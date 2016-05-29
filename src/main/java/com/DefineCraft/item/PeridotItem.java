package com.DefineCraft.item;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PeridotItem extends Item{
      
       public PeridotItem(String itemName){
    	   this.setUnlocalizedName(Ref.MODID + "_" +itemName);
           this.setTextureName(Ref.MODID + ":" + itemName);
   		setCreativeTab(DefineCraftMod.DefineCraft);
       }

}