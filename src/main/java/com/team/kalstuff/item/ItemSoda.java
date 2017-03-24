package com.team.kalstuff.item;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
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
		this.setAlwaysEdible();
		this.setCreativeTab(null);
	}
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		
		if (playerIn.canEat(this.alwaysEdible)) playerIn.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}
	
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		
		if (!worldIn.isRemote && this.length != 0) {
			try {
				player.addPotionEffect(new PotionEffect(this.effect, ((this.length / (this.getMaxDamage(stack) + 1)) + player.getActivePotionEffect(this.effect).getDuration()), 0));
			} catch (NullPointerException e) {
				player.addPotionEffect(new PotionEffect(this.effect, (this.length / (this.getMaxDamage(stack) + 1)), 0));
			}
			
			if (player.getActivePotionEffect(this.effect).getDuration() > 7200) {
				player.removePotionEffect(this.effect);
				player.addPotionEffect(new PotionEffect(this.effect, 7200, 0));
			}
		}
    }
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		
		if (worldIn.isRemote) return stack;
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
  	     }
		
		final EntityPlayer player = entityLiving instanceof EntityPlayer ? ((EntityPlayer) entityLiving) : null;
		
		
		if (!player.capabilities.isCreativeMode) {
			stack.damageItem(1, player);
		}
		if (!player.capabilities.isCreativeMode && stack.getCount() == 0) { //TODO: update this
			if (stack.getCount() <= 0) return new ItemStack(KalStuffItems.soda_can); //TODO: update this
			else player.inventory.addItemStackToInventory(new ItemStack(KalStuffItems.soda_can));
		}
		return stack;
	}
	
    /**
     * How long it takes to use or consume an item
     */
	@Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 5;
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("With bubbly endstone!");
	}
}
