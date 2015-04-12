package com.team.kalstuff;

import java.util.Set;

import com.team.KalStuff;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;

public class KalStuffGuiFactory implements IModGuiFactory 
{
	@Override
    public void initialize(Minecraft minecraftInstance) {}
	
	@Override
    public Class<? extends GuiScreen> mainConfigGuiClass() { return KalStuffConfigGui.class; }
	
	@Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() { return null; }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) { return null; }
    
    public static class KalStuffConfigGui extends GuiConfig
    {
    	public KalStuffConfigGui(GuiScreen parentScreen)
        {
    		super(parentScreen, (new ConfigElement(KalStuff.getConfig().getCategory(Configuration.CATEGORY_GENERAL))).getChildElements(), "KalStuff", false, false, I18n.format("kalstuff.configgui.configTitle"));
        }
    }
}
