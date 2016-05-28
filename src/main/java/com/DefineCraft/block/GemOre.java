package com.DefineCraft.block;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GemOre extends Block {

	public GemOre(String name) {
		super(Material.rock);
		setBlockName(Ref.MODID + "_" + name);
		setBlockTextureName(Ref.MODID + ":" + name);
		setCreativeTab(DefineCraftMod.DefineCraft);
		setHardness(2.0F);
		setResistance(2.0F);
	}

}
