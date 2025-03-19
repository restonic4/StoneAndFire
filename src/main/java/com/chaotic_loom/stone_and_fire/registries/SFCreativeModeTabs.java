package com.chaotic_loom.stone_and_fire.registries;

import com.chaotic_loom.stone_and_fire.StoneAndFire;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SFCreativeModeTabs {
    public static final List<Item> items = new ArrayList<>();

    public static final CreativeModeTab TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            StoneAndFire.id(StoneAndFire.MOD_ID),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup." + StoneAndFire.MOD_ID))
                    .icon(() -> new ItemStack(SFItems.ICON))
                    .displayItems((params, output) -> {
                        for (Item item : items) {
                            output.accept(item);
                        }
                    })
                    .build()
    );

    public static void register() {

    }
}
