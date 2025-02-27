package com.example.sleepingbagmod;

import com.example.sleepingbagmod.init.ModBlocks;
import com.example.sleepingbagmod.init.ModItems;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = SleepingBagMod.MODID, version = SleepingBagMod.VERSION)
public class SleepingBagMod
{
    public static final String MODID = "sleepingbagmod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModEvents modEvents = new ModEvents();
        ModItems.sleeping_bag.setUnlocalizedName("sleepingBag");
        ModItems.sleeping_bag.setTextureName(MODID + ":sleeping_bag");
        ModItems.sleeping_bag.setCreativeTab(CreativeTabs.tabDecorations);
        ModItems.sleeping_bag.setMaxStackSize(1);
        ModBlocks.sleeping_bag.setBlockName("sleepingBag");
        ModBlocks.sleeping_bag.setBlockTextureName(MODID + ":sleeping_bag");
        ModBlocks.sleeping_bag.setHardness(0.2F);
        GameRegistry.registerItem(ModItems.sleeping_bag, "sleeping_bag_item", MODID);
        GameRegistry.registerBlock(ModBlocks.sleeping_bag, "sleeping_bag");
        MinecraftForge.EVENT_BUS.register(modEvents);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        GameRegistry.addRecipe(new ItemStack(ModItems.sleeping_bag),"AAA",'A',Blocks.wool);
    }
}
