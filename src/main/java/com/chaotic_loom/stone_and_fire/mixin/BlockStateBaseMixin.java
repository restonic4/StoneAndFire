package com.chaotic_loom.stone_and_fire.mixin;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BlockStateBaseMixin {
    @Shadow public abstract Block getBlock();

    @Inject(method = "requiresCorrectToolForDrops", at = @At("RETURN"), cancellable = true)
    private void dropWithToolOnly(CallbackInfoReturnable<Boolean> cir) {
        Block block = this.getBlock();
        BlockState blockState = block.defaultBlockState();

        if (blockState.is(BlockTags.LOGS) || blockState.is(BlockTags.PLANKS) || blockState.is(BlockTags.WOODEN_STAIRS) || blockState.is(BlockTags.WOODEN_SLABS)) {
            cir.setReturnValue(true);
        }
    }
}
