package com.team.kalstuff.block;

import com.team.kalstuff.StartupCommon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEnder extends Block {

	public BlockEnder() {
		super(Material.ROCK);
		this.setCreativeTab(StartupCommon.kalStuffTab);
		this.setHardness(5.0F);
	}
	
	
	
}
