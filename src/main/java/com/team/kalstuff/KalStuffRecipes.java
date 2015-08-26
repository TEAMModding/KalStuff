package com.team.kalstuff;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
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
 

 GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemLightCoffee, 1), new Object[] {
	 new ItemStack(Items.milk_bucket),
	 new ItemStack(StartupCommon.itemCoffee)
	 });
  
 GameRegistry.addRecipe(new ItemStack(StartupCommon.itemCoffeeMug, 1),  new Object[] {
	 "PC",
	 'C', Items.clay_ball,
	 'P', Items.flower_pot
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
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockCarrot, 4), new Object[] {
	 "PPP",
	 "PPP",
	 "PPP",
	 'P', Items.carrot
 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockApple, 4), new Object[] {
	 "PPP",
	 "PPP",
	 "PPP",
	 'P', Items.apple
 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.blockPotato, 2), new Object[] {
	 "PPP",
	 "PPP",
	 "PPP",
	 'P', Items.potato
 });
 
 GameRegistry.addRecipe(new ItemStack(StartupCommon.itemGoldenMug, 1), new Object[] {
	 "p p",
	 " p ",
	 'p', Items.gold_ingot
 });
 
 GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemJewelSoup, 1), new Object[] {
	 new ItemStack(Items.diamond),
	 new ItemStack(StartupCommon.itemGoldenMug)
 });
 
	GameRegistry.addRecipe(new ItemStack(StartupCommon.blockChickenNest, 1), new Object[] {
		" x ",
		"x x",
		" x ",
		'x', Items.wheat
	});
	
	GameRegistry.addRecipe(new ItemStack(StartupCommon.itemChocolateCap), new Object[] {
		"888",
		"8 8",
		"   ",
		'8', new ItemStack(Items.dye, 1, EnumDyeColor.BROWN.getDyeDamage())
	});
	
	GameRegistry.addRecipe(new ItemStack(StartupCommon.itemBaconCore), new Object[] {
		" p",
		"p ",
		'p', Items.cooked_porkchop
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
			'A', Blocks.stone
		});
	 
	GameRegistry.addRecipe(new ItemStack(StartupCommon.itemWalkingStick), new Object[] {
			"  A",
			" A ",
			"A  ",
			'A', Items.stick
		});
	
	GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemAppleSoda), new Object[] {
		new ItemStack(StartupCommon.itemSodaCan),
		new ItemStack(Items.apple)
	});
	
	GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemGrapeSoda), new Object[] {
		new ItemStack(StartupCommon.itemSodaCan),
		new ItemStack(StartupCommon.itemGrapes)
	});
	
	GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemMelonSoda), new Object[] {
		new ItemStack(StartupCommon.itemSodaCan),
		new ItemStack(Items.melon)
	});
	
	GameRegistry.addShapelessRecipe(new ItemStack(StartupCommon.itemRootBeer), new Object[] {
		new ItemStack(StartupCommon.itemSodaCan),
		new ItemStack(Items.nether_wart)
	});
	 
	GameRegistry.addSmelting(Items.iron_ingot, new ItemStack(StartupCommon.itemSodaCan), 3);
	};
	
	
}
