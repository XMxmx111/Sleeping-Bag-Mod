package com.example.sleepingbagmod.items;

import com.example.sleepingbagmod.blocks.BlockSleepingBag;
import com.example.sleepingbagmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBed;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemSleepingBag extends ItemBed
{
    public ItemSleepingBag()
    {
        super();
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    @Override
    public boolean onItemUse(ItemStack p_onItemUse_1_, EntityPlayer p_onItemUse_2_, World p_onItemUse_3_, BlockPos p_onItemUse_4_, EnumFacing p_onItemUse_5_, float p_onItemUse_6_, float p_onItemUse_7_, float p_onItemUse_8_) {
        if (p_onItemUse_3_.isRemote) {
            return true;
        } else if (p_onItemUse_5_ != EnumFacing.UP) {
            return false;
        } else {
            IBlockState lvt_9_1_ = p_onItemUse_3_.getBlockState(p_onItemUse_4_);
            Block lvt_10_1_ = lvt_9_1_.getBlock();
            boolean lvt_11_1_ = lvt_10_1_.isReplaceable(p_onItemUse_3_, p_onItemUse_4_);
            if (!lvt_11_1_) {
                p_onItemUse_4_ = p_onItemUse_4_.up();
            }

            int lvt_12_1_ = MathHelper.floor_double((double)(p_onItemUse_2_.rotationYaw * 4.0F / 360.0F) + (double)0.5F) & 3;
            EnumFacing lvt_13_1_ = EnumFacing.getHorizontal(lvt_12_1_);
            BlockPos lvt_14_1_ = p_onItemUse_4_.offset(lvt_13_1_);
            if (p_onItemUse_2_.canPlayerEdit(p_onItemUse_4_, p_onItemUse_5_, p_onItemUse_1_) && p_onItemUse_2_.canPlayerEdit(lvt_14_1_, p_onItemUse_5_, p_onItemUse_1_)) {
                boolean lvt_15_1_ = p_onItemUse_3_.getBlockState(lvt_14_1_).getBlock().isReplaceable(p_onItemUse_3_, lvt_14_1_);
                boolean lvt_16_1_ = lvt_11_1_ || p_onItemUse_3_.isAirBlock(p_onItemUse_4_);
                boolean lvt_17_1_ = lvt_15_1_ || p_onItemUse_3_.isAirBlock(lvt_14_1_);
                if (lvt_16_1_ && lvt_17_1_ && World.doesBlockHaveSolidTopSurface(p_onItemUse_3_, p_onItemUse_4_.down()) && World.doesBlockHaveSolidTopSurface(p_onItemUse_3_, lvt_14_1_.down())) {
                    IBlockState lvt_18_1_ = ModBlocks.sleeping_bag.getDefaultState().withProperty(BlockSleepingBag.OCCUPIED, false).withProperty(BlockSleepingBag.FACING, lvt_13_1_).withProperty(BlockSleepingBag.PART, BlockSleepingBag.EnumPartType.FOOT);
                    if (p_onItemUse_3_.setBlockState(p_onItemUse_4_, lvt_18_1_, 3)) {
                        IBlockState lvt_19_1_ = lvt_18_1_.withProperty(BlockSleepingBag.PART, BlockSleepingBag.EnumPartType.HEAD);
                        p_onItemUse_3_.setBlockState(lvt_14_1_, lvt_19_1_, 3);
                    }

                    --p_onItemUse_1_.stackSize;
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
