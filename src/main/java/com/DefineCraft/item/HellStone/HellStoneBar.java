package com.DefineCraft.item.HellStone;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HellStoneBar  extends Item
{
	public HellStoneBar(String itemName){
        setUnlocalizedName(Ref.MODID + "_" + itemName);
        setTextureName(Ref.MODID + ":" + itemName);
        setCreativeTab(CreativeTabs.tabMaterials);
		setCreativeTab(DefineCraftMod.DefineCraft);

}
    
}
