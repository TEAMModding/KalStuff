package com.team.kalstuff;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class KalStuffRecipes {

	public static void add() {
		
		
		/*--------------------BEGIN SHAPED RECIPES--------------------*/
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.coffee_mug, 1),  new Object[] {
				"   ",
				"PC ",
				"   ",
				'C', Items.CLAY_BALL,
				'P', Items.FLOWER_POT
		});
 
		GameRegistry.addRecipe(new ItemStack(StartupCommon.bridge, 1),  new Object[] {
				"SPS",
				"PEP",
				"SPS",
				'S', Items.STICK,
				'P', Blocks.PLANKS,
				'E', StartupCommon.crushed_ender
		});
 
		GameRegistry.addRecipe(new ItemStack(StartupCommon.ender_block, 1), new Object[] {
				"PPP",
				"PPP",
				"PPP",
				'P', Items.ENDER_PEARL
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.blaze_block, 1), new Object[] {
				"BBB",
				"BBB",
				"BBB",
				'B', Items.BLAZE_ROD
		});
 
		GameRegistry.addRecipe(new ItemStack(StartupCommon.carrot_block, 4), new Object[] {
				"CCC",
				"CCC",
				"CCC",
				'C', Items.CARROT
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.apple_block, 4), new Object[] {
				"AAA",
				"AAA",
				"AAA",
				'A', Items.APPLE
		});
 
		GameRegistry.addRecipe(new ItemStack(StartupCommon.potato_block, 4), new Object[] {
				"PPP",
				"PPP",
				"PPP",
				'P', Items.POTATO
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.baked_potato_block, 4), new Object[] {
				"PPP",
				"PPP",
				"PPP",
				'P', Items.BAKED_POTATO
		});
 
		GameRegistry.addRecipe(new ItemStack(StartupCommon.golden_mug, 1), new Object[] {
				"X X",
				" X ",
				"   ",
				'X', Items.GOLD_INGOT
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.chicken_nest, 1), new Object[] {
				" X ",
				"X X",
				" X ",
				'X', Items.WHEAT
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.chocolate_cap), new Object[] {
				"XXX",
				"X X",
				"   ",
				'X', new ItemStack(Items.DYE, 1, EnumDyeColor.BROWN.getDyeDamage())
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.bacon_core), new Object[] {
				" P ",
				"P  ",
				"   ",
				'P', Items.COOKED_PORKCHOP
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.bacon_wand), new Object[] {
				"  C",
				" B ",
				"C  ",
				'B', StartupCommon.infused_bacon_core,
				'C', StartupCommon.chocolate_cap
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.trash_can), new Object[] {
				"A A",
				"A A",
				"AAA",
				'A', Blocks.STONE
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.walking_stick), new Object[] {
				"  A",
				" A ",
				"A  ",
				'A', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.iron_dagger, 1),  new Object[] {
				" M ",
				" S ",
				"   ",
				'M', Items.IRON_INGOT,
				'S', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.wooden_dagger, 1),  new Object[] {
				" M ",
				" S ",
				"   ",
				'M', Blocks.PLANKS,
				'S', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.stone_dagger, 1),  new Object[] {
				" M ",
				" S ",
				"   ",
				'M', Blocks.COBBLESTONE,
				'S', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.diamond_dagger, 1),  new Object[] {
				" M ",
				" S ",
				"   ",
				'M', Items.DIAMOND,
				'S', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.golden_dagger, 1),  new Object[] {
				" M ",
				" S ",
				"   ",
				'M', Items.GOLD_INGOT,
				'S', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(StartupCommon.plantable_grape_seeds, 1),  new Object[] {
				"S S",
				" G ",
				"S S",
				'G', StartupCommon.grape_seeds,
				'S', Items.STICK
		});
		
		
		
		
		
		/*--------------------END SHAPED RECIPES--------------------*/
		
		
		
		/*--------------------SHAPELESS RECIPES--------------------*/
		
		
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.crushed_ender, 4), new Object[] {
				new ItemStack(Items.ENDER_PEARL),
				new ItemStack(Items.FLINT)
		});
 
		GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.coffee, 1), new Object[] {
				new ItemStack(Blocks.DIRT),
				new ItemStack(StartupCommon.coffee_mug)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.tea, 1), new Object[] {
				new ItemStack(Blocks.LEAVES),
				new ItemStack(StartupCommon.coffee_mug)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.jewel_soup, 1), new Object[] {
				new ItemStack(Items.DIAMOND),
				new ItemStack(StartupCommon.golden_mug)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.grape_seeds, 1), new Object[] {
				new ItemStack(StartupCommon.grapes)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.light_coffee, 1), new Object[] {
				new ItemStack(Items.MILK_BUCKET),
				new ItemStack(StartupCommon.coffee)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.closed_apple_soda), new Object[] {
				new ItemStack(StartupCommon.soda_can),
				new ItemStack(Items.APPLE)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.closed_grape_soda), new Object[] {
				new ItemStack(StartupCommon.soda_can),
				new ItemStack(StartupCommon.grapes)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.closed_melon_soda), new Object[] {
				new ItemStack(StartupCommon.soda_can),
				new ItemStack(Items.MELON)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.closed_root_beer), new Object[] {
				new ItemStack(StartupCommon.soda_can),
				new ItemStack(Items.NETHER_WART)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.infused_bacon_core, 1), new Object[] {
				new ItemStack(StartupCommon.bacon_core),
				new ItemStack(StartupCommon.coffee.setContainerItem(StartupCommon.coffee_mug))
		});
				
		GameRegistry.addShapelessRecipe(new ItemStack(Items.CARROT , 9), new Object[] {
				new ItemStack(StartupCommon.carrot_block),
				new ItemStack(StartupCommon.carrot_block),
				new ItemStack(StartupCommon.carrot_block),
				new ItemStack(StartupCommon.carrot_block),
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.APPLE , 9), new Object[] {
				new ItemStack(StartupCommon.apple_block),
				new ItemStack(StartupCommon.apple_block),
				new ItemStack(StartupCommon.apple_block),
				new ItemStack(StartupCommon.apple_block),
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.POTATO , 9), new Object[] {
				new ItemStack(StartupCommon.potato_block),
				new ItemStack(StartupCommon.potato_block),
				new ItemStack(StartupCommon.potato_block),
				new ItemStack(StartupCommon.potato_block),
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.BAKED_POTATO , 9), new Object[] {
				new ItemStack(StartupCommon.baked_potato_block),
				new ItemStack(StartupCommon.baked_potato_block),
				new ItemStack(StartupCommon.baked_potato_block),
				new ItemStack(StartupCommon.baked_potato_block),
		});
		
		
		
		
		
		/*--------------------END SHAPELESS RECIPES--------------------*/
		
		
		
		/*--------------------BEGIN SMELTING RECIPES--------------------*/
		
		
		
		
		
		GameRegistry.addSmelting(StartupCommon.potato_block, new ItemStack(StartupCommon.baked_potato_block), 2);
		
		
		
		
		
		/*--------------------END SMELTING RECIPES--------------------*/
	}
}
