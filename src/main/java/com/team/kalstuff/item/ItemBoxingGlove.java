package com.team.kalstuff.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.WorldServer;

public class ItemBoxingGlove extends Item {
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		
		
		if (player.getEntityWorld().isRemote) return true;
		
		if (((EntityLivingBase) entity).getHealth() - 1.0 <= 0.0F) {

            ((WorldServer)player.getEntityWorld()).spawnParticle(EnumParticleTypes.CRIT, entity.posX, entity.posY + (double)entity.height * 0.5D, entity.posZ, 100, 0.0D, 0.0D, 0.0D, 0.5D, new int[0]);

			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 200, 0, true, true));
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 9, true, true));
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 200, 128, true, true));

			return true;
		}
		
		return false;
	}	
}
