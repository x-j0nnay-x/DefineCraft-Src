package com.DefineCraft.block;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TerbiumOre extends Block {

	public TerbiumOre(String name) {
		super(Material.rock);
		this.setBlockName(Ref.MODID + "_" +name);
		this.setBlockTextureName(Ref.MODID + ":" +name);
		setCreativeTab(DefineCraftMod.DefineCraft);
		setHardness(2.0F);
		setResistance(2.0F);
	}

}
