package com.team.kalstuff.structure;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class StructureFile implements IWorldGenerator
{
	private String file;
	private int rarity;
	
	/**
	 * Represents a worldgen file for generation.
	 * @param filename Name of the worldgen file located in assets.kalstuff.worldgen
	 * @param rarity Rarity of generating, 1 wil generate every chunk, around 100 seems about right.
	 */
	public StructureFile(String filename, int rarity) {
		this.file = filename;
		this.rarity = rarity;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (random.nextInt(rarity) == 1)
		{
			try {
				BlockPos pos = new BlockPos(chunkX * 16, world.getHorizon(new BlockPos(chunkX * 16, 0, chunkZ * 16)).getY(), chunkZ * 16);
				if (world.getBlockState(pos.down()) == Blocks.grass.getDefaultState())
				{
					BlockPos boundpos = build(pos, file, world);
					level(pos, boundpos, world);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private BlockPos build(BlockPos pos, String file, World world) throws IOException
	{
		InputStream stream = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("kalstuff", "files/worldgen/" + file + ".worldgen")).getInputStream();
		DataInputStream in = new DataInputStream(new BufferedInputStream(stream));
		BlockPos indexPos = null;
		try {
			while (true) {
				int x = in.readInt();
				int y = in.readInt();
				int z = in.readInt();
				int id = in.readInt();
				indexPos = new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ());
			
				world.setBlockState(indexPos, Block.getStateById(id), 2);
			}
		}
		catch (EOFException e)
		{
			in.close();
			return indexPos;
		}
	}
	
	private void level(BlockPos bound1, BlockPos bound2, World world) {
		
		
		for (int x = bound1.getX(); x < bound2.getX() + 1; x++) {
			for (int z = bound1.getZ(); z < bound2.getZ() + 1; z++) {
				BlockPos pos = new BlockPos(x, bound1.getY() - 1, z);
				world.setBlockState(pos, Blocks.grass.getDefaultState());
			}
		}
		
		for (int y = bound1.getY() - 2; y > bound1.getY() - 8; y--) {
			for (int x = bound1.getX(); x < bound2.getX() + 1; x++) {
				for (int z = bound1.getZ(); z < bound2.getZ() + 1; z++) {
					BlockPos pos = new BlockPos(x, y, z);
					world.setBlockState(pos, Blocks.dirt.getDefaultState());
				}
			}
		}
	}
}
