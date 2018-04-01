package com.team.kalstuff.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
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
		this.setSoundType(SoundType.STONE);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer entityplayer,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (entityplayer.canEat(false))
		{
			entityplayer.getFoodStats().addStats(amount, saturation);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
			worldIn.setBlockToAir(pos);
			return true;
		}
		return false;
	}
}