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
	
	boolean particle = false;
	BlockPos partLoc;
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
	public BlockBridge() throws StackOverflowError, IllegalArgumentException, NullPointerException {
	super(Material.wood);
	this.setCreativeTab(StartupCommon.kalStuffTab);
    this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    this.setHardness(0.5f);
}

	 @SideOnly(Side.CLIENT)
	 public EnumWorldBlockLayer getBlockLayer() {
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
		return chain(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ, pos);
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
	    
	    public boolean chain(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ, BlockPos origin) {
	    				
	    	BlockPos aPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
	    	if (worldIn.isRemote) return true;
			
	    	try {Block.getBlockFromItem(playerIn.getCurrentEquippedItem().getItem());}
	    	catch (Exception e) {return true;}
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

				if (aPos == origin) return true;
				
				if (worldIn.getBlockState(aPos).getBlock().getDefaultState() == StartupCommon.blockBridge.getDefaultState()) {
					BlockBridge aBridge = (BlockBridge) worldIn.getBlockState(aPos).getBlock();
					
					try {
						aBridge.chain(worldIn, aPos, worldIn.getBlockState(aPos), playerIn, side, hitX, hitY, hitZ, origin);
					} catch (StackOverflowError e) {}
					
				} else {
	
					IBlockState block;
			      
					 try {
						block = (IBlockState) Block.getBlockFromItem(playerIn.getCurrentEquippedItem().getItem()).getDefaultState().withProperty(FACING, BlockPistonBase.getFacingFromEntity(worldIn, origin, playerIn));
						worldIn.setBlockState(aPos, block);
						this.partLoc = aPos;
						this.particle = true;
						worldIn.playSoundEffect(aPos.getX(), aPos.getY(), aPos.getZ(), block.getBlock().stepSound.getBreakSound(), 1.0f, 1.0f);
			            if (!playerIn.capabilities.isCreativeMode) --playerIn.getCurrentEquippedItem().stackSize;
					 } catch (Exception error) {
						 try {
							 block = (IBlockState) Block.getBlockFromItem(playerIn.getCurrentEquippedItem().getItem()).getDefaultState().withProperty(FACING, playerIn.getHorizontalFacing().getOpposite());;
								worldIn.setBlockState(aPos, block);
								this.partLoc = aPos;
								this.particle = true;
								worldIn.playSoundEffect(aPos.getX(), aPos.getY(), aPos.getZ(), block.getBlock().stepSound.getBreakSound(), 1.0f, 1.0f);
					            if (!playerIn.capabilities.isCreativeMode) --playerIn.getCurrentEquippedItem().stackSize;
						 } catch (Exception error2) {
							 try {
								 block = (IBlockState) Block.getBlockFromItem(playerIn.getCurrentEquippedItem().getItem()).getDefaultState();
								worldIn.setBlockState(aPos, block);
								this.partLoc = aPos;
								this.particle = true;
								worldIn.playSoundEffect(aPos.getX(), aPos.getY(), aPos.getZ(), block.getBlock().stepSound.getBreakSound(), 1.0f, 1.0f);
					            if (!playerIn.capabilities.isCreativeMode) --playerIn.getCurrentEquippedItem().stackSize;
							 } catch (Exception error3) {}
						 }
					 }
				}
	    	
			
	    	return true;
			

	    }
	    @SideOnly(Side.CLIENT)
	    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
	           if (this.particle)
	        	   for (int i = 0; i < 8; i ++) {
	                   worldIn.spawnParticle(EnumParticleTypes.PORTAL, this.partLoc.getX() + 0.5, this.partLoc.getY() + 0.5, this.partLoc.getZ() + 0.5, (rand.nextDouble() * 2) - 1, (rand.nextDouble() * 2) - 1.5, (rand.nextDouble() * 2) - 1, new int[0]);
	        	   }
	          this.particle = false;
	    }
	   // public BlockPos findNextPosition(World worldIn, BlockPos pos)
}