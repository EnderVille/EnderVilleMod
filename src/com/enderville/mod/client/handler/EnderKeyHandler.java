package com.enderville.mod.client.handler;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import com.enderville.mod.client.player.EventCloakRender;
import com.enderville.mod.client.player.EventSkinRender;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

/**
 * EnderKeyHandler.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class EnderKeyHandler extends KeyHandler {

	@SuppressWarnings({ "rawtypes" })
	private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
	public static boolean keyPressed = false;
	@SuppressWarnings("unused")
	private Minecraft mc = FMLClientHandler.instance().getClient();
	
	public EnderKeyHandler(KeyBinding[] keyBindings, boolean[] repeatings) {
		super(keyBindings, repeatings);
		}
	
	@Override
	public String getLabel() {
		return "EnderKeyHandler";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		keyPressed = true;
		EventCloakRender.instance.refreshCapes();
		EventSkinRender.instance.refreshSkins();
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		keyPressed = false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public EnumSet<TickType> ticks() {
		
		return tickTypes;
	}

}
