package com.team.kalstuff;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSquidMat extends Block {

	protected BlockSquidMat() {
		super(Material.carpet);
		this.setCreativeTab(StartupCommon.kalStuffTab);
	    this.setHardness(0.1f);
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
	
}
