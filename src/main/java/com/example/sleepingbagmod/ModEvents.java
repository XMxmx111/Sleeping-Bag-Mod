package com.example.sleepingbagmod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

public class ModEvents
{
    @SubscribeEvent
    public void PlayerWakeUp(PlayerWakeUpEvent event)
    {
        if (event.setSpawn)
        {
            System.out.println("Player Wake Up");
        }
    }
}
