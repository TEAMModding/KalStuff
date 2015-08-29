package com.team.kalstuff.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemClosedSoda extends Item {
	
	Item item;
	
	public ItemClosedSoda(Item item) {
		this.item = item;
		this.setMaxStackSize(6);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		super.onItemRightClick(itemStackIn, worldIn, playerIn);
		
		worldIn.playSoundAtEntity(playerIn, "kalstuff:item.closedSoda.open", 1.0f, 1.0f);
		--itemStackIn.stackSize;
        if (itemStackIn.stackSize <= 0) return new ItemStack(this.item);
        playerIn.inventory.addItemStackToInventory(new ItemStack(this.item));
        
		return itemStackIn;
	}
	
}
