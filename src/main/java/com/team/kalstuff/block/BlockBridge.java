package com.team.kalstuff.block;

import java.util.Random;

import com.team.kalstuff.config.Config;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBridge extends BlockDirectional
{
	private boolean particle = false;
	private BlockPos partLoc;

	public BlockBridge(String name) throws StackOverflowError, IllegalArgumentException, NullPointerException
	{
		super(Material.WOOD);
		BlockKalStuff.setupBlock(this, name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setHardness(0.5f);
		this.setSoundType(SoundType.WOOD);
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		return chain(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ, pos);
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
	{
		return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer));
	}

	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
	}

	public int getMetaFromState(IBlockState state)
	{
		byte b0 = 0;
		int i = b0 | ((EnumFacing) state.getValue(FACING)).getIndex();

		return i;
	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	/**
	 * Whenever the bridge block is right clicked or activated by another bridge,
	 * this method is fired. It attempts to find where to place or chain the given
	 * block
	 */
	@SuppressWarnings("deprecation")
	public boolean chain(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side,
			float hitX, float hitY, float hitZ, BlockPos origin)
	{
		if (worldIn.isRemote)
			return true;

		ItemStack itemstack = playerIn.getHeldItemMainhand();
		Block block;
		// attempt to get a block from the held item without crashing the game
		try
		{
			block = Block.getBlockFromItem(itemstack.getItem());
		} catch (Exception e)
		{
			return true;
		}
		if (block == null)
			return true;

		// if the block cannot be picked up by endermen, is not a bridge block, and in
		// the case of TNT is not allowed in the config, return with a chat message
		if ((!EntityEnderman.getCarriable(block) && block != KalStuffBlocks.BRIDGE)
				|| (!Config.bridgeTNT && block == Blocks.TNT))
		{
			playerIn.sendMessage(new TextComponentTranslation("The bridge is unable to send this", new Object[0]));
			return true;
		}

		BlockPos aPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());

		// all of this is just looking sixteen blocks in front of the bridge block,
		// depending on what direction it is facing, to try to find something to do with
		// the given block
		int i = 0;
		if (state.getValue(FACING).equals(EnumFacing.EAST))
			do
				aPos = new BlockPos(aPos.getX() + 1, aPos.getY(), aPos.getZ());
			while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock()
					.getDefaultState() != KalStuffBlocks.BRIDGE.getDefaultState() && i++ <= 16);

		if (state.getValue(FACING).equals(EnumFacing.WEST))
			do
				aPos = new BlockPos(aPos.getX() - 1, aPos.getY(), aPos.getZ());
			while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock()
					.getDefaultState() != KalStuffBlocks.BRIDGE.getDefaultState() && i++ <= 16);

		if (state.getValue(FACING).equals(EnumFacing.UP))
			do
				aPos = new BlockPos(aPos.getX(), aPos.getY() + 1, aPos.getZ());
			while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock()
					.getDefaultState() != KalStuffBlocks.BRIDGE.getDefaultState() && i++ <= 16);

		if (state.getValue(FACING).equals(EnumFacing.DOWN))
			do
				aPos = new BlockPos(aPos.getX(), aPos.getY() - 1, aPos.getZ());
			while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock()
					.getDefaultState() != KalStuffBlocks.BRIDGE.getDefaultState() && i++ <= 16);

		if (state.getValue(FACING).equals(EnumFacing.NORTH))
			do
				aPos = new BlockPos(aPos.getX(), aPos.getY(), aPos.getZ() - 1);
			while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock()
					.getDefaultState() != KalStuffBlocks.BRIDGE.getDefaultState() && i++ <= 16);

		if (state.getValue(FACING).equals(EnumFacing.SOUTH))
			do
				aPos = new BlockPos(aPos.getX(), aPos.getY(), aPos.getZ() + 1);
			while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock()
					.getDefaultState() != KalStuffBlocks.BRIDGE.getDefaultState() && i++ <= 16);
		// end the great block search

		// if the bridge blocks have chained back to the first one, return
		if (aPos.equals(origin))
			return true;
		// if the found position is more than sixteen blocks away despite all of the
		// checks above, then send a message that the bridge cannot reach that far
		if (i > 16)
		{
			playerIn.sendMessage(new TextComponentTranslation("The bridge cannot reach that far", new Object[0]));
			return true;
		}

		// if a bridge block is found
		if (worldIn.getBlockState(aPos).getBlock().getDefaultState() == KalStuffBlocks.BRIDGE.getDefaultState())
		{
			BlockBridge target = (BlockBridge) worldIn.getBlockState(aPos).getBlock();

			// attempt to "chain" the target bridge
			try
			{
				target.chain(worldIn, aPos, worldIn.getBlockState(aPos), playerIn, side, hitX, hitY, hitZ, origin);
			}
			catch (StackOverflowError e) {}

		}
		else if (i <= 16 && block.canPlaceBlockAt(worldIn, aPos))
		{ // if air is found
			boolean success = false;
			IBlockState blockstate;
			try
			{
				// attempt to place as a six-directional block, e.g. dispenser
				blockstate = (IBlockState) Block.getBlockFromItem(playerIn.getHeldItemMainhand().getItem())
						.getStateFromMeta(itemstack.getMetadata())
						.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(origin, playerIn));
				if (blockstate.getBlock().canPlaceBlockAt(worldIn, aPos))
					if (worldIn.setBlockState(aPos, blockstate))
						success = true;
			} catch (Exception e)
			{
				try
				{
					// attempt to place as a four-directional block, e.g. furnace
					blockstate = (IBlockState) Block.getBlockFromItem(playerIn.getHeldItemMainhand().getItem())
							.getStateFromMeta(itemstack.getMetadata())
							.withProperty(FACING, playerIn.getHorizontalFacing().getOpposite());
					if (blockstate.getBlock().canPlaceBlockAt(worldIn, aPos))
						if (worldIn.setBlockState(aPos, blockstate))
							success = true;

				} catch (Exception e2)
				{
					try
					{
						// attempt to place as a normal block, e.g. dirt
						blockstate = (IBlockState) Block.getBlockFromItem(playerIn.getHeldItemMainhand().getItem())
								.getStateFromMeta(itemstack.getMetadata());
						if (blockstate.getBlock().canPlaceBlockAt(worldIn, aPos))
							if (worldIn.setBlockState(aPos, blockstate))
								success = true;
					} catch (Exception e3)
					{
					}
				}
			}
			// if the block was placed, fire particles, play sound, and all the fancy stuff
			if (success)
			{
				this.partLoc = aPos;
				this.particle = true;

				SoundType soundtype = block.getSoundType();
				worldIn.playSound(null, aPos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.playSound(null, pos, SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.BLOCKS, 0.5F, 0.8F);
				if (!playerIn.capabilities.isCreativeMode)
					playerIn.getHeldItemMainhand().shrink(1); // TODO: update this
			} else
				playerIn.sendMessage(new TextComponentTranslation("The bridge block is unable to affect that location",
						new Object[0]));

		}
		return true;
	}

	/**
	 * This is the only way to display particles without a tile entity. It gets
	 * fired at random, so the particle variable is used to schedule particles for
	 * the next tick
	 */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		if (this.particle)
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 2; j++)
					worldIn.spawnParticle(EnumParticleTypes.PORTAL, this.partLoc.getX() + 0.5,
							this.partLoc.getY() + 0.5, this.partLoc.getZ() + 0.5, (rand.nextDouble() * 2) - 1,
							(rand.nextDouble() * 2) - 1.5, (rand.nextDouble() * 2) - 1, new int[0]);

		this.particle = false;
	}
}