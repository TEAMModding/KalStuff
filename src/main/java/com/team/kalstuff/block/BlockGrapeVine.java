package com.team.kalstuff.block;

import java.util.Random;

import com.team.kalstuff.StartupCommon;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class BlockGrapeVine extends BlockCrops {

    protected Item getSeed()
    {
        return StartupCommon.grape_seeds;
    }

    protected Item getCrop()
    {
        return StartupCommon.grapes;
    }
    
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
		
		if (((Integer)state.getValue(AGE)).intValue() == 7) {
        worldIn.setBlockState(pos, state.withProperty(AGE, 6));
        Random rand = new Random();
        ItemStack aStack = new ItemStack(StartupCommon.grapes, rand.nextInt(2) + 3);
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
	    	            ret.add(new ItemStack(this.getCrop(), 1, 0));
	                }
	            }
                ret.add(new ItemStack(this.getSeed(), 1, 0));
	        }
	        return ret;
	    }
	    
	    @Override
	    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	    {
	        return false;
	    } 
	    
}
