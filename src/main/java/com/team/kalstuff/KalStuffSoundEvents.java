package com.team.kalstuff;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * Registers this mod's {@link SoundEvent}s.
 *
 * @author Kalman98 (who really just copied what Choonster did)
 */
@ObjectHolder(KalStuff.MODID)
public class KalStuffSoundEvents {

		@ObjectHolder("item.closed_soda.open")
		public static final SoundEvent CAN_OPEN = null;

		@Mod.EventBusSubscriber(modid = KalStuff.MODID)
		public static class RegistrationHandler {
			/**
			 * Register this mod's {@link SoundEvent}s.
			 *
			 * @param event The event
			 */
			@SubscribeEvent
			public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) {
				final SoundEvent[] soundEvents = {
						createSoundEvent("item.closed_soda.open")
				};

				event.getRegistry().registerAll(soundEvents);
			}

			/**
			 * Create a {@link SoundEvent}.
			 *
			 * @param soundName The SoundEvent's name without the testmod3 prefix
			 * @return The SoundEvent
			 */
			private static SoundEvent createSoundEvent(final String soundName) {
				final ResourceLocation soundID = new ResourceLocation(KalStuff.MODID, soundName);
				return new SoundEvent(soundID).setRegistryName(soundID);
			}
		}
}
