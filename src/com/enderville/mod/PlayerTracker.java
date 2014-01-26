package com.enderville.mod;

import com.enderville.mod.client.player.EventCloakRender;
import com.enderville.mod.client.player.EventSkinRender;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;

/**
 * PlayerTracker.java
 * 
 * EnderVille
 *
 * @author DylanGore
 * @license DylanGore Mod License (http://mods.dylangore.info/license.txt)
 * 
 */

public class PlayerTracker implements IPlayerTracker
{

	@Override
	public void onPlayerLogin(EntityPlayer player)
	{
		player.addChatMessage("" + "If your skin is steve, press F5 to refresh it");
			
		EventCloakRender.instance.refreshCapes();
		EventSkinRender.instance.refreshSkins();
	}

	@Override
	public void onPlayerLogout(EntityPlayer player)
	{
	}


	@Override
	public void onPlayerChangedDimension(EntityPlayer player)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onPlayerRespawn(EntityPlayer player)
	{
		// TODO Auto-generated method stub
	}
}