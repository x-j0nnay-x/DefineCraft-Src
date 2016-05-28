package com.DefineCraft.item.Obsidian;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.item.ItemAxe;

public class ObsidianAxe extends ItemAxe 
{
	public ObsidianAxe(ToolMaterial material, String name) 
	{
		super(material);
		setUnlocalizedName(Ref.MODID + "_" + name);
		setTextureName(Ref.MODID + ":" + name);
		setCreativeTab(DefineCraftMod.DefineCraft);

	}
}
