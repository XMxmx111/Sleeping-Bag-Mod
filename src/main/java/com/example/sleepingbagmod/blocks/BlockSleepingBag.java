package com.example.sleepingbagmod.blocks;

import com.example.sleepingbagmod.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBed;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSleepingBag extends BlockBed
{
    public BlockSleepingBag()
    {
        super();
        this.setBedBounds();
        this.disableStats();
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess p_setBlockBoundsBasedOnState_1_, BlockPos p_setBlockBoundsBasedOnState_2_) {
        this.setBedBounds();
    }

    private void setBedBounds()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
    }

    public Item getItemDropped(IBlockState p_getItemDropped_1_, Random p_getItemDropped_2_, int p_getItemDropped_3_)
    {
        return p_getItemDropped_1_.getValue(PART) == BlockSleepingBag.EnumPartType.HEAD ? null : ModItems.sleeping_bag;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World p_getItem_1_, BlockPos p_getItem_2_)
    {
        return ModItems.sleeping_bag;
    }

    @Override
    public boolean isBed(IBlockAccess p_isBed_1_, BlockPos p_isBed_2_, Entity p_isBed_3_)
    {
        return true;
    }
}
