package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;
import com.team.kalstuff.item.ItemCoffee;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemLightCoffee extends ItemCoffee {

	public ItemLightCoffee(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);

	}
	
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
		if (!worldIn.isRemote)
		{
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 0));
		}
    }
    
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
	  {
	      super.onItemUseFinish(stack, worldIn, playerIn);
	      return new ItemStack(StartupCommon.itemCoffeeMug);
	  }
}
