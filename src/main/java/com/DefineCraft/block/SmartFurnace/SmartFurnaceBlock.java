package com.DefineCraft.block.SmartFurnace;

import java.util.Random;

import com.DefineCraft.common.*;

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


public class SmartFurnaceBlock extends BlockContainer {
	protected Random rand = new Random();

	static boolean isActiveSound;
	
	public SmartFurnaceBlock(String SmartFurnace) {
		super(Material.rock);
		setBlockName(Ref.MODID + "_" + SmartFurnace);
		setCreativeTab(DefineCraftMod.DefineCraft);
		setHardness(2.0F);
		setResistance(2.0F);

	}

	/* Logic backend */
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new SmartFurnaceLogic();
	}

	public Integer getGui(World world, int x, int y, int z,
			EntityPlayer entityplayer) {
		return GuiHandler.SmartFurnace;
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

		if (te != null && te instanceof SmartFurnaceLogic) {
			SmartFurnaceLogic logic = (SmartFurnaceLogic) te;
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
		if (logic instanceof SmartFurnaceLogic) {
			SmartFurnaceLogic direction = (SmartFurnaceLogic) logic;
			if (entityliving == null) {
				direction.setDirection(0F, 0F, null);
			} else {
				direction.setDirection(entityliving.rotationYaw * 4F,
						entityliving.rotationPitch, entityliving);
			}
		}

		if (logic instanceof SmartFurnaceLogic) {
			SmartFurnaceLogic inv = (SmartFurnaceLogic) logic;
			if (stack.hasDisplayName()) {
				inv.setGuiDisplayName(stack.getDisplayName());
			}
		}
	}

	public static boolean isActive(IBlockAccess world, int x, int y, int z) {
		TileEntity logic = world.getTileEntity(x, y, z);
		if (logic instanceof SmartFurnaceLogic) {
				return ((SmartFurnaceLogic) logic).getActive();
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
		if (te instanceof SmartFurnaceLogic) {
			return ((SmartFurnaceLogic) te).getActive() ? 15 : 0;
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
	public void randomDisplayTick(World world, int x, int y, int z,
			Random par5Random) {
		SmartFurnaceLogic logic = (SmartFurnaceLogic) world.getTileEntity(x, y, z);
		if (logic.getActive()) {
			int direction = logic.getRenderDirection();
			float f = x + 0.5F;
			float f1 = y + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
			float f2 = z + 0.5F;
			float f3 = 0.52F;
			float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

			if (direction == 4) {
				world.spawnParticle("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D,
						0.0D);
				world.spawnParticle("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D,
						0.0D);
			} else if (direction == 5) {
				world.spawnParticle("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D,
						0.0D);
				world.spawnParticle("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D,
						0.0D);
			} else if (direction == 2) {
				world.spawnParticle("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D,
						0.0D);
				world.spawnParticle("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D,
						0.0D);
			} else if (direction == 3) {
				world.spawnParticle("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D,
						0.0D);
				world.spawnParticle("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D,
						0.0D);
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
		int direction = (logic instanceof SmartFurnaceLogic) ? ((SmartFurnaceLogic) logic)
				.getRenderDirection() : 0;
		int meta = world.getBlockMetadata(x, y, z) % 8;

		if (meta == 0) {
			if (side == direction) {
				if (((SmartFurnaceLogic) logic).getActive())
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
		String[] textureNames = { "Smartfurnace_front_off", "Smartfurnace_front_on",
				"Smartfurnace_side", "Smartfurnace_top" };

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
