package com.team.kalstuff.block;

import java.util.Random;

import com.team.kalstuff.tileentity.TileEntityMoonFlower;

import net.minecraft.block.BlockBush;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMoonFlower extends BlockBush implements ITileEntityProvider
{
	public static final PropertyInteger NIGHT = PropertyInteger.create("night", 0, 1);

	public BlockMoonFlower(float light, String name)
	{
		BlockKalStuff.setupBlock(this, name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(NIGHT, Integer.valueOf(0)));
		this.setLightLevel((light) / 16.0f);
		// we must set the creative tab to null here so all varieties will not show up
		// in the inventory
		this.setCreativeTab(null);
	}

	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		super.breakBlock(worldIn, pos, state);
		worldIn.removeTileEntity(pos);
	}

	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityMoonFlower();
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.updateTick(worldIn, pos, state, rand);
		if ((worldIn.getWorldTime() >= 12800 && worldIn.getWorldTime() < 23000)
				&& ((Integer) state.getValue(NIGHT)).intValue() != 1)
		{
			worldIn.setBlockState(pos, state.withProperty(NIGHT, Integer.valueOf(1)));
		} else if ((worldIn.getWorldTime() >= 23000 || worldIn.getWorldTime() < 12800)
				&& ((Integer) state.getValue(NIGHT)).intValue() != 0)
		{
			worldIn.setBlockState(pos, state.withProperty(NIGHT, Integer.valueOf(0)));
		}
	}

	public void checkSky(World worldIn, BlockPos pos)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos);
		if (worldIn.getBlockState(pos).getBlock().getClass() == BlockMoonFlower.class)
		{
			if (worldIn.canSeeSky(pos) && ((Integer) worldIn.getBlockState(pos).getValue(NIGHT)).intValue() == 1)
			{
				if (worldIn.getCurrentMoonPhaseFactor() == 0)
					worldIn.setBlockState(pos, KalStuffBlocks.moon_flower1.getDefaultState().withProperty(NIGHT,
							iblockstate.getValue(NIGHT)));
				if (worldIn.getCurrentMoonPhaseFactor() == .25)
					worldIn.setBlockState(pos, KalStuffBlocks.moon_flower2.getDefaultState().withProperty(NIGHT,
							iblockstate.getValue(NIGHT)));
				if (worldIn.getCurrentMoonPhaseFactor() == .50)
					worldIn.setBlockState(pos, KalStuffBlocks.moon_flower3.getDefaultState().withProperty(NIGHT,
							iblockstate.getValue(NIGHT)));
				if (worldIn.getCurrentMoonPhaseFactor() == .75)
					worldIn.setBlockState(pos, KalStuffBlocks.moon_flower4.getDefaultState().withProperty(NIGHT,
							iblockstate.getValue(NIGHT)));
				if (worldIn.getCurrentMoonPhaseFactor() == 1)
					worldIn.setBlockState(pos, KalStuffBlocks.moon_flower5.getDefaultState().withProperty(NIGHT,
							iblockstate.getValue(NIGHT)));
			} else
			{
				worldIn.setBlockState(pos,
						KalStuffBlocks.moon_flower.getDefaultState().withProperty(NIGHT, iblockstate.getValue(NIGHT)),
						3);
			}
		}
	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { NIGHT });
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(KalStuffBlocks.moon_flower);
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World worldIn, BlockPos pos)
	{
		return Item.getItemFromBlock(KalStuffBlocks.moon_flower);
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(NIGHT, Integer.valueOf(meta));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state)
	{
		return ((Integer) state.getValue(NIGHT)).intValue();
	}
}