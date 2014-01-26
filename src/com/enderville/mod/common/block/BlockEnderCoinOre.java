package com.enderville.mod.common.block;

import java.util.List;
import java.util.Random;

import com.enderville.mod.common.lib.BlockInfo;
import com.enderville.mod.common.lib.ModInfo;
import com.enderville.mod.common.registry.EVBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * BlockEnderCoinOre.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class BlockEnderCoinOre extends TemplateBlock {
	
	public BlockEnderCoinOre(int id, Material material) {
		super(id, material);
		this.setStepSound(Block.soundStoneFootstep);
		this.setUnlocalizedName(BlockInfo.ENDERCOIN_ORE_NAME_UNLOC);
		this.setLightValue(1.0F);
		this.setHardness(20.0F);
		this.setResistance(2000.0F);
	}
	
	@SideOnly(Side.CLIENT)
    private Icon[] Icons;

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir)
    {
        Icons = new Icon[BlockInfo.ENDERCOIN_ORE_NAMES.length];
        for(int i = 0; i < Icons.length; i++)
        {
            Icons[i] = ir.registerIcon(ModInfo.ID.toLowerCase() + ":" + BlockInfo.ENDERCOIN_ORE_NAME_UNLOC + "_" + i);
        }
    }
    
    public int damageDropped(int meta)
    {
        return meta;
    }
    
    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
    	return 0;
    }
    
    @Override
    public void onBlockClicked(World world, int x, int y, int z,EntityPlayer player) {
    	if(world.isRemote){
        	player.addChatMessage("\u00a74" + "[WARNING!]" + "\u00a7f" + " You will not recieve anything for mining this block!");
    	}
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int id, int meta)
    {
        return Icons[meta];
    }
    
    public int idPicked(int id)
    {
        return  id;
    }

    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs , @SuppressWarnings("rawtypes") List par3List)
    {
        for(int i = 0; i < Icons.length; i++)
        {
            par3List.add(new ItemStack(par1 ,1, i));
        }
    }
    
    @Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
    	if(player instanceof FakePlayer){
			return false;
		}
		else{
			switch(world.getBlockMetadata(x, y, z))
	        {
	            case 0:
	            {
	            	player.inventory.addItemStackToInventory(new ItemStack(EVBlocks.enderCoinOre, 1,0));
	    			world.setBlockToAir(x,y,z);
	    			world.playSoundAtEntity(player, "random.levelup", 1,2);
	                break;
	            }
	            
	            case 1:
	            {
	            	player.inventory.addItemStackToInventory(new ItemStack(EVBlocks.enderCoinOre, 1,1));
	    			world.setBlockToAir(x,y,z);
	    			world.playSoundAtEntity(player, "random.levelup", 1,2);
	    			break;
	            }
	            
	            case 2:
	            {
	            	player.inventory.addItemStackToInventory(new ItemStack(EVBlocks.enderCoinOre, 1,2));
	    			world.setBlockToAir(x,y,z);
	    			world.playSoundAtEntity(player, "random.levelup", 1,2);
	    			break;
	            }
	            
	            case 3:
	            {
	            	player.inventory.addItemStackToInventory(new ItemStack(EVBlocks.enderCoinOre, 1,3));
	    			world.setBlockToAir(x,y,z);
	    			world.playSoundAtEntity(player, "random.levelup", 1,2);
	    			break;
	            }
	        }
		}
			

			return true;
	}

}

