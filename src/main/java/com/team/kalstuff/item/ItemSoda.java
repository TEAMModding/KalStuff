package com.team.kalstuff.item;

import java.util.List;
import java.util.Random;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

public class ItemSoda extends ItemDrink
{
	public ItemSoda(int amount, float saturation, int potionLength, Potion potion, String name)
	{
		super(amount, saturation, potionLength, potion, name);
		this.setMaxDamage(5);
		this.setMaxStackSize(1);
		this.setCreativeTab(null); // we don't want open sodas in the Creative inventory
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	{
		if (worldIn.isRemote)
			return stack;
		if (entityLiving instanceof EntityPlayer)
		{
			EntityPlayer entityplayer = (EntityPlayer) entityLiving;
			entityplayer.getFoodStats().addStats(this.getAmount(), this.getSaturation());
			this.addEffects(stack, worldIn, entityplayer);
			entityplayer.addStat(StatList.getObjectUseStats(this));
		}

		EntityPlayer player = entityLiving instanceof EntityPlayer ? ((EntityPlayer) entityLiving) : null;
		System.out.println(player);
		if (!player.capabilities.isCreativeMode)
		{
			// TODO the EntityPlayerMP argument may not work
			if (stack.attemptDamageItem(1, new Random(), (EntityPlayerMP) player))
			{
				if (stack.getCount() <= 1)
					return this.getReturnStack();
				else
				{
					// this code should never run under normal circumstances
					ItemHandlerHelper.giveItemToPlayer(player, this.getReturnStack());
					stack.shrink(1);
					stack.getItem().setDamage(stack, 0);
				}
			}
		}
		return stack;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 5;
	}

	@Override
	public void addInformation(ItemStack stack, World playerIn, List<String> tooltip, ITooltipFlag advanced)
	{
		tooltip.add("With bubbly endstone!");
	}
}
