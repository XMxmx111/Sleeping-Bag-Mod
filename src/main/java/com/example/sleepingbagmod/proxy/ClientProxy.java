package com.example.sleepingbagmod.proxy;

import com.example.sleepingbagmod.blocks.BlockSleepingBag;
import com.example.sleepingbagmod.init.ModBlocks;
import com.example.sleepingbagmod.init.ModItems;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

import static com.example.sleepingbagmod.SleepingBagMod.MODID;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        ModelLoader.setCustomModelResourceLocation(ModItems.sleeping_bag, 0, new ModelResourceLocation(MODID + ":sleeping_bag", "inventory"));
        ModelLoader.setCustomStateMapper(ModBlocks.sleeping_bag, (new StateMap.Builder()).ignore(BlockSleepingBag.OCCUPIED).build());
    }
    @Override
    public void init() {}
    @Override
    public void postInit() {}
}
