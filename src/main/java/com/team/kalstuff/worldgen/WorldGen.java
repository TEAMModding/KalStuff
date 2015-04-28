package com.team.kalstuff.worldgen;

import java.util.ArrayList;
import java.util.Random;

import com.team.kalstuff.structure.Structure;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator
{
	
	private ArrayList<Structure> structures = new ArrayList<Structure>();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (random.nextInt(100) == 1) {
		//	spawn(random, new BlockPos(chunkX * 16, world.getHorizon(new BlockPos(chunkX * 16, 0, chunkZ * 16)).getY(), chunkZ * 16), world);
			BlockPos aPos = this.getSurface(chunkX * 16, chunkZ * 16, world);
			if (aPos != null) build(structures.get(random.nextInt(structures.size())).getStructure(), aPos, world);
		}
	}
	
	/*private void spawn(Random rand, BlockPos pos, World world)
	{
		world.setBlockState(pos, Blocks.stonebrick.getDefaultState(), 3);
		world.setBlockState(pos.up(), Blocks.stonebrick.getDefaultState(), 3);
		world.setBlockState(pos.up(2), Blocks.stonebrick.getStateFromMeta(3), 3);
		
	}*/
	
	public void add(Structure structure) {
		structures.add(structure);
	}

	
	public static void build(ArrayList<Block[][]> structure, BlockPos pos, World world) {

			for (int i = 0; i < structure.size(); i ++) {
				for (int j = 0; j < structure.get(i).length; j ++) {
					for (int k = 0; k < structure.get(i)[j].length; k ++) {
						BlockPos aPos = new BlockPos(pos.getX() + j, pos.getY() + i, pos.getZ() + k);
						world.setBlockState(aPos, structure.get(i)[j][k].getDefaultState());
						System.out.println("X: " + (pos.getX() + j) + ", Y: " + (pos.getY() + i) + ", Z: " + (pos.getZ() + k + ", Block: " + structure.get(i)[j][k]));
					}
				}
			}

		
	}
	
	public BlockPos getSurface(int x, int z, World world) {
		for (int y = 0; y < world.getHeight(); y ++) {
			BlockPos aPos = new BlockPos(x, y, z);
			if (world.getBlockState(aPos) == Blocks.grass.getDefaultState()) return aPos;
		}
		return null;
	}
	
}
