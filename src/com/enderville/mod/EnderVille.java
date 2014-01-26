package com.enderville.mod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;

import com.enderville.mod.client.handler.ConfigurationHandler;
import com.enderville.mod.client.player.EventCloakRender;
import com.enderville.mod.client.player.EventSkinRender;
import com.enderville.mod.client.registry.EVStats;
import com.enderville.mod.client.registry.EVTabs;
import com.enderville.mod.common.CommonProxy;
import com.enderville.mod.common.entity.animal.EntityWildPROdotes;
import com.enderville.mod.common.lib.ModInfo;
import com.enderville.mod.common.registry.EVBlocks;
import com.enderville.mod.common.registry.EVItems;
import com.enderville.mod.common.registry.EVMisc;
import com.enderville.mod.common.registry.EVWorld;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * EnderVille.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class EnderVille {
	@SidedProxy(clientSide = ModInfo.CLIENTPROXY, serverSide = ModInfo.COMMONPROXY)
	public static CommonProxy proxy;
	
	public static EntityPlayer player; 
	public static World world;

	@Instance(ModInfo.ID)
	public static EnderVille instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.initGen(EnderConfigFiles.addConfigFile(ModInfo.CHANNELNAME, ModInfo.ID, event));
		ConfigurationHandler.initMenu(EnderConfigFiles.addConfigFile(ModInfo.CHANNELNAME, "MainMenu", event));
		
		EVBlocks.init();
		
		EVItems.init();
		
		EVWorld.initGen();
		EVWorld.moneyTreeBonemeal();
		
		proxy.initRenderers();
	}

	public static int proEntID = EntityRegistry.findGlobalUniqueEntityId();
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerPlayerTracker(new PlayerTracker());
		
		if (event.getSide() == Side.CLIENT)
        {
            MinecraftForge.EVENT_BUS.register(new EventCloakRender());
        }
		if (event.getSide() == Side.CLIENT){
			MinecraftForge.EVENT_BUS.register(new EventSkinRender());
		}
		
		EntityRegistry.registerGlobalEntityID(EntityWildPROdotes.class, "wildprodotes", proEntID ,0xffffff, 0xffffff);
		EntityRegistry.addSpawn(EntityWildPROdotes.class, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.plains);
		
		LanguageRegistry.instance().addStringLocalization("entity.wildprodotes.name","en_US", "A Wild PROdotes");
		
		/* Blocks */
		EVBlocks.addNames();
		EVBlocks.addRecipes();
		EVBlocks.regTileEnttities();
		
		/* Items */
		EVItems.addNames();
		EVItems.addRecipes();
		
		/* Creative Tabs */
		EVTabs.addNames();
		
		/* Villager */
		EVMisc.initVillager();
		proxy.initVillagers();
		
		/* Stats */
		EVStats.init();
		EVStats.addNames();
		EVStats.regPages();
		
		proxy.initKeys();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
	
	public static String getWebFile(String fileURL){
		String file = "";
		try {
		    // Create a URL for the desired page
		    URL url = new URL(fileURL);

		    // Read all the text returned by the server
		    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		    String str = in.readLine();
		    file = str;
		    in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return file;
	}
}
