
package com.team.kalstuff;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

import com.team.KalStuff;
import com.team.kalstuff.block.*;
import com.team.kalstuff.item.*;
import com.team.kalstuff.tileentity.*;
import com.team.kalstuff.worldgen.WorldGenGrapeVine;
import com.team.kalstuff.worldgen.WorldGenMoonFlower;
import com.team.kalstuff.structure.*;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupCommon {
	public static BlockBridge blockBridge;
	// public static BlockSquidMat blockSquidMat;
	public static BlockEnder blockEnder;
	public static BlockBlaze blockBlaze;
	public static BlockCarrot blockCarrot;
	public static BlockApple blockApple;
	public static BlockPotato blockPotato;
	public static BlockBakedPotato blockBakedPotato;
	public static BlockChickenNest blockChickenNest;
	public static BlockTrashCan blockTrashCan;
	public static BlockWildGrapeVine blockWildGrapeVine;
	public static BlockGrapeVine blockGrapeVine;
	public static BlockMoonFlower blockMoonFlower;
	public static BlockMoonFlower blockMoonFlower1;
	public static BlockMoonFlower blockMoonFlower2;
	public static BlockMoonFlower blockMoonFlower3;
	public static BlockMoonFlower blockMoonFlower4;
	public static BlockMoonFlower blockMoonFlower5;
	public static BlockLockedChest blockLockedChest;

	public static Item itemEnderPowder;
	public static ItemCoffee itemCoffee;
	public static ItemJewelSoup itemJewelSoup;
	public static Item itemCoffeeMug;
	public static Item itemGoldenMug;
	public static Item itemSodaCan;
	public static ItemSoda itemRootBeer;
	public static ItemSoda itemMelonSoda;
	public static ItemSoda itemAppleSoda;
	public static ItemSoda itemGrapeSoda;
	public static ItemBlazeSoup itemBlazeSoup;
	public static Item itemTea;
	public static ItemCoffee itemLightCoffee;
	public static ItemBaconWand itemBaconWand;
	public static Item itemChocolateCap;
	public static Item itemBaconCore;
	public static Item itemInfusedBaconCore;
	public static ItemFood itemGrapes;
	public static ItemSeeds itemGrapeSeeds;
	public static ItemWalkingStick itemWalkingStick;
	public static ItemClosedSoda itemClosedRootBeer;
	public static ItemClosedSoda itemClosedMelonSoda;
	public static ItemClosedSoda itemClosedAppleSoda;
	public static ItemClosedSoda itemClosedGrapeSoda;

	public static CreativeTabs kalStuffTab = new KalStuffCreativeTab("kalStuffTab");

	public static void preInitCommon() {
		
		ModSoundEvents.registerSounds();
		
		// ClientCommandHandler.instance.registerCommand(new CommandWorldGen());
		
    	//blockBridge = (BlockBridge) new BlockBridge().setUnlocalizedName("blockBridge");
    	blockEnder = (BlockEnder) new BlockEnder().setUnlocalizedName("blockEnder");
    	blockBlaze = (BlockBlaze) new BlockBlaze().setUnlocalizedName("blockBlaze");
    	blockCarrot = (BlockCarrot) new BlockCarrot().setUnlocalizedName("blockCarrot");
    	blockApple = (BlockApple) new BlockApple().setUnlocalizedName("blockApple");
    	blockPotato = (BlockPotato) new BlockPotato().setUnlocalizedName("blockPotato");
    	//blockBakedPotato = (BlockBakedPotato) new BlockBakedPotato().setUnlocalizedName("blockBakedPotato");
    	blockChickenNest = (BlockChickenNest) new BlockChickenNest().setUnlocalizedName("blockChickenNest");
    	blockTrashCan = (BlockTrashCan) new BlockTrashCan().setUnlocalizedName("trashCan");
    	//blockWildGrapeVine = (BlockWildGrapeVine) new BlockWildGrapeVine().setUnlocalizedName("blockWildGrapeVine");
    	blockGrapeVine = (BlockGrapeVine) new BlockGrapeVine().setUnlocalizedName("blockGrapeVine");
    	//blockMoonFlower = (BlockMoonFlower) new BlockMoonFlower(0).setUnlocalizedName("blockMoonFlower").setCreativeTab(kalStuffTab);
    	//blockMoonFlower1 = (BlockMoonFlower) new BlockMoonFlower(4).setUnlocalizedName("blockMoonFlower").setCreativeTab(null);
    	//blockMoonFlower2 = (BlockMoonFlower) new BlockMoonFlower(6).setUnlocalizedName("blockMoonFlower").setCreativeTab(null);
    	//blockMoonFlower3 = (BlockMoonFlower) new BlockMoonFlower(8).setUnlocalizedName("blockMoonFlower").setCreativeTab(null);
    	//blockMoonFlower4 = (BlockMoonFlower) new BlockMoonFlower(10).setUnlocalizedName("blockMoonFlower").setCreativeTab(null);
    	//blockMoonFlower5 = (BlockMoonFlower) new BlockMoonFlower(12).setUnlocalizedName("blockMoonFlower").setCreativeTab(null);
    	//blockLockedChest = (BlockLockedChest) new BlockLockedChest(0).setUnlocalizedName("blockLockedChest");
    	
    	
    	//GameRegistry.registerBlock(blockBridge, "blockBridge");
    	
    	GameRegistry.register(blockEnder.setRegistryName("blockEnder"));
    	GameRegistry.register(new ItemBlock(blockEnder).setRegistryName("blockEnder"));
    	
    	GameRegistry.register(blockBlaze.setRegistryName("blockBlaze"));
    	GameRegistry.register(new ItemBlock(blockBlaze).setRegistryName("blockBlaze"));
    	
    	GameRegistry.register(blockCarrot.setRegistryName("blockCarrot"));
    	GameRegistry.register(new ItemBlock(blockCarrot).setRegistryName("blockCarrot"));
    	
    	GameRegistry.register(blockApple.setRegistryName("blockApple"));
    	GameRegistry.register(new ItemBlock(blockApple).setRegistryName("blockApple"));
    	
    	GameRegistry.register(blockPotato.setRegistryName("blockPotato"));
    	GameRegistry.register(new ItemBlock(blockPotato).setRegistryName("blockPotato"));
    	
    	//GameRegistry.registerBlock(blockBakedPotato, "blockBakedPotato");
    	
    	GameRegistry.register(blockChickenNest.setRegistryName("blockChickenNest"));
    	GameRegistry.register(new ItemBlock(blockChickenNest).setRegistryName("blockChickenNest"));
    	
    	GameRegistry.register(blockTrashCan.setRegistryName("blockTrashCan"));
    	GameRegistry.register(new ItemBlock(blockTrashCan).setRegistryName("blockTrashCan"));
    	
    	//GameRegistry.registerBlock(blockWildGrapeVine, "blockWildGrapeVine");
    	
    	GameRegistry.register(blockGrapeVine.setRegistryName("blockGrapeVine"));
    	GameRegistry.register(new ItemBlock(blockGrapeVine).setRegistryName("blockGrapeVine"));
    	
    	//GameRegistry.registerBlock(blockMoonFlower,  "blockMoonFlower");
    	//GameRegistry.registerBlock(blockMoonFlower1,  "blockMoonFlower1");
    	//GameRegistry.registerBlock(blockMoonFlower2,  "blockMoonFlower2");
    	//GameRegistry.registerBlock(blockMoonFlower3,  "blockMoonFlower3");
    	//GameRegistry.registerBlock(blockMoonFlower4,  "blockMoonFlower4");
    	//GameRegistry.registerBlock(blockMoonFlower5,  "blockMoonFlower5");
    	//GameRegistry.registerBlock(blockLockedChest, "blockLockedChest");
    	
    	itemEnderPowder = new Item().setUnlocalizedName("itemEnderPowder").setCreativeTab(kalStuffTab);
    	itemCoffeeMug = new Item().setUnlocalizedName("itemCoffeeMug").setCreativeTab(kalStuffTab);
    	itemCoffee = (ItemCoffee) new ItemCoffee(2, 2.0f, false, 200).setAlwaysEdible().setUnlocalizedName("itemCoffee").setCreativeTab(kalStuffTab);
    	itemLightCoffee = (ItemCoffee) new ItemCoffee(2, 2.0f, false).setAlwaysEdible().setUnlocalizedName("itemLightCoffee").setCreativeTab(kalStuffTab);
    	itemTea = (ItemTea) new ItemTea(2, 2.0f, false).setAlwaysEdible().setUnlocalizedName("itemTea").setCreativeTab(kalStuffTab);
    	itemGoldenMug = new Item().setUnlocalizedName("itemGoldenMug").setCreativeTab(kalStuffTab);
    	itemJewelSoup = (ItemJewelSoup) new ItemJewelSoup(2, 2.0f, false, 200).setAlwaysEdible().setUnlocalizedName("itemJewelSoup").setCreativeTab(kalStuffTab);
    	itemBlazeSoup = (ItemBlazeSoup) new ItemBlazeSoup(2, 2.0f, false).setUnlocalizedName("itemBlazeSoup").setCreativeTab(kalStuffTab);
    	 itemBaconWand = (ItemBaconWand) new ItemBaconWand().setUnlocalizedName("itemBaconWand");
    	 itemChocolateCap = new Item().setUnlocalizedName("itemChocolateCap").setCreativeTab(kalStuffTab);
    	 itemBaconCore = new Item().setUnlocalizedName("itemBaconCore").setCreativeTab(kalStuffTab);
    	 itemInfusedBaconCore = new Item().setUnlocalizedName("itemInfusedBaconCore").setCreativeTab(kalStuffTab);
    	 itemGrapes = (ItemFood) new ItemFood(3, 0.5f, false).setUnlocalizedName("itemGrapes").setCreativeTab(kalStuffTab);
    	 itemGrapeSeeds = (ItemSeeds) new ItemSeeds(blockGrapeVine, Blocks.FARMLAND).setUnlocalizedName("itemGrapeSeeds").setCreativeTab(kalStuffTab);
    	 itemWalkingStick = (ItemWalkingStick) new ItemWalkingStick().setUnlocalizedName("itemWalkingStick").setCreativeTab(kalStuffTab);
    	 itemSodaCan = new Item().setUnlocalizedName("itemSodaCan").setCreativeTab(kalStuffTab);
    	 itemRootBeer = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.FIRE_RESISTANCE).setAlwaysEdible().setUnlocalizedName("itemRootBeer").setCreativeTab(kalStuffTab);
    	 itemAppleSoda = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.NIGHT_VISION).setAlwaysEdible().setUnlocalizedName("itemAppleSoda").setCreativeTab(kalStuffTab);
    	 itemMelonSoda = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.HASTE).setAlwaysEdible().setUnlocalizedName("itemMelonSoda").setCreativeTab(kalStuffTab);
    	 itemGrapeSoda = (ItemSoda) new ItemSoda(2, 2.0f, false, 600, MobEffects.JUMP_BOOST).setAlwaysEdible().setUnlocalizedName("itemGrapeSoda").setCreativeTab(kalStuffTab);
      	 itemClosedRootBeer = (ItemClosedSoda) new ItemClosedSoda(itemRootBeer).setUnlocalizedName("itemRootBeer.closed").setCreativeTab(kalStuffTab);
    	 itemClosedAppleSoda = (ItemClosedSoda) new ItemClosedSoda(itemAppleSoda).setUnlocalizedName("itemAppleSoda.closed").setCreativeTab(kalStuffTab);
    	 itemClosedMelonSoda = (ItemClosedSoda) new ItemClosedSoda(itemMelonSoda).setUnlocalizedName("itemMelonSoda.closed").setCreativeTab(kalStuffTab);
    	 itemClosedGrapeSoda = (ItemClosedSoda) new ItemClosedSoda(itemGrapeSoda).setUnlocalizedName("itemGrapeSoda.closed").setCreativeTab(kalStuffTab);

    	GameRegistry.register(itemEnderPowder.setRegistryName("itemEnderPowder"));
 		GameRegistry.register(itemCoffee.setRegistryName("itemCoffee"));
 		GameRegistry.register(itemJewelSoup.setRegistryName("itemJewelSoup"));
 		GameRegistry.register(itemLightCoffee.setRegistryName("itemLightCoffee"));
 		GameRegistry.register(itemTea.setRegistryName("itemTea"));
 		GameRegistry.register(itemCoffeeMug.setRegistryName("itemCoffeeMug"));
 		GameRegistry.register(itemGoldenMug.setRegistryName("itemGoldenMug"));
 		
 		GameRegistry.register(itemBaconWand.setRegistryName("itemBaconWand"));
 		GameRegistry.register(itemChocolateCap.setRegistryName("itemChocolateCap"));
 		GameRegistry.register(itemBaconCore.setRegistryName("itemBaconCore"));
 		GameRegistry.register(itemInfusedBaconCore.setRegistryName("itemInfusedBaconCore"));
 		GameRegistry.register(itemGrapes.setRegistryName("itemGrapes"));
 		GameRegistry.register(itemGrapeSeeds.setRegistryName("itemGrapeSeeds"));
 		GameRegistry.register(itemBlazeSoup.setRegistryName("itemBlazeSoup"));

 		GameRegistry.register(itemWalkingStick.setRegistryName("itemWalkingStick"));

 		GameRegistry.register(itemSodaCan.setRegistryName("itemSodaCan"));
 		GameRegistry.register(itemRootBeer.setRegistryName("itemRootBeer"));
 		GameRegistry.register(itemAppleSoda.setRegistryName("itemAppleSoda"));
 		GameRegistry.register(itemMelonSoda.setRegistryName("itemMelonSoda"));
 		GameRegistry.register(itemGrapeSoda.setRegistryName("itemGrapeSoda"));
 		GameRegistry.register(itemClosedRootBeer.setRegistryName("ItemClosedRootBeer"));
 		GameRegistry.register(itemClosedAppleSoda.setRegistryName("ItemClosedAppleSoda"));
 		GameRegistry.register(itemClosedMelonSoda.setRegistryName("ItemClosedMelonSoda"));
 		GameRegistry.register(itemClosedGrapeSoda.setRegistryName("ItemClosedGrapeSoda"));
    	 
		// GameRegistry.registerWorldGenerator(new WorldGenGrapeVine(), 1);
		// GameRegistry.registerWorldGenerator(new WorldGenMoonFlower(), 1);

		// GameRegistry.registerTileEntity(TileEntityMoonFlower.class,
		// "tileEntityMoonFlower");
    	 //GameRegistry.registerWorldGenerator(new StructureFile("cottage", KalStuff.cottageRarity), 1);
    	 
    	 //GameRegistry.registerWorldGenerator(new WorldGenGrapeVine(), 1);
    	 //GameRegistry.registerWorldGenerator(new WorldGenMoonFlower(), 1);
    	 
    	 
    	 GameRegistry.registerTileEntity(TileEntityChickenNest.class, "tileEntityChickenNest");
    	 //GameRegistry.registerTileEntity(TileEntityMoonFlower.class, "tileEntityMoonFlower");

		NetworkRegistry.INSTANCE.registerGuiHandler(KalStuff.instance, new KalStuffGuiHandler());
	}

	public static void initCommon() {
		System.out.println(
				"Hi there, nerdy geeks. You should just enjoy Minecraft and stop looking at the system output.");

		// KalStuffRecipes.add();

		CoreEventHandler events = new CoreEventHandler();
		MinecraftForge.EVENT_BUS.register(events);

		/*
		 * if (!Files.exists(Paths.get("worldgen-export"),
		 * LinkOption.NOFOLLOW_LINKS)) { try {
		 * Files.createDirectory(Paths.get("worldgen-export"), new
		 * FileAttribute[] {}); } catch (IOException e) { e.printStackTrace(); }
		 * }
		 */

	}

	public static void postInitCommon() {
		System.out.println("Wait a minute... Guys! IT WORKS!?! WE MADE A MOD!!!");
	}
}