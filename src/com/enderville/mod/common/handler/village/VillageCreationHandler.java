package com.enderville.mod.common.handler.village;

import java.util.List;
import java.util.Random;

import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureVillagePieceWeight;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

/**
 * VillageCreationHandler.java
 * 
 * EnderVille
 * 
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class VillageCreationHandler implements IVillageCreationHandler
{

	@Override
    public StructureVillagePieceWeight getVillagePieceWeight (Random random, int i)
    {
        return new StructureVillagePieceWeight(ComponentBank.class, 30, i + random.nextInt(4));
    }

    @Override
    public Class<?> getComponentClass ()
    {
        return ComponentBank.class;
    }

    @Override
    public Object buildComponent (StructureVillagePieceWeight villagePiece, ComponentVillageStartPiece startPiece, @SuppressWarnings("rawtypes") List pieces, Random random, int p1, int p2, int p3, int p4, int p5)
    {
        return ComponentBank.buildComponent(startPiece, pieces, random, p1, p2, p3, p4, p5);
    }
}
