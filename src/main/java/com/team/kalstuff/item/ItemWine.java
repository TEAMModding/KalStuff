package com.team.kalstuff.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class ItemWine extends ItemDrink
{
	int potionLength = 0;

	/**
	 * 
	 * 
	 * @param potionLength
	 *            is the length of the speed effect the player gets upon drinking.
	 */
	public ItemWine(int amount, float saturation, int potionLength, String name)
	{
		super(amount, saturation, potionLength, new Potion[] { MobEffects.NAUSEA, MobEffects.BLINDNESS }, name);
		this.setMaxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack stack, World playerIn, List<String> tooltip, ITooltipFlag advanced)
	{
		tooltip.add("Wine is just messed up.");
	}
}
