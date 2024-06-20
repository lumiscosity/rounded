package com.lumiscosity.rounded.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;

public class HugeLustershroomFeature extends HugeMushroomFeature {
    public HugeLustershroomFeature(Codec<HugeMushroomFeatureConfig> codec) {
        super(codec);
    }

    @Override
    protected void generateCap(WorldAccess world, Random random, BlockPos start, int y, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config) {
        for (int i = y - 3; i <= y; i++) {
            int j = i < y ? config.foliageRadius : config.foliageRadius - 1;
            int k = config.foliageRadius - 2;
            if (i == y - 3) {
                for (int l = -j; l <= j; l += 4) {
                    for (int m = -j; m <= j; m += 4) {
                        mutable.set(start, l, i, m);
                        BlockState blockState = config.capProvider.get(random, start);
                        if (blockState.contains(MushroomBlock.WEST)
                                && blockState.contains(MushroomBlock.EAST)
                                && blockState.contains(MushroomBlock.NORTH)
                                && blockState.contains(MushroomBlock.SOUTH)
                                && blockState.contains(MushroomBlock.UP)) {
                            blockState = blockState.with(MushroomBlock.UP, true)
                                    .with(MushroomBlock.WEST, false)
                                    .with(MushroomBlock.EAST, false)
                                    .with(MushroomBlock.NORTH, false)
                                    .with(MushroomBlock.SOUTH, false);
                        }
                        this.setBlockState(world, mutable, blockState);
                    }
                }
                j += 1;
            }

            for (int l = -j; l <= j; l++) {
                for (int m = -j; m <= j; m++) {
                    boolean bl = l == -j;
                    boolean bl2 = l == j;
                    boolean bl3 = m == -j;
                    boolean bl4 = m == j;
                    boolean bl5 = bl || bl2;
                    boolean bl6 = bl3 || bl4;
                    if (i >= y || bl5 != bl6) {
                        mutable.set(start, l, i, m);
                        if (!world.getBlockState(mutable).isOpaqueFullCube(world, mutable)) {
                            BlockState blockState = config.capProvider.get(random, start);
                            if (blockState.contains(MushroomBlock.WEST)
                                    && blockState.contains(MushroomBlock.EAST)
                                    && blockState.contains(MushroomBlock.NORTH)
                                    && blockState.contains(MushroomBlock.SOUTH)
                                    && blockState.contains(MushroomBlock.UP)) {
                                blockState = blockState.with(MushroomBlock.UP, i >= y - 1)
                                        .with(MushroomBlock.WEST, l < -k)
                                        .with(MushroomBlock.EAST, l > k)
                                        .with(MushroomBlock.NORTH, m < -k)
                                        .with(MushroomBlock.SOUTH, m > k);
                            }

                            this.setBlockState(world, mutable, blockState);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected int getCapSize(int i, int j, int capSize, int y) {
        int k = 0;
        if (y < j && y >= j - 3) {
            k = capSize;
        } else if (y == j) {
            k = capSize;
        }

        return k;
    }
}
