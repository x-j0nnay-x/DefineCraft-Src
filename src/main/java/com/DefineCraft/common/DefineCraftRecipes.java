package com.DefineCraft.common;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class DefineCraftRecipes
{
    public static void init()
    {
//Crafting Items
      		GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.LogicChip, 2), new Object[] {"323","313", '1', DefineCraftModItems.Peridot, '2', Items.redstone, '3', Blocks.stone_button});
      		GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.GrinderHead, 4), new Object[]{" 11"," 1 ","  2", '1', Items.stick, '2', DefineCraftModItems.SilverBar});
            GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.RefinedWoodenDoor, 1), new Object[] {"01", '0', DefineCraftModItems.Peridot, '1', Items.wooden_door});

      	//Silver
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.SilverSword, 1), new Object[] {" 1 ", " 1 ", " 7 ", '1', DefineCraftModItems.SilverBar, '7', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.SilverHoe, 1), new Object[] {"00 ", " 4 ", " 4 ", '0', DefineCraftModItems.SilverBar, '4', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.SilverHoe, 1), new Object[] {" 00", " 4 ", " 4 ", '0', DefineCraftModItems.SilverBar, '4', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.SilverPickAxe, 1), new Object[] {"000", " 4 ", " 4 ", '0', DefineCraftModItems.SilverBar, '4', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.SilverAxe, 1), new Object[] {"11 ", "14 ", " 4 ", '1', DefineCraftModItems.SilverBar, '4', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.SilverAxe, 1), new Object[] {" 11", " 41", " 4 ", '1', DefineCraftModItems.SilverBar, '4', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.SilverSpade, 1), new Object[] {" 1 ", " 4 ", " 4 ", '1', DefineCraftModItems.SilverBar, '4', Items.stick});
          //Terbium
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.TerbiumSword, 1), new Object[] {" 1 ", " 1 ", " 7 ", '1', DefineCraftModItems.TerbiumBar, '7', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.TerbiumHoe, 1), new Object[] {"00 ", " 4 ", " 4 ", '0', DefineCraftModItems.TerbiumBar, '4', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.TerbiumHoe, 1), new Object[] {" 00", " 4 ", " 4 ", '0', DefineCraftModItems.TerbiumBar, '4', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.TerbiumPickAxe, 1), new Object[] {"000", " 4 ", " 4 ", '0', DefineCraftModItems.TerbiumBar, '4', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.TerbiumAxe, 1), new Object[] {"11 ", "14 ", " 4 ", '1', DefineCraftModItems.TerbiumBar, '4', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.TerbiumAxe, 1), new Object[] {" 11", " 41", " 4 ", '1', DefineCraftModItems.TerbiumBar, '4', Items.stick});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.TerbiumSpade, 1), new Object[] {" 1 ", " 4 ", " 4 ", '1', DefineCraftModItems.TerbiumBar, '4', Items.stick});
          //HellStone
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.HellStoneSword, 1), new Object[] {" 1 ", " 1 ", " 7 ", '1', DefineCraftModItems.HellStoneBar, '7', DefineCraftModItems.ObsidianBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.HellStoneHoe, 1), new Object[] {"00 ", " 4 ", " 4 ", '0', DefineCraftModItems.HellStoneBar, '4', DefineCraftModItems.ObsidianBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.HellStoneHoe, 1), new Object[] {" 00", " 4 ", " 4 ", '0', DefineCraftModItems.HellStoneBar, '4', DefineCraftModItems.ObsidianBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.HellStonePickAxe, 1), new Object[] {"000", " 4 ", " 4 ", '0', DefineCraftModItems.HellStoneBar, '4', DefineCraftModItems.ObsidianBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.HellStoneAxe, 1), new Object[] {"11 ", "14 ", " 4 ", '1', DefineCraftModItems.HellStoneBar, '4', DefineCraftModItems.ObsidianBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.HellStoneAxe, 1), new Object[] {" 11", " 41", " 4 ", '1', DefineCraftModItems.HellStoneBar, '4', DefineCraftModItems.ObsidianBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.HellStoneSpade, 1), new Object[] {" 1 ", " 4 ", " 4 ", '1', DefineCraftModItems.HellStoneBar, '4', DefineCraftModItems.ObsidianBar});
           //Obsidian
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.ObsidianSword, 1), new Object[] {" 1 ", " 1 ", " 7 ", '1', DefineCraftModItems.ObsidianBar, '7', Items.blaze_rod});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.ObsidianHoe, 1), new Object[] {"00 ", " 4 ", " 4 ", '0', DefineCraftModItems.ObsidianBar, '4', Items.blaze_rod});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.ObsidianHoe, 1), new Object[] {" 00", " 4 ", " 4 ", '0', DefineCraftModItems.ObsidianBar, '4', Items.blaze_rod});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.ObsidianPickAxe, 1), new Object[] {"000", " 4 ", " 4 ", '0', DefineCraftModItems.ObsidianBar, '4', Items.blaze_rod});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.ObsidianAxe, 1), new Object[] {"11 ", "14 ", " 4 ", '1', DefineCraftModItems.ObsidianBar, '4', Items.blaze_rod});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.ObsidianAxe, 1), new Object[] {" 11", " 41", " 4 ", '1', DefineCraftModItems.ObsidianBar, '4', Items.blaze_rod});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.ObsidianSpade, 1), new Object[] {" 1 ", " 4 ", " 4 ", '1', DefineCraftModItems.ObsidianBar, '4', Items.blaze_rod});
//Crafting Blocks
              GameRegistry.addRecipe(new ItemStack(DefineCraftModBlocks.Grinder, 1), new Object[] {"xxx", "zyz", "xzx", 'x', Blocks.stone, 'z',Blocks.cobblestone, 'y', Blocks.furnace});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModBlocks.BarMaker, 1), new Object[] {"121", "232", "121", '1', DefineCraftModItems.SilverBar, '2', Blocks.cobblestone, '3', DefineCraftModBlocks.SmartFurnace});
              GameRegistry.addShapelessRecipe(new ItemStack(DefineCraftModBlocks.SmartFurnace, 1), new Object[] {DefineCraftModItems.LogicChip, Blocks.furnace});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModBlocks.Infuser, 1), new Object[] {"141", "232", "212", '1', DefineCraftModItems.HellStoneBar, '2', Blocks.piston, '3', DefineCraftModBlocks.BarMaker, '4', DefineCraftModItems.LogicChip});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModBlocks.GemCharger, 1), new Object[] {"222", "232", "212",  '1', Items.lava_bucket, '2', Blocks.obsidian, '3', DefineCraftModBlocks.SmartFurnace});
