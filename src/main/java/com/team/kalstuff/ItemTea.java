package com.team.kalstuff;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemTea extends ItemDrink {

    private boolean alwaysEdible;
	public ItemTea(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);

	}
    
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
	  {
	      super.onItemUseFinish(stack, worldIn, playerIn);
	      return new ItemStack(StartupCommon.itemCoffeeMug);
	  }
}
