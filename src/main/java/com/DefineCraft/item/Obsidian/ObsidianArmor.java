package com.DefineCraft.item.Obsidian;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ObsidianArmor extends ItemArmor
{
	public ObsidianArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		setUnlocalizedName(Ref.MODID + "_" + name);
		setTextureName(Ref.MODID + ":" + name);
		setCreativeTab(DefineCraftMod.DefineCraft);

	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
	{
		if (stack.getItem() == DefineCraftMod.ObsidianHelmet || stack.getItem() == DefineCraftMod.ObsidianChest || stack.getItem() == DefineCraftMod.ObsidianBoots) 
		{
			return Ref.MODID + ":models/armor/Obsidian1.png";
		}
		else if(stack.getItem() == DefineCraftMod.ObsidianLegs)
		{
			return Ref.MODID + ":models/armor/Obsidian2.png";
		}
		else
		{
			System.out.println("Invalid Item");
			return null;
		}
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if(itemStack.getItem().getUnlocalizedName() == "ObsidianHelmet")
		{
			if(player.isInWater())
			{
				player.setAir(20);
			}
		}
	}
}