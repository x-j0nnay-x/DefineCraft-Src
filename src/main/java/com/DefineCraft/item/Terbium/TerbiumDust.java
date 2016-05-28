package com.DefineCraft.item.Terbium;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TerbiumDust  extends Item
{
	public TerbiumDust(String itemName){
        setUnlocalizedName(Ref.MODID + "_" + itemName);
        setTextureName(Ref.MODID + ":" + itemName);
		setCreativeTab(DefineCraftMod.DefineCraft);
}
	
}