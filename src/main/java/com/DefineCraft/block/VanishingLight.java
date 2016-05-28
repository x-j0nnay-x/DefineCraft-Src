package com.DefineCraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;

import com.DefineCraft.block.GemCharger.GemChargerLogic;
import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.Ref;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class VanishingLight extends Block
{
	
    public VanishingLight(String name)
    {
    super(Material.circuits);
    this.setTickRandomly(true);
	setBlockName(Ref.MODID + "_" + name);
	setBlockTextureName(Ref.MODID + ":" + name);
	//setBlockTextureName();
	setCreativeTab(DefineCraftMod.DefineCraft);
	setHardness(100.0F);
	setResistance(100.0F);
	setLightOpacity(16);
	setLightLevel(1.0f);
    }
    public void updateTick(World world, int i, int j, int k, Random rand)
    {
    	
    	this.dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
        world.setBlock(i, j, k, Blocks.air);
    	
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int wx, int wy, int wz)
    {
        return null;
    }
    public boolean canCollideCheck(int p_149678_1_, boolean p_149678_2_)
    {
        return false;
    }

    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
   		 super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
            int l1 = par1World.getBlockMetadata(par2, par3, par4);
            float f = (float)par2 + 0F;
            float f1 = (float)par3 + 0.0F + par5Random.nextFloat() ;
            float f2 = (float)par4 + 0F;
            float f3 = 0.F;
            float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

            for (int l = par2 - 2; l <= par2 + 2; ++l)
            {
                for (int i1 = par4 - 2; i1 <= par4 + 2; ++i1)
                {
                    if (l > par2 - 2 && l < par2 + 2 && i1 == par4 - 1)
                    {
                        i1 = par4 + 2;
                    }

                    if (par5Random.nextInt(16) == 0)
                    {
                        for (int j1 = par3; j1 <= par3 + 1; ++j1)
                        {
                            if (!par1World.isAirBlock((l - par2) / 2 + par2, j1, (i1 - par4) / 2 + par4))
                            {
                                break;
                            }

                            par1World.spawnParticle("enchantmenttable", (double)par2 + 0.5D, (double)par3 + 2.0D, (double)par4 + 0.5D, (double)((float)(l - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(j1 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(i1 - par4) + par5Random.nextFloat()) - 0.5D);
                        }
                    }
                }
            }

            for (int l = 0; l < 3; ++l)
            {
                double d0 = (double)((float)par2 + par5Random.nextFloat());
                double d1 = (double)((float)par3 + par5Random.nextFloat());
                d0 = (double)((float)par4 + par5Random.nextFloat());
                double d2 = 0.0D;
                double d3 = 0.0D;
                double d4 = 0.0D;
                int i1 = par5Random.nextInt(2) * 2 - 1;
                int j1 = par5Random.nextInt(2) * 2 - 1;
                d2 = ((double)par5Random.nextFloat() - 0.5D) * 0.125D;
                d3 = ((double)par5Random.nextFloat() - 0.5D) * 0.125D;
                d4 = ((double)par5Random.nextFloat() - 0.5D) * 0.125D;
                double d5 = (double)par4 + 0.5D + 0.25D * (double)j1;
                d4 = (double)(par5Random.nextFloat() * 1.0F * (float)j1);
                double d6 = (double)par2 + 0.5D + 0.25D * (double)i1;
                d2 = (double)(par5Random.nextFloat() * 1.0F * (float)i1);
                par1World.spawnParticle("portal", d6, d1, d5, d2, d3, d4);
            }
        
    }
   
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }
    public boolean isOpaqueCube()
    {
        return false;
    }
    public int getRenderType()
    {
        return -1;
    }
    public boolean renderAsNormalBlock()
    {
        return false;
    }
   
	  

}