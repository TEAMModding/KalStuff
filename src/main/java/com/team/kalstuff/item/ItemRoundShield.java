package com.team.kalstuff.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;

public class ItemRoundShield extends ItemShield {
	
	public ItemRoundShield(Item.ToolMaterial material, String name) {
		ItemKalStuff.setupItem(this, name);
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		
	}
	
	
	
	
	
	
	
}
	

