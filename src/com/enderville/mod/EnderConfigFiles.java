package com.enderville.mod;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * GoreConfigFiles.java
 * 
 * GoreCore
 *
 * @author DylanGore
 * @license DylanGore Mod License (http://mods.dylangore.info/license.txt)
 * 
 */

public class EnderConfigFiles {
	
	public static File addConfigFile(String modName, String fileName, FMLPreInitializationEvent event){
		return new File(event.getModConfigurationDirectory().getAbsolutePath()
                + File.separator
                + "EnderVille"
                + File.separator
                + modName
				+ File.separator
                + fileName + ".cfg");
	}
}
