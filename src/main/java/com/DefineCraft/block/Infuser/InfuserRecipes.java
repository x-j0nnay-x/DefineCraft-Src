package com.DefineCraft.block.Infuser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import com.DefineCraft.common.DefineCraftMod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfuserRecipes
{
    private static final InfuserRecipes smeltingBase = new InfuserRecipes();

    /** The list of smelting results. */
    private Map GrindingList = new HashMap();
    private Map GrinderexperienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaGrindingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addGrinding and getSmeltingResult.
     */
    public static final InfuserRecipes Grinding()
    {
        return new InfuserRecipes();
    }

    public InfuserRecipes()
    {
        //Grinder recipe adding
        //this.addGrinding(Main.DOre.getIdFromBlock(Main.DOre), new ItemStack(Main.DGem, 3), 1.0F);
    	this.addGrinding(Items.diamond.getIdFromItem(Items.diamond) , new ItemStack(Block.getBlockById(Blocks.diamond_ore.getIdFromBlock(Blocks.diamond_ore)), 1), 1.0F);
    	this.addGrinding(Items.iron_ingot.getIdFromItem(Items.iron_ingot) , new ItemStack(Block.getBlockById(Blocks.iron_ore.getIdFromBlock(Blocks.iron_ore)), 1), 1.0F);
    	this.addGrinding(Items.gold_ingot.getIdFromItem(Items.gold_ingot) , new ItemStack(Block.getBlockById(Blocks.gold_ore.getIdFromBlock(Blocks.gold_ore)), 1), 1.0F);
    	

        
    }

    /**
     * Adds a smelting recipe.
     */
    public void addGrinding(int par1, ItemStack par2ItemStack, float par3)
    {
        this.GrindingList.put(Integer.valueOf(par1), par2ItemStack);
        this.GrinderexperienceList.put(Integer.valueOf(par2ItemStack.getItem().getIdFromItem(par2ItemStack.getItem())), par3);
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public ItemStack getGrindingResult(int par1)
    {
        return (ItemStack)this.GrindingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList()
    {
        return this.GrindingList;
    }

    @Deprecated //In favor of ItemStack sensitive version
    public float getExperience(int par1)
    {
        return this.GrinderexperienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.GrinderexperienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }

    /**
     * A metadata sensitive version of adding a furnace recipe.
     */
    public void addGrinding(int itemID, int metadata, ItemStack itemstack, float experience)
    {
        metaGrindingList.put(Arrays.asList(itemID, metadata), itemstack);
        metaExperience.put(Arrays.asList(itemstack.getItem().getIdFromItem(itemstack.getItem()), itemstack.getItemDamage()), experience);
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getGrindingResult(ItemStack item)
    {
        if (item == null)
        {
            return null;
        }

        ItemStack ret = (ItemStack)metaGrindingList.get(Arrays.asList(item, item.getItemDamage()));

        if (ret != null)
        {
            return ret;
        }

        return (ItemStack)GrindingList.get(Integer.valueOf(item.getItem().getIdFromItem(item.getItem())));
    }

    /**
     * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
     */
    public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }

        float ret = item.getItem().getSmeltingExperience(item);

        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item, item.getItemDamage())))
        {
            ret = metaExperience.get(Arrays.asList(item, item.getItemDamage()));
        }

        if (ret < 0 && GrinderexperienceList.containsKey(item))
        {
            ret = ((Float)GrinderexperienceList.get(item)).floatValue();
        }

        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaSmeltingList()
    {
        return metaGrindingList;
    }
}
