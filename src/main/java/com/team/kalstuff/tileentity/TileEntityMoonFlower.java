package com.team.kalstuff.tileentity;

import com.team.kalstuff.block.BlockMoonFlower;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;


public class TileEntityMoonFlower extends TileEntity implements ITickable {

	
	@Override
	public void update() {
		if (this.world != null && !this.world.isRemote && world.getWorldTime() >= 13000 || world.getWorldTime() < 1000) {  
			this.blockType = this.getBlockType();
			
            if (this.blockType instanceof BlockMoonFlower)
                ((BlockMoonFlower)this.blockType).checkSky(this.world, this.pos);
        }
	}
}