package com.chaotic_loom.stone_and_fire;

import com.chaotic_loom.stone_and_fire.registries.SFCreativeModeTabs;
import com.chaotic_loom.stone_and_fire.registries.SFItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class StoneAndFire implements ModInitializer {
    public static final String MOD_ID = "stone_and_fire";

    @Override
    public void onInitialize() {
        SFItems.register();
        SFCreativeModeTabs.register();
    }

    public static ResourceLocation id(String id) {
        return new ResourceLocation(MOD_ID, id);
    }
}
