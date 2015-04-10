package com.team.kalstuff;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
//

// What comment not working?

public class BlockBridge extends Block {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
	public BlockBridge() {
	super(Material.wood);
	this.setCreativeTab(StartupCommon.kalStuffTab);
    this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    this.setHardness(0.5f);
}

	 @SideOnly(Side.CLIENT)
	 public EnumWorldBlockLayer getBlockLayer()
	 {
	 return EnumWorldBlockLayer.SOLID;
	 }

	 @Override
	 public boolean isOpaqueCube() {
	 return true;
	 }
	 
	 @Override
	 public boolean isFullCube() {
	 return true;
	 }
	 
	 @Override
	 public int getRenderType() {
	 return 3;
	 }
	 
	 @Override
	 public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	    {
			// TODO Auto-generated method stub
			BlockPos aPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
			BlockPos aPos2 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
			if (worldIn.isRemote) return true;
			if (playerIn.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(Blocks.planks)) {
				
				if (state.getValue(FACING).equals(EnumFacing.EAST)) while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState()) aPos = new BlockPos(aPos.getX() + 1, aPos.getY(), aPos.getZ());
				if (state.getValue(FACING).equals(EnumFacing.WEST)) while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState()) aPos = new BlockPos(aPos.getX() - 1, aPos.getY(), aPos.getZ());
				if (state.getValue(FACING).equals(EnumFacing.UP)) while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState()) aPos = new BlockPos(aPos.getX(), aPos.getY() + 1, aPos.getZ());
				if (state.getValue(FACING).equals(EnumFacing.DOWN)) while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState()) aPos = new BlockPos(aPos.getX(), aPos.getY() - 1, aPos.getZ());
				if (state.getValue(FACING).equals(EnumFacing.NORTH)) while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState()) aPos = new BlockPos(aPos.getX(), aPos.getY(), aPos.getZ() - 1);
				if (state.getValue(FACING).equals(EnumFacing.SOUTH)) while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState()) aPos = new BlockPos(aPos.getX(), aPos.getY(), aPos.getZ() + 1);

				
				Random rand = new Random();
				worldIn.setBlockState(aPos, Block.getBlockFromItem(playerIn.getCurrentEquippedItem().getItem()).getStateFromMeta(playerIn.getCurrentEquippedItem().getMetadata()));
				for (int i = 0; i < 16; ++i)
                {
                    worldIn.spawnParticle(EnumParticleTypes.PORTAL, aPos.getX(), aPos.getY() + rand.nextDouble() * 2.0D, aPos.getZ(), rand.nextGaussian(), 0.0D, rand.nextGaussian(), new int[0]);
                }
	            worldIn.playSoundEffect(aPos.getX(), aPos.getY(), aPos.getZ(), "dig.wood", 1.0f, 1.0f);
				System.out.println(state.getValue(FACING));	
				if (!playerIn.capabilities.isCreativeMode) --playerIn.getCurrentEquippedItem().stackSize;

			}
			return true;
	    }
	 
	    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	    {
	        super.onBlockAdded(worldIn, pos, state);
	        this.setDefaultDirection(worldIn, pos, state);
	    }
	    
	    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	    {
	        return this.getDefaultState().withProperty(FACING, BlockPistonBase.getFacingFromEntity(worldIn, pos, placer));
	    }

	    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	    {
	        worldIn.setBlockState(pos, state.withProperty(FACING, BlockPistonBase.getFacingFromEntity(worldIn, pos, placer)), 2);

	   /*     if (stack.hasDisplayName())
	        {
	            TileEntity tileentity = worldIn.getTileEntity(pos);

	            if (tileentity instanceof TileEntityDispenser)
	            {
	                ((TileEntityDispenser)tileentity).setCustomName(stack.getDisplayName());
	            }
	        }*/
	    }
	    
	    
	    
	    
	    
	    
	    

	    private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state)
	    {
	        if (!worldIn.isRemote)
	        {
	            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
	            boolean flag = worldIn.getBlockState(pos.north()).getBlock().isFullBlock();
	            boolean flag1 = worldIn.getBlockState(pos.south()).getBlock().isFullBlock();

	            if (enumfacing == EnumFacing.NORTH && flag && !flag1)
	            {
	                enumfacing = EnumFacing.SOUTH;
	            }
	            else if (enumfacing == EnumFacing.SOUTH && flag1 && !flag)
	            {
	                enumfacing = EnumFacing.NORTH;
	            }
	            else
	            {
	                boolean flag2 = worldIn.getBlockState(pos.west()).getBlock().isFullBlock();
	                boolean flag3 = worldIn.getBlockState(pos.east()).getBlock().isFullBlock();

	                if (enumfacing == EnumFacing.WEST && flag2 && !flag3)
	                {
	                    enumfacing = EnumFacing.EAST;
	                }
	                else if (enumfacing == EnumFacing.EAST && flag3 && !flag2)
	                {
	                    enumfacing = EnumFacing.WEST;
	                }
	            }

	            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
	        }
	    }
	    
	    public static EnumFacing getFacing(int meta)
	    {
	        return EnumFacing.getFront(meta & 7);
	    }
	    
	    public IBlockState getStateForEntityRender(IBlockState state)
	    {
	        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
	    }

	    public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState();
	    }

	    public int getMetaFromState(IBlockState state)
	    {
	        byte b0 = 0;
	        int i = b0 | ((EnumFacing)state.getValue(FACING)).getIndex();



	        return i;
	    }

	    
	    protected BlockState createBlockState()
	    {
	        return new BlockState(this, new IProperty[] {FACING});
	    }
}