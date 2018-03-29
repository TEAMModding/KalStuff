package com.team.kalstuff.block;

import com.team.kalstuff.KalStuff;
import com.team.kalstuff.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class BlockKalStuff extends Block {

	public BlockKalStuff(Material materialIn, String name) {
		super(materialIn);
		setupBlock(this, name);
	}
	
	
	public static Block setupBlock(Block block, String name) {
		block.setRegistryName(name);
		block.setUnlocalizedName(KalStuff.MODID + ":" + name);
		block.setCreativeTab(CommonProxy.KALSTUFF);
		return block;
	}
}
