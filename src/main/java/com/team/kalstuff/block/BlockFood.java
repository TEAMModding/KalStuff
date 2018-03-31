package com.team.kalstuff.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockFood extends BlockKalStuff
{
	private int amount;
	float saturation;

	public BlockFood(float hardness, int amount, float saturation, String name)
	{
		super(Material.ROCK, name);
		this.setHardness(hardness);
		this.amount = amount;
		this.saturation = saturation;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (playerIn.canEat(false))
		{
			playerIn.getFoodStats().addStats(amount, saturation);
			worldIn.setBlockToAir(pos);
		}
		return true;
	}
}