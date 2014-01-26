package com.enderville.mod.client.render;

import com.enderville.mod.client.model.ModelHuman;
import com.enderville.mod.common.lib.ModInfo;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * RenderWildPROdotes.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class RenderWildPROdotes extends RenderLiving{

	private static ResourceLocation widPROdotes = new ResourceLocation(ModInfo.ID + ":" + "textures/entity/PROdotes.png");
	
	public RenderWildPROdotes() {
		super(new ModelHuman(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return widPROdotes;
	}
	
	

}
