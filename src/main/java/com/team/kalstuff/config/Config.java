package com.team.kalstuff.config;

import java.io.File;
import java.util.List;

import com.team.kalstuff.KalStuff;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config {
		
	public static File configurationFile;
	public static Configuration config;
	
	public static final String CATEGORY_GENERAL = "General";
	
	public static int cottageRarity = 512;
	public static boolean bridgeTNT = false;
	
	public static final void initialize(FMLPreInitializationEvent e, File file)
	{
		config = new Configuration(file, KalStuff.VERSION, true);
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		config.load();
		config.setCategoryRequiresWorldRestart(CATEGORY_GENERAL, false);
		config.setCategoryRequiresMcRestart(CATEGORY_GENERAL, false);
		config.setCategoryComment(CATEGORY_GENERAL, "General configuration");
		refresh();
		config.save();
	}
	public static final Configuration getConfig()
	{
		return config;
	}
	
	private static final void refresh()
	{
		cottageRarity = config.getInt("Cottage Rarity", CATEGORY_GENERAL, cottageRarity, 0, 16384, "Rarity for cottage generation");
		bridgeTNT = config.getBoolean("Allow Bridge TNT", CATEGORY_GENERAL, bridgeTNT, "Restricts bridge blocks from placing TNT");
	}
	
	public static void add(List<IConfigElement> list)
	{
		list.add(new ConfigElement(config.getCategory(CATEGORY_GENERAL)));
	}
	
	public static class EventHandler
	{
		@SubscribeEvent
		public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
		{
			if (event.getModID().equals(KalStuff.MODID))
			{
				refresh();
				if (config.hasChanged())
				{
					config.save();
				}
			}
		}
	}
}
