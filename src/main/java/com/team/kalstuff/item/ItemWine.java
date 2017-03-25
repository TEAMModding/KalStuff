package com.team.kalstuff.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class ItemWine extends ItemDrink {

	int potionLength = 0;

	/**
	 * 
	 * 
	 * @param potionLength
	 *            is the length of the speed effect the player gets upon
	 *            drinking.
	 */
	public ItemWine(int amount, float saturation, int potionLength, Potion potions[]) {
		super(amount, saturation, potionLength, potions);
		this.setMaxStackSize(1);
		this.setReturnStack(new ItemStack(KalStuffItems.wine));
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("Wine is just messed up.");
	}
}
