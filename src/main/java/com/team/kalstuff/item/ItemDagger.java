package com.team.kalstuff.item;

import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDagger extends ItemKalStuff
{
	private final float attackDamage;
	private final Item.ToolMaterial material;

	public ItemDagger(Item.ToolMaterial material, String name)
	{
		super(name);
		this.material = material;
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		this.attackDamage = 1.0F + material.getDamageVsEntity();
	}

	/**
	 * Returns the amount of damage this item will deal. One heart of damage is
	 * equal to 2 damage points.
	 */
	public float getDamageVsEntity()
	{
		return this.attackDamage;
	}

	public float getStrVsBlock(ItemStack stack, IBlockState state)
	{
		Block block = state.getBlock();

		if (block == Blocks.WEB)
		{
			return 15.0F;
		} else
		{
			Material material = state.getMaterial();
			return material != Material.PLANTS && material != Material.VINE && material != Material.CORAL
					&& material != Material.LEAVES && material != Material.GOURD ? 1.0F : 1.5F;
		}
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	{
		// checking if the attacker is facing with 45 degrees in either direction of the
		// target's yaw
		if (areEntitiesFacingSameWay(target, attacker))
		{
			// we get the damage the dagger will do, including enchantments and the +1
			// damage every item gets. Also note that doing damage here will completely
			// remove damage done in EntityPlayer#attackTargetEntityWithCurrentItem(Entity),
			// due to the way Minecraft handles simultaneous damage sources (the stronger
			// source wins). Thus we double the damage here to make up for that.
			float f = 2.5F * (1.0F + this.attackDamage
					+ EnchantmentHelper.getModifierForCreature(stack, target.getCreatureAttribute()));
			target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), f);
		}
		stack.damageItem(1, attacker);
		return true;
	}

	public boolean areEntitiesFacingSameWay(EntityLivingBase entity1, EntityLivingBase entity2)
	{
		float temp, yawLowerBound, yawUpperBound, yaw1, yaw2;
		boolean wrapped = false;
		// Minecraft has a weird yaw system where rotating in a certain direction enough
		// times will cause your yaw to go negative, but with the same absolute value.
		// We must get the absolute values here to ensure the math never gets broken by
		// this.
		yaw1 = Math.abs(entity1.getRotationYawHead());
		yaw2 = Math.abs(entity2.getRotationYawHead());

		temp = yaw1 - 45;
		if (temp < 0)
		{
			yawLowerBound = 360 + temp; // subtract the difference from 360 to loop back around 360
			wrapped = true;
		} else
			yawLowerBound = temp;

		temp = yaw1 + 45;
		if (temp > 360)
		{
			yawUpperBound = temp - 360; // find the difference from 360 to loop back around 0
			wrapped = true;
		} else
			yawUpperBound = temp;

		if ((!wrapped && (yaw2 > yawLowerBound && yaw2 < yawUpperBound))
				|| ((wrapped && (yaw2 > yawLowerBound || yaw2 < yawUpperBound))))
		{
			return true;
		}
		return false;
	}

	/**
	 * Called when a Block is destroyed using this Item. Return true to trigger the
	 * "Use Item" statistic.
	 */
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos,
			EntityLivingBase entityLiving)
	{
		if ((double) state.getBlockHardness(worldIn, pos) != 0.0D)
		{
			stack.damageItem(2, entityLiving);
		}

		return true;
	}

	/**
	 * Check whether this Item can harvest the given Block
	 */
	public boolean canHarvestBlock(IBlockState blockIn)
	{
		return blockIn.getBlock() == Blocks.WEB;
	}

	/**
	 * Returns True is the item is rendered in full 3D when held.
	 */
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based on
	 * material.
	 */
	public int getItemEnchantability()
	{
		return this.material.getEnchantability();
	}

	/**
	 * Return the name for this tool's material.
	 */
	public String getToolMaterialName()
	{
		return this.material.toString();
	}

	/**
	 * Return whether this item is reparable in an anvil.
	 */
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		ItemStack mat = this.material.getRepairItemStack();
		if (!mat.isEmpty() && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false))
			return true;
		return super.getIsRepairable(toRepair, repair);
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack)
	{
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

		if (slot == EntityEquipmentSlot.MAINHAND)
		{
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
					new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.attackDamage, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
					new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -1.2D, 0));
		}
		return multimap;
	}
}