package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class ItemBlazeSoup extends ItemDrink {
	
	/**
     * 
     *  
     * @param potionLength is the length of the speed effect the player gets upon drinking.
     */
	public ItemBlazeSoup(int amount, float saturation, int potionLength, Potion[] potions)
	{
		super(amount, saturation, potionLength, potions);
		this.setMaxStackSize(1);
		this.setCreativeTab(StartupCommon.KALSTUFF);
		this.setReturnStack(new ItemStack(KalStuffItems.golden_mug));
	}

}
