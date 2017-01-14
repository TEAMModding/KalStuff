
package com.team.kalstuff;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.team.kalstuff.block.KalStuffBlocks;
import com.team.kalstuff.entity.KalStuffEntities;
import com.team.kalstuff.item.KalStuffItems;
import com.team.kalstuff.tileentity.KalStuffTileEntities;
import com.team.kalstuff.worldgen.KalStuffWorldGenerator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class StartupCommon {
	
	public static final CreativeTabs KALSTUFF = new KalStuffCreativeTab("kalstuffTab");
	public static final Logger log = LogManager.getLogger(KalStuff.MODID);

	public static void preInit() {
		
		KalStuffSoundEvents.registerSounds();
		KalStuffBlocks.setup();
		KalStuffItems.setup();
		KalStuffTileEntities.register();
		KalStuffWorldGenerator.register();
		KalStuffEntities.setup();
		NetworkRegistry.INSTANCE.registerGuiHandler(KalStuff.instance, new KalStuffGuiHandler());
	}

	public static void init() {

		log.info("Hi there, nerdy geeks. You should just enjoy Minecraft and stop looking at the system output.");
		
		KalStuffRecipes.add();
		CoreEventHandler events = new CoreEventHandler();
		MinecraftForge.EVENT_BUS.register(events);
	}

	public static void postInit() {
		
		log.info("Wait a minute... Guys! IT WORKS!?! WE MADE A MOD!!!");
	}
}