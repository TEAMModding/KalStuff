package com.team.kalstuff.worldgen;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class KalStuffWorldGenerator {

	public static void register() {
		
    	GameRegistry.registerWorldGenerator(new WorldGenGrapeVine(), 1);
    	GameRegistry.registerWorldGenerator(new WorldGenMoonFlower(), 1);
	}
}
