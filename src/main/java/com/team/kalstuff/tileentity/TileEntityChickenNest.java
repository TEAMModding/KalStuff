package com.team.kalstuff.tileentity;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

// Now actually works!
public class TileEntityChickenNest extends TileEntity implements ITickable
{
	// create and initialize the items variable that will store the items
	// private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(1,
	// ItemStack.EMPTY);
	private EntityChicken chicken;
	private int cooldown;
	public static final int SIZE = 1;

	// This item handler will hold our nine inventory slots
	private ItemStackHandler itemStackHandler = new ItemStackHandler(SIZE)
	{
		@Override
		protected void onContentsChanged(int slot)
		{
			// we need to tell the tile entity that something has changed so
			// that the chest contents is persisted
			TileEntityChickenNest.this.markDirty();
		}
	};

	// Check for items
	@Override
	public void update()
	{
		if (!world.isRemote)
		{
			EntityItem item = checkForItemEntities(this.world, this.pos.getX(), this.pos.getY(), this.pos.getZ());
			if (item != null)
			{
				ItemStack itemstack = item.getEntityItem().copy();
				item.setEntityItemStack(this.add(itemstack));
			}
			if (this.cooldown > 0)
				this.cooldown--;
			if (this.chicken != null && this.chicken.isDead)
				this.chicken = null;
			if (this.chicken == null && this.cooldown <= 0)
				this.chicken = checkForChickens(this.world, this.pos.getX(), this.pos.getY(), this.pos.getZ());
			else if (this.chicken != null)
				this.chicken.setPosition(this.getPos().getX() + .5, this.getPos().getY(), this.getPos().getZ() + .5);
		}

	}

	// Find a "random" item over the block
	public static EntityItem checkForItemEntities(World worldIn, double p_145897_1_, double p_145897_3_,
			double p_145897_5_)
	{
		List<?> list = worldIn.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(p_145897_1_, p_145897_3_,
				p_145897_5_, p_145897_1_ + 1.0D, p_145897_3_ + 0.5D, p_145897_5_ + 1.0D), null);
		return list.size() > 0 ? (EntityItem) list.get(0) : null;
	}

	// Find a "random" chicken over the block
	public static EntityChicken checkForChickens(World worldIn, double p_145897_1_, double p_145897_3_,
			double p_145897_5_)
	{
		List<?> list = worldIn.getEntitiesWithinAABB(EntityChicken.class, new AxisAlignedBB(p_145897_1_, p_145897_3_,
				p_145897_5_, p_145897_1_ + 1.0D, p_145897_3_ + 1.0D, p_145897_5_ + 1.0D), null);
		return list.size() > 0 ? (EntityChicken) list.get(0) : null;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		if (compound.hasKey("items"))
		{
			itemStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("items"));
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setTag("items", itemStackHandler.serializeNBT());
		return compound;
	}

	public boolean isUsableBy(EntityPlayer playerIn)
	{
		return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
	}

	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return true;
		}
		return super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(itemStackHandler);
		}
		return super.getCapability(capability, facing);
	}

	// checks if there is any space that the specified item can fit in. Meaning only
	// partial stacks if they're the same item
	private boolean hasRoomForItem(ItemStack itemstack)
	{
		return (this.itemStackHandler.getStackInSlot(0).isEmpty()
				|| (this.itemStackHandler.getStackInSlot(0).getCount() < this.itemStackHandler.getStackInSlot(0)
						.getMaxStackSize() && itemstack.isItemEqual(this.itemStackHandler.getStackInSlot(0))));
	}

	// adds as many items from the item stack as it can to the inventory
	private ItemStack add(ItemStack itemstack)
	{
		int i;
		int count = itemstack.getCount();
		for (i = 0; i < count && this.hasRoomForItem(itemstack); i++)
		{
			if (this.itemStackHandler.getStackInSlot(0).isEmpty())
			{
				this.itemStackHandler.setStackInSlot(0, itemstack);
				itemstack = ItemStack.EMPTY;
			} else
			{
				this.itemStackHandler.setStackInSlot(0,
						new ItemStack(itemstack.getItem(), this.itemStackHandler.getStackInSlot(0).getCount() + 1));
				itemstack.shrink(1);
			}
		}
		return itemstack;
	}

	public void dropChicken()
	{
		if (!world.isRemote)
		{
			this.resetCooldown();
			if (this.chicken != null)
				this.chicken.setPositionAndUpdate(this.getPos().getX() + .5, this.getPos().getY() + .6,
						this.getPos().getZ() + .5);
			this.chicken = null;
		}
	}

	public void resetCooldown()
	{
		this.cooldown = 100;
	}

	public int getInventorySize()
	{
		return SIZE;
	}

	/**
	 * Taken from net.minecraft.inventory.InventoryHelper, the same code Vanilla
	 * containers use for dropping their items randomly
	 * 
	 * @param worldIn
	 * @param pos
	 */
	public void dropItems(World worldIn, BlockPos pos)
	{
		for (int i = 0; i < itemStackHandler.getSlots(); ++i)
		{
			ItemStack itemstack = itemStackHandler.getStackInSlot(i);

			if (!itemstack.isEmpty())
			{
				spawnItemStack(worldIn, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), itemstack);
			}
		}
	}

	/**
	 * Taken from net.minecraft.inventory.InventoryHelper, the same code Vanilla
	 * containers use for dropping their items randomly
	 * 
	 * @param worldIn
	 * @param x
	 * @param y
	 * @param z
	 * @param stack
	 */
	public static void spawnItemStack(World worldIn, double x, double y, double z, ItemStack stack)
	{
		Random rand = new Random();
		float f = rand.nextFloat() * 0.8F + 0.1F;
		float f1 = rand.nextFloat() * 0.2F + 0.1F;
		float f2 = rand.nextFloat() * 0.8F + 0.1F;

		while (!stack.isEmpty())
		{
			EntityItem entityitem = new EntityItem(worldIn, x + (double) f, y + (double) f1, z + (double) f2,
					stack.splitStack(rand.nextInt(21) + 10));
			entityitem.motionX = rand.nextGaussian() * 0.05000000074505806D;
			entityitem.motionY = rand.nextGaussian() * 0.05000000074505806D + 0.20000000298023224D;
			entityitem.motionZ = rand.nextGaussian() * 0.05000000074505806D;
			worldIn.spawnEntity(entityitem);
		}
	}
}