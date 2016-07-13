
package com.team.kalstuff;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.team.KalStuff;
import com.team.kalstuff.block.BlockApple;
import com.team.kalstuff.block.BlockBakedPotato;
import com.team.kalstuff.block.BlockBlaze;
import com.team.kalstuff.block.BlockBridge;
import com.team.kalstuff.block.BlockCarrot;
import com.team.kalstuff.block.BlockChickenNest;
import com.team.kalstuff.block.BlockEnder;
import com.team.kalstuff.block.BlockGrapeVine;
import com.team.kalstuff.block.BlockMoonFlower;
import com.team.kalstuff.block.BlockPotato;
import com.team.kalstuff.block.BlockTrashCan;
import com.team.kalstuff.block.BlockWildGrapeVine;
import com.team.kalstuff.item.ItemBaconWand;
import com.team.kalstuff.item.ItemBlazeSoup;
import com.team.kalstuff.item.ItemClosedSoda;
import com.team.kalstuff.item.ItemCoffee;
import com.team.kalstuff.item.ItemEnderPowder;
import com.team.kalstuff.item.ItemJewelSoup;
import com.team.kalstuff.item.ItemSoda;
import com.team.kalstuff.item.ItemTea;
import com.team.kalstuff.item.ItemWalkingStick;
import com.team.kalstuff.tileentity.TileEntityChickenNest;
import com.team.kalstuff.tileentity.TileEntityMoonFlower;
import com.team.kalstuff.worldgen.WorldGenGrapeVine;
import com.team.kalstuff.worldgen.WorldGenMoonFlower;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon {
	
	public static final CreativeTabs KALSTUFF = new KalStuffCreativeTab("kalstuffTab");
	public static final Logger log = LogManager.getLogger(KalStuff.MODID);
	
	public static BlockBridge				bridge;
	public static BlockEnder				ender_block;
	public static BlockBlaze				blaze_block;
	public static BlockCarrot				carrot_block;
	public static BlockApple				apple_block;
	public static BlockPotato				potato_block;
	public static BlockBakedPotato			baked_potato_block;
	public static BlockChickenNest			chicken_nest;
	public static BlockTrashCan				trash_can;
	public static BlockWildGrapeVine		wild_grape_vine;
	public static BlockGrapeVine			grape_vine;
	public static BlockMoonFlower			moon_flower;
	public static BlockMoonFlower			moon_flower1;
	public static BlockMoonFlower			moon_flower2;
	public static BlockMoonFlower			moon_flower3;
	public static BlockMoonFlower			moon_flower4;
	public static BlockMoonFlower			moon_flower5;
	
	public static ItemEnderPowder			ender_powder;
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
	public static ItemSeeds					grape_seeds;
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

	public static void preInitCommon() {
		
		ModSoundEvents.registerSounds();
		
    	bridge = (BlockBridge) new BlockBridge().setUnlocalizedName("bridge");
    	ender_block = (BlockEnder) new BlockEnder().setUnlocalizedName("blockEnder");
    	blaze_block = (BlockBlaze) new BlockBlaze().setUnlocalizedName("blockBlaze");
    	carrot_block = (BlockCarrot) new BlockCarrot().setUnlocalizedName("blockCarrot");
    	apple_block = (BlockApple) new BlockApple().setUnlocalizedName("blockApple");
    	potato_block = (BlockPotato) new BlockPotato().setUnlocalizedName("blockPotato");
    	baked_potato_block = (BlockBakedPotato) new BlockBakedPotato().setUnlocalizedName("blockBakedPotato");
    	chicken_nest = (BlockChickenNest) new BlockChickenNest().setUnlocalizedName("chickenNest");
    	trash_can = (BlockTrashCan) new BlockTrashCan().setUnlocalizedName("trashCan");
    	wild_grape_vine = (BlockWildGrapeVine) new BlockWildGrapeVine().setUnlocalizedName("wildGrapeVine");
    	grape_vine = (BlockGrapeVine) new BlockGrapeVine().setUnlocalizedName("grapeVine");
    	
    	moon_flower = (BlockMoonFlower) new BlockMoonFlower(0).setUnlocalizedName("moonFlower").setCreativeTab(KALSTUFF);
    	moon_flower1 = (BlockMoonFlower) new BlockMoonFlower(1).setUnlocalizedName("moonFlower").setCreativeTab(null);
    	moon_flower2 = (BlockMoonFlower) new BlockMoonFlower(2).setUnlocalizedName("moonFlower").setCreativeTab(null);
    	moon_flower3 = (BlockMoonFlower) new BlockMoonFlower(3).setUnlocalizedName("moonFlower").setCreativeTab(null);
    	moon_flower4 = (BlockMoonFlower) new BlockMoonFlower(4).setUnlocalizedName("moonFlower").setCreativeTab(null);
    	moon_flower5 = (BlockMoonFlower) new BlockMoonFlower(5).setUnlocalizedName("moonFlower").setCreativeTab(null);
    	
    	
    	GameRegistry.register(bridge.setRegistryName("bridge"));
    	GameRegistry.register(new ItemBlock(bridge).setRegistryName("bridge"));
    	
    	GameRegistry.register(ender_block.setRegistryName("blockEnder"));
    	GameRegistry.register(new ItemBlock(ender_block).setRegistryName("blockEnder"));
    	
    	GameRegistry.register(blaze_block.setRegistryName("blockBlaze"));
    	GameRegistry.register(new ItemBlock(blaze_block).setRegistryName("blockBlaze"));
    	
    	GameRegistry.register(carrot_block.setRegistryName("blockCarrot"));
    	GameRegistry.register(new ItemBlock(carrot_block).setRegistryName("blockCarrot"));
    	
    	GameRegistry.register(apple_block.setRegistryName("blockApple"));
    	GameRegistry.register(new ItemBlock(apple_block).setRegistryName("blockApple"));
    	
    	GameRegistry.register(potato_block.setRegistryName("blockPotato"));
    	GameRegistry.register(new ItemBlock(potato_block).setRegistryName("blockPotato"));
    	
    	GameRegistry.register(baked_potato_block.setRegistryName("blockBakedPotato"));
    	GameRegistry.register(new ItemBlock(baked_potato_block).setRegistryName("blockBakedPotato"));
    	
    	GameRegistry.register(chicken_nest.setRegistryName("chickenNest"));
    	GameRegistry.register(new ItemBlock(chicken_nest).setRegistryName("chickenNest"));
    	
    	GameRegistry.register(trash_can.setRegistryName("trashCan"));
    	GameRegistry.register(new ItemBlock(trash_can).setRegistryName("trashCan"));
    	
    	GameRegistry.register(wild_grape_vine.setRegistryName("wildGrapeVine"));
    	GameRegistry.register(new ItemBlock(wild_grape_vine).setRegistryName("wildGrapeVine"));
    	
    	GameRegistry.register(grape_vine.setRegistryName("grapeVine"));
    	GameRegistry.register(new ItemBlock(grape_vine).setRegistryName("grapeVine"));
    	
    	GameRegistry.register(moon_flower.setRegistryName("moonFlower"));
    	GameRegistry.register(moon_flower1.setRegistryName("moonFlower1"));
    	GameRegistry.register(moon_flower2.setRegistryName("moonFlower2"));
    	GameRegistry.register(moon_flower3.setRegistryName("moonFlower3"));
    	GameRegistry.register(moon_flower4.setRegistryName("moonFlower4"));
    	GameRegistry.register(moon_flower5.setRegistryName("moonFlower5"));
    	GameRegistry.register(new ItemBlock(moon_flower).setRegistryName("moonFlower"));
    	
    	ender_powder = (ItemEnderPowder) new ItemEnderPowder().setUnlocalizedName("enderPowder").setCreativeTab(KALSTUFF);
    	coffee_mug = new Item().setUnlocalizedName("coffeeMug").setCreativeTab(KALSTUFF);
    	coffee = (ItemCoffee) new ItemCoffee(2, 2.0f, false, 200).setAlwaysEdible().setUnlocalizedName("coffee").setCreativeTab(KALSTUFF);
    	light_coffee = (ItemCoffee) new ItemCoffee(2, 2.0f, false).setAlwaysEdible().setUnlocalizedName("lightCoffee").setCreativeTab(KALSTUFF);
    	tea = (ItemTea) new ItemTea(2, 2.0f, false).setAlwaysEdible().setUnlocalizedName("tea").setCreativeTab(KALSTUFF);
    	golden_mug = new Item().setUnlocalizedName("goldenMug").setCreativeTab(KALSTUFF);
    	jewel_soup = (ItemJewelSoup) new ItemJewelSoup(2, 2.0f, false, 200).setAlwaysEdible().setUnlocalizedName("jewelSoup").setCreativeTab(KALSTUFF);
    	blaze_soup = (ItemBlazeSoup) new ItemBlazeSoup(2, 2.0f, false).setUnlocalizedName("blazeSoup").setCreativeTab(KALSTUFF);
    	bacon_wand = (ItemBaconWand) new ItemBaconWand().setUnlocalizedName("baconWand");
    	chocolate_cap = new Item().setUnlocalizedName("chocolateCap").setCreativeTab(KALSTUFF);
    	bacon_core = new Item().setUnlocalizedName("baconCore").setCreativeTab(KALSTUFF);
    	infused_bacon_core = new Item().setUnlocalizedName("infusedBaconCore").setCreativeTab(KALSTUFF);
    	grapes = (ItemFood) new ItemFood(3, 0.5f, false).setUnlocalizedName("grapes").setCreativeTab(KALSTUFF);
    	grape_seeds = (ItemSeeds) new ItemSeeds(grape_vine, Blocks.FARMLAND).setUnlocalizedName("grapeSeeds").setCreativeTab(KALSTUFF);
    	walking_stick = (ItemWalkingStick) new ItemWalkingStick().setUnlocalizedName("walkingStick").setCreativeTab(KALSTUFF);
    	soda_can = new Item().setUnlocalizedName("sodaCan").setCreativeTab(KALSTUFF);
    	root_beer = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.FIRE_RESISTANCE).setAlwaysEdible().setUnlocalizedName("rootBeer").setCreativeTab(KALSTUFF);
    	melon_soda = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.HASTE).setAlwaysEdible().setUnlocalizedName("melonSoda").setCreativeTab(KALSTUFF);
    	apple_soda = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.NIGHT_VISION).setAlwaysEdible().setUnlocalizedName("appleSoda").setCreativeTab(KALSTUFF);
    	grape_soda = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.JUMP_BOOST).setAlwaysEdible().setUnlocalizedName("grapeSoda").setCreativeTab(KALSTUFF);
      	closed_root_beer = (ItemClosedSoda) new ItemClosedSoda(root_beer).setUnlocalizedName("closedRootBeer").setCreativeTab(KALSTUFF);
    	closed_melon_soda = (ItemClosedSoda) new ItemClosedSoda(melon_soda).setUnlocalizedName("closedMelonSoda").setCreativeTab(KALSTUFF);
    	closed_apple_soda = (ItemClosedSoda) new ItemClosedSoda(apple_soda).setUnlocalizedName("closedAppleSoda").setCreativeTab(KALSTUFF);
    	closed_grape_soda = (ItemClosedSoda) new ItemClosedSoda(grape_soda).setUnlocalizedName("closedGrapeSoda").setCreativeTab(KALSTUFF);

    	GameRegistry.register(ender_powder.setRegistryName("enderPowder"));
 		GameRegistry.register(coffee_mug.setRegistryName("coffeeMug"));
 		GameRegistry.register(coffee.setRegistryName("coffee"));
 		GameRegistry.register(light_coffee.setRegistryName("lightCoffee"));
 		GameRegistry.register(tea.setRegistryName("tea"));
 		GameRegistry.register(golden_mug.setRegistryName("goldenMug"));
 		GameRegistry.register(jewel_soup.setRegistryName("jewelSoup"));
 		GameRegistry.register(blaze_soup.setRegistryName("blazeSoup"));
 		GameRegistry.register(bacon_wand.setRegistryName("baconWand"));
 		GameRegistry.register(chocolate_cap.setRegistryName("chocolateCap"));
 		GameRegistry.register(bacon_core.setRegistryName("baconCore"));
 		GameRegistry.register(infused_bacon_core.setRegistryName("infusedBaconCore"));
 		GameRegistry.register(grapes.setRegistryName("grapes"));
 		GameRegistry.register(grape_seeds.setRegistryName("grapeSeeds"));
 		GameRegistry.register(walking_stick.setRegistryName("walkingStick"));
 		GameRegistry.register(soda_can.setRegistryName("sodaCan"));
 		GameRegistry.register(root_beer.setRegistryName("rootBeer"));
 		GameRegistry.register(melon_soda.setRegistryName("melonSoda"));
 		GameRegistry.register(apple_soda.setRegistryName("appleSoda"));
 		GameRegistry.register(grape_soda.setRegistryName("grapeSoda"));
 		GameRegistry.register(closed_root_beer.setRegistryName("closedRootBeer"));
 		GameRegistry.register(closed_melon_soda.setRegistryName("closedMelonSoda"));
 		GameRegistry.register(closed_apple_soda.setRegistryName("closedAppleSoda"));
 		GameRegistry.register(closed_grape_soda.setRegistryName("closedGrapeSoda"));
    	
 		
    	GameRegistry.registerWorldGenerator(new WorldGenGrapeVine(), 1);
    	GameRegistry.registerWorldGenerator(new WorldGenMoonFlower(), 1);
    	
    	
    	GameRegistry.registerTileEntity(TileEntityChickenNest.class, "ChickenNest");
    	GameRegistry.registerTileEntity(TileEntityMoonFlower.class, "MoonFlower");

		NetworkRegistry.INSTANCE.registerGuiHandler(KalStuff.instance, new KalStuffGuiHandler());
	}

	public static void initCommon() {
		log.info("Hi there, nerdy geeks. You should just enjoy Minecraft and stop looking at the system output.");
		KalStuffRecipes.add();
		
		CoreEventHandler events = new CoreEventHandler();
		MinecraftForge.EVENT_BUS.register(events);
	}

	public static void postInitCommon() {
		log.info("Wait a minute... Guys! IT WORKS!?! WE MADE A MOD!!!");
	}
}