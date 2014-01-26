package com.enderville.mod.common.item;

import java.util.List;

import com.enderville.mod.common.lib.ItemInfo;
import com.enderville.mod.common.lib.ModInfo;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * ItemEnderCoin.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class ItemEnderCoin extends TemplateItem{

	public ItemEnderCoin(int id) {
		super(id);
		this.hasSubtypes = true;
		this.setUnlocalizedName(ItemInfo.ENDERCOIN_NAME_UNLOC);
	}
	
	@SideOnly(Side.CLIENT)
    private Icon[] Icons;

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir)
    {
        Icons = new Icon[ItemInfo.ENDERCOIN_NAMES.length];
        for(int i = 0; i < Icons.length; i++)
        {
            Icons[i] = ir.registerIcon(ModInfo.ID.toLowerCase() + ":" + ItemInfo.ENDERCOIN_NAME_UNLOC + "_" + i);
        }
    }
    
    @Override
    public Icon getIconFromDamage(int dmg) {
    	return Icons[dmg];
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int i = MathHelper.clamp_int(stack.getItemDamage(), 0, ItemInfo.ENDERCOIN_NAMES.length);
        return super.getUnlocalizedName() + "_" + ItemInfo.ENDERCOIN_NAMES[i];
    }
    
    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs creativeTabs , @SuppressWarnings("rawtypes") List list)
    {
        for(int i = 0; i < Icons.length; i++)
        {
            list.add(new ItemStack(id ,1, i));
        }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public void addInformation(ItemStack stack,EntityPlayer player, @SuppressWarnings("rawtypes") List list, boolean par4) {
    		list.add("\u00a79" + "8 Iron Coins + 1 Gold Ingot (Crafting Bench) = 1 Gold Coin");
    		list.add("\u00a76" + "8 Gold Coins + 1 Diamond (Crafting Bench) = 1 Diamond Coin");
    		list.add("\u00a73" + "8 Diamond Coins + 1 Emerald (Crafting Bench) = 1 Emerald Coin");
    }
}
