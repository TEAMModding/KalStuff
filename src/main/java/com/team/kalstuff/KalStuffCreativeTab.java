package com.team.kalstuff;

import com.team.kalstuff.block.KalStuffBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KalStuffCreativeTab extends CreativeTabs {

	public KalStuffCreativeTab(String tabLabel) {
		super(tabLabel);	
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		
		return new ItemStack(Item.getItemFromBlock(KalStuffBlocks.bridge));
	}
}