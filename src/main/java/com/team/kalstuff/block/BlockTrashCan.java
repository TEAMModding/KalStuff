package com.team.kalstuff.block;

import com.team.KalStuff;
import com.team.kalstuff.StartupCommon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockTrashCan extends Block
{

	public BlockTrashCan() {
		super(Material.iron);
		this.setCreativeTab(StartupCommon.kalStuffTab);
		this.setBlockBounds(1/16.0f, 0.0f, 1/16.0f, 15/16.0f, 1.0f, 15/16.0f);
	}
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		if (!worldIn.isRemote)
		{
			System.out.println("opening gui");
			playerIn.openGui(KalStuff.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}
}
