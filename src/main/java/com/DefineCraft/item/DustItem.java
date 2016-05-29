package com.DefineCraft.item;

import net.minecraft.item.Item;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

public class DustItem extends Item{
    
    public DustItem(String itemName){
    	   this.setUnlocalizedName(Ref.MODID + "_" +itemName);
           this.setTextureName(Ref.MODID + ":" + itemName);
   			setCreativeTab(DefineCraftMod.DefineCraft);
    }

}
