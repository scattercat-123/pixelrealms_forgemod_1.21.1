package com.scattercat.pixelrealms.datagen;

import com.scattercat.pixelrealms.block.ModBlocks;
import com.scattercat.pixelrealms.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.LIGHT_BLOCK.get());
        dropSelf(ModBlocks.CHISELED_STAIRS.get());
        dropSelf(ModBlocks.SOLAR_PANEL.get());

        dropSelf(ModBlocks.LIGHT_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.LIGHT_TRAPDOOR.get());
        dropSelf(ModBlocks.LIGHT_FENCE.get());
        dropSelf(ModBlocks.LIGHT_DOOR.get());
        dropSelf(ModBlocks.LIGHT_BUTTON.get());
        dropSelf(ModBlocks.LIGHT_FENCE_GATE.get());

        dropSelf(ModBlocks.LIGHT_STAIR.get());
        dropSelf(ModBlocks.LIGHT_WALL.get());
        this.add(ModBlocks.LIGHT_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_SLAB.get()));
        this.add(ModBlocks.LIGHT_DOOR.get(),
                block -> createDoorTable(ModBlocks.LIGHT_DOOR.get()));

        this.add(ModBlocks.LIGHT_ORE.get(),
                block -> createOreDrop(ModBlocks.LIGHT_ORE.get(), ModItems.RAW_LIGHTORB.get()));
        this.add(ModBlocks.LIGHT_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.LIGHT_DEEPSLATE_ORE.get(), ModItems.RAW_LIGHTORB.get(), 2, 5));
        this.add(ModBlocks.RAW_LIGHT_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.RAW_LIGHT_BLOCK.get(), ModItems.RAW_LIGHTORB.get(), 4, 7));

    }
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
