package com.DefineCraft.common;

import com.DefineCraft.Proxy.ClientProxy;
import com.DefineCraft.Proxy.CommonProxy;
import com.DefineCraft.Proxy.IProxy;
import com.DefineCraft.World.DefineOreGen;
import com.DefineCraft.block.*;
import com.DefineCraft.block.BarMaker.*;
import com.DefineCraft.block.GemCharger.*;
import com.DefineCraft.block.Grinder.*;
import com.DefineCraft.block.Infuser.*;
import com.DefineCraft.block.SmartFurnace.SmartFurnaceBlock;
import com.DefineCraft.common.*;
import com.DefineCraft.item.*;
import com.DefineCraft.item.Gems.*;
import com.DefineCraft.item.HellStone.*;
import com.DefineCraft.item.Obsidian.*;
import com.DefineCraft.item.Terbium.*;
import com.DefineCraft.item.Silver.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Ref.MODID, version = Ref.VERSION)
public class DefineCraftMod {
	
	@Mod.Instance(Ref.MODID)
    public static DefineCraftMod instance;

    @SidedProxy(clientSide = Ref.ClientProxy, serverSide = Ref.ServerProxy)
    public static IProxy proxy;
    
    @EventHandler
	public void pre_init(FMLInitializationEvent event) {
	System.out.println("===============================================================");
    System.out.println("           Loading Definecraft Mod Thanks You                  ");
    System.out.println("***************************************************************");

//	proxy.register_renderers();
 //   DefineCraftModItems.pre_init();
//    DefineCraftModBlocks.pre_init();
}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.register_renderers();
		DefineCraftModItems.pre_init();
	    DefineCraftModBlocks.pre_init();
		DefineCraftModItems.init();
	    DefineCraftModBlocks.init();
//World Gen
        GameRegistry.registerWorldGenerator(new DefineOreGen(), 1);
//Ore Dictionary adding
        OreDictionary.registerOre("dustSilver", new ItemStack(DefineCraftModItems.SilverDust));
        OreDictionary.registerOre("ingotSilver", new ItemStack(DefineCraftModItems.SilverBar));
        OreDictionary.registerOre("dustTerbium", new ItemStack(DefineCraftModItems.TerbiumDust));
        OreDictionary.registerOre("ingotTerbium", new ItemStack(DefineCraftModItems.TerbiumBar));
        OreDictionary.registerOre("dustObsidian", new ItemStack(DefineCraftModItems.ObsidianDust));
        OreDictionary.registerOre("ingotObsidian", new ItemStack(DefineCraftModItems.ObsidianBar));
        OreDictionary.registerOre("dustHellStone", new ItemStack(DefineCraftModItems.HellStoneDust));
        OreDictionary.registerOre("ingotHellStone", new ItemStack(DefineCraftModItems.HellStoneBar));
        OreDictionary.registerOre("dustDiamond", new ItemStack(DefineCraftModItems.DiamondDust));
        OreDictionary.registerOre("dustGold", new ItemStack(DefineCraftModItems.GoldDust));
        OreDictionary.registerOre("dustIron", new ItemStack(DefineCraftModItems.IronDust));
    	OreDictionary.registerOre("oreHellstone", new ItemStack(DefineCraftModBlocks.HellStoneOre));
    	OreDictionary.registerOre("oreTerbium", new ItemStack(DefineCraftModBlocks.TerbiumOre));
    	OreDictionary.registerOre("oreSilver", new ItemStack(DefineCraftModBlocks.SilverOre));
//Network Registry        
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
//Custom renders
      		proxy.register_renderers();


	}
	public static CreativeTabs DefineCraft = new CreativeTabs("DefineCraft") {
	         public Item getTabIconItem() {
	                 return DefineCraftModItems.HellStoneSword;
	         }
	 };

	@EventHandler
	public void postinit(FMLPreInitializationEvent event) {
	System.out.println("***************************************************************");
	System.out.println("      Definecraft Is Loaded Up, You Are Ready To Play      ");
	System.out.println("===============================================================");
		
	}
	

	

}
