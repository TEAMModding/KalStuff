package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemBaconWand extends Item {

	public ItemBaconWand() {
		this.setCreativeTab(StartupCommon.KALSTUFF);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase entity, EnumHand hand)
    {
		
		if (entity.worldObj.isRemote) return false;
		
		if (entity instanceof net.minecraft.entity.player.EntityPlayerMP) {
			EntityPlayerMP anEntity = (EntityPlayerMP) entity;
			anEntity.dropItem(false);
			
			//TODO: this is bound to change in an update
			//pseudocode: stack.setSize(stack.getSize() - 1);
			stack.func_190920_e(stack.func_190916_E() - 1);
			
			if (anEntity.canEat(false)) {
				anEntity.getFoodStats().addStats(5, 10.0F);
			}
			anEntity.worldObj.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, anEntity.worldObj.rand.nextFloat() * 0.1F + 0.9F);
			
		}
		return true;
		
	}

}
