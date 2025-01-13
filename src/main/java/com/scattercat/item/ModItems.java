package com.scattercat.item;

import com.scattercat.item.custom.ChiselItem;
import com.scattercat.pixelrealms.PixelRealms;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PixelRealms.MOD_ID);

    public static final RegistryObject<Item> LIGHTORB = ITEMS.register("lightorb",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_LIGHTORB = ITEMS.register("raw_lightorb",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));
    public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench",
            () -> new Item(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> GLOW_WRENCH = ITEMS.register("glow_wrench",
            () -> new Item(new Item.Properties().durability(64)));

    public static void regsiter(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}