package com.enderville.mod.asm;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

/**
 * GoreCoreLoadingPlugin.java
 * 
 * GoreCore
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

@TransformerExclusions("com.enderville.mod")

@MCVersion("1.6.4")
public class EnderVilleLoadingPlugin implements IFMLLoadingPlugin {
	
	@Override
	public String[] getLibraryRequestClass() {
		return null;
	}

	@Override
	public String[] getASMTransformerClass() {
		return new String[] {"com.enderville.mod.asm.EnderVilleAccessTransformer"};
	}

	@Override
	public String getModContainerClass() {
		return null; //"com.enderville.mod.asm.EnderVilleModContainer";
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {

	}

}
