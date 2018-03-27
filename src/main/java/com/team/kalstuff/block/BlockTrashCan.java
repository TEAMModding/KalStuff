package com.team.kalstuff.block;

import com.team.kalstuff.KalStuff;
import com.team.kalstuff.StartupCommon;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTrashCan extends BlockKalStuff
{
	public static final AxisAlignedBB AABB = new AxisAlignedBB(1d/16d, 0d, 1d/16d, 15d/16d, 1d, 15d/16d);

	public BlockTrashCan(String name) {
		super(Material.IRON, name);
		this.setCreativeTab(StartupCommon.KALSTUFF);
		this.setHardness(3.0F);
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return AABB;
    }

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if (!worldIn.isRemote)
		{
			playerIn.openGui(KalStuff.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
}
