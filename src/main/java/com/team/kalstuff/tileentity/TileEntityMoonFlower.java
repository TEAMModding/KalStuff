package com.team.kalstuff.tileentity;

import com.team.kalstuff.block.BlockMoonFlower;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;


public class TileEntityMoonFlower extends TileEntity implements ITickable {

	
	@Override
	public void update() {
		if (this.worldObj != null && !this.worldObj.isRemote && worldObj.getWorldTime() >= 13000 || worldObj.getWorldTime() < 1000) {  
			this.blockType = this.getBlockType();
			
            if (this.blockType instanceof BlockMoonFlower)
                ((BlockMoonFlower)this.blockType).checkSky(this.worldObj, this.pos);
        }
	}
}