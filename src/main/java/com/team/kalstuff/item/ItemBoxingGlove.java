package com.team.kalstuff.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBoxingGlove extends ItemKalStuff
{
	public ItemBoxingGlove(String name)
	{
		super(name);
		this.setHasSubtypes(true);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		if (player.getEntityWorld().isRemote)
			return true;
		if (((EntityLivingBase) entity).getHealth() - 1.0 <= 0.0F)
		{
			((WorldServer) player.getEntityWorld()).spawnParticle(EnumParticleTypes.CRIT, entity.posX,
					entity.posY + (double) entity.height * 0.5D, entity.posZ, 100, 0.0D, 0.0D, 0.0D, 0.5D, new int[0]);

			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 200, 0, true, true));
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 9, true, true));
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 200, 128, true, true));

			return true;
		}
		return false;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		playerIn.swingArm(hand);
		return super.onItemRightClick(worldIn, playerIn, hand);
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target,
			EnumHand hand)
	{
		if (player.getEntityWorld().isRemote)
			return super.itemInteractionForEntity(stack, player, target, hand);

		player.setHeldItem(EnumHand.OFF_HAND, player.getHeldItemMainhand());
		player.setHeldItem(EnumHand.MAIN_HAND, stack);
		player.attackTargetEntityWithCurrentItem(target);
		player.setHeldItem(EnumHand.MAIN_HAND, player.getHeldItemOffhand());
		player.setHeldItem(EnumHand.OFF_HAND, stack);
		return true;
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye returns
	 * 16 items)
	 */
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
	{
		for (int i = 0; i < 16; ++i)
		{
			subItems.add(new ItemStack(itemIn, 1, i));
		}
	}
}
