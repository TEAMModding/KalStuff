package com.team.kalstuff;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class KalStuffCreativeTab extends CreativeTabs {

public KalStuffCreativeTab(String tabLabel)
{
super(tabLabel);
}

@Override
@SideOnly(Side.CLIENT)
public Item getTabIconItem()
{
//return Item.getItemFromBlock(StartupCommon.blockBridge);
	return Items.REDSTONE;
}

}