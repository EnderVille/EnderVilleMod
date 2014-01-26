package com.enderville.mod.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.enderville.mod.common.lib.ModInfo;

/**
 * GUIEnderCoinBank.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class GUIEnderCoinBank extends GuiContainer{

	public static final ResourceLocation field_110421_t = new ResourceLocation(ModInfo.ID.toLowerCase() + "/textures/gui/enderCoinBank.png");
	
	@SuppressWarnings("unused")
	private IInventory upperChestInventory;
	@SuppressWarnings("unused")
	private IInventory lowerChestInventory;
	private int inventoryRows;

	public GUIEnderCoinBank(IInventory IInv1, IInventory IInv2) {
		super(new ContainerChest(IInv1, IInv2));
		this.upperChestInventory = IInv1;
		this.lowerChestInventory = IInv1;
		short short1 = 222;
		int i = short1 - 108;
		this.inventoryRows = IInv2.getSizeInventory() / 9;
		this.ySize = i + this.inventoryRows * 18;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(field_110421_t);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) /2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		fontRenderer.drawString("EnderCoin Bank - " + this.mc.thePlayer.username , 8, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}
}
