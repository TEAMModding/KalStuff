package com.team.kalstuff.item;

import com.team.kalstuff.proxy.CommonProxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemLute extends ItemKalStuff {
	
	public ItemLute(String name) {
		super(name);
		this.setCreativeTab(CommonProxy.KALSTUFF);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		
		worldIn.playSound(playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.BLOCK_NOTE_HARP, SoundCategory.AMBIENT, 1.0f, 1.0f, false);
		worldIn.spawnParticle(EnumParticleTypes.NOTE, playerIn.posX, playerIn.posY + 2.5f, playerIn.posZ, 24.0D, 0.0D, 0.0D, new int[0]);
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
