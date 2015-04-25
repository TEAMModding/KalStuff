package com.team.kalstuff;

import com.team.kalstuff.container.ContainerChickenNest;
import com.team.kalstuff.container.ContainerTrashCan;
import com.team.kalstuff.gui.GuiChickenNest;
import com.team.kalstuff.gui.GuiTrashCan;
import com.team.kalstuff.tileentity.TileEntityChickenNest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * This is the new gui registry everyone should use.
 * To add a new Gui simply add a new case statement with it's own number
 * (your gui id). If your gui is on both client and server you will need 
 * to add it in both methods.
 * @author Joseph
 *
 */
public class KalStuffGuiHandler implements IGuiHandler {
	private static final int GUIID_CHICKEN_NEST = 30;
	public static int getGuiID() {return GUIID_CHICKEN_NEST;}

	/**
	 * Gets the server gui element, should return a child of Container.
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		switch(ID)
		{
			case(0): {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity instanceof TileEntityChickenNest) 
				{
					TileEntityChickenNest tileEntityChickenNest = (TileEntityChickenNest) tileEntity;
					return new ContainerChickenNest(player.inventory, tileEntityChickenNest);
				}
			}
			case(1): {
				return new ContainerTrashCan(player.inventory);
			}
		}
		return null;
	}

	/**
	 * Gets the client gui element, this one returns the actual gui.
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		switch(ID)
		{
			case(0): {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity instanceof TileEntityChickenNest) 
				{
					TileEntityChickenNest tileEntityChickenNest = (TileEntityChickenNest) tileEntity;
					return new GuiChickenNest(player.inventory, tileEntityChickenNest);
				}
				return null;
			}
			case(1): {
				return new GuiTrashCan(player.inventory);
			}
		}
		return null;
	}
}