package com.team.kalstuff;

import java.util.Set;

import com.team.kalstuff.gui.KalStuffConfigGui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

/**
 * this is the class that gives forge the blueprints for it's config gui
 * @author Joseph
 *
 */
public class KalStuffGuiFactory implements IModGuiFactory 
{
	@Override
    public void initialize(Minecraft minecraftInstance) {}
	
	@Override
    public Class<? extends GuiScreen> mainConfigGuiClass() { return KalStuffConfigGui.class; }
	
	@Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() { return null; }

    @SuppressWarnings("deprecation")
	@Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) { return null; }
}
