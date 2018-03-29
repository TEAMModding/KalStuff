package com.team.kalstuff.tileentity;

import com.team.kalstuff.KalStuff;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class KalStuffTileEntities {

	public static void register() {
		
		GameRegistry.registerTileEntity(TileEntityChickenNest.class, KalStuff.MODID + ":chicken_nest");
    	GameRegistry.registerTileEntity(TileEntityMoonFlower.class, KalStuff.MODID + ":moon_flower");
	}
}
