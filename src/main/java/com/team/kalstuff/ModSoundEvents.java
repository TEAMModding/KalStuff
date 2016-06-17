package com.team.kalstuff;

import com.team.KalStuff;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSoundEvents {
	
	public static final SoundEvent CAN_OPEN;
	
	
	static {
		CAN_OPEN = registerSound("item.soda_can.open");
	}
	/**
	 * Register the {@link SoundEvent}s.
	 */
	public static void registerSounds() {
		// Dummy method to make sure the static initialiser runs
	}
	
	/**
	 * Register a {@link SoundEvent}.
	 *
	 * @param soundName The SoundEvent's name without the MODID prefix
	 * @return The SoundEvent
	 */
	private static SoundEvent registerSound(String soundName) {
		ResourceLocation location = new ResourceLocation(KalStuff.MODID, soundName);
		return GameRegistry.register(new SoundEvent(location), location);
	}
	
}
