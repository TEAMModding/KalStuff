package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;

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
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if (playerIn.canEat(this.alwaysEdible)) playerIn.setItemInUse(itemStackIn, 5);
        return itemStackIn;
    }
	
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
		if (!worldIn.isRemote && this.length != 0)
		{
			try{
				player.addPotionEffect(new PotionEffect(this.effect.id, ((this.length / (this.getMaxDamage() + 1)) + player.getActivePotionEffect(this.effect).getDuration()), 0));
			}catch (NullPointerException e) {player.addPotionEffect(new PotionEffect(this.effect.id, (this.length / (this.getMaxDamage() + 1)), 0));}
			if (player.getActivePotionEffect(this.effect).getDuration() > 7200) {
				player.removePotionEffect(this.effect.id);
				player.addPotionEffect(new PotionEffect(this.effect.id, 7200, 0));
			}
		}
	      stack.damageItem(1, player);
    }
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn) {
	      super.onItemUseFinish(stack, worldIn, playerIn);

	        if (!playerIn.capabilities.isCreativeMode && stack.getItemDamage() <= 0) {
	            --stack.stackSize;
	            if (stack.stackSize <= 0) return new ItemStack(StartupCommon.itemSodaCan);
	            playerIn.inventory.addItemStackToInventory(new ItemStack(StartupCommon.itemSodaCan));
	        }
	        if (stack.getItemDamage() > 0) stack.stackSize ++;
	      return stack;
	  }
}
