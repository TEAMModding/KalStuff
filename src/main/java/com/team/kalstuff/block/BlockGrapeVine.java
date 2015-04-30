package com.team.kalstuff.block;

import java.util.Random;

import com.team.kalstuff.StartupCommon;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockGrapeVine extends BlockCrops {

    protected Item getSeed()
    {
        return StartupCommon.itemGrapeSeeds;
    }

    protected Item getCrop()
    {
        return StartupCommon.itemGrapes;
    }
    
	 @Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
		
		if (((Integer)state.getValue(AGE)).intValue() == 7) {
        worldIn.setBlockState(pos, state.withProperty(AGE, 6));
        Random rand = new Random();
        ItemStack aStack = new ItemStack(StartupCommon.itemGrapes, rand.nextInt(2) + 3);
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
	        ItemStack aStack = new ItemStack(StartupCommon.itemGrapes, rand.nextInt(2) + 3);
	        spawnAsEntity(worldIn, pos, aStack);
	    	}
	    }
	    
	    @Override
	    public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	    {
	        java.util.List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
	        int age = ((Integer)state.getValue(AGE)).intValue();
	        Random rand = world instanceof World ? ((World)world).rand : new Random();

	        if (age >= 7)
	        {
	          //  int k = 3 + fortune;

	            for (int i = 0; i < 3 + fortune; ++i)
	            {
	                if (rand.nextInt(15) <= age)
	                {
	                    ret.add(new ItemStack(this.getSeed(), rand.nextInt(2) + 3, 0));
	                }
	            }
	        }
	        return ret;
	    }
	    
	    @Override
	    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	    {
	        return false;
	    }
	    
	/*    @Override
	    public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
	    	return false;
	    }*/
	    
	    
}
