package com.team.kalstuff;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(	modid = KalStuff.MODID,
		name = KalStuff.NAME,
		version = KalStuff.VERSION,
		acceptedMinecraftVersions = "[1.11,1.12]",
		guiFactory = "com.team.kalstuff.KalStuffGuiFactory")
public class KalStuff  {
	
	public static final String MODID = "kalstuff";
	public static final String NAME = "KalStuff";
	public static final String VERSION = "0.7.2";
	
	//The instance of the mod that Forge uses.
	@Mod.Instance(KalStuff.MODID)
	public static KalStuff instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		com.team.kalstuff.StartupCommon.preInit(event, this);
		if (event.getSide().isClient()) com.team.kalstuff.StartupClientOnly.preInitClientOnly(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{	
		com.team.kalstuff.StartupCommon.init(event, this);
		if (event.getSide().isClient()) com.team.kalstuff.StartupClientOnly.initClientOnly(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{	
		com.team.kalstuff.StartupCommon.postInit(event, this);
		if (event.getSide().isClient()) com.team.kalstuff.StartupClientOnly.postInitClientOnly(event);
		
	}
}