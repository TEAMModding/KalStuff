package com.team.kalstuff;

import com.team.kalstuff.container.ContainerChickenNest;
import com.team.kalstuff.container.ContainerTrashCan;
import com.team.kalstuff.gui.GuiChickenNest;
import com.team.kalstuff.gui.GuiTrashCan;
import com.team.kalstuff.tileentity.TileEntityChickenNest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * This is the new gui registry everyone should use. To add a new Gui simply add
 * a new case statement with it's own number (your gui id). If your gui is on
 * both client and server you will need to add it in both methods.
 * 
 * @author Joseph
 *
 */
public class KalStuffGuiHandler implements IGuiHandler
{
	private static final int GUIID_CHICKEN_NEST = 30;

	public static int getGuiID()
	{
		return GUIID_CHICKEN_NEST;
	}

	/**
	 * Gets the server gui element, should return a child of Container.
	 */
	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		BlockPos pos = new BlockPos(x, y, z);
		switch (ID)
		{
		case (0):
			return new ContainerChickenNest(player.inventory, (TileEntityChickenNest) world.getTileEntity(pos));
		case (1):
			return new ContainerTrashCan(player.inventory);
		default:
			return null;
		}
	}

	/**
	 * Gets the client gui element, this one returns the actual gui.
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID)
		{
		case (0):
			return new GuiChickenNest(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
		case (1):
			return new GuiTrashCan(player.inventory);
		default:
			return null;
		}
	}
}