package com.team.kalstuff.gui;

import java.util.ArrayList;
import java.util.List;

import com.team.KalStuff;
import com.team.kalstuff.config.Configs;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class KalStuffConfigGui extends GuiConfig {

	public KalStuffConfigGui(GuiScreen parent) {
		super(parent, getConfigElements(), KalStuff.MODID, false, false, getTitle());
	}
	
	private static List<IConfigElement> getConfigElements() {
		List<IConfigElement> configElements = new ArrayList<IConfigElement>();
		
		configElements.addAll(new ConfigElement(Configs.config.getCategory(Configs.CATEGORY_GENERIC)).getChildElements());
		
		return configElements;
	}
	
	private static String getTitle() {
		return GuiConfig.getAbridgedConfigPath(Configs.configurationFile.toString());
	}
	
}
