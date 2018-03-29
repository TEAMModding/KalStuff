package com.team.kalstuff;

import com.team.kalstuff.block.KalStuffBlocks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class KalStuffRecipes {

	public static void add() {
		// a super big thank you to williewillus for writing a script
		// to convert recipes to JSON!
		// Link: https://gist.github.com/williewillus/a1a899ce5b0f0ba099078d46ae3dae6e
		addSmeltingRecipes();
	}
	
	public static void addSmeltingRecipes(){
		GameRegistry.addSmelting(KalStuffBlocks.potato_block, new ItemStack(KalStuffBlocks.baked_potato_block), 2);
	}
}
