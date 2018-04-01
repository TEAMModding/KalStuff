package com.team.kalstuff.block;

import com.team.kalstuff.KalStuff;
import com.team.kalstuff.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockKalStuff extends Block
{
	public BlockKalStuff(Material material, String name)
	{
		super(material);
		setupBlock(this, name);
	}
	
	public BlockKalStuff(Material material, SoundType sound, String name)
	{
		super(material);
		this.setSoundType(sound);
		setupBlock(this, name);
	}

	public static Block setupBlock(Block block, String name)
	{
		block.setRegistryName(name);
		block.setUnlocalizedName(KalStuff.MODID + ":" + name);
		block.setCreativeTab(CommonProxy.KALSTUFF);
		return block;
	}
}
