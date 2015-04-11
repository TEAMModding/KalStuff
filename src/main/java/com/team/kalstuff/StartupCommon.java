package com.team.kalstuff;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


// Does the repository wooooooork?!?!?!?

//testing repository
// Yes it does!

//Testing again, to see if eclipse works with Git.

//That's so awesome!

//Yayo
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
