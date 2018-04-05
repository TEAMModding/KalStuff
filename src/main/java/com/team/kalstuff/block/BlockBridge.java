package com.team.kalstuff.block;

import java.util.Random;

import com.team.kalstuff.KalStuff;
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
import net.minecraft.item.ItemBlock;
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
		return chain(worldIn, pos, state, playerIn, hand, side, hitX, hitY, hitZ, pos);
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
	public boolean chain(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ, BlockPos origin)
	{
		if (world.isRemote)
			return true;

		ItemStack itemstack = player.getHeldItemMainhand();
		Block block;
		// attempt to get a block from the held item without crashing the game
		try
		{
			block = Block.getBlockFromItem(itemstack.getItem());
		}
		catch (Exception e)
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
			player.sendMessage(new TextComponentTranslation("The bridge is unable to send this"));
			return true;
		}

		// get next position that the bridge block is pointing towards
		BlockPos aPos = this.getNextBlock(pos, state, world);
		int dist = (int) aPos.getDistance(pos.getX(), pos.getY(), pos.getZ());

		// check for unbreakable or very hard blocks - should only catch unbreakable
		// blocks (e.g. bedrock), obsidian, and water by default (we explicitly allow
		// lava)
		if (world.getBlockState(aPos).getBlockHardness(world, aPos) == -1.0F
				|| (world.getBlockState(aPos).getBlockHardness(world, aPos) >= 50.0F
						&& world.getBlockState(aPos).getBlock() != Blocks.LAVA
						&& world.getBlockState(aPos).getBlock() != Blocks.FLOWING_LAVA))
		{
			player.sendMessage(new TextComponentTranslation("Something is blocking the bridge"));
			KalStuff.logger.info(world.getBlockState(aPos).getBlock());
			return true;
		}
		// if the bridge blocks have chained back to the first one, return
		if (aPos.equals(origin))
			return true;
		// if the found position is more than sixteen blocks away despite all of the
		// checks above, then send a message that the bridge cannot reach that far
		if (dist > 16)
		{
			player.sendMessage(new TextComponentTranslation("The bridge cannot reach that far"));
			return true;
		}

		// if a bridge block is found
		if (world.getBlockState(aPos).getBlock().getDefaultState() == KalStuffBlocks.BRIDGE.getDefaultState())
		{
			BlockBridge target = (BlockBridge) world.getBlockState(aPos).getBlock();
			// attempt to "chain" the target bridge
			try
			{
				target.chain(world, aPos, world.getBlockState(aPos), player, hand, side, hitX, hitY, hitZ, origin);
			} catch (StackOverflowError e) {}

		} else if (dist <= 16 && block.canPlaceBlockAt(world, aPos))
		{ // if air is found
			boolean success = false;
			IBlockState blockstate, directional;
			blockstate = Block.getBlockFromItem(player.getHeldItem(hand).getItem()).getStateForPlacement(world, aPos,
					side, hitX, hitY, hitZ, itemstack.getMetadata(), player, hand);
			try
			{ // try placing as a six-directional block
				directional = blockstate.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(origin, player));
				if (((ItemBlock) player.getHeldItem(hand).getItem()).placeBlockAt(itemstack, player, world, aPos, side,
						hitZ, hitZ, hitZ, directional))
					success = true;
			}
			catch (Exception e)
			{
				try
				{ // set the block without a direction - we kept the blockstate backup because I
					// don't know how to remove a property from a block :P
					// oh and by the way, Vanilla blocks with quad-rotations (e.g. furnaces) will
					// still magically get their rotation - I'm not entirely sure how. Note that for
					// some reason they will never place facing a solid block if there's an opening
					// (air) available. They'll just rotate away from it. Or at least furnaces
					// do, anyway, those are the only blocks I tried
					if (((ItemBlock) player.getHeldItem(hand).getItem()).placeBlockAt(itemstack, player, world, aPos,
							side, hitZ, hitZ, hitZ, blockstate))
						success = true;
				} catch (Exception g) {}
			}

			// if the block was placed, fire particles, play sound, and all the fancy stuff
			if (success)
			{
				this.partLoc = aPos;
				this.particle = true;

				SoundType soundtype = block.getSoundType();
				world.playSound(null, aPos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
				world.playSound(null, pos, SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.BLOCKS, 0.5F, 0.8F);
				if (!player.capabilities.isCreativeMode)
					player.getHeldItemMainhand().shrink(1); // TODO: update this
			} else
				player.sendMessage(new TextComponentTranslation("The bridge is unable to affect that location"));

		}
		return true;
	}

	public BlockPos getNextBlock(BlockPos pos, IBlockState state, World world)
	{
		BlockPos aPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
		IBlockState blockstate;
		int i = 0;
		do
		{
			switch (state.getValue(FACING).getIndex())
			{
			case 0:
				aPos = aPos.down();
				break;
			case 1:
				aPos = aPos.up();
				break;
			case 2:
				aPos = aPos.north();
				break;
			case 3:
				aPos = aPos.south();
				break;	
			case 4:
				aPos = aPos.west();
				break;
			case 5:
				aPos = aPos.east();
				break;
			}
			blockstate = world.getBlockState(aPos);
			KalStuff.logger.info(aPos);
		} while (blockstate != Blocks.AIR.getDefaultState()
				&& blockstate.getBlock().getDefaultState() != KalStuffBlocks.BRIDGE.getDefaultState() && i++ <= 16
				&& blockstate.getBlockHardness(world, aPos) != -1.0F
				&& blockstate.getBlockHardness(world, aPos) < 50.0F);
		return aPos;
	}

	/**
	 * This is the only way to display particles without a tile entity. It gets
	 * fired at random, so the particle variable is used to schedule particles for
	 * the next tick.
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