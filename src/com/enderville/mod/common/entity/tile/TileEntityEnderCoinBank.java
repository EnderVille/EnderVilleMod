package com.enderville.mod.common.entity.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

/**
 * TileEntityEnderCoinBank.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class TileEntityEnderCoinBank extends TileEntity implements IInventory{

	private ItemStack[] inv;
	
	public TileEntityEnderCoinBank(){
		inv = new ItemStack[9];
	}
	
	/*
	 * Reads EnderCoin Bank info from NBT
	 */
	@Override
	public void readFromNBT(NBTTagCompound tagComp) {
		super.readFromNBT(tagComp);
		NBTTagList tagList = tagComp.getTagList("Inventory");
		
		for(int i = 0; i < tagList.tagCount(); i++){
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");
			
			if(slot >= 0 && slot < inv.length){
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
	
	/*
	 * Writes EnderCoin Bank info to NBT
	 */
	@Override
	public void writeToNBT(NBTTagCompound tagComp) {
		super.writeToNBT(tagComp);
		NBTTagList itemList = new NBTTagList();
		
		for(int i =0;i < inv.length; i++){
			ItemStack stack = inv[i];
			
			if(stack != null){
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		
		tagComp.setTag("Inventory", itemList);
	}
	
	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int j) {
		ItemStack stack = getStackInSlot(slot);
		
		if(stack != null){
			
			if(stack.stackSize <= j){
				setInventorySlotContents(slot, null);
			}else{
				stack = stack.splitStack(j);
			}
			
			if(stack.stackSize == 0){
				setInventorySlotContents(slot, null);
			}
		}
		
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		
		if(stack != null){
			setInventorySlotContents(slot, null);
		}
		
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
		
		if(stack != null && stack.stackSize > getInventoryStackLimit()){
			stack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		return "EnderCoin Bank"; 
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openChest() {
		
	}

	@Override
	public void closeChest() {
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return false;
	}

}
