package com.team.kalstuff.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.team.kalstuff.KalStuff;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class KalStuffGuiFactory implements IModGuiFactory
{
	@Override
	public void initialize(Minecraft minecraftInstance) {}

	@Override
	public boolean hasConfigGui()
	{
		return true;
	}

	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen)
	{
		return new ConfigGui(parentScreen);
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
	{
		return null;
	}

	public static class ConfigGui extends GuiConfig
	{
		public ConfigGui(GuiScreen parent)
		{
			super(parent, getList(), KalStuff.MODID, false, false, getTitle());
		}

		public static List<IConfigElement> getList()
		{
			List<IConfigElement> list = new ArrayList<IConfigElement>();
			Config.add(list);
			return list;
		}

		public static String getTitle()
		{
			return I18n.format("gui.kalstuff:main_config.name");
		}
	}
}
