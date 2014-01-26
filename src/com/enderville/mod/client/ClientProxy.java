package com.enderville.mod.client;

import com.enderville.mod.client.handler.TickHandlerRender;
import com.enderville.mod.client.registry.EVKeys;
import com.enderville.mod.client.render.RenderWildPROdotes;
import com.enderville.mod.common.CommonProxy;
import com.enderville.mod.common.entity.animal.EntityWildPROdotes;
import com.enderville.mod.common.registry.EVMisc;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * ClientProxy.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class ClientProxy extends CommonProxy {
	@Override
	public void initSounds() {
	}

	@Override
	public void initRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityWildPROdotes.class, new RenderWildPROdotes());
		TickRegistry.registerTickHandler(new TickHandlerRender(), Side.CLIENT);
	}
	
	@Override
	public void initVillagers(){
		EVMisc.initVillagerClient();
	}
	
	@Override
	public void initKeys(){
		EVKeys.addKeyBindings();
	}
}

