package com.lumiscosity.rounded.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static com.lumiscosity.rounded.blocks.RegisterBlocks.TROUGH;
import static com.lumiscosity.rounded.blocks.TroughBlock.LEVEL;
import static com.lumiscosity.rounded.misc.RegisterSounds.TROUGH_RUSTLE;

@Mixin(Entity.class)
public class TroughFallCancelMixin {

    @WrapOperation(
            method = "fall",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;onLandedUpon(Lnet/minecraft/world/World;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;F)V")
    )
    private void troughFallCancel(Block block, World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, Operation<Void> original) {
        BlockPos calc = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        if (world.getBlockState(calc).isOf(TROUGH)) {
            if (world.getBlockState(calc).get(LEVEL) > 0) {
                world.playSound(null, calc, TROUGH_RUSTLE, SoundCategory.BLOCKS);
            }
            if (world.getBlockState(calc).get(LEVEL) == 7) {
                original.call(block, world, state, pos, entity, fallDistance * 0.2F);
            } else {
                original.call(block, world, state, pos, entity, fallDistance);
            }
        } else {
            original.call(block, world, state, pos, entity, fallDistance);
        }
    }

}

