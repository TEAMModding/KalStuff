package com.team.kalstuff;


import com.team.kalstuff.block.BlockBlaze;
import com.team.kalstuff.block.BlockApple;
import com.team.kalstuff.block.BlockBridge;
import com.team.kalstuff.block.BlockEnder;
import com.team.kalstuff.block.BlockSquidMat;
import com.team.kalstuff.block.BlockPotato;
import com.team.kalstuff.item.ItemCoffee;
import com.team.kalstuff.item.ItemJewelSoup;
import com.team.kalstuff.item.ItemEnderPowder;
import com.team.kalstuff.item.ItemTea;
import com.team.kalstuff.block.BlockCarrot;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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
    public static ItemEnderPowder itemEnderPowder;
    public static ItemCoffee itemCoffee;
    public static ItemJewelSoup itemJewelSoup;
    public static Item itemCoffeeMug;
    public static Item itemGoldenMug;
    public static Item itemTea;
    public static ItemCoffee itemLightCoffee;
    
    public static CreativeTabs kalStuffTab = new KalStuffCreativeTab("kalStuffTab");
    
    

    public static void preInitCommon()
    {
    	blockBridge = (BlockBridge)(new BlockBridge().setUnlocalizedName("blockBridge"));
    	blockSquidMat = (BlockSquidMat)(new BlockSquidMat().setUnlocalizedName("blockSquidMat"));
    	blockEnder = (BlockEnder)(new BlockEnder().setUnlocalizedName("blockEnder"));
    	blockBlaze = (BlockBlaze)(new BlockBlaze().setUnlocalizedName("blockBlaze"));
    	blockCarrot = (BlockCarrot)(new BlockCarrot().setUnlocalizedName("blockCarrot"));
    	blockApple = (BlockApple)(new BlockApple().setUnlocalizedName("blockApple"));
    	blockPotato = (BlockPotato)(new BlockPotato().setUnlocalizedName("blockPotato"));
    	GameRegistry.registerBlock(blockBridge, "blockBridge");
    	GameRegistry.registerBlock(blockSquidMat, "blockSquidMat");
    	GameRegistry.registerBlock(blockEnder, "blockEnder");
    	GameRegistry.registerBlock(blockBlaze, "blockBlaze");
    	GameRegistry.registerBlock(blockCarrot, "blockCarrot");
    	GameRegistry.registerBlock(blockApple, "blockApple");
    	GameRegistry.registerBlock(blockPotato, "blockPotato");
    	
    	 itemEnderPowder = (ItemEnderPowder)(new ItemEnderPowder().setUnlocalizedName("itemEnderPowder"));
    	 itemCoffee = (ItemCoffee) ((new ItemCoffee(2, 2.0f, false, 200)).setAlwaysEdible().setUnlocalizedName("itemCoffee"));
    	 itemJewelSoup = (ItemJewelSoup) ((new ItemJewelSoup(2, 2.0f, false, 200)).setAlwaysEdible().setUnlocalizedName("itemJewelSoup"));
    	 itemLightCoffee = (ItemCoffee) ((new ItemCoffee(2, 2.0f, false)).setAlwaysEdible().setUnlocalizedName("itemLightCoffee")).setCreativeTab(kalStuffTab);
    	 itemCoffeeMug = new Item().setUnlocalizedName("itemCoffeeMug").setCreativeTab(kalStuffTab);
    	 itemGoldenMug = new Item().setUnlocalizedName("itemGoldenMug").setCreativeTab(kalStuffTab);
    	 itemTea = (ItemTea) ((new ItemTea(2, 2.0f, false)).setAlwaysEdible().setUnlocalizedName("itemTea"));
    	 
    	 GameRegistry.registerItem(itemEnderPowder, "itemEnderPowder");
    	 GameRegistry.registerItem(itemCoffee, "itemCoffee");
    	 GameRegistry.registerItem(itemJewelSoup, "itemJewelSoup");
    	 GameRegistry.registerItem(itemLightCoffee, "itemLightCoffee");
    	 GameRegistry.registerItem(itemCoffeeMug, "itemCoffeeMug");
    	 GameRegistry.registerItem(itemGoldenMug, "itemGoldenMug");
    	 GameRegistry.registerItem(itemTea, "itemTea");
    }
    
    public static void initCommon()
    {
    	KalStuffRecipes.add();
    }
    public static void postInitCommon()
    {
    }
}
