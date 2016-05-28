package com.DefineCraft.item.Silver;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.item.ItemPickaxe;

public class SilverPickaxe extends ItemPickaxe 
{
	public SilverPickaxe(ToolMaterial material, String name) 
	{
		super(material);
		setUnlocalizedName(Ref.MODID + "_" + name);
		setTextureName(Ref.MODID + ":" + name);
		setCreativeTab(DefineCraftMod.DefineCraft);

	}
}