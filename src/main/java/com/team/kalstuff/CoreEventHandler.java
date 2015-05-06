package com.team.kalstuff;

import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CoreEventHandler 
{
	@SubscribeEvent
	public void onUpdateEvent(LivingUpdateEvent event)
	{
		if (event.entityLiving.getHeldItem()!= null)
		{
			if (event.entityLiving.getHeldItem().getItem() == StartupCommon.itemWalkingStick)
			{
				event.entityLiving.stepHeight = 1F;
			}
			else
				event.entityLiving.stepHeight = 0.6F;
		}
		else
			event.entityLiving.stepHeight = 0.6F;
	}
}
