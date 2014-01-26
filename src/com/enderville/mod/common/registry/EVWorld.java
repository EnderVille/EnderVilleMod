package com.enderville.mod.common.registry;

import com.enderville.mod.common.handler.OreGenerationHandler;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * EVWorld.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class EVWorld {

	public static OreGenerationHandler oreGen = new OreGenerationHandler();
//	public static TreeGenerationHandler treeGen = new TreeGenerationHandler();
	
	public static void initGen(){
		GameRegistry.registerWorldGenerator(oreGen);
//		GameRegistry.registerWorldGenerator(treeGen);
	}
	
	public static void moneyTreeBonemeal(){
//		MinecraftForge.EVENT_BUS.register(new EventMoneySaplingBonemeal());
	}
	
}
