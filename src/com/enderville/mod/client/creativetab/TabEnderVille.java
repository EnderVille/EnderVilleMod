package com.enderville.mod.client.creativetab;

import com.enderville.mod.common.lib.TabInfo;
import com.enderville.mod.common.registry.EVItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * TabEnderVille.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class TabEnderVille extends CreativeTabs{

	public TabEnderVille(int tabID, String tabLabel) {
		super(tabID, tabLabel);
	}
	
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack()
	{
			return new ItemStack(EVItems.enderCoin, 1, 2);
	}

	public String getTranslatedTabLabel(){
		return TabInfo.ENDERVILLE_NAME;
	}

}
