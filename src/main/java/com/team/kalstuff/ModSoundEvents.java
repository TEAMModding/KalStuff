package com.team.kalstuff;

import com.team.KalStuff;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSoundEvents {
	
	public static SoundEvent item_soda_can_open;
	
	/**
	 * Register the {@link SoundEvent}s.
	 */
	public static void registerSounds() {
		item_soda_can_open = registerSound("item.soda_can.open");
	}
	
	/**
	 * Register a {@link SoundEvent}.
	 *
	 * @param soundName The SoundEvent's name without the testmod3 prefix
	 * @return The SoundEvent
	 */
	private static SoundEvent registerSound(String soundName) {
		ResourceLocation soundID = new ResourceLocation(KalStuff.MODID, soundName);
		SoundEvent event = new SoundEvent(soundID);
		GameRegistry.register(event, soundID);
		return event;
	}
	
}
