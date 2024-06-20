package com.lumiscosity.rounded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class TroughBlock extends ComposterBlock {

    public static final IntProperty LEVEL = Properties.LEVEL_8;

    public TroughBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(LEVEL, 0));
    }

    static class TroughValidPredicate implements Predicate<LivingEntity> {
        @Override
        public boolean test(LivingEntity livingEntity) {
            return false;
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int i = (Integer)state.get(LEVEL);
        if (i < 8) {
            if (i < 7 && !world.isClient) {
                BlockState blockState = addToComposter(player, state, world, pos, stack);
                world.syncWorldEvent(WorldEvents.COMPOSTER_USED, pos, state != blockState ? 1 : 0);
                player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
                stack.decrementUnlessCreative(1, player);
            }

            return ItemActionResult.success(world.isClient);
        } else {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
            return ActionResult.PASS;
    }

    static BlockState addToComposter(@Nullable Entity user, BlockState state, WorldAccess world, BlockPos pos, ItemStack stack) {
        int i = (Integer)state.get(LEVEL);
        if ((i != 0) && !(world.getRandom().nextDouble() < 0.5F)) {
            return state;
        } else {
            int j = i + 1;
            BlockState blockState = state.with(LEVEL, j);
            world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(user, blockState));
            if (j == 7) {
                world.scheduleBlockTick(pos, state.getBlock(), 20);
            }

            return blockState;
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

    public static BlockState consumeTroughStack(BlockState state) {
        int current_level = state.get(LEVEL);
        if (current_level > 0) {
            return state.with(LEVEL, current_level - 1);
        } else {
            return state;
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(LEVEL) > 0) {
            if (growAnimals(world, pos)) {
                world.setBlockState(pos, consumeTroughStack(state));
            }
        }
    }
}
