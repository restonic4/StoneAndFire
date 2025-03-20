package com.chaotic_loom.stone_and_fire.registries;

import com.chaotic_loom.easy_modpack.EasyModpack;
import com.chaotic_loom.stone_and_fire.StoneAndFire;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;

public class SFItems {
    public static final Item ICON = Registry.register(
            BuiltInRegistries.ITEM,
            StoneAndFire.id("icon"),
            new Item(new Item.Properties())
    );

    public static final Item FIBER = registerItem(
            "fiber",
            new Item(new Item.Properties())
    );

    public static final AxeItem FLINT_AXE = (AxeItem) registerItem(
            "flint_axe",
            new AxeItem(SFToolTiers.get(SFToolTiers.FLINT), 6, -3.0F, new Item.Properties())
    );

    public static final PickaxeItem FLINT_PICKAXE = (PickaxeItem) registerItem(
            "flint_pickaxe",
            new PickaxeItem(SFToolTiers.get(SFToolTiers.FLINT), 1, -2.8f, new Item.Properties())
    );

    public static final Item RAW_TIN = registerItem(
            "raw_tin",
            new Item(new Item.Properties())
    );

    public static final Item BRONZE_MASS = registerItem(
            "bronze_mass",
            new Item(new Item.Properties())
    );

    public static final Item BRONZE_INGOT = registerItem(
            "bronze_ingot",
            new Item(new Item.Properties())
    );

    public static final AxeItem BRONZE_AXE = (AxeItem) registerItem(
            "bronze_axe",
            new AxeItem(SFToolTiers.get(SFToolTiers.BRONZE), 6.0F, -3.0F, new Item.Properties())
    );

    public static final PickaxeItem BRONZE_PICKAXE = (PickaxeItem) registerItem(
            "bronze_pickaxe",
            new PickaxeItem(SFToolTiers.get(SFToolTiers.BRONZE), 1, -2.8f, new Item.Properties())
    );

    public static final SwordItem BRONZE_SWORD = (SwordItem) registerItem(
            "bronze_sword",
            new SwordItem(SFToolTiers.get(SFToolTiers.BRONZE), 3, -2.4F, new Item.Properties())
    );

    public static final ShovelItem BRONZE_SHOVEL = (ShovelItem) registerItem(
            "bronze_shovel",
            new ShovelItem(SFToolTiers.get(SFToolTiers.BRONZE), 1.5f, -3.0F, new Item.Properties())
    );

    public static final HoeItem BRONZE_HOE = (HoeItem) registerItem(
            "bronze_hoe",
            new HoeItem(SFToolTiers.get(SFToolTiers.BRONZE), 0, -3.0F, new Item.Properties())
    );

    public static void register() {
        disableWoodenTools();
        disableStoneTools();
    }

    public static Item registerItem(String id, Item item) {
        Item registeredItem = Registry.register(BuiltInRegistries.ITEM, StoneAndFire.id(id), item);
        SFCreativeModeTabs.items.add(registeredItem);

        return registeredItem;
    }

    private static void disableWoodenTools() {
        EasyModpack.ITEM_MANAGER.disable(BuiltInRegistries.ITEM.getKey(Items.WOODEN_SWORD));
        EasyModpack.ITEM_MANAGER.disable(BuiltInRegistries.ITEM.getKey(Items.WOODEN_AXE));
        EasyModpack.ITEM_MANAGER.disable(BuiltInRegistries.ITEM.getKey(Items.WOODEN_PICKAXE));
        EasyModpack.ITEM_MANAGER.disable(BuiltInRegistries.ITEM.getKey(Items.WOODEN_SHOVEL));
        EasyModpack.ITEM_MANAGER.disable(BuiltInRegistries.ITEM.getKey(Items.WOODEN_HOE));
    }

    private static void disableStoneTools() {
        EasyModpack.ITEM_MANAGER.disable(BuiltInRegistries.ITEM.getKey(Items.STONE_SWORD));
        EasyModpack.ITEM_MANAGER.disable(BuiltInRegistries.ITEM.getKey(Items.STONE_AXE));
        EasyModpack.ITEM_MANAGER.disable(BuiltInRegistries.ITEM.getKey(Items.STONE_PICKAXE));
        EasyModpack.ITEM_MANAGER.disable(BuiltInRegistries.ITEM.getKey(Items.STONE_SHOVEL));
        EasyModpack.ITEM_MANAGER.disable(BuiltInRegistries.ITEM.getKey(Items.STONE_HOE));
    }
}
