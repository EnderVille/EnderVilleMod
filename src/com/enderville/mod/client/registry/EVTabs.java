package com.enderville.mod.client.registry;

import com.enderville.mod.client.creativetab.TabEnderVille;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;

/**
 * EVTabs.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class EVTabs {

	public static CreativeTabs tabEnderVille = new TabEnderVille(CreativeTabs.getNextID(), "EnderVille");;
	
	
	
	public static void addNames(){
			LanguageRegistry.instance().addStringLocalization("itemGroup.tabEnderVille", "en_US", "EnderVille");
	}
	
}
