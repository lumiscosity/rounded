package com.lumiscosity.rounded.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class OceanRockFeature extends Feature<SimpleBlockFeatureConfig> {
    public OceanRockFeature(Codec<SimpleBlockFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<SimpleBlockFeatureConfig> context) {
        BlockPos origin = context.getOrigin();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        Random random = context.getRandom();

        SimpleBlockFeatureConfig SimpleBlockFeatureConfig;
        for (SimpleBlockFeatureConfig = context.getConfig(); origin.getY() > structureWorldAccess.getBottomY() + 3; origin = origin.down()) {
            if (!structureWorldAccess.isAir(origin.down())) {
                BlockState blockState = structureWorldAccess.getBlockState(origin.down());
                if (isSoil(blockState) || isStone(blockState) || blockState.isIn(BlockTags.BASE_STONE_NETHER)) {
                    break;
                }
            }
        }

        if (origin.getY() <= structureWorldAccess.getBottomY() + 3) {
            return false;
        } else {
            int[] heights = {
                    random.nextInt(7), random.nextInt(8), random.nextInt(7),
                    random.nextInt(8), random.nextInt(9), random.nextInt(8),
                    random.nextInt(7), random.nextInt(8), random.nextInt(7)
            };

            BlockPos.Mutable pos = new BlockPos.Mutable();
            for (int i = 0; i < 9; i++) {
                pos.set(origin.getX() + i % 3,origin.getY() - random.nextInt(3),origin.getZ() + i / 3);
                for (int j = 0; j < heights[i]; j++) {
                    structureWorldAccess.setBlockState(pos, SimpleBlockFeatureConfig.toPlace().get(random, pos), Block.NOTIFY_ALL);
                    pos.move(Direction.UP);
                }
            }

            return true;
        }
    }
}
