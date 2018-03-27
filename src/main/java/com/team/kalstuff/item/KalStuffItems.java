package com.team.kalstuff.item;

import com.team.kalstuff.StartupCommon;
import com.team.kalstuff.block.KalStuffBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder("kalstuff")
@Mod.EventBusSubscriber(modid = "kalstuff")
public class KalStuffItems {

	// ---Please keep all items in alphabetical order!---
	public static final Item apple_soda = Items.AIR;
	public static final Item bacon_core = Items.AIR;
	public static final Item bacon_wand = Items.AIR;
	public static final Item blaze_soup = Items.AIR;
	public static final Item boxing_glove = Items.AIR;
	public static final Item chocolate_cap = Items.AIR;
	public static final Item closed_apple_soda = Items.AIR;
	public static final Item closed_grape_soda = Items.AIR;
	public static final Item closed_melon_soda = Items.AIR;
	public static final Item closed_root_beer = Items.AIR;
	public static final Item coffee = Items.AIR;
	public static final Item coffee_mug = Items.AIR;
	public static final Item crushed_ender = Items.AIR;
	public static final Item diamond_dagger = Items.AIR;
	public static final Item golden_dagger = Items.AIR;
	public static final Item golden_mug = Items.AIR;
	public static final Item grapes = Items.AIR;
	public static final Item grape_seeds = Items.AIR;
	public static final Item grape_soda = Items.AIR;
	public static final Item infused_bacon_core = Items.AIR;
	public static final Item iron_dagger = Items.AIR;
	public static final Item jewel_soup = Items.AIR;
	public static final Item light_coffee = Items.AIR;
	public static final Item lute = Items.AIR;
	public static final Item melon_soda = Items.AIR;
	public static final Item plantable_grape_seeds = Items.AIR;
	public static final Item root_beer = Items.AIR;
	public static final Item soda_can = Items.AIR;
	public static final Item stone_dagger = Items.AIR;	
	public static final Item tea = Items.AIR;
	public static final Item walking_stick = Items.AIR;
	public static final Item wine = Items.AIR;
	public static final Item wine_bottle = Items.AIR;
	public static final Item wooden_dagger = Items.AIR;
	public static final Item wooden_round_shield = Items.AIR;

	/**
	 * Registers all items from the mod.
	 */
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		
		IForgeRegistry<Item> reg = event.getRegistry();
		
		// please continue to keep all items in alphabetical order
				reg.register(new ItemSoda(2, 2.0F, 600, MobEffects.NIGHT_VISION, "apple_soda"));
				reg.register(new ItemKalStuff("bacon_core"));
				reg.register(new ItemBaconWand("bacon_wand"));
				reg.register(new ItemBlazeSoup(2, 2.0F, 6000, "blaze_soup"));
				reg.register(new ItemBoxingGlove("boxing_glove"));
				reg.register(new ItemKalStuff("chocolate_cap"));
				reg.register(new ItemClosedSoda("closed_apple_soda").setReturnStack(apple_soda));
				reg.register(new ItemClosedSoda("closed_grape_soda").setReturnStack(grape_soda));
				reg.register(new ItemClosedSoda("closed_melon_soda").setReturnStack(melon_soda));
				reg.register(new ItemClosedSoda("closed_root_beer").setReturnStack(root_beer));
				reg.register(new ItemCoffee(2, 2.0F, 200, MobEffects.SPEED, "coffee"));
				reg.register(new ItemKalStuff("coffee_mug"));
				reg.register(new ItemEnderPowder("crushed_ender"));
				reg.register(new ItemDagger(Item.ToolMaterial.DIAMOND, "diamond_dagger"));
				reg.register(new ItemDagger(Item.ToolMaterial.GOLD, "golden_dagger"));
				reg.register(new ItemKalStuff("golden_mug"));
				reg.register(new ItemFood(3, 0.5F, false).setRegistryName("grapes").setUnlocalizedName("grapes").setCreativeTab(StartupCommon.KALSTUFF));
				reg.register(new ItemKalStuff("grape_seeds"));
				reg.register(new ItemSoda(2, 2.0F, 600, MobEffects.JUMP_BOOST, "grape_soda"));
				reg.register(new ItemKalStuff("infused_bacon_core"));
				reg.register(new ItemDagger(Item.ToolMaterial.IRON, "iron_dagger"));
				reg.register(new ItemJewelSoup(2, 2.0f, 6000, "jewel_soup"));
				reg.register(new ItemCoffee(2, 2.0F, 0, null, "light_coffee"));
				reg.register(new ItemLute("lute"));
				reg.register(new ItemSoda(2, 2.0F, 600, MobEffects.HASTE, "melon_soda"));
				reg.register(new ItemSeeds(KalStuffBlocks.grape_vine, Blocks.FARMLAND).setRegistryName("plantable_grape_seeds").setUnlocalizedName("plantable_grape_seeds").setCreativeTab(StartupCommon.KALSTUFF));
				reg.register(new ItemSoda(2, 2.0F, 600, MobEffects.STRENGTH, "root_beer"));
				reg.register(new ItemKalStuff("soda_can"));
				reg.register(new ItemDagger(Item.ToolMaterial.STONE, "stone_dagger"));
				reg.register(new ItemTea(2, 2.0F, "tea"));
				reg.register(new ItemWalkingStick("walking_stick"));
				reg.register(new ItemWine(2, 2.0F, 1200, "wine"));
				reg.register(new ItemKalStuff("wine_bottle"));
				reg.register(new ItemDagger(Item.ToolMaterial.WOOD, "wooden_dagger"));
				reg.register(new ItemRoundShield(Item.ToolMaterial.WOOD, "wooden_round_shield"));
		
		registerItemBlocks(reg);
	}
	
	/**
	 * Registers all ItemBlocks from the mod.
	 */
	public static void registerItemBlocks(IForgeRegistry<Item> reg) {
		
		// please keep all itemblocks in alphabetical order
		reg.register(new ItemBlock(KalStuffBlocks.apple_block).setRegistryName("apple_block"));
		reg.register(new ItemBlock(KalStuffBlocks.baked_potato_block).setRegistryName("baked_potato_block"));
		reg.register(new ItemBlock(KalStuffBlocks.blaze_block).setRegistryName("blaze_block"));
		reg.register(new ItemBlock(KalStuffBlocks.bridge).setRegistryName("bridge"));
		reg.register(new ItemBlock(KalStuffBlocks.carrot_block).setRegistryName("carrot_block"));
		reg.register(new ItemBlock(KalStuffBlocks.chicken_nest).setRegistryName("chicken_nest"));
		reg.register(new ItemBlock(KalStuffBlocks.ender_block).setRegistryName("ender_block"));
		reg.register(new ItemBlock(KalStuffBlocks.grape_vine).setRegistryName("grape_vine"));
		reg.register(new ItemBlock(KalStuffBlocks.great_grape).setRegistryName("great_grape"));
		reg.register(new ItemBlock(KalStuffBlocks.moon_flower).setRegistryName("moon_flower"));
		reg.register(new ItemBlock(KalStuffBlocks.potato_block).setRegistryName("potato_block"));
		reg.register(new ItemBlock(KalStuffBlocks.trash_can).setRegistryName("trash_can"));
		reg.register(new ItemBlock(KalStuffBlocks.wild_grape_vine).setRegistryName("wild_grape_vine"));
	}
}
