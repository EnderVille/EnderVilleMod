package com.enderville.mod.client.registry;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import com.enderville.mod.client.handler.EnderKeyHandler;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * EVKeys.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class EVKeys {

	/* Refresh Capes */
	private static KeyBinding[] keyRefresh = {new KeyBinding("\u00a75" + "Refresh Ender Capes + Skins", Keyboard.KEY_F12)};
	private static boolean[] repeatRefresh = {false};
	
	@SideOnly(Side.CLIENT)
	public static void addKeyBindings(){
		KeyBindingRegistry.registerKeyBinding(new EnderKeyHandler(keyRefresh, repeatRefresh));
	}
	
}
