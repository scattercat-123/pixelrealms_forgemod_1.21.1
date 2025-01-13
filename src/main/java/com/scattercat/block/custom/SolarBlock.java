package com.scattercat.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SolarBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<SolarBlock> CODEC = simpleCodec(SolarBlock::new);
    public static final VoxelShape SHAPE = Shapes.or(
            Block.box(1.0, 0.0, 1.0, 15.0, 2.0, 15.0),
            Block.box(1.0, 2.0, 2.0, 15.0, 4.0, 14.0),
            Block.box(1.0, 4.0, 3.0, 15.0, 6.0, 13.0),
            Block.box(1.0, 6.0, 4.0, 15.0, 8.0, 12.0),
            Block.box(1.0, 8.0, 5.0, 15.0, 10.0, 11.0),
            Block.box(1.0, 10.0, 6.0, 15.0, 12.0, 10.0),
            Block.box(1.0, 12.0, 7.0, 15.0, 14.0, 9.0)
    );

    public SolarBlock(Properties pProperties) {
        super(pProperties);
    }
    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
