package com.team.kalstuff;

import com.team.kalstuff.config.Configs;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;


@Mod(	modid = KalStuff.MODID,
		name = KalStuff.NAME,
		version = KalStuff.VERSION,
		acceptedMinecraftVersions = "[1.9.4, 1.11)",
		guiFactory = "com.team.kalstuff.KalStuffGuiFactory")
public class KalStuff  {
	
	public static final String MODID = "kalstuff";
	public static final String NAME = "KalStuff";
	public static final String VERSION = "0.7.2";
	
	//The instance of the mod that Forge uses.
	@Mod.Instance(KalStuff.MODID)
	public static KalStuff instance;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		Configs.loadConfigsFromFile(event.getSuggestedConfigurationFile());
		
		FMLCommonHandler.instance().bus().register(this);
		
		MinecraftForge.EVENT_BUS.register(new Configs());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		com.team.kalstuff.StartupCommon.preInit();
		if (event.getSide().isClient()) com.team.kalstuff.StartupClientOnly.preInitClientOnly();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		com.team.kalstuff.StartupCommon.init();
		if (event.getSide().isClient()) com.team.kalstuff.StartupClientOnly.initClientOnly();
	}
	
	@EventHandler
	public void init(FMLServerStartingEvent event) {
		
		com.team.kalstuff.StartupCommon.postInit();
		if (event.getSide().isClient()) com.team.kalstuff.StartupClientOnly.postInitClientOnly();
		
		//event.registerServerCommand(new CommandWorldGenBuild());
	}
}