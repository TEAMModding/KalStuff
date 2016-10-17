package com.team.kalstuff.block;

import com.team.kalstuff.StartupCommon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class KalStuffBlocks {

	public static BlockBridge				bridge;
	public static Block						ender_block;
	public static Block						blaze_block;
	public static BlockFood					carrot_block;
	public static BlockFood					apple_block;
	public static BlockFood					potato_block;
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
	public static Block						great_grape;
	
	
	public static void setup() {
		
		initialize();
		register();
	}
	
	public static void initialize() {
		
		bridge = (BlockBridge) new BlockBridge().setUnlocalizedName("bridge");
    	ender_block = new Block(Material.ROCK).setUnlocalizedName("blockEnder").setHardness(5.0F).setCreativeTab(StartupCommon.KALSTUFF);
    	blaze_block = new Block(Material.IRON).setUnlocalizedName("blockBlaze").setHardness(35.0F).setCreativeTab(StartupCommon.KALSTUFF);
    	carrot_block = (BlockFood) new BlockFood(1.5F, 7, 4.8F).setUnlocalizedName("blockCarrot").setCreativeTab(StartupCommon.KALSTUFF);
    	apple_block = (BlockFood) new BlockFood(1.5F, 9, 2.4F).setUnlocalizedName("blockApple").setCreativeTab(StartupCommon.KALSTUFF);
    	potato_block = (BlockFood) new BlockFood(1.5F, 3, 0.6F).setUnlocalizedName("blockPotato").setCreativeTab(StartupCommon.KALSTUFF);
    	baked_potato_block = (BlockBakedPotato) new BlockBakedPotato(1.5F, 11, 6F).setUnlocalizedName("blockBakedPotato").setCreativeTab(StartupCommon.KALSTUFF);
    	chicken_nest = (BlockChickenNest) new BlockChickenNest().setUnlocalizedName("chickenNest");
    	trash_can = (BlockTrashCan) new BlockTrashCan().setUnlocalizedName("trashCan");
    	wild_grape_vine = (BlockWildGrapeVine) new BlockWildGrapeVine().setUnlocalizedName("wildGrapeVine");
    	grape_vine = (BlockGrapeVine) new BlockGrapeVine().setUnlocalizedName("grapeVine");
    	great_grape = new Block(Material.SPONGE).setUnlocalizedName("greatGrape").setCreativeTab(StartupCommon.KALSTUFF);
    	
    	moon_flower = (BlockMoonFlower) new BlockMoonFlower(0).setUnlocalizedName("moonFlower").setCreativeTab(StartupCommon.KALSTUFF);
    	moon_flower1 = (BlockMoonFlower) new BlockMoonFlower(1).setUnlocalizedName("moonFlower").setCreativeTab(null);
    	moon_flower2 = (BlockMoonFlower) new BlockMoonFlower(2).setUnlocalizedName("moonFlower").setCreativeTab(null);
    	moon_flower3 = (BlockMoonFlower) new BlockMoonFlower(3).setUnlocalizedName("moonFlower").setCreativeTab(null);
    	moon_flower4 = (BlockMoonFlower) new BlockMoonFlower(4).setUnlocalizedName("moonFlower").setCreativeTab(null);
    	moon_flower5 = (BlockMoonFlower) new BlockMoonFlower(5).setUnlocalizedName("moonFlower").setCreativeTab(null);
	}
	
	public static void register() {
		
		GameRegistry.register(bridge.setRegistryName("bridge"));
    	GameRegistry.register(new ItemBlock(bridge).setRegistryName("bridge"));
    	
    	GameRegistry.register(ender_block.setRegistryName("ender_block"));
    	GameRegistry.register(new ItemBlock(ender_block).setRegistryName("ender_block"));
    	
    	GameRegistry.register(blaze_block.setRegistryName("blaze_block"));
    	GameRegistry.register(new ItemBlock(blaze_block).setRegistryName("blaze_block"));
    	
    	GameRegistry.register(carrot_block.setRegistryName("carrot_block"));
    	GameRegistry.register(new ItemBlock(carrot_block).setRegistryName("carrot_block"));
    	
    	GameRegistry.register(apple_block.setRegistryName("apple_block"));
    	GameRegistry.register(new ItemBlock(apple_block).setRegistryName("apple_block"));
    	
    	GameRegistry.register(potato_block.setRegistryName("potato_block"));
    	GameRegistry.register(new ItemBlock(potato_block).setRegistryName("potato_block"));
    	
    	GameRegistry.register(baked_potato_block.setRegistryName("baked_potato_block"));
    	GameRegistry.register(new ItemBlock(baked_potato_block).setRegistryName("baked_potato_block"));
    	
    	GameRegistry.register(chicken_nest.setRegistryName("chicken_nest"));
    	GameRegistry.register(new ItemBlock(chicken_nest).setRegistryName("chicken_nest"));
    	
    	GameRegistry.register(trash_can.setRegistryName("trash_can"));
    	GameRegistry.register(new ItemBlock(trash_can).setRegistryName("trash_can"));
    	
    	GameRegistry.register(wild_grape_vine.setRegistryName("wild_grape_vine"));
    	GameRegistry.register(new ItemBlock(wild_grape_vine).setRegistryName("wild_grape_vine"));
    	
    	GameRegistry.register(grape_vine.setRegistryName("grape_vine"));
    	GameRegistry.register(new ItemBlock(grape_vine).setRegistryName("grape_vine"));
    	
    	GameRegistry.register(great_grape.setRegistryName("great_grape"));
    	GameRegistry.register(new ItemBlock(great_grape).setRegistryName("great_grape"));
    	
    	GameRegistry.register(moon_flower.setRegistryName("moon_flower"));
    	GameRegistry.register(moon_flower1.setRegistryName("moon_flower1"));
    	GameRegistry.register(moon_flower2.setRegistryName("moon_flower2"));
    	GameRegistry.register(moon_flower3.setRegistryName("moon_flower3"));
    	GameRegistry.register(moon_flower4.setRegistryName("moon_flower4"));
    	GameRegistry.register(moon_flower5.setRegistryName("moon_flower5"));
    	GameRegistry.register(new ItemBlock(moon_flower).setRegistryName("moon_flower"));
	}
}
