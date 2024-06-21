package com.lumiscosity.rounded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomPlantBlock;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import static com.lumiscosity.rounded.Rounded.MOD_ID;

public class LustershroomPlant extends MushroomPlantBlock {
    public LustershroomPlant(RegistryKey<ConfiguredFeature<?, ?>> featureKey, Settings settings) {
        super(featureKey, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(TagKey.of(RegistryKeys.BLOCK, Identifier.of("minecraft", "dirt")));
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isIn(BlockTags.MUSHROOM_GROW_BLOCK) || this.canPlantOnTop(blockState, world, blockPos);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(30) == 0) {
            int i = 5;
            int j = 4;

            for (BlockPos blockPos : BlockPos.iterate(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
                if (world.getBlockState(blockPos).isOf(this)) {
                    if (--i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockPos2 = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);

            for (int k = 0; k < 4; k++) {
                if (world.isAir(blockPos2) && state.canPlaceAt(world, blockPos2)) {
                    pos = blockPos2;
                }

                blockPos2 = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
            }

            if (world.isAir(blockPos2)
                    && state.canPlaceAt(world, blockPos2)
                    && world.getBlockState(blockPos2).isIn(TagKey.of(RegistryKeys.BLOCK, Identifier.of("minecraft", "mushroom_grow_block")))
            ) {
                world.setBlockState(blockPos2, state, Block.NOTIFY_LISTENERS);
            }
        }
    }
}
