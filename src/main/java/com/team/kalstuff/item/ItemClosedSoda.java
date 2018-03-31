package com.team.kalstuff.item;

import java.util.List;

import com.team.kalstuff.KalStuffSoundEvents;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemClosedSoda extends ItemKalStuff
{
	private ItemStack returnStack = ItemStack.EMPTY;

	public ItemClosedSoda(String name)
	{
		super(name);
		this.setMaxStackSize(6);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		super.onItemRightClick(worldIn, playerIn, hand);
		worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, KalStuffSoundEvents.CAN_OPEN,
				SoundCategory.PLAYERS, 1.0F, 1.0F);

		ItemStack stack = playerIn.getHeldItem(hand);

		stack.shrink(1);

		if (stack.getCount() <= 0)
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, this.getReturnStack());
		playerIn.inventory.addItemStackToInventory(this.getReturnStack());

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}

	public ItemClosedSoda setReturnStack(ItemStack stack)
	{
		this.returnStack = stack;
		return this;
	}

	public ItemClosedSoda setReturnStack(Item item)
	{
		this.returnStack = new ItemStack(item);
		return this;
	}

	public ItemStack getReturnStack()
	{
		return this.returnStack;
	}

	@Override
	public void addInformation(ItemStack stack, World playerIn, List<String> tooltip, ITooltipFlag advanced)
	{
		tooltip.add("With bubbly endstone!");
	}
}
