package com.team.kalstuff;

import com.team.kalstuff.block.KalStuffBlocks;
import com.team.kalstuff.item.KalStuffItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class KalStuffRecipes {

	public static void add() {
		
		addShapedRecipes();
		addShapelessRecipes();
		addSmeltingRecipes();
	}
	
	
	public static void addShapedRecipes() {
		
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.coffee_mug, 1),  new Object[] {
				"   ",
				"PC ",
				"   ",
				'C', Items.CLAY_BALL,
				'P', Items.FLOWER_POT
		});
 
		GameRegistry.addRecipe(new ItemStack(KalStuffBlocks.bridge, 1),  new Object[] {
				"SPS",
				"PEP",
				"SPS",
				'S', Items.STICK,
				'P', Blocks.PLANKS,
				'E', KalStuffItems.crushed_ender
		});
 
		GameRegistry.addRecipe(new ItemStack(KalStuffBlocks.ender_block, 1), new Object[] {
				"PPP",
				"PPP",
				"PPP",
				'P', Items.ENDER_PEARL
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffBlocks.blaze_block, 1), new Object[] {
				"BBB",
				"BBB",
				"BBB",
				'B', Items.BLAZE_ROD
		});
 
		GameRegistry.addRecipe(new ItemStack(KalStuffBlocks.carrot_block, 4), new Object[] {
				"CCC",
				"CCC",
				"CCC",
				'C', Items.CARROT
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffBlocks.apple_block, 4), new Object[] {
				"AAA",
				"AAA",
				"AAA",
				'A', Items.APPLE
		});
 
		GameRegistry.addRecipe(new ItemStack(KalStuffBlocks.potato_block, 4), new Object[] {
				"PPP",
				"PPP",
				"PPP",
				'P', Items.POTATO
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffBlocks.baked_potato_block, 4), new Object[] {
				"PPP",
				"PPP",
				"PPP",
				'P', Items.BAKED_POTATO
		});
 
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.golden_mug, 1), new Object[] {
				"X X",
				" X ",
				"   ",
				'X', Items.GOLD_INGOT
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffBlocks.chicken_nest, 1), new Object[] {
				" X ",
				"X X",
				" X ",
				'X', Items.WHEAT
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.chocolate_cap), new Object[] {
				"XXX",
				"X X",
				"   ",
				'X', new ItemStack(Items.DYE, 1, EnumDyeColor.BROWN.getDyeDamage())
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.bacon_core), new Object[] {
				" P ",
				"P  ",
				"   ",
				'P', Items.COOKED_PORKCHOP
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.bacon_wand), new Object[] {
				"  C",
				" B ",
				"C  ",
				'B', KalStuffItems.infused_bacon_core,
				'C', KalStuffItems.chocolate_cap
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffBlocks.trash_can), new Object[] {
				"A A",
				"A A",
				"AAA",
				'A', Blocks.STONE
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.walking_stick), new Object[] {
				"  A",
				" A ",
				"A  ",
				'A', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.iron_dagger, 1),  new Object[] {
				" M ",
				" S ",
				"   ",
				'M', Items.IRON_INGOT,
				'S', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.wooden_dagger, 1),  new Object[] {
				" M ",
				" S ",
				"   ",
				'M', Blocks.PLANKS,
				'S', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.stone_dagger, 1),  new Object[] {
				" M ",
				" S ",
				"   ",
				'M', Blocks.COBBLESTONE,
				'S', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.diamond_dagger, 1),  new Object[] {
				" M ",
				" S ",
				"   ",
				'M', Items.DIAMOND,
				'S', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.golden_dagger, 1),  new Object[] {
				" M ",
				" S ",
				"   ",
				'M', Items.GOLD_INGOT,
				'S', Items.STICK
		});
		
		GameRegistry.addRecipe(new ItemStack(KalStuffItems.plantable_grape_seeds, 1),  new Object[] {
				"S S",
				" G ",
				"S S",
				'G', KalStuffItems.grape_seeds,
				'S', Items.STICK
		});
	}

	
	public static void addShapelessRecipes() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(KalStuffItems.crushed_ender, 4), new Object[] {
				new ItemStack(Items.ENDER_PEARL),
				new ItemStack(Items.FLINT)
		});
 
		GameRegistry.addShapelessRecipe(new ItemStack(KalStuffItems.coffee, 1), new Object[] {
				new ItemStack(Blocks.DIRT),
				new ItemStack(KalStuffItems.coffee_mug)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(KalStuffItems.tea, 1), new Object[] {
				new ItemStack(Blocks.LEAVES),
				new ItemStack(KalStuffItems.coffee_mug)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(KalStuffItems.jewel_soup, 1), new Object[] {
				new ItemStack(Items.DIAMOND),
				new ItemStack(KalStuffItems.golden_mug)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(KalStuffItems.grape_seeds, 1), new Object[] {
				new ItemStack(KalStuffItems.grapes)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(KalStuffItems.light_coffee, 1), new Object[] {
				new ItemStack(Items.MILK_BUCKET),
				new ItemStack(KalStuffItems.coffee)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(KalStuffItems.closed_apple_soda), new Object[] {
				new ItemStack(KalStuffItems.soda_can),
				new ItemStack(Items.APPLE)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(KalStuffItems.closed_grape_soda), new Object[] {
				new ItemStack(KalStuffItems.soda_can),
				new ItemStack(KalStuffItems.grapes)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(KalStuffItems.closed_melon_soda), new Object[] {
				new ItemStack(KalStuffItems.soda_can),
				new ItemStack(Items.MELON)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(KalStuffItems.closed_root_beer), new Object[] {
				new ItemStack(KalStuffItems.soda_can),
				new ItemStack(Items.NETHER_WART)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(KalStuffItems.infused_bacon_core, 1), new Object[] {
				new ItemStack(KalStuffItems.bacon_core),
				new ItemStack(KalStuffItems.coffee.setContainerItem(KalStuffItems.coffee_mug))
		});
				
		GameRegistry.addShapelessRecipe(new ItemStack(Items.CARROT , 9), new Object[] {
				new ItemStack(KalStuffBlocks.carrot_block),
				new ItemStack(KalStuffBlocks.carrot_block),
				new ItemStack(KalStuffBlocks.carrot_block),
				new ItemStack(KalStuffBlocks.carrot_block),
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.APPLE , 9), new Object[] {
				new ItemStack(KalStuffBlocks.apple_block),
				new ItemStack(KalStuffBlocks.apple_block),
				new ItemStack(KalStuffBlocks.apple_block),
				new ItemStack(KalStuffBlocks.apple_block),
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.POTATO , 9), new Object[] {
				new ItemStack(KalStuffBlocks.potato_block),
				new ItemStack(KalStuffBlocks.potato_block),
				new ItemStack(KalStuffBlocks.potato_block),
				new ItemStack(KalStuffBlocks.potato_block),
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.BAKED_POTATO , 9), new Object[] {
				new ItemStack(KalStuffBlocks.baked_potato_block),
				new ItemStack(KalStuffBlocks.baked_potato_block),
				new ItemStack(KalStuffBlocks.baked_potato_block),
				new ItemStack(KalStuffBlocks.baked_potato_block),
		});
	}
	
	
	public static void addSmeltingRecipes(){
		
		GameRegistry.addSmelting(KalStuffBlocks.potato_block, new ItemStack(KalStuffBlocks.baked_potato_block), 2);
	}
}
