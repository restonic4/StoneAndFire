package com.chaotic_loom.stone_and_fire.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {
    @Inject(method = "getDestroyProgress", at = @At("RETURN"), cancellable = true)
    private void avoidPunchingWood(BlockState blockState, Player player, BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Float> cir) {
        if (blockState.is(BlockTags.LOGS) || blockState.is(BlockTags.PLANKS)) {
            if (!(player.getMainHandItem().getItem() instanceof DiggerItem)) {
                cir.setReturnValue(0f);
            }
        }
    }
}
