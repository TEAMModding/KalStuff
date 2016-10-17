package com.team.kalstuff.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BlockFood extends Block {

	private int amount;
	float saturation;
	
	public BlockFood(float hardness, int amount, float saturation) {
		super(Material.ROCK);
		
		this.setHardness(hardness);
		this.amount = amount;
		this.saturation = saturation;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		if (playerIn.canEat(false)) {
			playerIn.getFoodStats().addStats(amount, saturation);
			worldIn.setBlockToAir(pos);
		}
		return true;
	}
}