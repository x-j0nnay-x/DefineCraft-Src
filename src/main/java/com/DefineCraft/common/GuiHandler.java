package com.DefineCraft.common;

import com.DefineCraft.block.BarMaker.BarMakerContainer;
import com.DefineCraft.block.BarMaker.BarMakerGUI;
import com.DefineCraft.block.BarMaker.BarMakerLogic;
import com.DefineCraft.block.GemCharger.GemChargerContainer;
import com.DefineCraft.block.GemCharger.GemChargerGUI;
import com.DefineCraft.block.GemCharger.GemChargerLogic;
import com.DefineCraft.block.Grinder.GrinderContainer;
import com.DefineCraft.block.Grinder.GrinderGUI;
import com.DefineCraft.block.Grinder.GrinderLogic;
import com.DefineCraft.block.Infuser.InfuserContainer;
import com.DefineCraft.block.Infuser.InfuserGUI;
import com.DefineCraft.block.Infuser.InfuserLogic;
import com.DefineCraft.block.SmartFurnace.SmartFurnaceContainer;
import com.DefineCraft.block.SmartFurnace.SmartFurnaceGUI;
import com.DefineCraft.block.SmartFurnace.SmartFurnaceLogic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
 
public class GuiHandler implements IGuiHandler
{
    public static final int Grinder = 1;
    public static final int BarMaker = 2;
    public static final int GemCharger = 3;
    public static final int Infuser = 4;
    public static final int SmartFurnace = 5;
 
    @Override
    public Object getClientGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == Grinder)
        {
        	return new GrinderGUI(player.inventory, (GrinderLogic) world.getTileEntity(x, y, z));
        }
        if (ID == BarMaker)
        {
            return new BarMakerGUI(player.inventory, (BarMakerLogic) world.getTileEntity(x, y, z));
        }
        if (ID == SmartFurnace)
        {
            return new SmartFurnaceGUI(player.inventory, (SmartFurnaceLogic) world.getTileEntity(x, y, z));
        }
        if (ID == GemCharger)
        {
            return new GemChargerGUI(player.inventory, (GemChargerLogic) world.getTileEntity(x, y, z));
        }
        if (ID == Infuser)
        {
            return new InfuserGUI(player.inventory, (InfuserLogic) world.getTileEntity(x, y, z));
        }
        return null;
    }
 
    @Override
    public Object getServerGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == Grinder)
        {
            return new GrinderContainer(player.inventory, (GrinderLogic) world.getTileEntity(x, y, z));
        }
        if (ID == BarMaker)
        {
            return new BarMakerContainer(player.inventory, (BarMakerLogic) world.getTileEntity(x, y, z));
        }
        if (ID == SmartFurnace)
        {
            return new SmartFurnaceContainer(player.inventory, (SmartFurnaceLogic) world.getTileEntity(x, y, z));
        }
        if (ID == GemCharger)
        {
            return new GemChargerContainer(player.inventory, (GemChargerLogic) world.getTileEntity(x, y, z));
        }
        if (ID == Infuser)
        {
            return new InfuserContainer(player.inventory, (InfuserLogic) world.getTileEntity(x, y, z));
        }
        return null;
    }
}
