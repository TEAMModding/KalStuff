package com.team.kalstuff.block;
//please fix if the code is not right
import com.team.kalstuff.StartupCommon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockApple extends Block {

	public BlockApple() {
		super(Material.rock);
		this.setCreativeTab(StartupCommon.kalStuffTab);
		this.setHardness(10.0F);
	
	}
	
	
	
}