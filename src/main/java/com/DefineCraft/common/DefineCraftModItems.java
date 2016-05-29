package com.DefineCraft.common;


import com.DefineCraft.item.*;
import com.DefineCraft.item.Gems.EmptyGemItem;
import com.DefineCraft.item.HellStone.HellStoneArmor;
import com.DefineCraft.item.HellStone.HellStoneAxe;
import com.DefineCraft.item.HellStone.HellStoneBar;
import com.DefineCraft.item.HellStone.HellStoneDust;
import com.DefineCraft.item.HellStone.HellStoneHoe;
import com.DefineCraft.item.HellStone.HellStonePickaxe;
import com.DefineCraft.item.HellStone.HellStoneSpade;
import com.DefineCraft.item.HellStone.HellStoneSword;
import com.DefineCraft.item.Obsidian.ObsidianArmor;
import com.DefineCraft.item.Obsidian.ObsidianAxe;
import com.DefineCraft.item.Obsidian.ObsidianBar;
import com.DefineCraft.item.Obsidian.ObsidianDust;
import com.DefineCraft.item.Obsidian.ObsidianHoe;
import com.DefineCraft.item.Obsidian.ObsidianPickaxe;
import com.DefineCraft.item.Obsidian.ObsidianSpade;
import com.DefineCraft.item.Obsidian.ObsidianSword;
import com.DefineCraft.item.Silver.SilverArmor;
import com.DefineCraft.item.Silver.SilverAxe;
import com.DefineCraft.item.Silver.SilverBar;
import com.DefineCraft.item.Silver.SilverDust;
import com.DefineCraft.item.Silver.SilverHoe;
import com.DefineCraft.item.Silver.SilverPickaxe;
import com.DefineCraft.item.Silver.SilverSpade;
import com.DefineCraft.item.Silver.SilverSword;
import com.DefineCraft.item.Terbium.TerbiumArmor;
import com.DefineCraft.item.Terbium.TerbiumAxe;
import com.DefineCraft.item.Terbium.TerbiumBar;
import com.DefineCraft.item.Terbium.TerbiumDust;
import com.DefineCraft.item.Terbium.TerbiumHoe;
import com.DefineCraft.item.Terbium.TerbiumPickaxe;
import com.DefineCraft.item.Terbium.TerbiumSpade;
import com.DefineCraft.item.Terbium.TerbiumSword;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(Ref.MODID)
public class DefineCraftModItems{

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

public static void pre_init() {
	
	ToolMaterial Silver = EnumHelper.addToolMaterial("Silver", 3, 300, 8F, 3, 20);
	ToolMaterial Terbium = EnumHelper.addToolMaterial("Terbium", 3, 500, 10F, 3, 25);
	ToolMaterial Obsidian = EnumHelper.addToolMaterial("Obsidian", 3, 1500, 15F, 4, 30);
	ToolMaterial HellStone = EnumHelper.addToolMaterial("HellStone", 3, 2000, 25F, 5, 35);
	ArmorMaterial SilverArmor1 = EnumHelper.addArmorMaterial("SilverArmor", 33, new int[] {3, 4, 4, 3}, 20);
	ArmorMaterial TerbiumArmor1 = EnumHelper.addArmorMaterial("TerbiumArmor", 33, new int[] {3, 4, 5, 3}, 25);
	ArmorMaterial ObsidianArmor1 = EnumHelper.addArmorMaterial("ObsidianArmor", 33, new int[] {3, 8, 6, 4}, 30);
	ArmorMaterial HellStoneArmor1 = EnumHelper.addArmorMaterial("HellStoneArmor", 33, new int[] {3, 8, 7, 5}, 35);	
	
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
}
    public static void init()
    {
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

    }
}