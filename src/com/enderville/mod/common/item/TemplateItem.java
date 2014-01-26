package com.enderville.mod.common.item;

import com.enderville.mod.client.registry.EVTabs;
import com.enderville.mod.common.lib.ModInfo;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

/**
 * ItemTemplateItem.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class TemplateItem extends Item{

	public TemplateItem(int id) {
		super(id);
		this.canRepair = false;
		this.setCreativeTab(EVTabs.tabEnderVille);
	}
	
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon(ModInfo.ID + ":" + this.getUnlocalizedName().substring(5));
	}
}
