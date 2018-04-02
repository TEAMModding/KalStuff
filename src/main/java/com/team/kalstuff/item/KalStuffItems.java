package com.team.kalstuff.item;

import com.team.kalstuff.KalStuff;
import com.team.kalstuff.block.KalStuffBlocks;
import com.team.kalstuff.proxy.CommonProxy;

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
public class KalStuffItems
{
	// ---Please keep all items in alphabetical order!--- //
	public static final Item APPLE_SODA = Items.AIR;
	public static final Item BACON_CORE = Items.AIR;
	public static final Item BACON_WAND = Items.AIR;
	public static final Item BLAZE_SOUP = Items.AIR;
	public static final Item BOXING_GLOVE = Items.AIR;
	public static final Item CHOCOLATE_CAP = Items.AIR;
	public static final Item CLOSED_APPLE_SODA = Items.AIR;
	public static final Item CLOSED_GRAPE_SODA = Items.AIR;
	public static final Item CLOSED_MELON_SODA = Items.AIR;
	public static final Item CLOSED_ROOT_BEER = Items.AIR;
	public static final Item COFFEE = Items.AIR;
	public static final Item COFFEE_MUG = Items.AIR;
	public static final Item CRUSHED_ENDER = Items.AIR;
	public static final Item DIAMOND_DAGGER = Items.AIR;
	public static final Item GOLDEN_DAGGER = Items.AIR;
	public static final Item GOLDEN_MUG = Items.AIR;
	public static final Item GRAPES = Items.AIR;
	public static final Item GRAPE_SEEDS = Items.AIR;
	public static final Item GRAPE_SODA = Items.AIR;
	public static final Item INFUSED_BACON_CORE = Items.AIR;
	public static final Item IRON_DAGGER = Items.AIR;
	public static final Item JEWEL_SOUP = Items.AIR;
	public static final Item LIGHT_COFFEE = Items.AIR;
	public static final Item LUTE = Items.AIR;
	public static final Item MELON_SODA = Items.AIR;
	public static final Item PLANTABLE_GRAPE_SEEDS = Items.AIR;
	public static final Item ROOT_BEER = Items.AIR;
	public static final Item SODA_CAN = Items.AIR;
	public static final Item STONE_DAGGER = Items.AIR;
	public static final Item TEA = Items.AIR;
	public static final Item WALKING_STICK = Items.AIR;
	public static final Item WINE = Items.AIR;
	public static final Item WINE_BOTTLE = Items.AIR;
	public static final Item WOODEN_DAGGER = Items.AIR;
	public static final Item WOODEN_ROUND_SHIELD = Items.AIR;

	/**
	 * Registers all items from the mod.
	 */
	@SubscribeEvent
	public static void registerItems(Register<Item> event)
	{
		IForgeRegistry<Item> reg = event.getRegistry();

		// this is the order they will appear in the Creative inventory - sort
		// accordingly

		// weapons and tools
		reg.register(new ItemWalkingStick("walking_stick"));

		reg.register(new ItemDagger(Item.ToolMaterial.WOOD, "wooden_dagger"));
		reg.register(new ItemDagger(Item.ToolMaterial.STONE, "stone_dagger"));
		reg.register(new ItemDagger(Item.ToolMaterial.IRON, "iron_dagger"));
		reg.register(new ItemDagger(Item.ToolMaterial.GOLD, "golden_dagger"));
		reg.register(new ItemDagger(Item.ToolMaterial.DIAMOND, "diamond_dagger"));

		reg.register(new ItemBoxingGlove("boxing_glove"));

		reg.register(new ItemBaconWand("bacon_wand"));
		reg.register(new ItemKalStuff("bacon_core"));
		reg.register(new ItemKalStuff("infused_bacon_core"));
		reg.register(new ItemKalStuff("chocolate_cap"));

		// drinks and foods
		reg.register(new ItemClosedSoda("closed_apple_soda"));
		reg.register(new ItemClosedSoda("closed_grape_soda"));
		reg.register(new ItemClosedSoda("closed_melon_soda"));
		reg.register(new ItemClosedSoda("closed_root_beer"));
		reg.register(new ItemSoda(2, 2.0F, 600, MobEffects.NIGHT_VISION, "apple_soda"));
		reg.register(new ItemSoda(2, 2.0F, 600, MobEffects.JUMP_BOOST, "grape_soda"));
		reg.register(new ItemSoda(2, 2.0F, 600, MobEffects.HASTE, "melon_soda"));
		reg.register(new ItemSoda(2, 2.0F, 600, MobEffects.STRENGTH, "root_beer"));
		reg.register(new ItemKalStuff("soda_can"));

		reg.register(new ItemCoffee(2, 2.0F, 200, MobEffects.SPEED, "coffee"));
		reg.register(new ItemCoffee(2, 2.0F, 0, null, "light_coffee"));
		reg.register(new ItemTea(2, 2.0F, "tea"));
		reg.register(new ItemKalStuff("coffee_mug"));

		reg.register(new ItemWine(2, 2.0F, 1200, "wine"));
		reg.register(new ItemKalStuff("wine_bottle"));

		reg.register(new ItemJewelSoup(2, 2.0f, 6000, "jewel_soup"));
		reg.register(new ItemBlazeSoup(2, 2.0F, 6000, "blaze_soup"));
		reg.register(new ItemKalStuff("golden_mug"));

		reg.register(new ItemFood(3, 0.5F, false).setRegistryName("grapes").setUnlocalizedName(KalStuff.MODID + ":" + "grapes")
				.setCreativeTab(CommonProxy.KALSTUFFTAB));
		reg.register(new ItemSeeds(KalStuffBlocks.GRAPE_VINE, Blocks.FARMLAND).setRegistryName("plantable_grape_seeds")
				.setUnlocalizedName(KalStuff.MODID + ":" + "plantable_grape_seeds").setCreativeTab(CommonProxy.KALSTUFFTAB));
		reg.register(new ItemKalStuff("grape_seeds"));

		// miscellaneous
		reg.register(new ItemEnderPowder("crushed_ender"));

		// ItemBlocks
		registerItemBlocks(reg);

		// prototype and work in progress
		reg.register(new ItemLute("lute"));
		reg.register(new ItemRoundShield(Item.ToolMaterial.WOOD, "wooden_round_shield"));
	}

