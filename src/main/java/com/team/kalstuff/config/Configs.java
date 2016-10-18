package com.team.kalstuff.config;

import java.io.File;

import com.team.kalstuff.KalStuff;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Configs {
	
	public static int cottageRarity;
	public static boolean bridgeTNT;
	
	public static File configurationFile;
	public static Configuration config;
	
	public static final String CATEGORY_GENERIC = "Generic";
	
	@SubscribeEvent
	public void onConfigChangedEvent(OnConfigChangedEvent event) {
		
		if (KalStuff.MODID.equals(event.getModID())) {
			loadConfigs(config);
		}
	}
	
	public static void loadConfigsFromFile(File configFile) {
		configurationFile = configFile;
		config = new Configuration(configFile, null, false);
		config.load();
		
		loadConfigs(config);
	}
	
	public static void loadConfigs(Configuration conf) {
		Property prop;
		
		// Copy one of these blocks of code and change accordingly to add options to the config.
		prop = conf.get("Generic", "cottageGen", 500);
		prop.setComment("Rarity for cottage generation.");
		prop.setName("Cottage Rarity");
		cottageRarity = prop.getInt();
		
		prop = conf.get("Generic", "bridgeTNT", true);
		prop.setComment("Restricts bridge blocks from placing TNT.");
		prop.setName("Blacklist Bridge TNT");
		bridgeTNT = prop.getBoolean();
		
		
		if (conf.hasChanged() == true) conf.save();
	}
}
