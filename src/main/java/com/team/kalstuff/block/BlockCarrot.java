package com.team.kalstuff.block;

import com.team.kalstuff.StartupCommon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCarrot extends Block {

	public BlockCarrot() {
		super(Material.grass);
		this.setCreativeTab(StartupCommon.kalStuffTab);
		this.setHardness(1.0F);
	}
	
	
	
}