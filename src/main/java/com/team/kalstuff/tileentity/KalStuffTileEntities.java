package com.team.kalstuff.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class KalStuffTileEntities {

	public static void register() {
		
		GameRegistry.registerTileEntity(TileEntityChickenNest.class, "ChickenNest");
    	GameRegistry.registerTileEntity(TileEntityMoonFlower.class, "MoonFlower");
	}
}
