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



//Yayo
public class StartupCommon
{

    public static BlockBridge blockBridge;
    public static BlockSquidMat blockSquidMat;
    public static BlockEnder blockEnder;
    
    public static ItemEnderPowder itemEnderPowder;
    public static ItemCoffee itemCoffee;
    public static Item itemCoffeeMug;
    
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
    	 
    	 
    	 
    	 GameRegistry.registerItem(itemEnderPowder, "itemEnderPowder");
    	 GameRegistry.registerItem(itemCoffee, "itemCoffee");
    	 GameRegistry.registerItem(itemCoffeeMug, "itemCoffeeMug");
    }
    
    public static void initCommon()
    {
    	 GameRegistry.addShapelessRecipe(new ItemStack(itemEnderPowder, 4), new Object[] {
    			 new ItemStack(Items.ender_pearl),
    			 new ItemStack(Items.flint)
    			 });
    	 
    	 GameRegistry.addShapelessRecipe(new ItemStack(itemCoffee, 1), new Object[] {
			 new ItemStack(Blocks.dirt),
			 new ItemStack(itemCoffeeMug)
			 });
    	 

    	 GameRegistry.addRecipe(new ItemStack(itemCoffeeMug, 1),  new Object[] {
    		 "PC",
    		 'C', Items.clay_ball,
    		 'P', Items.flower_pot,
    			 });
    	 
    	 GameRegistry.addRecipe(new ItemStack(blockBridge, 1),  new Object[] {
    		 "SPS",
    		 "PEP",
    		 "SPS",
    		 'S', Items.stick,
    		 'P', Blocks.planks,
    		 'E', itemEnderPowder
    			 });
    	 
    	 GameRegistry.addRecipe(new ItemStack(blockEnder, 1), new Object[] {
    		 "PPP",
    		 "PPP",
    		 "PPP",
    		 'P', Items.ender_pearl
    	 });
    }
    public static void postInitCommon()
    {
    }
}