//Crafting Armor
           //HellStone
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.HellStoneHelmet, 1), new Object[] {"XXX", "X X", 'X', DefineCraftModItems.HellStoneBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.HellStoneChest, 1), new Object[] {"X X", "XXX", "XXX", 'X', DefineCraftModItems.HellStoneBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.HellStoneLegs, 1), new Object[] {"XXX", "X X", "X X", 'X', DefineCraftModItems.HellStoneBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.HellStoneBoots, 1), new Object[] {"X X", "X X", 'X', DefineCraftModItems.HellStoneBar});
           //Obsidian
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.ObsidianHelmet, 1), new Object[] {"XXX", "X X", 'X', DefineCraftModItems.ObsidianBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.ObsidianChest, 1), new Object[] {"X X", "XXX", "XXX", 'X', DefineCraftModItems.ObsidianBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.ObsidianLegs, 1), new Object[] {"XXX", "X X", "X X", 'X', DefineCraftModItems.ObsidianBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.ObsidianBoots, 1), new Object[] {"X X", "X X", 'X', DefineCraftModItems.ObsidianBar});
           //Turbium
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.TerbiumHelmet, 1), new Object[] {"XXX", "X X", 'X', DefineCraftModItems.TerbiumBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.TerbiumChest, 1), new Object[] {"X X", "XXX", "XXX", 'X', DefineCraftModItems.TerbiumBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.TerbiumLegs, 1), new Object[] {"XXX", "X X", "X X", 'X', DefineCraftModItems.TerbiumBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.TerbiumBoots, 1), new Object[] {"X X", "X X", 'X', DefineCraftModItems.TerbiumBar});
           //Silver
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.SilverHelmet, 1), new Object[] {"XXX", "X X", 'X', DefineCraftModItems.SilverBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.SilverChest, 1), new Object[] {"X X", "XXX", "XXX", 'X', DefineCraftModItems.SilverBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.SilverLegs, 1), new Object[] {"XXX", "X X", "X X", 'X', DefineCraftModItems.SilverBar});
              GameRegistry.addRecipe(new ItemStack(DefineCraftModItems.SilverBoots, 1), new Object[] {"X X", "X X", 'X', DefineCraftModItems.SilverBar});
//Smelting
              GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather), 0.1F);
              GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(DefineCraftModItems.ObsidianBar), 1.1F);
              GameRegistry.addSmelting(DefineCraftModBlocks.SilverOre, new ItemStack(DefineCraftModItems.SilverBar), 1.6F);
              GameRegistry.addSmelting(DefineCraftModBlocks.TerbiumOre, new ItemStack(DefineCraftModItems.TerbiumBar), 1.9F);
              GameRegistry.addSmelting(DefineCraftModBlocks.HellStoneOre, new ItemStack(DefineCraftModItems.HellStoneBar), 2.1F);
              GameRegistry.addSmelting(DefineCraftModBlocks.GemOre, new ItemStack (DefineCraftModItems.EmptyGem), 5.8F);
              GameRegistry.addSmelting(DefineCraftModBlocks.PeridotOre, new ItemStack(DefineCraftModItems.Peridot), 5.2F);
              GameRegistry.addSmelting(DefineCraftModItems.SilverDust, new ItemStack(DefineCraftModItems.SilverBar), 1.6F);
              GameRegistry.addSmelting(DefineCraftModItems.TerbiumDust, new ItemStack(DefineCraftModItems.TerbiumBar), 1.9F);
              GameRegistry.addSmelting(DefineCraftModItems.HellStoneDust, new ItemStack(DefineCraftModItems.HellStoneBar), 2.1F);
              GameRegistry.addSmelting(DefineCraftModItems.ObsidianDust, new ItemStack (DefineCraftModItems.ObsidianBar), 5.8f);
              GameRegistry.addSmelting(DefineCraftModItems.IronDust, new ItemStack(Items.iron_ingot), 1.6F);
              GameRegistry.addSmelting(DefineCraftModItems.GoldDust, new ItemStack(Items.gold_ingot), 1.9F);
              GameRegistry.addSmelting(DefineCraftModItems.DiamondDust, new ItemStack(Items.diamond), 2.1F);

    }
}