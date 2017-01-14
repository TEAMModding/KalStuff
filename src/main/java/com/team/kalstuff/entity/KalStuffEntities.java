package com.team.kalstuff.entity;

import com.team.kalstuff.KalStuff;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class KalStuffEntities {

	/**
	 * Initializes and registers all entities from the mod.
	 */
	public static void setup() {
		
		registerEntities();
	}
	
	
	public static void registerEntities() {
		registerEntity(EntityDuck.class, "duck", 80, 3, true, 0x0DA70B, 0x101010);
	}
	
	
	//bits of this code were borrowed from Choonster because he wrote it very neatly! https://github.com/Choonster/TestMod3/blob/a6e5f7c223a18e4a53732af49aac6ac1bb52cc6f/src/main/java/choonster/testmod3/init/ModEntities.java
	private static int entityID = 0;
	
	/**
	 * Register an entity with the specified tracking values.
	 *
	 * @param entityClass          The entity's class
	 * @param entityName           The entity's unique name
	 * @param trackingRange        The range at which MC will send tracking updates
	 * @param updateFrequency      The frequency of tracking updates
	 * @param sendsVelocityUpdates Whether to send velocity information packets as well
	 */
	@SuppressWarnings("unused")
	private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		final ResourceLocation registryName = new ResourceLocation(KalStuff.MODID, entityName);
		EntityRegistry.registerModEntity(registryName, entityClass, registryName.toString(), entityID++, KalStuff.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}

	/**
	 * Register an entity with the specified tracking values and spawn egg colours.
	 *
	 * @param entityClass          The entity's class
	 * @param entityName           The entity's unique name
	 * @param trackingRange        The range at which MC will send tracking updates
	 * @param updateFrequency      The frequency of tracking updates
	 * @param sendsVelocityUpdates Whether to send velocity information packets as well
	 * @param eggPrimary           The spawn egg's primary (background) colour
	 * @param eggSecondary         The spawn egg's secondary (foreground) colour
	 */
	private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int eggPrimary, int eggSecondary) {
		final ResourceLocation registryName = new ResourceLocation(KalStuff.MODID, entityName);
		EntityRegistry.registerModEntity(registryName, entityClass, registryName.toString(), entityID++, KalStuff.instance, trackingRange, updateFrequency, sendsVelocityUpdates, eggPrimary, eggSecondary);
}
}
