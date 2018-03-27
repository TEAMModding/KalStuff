package com.team.kalstuff.item;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class ItemCoffee extends ItemDrink {

	int potionLength = 0;

	/**
	 * 
	 * 
	 * @param potionLength
	 *            is the length of the speed effect the player gets upon
	 *            drinking.
	 */
	public ItemCoffee(int amount, float saturation, int potionLength, Potion potion, String name) {
		super(amount, saturation, potionLength, potion, name);
		this.setMaxStackSize(1);
		this.setReturnStack(new ItemStack(KalStuffItems.coffee_mug));
	}
}
