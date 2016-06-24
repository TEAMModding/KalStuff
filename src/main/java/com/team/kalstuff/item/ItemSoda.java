package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSoda extends ItemDrink {

	int length;
	Potion effect;
	public ItemSoda(int amount, float saturation, boolean isWolfFood, int potionLength, Potion potion) {
		super(amount, saturation, isWolfFood);
		this.length = potionLength;
		this.effect = potion;
		this.setMaxDamage(5);
		this.setMaxStackSize(1);
	}
	
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote && this.length != 0) {
			player.addPotionEffect(new PotionEffect(effect, length, 0));
		}
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		super.onItemUseFinish(stack, worldIn, entityLiving);
		return new ItemStack(StartupCommon.itemSodaCan);
	}
}
