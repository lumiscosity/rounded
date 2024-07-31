package com.lumiscosity.rounded.mixin;

import com.lumiscosity.rounded.blocks.RegisterBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.ConduitBlockEntity;
import org.spongepowered.asm.mixin.*;

@Mixin(ConduitBlockEntity.class)
public class ExtraConduitPowerMixin {
    @Shadow
    @Final
    @Mutable
    private static Block[] ACTIVATING_BLOCKS;

    static {
        ACTIVATING_BLOCKS = new Block[]{Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS, Blocks.SEA_LANTERN, Blocks.DARK_PRISMARINE, RegisterBlocks.CHISELED_PRISMARINE_BRICKS, RegisterBlocks.SMOOTH_PRISMARINE};
    }
}
