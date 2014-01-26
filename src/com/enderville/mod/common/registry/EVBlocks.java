package com.enderville.mod.common.registry;

import com.enderville.mod.common.block.BlockEnderCoinBank;
import com.enderville.mod.common.block.BlockEnderCoinOre;
import com.enderville.mod.common.entity.tile.TileEntityEnderCoinBank;
import com.enderville.mod.common.itemblock.ItemBlockEnderCoinOre;
import com.enderville.mod.common.lib.BlockInfo;
import com.enderville.mod.common.lib.ItemInfo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * EVBlocks.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class EVBlocks {

	/* Block Declaration */
	public static Block enderCoinOre;
	
	public static Block enderCoinBank;
	
	
	/* Money Tree */
//	public static Block moneyLog;
//	public static Block moneyLeaf;
//	public static Block moneySapling;
	
	public static void init(){
		/* EnderCoin Ore */
		enderCoinOre = new BlockEnderCoinOre(BlockInfo.ENDERCOIN_ORE_ID, Material.rock);
		GameRegistry.registerBlock(enderCoinOre, ItemBlockEnderCoinOre.class , BlockInfo.ENDERCOIN_ORE_NAME_UNLOC);
		
		/* EnderCoin Bank */
		enderCoinBank = new BlockEnderCoinBank(BlockInfo.ENDERCOIN_BANK_ID, Material.iron);
		GameRegistry.registerBlock(enderCoinBank, ItemBlock.class ,BlockInfo.ENDERCOIN_BANK_NAME_UNLOC);
		
//		/* Money Log */
//		moneyLog = new BlockMoneyLog(BlockInfo.MONEY_LOG_ID, Material.wood);
//		GameRegistry.registerBlock(moneyLog, BlockInfo.MONEY_LOG_NAME_UNLOC);
//		
//		/* Money Leaf */
//		moneyLeaf = new BlockMoneyLeaf(BlockInfo.MONEY_LEAF_ID, Material.leaves);
//		GameRegistry.registerBlock(moneyLeaf, BlockInfo.MONEY_LEAF_NAME_UNLOC);
//		
//		/* Money Sapling */
//		moneySapling = new BlockMoneySapling(BlockInfo.MONEY_SAPLING_ID, Material.plants);
//		GameRegistry.registerBlock(moneySapling, BlockInfo.MONEY_SAPLING_NAME_UNLOC);
	}
	
	public static void addNames(){
		/* EnderCoin Ore */
		for(int i =  0; i < BlockInfo.ENDERCOIN_ORE_NAMES.length; i ++){
			LanguageRegistry.addName(new ItemStack(enderCoinOre, 1, i), BlockInfo.ENDERCOIN_ORE_NAMES[i]);
		}
		
		/* EnderCoin Bank */
		LanguageRegistry.addName(enderCoinBank, BlockInfo.ENDERCOIN_BANK_NAME);
		
		/* Money Log */
//		LanguageRegistry.addName(moneyLog, BlockInfo.MONEY_LOG_NAME);
//		
//		/* Money Leaf */
//		LanguageRegistry.addName(moneyLeaf, BlockInfo.MONEY_LEAF_NAME);
//		
//		/* Money Sapling */
//		LanguageRegistry.addName(moneySapling, BlockInfo.MONEY_SAPLING_NAME);
	}
	
	public static void regTileEnttities(){
		GameRegistry.registerTileEntity(TileEntityEnderCoinBank.class, BlockInfo.ENDERCOIN_BANK_KEY);
	}
	
	public static void addRecipes(){
		/* Ender Coin Ore => EnderCoins */
		for(int meta = 0; meta < ItemInfo.ENDERCOIN_NAMES.length; meta ++){
			FurnaceRecipes.smelting().addSmelting(enderCoinOre.blockID, meta, new ItemStack(EVItems.enderCoin, 1, meta) ,1.0F);
		}
	}
}
