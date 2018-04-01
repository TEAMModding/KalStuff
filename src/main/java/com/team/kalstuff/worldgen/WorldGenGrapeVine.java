package com.team.kalstuff.worldgen;

import java.util.Random;

import com.team.kalstuff.block.KalStuffBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenGrapeVine implements IWorldGenerator
{
	public BlockPos getSurface(int x, int z, World world)
	{
		for (int y = 0; y < world.getHeight(); y++)
		{
			BlockPos aPos = new BlockPos(x, y, z);
			if (world.getBlockState(aPos) == Blocks.GRASS.getDefaultState() && world.isAirBlock(aPos.up()))
				return aPos;
		}
		return null;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider)
	{
		BlockPos aPos = this.getSurface(chunkX * 16 + random.nextInt(16), chunkZ * 16 + random.nextInt(16), world);
		if (random.nextInt(10) == 1)
		{
			if (aPos != null && world.getBiomeForCoordsBody(aPos) == Biome.REGISTRY
					.getObject(new ResourceLocation("roofed_forest")))
			{
				world.setBlockState(aPos.up(), KalStuffBlocks.WILD_GRAPE_VINE.getDefaultState());
			}
		}
	}
}
