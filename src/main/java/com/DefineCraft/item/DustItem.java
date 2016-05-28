package com.DefineCraft.item;

import net.minecraft.item.Item;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

public class DustItem extends Item{
    
    public DustItem(String itemName){
            setUnlocalizedName(Ref.MODID + "_" + itemName);
            setTextureName(Ref.MODID + ":" + itemName);
    		setCreativeTab(DefineCraftMod.DefineCraft);
    }

}
