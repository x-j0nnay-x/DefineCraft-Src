package com.DefineCraft.item.HellStone;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.item.ItemPickaxe;

public class HellStonePickaxe extends ItemPickaxe 
{
	public HellStonePickaxe(ToolMaterial material, String name) 
	{
		super(material);
		setUnlocalizedName(Ref.MODID + "_" + name);
		setTextureName(Ref.MODID + ":" + name);
		setCreativeTab(DefineCraftMod.DefineCraft);

	}
}