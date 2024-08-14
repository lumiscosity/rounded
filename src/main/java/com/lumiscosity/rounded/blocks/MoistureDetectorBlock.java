package com.lumiscosity.rounded.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import static com.lumiscosity.rounded.blocks.RegisterBlocks.MOISTURE_DETECTOR;
import static com.lumiscosity.rounded.blocks.RegisterBlocks.MOISTURE_DETECTOR_BE;

public class MoistureDetectorBlock extends BlockWithEntity {
    public static final IntProperty POWER = Properties.POWER;
    public static final BooleanProperty CHECK_LEVEL = BooleanProperty.of("check_level");

    public MoistureDetectorBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(POWER, 0).with(CHECK_LEVEL, false));
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(POWER);
    }

    public static void updateState(BlockState state, World world, BlockPos pos) {
        BlockPos check_pos = pos.up();
        if (state.get(CHECK_LEVEL)) {
            if (world.getBlockState(check_pos).isOf(Blocks.WATER)) {
                getWaterLevel(state, world, pos, world.getFluidState(check_pos));
            } else if (world.getBlockState(check_pos).contains(Properties.WATERLOGGED) ? world.getBlockState(check_pos).get(Properties.WATERLOGGED) : false) {
                if (state.get(POWER) != 9) {
                    world.setBlockState(pos, state.with(POWER, 9), Block.NOTIFY_ALL);
                }
            } else {
                if (state.get(POWER) != 0) {
                    world.setBlockState(pos, state.with(POWER, 0), Block.NOTIFY_ALL);
                }
            }
        } else if (world.getBlockState(check_pos).isOf(Blocks.AIR) && world.hasRain(check_pos)) {
            getRainLevel(state, world, pos);
        } else {
            if (state.get(POWER) != 0) {
                world.setBlockState(pos, state.with(POWER, 0), Block.NOTIFY_ALL);
            }
        }
    }

    public static void getWaterLevel(BlockState state, World world, BlockPos pos, FluidState water) {
        int i = water.getLevel();
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
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.canModifyBlocks()) {
            if (world.isClient) {
                return ActionResult.SUCCESS;
            } else {
                BlockState blockState = state.cycle(CHECK_LEVEL);
                world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
                updateState(blockState, world, pos);
                return ActionResult.CONSUME;
            }
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
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
        return checkType(type, MOISTURE_DETECTOR_BE, MoistureDetectorBlock::tick);
    }

    private static void tick(World world, BlockPos pos, BlockState state, MoistureDetectorBlockEntity blockEntity) {
        if (world.getTime() % 2L == 0L) {
            updateState(state, world, pos);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWER, MoistureDetectorBlock.CHECK_LEVEL);
    }
}
