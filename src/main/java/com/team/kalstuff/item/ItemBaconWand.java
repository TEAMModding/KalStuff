package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBaconWand extends Item {

	public ItemBaconWand() {
		this.setCreativeTab(StartupCommon.kalStuffTab);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		super.onItemRightClick(itemStackIn, worldIn, playerIn);
		return itemStackIn;
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase entity) {
		
		if (entity.worldObj.isRemote) return false;
		
		if (entity instanceof net.minecraft.entity.player.EntityPlayerMP) {
			EntityPlayerMP anEntity = (EntityPlayerMP) entity;
			anEntity.dropOneItem(false);
			stack.stackSize --;
			if (anEntity.canEat(false)) {
				anEntity.getFoodStats().addStats(5, 10.0F);
			}
			anEntity.worldObj.playSoundAtEntity(anEntity, "random.burp", 0.5F, anEntity.worldObj.rand.nextFloat() * 0.1F + 0.9F);
		}
		return true;
		
	}

}
