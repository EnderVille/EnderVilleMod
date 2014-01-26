package com.enderville.mod.common.handler;

import java.util.Random;

import com.enderville.mod.common.registry.EVBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * OreGenerationHandler.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class OreGenerationHandler implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		if(world.provider.dimensionId != -1 && world.provider.dimensionId != 1){
			generateSurface(world, random, chunkX*16, chunkZ*16);
		}
		
	}

	private void generateSurface(World world, Random random, int posX, int posZ) {
		int Xcoord = posX + random.nextInt(16);
	    int Zcoord = posZ + random.nextInt(16);
	    
	    int ironYcoord = 5 + random.nextInt(63);
	    int goldYcoord = 2 + random.nextInt(32);
	    int diamondYcoord = 2 + random.nextInt(13);
	    int emeraldYcoord = 4 + random.nextInt(28);
	    
	    int ironVeinSize = 4 + random.nextInt(6);
	    int goldVeinSize = 4 + random.nextInt(4);
	    int diamondVeinSize = 1 + random.nextInt(8);
	    int emeraldVeinSize = 1;
	    
	    (new WorldGenMinable(EVBlocks.enderCoinOre.blockID,0, ironVeinSize, Block.stone.blockID)).generate(world, random, Xcoord, ironYcoord, Zcoord);
	    (new WorldGenMinable(EVBlocks.enderCoinOre.blockID,1, goldVeinSize, Block.stone.blockID)).generate(world, random, Xcoord, goldYcoord, Zcoord);
	    (new WorldGenMinable(EVBlocks.enderCoinOre.blockID,2, diamondVeinSize, Block.stone.blockID)).generate(world, random, Xcoord, diamondYcoord, Zcoord);
	    (new WorldGenMinable(EVBlocks.enderCoinOre.blockID,3, emeraldVeinSize, Block.stone.blockID)).generate(world, random, Xcoord, emeraldYcoord, Zcoord);
		
	}
	
	 /**
     * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
     *
     * @param The Block to spawn
     * @param The World to spawn in
     * @param A Random object for retrieving random positions within the world to spawn the Block
     * @param An int for passing the X-Coordinate for the Generation method
     * @param An int for passing the Z-Coordinate for the Generation method
     * @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
     * @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
     * @param An int for setting the maximum size of a vein
     * @param An int for the Number of chances available for the Block to spawn per-chunk
     * @param An int for the minimum Y-Coordinate height at which this block may spawn
     * @param An int for the maximum Y-Coordinate height at which this block may spawn
     **/
    public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {
          @SuppressWarnings("unused")
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
                 (new WorldGenMinable(block.blockID, maxVeinSize)).generate(world, random, posX, posY, posZ);
          }
    }

}
