package com.DefineCraft.item.Terbium;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TerbiumArmor extends ItemArmor
{
	public TerbiumArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		setUnlocalizedName(Ref.MODID + "_" + name);
		setTextureName(Ref.MODID + ":" + name);
		setCreativeTab(DefineCraftMod.DefineCraft);

	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
	{
		if (stack.getItem() == DefineCraftMod.TerbiumHelmet || stack.getItem() == DefineCraftMod.TerbiumChest || stack.getItem() == DefineCraftMod.TerbiumBoots) 
		{
			return Ref.MODID + ":models/armor/Terbium1.png";
		}
		else if(stack.getItem() == DefineCraftMod.TerbiumLegs)
		{
			return Ref.MODID + ":models/armor/Terbium2.png";
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
		if(itemStack.getItem().getUnlocalizedName() == "TerbiumHelmet")
		{
			if(player.isInWater())
			{
				player.setAir(20);
			}
		}
	}
}