package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
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
		this.setCreativeTab(StartupCommon.KALSTUFF);
	}
	
	public ItemBlazeSoup(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);
	}
	
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
		if (!worldIn.isRemote)
		{
			player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 6000, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 6000, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 6000, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
		}
    }
    
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	  {
	      super.onItemUseFinish(stack, worldIn, entityLiving);
	      return new ItemStack(StartupCommon.golden_mug);
	  }
}
