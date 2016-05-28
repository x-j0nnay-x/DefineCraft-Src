package com.DefineCraft.block.GemCharger;

import java.util.Random;

import com.DefineCraft.block.BarMaker.BarMakerLogic;
import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.GuiHandler;
import com.DefineCraft.common.Ref;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class GemChargerBlock extends BlockContainer {
	protected Random rand = new Random();

	static boolean isActiveSound;
	
	public GemChargerBlock(String GemCharger) {
		super(Material.rock);
		setBlockName(Ref.MODID + "_" + GemCharger);
		setCreativeTab(DefineCraftMod.DefineCraft);
		setHardness(2.0F);
		setResistance(2.0F);

	}

	/* Logic backend */
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new GemChargerLogic();
	}

	public Integer getGui(World world, int x, int y, int z,
			EntityPlayer entityplayer) {
		return GuiHandler.GemCharger;
	}

	public Object getModInstance() {
		return DefineCraftMod.instance;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float clickX, float clickY,
			float clickZ) {
		if (player.isSneaking())
			return false;

		Integer integer = getGui(world, x, y, z, player);
		if (integer == null || integer == -1) {
			return false;
		} else {
			if (!world.isRemote)
				player.openGui(getModInstance(), integer, world, x, y, z);
			return true;
		}
	}

	/* Inventory */

	@Override
	public void breakBlock(World par1World, int x, int y, int z, Block blockID,
			int meta) {
		TileEntity te = par1World.getTileEntity(x, y, z);

		if (te != null && te instanceof GemChargerLogic) {
			GemChargerLogic logic = (GemChargerLogic) te;
			for (int iter = 0; iter < logic.getSizeInventory(); ++iter) {
				ItemStack stack = logic.getStackInSlot(iter);

				if (stack != null) {
					float jumpX = rand.nextFloat() * 0.8F + 0.1F;
					float jumpY = rand.nextFloat() * 0.8F + 0.1F;
					float jumpZ = rand.nextFloat() * 0.8F + 0.1F;

					while (stack.stackSize > 0) {
						int itemSize = rand.nextInt(21) + 10;

						if (itemSize > stack.stackSize) {
							itemSize = stack.stackSize;
						}

						stack.stackSize -= itemSize;
						EntityItem entityitem = new EntityItem(par1World, x
								+ jumpX, y + jumpY, z + jumpZ, new ItemStack(
								stack.getItem(), itemSize,
								stack.getItemDamage()));

						if (stack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound(
									(NBTTagCompound) stack.getTagCompound()
											.copy());
						}

						float offset = 0.05F;
						entityitem.motionX = (float) rand.nextGaussian()
								* offset;
						entityitem.motionY = (float) rand.nextGaussian()
								* offset + 0.2F;
						entityitem.motionZ = (float) rand.nextGaussian()
								* offset;
						par1World.spawnEntityInWorld(entityitem);
					}
				}
			}
		}

		super.breakBlock(par1World, x, y, z, blockID, meta);
	}

	/* Placement */

	int side = -1;

	// This class does not have an actual block placed in the world
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ, int meta) {
		this.side = side;
		return meta;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase entityliving, ItemStack stack) {
		TileEntity logic = world.getTileEntity(x, y, z);
		if (logic instanceof GemChargerLogic) {
			GemChargerLogic direction = (GemChargerLogic) logic;
			if (entityliving == null) {
				direction.setDirection(0F, 0F, null);
			} else {
				direction.setDirection(entityliving.rotationYaw * 4F,
						entityliving.rotationPitch, entityliving);
			}
		}

		if (logic instanceof GemChargerLogic) {
			GemChargerLogic inv = (GemChargerLogic) logic;
			if (stack.hasDisplayName()) {
				inv.setGuiDisplayName(stack.getDisplayName());
			}
		}
	}

	public static boolean isActive(IBlockAccess world, int x, int y, int z) {
		TileEntity logic = world.getTileEntity(x, y, z);
		if (logic instanceof GemChargerLogic) {
				return ((GemChargerLogic) logic).getActive();
		}
		return false;
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	/* Light */
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof GemChargerLogic) {
			return ((GemChargerLogic) te).getActive() ? 15 : 0;
		}
		return this.getLightValue();
	}

	/* Comparator */
	@Override
	public boolean hasComparatorInputOverride() {
		return true;
	}

	@Override
	public int getComparatorInputOverride(World par1World, int par2, int par3,
			int par4, int par5) {
		return Container.calcRedstoneFromInventory((IInventory) par1World
				.getTileEntity(par2, par3, par4));
	}

	@Override
	@SideOnly(Side.CLIENT)
	   public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
		GemChargerLogic logic = (GemChargerLogic) par1World.getTileEntity(par2, par3, par4);
	if (logic.getActive())
        {
            super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
            int l1 = par1World.getBlockMetadata(par2, par3, par4);
            float f = (float)par2 + 0.5F;
            float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)par4 + 0.5F;
            float f3 = 0.52F;
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

            if (l1 == 4)
            {
                par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l1 == 5)
            {
                par1World.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l1 == 2)
            {
                par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (l1 == 3)
            {
                par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }

	/* Textures */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icons[(meta % 8) * 3 + getTextureIndex(side)];
	}

	@SideOnly(Side.CLIENT)
	public int getTextureIndex(int side) {
		if (side == 0 || side == 1)
			return 3;
		if (side == 3)
			return 0;

		return 2;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		TileEntity logic = world.getTileEntity(x, y, z);
		int direction = (logic instanceof GemChargerLogic) ? ((GemChargerLogic) logic)
				.getRenderDirection() : 0;
		int meta = world.getBlockMetadata(x, y, z) % 8;

		if (meta == 0) {
			if (side == direction) {
				if (((GemChargerLogic) logic).getActive())
					return icons[1];
				else
					return icons[0];
			} else if (side > 1) {
				return icons[2];
			}
			return icons[3];
		}
		return icons[0];
	}

	@SideOnly(Side.CLIENT)
	public IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public String[] getTextureNames() {
		String[] textureNames = { "GemChargerFrunt", "GemChargerLit",
				"GemCharger", "GemCharger" };

		return textureNames;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		String[] textureNames = getTextureNames();
		this.icons = new IIcon[textureNames.length];

		for (int i = 0; i < this.icons.length; ++i) {
			this.icons[i] = iconRegister.registerIcon(Ref.MODID + ":"
					+ textureNames[i]);
		}
	}
}
