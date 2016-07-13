package com.team.kalstuff.block;

import com.team.KalStuff;
import com.team.kalstuff.StartupCommon;
import com.team.kalstuff.tileentity.TileEntityChickenNest;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockChickenNest extends BlockContainer {
	public static final AxisAlignedBB AABB = new AxisAlignedBB(0d, 0d, 0d, 1d, 3d / 16d, 1d);

	public BlockChickenNest() {
		super(Material.PLANTS);
		// this.setStepSound(soundTypeGrass);
		this.setCreativeTab(StartupCommon.KALSTUFF);
		this.setHardness(0.4F);

	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}

	/*
	 * 
	 * //These lines are presumed unnecessary, but were in the BlockSlab file.
	 * If problems arise // related to the bounding boxes, try un-commenting
	 * this. public void addCollisionBoxesToList(World worldIn, BlockPos pos,
	 * IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity)
	 * { this.setBlockBoundsBasedOnState(worldIn, pos);
	 * super.addCollisionBoxesToList(worldIn, pos, state, mask, list,
	 * collidingEntity); }
	 * 
	 * public void setBlockBoundsForItemRender() { this.setBlockBounds(0.0F,
	 * 0.0F, 0.0F, 1.0F, 0.5F, 1.0F); }
	 */

	// Called when the block is placed or loaded client side to get the tile
	// entity for the block
	// Should return a new instance of the tile entity for the block
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityChickenNest();
	}

	// Called when the block is right clicked
	// In this block it is used to open the blocks gui when right clicked by a
	// player
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		// Uses the gui handler registered to your mod to open the gui for the
		// given gui id
		// open on the server side only (not sure why you shouldn't open client
		// side too... vanilla doesn't, so we better not either)
		if (worldIn.isRemote)
			return true;

		if (playerIn.isSneaking()) {
			TileEntityChickenNest tileentitychickennest = (TileEntityChickenNest) worldIn.getTileEntity(pos);
			tileentitychickennest.dropChicken();
		} else
			playerIn.openGui(KalStuff.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());

		return true;
	}

	// This is where you can do something when the block is broken. In this case
	// drop the inventory's contents
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

		IInventory inventory = worldIn.getTileEntity(pos) instanceof IInventory
				? (IInventory) worldIn.getTileEntity(pos) : null;

		if (inventory != null) {
			// For each slot in the inventory
			for (int i = 0; i < inventory.getSizeInventory(); i++) {
				// If the slot is not empty
				if (inventory.getStackInSlot(i) != null) {
					// Create a new entity item with the item stack in the slot
					EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
							inventory.getStackInSlot(i));

					// Apply some random motion to the item
					float multiplier = 0.1f;
					float motionX = worldIn.rand.nextFloat() - 0.5f;
					float motionY = worldIn.rand.nextFloat() - 0.5f;
					float motionZ = worldIn.rand.nextFloat() - 0.5f;

					item.motionX = motionX * multiplier;
					item.motionY = motionY * multiplier;
					item.motionZ = motionZ * multiplier;

					// Spawn the item in the world
					worldIn.spawnEntityInWorld(item);
				}
			}

			// Clear the inventory so nothing else (such as another mod) can do
			// anything with the items
			inventory.clear();
		}

		// Super MUST be called last because it removes the tile entity
		super.breakBlock(worldIn, pos, state);
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.SOLID;
	}
	
	 /**
     * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
     */
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
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