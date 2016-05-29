package com.DefineCraft.item.Silver;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.DefineCraftModItems;
import com.DefineCraft.common.Ref;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SilverArmor extends ItemArmor
{
	public SilverArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		setUnlocalizedName(Ref.MODID + "_" + name);
		setTextureName(Ref.MODID + ":" + name);
		setCreativeTab(DefineCraftMod.DefineCraft);

	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
	{
		if (stack.getItem() == DefineCraftModItems.SilverHelmet || stack.getItem() == DefineCraftModItems.SilverChest || stack.getItem() == DefineCraftModItems.SilverBoots) 
		{
			return Ref.MODID + ":models/armor/Silver1.png";
		}
		else if(stack.getItem() == DefineCraftModItems.SilverLegs)
		{
			return Ref.MODID + ":models/armor/Silver2.png";
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
		if(itemStack.getItem().getUnlocalizedName() == "SilverHelmet")
		{
			if(player.isInWater())
			{
				player.setAir(20);
			}
		}
	}
}