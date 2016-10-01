package com.team.kalstuff.block;

import java.util.Random;

import com.team.kalstuff.StartupCommon;

import net.minecraft.block.BlockCrops;
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
import net.minecraft.world.World;

public class BlockGrapeVine extends BlockCrops {

    public static final PropertyBool GREAT = PropertyBool.create("great");

    public BlockGrapeVine() {
		super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0).withProperty(GREAT, false));
    }
    
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		
		Random rand = new Random();
		if (rand.nextInt(500) == 0) worldIn.setBlockState(pos, state.withProperty(GREAT, true));
	}
	
	protected Item getSeed() {
		return null;
	}

	protected Item getCrop() {
		return null;
	}
	
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        this.checkAndDropBlock(worldIn, pos, state);
        
        if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
            int i = this.getAge(state);

            if (i < this.getMaxAge()) {
                float f = getGrowthChance(this, worldIn, pos);

                if (rand.nextInt((int)(25.0F / f) + 1) == 0) {
            		if (i + 1 == 7 && state.getValue(GREAT)) worldIn.setBlockState(pos, StartupCommon.great_grape.getDefaultState());
            		else worldIn.setBlockState(pos, this.getDefaultState().withProperty(AGE, i + 1).withProperty(GREAT, state.getValue(GREAT)), 2);
                }
            }
        }
    }
	
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
            IBlockState soil = worldIn.getBlockState(pos.down());
            return soil.getBlock() == Blocks.FARMLAND;
    }
    
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
		
		if (((Integer)state.getValue(AGE)).intValue() == 7) {
			worldIn.setBlockState(pos, state.withProperty(AGE, 6));
			Random rand = new Random();
			ItemStack aStack = new ItemStack(StartupCommon.grapes, rand.nextInt(3) + 4);
			spawnAsEntity(worldIn, pos, aStack);
			return true;
		}
		return false;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
		
		if (((Integer)state.getValue(AGE)).intValue() == 1) {
			Random rand = new Random();
			ItemStack stack1 = new ItemStack(StartupCommon.grapes, rand.nextInt(2) + 3);
			ItemStack stack2 = new ItemStack(Items.STICK, 4);
			spawnAsEntity(worldIn, pos, stack1);
			spawnAsEntity(worldIn, pos, stack2);
		}
	}
	
	@Override
	public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		
		java.util.List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
		int age = ((Integer)state.getValue(AGE)).intValue();
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		
		if (age >= 7) ret.add(new ItemStack(StartupCommon.grapes, rand.nextInt(2) + 3));
		else ret.add(new ItemStack(StartupCommon.grape_seeds, 1, 0));
		ret.add(new ItemStack(Items.STICK, 4));
		
		return ret;
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return false;
	}
	
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {AGE, GREAT});
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta) {
    	return this.getDefaultState().withProperty(AGE, meta > 7 ? meta - 8 : meta).withProperty(GREAT, meta > 7 ? true : false);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state) {
        int i = state.getValue(AGE);
        return state.getValue(GREAT) ? i + 8 : i;
    }

}
