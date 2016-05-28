package com.DefineCraft.item.HellStone;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.item.ItemSword;

public class HellStoneSword extends ItemSword
{
	public HellStoneSword(ToolMaterial material, String name) 
	{
		super(material);
		setUnlocalizedName(Ref.MODID + "_" + name);
		setTextureName(Ref.MODID + ":" + name);
		setCreativeTab(DefineCraftMod.DefineCraft);

	}
}