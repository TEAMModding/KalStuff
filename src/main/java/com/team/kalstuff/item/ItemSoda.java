package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;

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
	}
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		if (playerIn.canEat(this.alwaysEdible)) playerIn.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}
	
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {   
		if (!worldIn.isRemote && this.length != 0)
		{
			try{
				player.addPotionEffect(new PotionEffect(this.effect, ((this.length / (this.getMaxDamage() + 1)) + player.getActivePotionEffect(this.effect).getDuration()), 0));
			}catch (NullPointerException e) {player.addPotionEffect(new PotionEffect(this.effect, (this.length / (this.getMaxDamage() + 1)), 0));}
			if (player.getActivePotionEffect(this.effect).getDuration() > 7200) {
				player.removePotionEffect(this.effect);
				player.addPotionEffect(new PotionEffect(this.effect, 7200, 0));
			}
		}
    }
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        if (worldIn.isRemote) return stack;
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
        }
        
	      final EntityPlayer player = entityLiving instanceof EntityPlayer ? ((EntityPlayer) entityLiving) : null;
	      
	      
          if (!player.capabilities.isCreativeMode) {
        	  stack.damageItem(1, player);
        	  System.out.println("Oh it got hurt.");
          }
	      System.out.println(stack.getItemDamage() + ", " + stack.getMaxDamage());
          if (!player.capabilities.isCreativeMode && stack.stackSize == 0) {
        	  System.out.print("Yipee!");
	            if (stack.stackSize <= 0) return new ItemStack(StartupCommon.itemSodaCan);
	            else player.inventory.addItemStackToInventory(new ItemStack(StartupCommon.itemSodaCan));
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
}
