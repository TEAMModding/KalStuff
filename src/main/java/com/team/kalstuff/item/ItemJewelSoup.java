package com.team.kalstuff.item;

import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;

public class ItemJewelSoup extends ItemDrink {
	
	int potionLength = 0;
	
	/**
	 * 
	 *  
	 * @param potionLength is the length of the speed effect the player gets upon drinking.
	 */
	public ItemJewelSoup(int amount, float saturation, int potionLength, String name) {
		super(amount, saturation, potionLength, new Potion[] {MobEffects.SPEED, MobEffects.REGENERATION}, name);
		this.setMaxStackSize(1);
	}
}
