package com.team.kalstuff.item;

import com.team.kalstuff.KalStuff;
import com.team.kalstuff.StartupCommon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemChestNut extends Item {
	
    //private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>func_191197_a(1, ItemStack.field_190927_a);

	public ItemChestNut(int amount, float saturation, boolean isWolfFood) {
		//super(amount, saturation, isWolfFood);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		
		playerIn.openGui(KalStuff.instance, 1, worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ());
		StartupCommon.log.info("Yes, this method gets fired.");
		return super.onItemRightClick(worldIn, playerIn, hand);
	}

}