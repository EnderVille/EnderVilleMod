package com.enderville.mod.client.handler;

import java.io.File;
import java.util.logging.Level;

import com.enderville.mod.common.lib.BlockInfo;
import com.enderville.mod.common.lib.ItemInfo;
import com.enderville.mod.common.lib.MainMenuInfo;
import com.enderville.mod.common.lib.ModInfo;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

/**
 * ConfigurationHnadler.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class ConfigurationHandler {

	public static Configuration config;

	/* General Configuration File */
	public static void initGen(File configFileGen) {

		config = new Configuration(configFileGen);

		try {
			config.load();
			
			/* Blocks */
			BlockInfo.ENDERCOIN_ORE_ID = config.getBlock(BlockInfo.ENDERCOIN_ORE_KEY, BlockInfo.ENDERCOIN_ORE_ID_DEFAULT, "EnderCoin Ores").getInt();
			BlockInfo.ENDERCOIN_BANK_ID = config.getBlock(BlockInfo.ENDERCOIN_BANK_KEY, BlockInfo.ENDERCOIN_BANK_ID_DEFAULT, "EnderCoin Bank (safe)").getInt();
			
//			BlockInfo.MONEY_LOG_ID = config.getBlock(BlockInfo.MONEY_LOG_KEY, BlockInfo.MONEY_LOG_ID_DEFAULT, "").getInt();
//			BlockInfo.MONEY_LEAF_ID = config.getBlock(BlockInfo.MONEY_LEAF_KEY, BlockInfo.MONEY_LEAF_ID_DEFAULT, "").getInt();
//			BlockInfo.MONEY_SAPLING_ID = config.getBlock(BlockInfo.MONEY_SAPLING_KEY, BlockInfo.MONEY_SAPLING_ID_DEFAULT, "").getInt();
			
			/* Items */
			ItemInfo.ENDERCOIN_ID = config.getItem(ItemInfo.ENDERCOIN_KEY, ItemInfo.ENDERCOIN_ID_DEFAULT, "Item ID for all EnderCoins").getInt() - 256;
			
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, ModInfo.NAME + " had a problem while loading  its config (General Configuration File).");
		} finally {
			config.save();
		}

	}

	
	public static void initMenu(File file) {
		config = new Configuration(file);

		String catServer = "Server";
		String catMisc = "Misc";
		String catWeb = "Web";
		
        try {
                config.load();
                
                MainMenuInfo.enabled = config.get(catMisc, "Override Vanilla Main Menu:", true, "").getBoolean(true);
                
                MainMenuInfo.versionFileURL = config.get(catWeb, "Version File URL", "http://enderville.com/emf/version.txt").getString();
                MainMenuInfo.noticeFileURL = config.get(catWeb, "Notice File URL", "http://enderville.com/emf/notice.txt").getString();
                
                MainMenuInfo.serverName = config.get(catServer, "Server Name", "EnderVille_Mod").getString();
                MainMenuInfo.serverIP = config.get(catServer, "Server IP + Port", "mod.enderville.com", "eg. 127.0.0.1:12345 (if server uses port 25565, there is not need to specify a port)").getString();
                MainMenuInfo.serverButtonText = config.get(catServer, "Server Button Text", "Join EnderVille Mod Server").getString();
                
                MainMenuInfo.splashText = config.get(catMisc, "Splash Text", "EnderVille!").getString();
             
                
        } catch (Exception e) {
                FMLLog.log(Level.SEVERE, e, ModInfo.NAME + " had a problem while loading  its config (Main Menu Configuration File).");
        } finally {
                config.save();
        }
	}
}

