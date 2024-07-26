package com.lumiscosity.rounded.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static com.lumiscosity.rounded.blocks.RegisterBlocks.MOISTURE_DETECTOR_BE;

public class MoistureDetectorBlock extends BlockWithEntity {
    public static final MapCodec<MoistureDetectorBlock> CODEC = createCodec(MoistureDetectorBlock::new);
    public static final IntProperty POWER = Properties.POWER;

    @Override
    public MapCodec<MoistureDetectorBlock> getCodec() {
        return CODEC;
    }

    public MoistureDetectorBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(POWER, 0));
    }

    @Override
    protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(POWER);
    }

    public static void getWaterLevel(BlockState state, World world, BlockPos pos, FluidState water) {
        int i = water.getLevel() * 2;
        i = MathHelper.clamp(i, 0, 15);
        if (state.get(POWER) != i) {
            world.setBlockState(pos, state.with(POWER, i), Block.NOTIFY_ALL);
        }
    }

    public static void getRainLevel(BlockState state, World world, BlockPos pos) {
        int i = world.isRaining() ? world.isThundering() ? 15 : 7 : 0;
        if (state.get(POWER) != i) {
            world.setBlockState(pos, state.with(POWER, i), Block.NOTIFY_ALL);
        }
    }

    @Override
    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    public static class MoistureDetectorBlockEntity extends BlockEntity {
        public MoistureDetectorBlockEntity(BlockPos pos, BlockState state) {
            super(MOISTURE_DETECTOR_BE, pos, state);
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MoistureDetectorBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return !world.isClient ? validateTicker(type, MOISTURE_DETECTOR_BE, MoistureDetectorBlock::tick) : null;
    }

    private static void tick(World world, BlockPos pos, BlockState state, MoistureDetectorBlockEntity blockEntity) {
        if (world.getTime() % 2L == 0L) {
            BlockPos check_pos = pos.up();
            if (world.getBlockState(check_pos).isOf(Blocks.WATER)) {
                getWaterLevel(state, world, pos, world.getFluidState(check_pos));
            } else if (world.getBlockState(check_pos).contains(Properties.WATERLOGGED) ? world.getBlockState(check_pos).get(Properties.WATERLOGGED) : false) {
                if (state.get(POWER) != 15) {
                    world.setBlockState(pos, state.with(POWER, 15), Block.NOTIFY_ALL);
                }
            } else if (world.hasRain(pos)) {
                getRainLevel(state, world, pos);
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWER);
    }
}
