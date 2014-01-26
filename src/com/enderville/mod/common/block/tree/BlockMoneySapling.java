package com.enderville.mod.common.block.tree;


/**
 * BlockMoneySapling.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

//public class BlockMoneySapling extends BlockFlower {
//	
//	public String unlocName = BlockInfo.MONEY_SAPLING_NAME_UNLOC;
//	
//	public BlockMoneySapling(int id, Material material) {
//		super(id, material);
//		this.setUnlocalizedName(unlocName);
//		this.setCreativeTab(EVTabs.tabEnderVille);
//		this.setHardness(0.1F);
//		float f = 0.4F;
//        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
//	}
//	
//	public static final String[] WOOD_TYPES = new String[] {"Money"};
//    @SideOnly(Side.CLIENT)
//    private Icon[] saplingIcon;
//
//    /**
//     * Ticks the block if it's been scheduled
//     */
//    public void updateTick(World world, int x, int y, int z, Random rand)
//    {
//        if (!world.isRemote)
//        {
//            super.updateTick(world, x, y, z, rand);
//
//            if (world.getBlockLightValue(x, y + 1, z) >= 9 && rand.nextInt(7) == 0)
//            {
//                this.markOrGrowMarked(world, x, y, z, rand);
//            }
//        }
//    }
//
//    @SideOnly(Side.CLIENT)
//
//    /**
//     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
//     */
//    public Icon getIcon(int par1, int par2)
//    {
//        par2 &= 3;
//        return this.saplingIcon[par2];
//    }
//
//    public void markOrGrowMarked(World par1World, int par2, int par3, int par4, Random par5Random)
//    {
//        int l = par1World.getBlockMetadata(par2, par3, par4);
//
//        if ((l & 8) == 0)
//        {
//            par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
//        }
//        else
//        {
//            this.growTree(par1World, par2, par3, par4, par5Random);
//        }
//    }
//
//    /**
//     * Attempts to grow a sapling into a tree
//     */
//    public void growTree(World par1World, int par2, int par3, int par4, Random par5Random)
//    {
//        if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
//
//        int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
//        Object object = null;
//        int i1 = 0;
//        int j1 = 0;
//        boolean flag = false;
//
//        if (l == 1)
//        {
//            object = new WorldGenTaiga2(true);
//        }
//        else if (l == 2)
//        {
//            object = new WorldGenForest(true);
//        }
//        else if (l == 3)
//        {
//            for (i1 = 0; i1 >= -1; --i1)
//            {
//                for (j1 = 0; j1 >= -1; --j1)
//                {
//                    if (this.isSameSapling(par1World, par2 + i1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3))
//                    {
//                        object = new WorldGenEnderTrees(true, 4 + par5Random.nextInt(7), 3, 3, false);
//                        flag = true;
//                        break;
//                    }
//                }
//
//                if (object != null)
//                {
//                    break;
//                }
//            }
//
//            if (object == null)
//            {
//                j1 = 0;
//                i1 = 0;
//                object = new WorldGenEnderTrees(true, 4 + par5Random.nextInt(7), 3, 3, false);
//            }
//        }
//        else
//        {
//            object = new WorldGenEnderTrees(true);
//
//            if (par5Random.nextInt(10) == 0)
//            {
//                object = new WorldGenBigTree(true);
//            }
//        }
//
//        if (flag)
//        {
//            par1World.setBlock(par2 + i1, par3, par4 + j1, 0, 0, 4);
//            par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, 0, 0, 4);
//            par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, 0, 0, 4);
//            par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, 0, 0, 4);
//        }
//        else
//        {
//            par1World.setBlock(par2, par3, par4, 0, 0, 4);
//        }
//
//        if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
//        {
//            if (flag)
//            {
//                par1World.setBlock(par2 + i1, par3, par4 + j1, this.blockID, l, 4);
//                par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this.blockID, l, 4);
//                par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this.blockID, l, 4);
//                par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this.blockID, l, 4);
//            }
//            else
//            {
//                par1World.setBlock(par2, par3, par4, this.blockID, l, 4);
//            }
//        }
//    }
//
//    /**
//     * Determines if the same sapling is present at the given location.
//     */
//    public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5)
//    {
//        return par1World.getBlockId(par2, par3, par4) == this.blockID && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
//    }
//
//    /**
//     * Determines the damage on the item the block drops. Used in cloth and wood.
//     */
//    public int damageDropped(int dmg)
//    {
//        return dmg & 3;
//    }
//
//    @SuppressWarnings("unchecked")
//	@SideOnly(Side.CLIENT)
//
//    /**
//     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
//     */
//    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, @SuppressWarnings("rawtypes") List par3List)
//    {
//        par3List.add(new ItemStack(par1, 1, 0));
//    }
//
//    @SideOnly(Side.CLIENT)
//
//    /**
//     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
//     * is the only chance you get to register icons.
//     */
//    public void registerIcons(IconRegister ir)
//    {
//        this.saplingIcon = new Icon[WOOD_TYPES.length];
//
//        for (int i = 0; i < this.saplingIcon.length; ++i)
//        {
//            this.saplingIcon[i] = ir.registerIcon(ModInfo.ID + ":"+ "sapling" + WOOD_TYPES[i]);
//        }
//    }
//}
//
