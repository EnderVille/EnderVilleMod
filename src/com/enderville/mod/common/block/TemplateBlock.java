package com.enderville.mod.common.block;

import com.enderville.mod.client.registry.EVTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * TemplateBlock.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class TemplateBlock extends Block {

	public TemplateBlock(int id, Material material) {
		super(id, material);
		this.setCreativeTab(EVTabs.tabEnderVille);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
	}
}

