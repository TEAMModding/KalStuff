package com.team.kalstuff;

import com.team.kalstuff.item.ItemDagger;
import com.team.kalstuff.item.KalStuffItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CoreEventHandler
{
	@SubscribeEvent
	public void onUpdateEvent(LivingUpdateEvent event)
	{
		EntityLivingBase living = event.getEntityLiving();
		if (living.getHeldItem(EnumHand.MAIN_HAND) != null
				&& living.getHeldItem(EnumHand.MAIN_HAND).getItem() == KalStuffItems.WALKING_STICK)
			event.getEntityLiving().stepHeight = 1F;

		else if (living.getHeldItem(EnumHand.OFF_HAND) != null
				&& living.getHeldItem(EnumHand.OFF_HAND).getItem() == KalStuffItems.WALKING_STICK)
			event.getEntityLiving().stepHeight = 1F;

		else
			event.getEntityLiving().stepHeight = 0.6F;
	}

	@SubscribeEvent
	public void onBlockClicked(LeftClickBlock event)
	{
		if (event.getEntityPlayer().isCreative())
			if (event.getEntityPlayer().getHeldItemMainhand().getItem() instanceof ItemDagger)
				event.setCanceled(true);

	}
}