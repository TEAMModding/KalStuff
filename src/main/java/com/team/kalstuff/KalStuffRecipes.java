package com.team.kalstuff;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class KalStuffRecipes {

	public static void add() {
   	 GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemEnderPowder, 4), new Object[] {
		 new ItemStack(Items.ENDER_PEARL),
		 new ItemStack(Items.FLINT)
		 });
 
 GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemCoffee, 1), new Object[] {
	 new ItemStack(Blocks.DIRT),
	 new ItemStack(StartupCommon.itemCoffeeMug)
	 });
 
 GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemTea, 1), new Object[] {
	 new ItemStack(Blocks.LEAVES),
	 new ItemStack(StartupCommon.itemCoffeeMug)
	 });
 

 GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemLightCoffee, 1), new Object[] {
	 new ItemStack(Items.MILK_BUCKET),
	 new ItemStack(StartupCommon.itemCoffee)
	 });
  
 GameRegistry.addRecipe(new ItemStack(StartupCommon.itemCoffeeMug, 1),  new Object[] {
	 "PC",
	 'C', Items.CLAY_BALL,
	 'P', Items.FLOWER_POT
		 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockBridge, 1),  new Object[] {
	 "SPS",
	 "PEP",
	 "SPS",
	 'S', Items.STICK,
	 'P', Blocks.PLANKS,
	 'E', StartupCommon.itemEnderPowder
		 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockEnder, 1), new Object[] {
	 "PPP",
	 "PPP",
	 "PPP",
	 'P', Items.ENDER_PEARL
 });


 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockBlaze, 1), new Object[] {
	 "PPP",
	 "PPP",
	 "PPP",
	 'P', Items.BLAZE_ROD
 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockCarrot, 4), new Object[] {
	 "PPP",
	 "PPP",
	 "PPP",
	 'P', Items.CARROT
 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockApple, 4), new Object[] {
	 "PPP",
	 "PPP",
	 "PPP",
	 'P', Items.APPLE
 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockPotato, 4), new Object[] {
	 "PPP",
	 "PPP",
	 "PPP",
	 'P', Items.POTATO
 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockBakedPotato, 4), new Object[] {
		 "PPP",
		 "PPP",
		 "PPP",
		 'P', Items.BAKED_POTATO
	 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.itemGoldenMug, 1), new Object[] {
	 "p p",
	 " p ",
	 'p', Items.GOLD_INGOT
 });
 
 GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemJewelSoup, 1), new Object[] {
	 new ItemStack(Items.DIAMOND),
	 new ItemStack(StartupCommon.itemGoldenMug)
 });
 
	GameRegistry.addRecipe(new ItemStack(StartupCommon.blockChickenNest, 1), new Object[] {
		" x ",
		"x x",
		" x ",
		'x', Items.WHEAT
	});
	
	GameRegistry.addRecipe(new ItemStack(StartupCommon.itemChocolateCap), new Object[] {
		"888",
		"8 8",
		"   ",
		'8', new ItemStack(Items.DYE, 1, EnumDyeColor.BROWN.getDyeDamage())
	});
	
	GameRegistry.addRecipe(new ItemStack(StartupCommon.itemBaconCore), new Object[] {
		" p",
		"p ",
		'p', Items.COOKED_PORKCHOP
	});
	
/*	GameRegistry.addRecipe(new ItemStack(StartupCommon.itemInfusedBaconCore), new Object[] {
		" c ",
		"cbc",
		" c ",
		'b', StartupCommon.itemBaconCore,
		'c', StartupCommon.itemCoffee.setContainerItem(StartupCommon.itemCoffeeMug)
	});*/
	 GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemInfusedBaconCore, 1), new Object[] {
		 new ItemStack(StartupCommon.itemBaconCore),
		 new ItemStack(StartupCommon.itemCoffee.setContainerItem(StartupCommon.itemCoffeeMug))
	 });
	GameRegistry.addRecipe(new ItemStack(StartupCommon.itemBaconWand), new Object[] {
		"  c",
		" b ",
		"c  ",
		'b', StartupCommon.itemInfusedBaconCore,
		'c', StartupCommon.itemChocolateCap
	});
 
	GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemGrapeSeeds, 1), new Object[] {
		 new ItemStack(StartupCommon.itemGrapes)
		 });
	 
	GameRegistry.addRecipe(new ItemStack(StartupCommon.blockTrashCan), new Object[] {
			"A A",
			"A A",
			"AAA",
			'A', Blocks.STONE
		});
	 
	GameRegistry.addRecipe(new ItemStack(StartupCommon.itemWalkingStick), new Object[] {
			"  A",
			" A ",
			"A  ",
			'A', Items.STICK
		});
	
	GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemClosedAppleSoda), new Object[] {
		new ItemStack(StartupCommon.itemSodaCan),
		new ItemStack(Items.APPLE)
	});
	
	GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemClosedGrapeSoda), new Object[] {
		new ItemStack(StartupCommon.itemSodaCan),
		new ItemStack(StartupCommon.itemGrapes)
	});
	
	GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemClosedMelonSoda), new Object[] {
		new ItemStack(StartupCommon.itemSodaCan),
		new ItemStack(Items.MELON)
	});
	
	GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemClosedRootBeer), new Object[] {
		new ItemStack(StartupCommon.itemSodaCan),
		new ItemStack(Items.NETHER_WART)
	});
	 
	GameRegistry.addSmelting(Items.IRON_INGOT, new ItemStack(StartupCommon.itemSodaCan), 3);
	
	GameRegistry.addSmelting(StartupCommon.blockPotato, new ItemStack(StartupCommon.blockBakedPotato), 2);
	
	GameRegistry.addShapelessRecipe(new ItemStack(Items.CARROT , 9), new Object[] {
			new ItemStack(StartupCommon.blockCarrot),
			new ItemStack(StartupCommon.blockCarrot),
			new ItemStack(StartupCommon.blockCarrot),
			new ItemStack(StartupCommon.blockCarrot),
		});
	
	GameRegistry.addShapelessRecipe(new ItemStack(Items.APPLE , 9), new Object[] {
			new ItemStack(StartupCommon.blockApple),
			new ItemStack(StartupCommon.blockApple),
			new ItemStack(StartupCommon.blockApple),
			new ItemStack(StartupCommon.blockApple),
		});
	
	GameRegistry.addShapelessRecipe(new ItemStack(Items.POTATO , 9), new Object[] {
			new ItemStack(StartupCommon.blockPotato),
			new ItemStack(StartupCommon.blockPotato),
			new ItemStack(StartupCommon.blockPotato),
			new ItemStack(StartupCommon.blockPotato),
		});
	
	GameRegistry.addShapelessRecipe(new ItemStack(Items.BAKED_POTATO , 9), new Object[] {
			new ItemStack(StartupCommon.blockBakedPotato),
			new ItemStack(StartupCommon.blockBakedPotato),
			new ItemStack(StartupCommon.blockBakedPotato),
			new ItemStack(StartupCommon.blockBakedPotato),
		});
		 
	
	
	
	};
	
	

	
}
