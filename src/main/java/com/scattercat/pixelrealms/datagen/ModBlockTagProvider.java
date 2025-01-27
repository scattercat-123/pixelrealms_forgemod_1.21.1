package com.scattercat.pixelrealms.datagen;
import com.scattercat.pixelrealms.PixelRealms;
import com.scattercat.pixelrealms.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PixelRealms.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LIGHT_BLOCK.get())
                .add(ModBlocks.RAW_LIGHT_BLOCK.get())
                .add(ModBlocks.LIGHT_ORE.get())
                .add(ModBlocks.LIGHT_DEEPSLATE_ORE.get())
                .add(ModBlocks.CHISELED_STAIRS.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LIGHT_DEEPSLATE_ORE.get())
                .add(ModBlocks.RAW_LIGHT_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.LIGHT_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SOLAR_PANEL.get());

        tag(BlockTags.FENCES).add(ModBlocks.LIGHT_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.LIGHT_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.LIGHT_WALL.get());
    }
}