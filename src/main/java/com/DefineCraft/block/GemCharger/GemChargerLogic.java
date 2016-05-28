package com.DefineCraft.block.GemCharger;


import com.DefineCraft.common.DefineCraftMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GemChargerLogic extends TileEntityFurnace
{
    private static final int[] slots_top = new int[] { 0 };
    private static final int[] slots_bottom = new int[] { 2, 1 };
    private static final int[] slots_sides = new int[] { 1 };

    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    private ItemStack[] inventory = new ItemStack[3];
    private String field_94130_e;

    byte direction;
    boolean active;

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory ()
    {
        return this.inventory.length;
    }

    /**
     * Returns the stack in slot i
     */
    @Override
    public ItemStack getStackInSlot (int par1)
    {
        return this.inventory[par1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    @Override
    public ItemStack decrStackSize (int par1, int par2)
    {
        if (this.inventory[par1] != null)
        {
            ItemStack itemstack;

            if (this.inventory[par1].stackSize <= par2)
            {
                itemstack = this.inventory[par1];
                this.inventory[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.inventory[par1].splitStack(par2);

                if (this.inventory[par1].stackSize == 0)
                {
                    this.inventory[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    @Override
    public ItemStack getStackInSlotOnClosing (int par1)
    {
        if (this.inventory[par1] != null)
        {
            ItemStack itemstack = this.inventory[par1];
            this.inventory[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    @Override
    public void setInventorySlotContents (int par1, ItemStack par2ItemStack)
    {
        this.inventory[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName ()
    {
        return this.isInvNameLocalized() ? this.field_94130_e : "Gem Charger";
    }

    /**
     * If this returns false, the inventory name will be used as an unlocalized name, and translated into the player's
     * language. Otherwise it will be used directly.
     */
    public boolean isInvNameLocalized ()
    {
        return this.field_94130_e != null && this.field_94130_e.length() > 0;
    }

    /**
     * Sets the custom display name to use when opening a GUI linked to this tile entity.
     */
    public void setGuiDisplayName (String par1Str)
    {
        this.field_94130_e = par1Str;
    }

    /**
     * Reads a tile entity from NBT.
     */
    @Override
    public void readFromNBT (NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.inventory.length)
            {
                this.inventory[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.furnaceBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.furnaceCookTime = par1NBTTagCompound.getShort("CookTime");
        this.currentItemBurnTime = getFuelTime(this.inventory[1]) * 2;

        if (par1NBTTagCompound.hasKey("CustomName"))
        {
            this.field_94130_e = par1NBTTagCompound.getString("CustomName");
        }
        readNetworkNBT(par1NBTTagCompound);
    }

    /**
     * Writes a tile entity to NBT.
     */
    @Override
    public void writeToNBT (NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short) this.furnaceBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short) this.furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inventory.length; ++i)
        {
            if (this.inventory[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                this.inventory[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        par1NBTTagCompound.setTag("Items", nbttaglist);

        if (this.isInvNameLocalized())
        {
            par1NBTTagCompound.setString("CustomName", this.field_94130_e);
        }
        writeNetworkNBT(par1NBTTagCompound);
    }

    public void readNetworkNBT (NBTTagCompound tags)
    {
        direction = tags.getByte("Direction");
        active = tags.getBoolean("Active");
    }

    public void writeNetworkNBT (NBTTagCompound tags)
    {
        tags.setByte("Direction", direction);
        tags.setBoolean("Active", active);
    }

    /* Packets */
    @Override
    public Packet getDescriptionPacket ()
    {
        NBTTagCompound tag = new NBTTagCompound();
        writeNetworkNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket (NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
        // Probably has deobf now, check on forge 1029
        readNetworkNBT(pkt.func_148857_g());
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    @Override
    public int getInventoryStackLimit ()
    {
        return 64;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled (int par1)
    {
        return this.furnaceCookTime * par1 / 1000;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    public int getBurnTimeRemainingScaled (int par1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 1000;
        }

        return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
    }

    /**
     * Returns true if the furnace is currently burning
     */
    @Override
    public boolean isBurning ()
    {
        return this.furnaceBurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    @Override
    public void updateEntity ()
    {
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;

        if (this.furnaceBurnTime > 0 && this.furnaceCookTime > 0) //Stops the cook time, so it does not keep burning
        {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.furnaceBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.furnaceBurnTime = getFuelTime(this.inventory[1]) * 2;

                if (this.furnaceBurnTime > 0)
                {
                    flag1 = true;

                    if (this.inventory[1] != null)
                    {
                        --this.inventory[1].stackSize;

                        if (this.inventory[1].stackSize == 0)
                        {
                            this.inventory[1] = this.inventory[1].getItem().getContainerItem(inventory[1]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.furnaceCookTime;

                if (this.furnaceCookTime == 1000)
                {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    if (!active)
                    {
                        this.active = true;
                        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                    }
                    flag1 = true;
                }
            }
            else
            {
                this.furnaceCookTime = 0; //this will save pragress
                if (active)
                {
                    this.active = false;                                          
                    worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                }
            } 

            if (flag != this.furnaceBurnTime > 0)
            {
                flag1 = true;
                this.active = true;
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                //BlockFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt ()
    {
        if (this.inventory[0] == null)
        {
            return false;
        }
        else
        {
        	ItemStack itemstack = GemChargerRecipes.Grinding().getGrindingResult(this.inventory[0]);
            if (itemstack == null)
                return false;
            if (this.inventory[2] == null)
                return true;
            if (!this.inventory[2].isItemEqual(itemstack))
                return false;
            int result = inventory[2].stackSize + itemstack.stackSize;
            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }
    
    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    @Override
    public void smeltItem ()
    {
        if (this.canSmelt())
        {
        	ItemStack itemstack = GemChargerRecipes.Grinding().getGrindingResult(this.inventory[0]);

            if (this.inventory[2] == null)
            {
                this.inventory[2] = itemstack.copy();
            }
            else if (this.inventory[2].isItemEqual(itemstack))
            {
                inventory[2].stackSize += itemstack.stackSize;
            }

            --this.inventory[0].stackSize;

            if (this.inventory[0].stackSize <= 0)
            {
                this.inventory[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getFuelTime (ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
        {
            return 0;
        }
        else
        { 
        	Item var1 = par0ItemStack.getItem();
        	if (var1 instanceof ItemBlock && Block.getBlockFromItem(var1) != Blocks.air)
            {
        		Block var2 = Block.getBlockFromItem(var1);
        		if (var2 == Blocks.coal_block)
                {
                    return 100;
                }
        		
            }
        	return GameRegistry.getFuelValue(par0ItemStack);
        }
            
    }

    /**
     * Return true if item is a fuel source (getItemBurnTime() > 0).
     */
    public static boolean isItemFuel (ItemStack par0ItemStack)
    {
        return getFuelTime(par0ItemStack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    @Override
    public boolean isUseableByPlayer (EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
    }

    public void openChest ()
    {
    }

    public void closeChest ()
    {
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    @Override
    public boolean isItemValidForSlot (int par1, ItemStack par2ItemStack)
    {
        return par1 == 2 ? false : (par1 == 1 ? isItemFuel(par2ItemStack) : true);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    @Override
    public int[] getAccessibleSlotsFromSide (int par1)
    {
        return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    @Override
    public boolean canInsertItem (int par1, ItemStack par2ItemStack, int par3)
    {
        return this.isItemValidForSlot(par1, par2ItemStack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    @Override
    public boolean canExtractItem (int par1, ItemStack par2ItemStack, int par3)
    {
        return par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket;
    }

    public boolean getActive ()
    {
        return active;
    }

    public void setDirection (float yaw, float pitch, Object object)
    {
        int facing = MathHelper.floor_double(yaw / 360 + 0.5D) & 3;
        switch (facing)
        {
        case 0:
            direction = 2;
            break;

        case 1:
            direction = 5;
            break;

        case 2:
            direction = 3;
            break;

        case 3:
            direction = 4;
            break;
        }
    }

    public int getRenderDirection ()
    {
        return direction;
    }
}
