package com.team;

import com.team.kalstuff.config.Configs;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(	modid = KalStuff.MODID,
		name = KalStuff.NAME,
		version = KalStuff.VERSION,
		acceptedMinecraftVersions = "[1.9.4, 1.11)",
		guiFactory = "com.team.kalstuff.KalStuffGuiFactory")
public class KalStuff 
{
	public static final String MODID = "kalstuff";
	public static final String NAME = "KalStuff";
	public static final String VERSION = "0.7.2";
	
	//The instance of the mod that Forge uses.
	@Mod.Instance(KalStuff.MODID)
	public static KalStuff instance;
	
	//Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="com.team.ClientOnlyProxy", serverSide="com.team.DedicatedServerProxy")
	public static CommonProxy proxy;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configs.loadConfigsFromFile(event.getSuggestedConfigurationFile());
		
		FMLCommonHandler.instance().bus().register(this);
		
		MinecraftForge.EVENT_BUS.register(new Configs());
		proxy.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit();
	}
	
	@EventHandler
	public void init(FMLServerStartingEvent event)
	{
		//event.registerServerCommand(new CommandWorldGenBuild());
	}
}


