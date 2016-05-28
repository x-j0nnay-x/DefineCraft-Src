package com.DefineCraft.item;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LogicChip extends Item{
      
       public LogicChip(String itemName){
               setUnlocalizedName(Ref.MODID + "_" + itemName);
               setTextureName(Ref.MODID + ":" + itemName);
       		setCreativeTab(DefineCraftMod.DefineCraft);
       }

}