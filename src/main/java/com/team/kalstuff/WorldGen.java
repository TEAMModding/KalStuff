package com.team.kalstuff;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (random.nextInt(100) == 1)
			spawn(random, new BlockPos(chunkX * 16, world.getHorizon(new BlockPos(chunkX * 16, 0, chunkZ * 16)).getY(), chunkZ * 16), world);
	}
	
	private void spawn(Random rand, BlockPos pos, World world)
	{
		world.setBlockState(pos, Blocks.stonebrick.getDefaultState(), 3);
		world.setBlockState(pos.up(), Blocks.stonebrick.getDefaultState(), 3);
		world.setBlockState(pos.up(2), Blocks.stonebrick.getStateFromMeta(3), 3);
		
	}

}
