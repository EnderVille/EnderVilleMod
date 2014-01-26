package com.enderville.mod.common.registry;

import com.enderville.mod.common.item.ItemEnderCoin;
import com.enderville.mod.common.lib.ItemInfo;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * EVItems.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class EVItems {
	
	public static Item enderCoin;

	public static void init() {
		enderCoin = new ItemEnderCoin(ItemInfo.ENDERCOIN_ID);
		GameRegistry.registerItem(enderCoin, ItemInfo.ENDERCOIN_NAME_UNLOC);
	}

	public static void addNames() {
		for(int meta = 0; meta < ItemInfo.ENDERCOIN_NAMES.length; meta ++){
			LanguageRegistry.addName(new ItemStack(enderCoin, 1, meta), ItemInfo.ENDERCOIN_NAMES[meta]);
		}
	}

	public static void addRecipes() {
		ItemStack ironCoin = new ItemStack(EVItems.enderCoin,1,0);
		ItemStack goldCoin = new ItemStack(EVItems.enderCoin,1,1);
		ItemStack diamondCoin = new ItemStack(EVItems.enderCoin,1,2);
		ItemStack emeraldCoin = new ItemStack(EVItems.enderCoin,1,3);
		
		GameRegistry.addShapelessRecipe(new ItemStack(EVItems.enderCoin, 1, 1),
				ironCoin, ironCoin, ironCoin,
				ironCoin, ironCoin, ironCoin,
				ironCoin, ironCoin, Item.ingotGold);
		
		GameRegistry.addShapelessRecipe(new ItemStack(EVItems.enderCoin, 1, 2),
				goldCoin, goldCoin, goldCoin,
				goldCoin, goldCoin, goldCoin,
				goldCoin, goldCoin, Item.diamond);
		
		GameRegistry.addShapelessRecipe(new ItemStack(EVItems.enderCoin, 1, 3),
				diamondCoin, diamondCoin, diamondCoin,
				diamondCoin, diamondCoin, diamondCoin,
				diamondCoin, diamondCoin, Item.emerald);
		
		/* Back Convert */
		GameRegistry.addShapelessRecipe(new ItemStack(EVItems.enderCoin, 8, 0),
				goldCoin);
		
		GameRegistry.addShapelessRecipe(new ItemStack(EVItems.enderCoin, 8, 1),
				diamondCoin);
		
		GameRegistry.addShapelessRecipe(new ItemStack(EVItems.enderCoin, 8, 2),
				emeraldCoin);
	}

}
