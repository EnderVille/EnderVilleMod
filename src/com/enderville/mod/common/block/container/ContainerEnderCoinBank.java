package com.enderville.mod.common.block.container;

import com.enderville.mod.common.entity.tile.TileEntityEnderCoinBank;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * ContainerEnderCoinBank.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class ContainerEnderCoinBank extends Container{

	protected TileEntityEnderCoinBank TE;
	
	public ContainerEnderCoinBank(InventoryPlayer inventoryPlayer, TileEntityEnderCoinBank tile){
		TE = tile;
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				addSlotToContainer(new Slot(TE, j + i * 3, 62 + j * 18, 17 + i * 18));
			}
		}
	
		bindPlayerInventory(inventoryPlayer);
	}
	
	/*
	 * Gets Player's Inventory
	 */
	private void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++){
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}
	
	/*
	 * Handles stack transfers
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack = null;
		Slot slotObject = (Slot)inventorySlots.get(slot);
		
		if(slotObject != null && slotObject.getHasStack()){
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();
			
			if(slot < 9){
				
				if(!this.mergeItemStack(stackInSlot, 0, 35, true)){
					return null;
				}
				
			}else if(this.mergeItemStack(stackInSlot, 0, 9, false)){
				return null;
			}
			
			if(stackInSlot.stackSize == 0){
				slotObject.putStack(null);
			}else{
				slotObject.onSlotChanged();
			}
			
			if(stackInSlot.stackSize == stack.stackSize){
				return null;
			}
			
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		
		return stack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return TE.isUseableByPlayer(player);
	}

}
