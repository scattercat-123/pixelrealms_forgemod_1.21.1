package com.scattercat.pixelrealms.item.custom;

import com.scattercat.pixelrealms.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.SAND, Blocks.SANDSTONE,
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.AMETHYST_BLOCK, ModBlocks.LIGHT_BLOCK.get(),
                    ModBlocks.LIGHT_BLOCK.get(), Blocks.GLOWSTONE,
                    Blocks.OAK_STAIRS, ModBlocks.CHISELED_STAIRS.get(),
                    Blocks.SPRUCE_STAIRS, ModBlocks.CHISELED_STAIRS.get(),
                    Blocks.BIRCH_STAIRS, ModBlocks.CHISELED_STAIRS.get(),
                    Blocks.JUNGLE_STAIRS, ModBlocks.CHISELED_STAIRS.get()
            );

    public ChiselItem(Properties pProperties) {
        super(pProperties);
    }

    @Override

    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
    }