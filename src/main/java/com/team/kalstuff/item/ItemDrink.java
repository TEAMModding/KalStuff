package com.team.kalstuff.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemDrink extends ItemFood {

	protected boolean alwaysEdible;

	public ItemDrink(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
	}

	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		playerIn.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}

	public ItemFood setAlwaysEdible() {
		this.alwaysEdible = true;
		return this;
	}

	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}
}
