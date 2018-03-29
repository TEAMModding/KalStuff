package com.team.kalstuff.container;

import com.team.kalstuff.tileentity.TileEntityChickenNest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;


public class ContainerChickenNest extends Container
{
	private TileEntityChickenNest tileEntityChickenNest;
	
	// each time we add a Slot to the container, it automatically increases the slotIndex, which means
	// 0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
	// 9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
	// 36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)

	private final int HOTBAR_SLOT_COUNT = 9;
	private final int PLAYER_INVENTORY_ROW_COUNT = 3;
	private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;

	private final int TE_INVENTORY_SLOT_COUNT = 1;
	
	private final int SLOT_X_SPACING = 18;
	private final int SLOT_Y_SPACING = 18;
	private final int HOTBAR_XPOS = 8;
	private final int HOTBAR_YPOS = 109;

	final int PLAYER_INVENTORY_XPOS = 8;
	final int PLAYER_INVENTORY_YPOS = 51;
	
	final int TILE_INVENTORY_XPOS = 80;
	final int TILE_INVENTORY_YPOS = 20;
	
	public ContainerChickenNest(IInventory playerInv, TileEntityChickenNest tileEntityChickenNest)
	{
		this.tileEntityChickenNest = tileEntityChickenNest;

		// chances are I will make this mistake at some point - so here's a convenient catch!
		if (TE_INVENTORY_SLOT_COUNT != tileEntityChickenNest.getInventorySize())
		{
			System.err.println("Mismatched slot count in ContainerChickenNest(" + TE_INVENTORY_SLOT_COUNT
					+ ") and TileInventory (" + tileEntityChickenNest.getInventorySize()+")");
		}
		
		addOwnSlots();
		addPlayerSlots(playerInv);
	}
	
    private void addPlayerSlots(IInventory playerInv)
    {
    	// add the player's inventory to the GUI
    	for (int y = 0; y < PLAYER_INVENTORY_ROW_COUNT; y++)
    	{
    		for (int x = 0; x < PLAYER_INVENTORY_COLUMN_COUNT; x++)
    		{
    			int slotNumber = HOTBAR_SLOT_COUNT + y * PLAYER_INVENTORY_COLUMN_COUNT + x;
    			int xpos = PLAYER_INVENTORY_XPOS + x * SLOT_X_SPACING;
    			int ypos = PLAYER_INVENTORY_YPOS + y * SLOT_Y_SPACING;
    			addSlotToContainer(new Slot(playerInv, slotNumber,  xpos, ypos));
    		}
    	}
        
        // add the player's hotbar to the GUI
        for (int x = 0; x < HOTBAR_SLOT_COUNT; x++)
        {
        	addSlotToContainer(new Slot(playerInv, x, HOTBAR_XPOS + SLOT_X_SPACING * x, HOTBAR_YPOS));
        }
    }
		
    private void addOwnSlots()
    {
        IItemHandler itemHandler = this.tileEntityChickenNest.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        
		// add our own slots to the GUI
		addSlotToContainer(new SlotItemHandler(itemHandler, 0, TILE_INVENTORY_XPOS, TILE_INVENTORY_YPOS));
    }
    
	// Vanilla calls this method every tick to make sure the player is still able to
    // access the inventory (e.g. still close enough), and if not closes the GUI
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileEntityChickenNest.isUsableBy(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index)
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (index < TileEntityChickenNest.SIZE)
			{
				if (!this.mergeItemStack(itemstack1, TileEntityChickenNest.SIZE, this.inventorySlots.size(), true))
				{
					return ItemStack.EMPTY;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 0, TileEntityChickenNest.SIZE, false))
			{
				return ItemStack.EMPTY;
			}
			
			if (itemstack1.isEmpty())
			{
				slot.putStack(ItemStack.EMPTY);
			}
			else
			{
				slot.onSlotChanged();
			}
		}
		
		return itemstack;
	}
}
