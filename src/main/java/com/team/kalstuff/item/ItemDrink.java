package com.team.kalstuff.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

public class ItemDrink extends ItemKalStuff
{
	private int amount, potionLength = 0;
	private float saturation;
	private Potion potions[] = null;
	private ItemStack returnStack = ItemStack.EMPTY;

	public ItemDrink(int amount, float saturation, String name)
	{
		super(name);
		this.amount = amount;
		this.saturation = saturation;
	}

	public ItemDrink(int amount, float saturation, int potionLength, Potion potion, String name)
	{
		super(name);
		this.amount = amount;
		this.saturation = saturation;
		this.potionLength = potionLength;
		this.potions = new Potion[] { potion };
	}

	public ItemDrink(int amount, float saturation, int potionLength, Potion potions[], String name)
	{
		super(name);
		this.amount = amount;
		this.saturation = saturation;
		this.potionLength = potionLength;
		this.potions = potions;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.DRINK;
	}

	protected void addEffects(ItemStack stack, World worldIn, EntityPlayer player)
	{
		if (!worldIn.isRemote && this.potionLength != 0)
		{
			for (Potion p : this.potions)
			{
				try
				{
					player.addPotionEffect(new PotionEffect(p, ((this.potionLength / (this.getMaxDamage(stack) + 1))
							+ player.getActivePotionEffect(p).getDuration()), 0));
				} catch (NullPointerException e)
				{
					player.addPotionEffect(
							new PotionEffect(p, (this.potionLength / (this.getMaxDamage(stack) + 1)), 0));
				}

				if (player.getActivePotionEffect(p).getDuration() > 7200)
				{
					player.removePotionEffect(p);
					player.addPotionEffect(new PotionEffect(p, 7200, 0));
				}
			}
		}
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	{
		if (worldIn.isRemote)
			return stack;
		if (entityLiving instanceof EntityPlayer)
		{
			EntityPlayer entityplayer = (EntityPlayer) entityLiving;
			entityplayer.getFoodStats().addStats(this.amount, this.saturation);
			this.addEffects(stack, worldIn, entityplayer);
			entityplayer.addStat(StatList.getObjectUseStats(this));
		}
		EntityPlayer player = entityLiving instanceof EntityPlayer ? ((EntityPlayer) entityLiving) : null;
		if (!player.isCreative())
		{
			if (stack.getCount() <= 1)
				return this.getReturnStack();

			else
			{
				// this code should never run under normal circumstances
				ItemHandlerHelper.giveItemToPlayer(player, this.getReturnStack());
				stack.shrink(1);
			}
		}
		return stack;
	}

	public ItemDrink setReturnStack(ItemStack stack)
	{
		this.returnStack = stack;
		return this;
	}

	public ItemDrink setReturnStack(Item item)
	{
		this.returnStack = new ItemStack(item);
		return this;
	}

	public ItemStack getReturnStack()
	{
		return this.returnStack.copy();
	}

	public int getAmount()
	{
		return this.amount;
	}

	public float getSaturation()
	{
		return this.saturation;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 32;
	}
}
