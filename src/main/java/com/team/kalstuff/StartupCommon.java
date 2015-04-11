package com.team.kalstuff;

import com.team.kalstuff.block.BlockBridge;
import com.team.kalstuff.block.BlockEnder;
import com.team.kalstuff.block.BlockSquidMat;
import com.team.kalstuff.item.ItemCoffee;
import com.team.kalstuff.item.ItemEnderPowder;
import com.team.kalstuff.item.ItemTea;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon
{
    public static BlockBridge blockBridge;
    public static BlockSquidMat blockSquidMat;
    public static BlockEnder blockEnder;
    
    public static ItemEnderPowder itemEnderPowder;
    public static ItemCoffee itemCoffee;
    public static Item itemCoffeeMug;
    public static Item itemTea;
    
    public static CreativeTabs kalStuffTab = new KalStuffCreativeTab("kalStuffTab");
    
    

    public static void preInitCommon()
    {
    	//StartupClientOnly.initClientOnly();
    	blockBridge = (BlockBridge)(new BlockBridge().setUnlocalizedName("blockBridge"));
    	blockSquidMat = (BlockSquidMat)(new BlockSquidMat().setUnlocalizedName("blockSquidMat"));
    	blockEnder = (BlockEnder)(new BlockEnder().setUnlocalizedName("blockEnder"));
    	
    	GameRegistry.registerBlock(blockBridge, "blockBridge");
    	GameRegistry.registerBlock(blockSquidMat, "blockSquidMat");
    	GameRegistry.registerBlock(blockEnder, "blockEnder");
    	
    	
    	
    	 itemEnderPowder = (ItemEnderPowder)(new ItemEnderPowder().setUnlocalizedName("itemEnderPowder"));
    	 itemCoffee = (ItemCoffee) ((new ItemCoffee(2, 2.0f, false)).setAlwaysEdible().setUnlocalizedName("itemCoffee"));
    	 itemCoffeeMug = new Item().setUnlocalizedName("itemCoffeeMug").setCreativeTab(kalStuffTab);
    	 itemTea = (ItemTea) ((new ItemTea(2, 2.0f, false)).setAlwaysEdible().setUnlocalizedName("itemTea"));
    	 
    	 
    	 GameRegistry.registerItem(itemEnderPowder, "itemEnderPowder");
    	 GameRegistry.registerItem(itemCoffee, "itemCoffee");
    	 GameRegistry.registerItem(itemCoffeeMug, "itemCoffeeMug");
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
