package com.team.kalstuff.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBoxingGlove extends Item {
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		
		if (((EntityLivingBase) entity).getHealth() - 1.0F <= 0.0F) return true;
		else return false;
	}
	
}
