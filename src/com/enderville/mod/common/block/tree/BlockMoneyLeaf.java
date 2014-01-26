package com.enderville.mod.common.block.tree;


/**
 * BlockMoneyLeaf.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

//public class BlockMoneyLeaf extends BlockLeavesBase implements IShearable {
//
//	public String unlocName = BlockInfo.MONEY_LEAF_NAME_UNLOC;
//	
//	public BlockMoneyLeaf(int id, Material material) {
//		super(id, material, false);
//		this.setUnlocalizedName(unlocName);
//		this.setCreativeTab(EVTabs.tabEnderVille);
//		this.setHardness(0.2F);
//		this.setStepSound(Block.soundGrassFootstep);
//		this.setTickRandomly(true);
//	}
//	 public static final String[] LEAF_TYPES = new String[] {"Money"};
//	    public static final String[][] LEAF_RENDER_TYPE = new String[][] {{"leafMoney"}, {"leafMoney_Opaque"}};
//	    @SideOnly(Side.CLIENT)
//
//	    /** 1 for fast graphic. 0 for fancy graphics. used in iconArray. */
//	    private int iconType;
//	    private Icon[][] iconArray = new Icon[2][];
//	    int[] adjacentTreeBlocks;
//
//	    @SideOnly(Side.CLIENT)
//	    public int getBlockColor()
//	    {
//	        return ColorizeLeaves.getFoliageColor();
//	    }
//
//	    @SideOnly(Side.CLIENT)
//
//	    /**
//	     * Returns the color this block should be rendered. Used by leaves.
//	     */
//	    public int getRenderColor(int par1)
//	    {
//	    	if((par1 &3) == 0){
//	    		return ColorizeLeaves.getFoliageColorMoney();
//	    	}
//	    	else{
//	    		return ColorizeLeaves.getFoliageColorMoney();
//	    	}
//	        
//	    }
//
//	    @SideOnly(Side.CLIENT)
//
//	    /**
//	     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
//	     * when first determining what to render.
//	     */
//	    public int colorMultiplier(IBlockAccess IBlockAccess, int x, int y, int z)
//	    {
//	        int l = IBlockAccess.getBlockMetadata(x, y, z);
//
//	        if ((l & 3) == 0)
//	        {
//	            return ColorizeLeaves.getFoliageColorMoney();
//	        }
////	        else if ((l & 3) == 1)
////	        {
////	            return ColorizerFoliage.getFoliageColorPine();
////	        }
////	        else if ((l & 3) == 2)
////	        {
////	            return ColorizerFoliage.getFoliageColorBirch();
////	        }
//	        else
//	        {
//	            int i1 = 0;
//	            int j1 = 0;
//	            int k1 = 0;
//
//	            for (int l1 = -1; l1 <= 1; ++l1)
//	            {
//	                for (int i2 = -1; i2 <= 1; ++i2)
//	                {
//	                    int j2 = IBlockAccess.getBiomeGenForCoords(x + i2, z + l1).getBiomeFoliageColor();
//	                    i1 += (j2 & 16711680) >> 16;
//	                    j1 += (j2 & 65280) >> 8;
//	                    k1 += j2 & 255;
//	                }
//	            }
//
//	            return (i1 / 9 & 255) << 16 | (j1 / 9 & 255) << 8 | k1 / 9 & 255;
//	        }
//	    }
//
//	    /**
//	     * Called on server worlds only when the block has been replaced by a different block ID, or the same block with a
//	     * different metadata value, but before the new metadata value is set. Args: World, x, y, z, old block ID, old
//	     * metadata
//	     */
//	    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
//	    {
//	        byte b0 = 1;
//	        int j1 = b0 + 1;
//
//	        if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1))
//	        {
//	            for (int k1 = -b0; k1 <= b0; ++k1)
//	            {
//	                for (int l1 = -b0; l1 <= b0; ++l1)
//	                {
//	                    for (int i2 = -b0; i2 <= b0; ++i2)
//	                    {
//	                        int j2 = par1World.getBlockId(par2 + k1, par3 + l1, par4 + i2);
//
//	                        if (Block.blocksList[j2] != null)
//	                        {
//	                            Block.blocksList[j2].beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
//	                        }
//	                    }
//	                }
//	            }
//	        }
//	    }
//
//	    /**
//	     * Ticks the block if it's been scheduled
//	     */
//	    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
//	    {
//	        if (!par1World.isRemote)
//	        {
//	            int l = par1World.getBlockMetadata(par2, par3, par4);
//
//	            if ((l & 8) != 0 && (l & 4) == 0)
//	            {
//	                byte b0 = 4;
//	                int i1 = b0 + 1;
//	                byte b1 = 32;
//	                int j1 = b1 * b1;
//	                int k1 = b1 / 2;
//
//	                if (this.adjacentTreeBlocks == null)
//	                {
//	                    this.adjacentTreeBlocks = new int[b1 * b1 * b1];
//	                }
//
//	                int l1;
//
//	                if (par1World.checkChunksExist(par2 - i1, par3 - i1, par4 - i1, par2 + i1, par3 + i1, par4 + i1))
//	                {
//	                    int i2;
//	                    int j2;
//	                    int k2;
//
//	                    for (l1 = -b0; l1 <= b0; ++l1)
//	                    {
//	                        for (i2 = -b0; i2 <= b0; ++i2)
//	                        {
//	                            for (j2 = -b0; j2 <= b0; ++j2)
//	                            {
//	                                k2 = par1World.getBlockId(par2 + l1, par3 + i2, par4 + j2);
//
//	                                Block block = Block.blocksList[k2];
//
//	                                if (block != null && block.canSustainLeaves(par1World, par2 + l1, par3 + i2, par4 + j2))
//	                                {
//	                                    this.adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
//	                                }
//	                                else if (block != null && block.isLeaves(par1World, par2 + l1, par3 + i2, par4 + j2))
//	                                {
//	                                    this.adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -2;
//	                                }
//	                                else
//	                                {
//	                                    this.adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -1;
//	                                }
//	                            }
//	                        }
//	                    }
//
//	                    for (l1 = 1; l1 <= 4; ++l1)
//	                    {
//	                        for (i2 = -b0; i2 <= b0; ++i2)
//	                        {
//	                            for (j2 = -b0; j2 <= b0; ++j2)
//	                            {
//	                                for (k2 = -b0; k2 <= b0; ++k2)
//	                                {
//	                                    if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1)
//	                                    {
//	                                        if (this.adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
//	                                        {
//	                                            this.adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
//	                                        }
//
//	                                        if (this.adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
//	                                        {
//	                                            this.adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
//	                                        }
//
//	                                        if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == -2)
//	                                        {
//	                                            this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
//	                                        }
//
//	                                        if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == -2)
//	                                        {
//	                                            this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
//	                                        }
//
//	                                        if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == -2)
//	                                        {
//	                                            this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
//	                                        }
//
//	                                        if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == -2)
//	                                        {
//	                                            this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
//	                                        }
//	                                    }
//	                                }
//	                            }
//	                        }
//	                    }
//	                }
//
//	                l1 = this.adjacentTreeBlocks[k1 * j1 + k1 * b1 + k1];
//
//	                if (l1 >= 0)
//	                {
//	                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l & -9, 4);
//	                }
//	                else
//	                {
//	                    this.removeLeaves(par1World, par2, par3, par4);
//	                }
//	            }
//	        }
//	    }
//
//	    @SideOnly(Side.CLIENT)
//
//	    /**
//	     * A randomly called display update to be able to add particles or other items for display
//	     */
//	    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
//	    {
//	        if (par1World.canLightningStrikeAt(par2, par3 + 1, par4) && !par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) && par5Random.nextInt(15) == 1)
//	        {
//	            double d0 = (double)((float)par2 + par5Random.nextFloat());
//	            double d1 = (double)par3 - 0.05D;
//	            double d2 = (double)((float)par4 + par5Random.nextFloat());
//	            par1World.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
//	        }
//	    }
//
//	    private void removeLeaves(World par1World, int par2, int par3, int par4)
//	    {
//	        this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
//	        par1World.setBlockToAir(par2, par3, par4);
//	    }
//
//	    /**
//	     * Returns the quantity of items to drop on block destruction.
//	     */
//	    public int quantityDropped(Random par1Random)
//	    {
//	        return par1Random.nextInt(20) == 0 ? 1 : 0;
//	    }
//
//	    private static World worldObj;
//	    
//	    /**
//	     * Returns the ID of the items to drop on destruction.
//	     */
//	    public int idDropped(int par1, Random rand, int par3)
//	    {
//	    	@SuppressWarnings("unused")
//			World world;
//	    	
//	    	if(worldObj.rand.nextInt(20) == 1){
//	    		return EVBlocks.moneySapling.blockID;
//	    	}else{
//	    		return 0;
//	    	}
//	        
//	    }
//
//	    /**
//	     * Drops the block items with a specified chance of dropping the specified items
//	     */
//	    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int par5, float par6, int par7)
//	    {
//	    		if(world.rand.nextInt(4) == 1){
//	    			this.dropBlockAsItem_do(world, x, y, z, new ItemStack(EVItems.enderCoin, 1, 0));
//	    		}
//	    		else if(world.rand.nextInt(8) == 1){
//	    			this.dropBlockAsItem_do(world, x, y, z, new ItemStack(EVItems.enderCoin, 1, 1));
//	    		}
//	    		else if(world.rand.nextInt(12) == 1){
//	    			this.dropBlockAsItem_do(world, x, y, z, new ItemStack(EVItems.enderCoin, 1, 2));
//	    		}
//	    		else if(world.rand.nextInt(16) == 1){
//	    			this.dropBlockAsItem_do(world, x, y, z, new ItemStack(EVItems.enderCoin, 1, 3));
//	    		}
//	    	
//	    }
//
//	    /**
//	     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
//	     * block and l is the block's subtype/damage.
//	     */
//	    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
//	    {
//	        super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
//	    }
//
//	    /**
//	     * Determines the damage on the item the block drops. Used in cloth and wood.
//	     */
//	    public int damageDropped(int dmg)
//	    {
//	        return dmg & 3;
//	    }
//
//	    /**
//	     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
//	     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
//	     */
//	    public boolean isOpaqueCube()
//	    {
//	        return !this.graphicsLevel;
//	    }
//
//	    @SideOnly(Side.CLIENT)
//
//	    /**
//	     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
//	     */
//	    public Icon getIcon(int par1, int par2)
//	    {
//	    	return this.iconArray[this.iconType][0];
//	    }
//
//	    @SideOnly(Side.CLIENT)
//
//	    /**
//	     * Pass true to draw this block using fancy graphics, or false for fast graphics.
//	     */
//	    public void setGraphicsLevel(boolean par1)
//	    {
//	        this.graphicsLevel = par1;
//	        this.iconType = par1 ? 0 : 1;
//	    }
//
//	    @SuppressWarnings("unchecked")
//		@SideOnly(Side.CLIENT)
//
//	    /**
//	     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
//	     */
//	    public void getSubBlocks(int id, CreativeTabs tabs, @SuppressWarnings("rawtypes") List list)
//	    {
//	        list.add(new ItemStack(id, 1, 0));
//	    }
//
//	    /**
//	     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
//	     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
//	     */
//	    protected ItemStack createStackedBlock(int par1)
//	    {
//	        return new ItemStack(this.blockID, 1, par1 & 3);
//	    }
//
//	    @SideOnly(Side.CLIENT)
//
//	    /**
//	     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
//	     * is the only chance you get to register icons.
//	     */
//	    public void registerIcons(IconRegister ir)
//	    {
//	        for (int i = 0; i < LEAF_RENDER_TYPE.length; ++i)
//	        {
//	            this.iconArray[i] = new Icon[LEAF_RENDER_TYPE[i].length];
//
//	            for (int j = 0; j < LEAF_RENDER_TYPE[i].length; ++j)
//	            {
//	                this.iconArray[i][j] = ir.registerIcon(ModInfo.ID + ":" + LEAF_RENDER_TYPE[i][j]);
//	            }
//	        }
//	    }
//
//	    @Override
//	    public boolean isShearable(ItemStack item, World world, int x, int y, int z)
//	    {
//	        return true;
//	    }
//
//	    @Override
//	    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
//	    {
//	        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
//	        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
//	        return ret;
//	    }
//
//	    @Override
//	    public void beginLeavesDecay(World world, int x, int y, int z)
//	    {
//	        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
//	    }
//
//	    @Override
//	    public boolean isLeaves(World world, int x, int y, int z)
//	    {
//	        return true;
//	    }
//	}
//
