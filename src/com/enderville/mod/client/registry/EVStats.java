package com.enderville.mod.client.registry;

import com.enderville.mod.common.registry.EVItems;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * EVAchievements.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class EVStats {

	/* Achievements */
	public static Achievement moneyTree;
	public static Achievement moneyDiamond;
	/* Achievement Pages */
	public static AchievementPage enderPage;

	
	public static void init(){
//		moneyTree = (new Achievement(4000, "moneyTree", 0, 0, EVBlocks.moneySapling,null)).registerAchievement().setIndependent().setSpecial();
		moneyDiamond = (new Achievement(4001, "moneyDiamond", 2, 2, new ItemStack(EVItems.enderCoin, 1, 3),null)).registerAchievement().setIndependent().setSpecial();
		
		enderPage = new AchievementPage("EnderVille", moneyTree, moneyDiamond);
	}
	
	public static void addNames(){
		LanguageRegistry.instance().addStringLocalization("achievement.moneyTree", "en_US", "Money Sapling");
		LanguageRegistry.instance().addStringLocalization("achievement.moneyTree.desc", "en_US", "Who ever said money dosn't grow on trees!");

		LanguageRegistry.instance().addStringLocalization("achievement.moneyDiamond", "en_US", "Diamond Coin");
		LanguageRegistry.instance().addStringLocalization("achievement.moneyDiamond.desc", "en_US", "Who ever said money dosn't grow on trees!");
	}
	
	public static void regPages(){
		AchievementPage.registerAchievementPage(enderPage);
	}
}
