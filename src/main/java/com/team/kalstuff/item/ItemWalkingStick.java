package com.team.kalstuff.item;

import com.google.common.collect.Multimap;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;

public class ItemWalkingStick extends Item
{
	private float attackDamage;
	public ItemWalkingStick() {
		this.attackDamage = 2.0f;
		this.maxStackSize = 1;
	}
	
    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public Multimap getItemAttributeModifiers()
    {
		Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", (double)this.attackDamage, 0));
        return multimap;
    }
}
