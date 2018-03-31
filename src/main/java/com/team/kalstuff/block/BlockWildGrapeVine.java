package com.team.kalstuff.block;

import java.util.Random;

import com.team.kalstuff.item.KalStuffItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWildGrapeVine extends BlockBush
{
	public static final PropertyInteger GROWN = PropertyInteger.create("grown", 0, 1);
	public static final AxisAlignedBB AABB = new AxisAlignedBB(3d / 16d, 0d, 3d / 16d, 13d / 16d, 1d, 13d / 16d);

	public BlockWildGrapeVine(String name)
	{
		super(Material.PLANTS);
		BlockKalStuff.setupBlock(this, name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(GROWN, Integer.valueOf(1)));
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return AABB;
	}

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.updateTick(worldIn, pos, state, rand);

		if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
		{
			int i = ((Integer) state.getValue(GROWN)).intValue();

			if (i < 1)
			{
				float f = getGrowthChance(this, worldIn, pos, state);

				if (rand.nextInt((int) (25.0F / f) + 1) == 0)
				{
					worldIn.setBlockState(pos, state.withProperty(GROWN, Integer.valueOf(i + 1)), 2);
				}
			}
		}
	}

	protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos, IBlockState state)
	{
		float f = 1.0F;
		BlockPos blockpos1 = pos.down();

		for (int i = -1; i <= 1; ++i)
		{
			for (int j = -1; j <= 1; ++j)
			{
				float f1 = 0.0F;
				IBlockState iblockstate = worldIn.getBlockState(blockpos1.add(i, 0, j));

				if (iblockstate.getBlock().canSustainPlant(state, worldIn, blockpos1.add(i, 0, j), EnumFacing.UP,
						(net.minecraftforge.common.IPlantable) blockIn))
				{
					f1 = 1.0F;
					if (iblockstate.getBlock().isFertile(worldIn, blockpos1.add(i, 0, j)))
					{
						f1 = 3.0F;
					}
				}

				if (i != 0 || j != 0)
				{
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		BlockPos blockpos2 = pos.north();
		BlockPos blockpos3 = pos.south();
		BlockPos blockpos4 = pos.west();
		BlockPos blockpos5 = pos.east();
		boolean flag = blockIn == worldIn.getBlockState(blockpos4).getBlock()
				|| blockIn == worldIn.getBlockState(blockpos5).getBlock();
		boolean flag1 = blockIn == worldIn.getBlockState(blockpos2).getBlock()
				|| blockIn == worldIn.getBlockState(blockpos3).getBlock();

		if (flag && flag1)
		{
			f /= 2.0F;
		} else
		{
			boolean flag2 = blockIn == worldIn.getBlockState(blockpos4.north()).getBlock()
					|| blockIn == worldIn.getBlockState(blockpos5.north()).getBlock()
					|| blockIn == worldIn.getBlockState(blockpos5.south()).getBlock()
					|| blockIn == worldIn.getBlockState(blockpos4.south()).getBlock();

			if (flag2)
			{
				f /= 2.0F;
			}
		}

		return f;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		super.onBlockActivated(worldIn, pos, state, playerIn, hand, side, hitX, hitY, hitZ);

		if (((Integer) state.getValue(GROWN)).intValue() == 1)
		{
			worldIn.setBlockState(pos, state.withProperty(GROWN, 0));
			Random rand = new Random();
			ItemStack aStack = new ItemStack(KalStuffItems.grapes, rand.nextInt(2) + 3);
			spawnAsEntity(worldIn, pos, aStack);
			return true;
		}
		return false;

	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { GROWN });
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(GROWN, Integer.valueOf(meta));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state)
	{
		return ((Integer) state.getValue(GROWN)).intValue();
	}

	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
	{
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
		if (((Integer) state.getValue(GROWN)).intValue() == 1)
		{
			Random rand = new Random();
			ItemStack aStack = new ItemStack(KalStuffItems.grapes, rand.nextInt(2) + 3);
			spawnAsEntity(worldIn, pos, aStack);
		}
	}

	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player)
	{
		return false;
	}
}
