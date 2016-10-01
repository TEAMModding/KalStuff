package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemWine extends ItemDrink {

	int potionLength = 0;

	/**
	 * 
	 * 
	 * @param potionLength
	 *            is the length of the speed effect the player gets upon
	 *            drinking.
	 */
	public ItemWine(int amount, float saturation, boolean isWolfFood, int potionLength) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);
		this.potionLength = potionLength;
	}

	public ItemWine(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);
	}

	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote && this.potionLength != 0) {
			player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, this.potionLength, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, this.potionLength, 0));
		}
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		super.onItemUseFinish(stack, worldIn, entityLiving);
		return new ItemStack(StartupCommon.wine_bottle);
	}
}
