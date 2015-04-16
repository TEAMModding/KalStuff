package com.team.kalstuff.block;
//please fix if the code is not right
import com.team.kalstuff.StartupCommon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBlaze extends Block {

	public BlockBlaze() {
		super(Material.iron);
		this.setCreativeTab(StartupCommon.kalStuffTab);
		this.setHardness(35.0F);
	}
	
	
	
}