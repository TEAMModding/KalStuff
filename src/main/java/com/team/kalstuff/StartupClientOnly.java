package com.team.kalstuff;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupClientOnly {
	
	public static void preInitClientOnly()
	{
		KeyBinding binding = new KeyBinding("key.kalstuff.test", 37, "key.categories.kalstuff");
		ClientRegistry.registerKeyBinding(binding);
	}
	
	public static void initClientOnly()
	{
		System.out.println("The item model has been succesfully loaded! Whoopy and hooray!");
		final int DEFAULT_ITEM_SUBTYPE = 0;
		
		Item itemBlockBridge = GameRegistry.findItem("kalstuff", "blockBridge");
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("kalstuff:blockBridge", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockBridge, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);

		ModelResourceLocation itemModelResourceLocation2 = new ModelResourceLocation("kalstuff:itemEnderPowder", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StartupCommon.itemEnderPowder, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation2);
		 
		ModelResourceLocation itemModelResourceLocation3 = new ModelResourceLocation("kalstuff:itemCoffee", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StartupCommon.itemCoffee, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation3);
		 
		ModelResourceLocation itemModelResourceLocation4 = new ModelResourceLocation("kalstuff:itemCoffeeMug", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StartupCommon.itemCoffeeMug, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation4);
		
		Item itemBlockSquidMat = GameRegistry.findItem("kalstuff", "blockSquidMat");
		ModelResourceLocation itemModelResourceLocation5= new ModelResourceLocation("kalstuff:blockSquidMat", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSquidMat, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation5);
		
		Item itemBlockEnder = GameRegistry.findItem("kalstuff", "blockEnder");
		ModelResourceLocation itemModelResourceLocation6= new ModelResourceLocation("kalstuff:blockEnder", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockEnder, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation6);
	
		ModelResourceLocation itemModelResourceLocation7 = new ModelResourceLocation("kalstuff:itemTea", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(StartupCommon.itemTea, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation7);

	}
	 
	public static void postInitClientOnly()
	{
	}
	
}
