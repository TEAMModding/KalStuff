package com.team.kalstuff.block;

import javax.annotation.Nullable;

import com.team.kalstuff.KalStuff;
import com.team.kalstuff.tileentity.TileEntityChickenNest;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockChickenNest extends BlockKalStuff implements ITileEntityProvider
{
	public static final AxisAlignedBB AABB = new AxisAlignedBB(0D, 0D, 0D, 1D, 3D / 16D, 1D);

	public BlockChickenNest(String name)
	{
		super(Material.PLANTS, name);
		// this.setStepSound(soundTypeGrass);
		this.setHardness(0.4F);

	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return AABB;
	}

	/** 
	 * Called when the block is placed or loaded client
	 * side to get the tile entity for the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityChickenNest();
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
			return true;
		
		TileEntity te = worldIn.getTileEntity(pos);
		if (!(te instanceof TileEntityChickenNest)) return false;
		
		if (playerIn.isSneaking())
		{		
			((TileEntityChickenNest) te).dropChicken();
		} else
		{
			playerIn.openGui(KalStuff.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public void harvestBlock(final World world, final EntityPlayer player, final BlockPos pos, final IBlockState state, @Nullable final TileEntity te, final ItemStack tool) {
		super.harvestBlock(world, player, pos, state, te, tool);
		world.setBlockToAir(pos);
	}

	// This is where you can do something when the block is broken. In this case drop the inventory's contents
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		
		TileEntity te = worldIn.getTileEntity(pos);
		if ((te instanceof TileEntityChickenNest)) ((TileEntityChickenNest) te).dropItems(worldIn, pos);
		
		// Super MUST be called last because it removes the tile entity
		super.breakBlock(worldIn, pos, state);
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
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
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
}