package com.team.kalstuff.worldgen;

import java.util.Random;

import com.team.kalstuff.StartupCommon;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenGrapeVine implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (random.nextInt(10) == 1) {
		BlockPos aPos = this.getSurface(chunkX * 16 + random.nextInt(16), chunkZ * 16 + random.nextInt(16), world);
		
		if (aPos != null && world.getBiomeGenForCoordsBody(aPos).biomeID == BiomeGenBase.roofedForest.biomeID) {
			System.out.println("Generatin' grape vines...");
			world.setBlockState(aPos.up(), StartupCommon.blockGrapeVine.getDefaultState());
		}
		}
	}

	public BlockPos getSurface(int x, int z, World world) {
		for (int y = 0; y < world.getHeight(); y ++) {
			BlockPos aPos = new BlockPos(x, y, z);
			if (world.getBlockState(aPos) == Blocks.grass.getDefaultState() && world.isAirBlock(aPos.up())) return aPos;
		}
		return null;
	}
}
