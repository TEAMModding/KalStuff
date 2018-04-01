package com.team.kalstuff.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
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
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer entityplayer, EntityLivingBase target,
			EnumHand hand)
	{
		if (entityplayer.getEntityWorld().isRemote)
			return super.itemInteractionForEntity(stack, entityplayer, target, hand);
		entityplayer.swingArm(hand);
		
		if (((EntityLivingBase) target).getHealth() - 1.0 <= 0.0F)
		{
			((WorldServer) entityplayer.getEntityWorld()).spawnParticle(EnumParticleTypes.CRIT, target.posX,
					target.posY + (double) target.height * 0.5D, target.posZ, 100, 0.0D, 0.0D, 0.0D, 0.5D, new int[0]);

			((EntityLivingBase) target).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 200, 0, true, true));
			((EntityLivingBase) target).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 9, true, true));

			((EntityLivingBase) target).addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 200, 128, true, true));
			return super.itemInteractionForEntity(stack, entityplayer, target, hand);
		}
        entityplayer.getEntityWorld().playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, entityplayer.getSoundCategory(), 1.0F, 1.0F);
		target.attackEntityFrom(DamageSource.causePlayerDamage(entityplayer), 1.0F);
		return super.itemInteractionForEntity(stack, entityplayer, target, hand);
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
