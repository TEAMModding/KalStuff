package com.team.kalstuff.item;

import net.minecraft.potion.Potion;

public class ItemJewelSoup extends ItemDrink {
	
	int potionLength = 0;
	
	/**
	 * 
	 *  
	 * @param potionLength is the length of the speed effect the player gets upon drinking.
	 */
	public ItemJewelSoup(int amount, float saturation, int potionLength, Potion potions[]) {
		super(amount, saturation, potionLength, potions);
		this.setMaxStackSize(1);
		this.potionLength = potionLength;
	}
}
