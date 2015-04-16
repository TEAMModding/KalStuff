package com.team.kalstuff.block;

import com.team.kalstuff.StartupCommon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBlaze extends Block {

	public BlockBlaze() {
		super(Material.rock);
		this.setCreativeTab(StartupCommon.kalStuffTab);
		this.setHardness(15.0F);
	}
	
	
	
}