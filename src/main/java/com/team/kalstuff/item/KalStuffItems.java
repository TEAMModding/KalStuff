package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;
import com.team.kalstuff.block.KalStuffBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class KalStuffItems {

	//Please keep all items in alphabetical order!
	public static ItemSoda					apple_soda;
	public static Item						bacon_core;
	public static ItemBaconWand				bacon_wand;
	public static ItemBlazeSoup				blaze_soup;
	public static ItemBoxingGlove			boxing_glove;
	public static Item						chocolate_cap;
	public static ItemClosedSoda			closed_apple_soda;
	public static ItemClosedSoda			closed_grape_soda;
	public static ItemClosedSoda			closed_melon_soda;
	public static ItemClosedSoda			closed_root_beer;
	public static ItemCoffee				coffee;
	public static Item						coffee_mug;
	public static ItemEnderPowder			crushed_ender;
	public static ItemDagger				diamond_dagger;
	public static ItemDagger				golden_dagger;
	public static Item						golden_mug;
	public static ItemFood					grapes;
	public static Item						grape_seeds;
	public static ItemSoda					grape_soda;
	public static Item						infused_bacon_core;
	public static ItemDagger				iron_dagger;
	public static ItemJewelSoup				jewel_soup;
	public static ItemCoffee				light_coffee;
	public static ItemLute					lute;
	public static ItemSoda					melon_soda;
	public static ItemSeeds					plantable_grape_seeds;
	public static ItemSoda					root_beer;
	public static Item						soda_can;
	public static ItemDagger				stone_dagger;	
	public static ItemTea						tea;
	public static ItemWalkingStick			walking_stick;
	public static ItemWine					wine;
	public static Item						wine_bottle;
	public static ItemDagger				wooden_dagger;
	public static ItemRoundShield			wooden_round_shield;
	
	/**
	 * Initializes and registers all items from the mod, including ItemBlocks.
	 */
	public static void setup() {
		
		initializeItems();
		registerItems();
		registerItemBlocks();
	}
	
	/**
	 * Initializes all items from the mod.
	 */
	public static void initializeItems() {

		//Please keep all items in alphabetical order!
    	apple_soda 				= (ItemSoda) new ItemSoda(2, 2.0f, 600, MobEffects.NIGHT_VISION).setUnlocalizedName("appleSoda");
    	bacon_core 				= new Item().setUnlocalizedName("baconCore").setCreativeTab(StartupCommon.KALSTUFF);
    	bacon_wand 				= (ItemBaconWand) new ItemBaconWand().setUnlocalizedName("baconWand");
    	blaze_soup 				= (ItemBlazeSoup) new ItemBlazeSoup(2, 2.0f, 6000, new Potion[] {MobEffects.ABSORPTION, MobEffects.NIGHT_VISION, MobEffects.STRENGTH, MobEffects.FIRE_RESISTANCE}).setUnlocalizedName("blazeSoup").setCreativeTab(StartupCommon.KALSTUFF);
    	boxing_glove			= (ItemBoxingGlove) new ItemBoxingGlove().setUnlocalizedName("boxingGlove").setCreativeTab(StartupCommon.KALSTUFF);
    	chocolate_cap 			= new Item().setUnlocalizedName("chocolateCap").setCreativeTab(StartupCommon.KALSTUFF);
    	closed_apple_soda		= (ItemClosedSoda) new ItemClosedSoda().setUnlocalizedName("closedAppleSoda").setCreativeTab(StartupCommon.KALSTUFF);
    	closed_grape_soda		= (ItemClosedSoda) new ItemClosedSoda().setUnlocalizedName("closedGrapeSoda").setCreativeTab(StartupCommon.KALSTUFF);
    	closed_melon_soda		= (ItemClosedSoda) new ItemClosedSoda().setUnlocalizedName("closedMelonSoda").setCreativeTab(StartupCommon.KALSTUFF);
      	closed_root_beer		= (ItemClosedSoda) new ItemClosedSoda().setUnlocalizedName("closedRootBeer").setCreativeTab(StartupCommon.KALSTUFF);
    	coffee 					= (ItemCoffee) new ItemCoffee(2, 2.0f, 200, MobEffects.SPEED).setUnlocalizedName("coffee").setCreativeTab(StartupCommon.KALSTUFF);
    	coffee_mug 				= new Item().setUnlocalizedName("coffeeMug").setCreativeTab(StartupCommon.KALSTUFF);
		crushed_ender 			= (ItemEnderPowder) new ItemEnderPowder().setUnlocalizedName("enderPowder").setCreativeTab(StartupCommon.KALSTUFF);
    	diamond_dagger 			= (ItemDagger) new ItemDagger(Item.ToolMaterial.DIAMOND).setUnlocalizedName("diamondDagger").setCreativeTab(StartupCommon.KALSTUFF);
    	golden_dagger 			= (ItemDagger) new ItemDagger(Item.ToolMaterial.GOLD).setUnlocalizedName("goldenDagger").setCreativeTab(StartupCommon.KALSTUFF);
    	golden_mug 				= new Item().setUnlocalizedName("goldenMug").setCreativeTab(StartupCommon.KALSTUFF);
    	grapes 					= (ItemFood) new ItemFood(3, 0.5f, false).setUnlocalizedName("grapes").setCreativeTab(StartupCommon.KALSTUFF);
    	grape_seeds 			= new Item().setUnlocalizedName("grapeSeeds").setCreativeTab(StartupCommon.KALSTUFF);
    	grape_soda 				= (ItemSoda) new ItemSoda(2, 2.0f, 600, MobEffects.JUMP_BOOST).setUnlocalizedName("grapeSoda");
    	infused_bacon_core 		= new Item().setUnlocalizedName("infusedBaconCore").setCreativeTab(StartupCommon.KALSTUFF);
    	iron_dagger 			= (ItemDagger) new ItemDagger(Item.ToolMaterial.IRON).setUnlocalizedName("ironDagger").setCreativeTab(StartupCommon.KALSTUFF);
    	jewel_soup 				= (ItemJewelSoup) new ItemJewelSoup(2, 2.0f, 6000, new Potion[] {MobEffects.SPEED, MobEffects.REGENERATION}).setUnlocalizedName("jewelSoup").setCreativeTab(StartupCommon.KALSTUFF);
    	light_coffee			= (ItemCoffee) new ItemCoffee(2, 2.0f, 0, null).setUnlocalizedName("lightCoffee").setCreativeTab(StartupCommon.KALSTUFF);
    	lute					= (ItemLute) new ItemLute().setUnlocalizedName("lute").setCreativeTab(StartupCommon.KALSTUFF);
    	melon_soda 				= (ItemSoda) new ItemSoda(2, 2.0f, 600, MobEffects.HASTE).setUnlocalizedName("melonSoda");
    	plantable_grape_seeds 	= (ItemSeeds) new ItemSeeds(KalStuffBlocks.grape_vine, Blocks.FARMLAND).setUnlocalizedName("plantableGrapeSeeds").setCreativeTab(StartupCommon.KALSTUFF);
    	root_beer 				= (ItemSoda) new ItemSoda(2, 2.0f, 600, MobEffects.FIRE_RESISTANCE).setUnlocalizedName("rootBeer");
    	soda_can 				= new Item().setUnlocalizedName("sodaCan").setCreativeTab(StartupCommon.KALSTUFF);
    	stone_dagger 			= (ItemDagger) new ItemDagger(Item.ToolMaterial.STONE).setUnlocalizedName("stoneDagger").setCreativeTab(StartupCommon.KALSTUFF);
    	tea 					= (ItemTea) new ItemTea(2, 2.0f).setUnlocalizedName("tea").setCreativeTab(StartupCommon.KALSTUFF);
    	walking_stick 			= (ItemWalkingStick) new ItemWalkingStick().setUnlocalizedName("walkingStick").setCreativeTab(StartupCommon.KALSTUFF);
    	wine 					= (ItemWine) new ItemWine(2, 2.0f, 1200, new Potion[] {MobEffects.NAUSEA, MobEffects.BLINDNESS}).setUnlocalizedName("wine").setCreativeTab(StartupCommon.KALSTUFF);
    	wine_bottle 			= new Item().setUnlocalizedName("wineBottle").setCreativeTab(StartupCommon.KALSTUFF);
    	wooden_dagger			= (ItemDagger) new ItemDagger(Item.ToolMaterial.WOOD).setUnlocalizedName("woodenDagger").setCreativeTab(StartupCommon.KALSTUFF);
    	wooden_round_shield 	= (ItemRoundShield) new ItemRoundShield(Item.ToolMaterial.WOOD).setUnlocalizedName("roundWoodenShield").setCreativeTab(StartupCommon.KALSTUFF);
    	
    	
    	// set what items these will return when used. This must happen after_the items are initialized.
      	apple_soda.setReturnStack(soda_can);
      	blaze_soup.setReturnStack(golden_mug);
      	closed_apple_soda.setReturnStack(apple_soda);
      	closed_grape_soda.setReturnStack(grape_soda);
      	closed_melon_soda.setReturnStack(melon_soda);
      	closed_root_beer.setReturnStack(root_beer);
      	coffee.setReturnStack(coffee_mug);
      	grape_soda.setReturnStack(soda_can);
      	jewel_soup.setReturnStack(golden_mug);
      	light_coffee.setReturnStack(coffee_mug);
      	melon_soda.setReturnStack(soda_can);
      	root_beer.setReturnStack(soda_can);
      	tea.setReturnStack(coffee_mug);
      	wine.setReturnStack(wine_bottle);
	}
	
	/**
	 * Registers all items from the mod.
	 */
	public static void registerItems() {
		
		//Please keep all items in alphabetical order!
 		GameRegistry.register(apple_soda.setRegistryName("apple_soda"));
 		GameRegistry.register(bacon_core.setRegistryName("bacon_core"));
 		GameRegistry.register(bacon_wand.setRegistryName("bacon_wand"));
 		GameRegistry.register(blaze_soup.setRegistryName("blaze_soup"));
 		GameRegistry.register(boxing_glove.setRegistryName("boxing_glove"));
 		GameRegistry.register(chocolate_cap.setRegistryName("chocolate_cap"));
 		GameRegistry.register(closed_apple_soda.setRegistryName("closed_apple_soda"));
 		GameRegistry.register(closed_grape_soda.setRegistryName("closed_grape_soda"));
 		GameRegistry.register(closed_melon_soda.setRegistryName("closed_melon_soda"));
		GameRegistry.register(closed_root_beer.setRegistryName("closed_root_beer"));
 		GameRegistry.register(coffee.setRegistryName("coffee"));
 		GameRegistry.register(coffee_mug.setRegistryName("coffee_mug"));
		GameRegistry.register(crushed_ender.setRegistryName("crushed_ender"));
    	GameRegistry.register(diamond_dagger.setRegistryName("diamond_dagger"));
    	GameRegistry.register(golden_dagger.setRegistryName("golden_dagger"));
 		GameRegistry.register(golden_mug.setRegistryName("golden_mug"));
 		GameRegistry.register(grapes.setRegistryName("grapes"));
 		GameRegistry.register(grape_seeds.setRegistryName("grape_seeds"));
 		GameRegistry.register(grape_soda.setRegistryName("grape_soda"));
 		GameRegistry.register(infused_bacon_core.setRegistryName("infused_bacon_core"));
    	GameRegistry.register(iron_dagger.setRegistryName("iron_dagger"));
 		GameRegistry.register(jewel_soup.setRegistryName("jewel_soup"));
 		GameRegistry.register(light_coffee.setRegistryName("light_coffee"));
 		GameRegistry.register(lute.setRegistryName("lute"));
 		GameRegistry.register(melon_soda.setRegistryName("melon_soda"));
 		GameRegistry.register(plantable_grape_seeds.setRegistryName("plantable_grape_seeds"));
 		GameRegistry.register(root_beer.setRegistryName("root_beer"));
 		GameRegistry.register(soda_can.setRegistryName("soda_can"));
    	GameRegistry.register(stone_dagger.setRegistryName("stone_dagger"));
 		GameRegistry.register(tea.setRegistryName("tea"));
 		GameRegistry.register(walking_stick.setRegistryName("walking_stick"));
    	GameRegistry.register(wine.setRegistryName("wine"));
    	GameRegistry.register(wine_bottle.setRegistryName("wine_bottle"));
    	GameRegistry.register(wooden_dagger.setRegistryName("wooden_dagger"));
    	GameRegistry.register(wooden_round_shield.setRegistryName("wooden_round_shield"));
	}
	
	/**
	 * Registers all ItemBlocks from the mod.
	 */
	public static void registerItemBlocks() {

		//Please keep all itemblocks in alphabetical order!
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.apple_block).setRegistryName("apple_block"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.baked_potato_block).setRegistryName("baked_potato_block"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.blaze_block).setRegistryName("blaze_block"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.bridge).setRegistryName("bridge"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.carrot_block).setRegistryName("carrot_block"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.chicken_nest).setRegistryName("chicken_nest"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.ender_block).setRegistryName("ender_block"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.grape_vine).setRegistryName("grape_vine"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.great_grape).setRegistryName("great_grape"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.moon_flower).setRegistryName("moon_flower"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.potato_block).setRegistryName("potato_block"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.trash_can).setRegistryName("trash_can"));
    	GameRegistry.register(new ItemBlock(KalStuffBlocks.wild_grape_vine).setRegistryName("wild_grape_vine"));
	}
}
