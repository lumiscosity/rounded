package com.lumiscosity.rounded.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import static com.lumiscosity.rounded.Rounded.MOD_ID;

public class TroughBlock extends Block implements InventoryProvider {

    public static final MapCodec<TroughBlock> CODEC = createCodec(TroughBlock::new);
    public static final int NUM_LEVELS = 7;
    public static final int MIN_LEVEL = 0;
    public static final int MAX_LEVEL = 7;
    public static final IntProperty LEVEL = IntProperty.of("level", 0, 7);
    private static final VoxelShape RAYCAST_SHAPE = VoxelShapes.fullCube();
    private static final VoxelShape[] LEVEL_TO_COLLISION_SHAPE = Util.make(
            new VoxelShape[9],
            shapes -> {
                for (int i = 0; i < 8; i++) {
                    shapes[i] = VoxelShapes.combineAndSimplify(
                            RAYCAST_SHAPE, Block.createCuboidShape(2.0, (double)Math.max(2, 1 + i * 2), 2.0, 14.0, 16.0, 14.0), BooleanBiFunction.ONLY_FIRST
                    );
                }

                shapes[8] = shapes[7];
            }
    );

    @Override
    public MapCodec<TroughBlock> getCodec() {
        return CODEC;
    }

    public TroughBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(LEVEL, 0));
    }

    public static void playEffects(World world, BlockPos pos, boolean fill) {
        BlockState blockState = world.getBlockState(pos);
        world.playSoundAtBlockCenter(pos, fill ? SoundEvents.BLOCK_COMPOSTER_FILL_SUCCESS : SoundEvents.BLOCK_COMPOSTER_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
        double d = blockState.getOutlineShape(world, pos).getEndingCoord(Direction.Axis.Y, 0.5, 0.5) + 0.03125;
        double e = 0.13125F;
        double f = 0.7375F;
        Random random = world.getRandom();

        for (int i = 0; i < 10; i++) {
            double g = random.nextGaussian() * 0.02;
            double h = random.nextGaussian() * 0.02;
            double j = random.nextGaussian() * 0.02;
            world.addParticle(
                    ParticleTypes.COMPOSTER,
                    (double)pos.getX() + 0.13125F + 0.7375F * (double)random.nextFloat(),
                    (double)pos.getY() + d + (double)random.nextFloat() * (1.0 - d),
                    (double)pos.getZ() + 0.13125F + 0.7375F * (double)random.nextFloat(),
                    g,
                    h,
                    j
            );
        }
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return LEVEL_TO_COLLISION_SHAPE[state.get(LEVEL)];
    }

    @Override
    protected VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return RAYCAST_SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return LEVEL_TO_COLLISION_SHAPE[0];
    }

    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if ((Integer)state.get(LEVEL) == 7) {
            world.scheduleBlockTick(pos, state.getBlock(), 20);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int i = state.get(LEVEL);
        if (stack.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "trough_feed")))) {
            if (i < 7 && !world.isClient) {
                BlockState blockState = addToTrough(player, state, world, pos, stack);
                world.syncWorldEvent(WorldEvents.COMPOSTER_USED, pos, state != blockState ? 1 : 0);
                player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
                stack.decrementUnlessCreative(1, player);
            }

            return ItemActionResult.success(world.isClient);
        } else {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }
    }

    static BlockState addToTrough(@Nullable Entity user, BlockState state, WorldAccess world, BlockPos pos, ItemStack stack) {
        int i = state.get(LEVEL);
        if (((i != 0) && !(world.getRandom().nextDouble() < 0.5F)) || !stack.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "trough_feed")))) {
            return state;
        } else {
            int j = i + 1;
            BlockState blockState = state.with(LEVEL, j);
            world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(user, blockState));

            return blockState;
        }
    }

    public static BlockState consumeTroughStack(BlockState state) {
        int current_level = state.get(LEVEL);
        if (current_level > 0) {
            return state.with(LEVEL, current_level - 1);
        } else {
            return state;
        }
    }

    public <T extends Entity> boolean growAnimals(ServerWorld world, BlockPos pos) {
        boolean i = false;
        for (AnimalEntity entity : world.getEntitiesByType(
                TypeFilter.instanceOf(AnimalEntity.class),
                new Box(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1)
                        .expand(3.0F),
                EntityPredicates.VALID_LIVING_ENTITY)
        ) {
            if (entity.getBreedingAge() < 0) {
                entity.setBreedingAge(entity.getBreedingAge() + 600);
                i = true;
            }
            if (entity.getMaxHealth() != entity.getHealth()) {
                entity.heal(3F);
                i = true;
            }
        }
        return i;
    }

    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return (Integer)state.get(LEVEL);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        int i = state.get(LEVEL);
        return (SidedInventory)(i < 7 ? new TroughBlock.TroughInventory(state, world, pos) : new TroughBlock.DummyInventory());
    }

    static class TroughInventory extends SimpleInventory implements SidedInventory {
        private final BlockState state;
        private final WorldAccess world;
        private final BlockPos pos;
        private boolean dirty;

        public TroughInventory(BlockState state, WorldAccess world, BlockPos pos) {
            super(1);
            this.state = state;
            this.world = world;
            this.pos = pos;
        }

        @Override
        public int getMaxCountPerStack() {
            return 1;
        }

        @Override
        public int[] getAvailableSlots(Direction side) {
            return side == Direction.UP ? new int[]{0} : new int[0];
        }

        @Override
        public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
            return !this.dirty && dir == Direction.UP && ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.containsKey(stack.getItem());
        }

        @Override
        public boolean canExtract(int slot, ItemStack stack, Direction dir) {
            return false;
        }

        @Override
        public void markDirty() {
            ItemStack itemStack = this.getStack(0);
            if (!itemStack.isEmpty()) {
                this.dirty = true;
                BlockState blockState = TroughBlock.addToTrough(null, this.state, this.world, this.pos, itemStack);
                this.world.syncWorldEvent(WorldEvents.COMPOSTER_USED, this.pos, blockState != this.state ? 1 : 0);
                this.removeStack(0);
            }
        }
    }

    static class DummyInventory extends SimpleInventory implements SidedInventory {
        public DummyInventory() {
            super(0);
        }

        @Override
        public int[] getAvailableSlots(Direction side) {
            return new int[0];
        }

        @Override
        public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
            return false;
        }

        @Override
        public boolean canExtract(int slot, ItemStack stack, Direction dir) {
            return false;
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(LEVEL) > 0) {
            if (growAnimals(world, pos)) {
                world.setBlockState(pos, consumeTroughStack(state), Block.NOTIFY_ALL);
            }
        }
    }
}
