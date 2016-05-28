package com.DefineCraft.item.Gems;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EmptyGemItem extends Item{
      
	private int isFull;
	
       public EmptyGemItem(String itemName, int par2){
               setUnlocalizedName(Ref.MODID + "_" + itemName);
               setTextureName(Ref.MODID + ":" + itemName);
       		setCreativeTab(DefineCraftMod.DefineCraft);
       		this.isFull = par2;
       }

}