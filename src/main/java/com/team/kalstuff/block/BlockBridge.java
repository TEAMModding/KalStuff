package com.team.kalstuff.block;

import java.util.Random;

import com.team.kalstuff.StartupCommon;
import com.team.kalstuff.config.Configs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBridge extends Block {
	
	boolean particle = false;
	BlockPos partLoc;
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    
	public BlockBridge() throws StackOverflowError, IllegalArgumentException, NullPointerException {
		super(Material.WOOD);
		this.setCreativeTab(StartupCommon.KALSTUFF);
    	this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    	this.setHardness(0.5f);
	}

	 
	 @SideOnly(Side.CLIENT)
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.SOLID;
		}

	 @Override
	 public boolean isOpaqueCube(IBlockState state) {
	 return true;
	 }
	 
	 @Override
	 public boolean isFullCube(IBlockState state) {
		 return true;
	 }
	 
	 public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		 return chain(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ, pos);
	    }

	    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
	        return this.getDefaultState().withProperty(FACING, BlockPistonBase.getFacingFromEntity(pos, placer));
	    }

	    public static EnumFacing getFacing(int meta) {
	        return EnumFacing.getFront(meta & 7);
	    }
	    
	    public IBlockState getStateForEntityRender(IBlockState state) {
	        return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
	    }

	    public IBlockState getStateFromMeta(int meta) {
	        return this.getDefaultState();
	    }

	    public int getMetaFromState(IBlockState state) {
	        byte b0 = 0;
	        int i = b0 | ((EnumFacing)state.getValue(FACING)).getIndex();



	        return i;
	    }

	    
	    protected BlockStateContainer createBlockState() {
	        return new BlockStateContainer(this, new IProperty[] {FACING});
	    }
	    
	    @SuppressWarnings("deprecation")
		public boolean chain(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ, BlockPos origin) {
			
	    	if (worldIn.isRemote) return true;
	    	
	    	ItemStack itemstack = playerIn.getHeldItemMainhand();
			Block block;
	    	try {block = Block.getBlockFromItem(itemstack.getItem());}
	    	catch (Exception e) {return true;}
	    	if (block == null) return true;
	    	
	    	if ((!EntityEnderman.getCarriable(block) && block != StartupCommon.bridge) || (Configs.bridgeTNT && block == Blocks.TNT)) {
	    		playerIn.addChatMessage(new TextComponentTranslation("The bridge is unable to send this block", new Object[0]));
	    		return true;
	    	}
	    	
	    	BlockPos aPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
	    	
	    	int i = 0;
	    	if (state.getValue(FACING).equals(EnumFacing.EAST))
	    		do {
	    			aPos = new BlockPos(aPos.getX() + 1, aPos.getY(), aPos.getZ());
	    			i ++;
	    		}
	    		while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.bridge.getDefaultState());
	    	
	    	if (state.getValue(FACING).equals(EnumFacing.WEST))
	    		do {
	    			aPos = new BlockPos(aPos.getX() - 1, aPos.getY(), aPos.getZ());
	    			i ++;
	    		}
	    		while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.bridge.getDefaultState());
	    	
	    	if (state.getValue(FACING).equals(EnumFacing.UP))
	    		do {
	    			aPos = new BlockPos(aPos.getX(), aPos.getY() + 1, aPos.getZ());
	    			i ++;
	    		}
	    		while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.bridge.getDefaultState());
				
	    	if (state.getValue(FACING).equals(EnumFacing.DOWN))
	    		do {
	    			aPos = new BlockPos(aPos.getX(), aPos.getY() - 1, aPos.getZ());
	    			i ++;
	    		}
	    		while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.bridge.getDefaultState());
				
	    	if (state.getValue(FACING).equals(EnumFacing.NORTH))
	    		do {
	    			aPos = new BlockPos(aPos.getX(), aPos.getY(), aPos.getZ() - 1);
	    			i ++;
	    		}
	    		while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.bridge.getDefaultState());
	    	
	    	if (state.getValue(FACING).equals(EnumFacing.SOUTH))
	    		do 	{
	    			aPos = new BlockPos(aPos.getX(), aPos.getY(), aPos.getZ() + 1);
	    			i ++;
	    		}
	    		while (worldIn.getBlockState(aPos) != Blocks.AIR.getDefaultState() && worldIn.getBlockState(aPos).getBlock().getDefaultState() != StartupCommon.bridge.getDefaultState());
	    	
	    	if (aPos == origin) return true;
	    	if (i > 16) {
	    		playerIn.addChatMessage(new TextComponentTranslation("The bridge cannot reach that far", new Object[0]));
	    		return true;
	    	}
	    	
	    	if (worldIn.getBlockState(aPos).getBlock().getDefaultState() == StartupCommon.bridge.getDefaultState()) {
	    		BlockBridge aBridge = (BlockBridge) worldIn.getBlockState(aPos).getBlock();
	    			
	    		try {
	    			aBridge.chain(worldIn, aPos, worldIn.getBlockState(aPos), playerIn, side, hitX, hitY, hitZ, origin);
	    		} catch (StackOverflowError e) {}
	    		
	    	} else if (i <= 16 && worldIn.canBlockBePlaced(block, aPos, true, BlockPistonBase.getFacingFromEntity(pos, playerIn), playerIn, itemstack)) {
	    		boolean success = false;
	    		IBlockState blockstate;
	    		try {
	    			blockstate = (IBlockState) Block.getBlockFromItem(playerIn.getHeldItemMainhand().getItem()).getStateFromMeta(itemstack.getMetadata()).withProperty(FACING, BlockPistonBase.getFacingFromEntity(origin, playerIn));
	    			if (blockstate.getBlock().canPlaceBlockAt(worldIn, aPos)) worldIn.setBlockState(aPos, blockstate);
	    			success = true;
	    		} catch (Exception e) {
	    			try {
	    				blockstate = (IBlockState) Block.getBlockFromItem(playerIn.getHeldItemMainhand().getItem()).getStateFromMeta(itemstack.getMetadata()).withProperty(FACING, playerIn.getHorizontalFacing().getOpposite());
	    				if (blockstate.getBlock().canPlaceBlockAt(worldIn, aPos)) worldIn.setBlockState(aPos, blockstate);
	    				success = true;
	    			} catch (Exception e2) {
	    				try {
	    					blockstate = (IBlockState) Block.getBlockFromItem(playerIn.getHeldItemMainhand().getItem()).getStateFromMeta(itemstack.getMetadata());
	    					if (blockstate.getBlock().canPlaceBlockAt(worldIn, aPos)) worldIn.setBlockState(aPos, blockstate);
	    					success = true;
	    				} catch (Exception e3) {}
	    			}
	    		}
	    		System.out.println(i);
	    		if (success) {
	    			this.partLoc = aPos;
	    			this.particle = true;
	    			
	    			SoundType soundtype = block.getSoundType();
	    			worldIn.playSound(null, aPos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
	    			worldIn.playSound(null, pos, SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.BLOCKS, 0.5F, 0.8F);
	    			if (!playerIn.capabilities.isCreativeMode) --playerIn.getHeldItemMainhand().stackSize;
	    		}

	    	}
			return true;
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
	    	
	    	if (this.particle)
	    		for (int i = 0; i < 8; i ++)
	    			for (int j = 0; j < 2; j ++)
	    				worldIn.spawnParticle(EnumParticleTypes.PORTAL, this.partLoc.getX() + 0.5, this.partLoc.getY() + 0.5, this.partLoc.getZ() + 0.5, (rand.nextDouble() * 2) - 1, (rand.nextDouble() * 2) - 1.5, (rand.nextDouble() * 2) - 1, new int[0]);
	    	
	    	this.particle = false;
	    }
}