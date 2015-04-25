package com.team.kalstuff.block;

import com.team.kalstuff.StartupCommon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSquidMat extends Block {

	public BlockSquidMat() {
		super(Material.carpet);
		this.setCreativeTab(StartupCommon.kalStuffTab);
	    this.setHardness(0.1f);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 16/16.0f, 8/16.0f, 16/16.0f);
	}
	
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
	return EnumWorldBlockLayer.SOLID;
	}

	@Override
	public boolean isOpaqueCube() {
	return false;
	}

	@Override
	public boolean isFullCube() {
	return false;
	}
	
	@Override
	public int getRenderType() {
	return 3;
	}
	
	  public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	  {
	    return null;
	  }
}
