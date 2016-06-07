package com.team.kalstuff.item;

import net.minecraft.item.Item;

public class ItemWalkingStick extends Item
{
	private float attackDamage;
	public ItemWalkingStick() {
		this.attackDamage = 2.0f;
		this.maxStackSize = 1;
	}
}
