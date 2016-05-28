package com.DefineCraft.common;

import com.DefineCraft.Proxy.Client;
import com.DefineCraft.Proxy.Common;
import com.DefineCraft.Proxy.IProxy;
import com.DefineCraft.Proxy.Server;
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
	
	 public static CreativeTabs DefineCraft = new CreativeTabs("DefineCraft") {
         public Item getTabIconItem() {
                 return DefineCraftMod.HellStoneSword;
         }
 };
	
	@SidedProxy(clientSide = Ref.ClientProxy, serverSide = Ref.ServerProxy)
	 public static IProxy iproxy;
	public static Client Client_proxy;
	public static Server Server_proxy;
	public static Common Common_proxy;
	@Instance(value = Ref.MODID)
	public static DefineCraftMod instance;
//Items
	public static Item LogicChip;
	public static Item RefinedWoodenDoor;
	public static Item GrinderHead;
	//Dust
	public static Item IronDust;
	public static Item GoldDust;
	public static Item DiamondDust;
	//Gems / other ores
	public static Item EmptyGem;
	public static Item EnergyGem;
	public static Item Peridot;
	//HellStone
	public static Item HellStoneDust;
	public static Item HellStoneBar;
	public static Item HellStoneSword;
	public static Item HellStoneSpade;
	public static Item HellStonePickAxe;
	public static Item HellStoneAxe;
	public static Item HellStoneHoe;
	public static Item HellStoneHelmet;
	public static Item HellStoneChest;
	public static Item HellStoneLegs;
	public static Item HellStoneBoots;
	//Obsidian
	public static Item ObsidianDust;
	public static Item ObsidianBar;
	public static Item ObsidianSword;
	public static Item ObsidianSpade;
	public static Item ObsidianPickAxe;
	public static Item ObsidianAxe;
	public static Item ObsidianHoe;
	public static Item ObsidianHelmet;
	public static Item ObsidianChest;
	public static Item ObsidianLegs;
	public static Item ObsidianBoots;
	//Terbium
	public static Item TerbiumDust;
	public static Item TerbiumBar;
	public static Item TerbiumSword;
	public static Item TerbiumSpade;
	public static Item TerbiumPickAxe;
	public static Item TerbiumAxe;
	public static Item TerbiumHoe;
	public static Item TerbiumHelmet;
	public static Item TerbiumChest;
	public static Item TerbiumLegs;
	public static Item TerbiumBoots;
	//Silver
	public static Item SilverDust;
	public static Item SilverBar;
	public static Item SilverSword;
	public static Item SilverSpade;
	public static Item SilverPickAxe;
	public static Item SilverAxe;
	public static Item SilverHoe;
	public static Item SilverHelmet;
	public static Item SilverChest;
	public static Item SilverLegs;
	public static Item SilverBoots;
//blocks
	//gui blocks
	public static Block Grinder;
	public static Block BarMaker;
	public static Block SmartFurnace;
	public static Block GemCharger;
	public static Block Infuser;
	//other blocks
	public static Block RefinedWoodenDoorBlock;
	public static Block VanishingLight;
	public static Block meltingObsidian;
	public static Block meltingObsidian1;
	public static Block meltingObsidian0;
	public static Block meltingIce;
	//Ore fluids
	public static Block HellStoneOre;
	public static Fluid MoltenHellStone;
	public static Block TerbiumOre;
	//public static Fluid MoltenTerbium;
	public static Block SilverOre;
	//public static Fluid MoltenSilver;
	public static Block GemOre;
	public static Block PeridotOre;
