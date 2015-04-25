package com.team.kalstuff;

import java.util.ArrayList;
import java.util.Random;

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
		if (random.nextInt(100) == 1)
		//	spawn(random, new BlockPos(chunkX * 16, world.getHorizon(new BlockPos(chunkX * 16, 0, chunkZ * 16)).getY(), chunkZ * 16), world);
			build(structures.get(random.nextInt(structures.size())).structure, new BlockPos(chunkX * 16, world.getHorizon(new BlockPos(chunkX * 16, 0, chunkZ * 16)).getY(), chunkZ * 16), world);
	}
	
	private void spawn(Random rand, BlockPos pos, World world)
	{
		world.setBlockState(pos, Blocks.stonebrick.getDefaultState(), 3);
		world.setBlockState(pos.up(), Blocks.stonebrick.getDefaultState(), 3);
		world.setBlockState(pos.up(2), Blocks.stonebrick.getStateFromMeta(3), 3);
		
	}
	
	public void add(Structure structure) {
		structures.add(structure);
	}

	
	public static void build(ArrayList<Block[][]> structure, BlockPos pos, World world) {
		if (world.getBlockState(pos.down()) == (Blocks.grass.getDefaultState())) {
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
		
	}
}
