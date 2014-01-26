package com.enderville.mod.common.itemblock;

import java.util.List;

import com.enderville.mod.common.lib.BlockInfo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * ItemBlockEnderCoinORe.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class ItemBlockEnderCoinOre extends ItemBlock{

	public ItemBlockEnderCoinOre(int id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		
		return BlockInfo.ENDERCOIN_ORE_NAME_UNLOC + BlockInfo.ENDERCOIN_ORE_NAMES_UNLOC[stack.getItemDamage()];
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("To obtain this block you must right click on it, it can not be");
		list.add("mined with a pickaxe or any other mining method.");
		list.add("--------------------------------------------------");
		list.add("To convert this block to EnderCoins, smelt it using a furnace");
	}

}

