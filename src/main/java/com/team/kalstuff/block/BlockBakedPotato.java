package com.team.kalstuff.block;

import com.team.kalstuff.StartupCommon;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockBakedPotato extends Block {

	public BlockBakedPotato() {
		super(Material.grass);
		this.setCreativeTab(StartupCommon.kalStuffTab);
		this.setHardness(2.0F);
	}
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (playerIn.canEat(false))
		{
		playerIn.getFoodStats().addStats(11 , 6F);
		worldIn.setBlockToAir(pos);
		}
		return true;
	}
	
	
	
}
