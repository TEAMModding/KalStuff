package com.team.kalstuff.tileentity;

import com.team.kalstuff.block.BlockMoonFlower;

import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;


public class TileEntityMoonFlower extends TileEntity implements IUpdatePlayerListBox {

	
	@Override
	public void update() {
		if (this.worldObj != null && !this.worldObj.isRemote && worldObj.getWorldTime() >= 13000 || worldObj.getWorldTime() < 1000)
        {
            this.blockType = this.getBlockType();

            if (this.blockType instanceof BlockMoonFlower)
            {
                ((BlockMoonFlower)this.blockType).checkSky(this.worldObj, this.pos);
            }
        }
	}
}