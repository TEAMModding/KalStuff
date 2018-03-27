package com.team.kalstuff.item;

import net.minecraft.item.ItemStack;

public class ItemTea extends ItemDrink {

	public ItemTea(int amount, float saturation, String name) {
		super(amount, saturation, name);
		this.setMaxStackSize(1);
		this.setReturnStack(new ItemStack(KalStuffItems.coffee_mug));
	}

}
