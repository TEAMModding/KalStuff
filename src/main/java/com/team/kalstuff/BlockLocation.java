package com.team.kalstuff;

import java.io.Serializable;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public class BlockLocation implements Serializable 
{
	private static final long serialVersionUID = -7551624909690732269L;
	private Block block;
	private BlockPos blockPos;
	
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
