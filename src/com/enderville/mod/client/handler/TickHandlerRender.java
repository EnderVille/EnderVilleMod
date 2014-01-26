package com.enderville.mod.client.handler;

import java.util.EnumSet;

import com.enderville.mod.client.gui.mainmenu.MenuBaseEnderVille;
import com.enderville.mod.common.lib.MainMenuInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

/**
 * TickHandlerRender.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class TickHandlerRender implements ITickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.CLIENT)))
		{	
		if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu && MainMenuInfo.enabled == true) {
				Minecraft.getMinecraft().displayGuiScreen(new MenuBaseEnderVille());
			}else{
				
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		return "enderville-menu-listener";
	}

}
