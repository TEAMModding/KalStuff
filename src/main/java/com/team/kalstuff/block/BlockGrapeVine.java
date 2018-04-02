package com.team.kalstuff.block;

import java.util.Random;

import com.team.kalstuff.item.KalStuffItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGrapeVine extends BlockCrops
{
	public static final PropertyBool GREAT = PropertyBool.create("great");

	public BlockGrapeVine(String name)
	{
		super();
		BlockKalStuff.setupBlock(this, name);
		this.setCreativeTab(null); // we don't want this one in the Creative menu
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0).withProperty(GREAT, false));
		this.setSoundType(SoundType.PLANT);
	}

	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		super.onBlockAdded(worldIn, pos, state);
		Random rand = new Random();
		if (rand.nextInt(500) == 0)
			worldIn.setBlockState(pos, state.withProperty(GREAT, true));
	}

	protected Item getSeed()
	{
		return null;
	}

	protected Item getCrop()
	{
		return null;
	}

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		this.checkAndDropBlock(worldIn, pos, state);

		if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
		{
			int i = this.getAge(state);

			if (i < this.getMaxAge())
			{
				float f = getGrowthChance(this, worldIn, pos);

				if (rand.nextInt((int) (25.0F / f) + 1) == 0)
				{
					if (i + 1 == 7 && state.getValue(GREAT))
						worldIn.setBlockState(pos, KalStuffBlocks.GREAT_GRAPE.getDefaultState());
					else
						worldIn.setBlockState(pos, this.getDefaultState().withProperty(AGE, i + 1).withProperty(GREAT,
								state.getValue(GREAT)), 2);
				}
			}
		}
	}

	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
	{
		IBlockState soil = worldIn.getBlockState(pos.down());
		return soil.getBlock() == Blocks.FARMLAND;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY)
	{
		if (((Integer) state.getValue(AGE)).intValue() == 7)
		{
			worldIn.setBlockState(pos, state.withProperty(AGE, 6));
			Random rand = new Random();
			ItemStack aStack = new ItemStack(KalStuffItems.GRAPES, rand.nextInt(3) + 4);
			spawnAsEntity(worldIn, pos, aStack);
			return true;
		}
		return false;
	}

	@Override
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos,
			IBlockState state, int fortune)
	{
		super.getDrops(drops, world, pos, state, fortune);
		int age = ((Integer) state.getValue(AGE)).intValue();
		Random rand = world instanceof World ? ((World) world).rand : new Random();

		if (age >= 7)
			drops.add(new ItemStack(KalStuffItems.GRAPES, rand.nextInt(3) + 4));
		
		drops.add(new ItemStack(Items.STICK, 4));
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		return false;
	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { AGE, GREAT });
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(AGE, meta > 7 ? meta - 8 : meta).withProperty(GREAT,
				meta > 7 ? true : false);
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state)
	{
		int i = state.getValue(AGE);
		return state.getValue(GREAT) ? i + 8 : i;
	}
}
