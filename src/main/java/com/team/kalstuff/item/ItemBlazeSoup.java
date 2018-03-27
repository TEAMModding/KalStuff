package com.team.kalstuff.item;

import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class ItemBlazeSoup extends ItemDrink {
	
	/**
     * 
     *  
     * @param potionLength is the length of the speed effect the player gets upon drinking.
     */
	public ItemBlazeSoup(int amount, float saturation, int potionLength, String name)
	{
		super(amount, saturation, potionLength, new Potion[] {MobEffects.ABSORPTION, MobEffects.NIGHT_VISION, MobEffects.STRENGTH, MobEffects.FIRE_RESISTANCE}, name);
		this.setMaxStackSize(1);
		this.setReturnStack(new ItemStack(KalStuffItems.golden_mug));
	}

}
