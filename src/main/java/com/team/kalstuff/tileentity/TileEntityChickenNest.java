package com.team.kalstuff.tileentity;

import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityChicken;

import java.util.Arrays;
import java.util.List;


public class TileEntityChickenNest extends TileEntity implements IInventory, IUpdatePlayerListBox {
	// Create and initialize the items variable that will store store the items
	private ItemStack[] inventory = new ItemStack[1];
	private EntityChicken chicken;
	private int cooldown;
	
	//Check for items
	@Override
	public void update() {
	EntityItem item = CheckForItemEntities(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ());
	if (item != null)
	{
	ItemStack itemstack = item.getEntityItem().copy();
	item.setEntityItemStack(this.add(itemstack));
	System.out.println(itemstack.getItem());
	}
		if (this.cooldown > 0) this.cooldown --;
		if (this.chicken != null && this.chicken.isDead) this.chicken = null;
		if (this.chicken == null && this.cooldown <= 0) this.chicken = CheckForChickens(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ());
		else if (this.chicken != null) {
			this.chicken.setPosition(this.getPos().getX() + .5, this.getPos().getY(), this.getPos().getZ() + .5);
	}

	}

	//Find a "random" item over the block
	public static EntityItem CheckForItemEntities(World worldIn, double p_145897_1_, double p_145897_3_, double p_145897_5_)
	{
	List list = worldIn.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(p_145897_1_, p_145897_3_, p_145897_5_, p_145897_1_ + 1.0D, p_145897_3_ + 0.5D, p_145897_5_ + 1.0D), IEntitySelector.selectAnything);
	return list.size() > 0 ? (EntityItem)list.get(0) : null;
	}
	
	//Find a "random" item over the block
	public static EntityChicken CheckForChickens(World worldIn, double p_145897_1_, double p_145897_3_, double p_145897_5_)
	{
	List list = worldIn.getEntitiesWithinAABB(EntityChicken.class, new AxisAlignedBB(p_145897_1_, p_145897_3_, p_145897_5_, p_145897_1_ + 1.0D, p_145897_3_ + 1.0D, p_145897_5_ + 1.0D), IEntitySelector.selectAnything);
	return list.size() > 0 ? (EntityChicken)list.get(0) : null;
	}
	
	//Checks if there is any space whatsoever, include partial stacks
    private boolean hasEmptySpace()
    {
    	return (this.inventory[0] == null || this.inventory[0].stackSize != this.inventory[0].getMaxStackSize());
    }
	
    //Checks if there is any space that the specified item can fit in. Meaning only partial stacks if they're the same item.
    private boolean hasRoomForItem(ItemStack itemstack)
    {
    	return (this.inventory[0] == null || (this.inventory[0].stackSize != this.inventory[0].getMaxStackSize() && itemstack.getItem() == inventory[0].getItem()));
    }
    
    //Adds as many items from the item stack as it can to the inventory
    private ItemStack add(ItemStack itemstack) {
    	
    	int i;
    	for (i = 0; i < itemstack.stackSize && this.hasRoomForItem(itemstack); i ++) {
        	if (this.inventory[0] == null) this.inventory[0] = new ItemStack(itemstack.getItem(), 1);
        	else this.inventory[0].stackSize++;
    		itemstack.stackSize--;
    	}
    	return itemstack;
    }
    
	// Gets the number of slots in the inventory
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	// Gets the stack in the given slot
	@Override
	public ItemStack getStackInSlot(int slotIndex) {
		return inventory[slotIndex];
	}

	/**
	 * Removes some of the units from itemstack in the given slot, and returns as a separate itemstack
 	 * @param slotIndex the slot number to remove the items from
	 * @param count the number of units to remove
	 * @return a new itemstack containing the units removed from the slot
	 */
	@Override
	public ItemStack decrStackSize(int slotIndex, int count) {
		ItemStack itemStackInSlot = getStackInSlot(slotIndex);
		if (itemStackInSlot == null) return null;

		ItemStack itemStackRemoved;
		if (itemStackInSlot.stackSize <= count) {
			itemStackRemoved = itemStackInSlot;
			setInventorySlotContents(slotIndex, null);
		} else {
			itemStackRemoved = itemStackInSlot.splitStack(count);
			if (itemStackInSlot.stackSize == 0) {
				setInventorySlotContents(slotIndex, null);
			}
		}
	  markDirty();
		return itemStackRemoved;
	}

	// overwrites the stack in the given slotIndex with the given stack
	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack itemstack) {
		inventory[slotIndex] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		markDirty();
	}

	// This is the maximum number if items allowed in each slot
	// This only affects things such as hoppers trying to insert items you need to use the container to enforce this for players
	// inserting items via the gui
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	// Return true if the given player is able to use this block. In this case it checks that
	// 1) the world tileentity hasn't been replaced in the meantime, and
	// 2) the player isn't too far away from the centre of the block
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if (this.worldObj.getTileEntity(this.pos) != this) return false;
		final double X_CENTRE_OFFSET = 0.5;
		final double Y_CENTRE_OFFSET = 0.5;
		final double Z_CENTRE_OFFSET = 0.5;
		final double MAXIMUM_DISTANCE_SQ = 8.0 * 8.0;
		return player.getDistanceSq(pos.getX() + X_CENTRE_OFFSET, pos.getY() + Y_CENTRE_OFFSET, pos.getZ() + Z_CENTRE_OFFSET) < MAXIMUM_DISTANCE_SQ;
	}

	// Return true if the given stack is allowed to go in the given slot.  In this case, we can insert anything.
	// This only affects things such as hoppers trying to insert items you need to use the container to enforce this for players
	// inserting items via the gui
	@Override
	public boolean isItemValidForSlot(int slotIndex, ItemStack itemstack) {
		
		return itemstack == new ItemStack(Items.egg);
	}

	// This is where you save any data that you don't want to lose when the tile entity unloads
	// In this case, it saves the itemstacks stored in the container
	@Override
	public void writeToNBT(NBTTagCompound parentNBTTagCompound)
	{
		super.writeToNBT(parentNBTTagCompound); // The super call is required to save and load the tileEntity's location

		// to use an analogy with Java, this code generates an array of hashmaps
		// The itemStack in each slot is converted to an NBTTagCompound, which is effectively a hashmap of key->value pairs such
		//   as slot=1, id=2353, count=1, etc
		// Each of these NBTTagCompound are then inserted into NBTTagList, which is similar to an array.
		NBTTagList dataForAllSlots = new NBTTagList();
		for (int i = 0; i < this.inventory.length; ++i) {
			if (this.inventory[i] != null)	{
				NBTTagCompound dataForThisSlot = new NBTTagCompound();
				dataForThisSlot.setByte("Slot", (byte) i);
				this.inventory[i].writeToNBT(dataForThisSlot);
				dataForAllSlots.appendTag(dataForThisSlot);
			}
		}
		// the array of hashmaps is then inserted into the parent hashmap for the container
		parentNBTTagCompound.setTag("Items", dataForAllSlots);
	}

	// This is where you load the data that you saved in writeToNBT
	@Override
	public void readFromNBT(NBTTagCompound parentNBTTagCompound)
	{
		super.readFromNBT(parentNBTTagCompound); // The super call is required to save and load the tiles location
		final byte NBT_TYPE_COMPOUND = 10;       // See NBTBase.createNewByType() for a listing
		NBTTagList dataForAllSlots = parentNBTTagCompound.getTagList("Items", NBT_TYPE_COMPOUND);

		Arrays.fill(inventory, null);           // set all slots to empty
		for (int i = 0; i < dataForAllSlots.tagCount(); ++i) {
			NBTTagCompound dataForOneSlot = dataForAllSlots.getCompoundTagAt(i);
			int slotIndex = dataForOneSlot.getByte("Slot") & 255;

			if (slotIndex >= 0 && slotIndex < this.inventory.length) {
				this.inventory[slotIndex] = ItemStack.loadItemStackFromNBT(dataForOneSlot);
			}
		}
	}

	// set all slots to empty
	@Override
	public void clear() {
		Arrays.fill(inventory, null);
	}

	// will add a key for this container to the lang file so we can name it in the GUI
	@Override
	public String getName() {
		return "container.chickenNest.name";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	// standard code to look up what the human-readable name is
	@Override
	public IChatComponent getDisplayName() {
		return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName());
	}

	public void dropChicken() {
		this.resetCooldown();
		if (this.chicken != null) this.chicken.setPositionAndUpdate(this.getPos().getX() + .5, this.getPos().getY() + .5, this.getPos().getZ() + .5);
		this.chicken = null;
		System.out.println("Chicken Dropped. Cooldown: " + this.cooldown);
	}
	
	public void resetCooldown() {
		this.cooldown = 100;
	}
	
	// -----------------------------------------------------------------------------------------------------------
	// The following methods are not needed for this example but are part of IInventory so they must be implemented

	/**
	 * This method removes the entire contents of the given slot and returns it.
	 * Used by containers such as crafting tables which return any items in their slots when you close the GUI
	 * @param slotIndex
	 * @return
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex) {
		ItemStack itemStack = getStackInSlot(slotIndex);
		if (itemStack != null) setInventorySlotContents(slotIndex, null);
		return itemStack;
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {}

	@Override
	public int getFieldCount() {
		return 0;
	}
}