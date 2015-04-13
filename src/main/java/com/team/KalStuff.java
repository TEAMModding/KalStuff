package com.team;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = KalStuff.MODID, version = KalStuff.VERSION, guiFactory = "com.team.kalstuff.KalStuffGuiFactory")
public class KalStuff 
{
	public static final String MODID = "kalstuff";
	public static final String VERSION = "1.0";
	private static Configuration config;
	
	//The instance of your mod that Forge uses. Optional.
	@Mod.Instance(KalStuff.MODID)
	public static KalStuff instance;
	
	//Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="com.team.ClientOnlyProxy", serverSide="com.team.DedicatedServerProxy")
	public static CommonProxy proxy;
	
	public KalStuff()
	{
		System.out.println("KalStuff is being initialized");
		config = null;
		File cfgFile = new File(Loader.instance().getConfigDir(), "kalstuff.cfg");
        config = new Configuration(cfgFile);
        syncConfig(true);
	}

	private static void syncConfig(boolean load)
    {
        if (!config.isChild)
        {
            if (load)
            {
                config.load();
            }
        }
        
        Property prop;
        
        prop = config.get(CATEGORY_GENERAL, "test", true);
        prop.comment = "for testing this config file";
        prop.setLanguageKey("kalstuff.configgui.test");
        System.out.println("config value is: " + prop.getBoolean(true));
        
        if (config.hasChanged())
        {
            config.save();
        }
    }
	
	public static Configuration getConfig()
    {
        return config;
    }
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
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
}


