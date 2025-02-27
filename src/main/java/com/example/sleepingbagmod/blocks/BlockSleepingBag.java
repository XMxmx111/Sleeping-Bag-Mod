package com.example.sleepingbagmod.blocks;

import com.example.sleepingbagmod.init.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSleepingBag extends BlockBed
{
    @SideOnly(Side.CLIENT)
    private IIcon[] field_149980_b;
    @SideOnly(Side.CLIENT)
    private IIcon[] field_149982_M;
    @SideOnly(Side.CLIENT)
    private IIcon[] field_149983_N;

    public BlockSleepingBag()
    {
        super();
        this.func_149978_e();
        this.disableStats();
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        if (p_149691_1_ == 0)
        {
            return Blocks.wool.getBlockTextureFromSide(p_149691_1_);
        }
        else
        {
            int var3 = getDirection(p_149691_2_);
            int var4 = Direction.bedDirection[var3][p_149691_1_];
            int var5 = isBlockHeadOfBed(p_149691_2_) ? 1 : 0;
            return (var5 != 1 || var4 != 2) && (var5 != 0 || var4 != 3) ? (var4 != 5 && var4 != 4 ? this.field_149983_N[var5] : this.field_149982_M[var5]) : this.field_149980_b[var5];
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_149983_N = new IIcon[] {Blocks.bed.getIcon(1, 0), Blocks.bed.getIcon(1, 1000)};
        this.field_149980_b = new IIcon[] {p_149651_1_.registerIcon(this.getTextureName() + "_feet_end"), p_149651_1_.registerIcon(this.getTextureName() + "_head_end")};
        this.field_149982_M = new IIcon[] {p_149651_1_.registerIcon(this.getTextureName() + "_feet_side"), p_149651_1_.registerIcon(this.getTextureName() + "_head_side")};
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess p_setBlockBoundsBasedOnState_1_, int p_setBlockBoundsBasedOnState_2_, int p_setBlockBoundsBasedOnState_3_, int p_setBlockBoundsBasedOnState_4_) {
        this.func_149978_e();
    }

    private void func_149978_e()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
    }

    public Item getItemDropped(int p_getItemDropped_1_, Random p_getItemDropped_2_, int p_getItemDropped_3_)
    {
        return BlockSleepingBag.isBlockHeadOfBed(p_getItemDropped_1_) ? Item.getItemById(0) : ModItems.sleeping_bag;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World p_getItem_1_, int p_getItem_2_, int p_getItem_3_, int p_getItem_4_)
    {
        return ModItems.sleeping_bag;
    }

    @Override
    public boolean isBed(IBlockAccess world, int x, int y, int z, EntityLivingBase player)
    {
        return true;
    }
}
