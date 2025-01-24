package com.scattercat.pixelrealms.datagen;

import com.scattercat.pixelrealms.PixelRealms;
import com.scattercat.pixelrealms.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocksStateProvider extends BlockStateProvider {
    public ModBlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PixelRealms.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.LIGHT_BLOCK);
        blockWithItem(ModBlocks.LIGHT_ORE);
        blockWithItem(ModBlocks.LIGHT_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.RAW_LIGHT_BLOCK);


        stairsBlock(ModBlocks.LIGHT_STAIR.get(), blockTexture(ModBlocks.LIGHT_BLOCK.get()));
        slabBlock(ModBlocks.LIGHT_SLAB.get(), blockTexture(ModBlocks.LIGHT_BLOCK.get()), blockTexture(ModBlocks.LIGHT_BLOCK.get()));

        buttonBlock(ModBlocks.LIGHT_BUTTON.get(), blockTexture(ModBlocks.LIGHT_BLOCK.get()));
        pressurePlateBlock(ModBlocks.LIGHT_PRESSURE_PLATE.get(), blockTexture(ModBlocks.LIGHT_BLOCK.get()));

        fenceBlock(ModBlocks.LIGHT_FENCE.get(), blockTexture(ModBlocks.LIGHT_BLOCK.get()));
        fenceGateBlock(ModBlocks.LIGHT_FENCE_GATE.get(), blockTexture(ModBlocks.LIGHT_BLOCK.get()));
        wallBlock(ModBlocks.LIGHT_WALL.get(), blockTexture(ModBlocks.LIGHT_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.LIGHT_DOOR.get(), modLoc("block/light_door_bottom"), modLoc("block/light_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.LIGHT_TRAPDOOR.get(), modLoc("block/light_trapdoor"), true, "cutout");

        blockItem(ModBlocks.LIGHT_STAIR);
        blockItem(ModBlocks.LIGHT_SLAB);
        blockItem(ModBlocks.LIGHT_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.LIGHT_PRESSURE_PLATE);
        blockItem(ModBlocks.LIGHT_FENCE_GATE);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("pixelrealms:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()) {
        });
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("pixelrealms:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
