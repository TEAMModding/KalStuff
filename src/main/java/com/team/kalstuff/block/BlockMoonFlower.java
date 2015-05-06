package com.team.kalstuff.block;

import java.util.Random;

import com.team.kalstuff.StartupCommon;

import net.minecraft.block.BlockBush;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockMoonFlower extends BlockBush {
	
    public static final PropertyInteger NIGHT = PropertyInteger.create("night", 0, 1);
	
	public BlockMoonFlower() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(NIGHT, Integer.valueOf(0)));
        this.setLightLevel(12/16.0f);
        this.setCreativeTab(StartupCommon.kalStuffTab);
        this.setStepSound(soundTypeGrass);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
        IBlockState iblockstate = worldIn.getBlockState(pos);
		if (worldIn.getWorldTime() >= 13000 || worldIn.getWorldTime() < 1000 && ((Integer)iblockstate.getValue(NIGHT)).intValue() != 1)
			worldIn.setBlockState(pos, iblockstate.withProperty(NIGHT, Integer.valueOf(1)));
		else worldIn.setBlockState(pos, iblockstate.withProperty(NIGHT, Integer.valueOf(0)));
	}
	
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {NIGHT});
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
        return ((Integer)state.getValue(NIGHT)).intValue();
    }
    
}
