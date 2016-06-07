package com.team.kalstuff;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CoreEventHandler 
{
	@SubscribeEvent
	public void onUpdateEvent(LivingUpdateEvent event)
	{
		EntityLivingBase living = event.getEntityLiving();
		if (living.getHeldItem(EnumHand.MAIN_HAND)!= null && living.getHeldItem(EnumHand.MAIN_HAND).getItem() == StartupCommon.itemWalkingStick)
		{
			event.getEntityLiving().stepHeight = 1F;
		}
		else if (living.getHeldItem(EnumHand.OFF_HAND)!= null && living.getHeldItem(EnumHand.OFF_HAND).getItem() == StartupCommon.itemWalkingStick)
		{
			event.getEntityLiving().stepHeight = 1F;
		}
		else
			event.getEntityLiving().stepHeight = 0.6F;
	}
}
