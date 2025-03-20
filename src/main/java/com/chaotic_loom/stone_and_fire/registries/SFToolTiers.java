package com.chaotic_loom.stone_and_fire.registries;

import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SFToolTiers {
    private static final List<CustomTier> tiersToRegister = new ArrayList<>();

    public static final String FLINT = "FLINT";
    public static final String BRONZE = "BRONZE";

    static {
        register(FLINT, 0, 25, 2.0F, 0.0F, 15, () -> Ingredient.of(Items.FLINT));
        register(BRONZE, 1, 100, 4.0F, 1.0F, 5, () -> Ingredient.of(SFItems.BRONZE_MASS, SFItems.BRONZE_INGOT));
    }

    public static Tiers get(String id) {
        return Tiers.valueOf(id.toUpperCase());
    }

    public static List<CustomTier> collectTiers() {
        return tiersToRegister;
    }

    private static void register(String id, int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        tiersToRegister.add(new CustomTier(id, level, uses, speed, damage, enchantmentValue, repairIngredient));
    }

    public static class CustomTier {
        private final String id;
        private final int level;
        private final int uses;
        private final float speed;
        private final float damage;
        private final int enchantmentValue;
        private final Supplier<Ingredient> repairIngredient;

        private CustomTier(String id, int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
            this.id = id;
            this.level = level;
            this.uses = uses;
            this.speed = speed;
            this.damage = damage;
            this.enchantmentValue = enchantmentValue;
            this.repairIngredient = repairIngredient;
        }

        public String getId() {
            return id;
        }

        public int getLevel() {
            return level;
        }

        public int getUses() {
            return uses;
        }

        public float getSpeed() {
            return speed;
        }

        public float getDamage() {
            return damage;
        }

        public int getEnchantmentValue() {
            return enchantmentValue;
        }

        public Supplier<Ingredient> getRepairIngredient() {
            return repairIngredient;
        }
    }
}
