package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGrapeSoda extends ItemDrink {

	int potionLength = 0;
	
	
	public ItemGrapeSoda(int amount, float saturation, boolean isWolfFood, int potionLength) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);
		this.potionLength = potionLength;
	}
	
	public ItemGrapeSoda(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);
	}
	
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
		if (!worldIn.isRemote && this.potionLength != 0)
		{
			player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, this.potionLength, 0));
		}
    }
    
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
	  {
	      super.onItemUseFinish(stack, worldIn, playerIn);
	      return new ItemStack(StartupCommon.itemSodaCan);
	  }
}
