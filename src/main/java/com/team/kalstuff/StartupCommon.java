package com.team.kalstuff;

import com.team.KalStuff;

import com.team.kalstuff.block.*;
import com.team.kalstuff.item.*;
import com.team.kalstuff.tileentity.*;
import com.team.kalstuff.structure.*;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon
{
    public static BlockBridge blockBridge;
    public static BlockSquidMat blockSquidMat;
    public static BlockEnder blockEnder;
    public static BlockBlaze blockBlaze;
    public static BlockCarrot blockCarrot;
    public static BlockApple blockApple;
    public static BlockPotato blockPotato;


    public static BlockChickenNest blockChickenNest;
    
    public static ItemEnderPowder itemEnderPowder;
    public static ItemCoffee itemCoffee;
    public static ItemJewelSoup itemJewelSoup;
    public static Item itemCoffeeMug;
    public static Item itemGoldenMug;
    public static Item itemTea;
    public static ItemCoffee itemLightCoffee;
    public static ItemBaconWand itemBaconWand;
    public static Item itemChocolateCap;
    public static Item itemBaconCore;
    public static Item itemInfusedBaconCore;
    
    public static CreativeTabs kalStuffTab = new KalStuffCreativeTab("kalStuffTab");
    
    

    public static void preInitCommon()
    {

    	blockBridge = (BlockBridge) new BlockBridge().setUnlocalizedName("blockBridge");
    	blockSquidMat = (BlockSquidMat) new BlockSquidMat().setUnlocalizedName("blockSquidMat");
    	blockEnder = (BlockEnder) new BlockEnder().setUnlocalizedName("blockEnder");
    	blockBlaze = (BlockBlaze) new BlockBlaze().setUnlocalizedName("blockBlaze");
    	blockCarrot = (BlockCarrot) new BlockCarrot().setUnlocalizedName("blockCarrot");
    	blockApple = (BlockApple) new BlockApple().setUnlocalizedName("blockApple");
    	blockPotato = (BlockPotato) new BlockPotato().setUnlocalizedName("blockPotato");
    	blockChickenNest = (BlockChickenNest) new BlockChickenNest().setUnlocalizedName("blockChickenNest");

    	
    	GameRegistry.registerBlock(blockBridge, "blockBridge");
    	GameRegistry.registerBlock(blockSquidMat, "blockSquidMat");
    	GameRegistry.registerBlock(blockEnder, "blockEnder");
    	GameRegistry.registerBlock(blockBlaze, "blockBlaze");
    	GameRegistry.registerBlock(blockCarrot, "blockCarrot");
    	GameRegistry.registerBlock(blockApple, "blockApple");
    	GameRegistry.registerBlock(blockPotato, "blockPotato");

    	GameRegistry.registerBlock(blockChickenNest, "blockChickenNest");
    	
    	
    	 itemEnderPowder = (ItemEnderPowder) new ItemEnderPowder().setUnlocalizedName("itemEnderPowder");
    	 itemCoffee = (ItemCoffee) new ItemCoffee(2, 2.0f, false, 200).setAlwaysEdible().setUnlocalizedName("itemCoffee");
    	 itemJewelSoup = (ItemJewelSoup) new ItemJewelSoup(2, 2.0f, false, 200).setAlwaysEdible().setUnlocalizedName("itemJewelSoup");
    	 itemLightCoffee = (ItemCoffee) new ItemCoffee(2, 2.0f, false).setAlwaysEdible().setUnlocalizedName("itemLightCoffee").setCreativeTab(kalStuffTab);
    	 itemCoffeeMug = new Item().setUnlocalizedName("itemCoffeeMug").setCreativeTab(kalStuffTab);
    	 itemGoldenMug = new Item().setUnlocalizedName("itemGoldenMug").setCreativeTab(kalStuffTab);
    	 itemTea = (ItemTea) new ItemTea(2, 2.0f, false).setAlwaysEdible().setUnlocalizedName("itemTea");
    	 itemBaconWand = (ItemBaconWand) new ItemBaconWand().setUnlocalizedName("itemBaconWand");
    	 itemChocolateCap = new Item().setUnlocalizedName("itemChocolateCap").setCreativeTab(kalStuffTab);
    	 itemBaconCore = new Item().setUnlocalizedName("itemBaconCore").setCreativeTab(kalStuffTab);
    	 itemInfusedBaconCore = new Item().setUnlocalizedName("itemInfusedBaconCore").setCreativeTab(kalStuffTab);
    	 
    	 GameRegistry.registerItem(itemEnderPowder, "itemEnderPowder");
    	 GameRegistry.registerItem(itemCoffee, "itemCoffee");
    	 GameRegistry.registerItem(itemJewelSoup, "itemJewelSoup");
    	 GameRegistry.registerItem(itemLightCoffee, "itemLightCoffee");
    	 GameRegistry.registerItem(itemCoffeeMug, "itemCoffeeMug");
    	 GameRegistry.registerItem(itemGoldenMug, "itemGoldenMug");
    	 GameRegistry.registerItem(itemTea, "itemTea");
    	 GameRegistry.registerItem(itemBaconWand, "itemBaconWand");
    	 GameRegistry.registerItem(itemChocolateCap, "itemChocolateCap");
    	 GameRegistry.registerItem(itemBaconCore, "itemBaconCore");
    	 GameRegistry.registerItem(itemInfusedBaconCore, "itemInfusedBaconCore");
    	 

    	 WorldGen worldGen = new WorldGen();
    	 GameRegistry.registerWorldGenerator(worldGen, 1);


 		GameRegistry.registerTileEntity(TileEntityChickenNest.class, "tileEntityChickenNest");
 		
 		
		NetworkRegistry.INSTANCE.registerGuiHandler(KalStuff.instance, GuiHandlerRegistry.getInstance());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new KalStuffGuiHandler(), KalStuffGuiHandler.getGuiID());
		
		StructureHut structureHut = new StructureHut();
		worldGen.add(structureHut);
		
    }
    
    public static void initCommon()
    {
    	KalStuffRecipes.add();
    }
    public static void postInitCommon()
    {
    }
}
