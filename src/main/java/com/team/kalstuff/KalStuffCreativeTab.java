package com.team.kalstuff;

import com.team.kalstuff.item.KalStuffItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KalStuffCreativeTab extends CreativeTabs
{

	public KalStuffCreativeTab(String tabLabel)
	{
		super(tabLabel);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem()
	{
		return new ItemStack(KalStuffItems.TEA);
	}
}