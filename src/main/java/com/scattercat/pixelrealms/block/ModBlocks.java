package com.scattercat.pixelrealms.block;

import com.scattercat.pixelrealms.block.custom.ChiseledStairs;
import com.scattercat.pixelrealms.block.custom.SolarBlock;
import com.scattercat.pixelrealms.item.ModItems;
import com.scattercat.pixelrealms.PixelRealms;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PixelRealms.MOD_ID);

    public static final RegistryObject<Block> LIGHT_BLOCK = registerBlock("light_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 13)));

    public static final RegistryObject<Block> RAW_LIGHT_BLOCK = registerBlock("raw_light_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().lightLevel(value -> 8)));

    public static final RegistryObject<Block> LIGHT_ORE = registerBlock("light_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().lightLevel(value -> 9)));

    public static final RegistryObject<Block> LIGHT_DEEPSLATE_ORE = registerBlock("light_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE).lightLevel(value -> 8)));

    public static final RegistryObject<Block> SOLAR_PANEL = registerBlock("solar_panel",
            () -> new SolarBlock(BlockBehaviour.Properties.of().noOcclusion()));
    public static final RegistryObject<Block> CHISELED_STAIRS = registerBlock("chiseled_stairs",
            () -> new ChiseledStairs(BlockBehaviour.Properties.of().noOcclusion().randomTicks()));

    public static final RegistryObject<StairBlock> LIGHT_STAIR = registerBlock("light_stair",
            () -> new StairBlock(ModBlocks.LIGHT_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().lightLevel(value -> 13)));
    public static final RegistryObject<SlabBlock> LIGHT_SLAB = registerBlock("light_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().lightLevel(value -> 13)));


    public static final RegistryObject<PressurePlateBlock> LIGHT_PRESSURE_PLATE = registerBlock("light_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().lightLevel(value -> 13)));
    public static final RegistryObject<ButtonBlock> LIGHT_BUTTON = registerBlock("light_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noCollission().lightLevel(value -> 13)));

    public static final RegistryObject<FenceBlock> LIGHT_FENCE = registerBlock("light_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().lightLevel(value -> 13)));
    public static final RegistryObject<FenceGateBlock> LIGHT_FENCE_GATE = registerBlock("light_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().lightLevel(value -> 13)));
    public static final RegistryObject<WallBlock> LIGHT_WALL = registerBlock("light_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().lightLevel(value -> 13)));

    public static final RegistryObject<DoorBlock> LIGHT_DOOR = registerBlock("light_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion().lightLevel(value -> 13)));
    public static final RegistryObject<TrapDoorBlock> LIGHT_TRAPDOOR = registerBlock("light_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion().lightLevel(value -> 13)));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
