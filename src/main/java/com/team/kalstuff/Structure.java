package com.team.kalstuff;

import java.util.ArrayList;

import net.minecraft.block.*;
public class Structure {
	
	public Structure() {
		this.create();
	}

	 ArrayList<Block[][]> structure = new ArrayList<Block[][]>();
	
	 public ArrayList<Block[][]> getStructure() {
		 return structure;
	 }

	 public void addLayer(Block[][] layer) {
		// System.out.println("The length of structure is " + structure.length);
		 structure.add(layer);
	 }
	 
	 public void create() {
		 
	 }
	 /*	Block[][] layer1 =
		{	{Blocks.dirt, Blocks.stone},
			{Blocks.air,Blocks.planks}	};
	
	Block[][] layer2 = 
		{	{Blocks.iron_block, Blocks.bedrock, Blocks.cake},
			{Blocks.stone, Blocks.glass, Blocks.sand, Blocks.brick_stairs},
			{Blocks.diamond_ore}
		};
		*/
	 
}
