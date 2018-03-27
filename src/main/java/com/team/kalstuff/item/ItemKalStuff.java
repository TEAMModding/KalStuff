package com.team.kalstuff.item;

import com.team.kalstuff.KalStuff;
import com.team.kalstuff.StartupCommon;

import net.minecraft.item.Item;

public class ItemKalStuff extends Item {
	
	public ItemKalStuff(String name) {
		setupItem(this, name);
	}
	
	
	public static Item setupItem(Item item, String name) {
		item.setRegistryName(name);
		item.setUnlocalizedName(KalStuff.MODID + ":" + name);
		item.setCreativeTab(StartupCommon.KALSTUFF);
		return item;
	}
}
