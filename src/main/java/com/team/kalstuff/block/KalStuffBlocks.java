package com.team.kalstuff.block;

import com.team.kalstuff.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder("kalstuff")
@Mod.EventBusSubscriber(modid = "kalstuff")
public class KalStuffBlocks {

	// ---Please keep all blocks in alphabetical order!---
	public static final Block apple_block = Blocks.AIR;
	public static final Block baked_potato_block = Blocks.AIR;
	public static final Block blaze_block = Blocks.AIR;
	public static final Block bridge = Blocks.AIR;
	public static final Block carrot_block = Blocks.AIR;
	public static final Block chicken_nest = Blocks.AIR;
	public static final Block ender_block = Blocks.AIR;
	public static final Block grape_vine = Blocks.AIR;
	public static final Block great_grape = Blocks.AIR;
	public static final Block moon_flower = Blocks.AIR;
	public static final Block moon_flower1 = Blocks.AIR;
	public static final Block moon_flower2 = Blocks.AIR;
	public static final Block moon_flower3 = Blocks.AIR;
	public static final Block moon_flower4 = Blocks.AIR;
	public static final Block moon_flower5 = Blocks.AIR;
	public static final Block potato_block = Blocks.AIR;
	public static final Block trash_can = Blocks.AIR;
	public static final Block wild_grape_vine = Blocks.AIR;
	
	/**
	 * Registers all blocks from the mod.
	 */
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		
		IForgeRegistry<Block> reg = event.getRegistry();
		// remember to register ItemBlocks in KalStuffItems, and
		// please continue to keep all blocks in alphabetical order
		
		reg.register(new BlockFood(1.5F, 9, 2.4F, "apple_block"));
		reg.register(new BlockBakedPotato(1.5F, 11, 6F, "baked_potato_block"));
    	reg.register(new BlockKalStuff(Material.IRON, "blaze_block").setHardness(35.0F));
    	reg.register(new BlockBridge("bridge"));
    	reg.register(new BlockFood(11.5F, 7, 4.8F, "carrot_block"));
    	reg.register(new BlockChickenNest("chicken_nest"));
    	reg.register(new BlockKalStuff(Material.ROCK, "ender_block").setHardness(5.0F));
    	reg.register(new BlockGrapeVine("grape_vine"));
    	reg.register(new BlockKalStuff(Material.SPONGE, "great_grape"));
    	// only the first BlockMoonFlower should appear in the Creative inventory
    	reg.register(new BlockMoonFlower(0, "moon_flower").setCreativeTab(CommonProxy.KALSTUFF));
    	reg.register(new BlockMoonFlower(1, "moon_flower1"));
    	reg.register(new BlockMoonFlower(2, "moon_flower2"));
    	reg.register(new BlockMoonFlower(3, "moon_flower3"));
    	reg.register(new BlockMoonFlower(4, "moon_flower4"));
    	reg.register(new BlockMoonFlower(5, "moon_flower5"));
    	reg.register(new BlockFood(1.5F, 3, 0.6F, "potato_block"));
    	reg.register(new BlockTrashCan("trash_can"));
    	reg.register(new BlockWildGrapeVine("wild_grape_vine"));    	
	}
}
