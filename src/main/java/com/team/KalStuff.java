package com.team;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(	modid = KalStuff.MODID,
		name = KalStuff.NAME,
		version = KalStuff.VERSION,
		acceptedMinecraftVersions = "[1.9.4, 1.11)",
		guiFactory = "com.team.kalstuff.KalStuffGuiFactory")
public class KalStuff 
{
	public static final String MODID = "kalstuff";
	public static final String NAME = "KalStuff";
	public static final String VERSION = "0.7.0";
	public static int cottageRarity;
	private static Configuration config;
	
	//The instance of your mod that Forge uses. Optional.
	@Mod.Instance(KalStuff.MODID)
	public static KalStuff instance;
	
	//Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="com.team.ClientOnlyProxy", serverSide="com.team.DedicatedServerProxy")
	public static CommonProxy proxy;
	
	public KalStuff()
	{
		config = null;
		File cfgFile = new File(Loader.instance().getConfigDir(), "kalstuff.cfg");
        config = new Configuration(cfgFile);
        syncConfig(true);
	}

	/**
	 * Reads the config, saves it, and is the blueprint for creating
	 * the config for the first time
	 * 
	 * @author Joseph
	 */
	public static void syncConfig(boolean load)
    {
		List<String> propOrder = new ArrayList<String>();
		
		if (!config.isChild)http://mcforge.readthedocs.io/en/latest/conventions/versioning/
        {
            if (load)
            {
                config.load();
            }
        }
        
        Property prop;
        
        //If you want to add new properties, copy this block and change the names
        prop = config.get(CATEGORY_GENERAL, "cottageGen", 500);
        prop.setComment("Rarity for cottage generation.");
        prop.setLanguageKey("kalstuff.configgui.cottageGen").setRequiresMcRestart(true);
        prop.setName("Cottage Rarity");
        cottageRarity = prop.getInt();
        propOrder.add(prop.getName());
        
        
        
        config.setCategoryPropertyOrder(CATEGORY_GENERAL, propOrder);
        
        if (config.hasChanged())
        {
            config.save();
        }
    }
	
	public static Configuration getConfig()
    {
        return config;
    }
	
	/**
	 * Called when the config needs to be saved from the config gui
	 * 
	 * @author Joseph
	 */
	@SubscribeEvent
    public void onConfigChanged(OnConfigChangedEvent event)
    {
		if (MODID.equals(event.getModID()) && !event.isWorldRunning())
        {
            if (Configuration.CATEGORY_GENERAL.equals(event.getConfigID()))
            {
                syncConfig(false);
            }
        }
    }
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(this);
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


