package com.team.kalstuff.tileentity;

import java.util.List;

import com.team.kalstuff.container.ContainerChickenNest;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;


public class TileEntityChickenNest extends TileEntityLockableLoot implements IInventory, ITickable {
	// Create and initialize the items variable that will store store the items
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>func_191197_a(1, ItemStack.field_190927_a);
	private EntityChicken chicken;
	private int cooldown;
	
	//Check for items
	@Override
	public void update() {
		if (!worldObj.isRemote) {
			EntityItem item = CheckForItemEntities(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ());
			if (item != null)
			{
				ItemStack itemstack = item.getEntityItem().copy();
				item.setEntityItemStack(this.add(itemstack));
			}
			
			if (this.cooldown > 0) this.cooldown --;
			if (this.chicken != null && this.chicken.isDead) this.chicken = null;
			if (this.chicken == null && this.cooldown <= 0) this.chicken = CheckForChickens(this.worldObj, this.pos.getX(), this.pos.getY(), this.pos.getZ());
			else if (this.chicken != null) this.chicken.setPosition(this.getPos().getX() + .5, this.getPos().getY(), this.getPos().getZ() + .5);
		}
		
	}

	//Find a "random" item over the block
	public static EntityItem CheckForItemEntities(World worldIn, double p_145897_1_, double p_145897_3_, double p_145897_5_)
	{
	List<?> list = worldIn.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(p_145897_1_, p_145897_3_, p_145897_5_, p_145897_1_ + 1.0D, p_145897_3_ + 0.5D, p_145897_5_ + 1.0D), null);
	return list.size() > 0 ? (EntityItem)list.get(0) : null;
	}
	
	//Find a "random" item over the block
	public static EntityChicken CheckForChickens(World worldIn, double p_145897_1_, double p_145897_3_, double p_145897_5_)
	{
	List<?> list = worldIn.getEntitiesWithinAABB(EntityChicken.class, new AxisAlignedBB(p_145897_1_, p_145897_3_, p_145897_5_, p_145897_1_ + 1.0D, p_145897_3_ + 1.0D, p_145897_5_ + 1.0D), null);
	return list.size() > 0 ? (EntityChicken)list.get(0) : null;
	}
	
	//Checks if there is any space whatsoever, include partial stacks
    @SuppressWarnings("unused")
	private boolean hasEmptySpace()
    {
    	return (this.inventory.get(0) == null || this.inventory.get(0).func_190916_E() != this.inventory.get(0).getMaxStackSize()); //TODO: update this
    }
	
    //Checks if there is any space that the specified item can fit in. Meaning only partial stacks if they're the same item.
    private boolean hasRoomForItem(ItemStack itemstack)
    {
    	return (this.inventory.get(0) == null || (this.inventory.get(0).func_190916_E() != this.inventory.get(0).getMaxStackSize() && itemstack.getItem() == this.inventory.get(0).getItem())); //TODO: update this
    }
    
    //Adds as many items from the item stack as it can to the inventory
    private ItemStack add(ItemStack itemstack) {
    	
    	int i;
    	for (i = 0; i < itemstack.func_190916_E() && this.hasRoomForItem(itemstack); i ++) {//TODO: update this
        	if (this.inventory.get(0) == null) this.inventory.set(0, new ItemStack(itemstack.getItem(), 1));
        	else this.inventory.get(0).func_190917_f(1);//TODO: update this
    		itemstack.func_190917_f(-1);//TODO: update this
    	}
    	return itemstack;
    }
    
	// Gets the number of slots in the inventory
	@Override
	public int getSizeInventory() {
		return this.inventory.size();
	}

	// Gets the stack in the given slot
	@Override
	public ItemStack getStackInSlot(int slotIndex) {
        this.fillWithLoot((EntityPlayer)null);
        return (ItemStack)this.func_190576_q().get(slotIndex);
	}

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    public ItemStack decrStackSize(int index, int count)
    {
        this.fillWithLoot((EntityPlayer)null);
        ItemStack itemstack = ItemStackHelper.getAndSplit(this.func_190576_q(), index, count);
        return itemstack;
    }

	 /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        this.fillWithLoot((EntityPlayer)null);
        this.func_190576_q().set(index, stack);

        if (stack.func_190916_E() > this.getInventoryStackLimit())
        {
            stack.func_190920_e(this.getInventoryStackLimit());
        }
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
		
		return itemstack == new ItemStack(Items.EGG);
	}

	// This is where you save any data that you don't want to lose when the tile entity unloads
	// In this case, it saves the itemstacks stored in the container
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound parentNBTTagCompound)
	{
		super.writeToNBT(parentNBTTagCompound); // The super call is required to save and load the tileEntity's location

		// to use an analogy with Java, this code generates an array of hashmaps
		// The itemStack in each slot is converted to an NBTTagCompound, which is effectively a hashmap of key->value pairs such
		//   as slot=1, id=2353, count=1, etc
		// Each of these NBTTagCompound are then inserted into NBTTagList, which is similar to an array.
		NBTTagList dataForAllSlots = new NBTTagList();
		for (int i = 0; i < this.inventory.size(); ++i) {
			if (this.inventory.get(i) != null)	{
				NBTTagCompound dataForThisSlot = new NBTTagCompound();
				dataForThisSlot.setByte("Slot", (byte) i);
				this.inventory.get(i).writeToNBT(dataForThisSlot);
				dataForAllSlots.appendTag(dataForThisSlot);
			}
		}
		// the array of hashmaps is then inserted into the parent hashmap for the container
		parentNBTTagCompound.setTag("Items", dataForAllSlots);
		
		return parentNBTTagCompound;
	}

	// This is where you load the data that you saved in writeToNBT
	@Override
	public void readFromNBT(NBTTagCompound parentNBTTagCompound)
	{
		 super.readFromNBT(parentNBTTagCompound);
	        this.inventory = NonNullList.<ItemStack>func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);

	        if (!this.checkLootAndRead(parentNBTTagCompound))
	        {
	            ItemStackHelper.func_191283_b(parentNBTTagCompound, this.inventory);
	        }

	        if (parentNBTTagCompound.hasKey("CustomName", 8))
	        {
	            this.field_190577_o = parentNBTTagCompound.getString("CustomName");
	        }
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

	/*// standard code to look up what the human-readable name is
	@Override
	public IChatComponent getDisplayName() {
		return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName());
	}*/

	public void dropChicken() {
		if (!worldObj.isRemote) {
			this.resetCooldown();
			if (this.chicken != null) this.chicken.setPositionAndUpdate(this.getPos().getX() + .5, this.getPos().getY() + .6, this.getPos().getZ() + .5);
			this.chicken = null;
		}
	}
	
	public void resetCooldown() {
		this.cooldown = 100;
	}
	
	// -----------------------------------------------------------------------------------------------------------
	// The following methods are not needed for this example but are part of IInventory so they must be implemented

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

	@Override
	public ITextComponent getDisplayName() {
		return (ITextComponent)(this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]));
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(inventory, index);
	}

	@Override
	public boolean func_191420_l() {
		return false;
	}
	
	@Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        this.fillWithLoot(playerIn);
        return new ContainerChickenNest(playerInventory, this);
    }

	@Override
	public String getGuiID() {
		return "kalstuff:chicken_nest";
	}

    protected NonNullList<ItemStack> func_190576_q()
    {
        return this.inventory;
    }
}