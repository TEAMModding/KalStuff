package com.team.kalstuff.block;

import java.util.Random;
import com.team.kalstuff.StartupCommon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBridge extends Block {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
	public BlockBridge() throws StackOverflowError {
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
			if (worldIn.isRemote) return true;
			
				if (Block.getBlockFromItem(playerIn.getCurrentEquippedItem().getItem()) != null) {

				if (state.getValue(FACING).equals(EnumFacing.EAST)) 
					do aPos = new BlockPos(aPos.getX() + 1, aPos.getY(), aPos.getZ());
					while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());
						
				
				if (state.getValue(FACING).equals(EnumFacing.WEST)) 
					do aPos = new BlockPos(aPos.getX() - 1, aPos.getY(), aPos.getZ());
					while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());
						
				
				if (state.getValue(FACING).equals(EnumFacing.UP))
					do aPos = new BlockPos(aPos.getX(), aPos.getY() + 1, aPos.getZ());
					while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());
						
				
				if (state.getValue(FACING).equals(EnumFacing.DOWN)) 
					do aPos = new BlockPos(aPos.getX(), aPos.getY() - 1, aPos.getZ());
					while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());

				
				if (state.getValue(FACING).equals(EnumFacing.NORTH)) 
					do aPos = new BlockPos(aPos.getX(), aPos.getY(), aPos.getZ() - 1);
					while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());

				
				if (state.getValue(FACING).equals(EnumFacing.SOUTH)) 
					do 	aPos = new BlockPos(aPos.getX(), aPos.getY(), aPos.getZ() + 1);
					while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());

				
				if (worldIn.getBlockState(aPos).getBlock().getDefaultState() == StartupCommon.blockBridge.getDefaultState()) {
					System.out.println("It's a bridge block here.");
					BlockBridge aBridge = (BlockBridge) worldIn.getBlockState(aPos).getBlock();
		        	aBridge.chain(worldIn, aPos, worldIn.getBlockState(aPos), playerIn, side, hitX, hitY, hitZ, pos);
				} else {

				IBlockState block;
		        if (Block.getBlockFromItem(playerIn.getCurrentEquippedItem().getItem()).getDefaultState() == StartupCommon.blockBridge.getDefaultState()) {

		        	block = StartupCommon.blockBridge.getDefaultState().withProperty(FACING, BlockPistonBase.getFacingFromEntity(worldIn, pos, playerIn));
		        }
		        else block = Block.getBlockFromItem(playerIn.getCurrentEquippedItem().getItem()).getStateFromMeta(playerIn.getCurrentEquippedItem().getMetadata());
		        
				Random rand = new Random();
				worldIn.setBlockState(aPos, block);
				for (int i = 0; i < 16; ++i)
                {
                    worldIn.spawnParticle(EnumParticleTypes.PORTAL, aPos.getX(), aPos.getY() + rand.nextDouble() * 2.0D, aPos.getZ(), rand.nextGaussian(), 0.0D, rand.nextGaussian(), new int[0]);
                }
	            worldIn.playSoundEffect(aPos.getX(), aPos.getY(), aPos.getZ(), "dig.wood", 1.0f, 1.0f);
				System.out.println(state.getValue(FACING));	
				if (!playerIn.capabilities.isCreativeMode) --playerIn.getCurrentEquippedItem().stackSize;
				}
				}
			
			return true;
	    }

	    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	    {
	        return this.getDefaultState().withProperty(FACING, BlockPistonBase.getFacingFromEntity(worldIn, pos, placer));
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
	    
	    public boolean chain(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ, BlockPos firstPos) {
	    	// TODO Auto-generated method stub
	    				BlockPos aPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
	    				if (worldIn.isRemote) return true;
	    				
	    					if (Block.getBlockFromItem(playerIn.getCurrentEquippedItem().getItem()) != null) {

	    					if (state.getValue(FACING).equals(EnumFacing.EAST)) 
	    						do aPos = new BlockPos(aPos.getX() + 1, aPos.getY(), aPos.getZ());
	    						while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());
	    							
	    					
	    					if (state.getValue(FACING).equals(EnumFacing.WEST)) 
	    						do aPos = new BlockPos(aPos.getX() - 1, aPos.getY(), aPos.getZ());
	    						while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());
	    							
	    					
	    					if (state.getValue(FACING).equals(EnumFacing.UP))
	    						do aPos = new BlockPos(aPos.getX(), aPos.getY() + 1, aPos.getZ());
	    						while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());
	    							
	    					
	    					if (state.getValue(FACING).equals(EnumFacing.DOWN)) 
	    						do aPos = new BlockPos(aPos.getX(), aPos.getY() - 1, aPos.getZ());
	    						while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());

	    					
	    					if (state.getValue(FACING).equals(EnumFacing.NORTH)) 
	    						do aPos = new BlockPos(aPos.getX(), aPos.getY(), aPos.getZ() - 1);
	    						while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());

	    					
	    					if (state.getValue(FACING).equals(EnumFacing.SOUTH)) 
	    						do 	aPos = new BlockPos(aPos.getX(), aPos.getY(), aPos.getZ() + 1);
	    						while (worldIn.getBlockState(aPos) != Blocks.air.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.blockBridge.getDefaultState());

	    					if (aPos == firstPos) return true;
	    					else if (worldIn.getBlockState(aPos).getBlock().getDefaultState() == StartupCommon.blockBridge.getDefaultState()) {
	    						BlockBridge aBridge = (BlockBridge) worldIn.getBlockState(aPos).getBlock();
	    						try {
	    			        	aBridge.chain(worldIn, aPos, worldIn.getBlockState(aPos), playerIn, side, hitX, hitY, hitZ, pos);
	    						} catch (StackOverflowError e) {
	    							System.out.println(playerIn.getName() + " tried to make a bridge block loop! But we stopped them.");
	    						}
	    					} else {

	    					IBlockState block;
	    			        if (Block.getBlockFromItem(playerIn.getCurrentEquippedItem().getItem()).getDefaultState() == StartupCommon.blockBridge.getDefaultState()) {

	    			        	block = StartupCommon.blockBridge.getDefaultState().withProperty(FACING, BlockPistonBase.getFacingFromEntity(worldIn, pos, playerIn));
	    			        }
	    			        else block = Block.getBlockFromItem(playerIn.getCurrentEquippedItem().getItem()).getStateFromMeta(playerIn.getCurrentEquippedItem().getMetadata());
	    			        
	    					Random rand = new Random();
	    					worldIn.setBlockState(aPos, block);
	    					for (int i = 0; i < 16; ++i)
	    	                {
	    	                    worldIn.spawnParticle(EnumParticleTypes.PORTAL, aPos.getX(), aPos.getY() + rand.nextDouble() * 2.0D, aPos.getZ(), rand.nextGaussian(), 0.0D, rand.nextGaussian(), new int[0]);
	    	                }
	    		            worldIn.playSoundEffect(aPos.getX(), aPos.getY(), aPos.getZ(), "dig.wood", 1.0f, 1.0f);
	    					System.out.println(state.getValue(FACING));	
	    					if (!playerIn.capabilities.isCreativeMode) --playerIn.getCurrentEquippedItem().stackSize;
	    					}
	    					}
	    				
	    				return true;
	    }
	    
	   // public BlockPos findNextPosition(World worldIn, BlockPos pos)
}