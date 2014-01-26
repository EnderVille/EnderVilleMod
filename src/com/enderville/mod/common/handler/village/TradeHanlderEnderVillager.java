package com.enderville.mod.common.handler.village;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

/**
 * TradeHanlderEnderVillager.java
 * 
 * EnderVille
 * 
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class TradeHanlderEnderVillager implements IVillageTradeHandler {

	public void manipulateTradesForVillager(EntityVillager villager,
			MerchantRecipeList recipes, Random random) {

		/* 4 Iron Ingot => 1 Iron Ender Coin */
//		recipes.add(new MerchantRecipe(new ItemStack(Item.ingotIron, 4),
//				new ItemStack(EVItems.enderCoin, 1, 0)));
	}

}