//	//Gui
	
	
	@EventHandler
	public void preinit(FMLInitializationEvent event) {
	System.out.println("===============================================================");
    System.out.println("           Loading Definecraft Mod Thanks You                  ");
    System.out.println("***************************************************************");
    
    }

	@EventHandler
	public void init(FMLInitializationEvent event) {
//Custom renders
		Client_proxy.NewArrmorRenderer();
//Materials
	    ToolMaterial Silver = EnumHelper.addToolMaterial("Silver", 3, 300, 8F, 3, 20);
	    ToolMaterial Terbium = EnumHelper.addToolMaterial("Terbium", 3, 500, 10F, 3, 25);
	    ToolMaterial Obsidian = EnumHelper.addToolMaterial("Obsidian", 3, 1500, 15F, 4, 30);
	    ToolMaterial HellStone = EnumHelper.addToolMaterial("HellStone", 3, 2000, 25F, 5, 35);
	    ArmorMaterial SilverArmor1 = EnumHelper.addArmorMaterial("SilverArmor", 33, new int[] {3, 4, 4, 3}, 20);
	    ArmorMaterial TerbiumArmor1 = EnumHelper.addArmorMaterial("TerbiumArmor", 33, new int[] {3, 4, 5, 3}, 25);
	    ArmorMaterial ObsidianArmor1 = EnumHelper.addArmorMaterial("ObsidianArmor", 33, new int[] {3, 8, 6, 4}, 30);
	    ArmorMaterial HellStoneArmor1 = EnumHelper.addArmorMaterial("HellStoneArmor", 33, new int[] {3, 8, 7, 5}, 35);		
//Items		
		LogicChip = new LogicChip("LogicChip");
		RefinedWoodenDoor = new RefinedWoodenDoorItem("RefinedWoodenDoor");
		GrinderHead = new GrinderHeadItem("GrinderHead");
		//Dust
		IronDust = new DustItem("IronDust");
		GoldDust = new DustItem("GoldDust");
		DiamondDust = new DustItem("DiamondDust");
		//Gems
		EmptyGem = new EmptyGemItem("EmptyGem", 0);
		EnergyGem = new EmptyGemItem("EnergyGem", 1);
		Peridot = new PeridotItem("Peridot");
		//HellStone
		HellStoneDust = new HellStoneDust("HellStoneDust");
		HellStoneBar = new HellStoneBar("HellStoneBar");
		HellStoneSword = new HellStoneSword(HellStone, "HellStoneSword");
		HellStoneSpade = new HellStoneSpade(HellStone, "HellStoneSpade");
		HellStonePickAxe = new HellStonePickaxe(HellStone, "HellStonePickAxe");
		HellStoneAxe = new HellStoneAxe(HellStone, "HellStoneAxe");
		HellStoneHoe = new HellStoneHoe(HellStone, "HellStoneHoe");
		HellStoneHelmet = new HellStoneArmor(HellStoneArmor1, 0, "HellStoneHelmet");
		HellStoneChest = new HellStoneArmor(HellStoneArmor1, 1, "HellStoneChest");
		HellStoneLegs = new HellStoneArmor(HellStoneArmor1, 2, "HellStoneLegs");	
		HellStoneBoots = new HellStoneArmor(HellStoneArmor1, 3, "HellStoneBoots");		
		//Obsidian
		ObsidianDust = new ObsidianDust("ObsidianDust");
		ObsidianBar = new ObsidianBar("ObsidianBar");
		ObsidianSword = new ObsidianSword(Obsidian, "ObsidianSword");
		ObsidianSpade = new ObsidianSpade(Obsidian, "ObsidianSpade");
		ObsidianPickAxe = new ObsidianPickaxe(Obsidian, "ObsidianPickAxe");
		ObsidianAxe = new ObsidianAxe(Obsidian, "ObsidianAxe");
		ObsidianHoe = new ObsidianHoe(Obsidian, "ObsidianHoe");
		ObsidianHelmet = new ObsidianArmor(ObsidianArmor1, 0, "ObsidianHelmet");
		ObsidianChest = new ObsidianArmor(ObsidianArmor1, 1, "ObsidianChest");
		ObsidianLegs = new ObsidianArmor(ObsidianArmor1, 2, "ObsidianLegs");	
		ObsidianBoots = new ObsidianArmor(ObsidianArmor1, 3, "ObsidianBoots");	
		//Terbium
		TerbiumDust = new TerbiumDust("TerbiumDust");
		TerbiumBar = new TerbiumBar("TerbiumBar");
		TerbiumSword = new TerbiumSword(Terbium, "TerbiumSword");
		TerbiumSpade = new TerbiumSpade(Terbium, "TerbiumSpade");
		TerbiumPickAxe = new TerbiumPickaxe(Terbium, "TerbiumPickAxe");
		TerbiumAxe = new TerbiumAxe(Terbium, "TerbiumAxe");
		TerbiumHoe = new TerbiumHoe(Terbium, "TerbiumHoe");
		TerbiumHelmet = new TerbiumArmor(TerbiumArmor1, 0, "TerbiumHelmet");
		TerbiumChest = new TerbiumArmor(TerbiumArmor1, 1, "TerbiumChest");
		TerbiumLegs = new TerbiumArmor(TerbiumArmor1, 2, "TerbiumLegs");	
		TerbiumBoots = new TerbiumArmor(TerbiumArmor1, 3, "TerbiumBoots");
		//Silver
		SilverDust = new SilverDust("SilverDust");
		SilverBar = new SilverBar("SilverBar");
		SilverSword = new SilverSword(Silver, "SilverSword");
		SilverSpade = new SilverSpade(Silver, "SilverSpade");
		SilverPickAxe = new SilverPickaxe(Silver, "SilverPickAxe");
		SilverAxe = new SilverAxe(Silver, "SilverAxe");
		SilverHoe = new SilverHoe(Silver, "SilverHoe");
		SilverHelmet = new SilverArmor(SilverArmor1, 0, "SilverHelmet");
		SilverChest = new SilverArmor(SilverArmor1, 1, "SilverChest");
		SilverLegs = new SilverArmor(SilverArmor1, 2, "SilverLegs");	
		SilverBoots = new SilverArmor(SilverArmor1, 3, "SilverBoots");
//Blocks	
	//gui blocks
		Grinder = new MaterBlock("Grinder");
		BarMaker = new BarMakerBlock("BarMaker");
		SmartFurnace = new SmartFurnaceBlock("SmartFurnace");
		GemCharger = new GemChargerBlock("GemCharger");
		Infuser = new InfuserBlock("Infuser");
	//other blocks
		RefinedWoodenDoorBlock = new RefinedWoodenDoorBlock(Material.iron);
		meltingObsidian = new meltingObsidian("meltingObsidian");
		meltingObsidian1 = new meltingObsidian1("meltingObsidian1");
		meltingObsidian0 = new meltingObsidian0("meltingObsidian0");
		meltingIce = new meltingIce("meltingice");
		VanishingLight = new VanishingLight("VanishingLight");
	//Ore fluid
		HellStoneOre = new HellStoneOre("HellStoneOre");
		TerbiumOre = new TerbiumOre("TerbiumOre");
		SilverOre = new SilverOre("SilverOre");
		GemOre = new GemOre("GemOre");
		PeridotOre = new PeridotOre("PeridotOre");
//TileEnt's
	    GameRegistry.registerTileEntity(GrinderLogic.class, "Grinder");
	    GameRegistry.registerTileEntity(BarMakerLogic.class, "BarMaker");
	    GameRegistry.registerTileEntity(GemChargerLogic.class, "ChemCharger");
	    GameRegistry.registerTileEntity(InfuserLogic.class, "Infuser");
//Fluids
	    //FluidRegistry.registerFluid(MultenHellStone);
	   // FluidRegistry.addBucketForFluid(MultenHellStone);
	    //FluidRegistry.registerFluid(MultenSilver);
	   // FluidRegistry.registerFluid(MultenTerbium);
//Items
		GameRegistry.registerItem(LogicChip, "LogicChip");
		GameRegistry.registerItem(RefinedWoodenDoor, "RefinedWoodenDoor");
		GameRegistry.registerItem(GrinderHead, "GrinderHead");
		//Dust
		GameRegistry.registerItem(IronDust, "IronDust");
		GameRegistry.registerItem(GoldDust, "GoldDust");
		GameRegistry.registerItem(DiamondDust, "DiamondDust");		
		//Gems
		GameRegistry.registerItem(EmptyGem, "EmptyGem");
		GameRegistry.registerItem(EnergyGem, "EnergyGem");
		GameRegistry.registerItem(Peridot, "Peridot");
		//HellStone
		GameRegistry.registerItem(HellStoneDust, "HellStoneDust");
		GameRegistry.registerItem(HellStoneBar, "HellStoneBar");
		GameRegistry.registerItem(HellStoneSword, "HellStoneSword");
		GameRegistry.registerItem(HellStoneSpade, "HellStoneSpade");
		GameRegistry.registerItem(HellStonePickAxe, "HellStonePickAxe");
		GameRegistry.registerItem(HellStoneAxe, "HellStoneAxe");
		GameRegistry.registerItem(HellStoneHoe, "HellStoneHoe");
		GameRegistry.registerItem(HellStoneHelmet, "HellStoneHelmet");
		GameRegistry.registerItem(HellStoneChest, "HellStoneChest");
		GameRegistry.registerItem(HellStoneLegs, "HellStoneLegs");
		GameRegistry.registerItem(HellStoneBoots, "HellStoneBoots");
		//Obsidian
		GameRegistry.registerItem(ObsidianDust, "ObsidianDust");
		GameRegistry.registerItem(ObsidianBar, "ObsidianBar");
		GameRegistry.registerItem(ObsidianSword, "ObsidianSword");
		GameRegistry.registerItem(ObsidianSpade, "ObsidianSpade");
		GameRegistry.registerItem(ObsidianPickAxe, "ObsidianPickAxe");
		GameRegistry.registerItem(ObsidianAxe, "ObsidianAxe");
		GameRegistry.registerItem(ObsidianHoe, "ObsidianHoe");
		GameRegistry.registerItem(ObsidianHelmet, "ObsidianHelmet");
		GameRegistry.registerItem(ObsidianChest, "ObsidianChest");
		GameRegistry.registerItem(ObsidianLegs, "ObsidianLegs");
		GameRegistry.registerItem(ObsidianBoots, "ObsidianBoots");
		//Terbium
		GameRegistry.registerItem(TerbiumDust, "TerbiumDust");
		GameRegistry.registerItem(TerbiumBar, "TerbiumBar");
		GameRegistry.registerItem(TerbiumSword, "TerbiumSword");
		GameRegistry.registerItem(TerbiumSpade, "TerbiumSpade");
		GameRegistry.registerItem(TerbiumPickAxe, "TerbiumPickAxe");
		GameRegistry.registerItem(TerbiumAxe, "TerbiumAxe");
		GameRegistry.registerItem(TerbiumHoe, "TerbiumHoe");
		GameRegistry.registerItem(TerbiumHelmet, "TerbiumHelmet");
		GameRegistry.registerItem(TerbiumChest, "TerbiumChest");
		GameRegistry.registerItem(TerbiumLegs, "TerbiumLegs");
		GameRegistry.registerItem(TerbiumBoots, "TerbiumBoots");
		//Silver
		GameRegistry.registerItem(SilverDust, "SilverDust");
		GameRegistry.registerItem(SilverBar, "SilverBar");
		GameRegistry.registerItem(SilverSword, "SilverSword");
		GameRegistry.registerItem(SilverSpade, "SilverSpade");
		GameRegistry.registerItem(SilverPickAxe, "SilverPickAxe");
		GameRegistry.registerItem(SilverAxe, "SilverAxe");
		GameRegistry.registerItem(SilverHoe, "SilverHoe");
		GameRegistry.registerItem(SilverHelmet, "SilverHelmet");
		GameRegistry.registerItem(SilverChest, "SilverChest");
		GameRegistry.registerItem(SilverLegs, "SilverLegs");
		GameRegistry.registerItem(SilverBoots, "SilverBoots");
//Blocks
		//gui
		GameRegistry.registerBlock(Grinder, "Grinder");
		GameRegistry.registerBlock(BarMaker, "BarMaker");
		GameRegistry.registerBlock(SmartFurnace, "SmartFurnace");
		GameRegistry.registerBlock(GemCharger, "GemCharger");
		GameRegistry.registerBlock(Infuser, "Infuser");
		//other blocks
		GameRegistry.registerBlock(RefinedWoodenDoorBlock, "RefinedWoodenDoorBlock");
		GameRegistry.registerBlock(meltingObsidian, "meltingObsidian");
		GameRegistry.registerBlock(meltingObsidian1, "meltingObsidian1");
		GameRegistry.registerBlock(meltingObsidian0, "meltingObsidian0");
		GameRegistry.registerBlock(meltingIce, "meltingIce");
		GameRegistry.registerBlock(VanishingLight, "VanishingLight");
		//Ore
		GameRegistry.registerBlock(HellStoneOre, "HellStoneOre");
		GameRegistry.registerBlock(GemOre, "GemOre");
		GameRegistry.registerBlock(TerbiumOre, "TerbiumOre");
		GameRegistry.registerBlock(SilverOre, "SilverOre");
		GameRegistry.registerBlock(PeridotOre, "PeridotOre");
//Crafting		
		//Items
		GameRegistry.addRecipe(new ItemStack(LogicChip, 2), new Object[] {"323","313", '1', Peridot, '2', Items.redstone, '3', Blocks.stone_button});
		GameRegistry.addRecipe(new ItemStack(GrinderHead, 4), new Object[]{" 11"," 1 ","  2", '1', Items.stick, '2', SilverBar});
        GameRegistry.addRecipe(new ItemStack(RefinedWoodenDoor, 1), new Object[] {"01", '0', Peridot, '1', Items.wooden_door});

		//Silver
        GameRegistry.addRecipe(new ItemStack(SilverSword, 1), new Object[] {" 1 ", " 1 ", " 7 ", '1', SilverBar, '7', Items.stick});
        GameRegistry.addRecipe(new ItemStack(SilverHoe, 1), new Object[] {"00 ", " 4 ", " 4 ", '0', SilverBar, '4', Items.stick});
        GameRegistry.addRecipe(new ItemStack(SilverHoe, 1), new Object[] {" 00", " 4 ", " 4 ", '0', SilverBar, '4', Items.stick});
        GameRegistry.addRecipe(new ItemStack(SilverPickAxe, 1), new Object[] {"000", " 4 ", " 4 ", '0', SilverBar, '4', Items.stick});
        GameRegistry.addRecipe(new ItemStack(SilverAxe, 1), new Object[] {"11 ", "14 ", " 4 ", '1', SilverBar, '4', Items.stick});
        GameRegistry.addRecipe(new ItemStack(SilverAxe, 1), new Object[] {" 11", " 41", " 4 ", '1', SilverBar, '4', Items.stick});
        GameRegistry.addRecipe(new ItemStack(SilverSpade, 1), new Object[] {" 1 ", " 4 ", " 4 ", '1', SilverBar, '4', Items.stick});
        //Terbium
        GameRegistry.addRecipe(new ItemStack(TerbiumSword, 1), new Object[] {" 1 ", " 1 ", " 7 ", '1', TerbiumBar, '7', Items.stick});
        GameRegistry.addRecipe(new ItemStack(TerbiumHoe, 1), new Object[] {"00 ", " 4 ", " 4 ", '0', TerbiumBar, '4', Items.stick});
        GameRegistry.addRecipe(new ItemStack(TerbiumHoe, 1), new Object[] {" 00", " 4 ", " 4 ", '0', TerbiumBar, '4', Items.stick});
        GameRegistry.addRecipe(new ItemStack(TerbiumPickAxe, 1), new Object[] {"000", " 4 ", " 4 ", '0', TerbiumBar, '4', Items.stick});
        GameRegistry.addRecipe(new ItemStack(TerbiumAxe, 1), new Object[] {"11 ", "14 ", " 4 ", '1', TerbiumBar, '4', Items.stick});
        GameRegistry.addRecipe(new ItemStack(TerbiumAxe, 1), new Object[] {" 11", " 41", " 4 ", '1', TerbiumBar, '4', Items.stick});
        GameRegistry.addRecipe(new ItemStack(TerbiumSpade, 1), new Object[] {" 1 ", " 4 ", " 4 ", '1', TerbiumBar, '4', Items.stick});
        //HellStone
        GameRegistry.addRecipe(new ItemStack(HellStoneSword, 1), new Object[] {" 1 ", " 1 ", " 7 ", '1', HellStoneBar, '7', ObsidianBar});
        GameRegistry.addRecipe(new ItemStack(HellStoneHoe, 1), new Object[] {"00 ", " 4 ", " 4 ", '0', HellStoneBar, '4', ObsidianBar});
        GameRegistry.addRecipe(new ItemStack(HellStoneHoe, 1), new Object[] {" 00", " 4 ", " 4 ", '0', HellStoneBar, '4', ObsidianBar});
        GameRegistry.addRecipe(new ItemStack(HellStonePickAxe, 1), new Object[] {"000", " 4 ", " 4 ", '0', HellStoneBar, '4', ObsidianBar});
        GameRegistry.addRecipe(new ItemStack(HellStoneAxe, 1), new Object[] {"11 ", "14 ", " 4 ", '1', HellStoneBar, '4', ObsidianBar});
        GameRegistry.addRecipe(new ItemStack(HellStoneAxe, 1), new Object[] {" 11", " 41", " 4 ", '1', HellStoneBar, '4', ObsidianBar});
        GameRegistry.addRecipe(new ItemStack(HellStoneSpade, 1), new Object[] {" 1 ", " 4 ", " 4 ", '1', HellStoneBar, '4', ObsidianBar});
        //Obsidian
        GameRegistry.addRecipe(new ItemStack(ObsidianSword, 1), new Object[] {" 1 ", " 1 ", " 7 ", '1', ObsidianBar, '7', Items.blaze_rod});
        GameRegistry.addRecipe(new ItemStack(ObsidianHoe, 1), new Object[] {"00 ", " 4 ", " 4 ", '0', ObsidianBar, '4', Items.blaze_rod});
        GameRegistry.addRecipe(new ItemStack(ObsidianHoe, 1), new Object[] {" 00", " 4 ", " 4 ", '0', ObsidianBar, '4', Items.blaze_rod});
        GameRegistry.addRecipe(new ItemStack(ObsidianPickAxe, 1), new Object[] {"000", " 4 ", " 4 ", '0', ObsidianBar, '4', Items.blaze_rod});
        GameRegistry.addRecipe(new ItemStack(ObsidianAxe, 1), new Object[] {"11 ", "14 ", " 4 ", '1', ObsidianBar, '4', Items.blaze_rod});
        GameRegistry.addRecipe(new ItemStack(ObsidianAxe, 1), new Object[] {" 11", " 41", " 4 ", '1', ObsidianBar, '4', Items.blaze_rod});
        GameRegistry.addRecipe(new ItemStack(ObsidianSpade, 1), new Object[] {" 1 ", " 4 ", " 4 ", '1', ObsidianBar, '4', Items.blaze_rod});
//Armor
        //HellStone
        GameRegistry.addRecipe(new ItemStack(HellStoneHelmet, 1), new Object[] {"XXX", "X X", 'X', HellStoneBar});
        GameRegistry.addRecipe(new ItemStack(HellStoneChest, 1), new Object[] {"X X", "XXX", "XXX", 'X', HellStoneBar});
        GameRegistry.addRecipe(new ItemStack(HellStoneLegs, 1), new Object[] {"XXX", "X X", "X X", 'X', HellStoneBar});
        GameRegistry.addRecipe(new ItemStack(HellStoneBoots, 1), new Object[] {"X X", "X X", 'X', HellStoneBar});
        //Obsidian
        GameRegistry.addRecipe(new ItemStack(ObsidianHelmet, 1), new Object[] {"XXX", "X X", 'X', ObsidianBar});
        GameRegistry.addRecipe(new ItemStack(ObsidianChest, 1), new Object[] {"X X", "XXX", "XXX", 'X', ObsidianBar});
        GameRegistry.addRecipe(new ItemStack(ObsidianLegs, 1), new Object[] {"XXX", "X X", "X X", 'X', ObsidianBar});
        GameRegistry.addRecipe(new ItemStack(ObsidianBoots, 1), new Object[] {"X X", "X X", 'X', ObsidianBar});
        //Turbium
        GameRegistry.addRecipe(new ItemStack(TerbiumHelmet, 1), new Object[] {"XXX", "X X", 'X', TerbiumBar});
        GameRegistry.addRecipe(new ItemStack(TerbiumChest, 1), new Object[] {"X X", "XXX", "XXX", 'X', TerbiumBar});
        GameRegistry.addRecipe(new ItemStack(TerbiumLegs, 1), new Object[] {"XXX", "X X", "X X", 'X', TerbiumBar});
        GameRegistry.addRecipe(new ItemStack(TerbiumBoots, 1), new Object[] {"X X", "X X", 'X', TerbiumBar});
        //Silver
        GameRegistry.addRecipe(new ItemStack(SilverHelmet, 1), new Object[] {"XXX", "X X", 'X', SilverBar});
        GameRegistry.addRecipe(new ItemStack(SilverChest, 1), new Object[] {"X X", "XXX", "XXX", 'X', SilverBar});
        GameRegistry.addRecipe(new ItemStack(SilverLegs, 1), new Object[] {"XXX", "X X", "X X", 'X', SilverBar});
        GameRegistry.addRecipe(new ItemStack(SilverBoots, 1), new Object[] {"X X", "X X", 'X', SilverBar});
//Blocks
        GameRegistry.addRecipe(new ItemStack(Grinder, 1), new Object[] {"xxx", "zyz", "xzx", 'x', Blocks.stone, 'z',Blocks.cobblestone, 'y', Blocks.furnace});
        GameRegistry.addRecipe(new ItemStack(BarMaker, 1), new Object[] {"121", "232", "121", '1', SilverBar, '2', Blocks.cobblestone, '3', SmartFurnace});
        GameRegistry.addShapelessRecipe(new ItemStack(SmartFurnace, 1), new Object[] {LogicChip, Blocks.furnace});
        GameRegistry.addRecipe(new ItemStack(Infuser, 1), new Object[] {"141", "232", "212", '1', HellStoneBar, '2', Blocks.piston, '3', BarMaker, '4', LogicChip});
        GameRegistry.addRecipe(new ItemStack(GemCharger, 1), new Object[] {"222", "232", "212",  '1', Items.lava_bucket, '2', Blocks.obsidian, '3', SmartFurnace});
//Smelting
        GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather), 0.1F);
        GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(ObsidianBar), 1.1F);
        GameRegistry.addSmelting(SilverOre, new ItemStack(SilverBar), 1.6F);
        GameRegistry.addSmelting(TerbiumOre, new ItemStack(TerbiumBar), 1.9F);
        GameRegistry.addSmelting(HellStoneOre, new ItemStack(HellStoneBar), 2.1F);
        GameRegistry.addSmelting(GemOre, new ItemStack (EmptyGem), 5.8F);
        GameRegistry.addSmelting(PeridotOre, new ItemStack(Peridot), 5.2F);
        GameRegistry.addSmelting(SilverDust, new ItemStack(SilverBar), 1.6F);
        GameRegistry.addSmelting(TerbiumDust, new ItemStack(TerbiumBar), 1.9F);
        GameRegistry.addSmelting(HellStoneDust, new ItemStack(HellStoneBar), 2.1F);
        GameRegistry.addSmelting(ObsidianDust, new ItemStack (ObsidianBar), 5.8f);
        GameRegistry.addSmelting(IronDust, new ItemStack(Items.iron_ingot), 1.6F);
        GameRegistry.addSmelting(GoldDust, new ItemStack(Items.gold_ingot), 1.9F);
        GameRegistry.addSmelting(DiamondDust, new ItemStack(Items.diamond), 2.1F);
