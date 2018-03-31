package com.team.kalstuff.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemBaconWand extends ItemKalStuff
{
	public ItemBaconWand(String name)
	{
		super(name);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		playerIn.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase entity,
			EnumHand hand)
	{
		if (entity.world.isRemote)
			return false;
		if (entity instanceof net.minecraft.entity.player.EntityPlayerMP)
		{
			EntityPlayerMP anEntity = (EntityPlayerMP) entity;
			anEntity.dropItem(false);
			stack.shrink(1);
			if (anEntity.canEat(false))
			{
				anEntity.getFoodStats().addStats(5, 10.0F);
			}
			anEntity.world.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_PLAYER_BURP,
					SoundCategory.PLAYERS, 0.5F, anEntity.world.rand.nextFloat() * 0.1F + 0.9F);
		}
		return true;
	}
}
