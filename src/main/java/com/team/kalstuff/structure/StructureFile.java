package com.team.kalstuff.structure;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class StructureFile implements IWorldGenerator
{
	private String file;
	
	public StructureFile(String filename) {
		file = filename;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (random.nextInt(50) == 1)
		{
			try {
				BlockPos pos = new BlockPos(chunkX * 16, world.getHorizon(new BlockPos(chunkX * 16, 0, chunkZ * 16)).getY(), chunkZ * 16);
				if (world.getBlockState(pos.down()) == Blocks.grass.getDefaultState())
					build(pos, file, world);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void build(BlockPos pos, String file, World world) throws IOException
	{
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file + ".worldgen")));
		try {
			while (true) {
				int x = in.readInt();
				int y = in.readInt();
				int z = in.readInt();
				int id = in.readInt();
			
				world.setBlockState(new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ()), Block.getStateById(id), 2);
			}
		}
		catch (EOFException e)
		{
			in.close();
		}
	}
}
