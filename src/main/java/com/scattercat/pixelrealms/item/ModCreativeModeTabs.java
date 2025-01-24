package com.scattercat.pixelrealms.item;

import com.scattercat.pixelrealms.block.ModBlocks;
import com.scattercat.pixelrealms.PixelRealms;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PixelRealms.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LIGHT_ITEMS_TAB = CREATIVE_MODE_TABS.register("light_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.LIGHTORB.get()))
                    .title(Component.translatable("creativetab.pixelrealms.light_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Add items and blocks to the creative tab
                        output.accept(ModItems.LIGHTORB.get());
                        output.accept(ModItems.RAW_LIGHTORB.get());
                        output.accept(ModBlocks.LIGHT_BLOCK.get());
                        output.accept(ModBlocks.RAW_LIGHT_BLOCK.get());
                        output.accept(ModBlocks.LIGHT_ORE.get());
                        output.accept(ModBlocks.LIGHT_DEEPSLATE_ORE.get());

                        output.accept(ModBlocks.LIGHT_STAIR.get());
                        output.accept(ModBlocks.LIGHT_BUTTON.get());
                        output.accept(ModBlocks.LIGHT_DOOR.get());
                        output.accept(ModBlocks.LIGHT_FENCE.get());
                        output.accept(ModBlocks.LIGHT_FENCE_GATE.get());
                        output.accept(ModBlocks.LIGHT_WALL.get());
                        output.accept(ModBlocks.LIGHT_SLAB.get());
                        output.accept(ModBlocks.LIGHT_TRAPDOOR.get());
                        output.accept(ModBlocks.LIGHT_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.SOLAR_PANEL.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}