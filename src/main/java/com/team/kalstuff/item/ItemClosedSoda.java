package com.team.kalstuff.item;

import com.team.kalstuff.ModSoundEvents;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemClosedSoda extends Item {
	
	Item item;
	
	public ItemClosedSoda(Item item) {
		this.item = item;
		this.setMaxStackSize(6);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
		
		//worldIn.playSoundAtEntity(playerIn, "kalstuff:item.closedSoda.open", 1.0f, 1.0f);
		worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, ModSoundEvents.CAN_OPEN, SoundCategory.PLAYERS, 1.0F, 1.0F);
		
		--itemStackIn.stackSize;
        if (itemStackIn.stackSize <= 0) return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, new ItemStack(this.item));
        playerIn.inventory.addItemStackToInventory(new ItemStack(this.item));
        
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}
	
}
