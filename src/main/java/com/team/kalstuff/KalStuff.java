package com.team.kalstuff;

import org.apache.logging.log4j.Logger;

import com.team.kalstuff.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(	modid = KalStuff.MODID,
		name = KalStuff.NAME,
		version = KalStuff.VERSION,
		acceptedMinecraftVersions = "[1.12.2]",
		useMetadata = true,
		guiFactory = "com.team.kalstuff.config.KalStuffGuiFactory")
public class KalStuff  {
	
	public static final String MODID = "kalstuff";
	public static final String NAME = "KalStuff";
	public static final String VERSION = "0.7.2";
	
	@SidedProxy(clientSide = "com.team.kalstuff.proxy.ClientProxy",
				serverSide = "com.team.kalstuff.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	//The instance of the mod that Forge uses.
	@Mod.Instance
	public static KalStuff instance;

	public static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		logger = e.getModLog();
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{	
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{	
		proxy.postInit(e);
	}
}