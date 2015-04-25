package com.team.kalstuff;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;

public class BlockLocation {

	Block block;
	BlockPos blockPos;
	public BlockLocation(Block block, BlockPos blockPos) {
		this.blockPos = blockPos;
		this.block = block;
	}
	
	public Block getBlock() {
		return this.block;
	}
	
	public BlockPos getPos() {
		return this.blockPos;
	}
	
}
