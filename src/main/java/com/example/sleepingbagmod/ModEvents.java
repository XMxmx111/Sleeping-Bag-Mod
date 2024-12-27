package com.example.sleepingbagmod;

import com.example.sleepingbagmod.blocks.BlockSleepingBag;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerSetSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModEvents
{
    @SubscribeEvent
    public void onPlayerSetSpawn(PlayerSetSpawnEvent event)
    {
        World world = event.entityPlayer.worldObj;
        if (event.newSpawn != null)
        {
            Block block = world.getBlockState(event.newSpawn).getBlock();
            if (!world.isRemote && block instanceof BlockSleepingBag)
            {
                event.setCanceled(true);
            }
        }
    }
}
