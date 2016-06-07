package com.team.kalstuff.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenRocks implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (random.nextInt(50) == 1)
			if (world.getBlockState(new BlockPos(chunkX * 16, world.getHorizon(new BlockPos(chunkX * 16, 0, chunkZ * 16)).getY() - 1, chunkZ * 16)) == Blocks.grass.getDefaultState())
			spawn(random, new BlockPos(chunkX * 16, world.getHorizon(new BlockPos(chunkX * 16, 0, chunkZ * 16)).getY(), chunkZ * 16), world);
	}
	
	private void spawn(Random rand, BlockPos pos, World world)
	{
		world.setBlockState(pos, Blocks.stone.getDefaultState(), 3);
		world.setBlockState(pos.up(), Blocks.stone.getDefaultState(), 3);
		world.setBlockState(pos.north(), Blocks.stone.getDefaultState(), 3);
		world.setBlockState(pos.south(2), Blocks.stone.getDefaultState(), 3);
		world.setBlockState(pos.east(), Blocks.stone.getDefaultState(), 3);
	}

}