	/**
	 * Registers all ItemBlocks from the mod.
	 */
	public static void registerItemBlocks(IForgeRegistry<Item> reg)
	{
		// utility blocks
		reg.register(new ItemBlock(KalStuffBlocks.BRIDGE).setRegistryName("bridge"));
		reg.register(new ItemBlock(KalStuffBlocks.CHICKEN_NEST).setRegistryName("chicken_nest"));
		reg.register(new ItemBlock(KalStuffBlocks.TRASH_CAN).setRegistryName("trash_can"));

		// plants
		reg.register(new ItemBlock(KalStuffBlocks.GRAPE_VINE).setRegistryName("grape_vine"));
		reg.register(new ItemBlock(KalStuffBlocks.MOON_FLOWER).setRegistryName("moon_flower"));
		reg.register(new ItemBlock(KalStuffBlocks.WILD_GRAPE_VINE).setRegistryName("wild_grape_vine"));

		// food-based blocks
		reg.register(new ItemBlock(KalStuffBlocks.APPLE_BLOCK).setRegistryName("apple_block"));
		reg.register(new ItemBlock(KalStuffBlocks.CARROT_BLOCK).setRegistryName("carrot_block"));
		reg.register(new ItemBlock(KalStuffBlocks.POTATO_BLOCK).setRegistryName("potato_block"));
		reg.register(new ItemBlock(KalStuffBlocks.BAKED_POTATO_BLOCK).setRegistryName("baked_potato_block"));
		reg.register(new ItemBlock(KalStuffBlocks.GREAT_GRAPE).setRegistryName("great_grape"));

		// compaction blocks
		reg.register(new ItemBlock(KalStuffBlocks.BLAZE_BLOCK).setRegistryName("blaze_block"));
		reg.register(new ItemBlock(KalStuffBlocks.ENDER_BLOCK).setRegistryName("ender_block"));
	}

	/**
	 * Allows for configuration of items after item registry is complete. Use if,
	 * for example, your item needs to access another item.
	 */
	public static void configureItems()
	{
		((ItemClosedSoda) CLOSED_APPLE_SODA).setReturnStack(APPLE_SODA);
		((ItemClosedSoda) CLOSED_GRAPE_SODA).setReturnStack(GRAPE_SODA);
		((ItemClosedSoda) CLOSED_MELON_SODA).setReturnStack(MELON_SODA);
		((ItemClosedSoda) CLOSED_ROOT_BEER).setReturnStack(ROOT_BEER);
		((ItemSoda) APPLE_SODA).setReturnStack(SODA_CAN);
		((ItemSoda) GRAPE_SODA).setReturnStack(SODA_CAN);
		((ItemSoda) MELON_SODA).setReturnStack(SODA_CAN);
		((ItemSoda) ROOT_BEER).setReturnStack(SODA_CAN);
		((ItemCoffee) COFFEE).setReturnStack(COFFEE_MUG);
		((ItemCoffee) LIGHT_COFFEE).setReturnStack(COFFEE_MUG);
		((ItemTea) TEA).setReturnStack(COFFEE_MUG);
		((ItemBlazeSoup) BLAZE_SOUP).setReturnStack(GOLDEN_MUG);
		((ItemJewelSoup) JEWEL_SOUP).setReturnStack(GOLDEN_MUG);
		((ItemWine) WINE).setReturnStack(WINE_BOTTLE);

	}
}
