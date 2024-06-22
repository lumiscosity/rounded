package com.lumiscosity.rounded.mixin.client;

import com.lumiscosity.rounded.blocks.TroughBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class TroughEffectMixin {
	@Shadow
	private ClientWorld world;

	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/block/ComposterBlock;playEffects(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Z)V"), method = "processWorldEvent", cancellable = true)
	private void processWorldEvent(int eventId, BlockPos pos, int data, CallbackInfo info) {
		if (world != null && world.getBlockState(pos).getBlock() instanceof TroughBlock) {
			TroughBlock.playEffects(world, pos);
			info.cancel();
		}
	}
}