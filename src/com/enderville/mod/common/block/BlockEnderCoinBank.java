package com.enderville.mod.common.block;

import java.util.Random;

import com.enderville.mod.EnderVille;
import com.enderville.mod.client.registry.EVTabs;
import com.enderville.mod.common.lib.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * BlockEnderCoinBank.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class BlockEnderCoinBank extends BlockContainer {

	public BlockEnderCoinBank(int id, Material material) {
		super(id, material);
		this.setCreativeTab(EVTabs.tabEnderVille);
		this.setResistance(99999.0F);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundMetalFootstep);
	}
	
	

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
	
	@Override
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(ModInfo.ID + ":" + "enderCoinBank");
	}
	
	/*
	 * Drops items contained in the EnderCoin Bank
	 */
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		dropItems(world, x, y,z);
		super.breakBlock(world, x, y, z, par5, par6);
	}
	

	/*
	 * Calculates How Items Are Dropped
	 */
	private void dropItems(World world, int x, int y, int z) {
		Random rand = new Random();
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		
		if(!(tile instanceof IInventory)){
			return;
		}
		
		IInventory inventory = (IInventory) tile;
		
		for(int i = 0; i < inventory.getSizeInventory(); i++){
			ItemStack item = inventory.getStackInSlot(i);
			
			if(item != null && item.stackSize > 0){
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;
				
				EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));
				
				if(item.hasTagCompound()){
					entityItem.getEntityItem().setTagCompound((NBTTagCompound)item.getTagCompound().copy());
				}
				
				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
		
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float what,float these, float are) {
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		
		if(tile == null || player.isSneaking()){
			return false;
		}
		player.openGui(EnderVille.instance, 0, world, x, y, z);
		return true;
	}
	
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		if(!world.isRemote){
			player.addChatMessage("\u00a7a" + "This block is WIP!");
		}
	}

}
