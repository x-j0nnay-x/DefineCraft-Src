package com.DefineCraft.item.Obsidian;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ObsidianBar  extends Item
{
	public ObsidianBar(String itemName){
        setUnlocalizedName(Ref.MODID + "_" + itemName);
        setTextureName(Ref.MODID + ":" + itemName);
		setCreativeTab(DefineCraftMod.DefineCraft);

}
    
}
