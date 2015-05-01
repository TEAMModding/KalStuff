package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBlazeSoup extends ItemDrink {

	int potionLength = 0;
	
	/**
     * 
     *  
     * @param potionLength is the length of the speed effect the player gets upon drinking.
     */
	public ItemBlazeSoup(int amount, float saturation, boolean isWolfFood, int potionLength) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);
		this.potionLength = potionLength;
		this.setCreativeTab(StartupCommon.kalStuffTab);
	}
	
	public ItemBlazeSoup(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);
	}
	
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
		if (!worldIn.isRemote)
		{
			player.addPotionEffect(new PotionEffect(Potion.absorption.id, 6000, 0));
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 6000, 0));
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 6000, 0));
			player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
		}
    }
    
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
	  {
	      super.onItemUseFinish(stack, worldIn, playerIn);
	      return new ItemStack(StartupCommon.itemGoldenMug);
	  }
}
