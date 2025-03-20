package com.chaotic_loom.stone_and_fire.mixin;

import com.chaotic_loom.stone_and_fire.StoneAndFire;
import com.chaotic_loom.stone_and_fire.registries.SFToolTiers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.CustomValue;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@Mixin(Tiers.class)
public class TiersMixin {
    @Invoker("<init>")
    private static Tiers newType(String internalName, int internalId, int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredients) {
        throw new AssertionError("[" + StoneAndFire.MOD_ID + "]: Mixin injection failed!");
    }

    @Shadow()
    @Final
    @Mutable
    private static Tiers[] $VALUES;

    @Unique
    private static int currentOrdinal = 0;

    @Unique
    private static List<Tiers> tiersToRegister;

    @Inject(
            method = "<clinit>",
            at = @At(
                    value = "FIELD",
                    opcode = Opcodes.PUTSTATIC,
                    target = "Lnet/minecraft/world/item/Tiers;$VALUES:[Lnet/minecraft/world/item/Tiers;",
                    shift = At.Shift.AFTER
            )
    )
    private static void addCustomTiers(CallbackInfo ci) {
        var tiers = new ArrayList<>(Arrays.asList($VALUES));
        var last = tiers.get(tiers.size() - 1);
        currentOrdinal = last.ordinal() + 1;
        tiersToRegister = new ArrayList<>();

        for (SFToolTiers.CustomTier customTier : SFToolTiers.collectTiers()) {
            registerTier(customTier.getId(), customTier.getLevel(), customTier.getUses(), customTier.getSpeed(), customTier.getDamage(), customTier.getEnchantmentValue(), customTier.getRepairIngredient());
        }

        tiers.addAll(tiersToRegister);

        ArrayList<String> internalIds = new ArrayList<>();
        for (Tiers tier : tiers) {
            internalIds.add(tier.name());
        }

        $VALUES = tiers.toArray(new Tiers[0]);
    }

    @Unique
    private static Tiers registerTier(String id, int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredients) {
        var source = newType(id.toUpperCase(), currentOrdinal, level, uses, speed, damage, enchantmentValue, repairIngredients);
        currentOrdinal += 1;

        tiersToRegister.add(source);

        System.out.println("Tier " + id + " added!");

        return source;
    }
}