//World Gen
        GameRegistry.registerWorldGenerator(new DefineOreGen(), 1);
//Ore Dictionary adding
        OreDictionary.registerOre("dustSilver", new ItemStack(SilverDust));
        OreDictionary.registerOre("ingotSilver", new ItemStack(SilverBar));
        //OreDictionary.registerOre("blockSilver", new ItemStack(Silver));
        OreDictionary.registerOre("dustTerbium", new ItemStack(TerbiumDust));
        OreDictionary.registerOre("ingotTerbium", new ItemStack(TerbiumBar));
        //OreDictionary.registerOre("blockTerbium", new ItemStack(TerbiumBlock));
        OreDictionary.registerOre("dustObsidian", new ItemStack(ObsidianDust));
        OreDictionary.registerOre("ingotObsidian", new ItemStack(ObsidianBar));
        //OreDictionary.registerOre("blockObsidian", new ItemStack(ObsidianBlock));
        OreDictionary.registerOre("dustHellStone", new ItemStack(HellStoneDust));
        OreDictionary.registerOre("ingotHellStone", new ItemStack(HellStoneBar));
        //OreDictionary.registerOre("blockHellStone", new ItemStack(HellstoneBlock));
        OreDictionary.registerOre("dustDiamond", new ItemStack(DiamondDust));
        OreDictionary.registerOre("dustGold", new ItemStack(GoldDust));
        OreDictionary.registerOre("dustIron", new ItemStack(IronDust));
    	OreDictionary.registerOre("oreHellstone", new ItemStack(HellStoneOre));
    	OreDictionary.registerOre("oreTerbium", new ItemStack(TerbiumOre));
    	OreDictionary.registerOre("oreSilver", new ItemStack(SilverOre));
//Network Registry        
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

	}
	

	@EventHandler
	public void postinit(FMLPreInitializationEvent event) {
	System.out.println("***************************************************************");
	System.out.println("      Definecraft Is Loaded Up, You Are Ready To Play      ");
	System.out.println("===============================================================");
		
	}
	

	

}
