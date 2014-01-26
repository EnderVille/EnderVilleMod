package com.enderville.mod.common.registry;

import com.enderville.mod.common.handler.village.ComponentBank;
import com.enderville.mod.common.handler.village.TradeHanlderEnderVillager;
import com.enderville.mod.common.handler.village.VillageCreationHandler;

import net.minecraft.crash.CallableMinecraftVersion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * EVVillageer.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class EVMisc {

	
    /* Villager */
	
	public static int enderVillagerID = 345;
	
	@SideOnly(Side.CLIENT)
	public static void initVillagerClient(){
		VillagerRegistry.instance().registerVillagerSkin(enderVillagerID, new ResourceLocation("entity/villager/villager.png"));
	}
	
	public static void initVillager(){
		VillagerRegistry.instance().registerVillagerId(enderVillagerID);
		
		TradeHanlderEnderVillager handler = new TradeHanlderEnderVillager();
		VillagerRegistry.instance().registerVillageTradeHandler(enderVillagerID, handler);
		
		VillagerRegistry.instance().registerVillageCreationHandler(new VillageCreationHandler());try
        {
            if (new CallableMinecraftVersion(null).minecraftVersion().equals("1.6.4"))
            {
                MapGenStructureIO.func_143031_a(ComponentBank.class, "EnderVille:BankStructure");
            }
        }
        catch (Throwable e)
        {

        }
	}
	
	public static void initCapes(){
		
	}
	
	public static void initMisc(){
		
	}
	
}
