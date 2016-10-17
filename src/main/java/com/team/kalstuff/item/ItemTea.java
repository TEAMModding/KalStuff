package com.team.kalstuff.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTea extends ItemDrink {

	public ItemTea(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);

	}
    
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	  {
	      super.onItemUseFinish(stack, worldIn, entityLiving);
	      return new ItemStack(KalStuffItems.coffee_mug);
	  }
}
