package com.enderville.mod.common.event;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

/**
 * EventMoneySaplingBonemeal.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class EventMoneySaplingBonemeal {

	@ForgeSubscribe
	public void usedBonemeal(BonemealEvent event){
//		if(event.ID == EVBlocks.moneySapling.blockID){
//			if(!event.world.isRemote){
//				((BlockMoneySapling)EVBlocks.moneySapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
//			}
//		}
	}
	
}
