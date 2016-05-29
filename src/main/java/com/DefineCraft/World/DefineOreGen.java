package com.DefineCraft.World;

import java.util.Random;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.DefineCraftModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class DefineOreGen implements IWorldGenerator
{
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
                generateNeather(world, rand, chunkX * 16, chunkZ * 16);
                break;
            case 0:
                generateOverWorld(world, rand, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                generateEnd(world, rand, chunkX * 16, chunkZ * 16);
                break;
            
        }
    }

    private void generateEnd(World world, Random rand, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void generateOverWorld(World world, Random rand, int i, int j)
    {
		//your-block,metadata-of-block,Block-spawns-on,World,Ran,i=XPos,j=ZPos,maxX,maxZ,maxVeinSize,chancesToSpawn,minY,maxY)
		addOreSpawn(DefineCraftModBlocks.SilverOre, 0, Blocks.stone, world, rand, i, j, 16, 16, 7 + rand.nextInt(5), 5, 20, 38);
		addOreSpawn(DefineCraftModBlocks.TerbiumOre, 0, Blocks.stone, world, rand, i, j, 16, 16, 7 + rand.nextInt(5), 5, 10, 28);
		addOreSpawn(DefineCraftModBlocks.PeridotOre, 0, Blocks.stone, world, rand, i, j, 16, 16, 5+ rand.nextInt(5), 5, 10, 18);
		addOreSpawn(DefineCraftModBlocks.GemOre, 0, Blocks.stone, world, rand, i, j, 16, 16, 5, 5+ rand.nextInt(5), 10, 18);

       /* for (int y = 0; y < 38; y++)
        {
		   // int Xcoord = i + rand.nextInt(16);
           // int Zcoord = j + rand.nextInt(16);
           // int Ycoord = 20 + rand.nextInt(35);
           // (new WorldGenMinable(DefineCraftMod.SilverOre, 5)).generate(world, rand, Xcoord, Ycoord, Zcoord);
        }
        for (int y = 0; y < 25; y++)
        {
           // int Xcoord = i + rand.nextInt(16);
            //int Zcoord = j + rand.nextInt(16);
            //int Ycoord = 10 + rand.nextInt(16);
           // (new WorldGenMinable(DefineCraftMod.PeridotOre, 4)).generate(world, rand, Xcoord, Ycoord, Zcoord);
        }
        for (int y = 0; y < 10; y++)
        {
           // int Xcoord = i + rand.nextInt(16);
           // int Zcoord = j + rand.nextInt(16);
           // int Ycoord = 5 + rand.nextInt(16);
           // (new WorldGenMinable(DefineCraftMod.GemOre, 3)).generate(world, rand, Xcoord, Ycoord, Zcoord);
        }
        for (int y = 0; y < 25; y++)
        {
           // int Xcoord = i + rand.nextInt(16);
           // int Zcoord = j + rand.nextInt(16);
           // int Ycoord = 15 + rand.nextInt(16);
           // (new WorldGenMinable(DefineCraftMod.TerbiumOre, 4)).generate(world, rand, Xcoord, Ycoord, Zcoord);
        }*/
    }

    private void generateNeather(World world, Random rand, int i, int j)
    {
    	addOreSpawn(DefineCraftModBlocks.HellStoneOre, 0, Blocks.netherrack, world, rand, i, j, 16, 16, 5 + rand.nextInt(5), 5, 20, 146);

       /* for (int y = 0; y < 80; y++)
        {
            int Xcoord1 = i + rand.nextInt(16);
            int Zcoord1 = j + rand.nextInt(16);
            int Ycoord1 = 8 + rand.nextInt(16);
            (new NeatherMinable(DefineCraftMod.HellStoneOre, 5)).generate(world, rand, Xcoord1, Ycoord1, Zcoord1);
        }*/
    }
    public void addOreSpawn(Block block, int metadata, Block target, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {
          int maxPossY = minY + (maxY - 1);
          assert maxY > minY: "The maximum Y must be greater than the Minimum Y";
          assert maxX > 0 && maxX <= 16: "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
          assert minY > 0: "addOreSpawn: The Minimum Y must be greater than 0";
          assert maxY < 256 && maxY > 0: "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
          assert maxZ > 0 && maxZ <= 16: "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
         
          int diffBtwnMinMaxY = maxY - minY;
          for(int x = 0; x < chancesToSpawn; x++)
          {
                 int posX = blockXPos + random.nextInt(maxX);
                 int posY = minY + random.nextInt(diffBtwnMinMaxY);
                 int posZ = blockZPos + random.nextInt(maxZ);
                 (new WorldGenMinable(block, metadata, maxVeinSize, target)).generate(world, random, posX, posY, posZ);
          }
    }


}