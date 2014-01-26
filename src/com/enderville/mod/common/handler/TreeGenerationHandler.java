package com.enderville.mod.common.handler;


/**
 * TreeGenerationHandler.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

//public class TreeGenerationHandler implements IWorldGenerator{
//
//	@Override
//	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
//		
//		if(world.provider.dimensionId != -1  && world.provider.dimensionId != 1){
//			generateSurface(world, random, chunkX*16, chunkZ*16);
//		}
//		
//	}
//
//	private void generateSurface(World world, Random random, int posX, int posZ) {
//		for(int t = 0; t < 1; t++){
//			int ChunkX = posX + random.nextInt(16);
//			int ChunkY = random.nextInt(90);
//		    int ChunkZ = posZ + random.nextInt(16);
//			
//		    (new WorldGenEnderTrees(false, 8, 0, 0, false)).generate(world, random, ChunkX, ChunkY, ChunkZ);
//		    
//		}
//	    
//		
//	}
//}
