package com.team.kalstuff.block;

import com.team.kalstuff.StartupCommon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMystery extends Block {
	
	public BlockMystery() {
		super(Material.wood);		
				this.setCreativeTab(StartupCommon.kalStuffTab);		
				this.setHardness(0.5F);
				
	}
}