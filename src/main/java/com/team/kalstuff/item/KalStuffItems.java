package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;
import com.team.kalstuff.block.KalStuffBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class KalStuffItems {

	public static ItemEnderPowder			crushed_ender;
	public static Item						coffee_mug;
	public static ItemCoffee				coffee;
	public static ItemCoffee				light_coffee;
	public static Item						tea;
	public static Item						golden_mug;
	public static ItemJewelSoup				jewel_soup;
	public static ItemBlazeSoup				blaze_soup;
	public static ItemBaconWand				bacon_wand;
	public static Item						chocolate_cap;
	public static Item						bacon_core;
	public static Item						infused_bacon_core;
	public static ItemFood					grapes;
	public static Item						grape_seeds;
	public static ItemSeeds					plantable_grape_seeds;
	public static ItemWalkingStick			walking_stick;
	public static Item						soda_can;
	public static ItemClosedSoda			closed_root_beer;
	public static ItemClosedSoda			closed_melon_soda;
	public static ItemClosedSoda			closed_apple_soda;
	public static ItemClosedSoda			closed_grape_soda;
	public static ItemSoda					root_beer;
	public static ItemSoda					melon_soda;
	public static ItemSoda					apple_soda;
	public static ItemSoda					grape_soda;
	public static ItemDagger				iron_dagger;
	public static ItemDagger				wooden_dagger;
	public static ItemDagger				stone_dagger;
	public static ItemDagger				diamond_dagger;
	public static ItemDagger				golden_dagger;
	public static ItemRoundShield			wooden_round_shield;
	public static Item						wine_bottle;
	public static ItemWine					wine;
	
	
	public static void setup() {
		
		initialize();
		register();
	}
	
	public static void initialize() {
		
		crushed_ender = (ItemEnderPowder) new ItemEnderPowder().setUnlocalizedName("enderPowder").setCreativeTab(StartupCommon.KALSTUFF);
    	coffee_mug = new Item().setUnlocalizedName("coffeeMug").setCreativeTab(StartupCommon.KALSTUFF);
    	coffee = (ItemCoffee) new ItemCoffee(2, 2.0f, false, 200).setAlwaysEdible().setUnlocalizedName("coffee").setCreativeTab(StartupCommon.KALSTUFF);
    	light_coffee = (ItemCoffee) new ItemCoffee(2, 2.0f, false).setAlwaysEdible().setUnlocalizedName("lightCoffee").setCreativeTab(StartupCommon.KALSTUFF);
    	tea = (ItemTea) new ItemTea(2, 2.0f, false).setAlwaysEdible().setUnlocalizedName("tea").setCreativeTab(StartupCommon.KALSTUFF);
    	golden_mug = new Item().setUnlocalizedName("goldenMug").setCreativeTab(StartupCommon.KALSTUFF);
    	jewel_soup = (ItemJewelSoup) new ItemJewelSoup(2, 2.0f, false, 200).setAlwaysEdible().setUnlocalizedName("jewelSoup").setCreativeTab(StartupCommon.KALSTUFF);
    	blaze_soup = (ItemBlazeSoup) new ItemBlazeSoup(2, 2.0f, false).setUnlocalizedName("blazeSoup").setCreativeTab(StartupCommon.KALSTUFF);
    	bacon_wand = (ItemBaconWand) new ItemBaconWand().setUnlocalizedName("baconWand");
    	chocolate_cap = new Item().setUnlocalizedName("chocolateCap").setCreativeTab(StartupCommon.KALSTUFF);
    	bacon_core = new Item().setUnlocalizedName("baconCore").setCreativeTab(StartupCommon.KALSTUFF);
    	infused_bacon_core = new Item().setUnlocalizedName("infusedBaconCore").setCreativeTab(StartupCommon.KALSTUFF);
    	grapes = (ItemFood) new ItemFood(3, 0.5f, false).setUnlocalizedName("grapes").setCreativeTab(StartupCommon.KALSTUFF);
    	grape_seeds = new Item().setUnlocalizedName("grapeSeeds").setCreativeTab(StartupCommon.KALSTUFF);
    	plantable_grape_seeds = (ItemSeeds) new ItemSeeds(KalStuffBlocks.grape_vine, Blocks.FARMLAND).setUnlocalizedName("plantableGrapeSeeds").setCreativeTab(StartupCommon.KALSTUFF);
    	walking_stick = (ItemWalkingStick) new ItemWalkingStick().setUnlocalizedName("walkingStick").setCreativeTab(StartupCommon.KALSTUFF);
    	soda_can = new Item().setUnlocalizedName("sodaCan").setCreativeTab(StartupCommon.KALSTUFF);
    	root_beer = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.FIRE_RESISTANCE).setAlwaysEdible().setUnlocalizedName("rootBeer");
    	melon_soda = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.HASTE).setAlwaysEdible().setUnlocalizedName("melonSoda");
    	apple_soda = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.NIGHT_VISION).setAlwaysEdible().setUnlocalizedName("appleSoda");
    	grape_soda = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.JUMP_BOOST).setAlwaysEdible().setUnlocalizedName("grapeSoda");
      	closed_root_beer = (ItemClosedSoda) new ItemClosedSoda(root_beer).setUnlocalizedName("closedRootBeer").setCreativeTab(StartupCommon.KALSTUFF);
    	closed_melon_soda = (ItemClosedSoda) new ItemClosedSoda(melon_soda).setUnlocalizedName("closedMelonSoda").setCreativeTab(StartupCommon.KALSTUFF);
    	closed_apple_soda = (ItemClosedSoda) new ItemClosedSoda(apple_soda).setUnlocalizedName("closedAppleSoda").setCreativeTab(StartupCommon.KALSTUFF);
    	closed_grape_soda = (ItemClosedSoda) new ItemClosedSoda(grape_soda).setUnlocalizedName("closedGrapeSoda").setCreativeTab(StartupCommon.KALSTUFF);
    	iron_dagger = (ItemDagger) new ItemDagger(Item.ToolMaterial.IRON).setUnlocalizedName("ironDagger").setCreativeTab(StartupCommon.KALSTUFF);
    	wooden_dagger = (ItemDagger) new ItemDagger(Item.ToolMaterial.WOOD).setUnlocalizedName("woodenDagger").setCreativeTab(StartupCommon.KALSTUFF);
    	stone_dagger = (ItemDagger) new ItemDagger(Item.ToolMaterial.STONE).setUnlocalizedName("stoneDagger").setCreativeTab(StartupCommon.KALSTUFF);
    	diamond_dagger = (ItemDagger) new ItemDagger(Item.ToolMaterial.DIAMOND).setUnlocalizedName("diamondDagger").setCreativeTab(StartupCommon.KALSTUFF);
    	golden_dagger = (ItemDagger) new ItemDagger(Item.ToolMaterial.GOLD).setUnlocalizedName("goldenDagger").setCreativeTab(StartupCommon.KALSTUFF);
    	wooden_round_shield = (ItemRoundShield) new ItemRoundShield(Item.ToolMaterial.WOOD).setUnlocalizedName("roundWoodenShield").setCreativeTab(StartupCommon.KALSTUFF);
    	wine = (ItemWine) new ItemWine(2, 2.0f, false, 1200).setAlwaysEdible().setUnlocalizedName("wine").setCreativeTab(StartupCommon.KALSTUFF);
    	wine_bottle = new Item().setUnlocalizedName("wineBottle").setCreativeTab(StartupCommon.KALSTUFF);
	}
	
	public static void register() {
		
		GameRegistry.register(crushed_ender.setRegistryName("crushed_ender"));
 		GameRegistry.register(coffee_mug.setRegistryName("coffee_mug"));
 		GameRegistry.register(coffee.setRegistryName("coffee"));
 		GameRegistry.register(light_coffee.setRegistryName("light_coffee"));
 		GameRegistry.register(tea.setRegistryName("tea"));
 		GameRegistry.register(golden_mug.setRegistryName("golden_mug"));
 		GameRegistry.register(jewel_soup.setRegistryName("jewel_soup"));
 		GameRegistry.register(blaze_soup.setRegistryName("blaze_soup"));
 		GameRegistry.register(bacon_wand.setRegistryName("bacon_wand"));
 		GameRegistry.register(chocolate_cap.setRegistryName("chocolate_cap"));
 		GameRegistry.register(bacon_core.setRegistryName("bacon_core"));
 		GameRegistry.register(infused_bacon_core.setRegistryName("infused_bacon_core"));
 		GameRegistry.register(grapes.setRegistryName("grapes"));
 		GameRegistry.register(grape_seeds.setRegistryName("grape_seeds"));
 		GameRegistry.register(plantable_grape_seeds.setRegistryName("plantable_grape_seeds"));
 		GameRegistry.register(walking_stick.setRegistryName("walking_stick"));
 		GameRegistry.register(soda_can.setRegistryName("soda_can"));
 		GameRegistry.register(root_beer.setRegistryName("root_beer"));
 		GameRegistry.register(melon_soda.setRegistryName("melon_soda"));
 		GameRegistry.register(apple_soda.setRegistryName("apple_soda"));
 		GameRegistry.register(grape_soda.setRegistryName("grape_soda"));
 		GameRegistry.register(closed_root_beer.setRegistryName("closed_root_beer"));
 		GameRegistry.register(closed_melon_soda.setRegistryName("closed_melon_soda"));
 		GameRegistry.register(closed_apple_soda.setRegistryName("closed_apple_soda"));
 		GameRegistry.register(closed_grape_soda.setRegistryName("closed_grape_soda"));
    	GameRegistry.register(iron_dagger.setRegistryName("iron_dagger"));
    	GameRegistry.register(wooden_dagger.setRegistryName("wooden_dagger"));
    	GameRegistry.register(stone_dagger.setRegistryName("stone_dagger"));
    	GameRegistry.register(diamond_dagger.setRegistryName("diamond_dagger"));
    	GameRegistry.register(golden_dagger.setRegistryName("golden_dagger"));
    	GameRegistry.register(wooden_round_shield.setRegistryName("wooden_round_shield"));
    	GameRegistry.register(wine.setRegistryName("wine"));
    	GameRegistry.register(wine_bottle.setRegistryName("wine_bottle"));
	}
}
