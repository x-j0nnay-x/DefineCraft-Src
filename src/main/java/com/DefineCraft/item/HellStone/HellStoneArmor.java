package com.DefineCraft.item.HellStone;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;
import com.DefineCraft.block.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class HellStoneArmor extends ItemArmor
{
	public HellStoneArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		setUnlocalizedName(Ref.MODID + "_" + name);
		setTextureName(Ref.MODID + ":" + name);
		setCreativeTab(DefineCraftMod.DefineCraft);

	}
	


	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
	{
		if (stack.getItem() == DefineCraftMod.HellStoneHelmet) 
		{
			return Ref.MODID + ":models/armor/hellstone1.png";
		}
		else if (stack.getItem() == DefineCraftMod.HellStoneChest) 
		{
			return Ref.MODID + ":models/armor/hellstone1.png";
		}
		else if (stack.getItem() == DefineCraftMod.HellStoneBoots) 
		{
			return Ref.MODID + ":models/armor/hellstone1.png";
		}
		else if(stack.getItem() == DefineCraftMod.HellStoneLegs)
		{
			return Ref.MODID + ":models/armor/hellstone2.png";  
		}
		//else if (stack.getItem() == DefineCraftMod.HellStoneChest) 
		//{
		//	return Ref.MODID + ":models/armor/HellStoneArmorChest.png";
		//}
		else
		{
			System.out.println("Invalid Item");
			return null;
		}
	}
	//public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (player.getCurrentArmor(0) != null &&player.getCurrentArmor(0).getItem().equals(DefineCraftMod.HellStoneBoots))
		{
				for(int _x = -3; _x <= 3; _x++) {
				for(int _z = -3; _z <= 3; _z++) {
					if(Math.abs(_x) + Math.abs(_z) <= 3) {
							int x = (int) player.posX;
							int y = (int) player.posY - 1;
							int z = (int) player.posZ;
							boolean IsFlowing = (world.getBlockMetadata(x+_x, y, z+_z) >= 1);
							boolean IsStill = (world.getBlockMetadata(x+_x, y, z+_z) == 0);
							Block block0 = world.getBlock(x,y+2,z-1);
							Block block = world.getBlock(x+_x, y, z+_z);
					            //check and replace.
					        if(block == Blocks.water && IsStill || block ==Blocks.flowing_water && IsStill){
					    			world.setBlock(x+_x, y, z+_z, DefineCraftMod.meltingObsidian1);
					    			world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
					    			}
					        if(block == Blocks.lava && IsStill || block ==Blocks.flowing_lava && IsStill){
				    			world.setBlock(x+_x, y, z+_z, DefineCraftMod.meltingObsidian);
				    			world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
				    			}
					        if(block == Blocks.water && IsFlowing || block ==Blocks.flowing_water && IsFlowing || block == Blocks.lava && IsFlowing || block ==Blocks.flowing_lava && IsFlowing){
				    			world.setBlock(x+_x, y, z+_z, DefineCraftMod.meltingObsidian0);
				    			world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
				    			}
					      //has full armor
							if (player.getCurrentArmor(0) != null &&player.getCurrentArmor(0).getItem().equals(DefineCraftMod.HellStoneBoots) && player.getCurrentArmor(1) != null &&player.getCurrentArmor(1).getItem().equals(DefineCraftMod.HellStoneLegs) && player.getCurrentArmor(2) != null &&player.getCurrentArmor(2).getItem().equals(DefineCraftMod.HellStoneChest) && player.getCurrentArmor(3) != null &&player.getCurrentArmor(3).getItem().equals(DefineCraftMod.HellStoneHelmet)){
								{
								if (world.getBlockLightValue(x, y+1, z) <=8 && block0 != DefineCraftMod.VanishingLight){
									 world.setBlock(x,y+1,z, DefineCraftMod.VanishingLight);
									 world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "step.stone", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
								 }
								 if (player.isBurning()){
									 player.extinguish(); 
									 world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
								 }
							}
					        }
					    }
					}
				}
			}
		//Just Chest
			if (player.getCurrentArmor(2) != null &&player.getCurrentArmor(2).getItem().equals(DefineCraftMod.HellStoneChest)){
				player.fallDistance = 0.0F;
				 player.capabilities.allowFlying = true;
				}
		//just helme
		if(itemStack.getItem().getUnlocalizedName() == "HellStoneHelmet")
		{
			if(player.isInWater())
			{
				player.setAir(20);
			}
		}
	  }
}