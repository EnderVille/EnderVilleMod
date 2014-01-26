package com.enderville.mod.client.handler;
//package dylangore.mods.enderville.handler;
//
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.world.World;
//import cpw.mods.fml.common.network.IGuiHandler;
//import cpw.mods.fml.common.network.NetworkRegistry;
//import dylangore.mods.enderville.EnderVille;
//import dylangore.mods.enderville.client.container.ContainerPrintingPress;
//import dylangore.mods.enderville.client.container.GuiPrintingPress;
//import dylangore.mods.enderville.entity.tile.TileEntityPrintingPress;
//
///**
// * GuiHandler.java
// * 
// * EnderVille
// *
// * @author DylanGore (http://github.com/DylanGore)
// * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
// * 
// */
//
//public class GuiHandler implements IGuiHandler {
//
//	public GuiHandler() {
//		NetworkRegistry.instance().registerGuiHandler(EnderVille.instance, this);
//	}
//	
//	@Override
//	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//		switch (ID) {
//			case 0:
//				TileEntity te = world.getBlockTileEntity(x, y, z);
//				if (te != null && te instanceof TileEntityPrintingPress) {
//					return new ContainerPrintingPress(player.inventory, (TileEntityPrintingPress)te);
//				}
//				break;
//		}
//		
//		return null;
//	}
//
//	@Override
//	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//		switch (ID) {
//			case 0:
//				TileEntity te = world.getBlockTileEntity(x, y, z);
//				if (te != null && te instanceof TileEntityPrintingPress) {
//					return new GuiPrintingPress(player.inventory, (TileEntityPrintingPress)te);
//				}
//			
//				break;
//		}
//
//
//		return null;
//	}
//
//}
