package com.DefineCraft.item.Silver;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SilverBar  extends Item
{
	public SilverBar(String itemName){
        setUnlocalizedName(Ref.MODID + "_" + itemName);
        setTextureName(Ref.MODID + ":" + itemName);
		setCreativeTab(DefineCraftMod.DefineCraft);
}
    
}
