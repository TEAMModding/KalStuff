
package com.team.kalstuff.proxy;

import com.team.kalstuff.CoreEventHandler;
import com.team.kalstuff.KalStuff;
import com.team.kalstuff.KalStuffCreativeTab;
import com.team.kalstuff.KalStuffGuiHandler;
import com.team.kalstuff.KalStuffRecipes;
import com.team.kalstuff.entity.KalStuffEntities;
import com.team.kalstuff.item.KalStuffItems;
import com.team.kalstuff.tileentity.KalStuffTileEntities;
import com.team.kalstuff.worldgen.KalStuffWorldGenerator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod.EventBusSubscriber
public class CommonProxy
{
	public static final CreativeTabs KALSTUFF = new KalStuffCreativeTab("kalstuffTab");

	public void preInit(FMLPreInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(new CoreEventHandler());
		KalStuffTileEntities.register();
		KalStuffWorldGenerator.register();
		KalStuffEntities.setup();
		NetworkRegistry.INSTANCE.registerGuiHandler(KalStuff.instance, new KalStuffGuiHandler());
	}

	public void init(FMLInitializationEvent e)
	{
		KalStuffRecipes.add();
		KalStuffItems.configureItems();
		KalStuff.logger
				.info("Hi there, nerdy geeks. You should just enjoy Minecraft and stop looking at the system output.");
	}

	public void postInit(FMLPostInitializationEvent e)
	{
		KalStuff.logger.info("Wait a minute... Guys! IT WORKS!?! WE MADE A MOD!!!");
	}
}