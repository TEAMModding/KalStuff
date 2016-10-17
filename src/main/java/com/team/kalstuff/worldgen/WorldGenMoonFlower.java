package com.team.kalstuff.worldgen;

import java.util.ArrayList;
import java.util.Random;

import com.team.kalstuff.block.KalStuffBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenMoonFlower implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (random.nextInt(100) == 1) {
		ArrayList<BlockPos> somePos = this.getValidLocationsInArea(random, chunkX * 16 + random.nextInt(16), chunkZ * 16 + random.nextInt(16), 8, world);
		
		if (somePos != null) {
			for (int i = 0; i < somePos.size(); i ++)
				if (somePos.get(i) != null)
					world.setBlockState(somePos.get(i).up(), KalStuffBlocks.moon_flower.getDefaultState());

		}
		}
	}

	public BlockPos getSurface(int x, int z, World world) {
		
		for (int y = 0; y < world.getHeight(); y ++) {
			BlockPos aPos = new BlockPos(x, y, z);
			if (world.getBlockState(aPos) == Blocks.GRASS.getDefaultState() && world.isAirBlock(aPos.up())) return aPos;
		}
		return null;
	}
	
	public ArrayList<BlockPos> getValidLocationsInArea(Random rand, int x, int z, int tries, World world) {
		
		ArrayList<BlockPos> somePos = new ArrayList<BlockPos>();
		
		for (int i = 0; i < tries; i ++) {
			BlockPos aPos = this.getSurface(x + rand.nextInt(10) - 5, z + rand.nextInt(10) - 5, world);
			if (aPos != null) somePos.add(aPos);
		}
		
		return somePos;
		
	}
}
