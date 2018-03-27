
package com.team.kalstuff;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.team.kalstuff.config.Configs;
import com.team.kalstuff.entity.KalStuffEntities;
import com.team.kalstuff.tileentity.KalStuffTileEntities;
import com.team.kalstuff.worldgen.KalStuffWorldGenerator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class StartupCommon {
	
	public static final CreativeTabs KALSTUFF = new KalStuffCreativeTab("kalstuffTab");
	public static final Logger log = LogManager.getLogger(KalStuff.MODID);

	public static void preInit(FMLPreInitializationEvent event, KalStuff ks)
	{	
		Configs.loadConfigsFromFile(event.getSuggestedConfigurationFile());
		
		//MinecraftForge.EVENT_BUS.register(ks);
		MinecraftForge.EVENT_BUS.register(new Configs());
		MinecraftForge.EVENT_BUS.register(new CoreEventHandler());
		KalStuffTileEntities.register();
		KalStuffWorldGenerator.register();
		KalStuffEntities.setup();
		NetworkRegistry.INSTANCE.registerGuiHandler(KalStuff.instance, new KalStuffGuiHandler());
	}

	public static void init(FMLInitializationEvent event, KalStuff ks)
	{
		log.info("Hi there, nerdy geeks. You should just enjoy Minecraft and stop looking at the system output.");
		
		KalStuffRecipes.add();
	}

	public static void postInit(FMLPostInitializationEvent event, KalStuff ks)
	{	
		log.info("Wait a minute... Guys! IT WORKS!?! WE MADE A MOD!!!");
	}
}