package com.example.sleepingbagmod;

import com.example.sleepingbagmod.init.ModBlocks;
import com.example.sleepingbagmod.init.ModItems;
import com.example.sleepingbagmod.proxy.CommonProxy;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.ItemStack;

import static net.minecraft.block.Block.soundTypeCloth;

@Mod(modid = SleepingBagMod.MODID, version = SleepingBagMod.VERSION)
public class SleepingBagMod
{
    public static final String MODID = "sleepingbagmod";
    public static final String VERSION = "1.0";

    @SidedProxy(modId = SleepingBagMod.MODID, clientSide = "com.example.sleepingbagmod.proxy.ClientProxy", serverSide = "com.example.sleepingbagmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.sleeping_bag.setUnlocalizedName("sleepingBag");
        ModItems.sleeping_bag.setCreativeTab(CreativeTabs.tabDecorations);
        ModItems.sleeping_bag.setMaxStackSize(1);
        ModBlocks.sleeping_bag.setUnlocalizedName("sleepingBag");
        ModBlocks.sleeping_bag.setHardness(0.2F);
        ModBlocks.sleeping_bag.setStepSound(soundTypeCloth);
        GameRegistry.registerItem(ModItems.sleeping_bag, "sleeping_bag_item");
        GameRegistry.registerBlock(ModBlocks.sleeping_bag, "sleeping_bag");

        CommonProxy.registerEvent(new ModEvents());

        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        // System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        GameRegistry.addRecipe(new ItemStack(ModItems.sleeping_bag),"AAA",'A',Blocks.wool);

        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
}
