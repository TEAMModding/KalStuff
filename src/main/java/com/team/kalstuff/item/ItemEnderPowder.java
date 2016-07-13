package com.team.kalstuff.item;

import java.util.Random;

import com.team.kalstuff.StartupCommon;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemEnderPowder extends Item {
	
		public ItemEnderPowder() {
		this.setMaxStackSize(64);
		this.setCreativeTab(StartupCommon.kalStuffTab); // the item will appear on the Miscellaneous tab in creative
		}
		
		public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
			super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
			Random rand = new Random();
				
			
			--itemStackIn.stackSize;
			worldIn.playSound(null, playerIn.getPosition(), SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
			for (int i = 0; i < 32; ++i) {
				worldIn.spawnParticle(EnumParticleTypes.PORTAL, playerIn.posX, playerIn.posY + rand.nextDouble() * 2.0D, playerIn.posZ, rand.nextGaussian(), 0.0D, rand.nextGaussian(), new int[0]);
			}
			if (!worldIn.isRemote) {
				if (!playerIn.isPlayerSleeping()) {
					double randX = playerIn.posX, randY = playerIn.posY, randZ = playerIn.posZ;
					
					int maxTries = 4000;
					int loopCount = 0;
					for(boolean goodPos = false; goodPos == false && loopCount < maxTries;) {	

						randX = (playerIn.posX + rand.nextInt(20) - 10);
						randY = (playerIn.posY + rand.nextInt(20) - 10);
						randZ = (playerIn.posZ + rand.nextInt(20) - 10);
						BlockPos aPos = new BlockPos(randX, randY, randZ);
						BlockPos aPos2 = new BlockPos(randX, randY + 1, randZ);
						BlockPos aPos3 = new BlockPos(randX, randY + 2, randZ);
						IBlockState block = worldIn.getBlockState(aPos);
						IBlockState block2 = worldIn.getBlockState(aPos2);
						IBlockState block3 = worldIn.getBlockState(aPos3);
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

					net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(playerIn, randX, randY, randZ, 0.0F);
					if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) {
						if (rand.nextFloat() < 0.03F && worldIn.getGameRules().getBoolean("doMobSpawning")) {
							EntityEndermite entityendermite = new EntityEndermite(worldIn);
							entityendermite.setSpawnedByPlayer(true);
							entityendermite.setLocationAndAngles(playerIn.posX, playerIn.posY, playerIn.posZ, playerIn.rotationYaw, playerIn.rotationPitch);
							worldIn.spawnEntityInWorld(entityendermite);
						}
						
						if (playerIn.isRiding()) {
							playerIn.dismountEntity(playerIn.getRidingEntity());
						}
						
						playerIn.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
						playerIn.fallDistance = 0.0F;
						playerIn.attackEntityFrom(DamageSource.fall, event.getAttackDamage());
					}
					
				}
				
			}
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
		}
}