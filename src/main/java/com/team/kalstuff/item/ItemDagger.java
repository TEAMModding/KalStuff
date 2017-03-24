package com.team.kalstuff.item;

import com.google.common.collect.Multimap;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;

public class ItemDagger extends ItemSword {

    private float attackDamage;
    
	public ItemDagger(Item.ToolMaterial material) {
		super(material);
		this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.attackDamage = 1 + (material.getDamageVsEntity() / 2);
	}
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		  Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);

	        if (slot == EntityEquipmentSlot.MAINHAND)
	        {
	        	multimap.removeAll(SharedMonsterAttributes.ATTACK_DAMAGE.getName());
	        	multimap.removeAll(SharedMonsterAttributes.ATTACK_SPEED.getName());
	            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
	            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -1.2D, 0));
	        }

	        return multimap;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (target.getHorizontalFacing() == attacker.getHorizontalFacing()) target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 1 + (attackDamage * 2));
		return super.hitEntity(stack, target, attacker);
	}
}