package com.team.kalstuff;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ItemEnderPowder extends Item {
	
		public ItemEnderPowder()
		{
		this.setMaxStackSize(64);
		this.setCreativeTab(StartupCommon.kalStuffTab); // the item will appear on the Miscellaneous tab in creative
		}
		
		public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	    {
			Random rand = new Random();
	        if (playerIn.capabilities.isCreativeMode)
	        {
	            return itemStackIn;
	        }
	        else
	        {
	            --itemStackIn.stackSize;
	            worldIn.playSoundEffect(playerIn.posX, playerIn.posY, playerIn.posZ, "mob.endermen.portal", 1.0F, 1.0F);
	            playerIn.playSound("mob.endermen.portal", 1.0F, 1.0F);
	            for (int i = 0; i < 32; ++i)
                {
                    worldIn.spawnParticle(EnumParticleTypes.PORTAL, playerIn.posX, playerIn.posY + rand.nextDouble() * 2.0D, playerIn.posZ, rand.nextGaussian(), 0.0D, rand.nextGaussian(), new int[0]);
                }
	            if (!worldIn.isRemote)
	            {
	            	 if (!playerIn.isPlayerSleeping())
	                    {
	                    	double randX = playerIn.posX, randY = playerIn.posY, randZ = playerIn.posZ;
	                    	
	                    	int maxTries = 100;
	                    	int loopCount = 0;
	                    	for(boolean goodPos = false; goodPos == false && loopCount < maxTries;) {

	                    		randX = (playerIn.posX + rand.nextInt(20) - 10);
	                    		randY = (playerIn.posY + rand.nextInt(20) - 10);
	                    		randZ = (playerIn.posZ + rand.nextInt(20) - 10);
	                    		BlockPos aPos = new BlockPos(randX, randY, randZ);
	                    		BlockPos aPos2 = new BlockPos(randX, randY + 1, randZ);
	                    		BlockPos aPos3 = new BlockPos(randX, randY + 2, randZ);
	                            Block block = worldIn.getBlockState(aPos).getBlock();
	                            Block block2 = worldIn.getBlockState(aPos2).getBlock();
	                            Block block3 = worldIn.getBlockState(aPos3).getBlock();
		                    	System.out.println(randX + ", " + randY + ", " + randZ);
	                    	if (loopCount <= (maxTries / 3) * 2) {
	                    			if (block.getMaterial().blocksMovement() &&
	                    				!block2.getMaterial().blocksMovement() &&
	                    				!block3.getMaterial().blocksMovement()){
	                    					randY ++;
	                    					goodPos = true;
	                    			}		
	                    	} else {
	                    		if (!block2.getMaterial().blocksMovement() &&
	                    			!block3.getMaterial().blocksMovement())
	                    				goodPos = true;
	                    	}
	                    		loopCount ++;
	                    		if (loopCount >= maxTries && goodPos == false) {
	                    			randX = playerIn.posX;
	                    			randY = playerIn.posY;
	                    			randZ = playerIn.posZ;
	                    			goodPos = true;
	                    		}
	                    	}
	                    	
	                    	System.out.println(randX + ", " + randY + ", " + randZ);
	                    	net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(playerIn, randX, randY, randZ, 2.0F);
	                        if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
	                        { // Don't indent to lower patch size
	                        if (rand.nextFloat() < 0.03F && worldIn.getGameRules().getGameRuleBooleanValue("doMobSpawning"))
	                        {
	                            EntityEndermite entityendermite = new EntityEndermite(worldIn);
	                            entityendermite.setSpawnedByPlayer(true);
	                            entityendermite.setLocationAndAngles(playerIn.posX, playerIn.posY, playerIn.posZ, playerIn.rotationYaw, playerIn.rotationPitch);
	                            worldIn.spawnEntityInWorld(entityendermite);
	                        }

	                        if (playerIn.isRiding())
	                        {
	                            playerIn.mountEntity((Entity)null);
	                        }

	                        playerIn.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
	                        playerIn.fallDistance = 0.0F;
	                        playerIn.attackEntityFrom(DamageSource.fall, event.attackDamage);
	                        }

	            }

	        }
	            return itemStackIn;
	    }
}
}

