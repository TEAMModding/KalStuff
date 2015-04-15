package com.team.kalstuff;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class KalStuffRecipes {

	public static void add() {
   	 GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemEnderPowder, 4), new Object[] {
		 new ItemStack(Items.ender_pearl),
		 new ItemStack(Items.flint)
		 });
 
 GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemCoffee, 1), new Object[] {
	 new ItemStack(Blocks.dirt),
	 new ItemStack(StartupCommon.itemCoffeeMug)
	 });
 
 GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemTea, 1), new Object[] {
	 new ItemStack(Blocks.leaves),
	 new ItemStack(StartupCommon.itemCoffeeMug)
	 });
 
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.itemCoffeeMug, 1),  new Object[] {
	 "PC",
	 'C', Items.clay_ball,
	 'P', Items.flower_pot,
		 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockBridge, 1),  new Object[] {
	 "SPS",
	 "PEP",
	 "SPS",
	 'S', Items.stick,
	 'P', Blocks.planks,
	 'E', StartupCommon.itemEnderPowder
		 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockEnder, 1), new Object[] {
	 "PPP",
	 "PPP",
	 "PPP",
	 'P', Items.ender_pearl
 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockBlaze, 1), new Object[] {
	 "PPP",
	 "PPP",
	 "PPP",
	 'P', Items.blaze_rod
 });

	}
	
}
