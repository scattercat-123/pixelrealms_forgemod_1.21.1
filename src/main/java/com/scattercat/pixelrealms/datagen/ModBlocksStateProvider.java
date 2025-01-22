package com.scattercat.pixelrealms.datagen;

import com.scattercat.pixelrealms.PixelRealms;
import com.scattercat.pixelrealms.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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

        blockWithItem(ModBlocks.CHISELED_STAIRS);
        blockWithItem(ModBlocks.SOLAR_PANEL);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
