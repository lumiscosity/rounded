package com.lumiscosity.rounded;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;

import static com.lumiscosity.rounded.blocks.RegisterBlocks.BLADDERWRACK_ITEM;

public class RegisterMisc {
    public static void initMisc() {
        CompostingChanceRegistry.INSTANCE.add(BLADDERWRACK_ITEM, 0.3f);
        LootTableEvents.MODIFY.register((resourceManager, lootManager, key, tableBuilder, source) -> {
            if (LootTables.FISHING_JUNK_GAMEPLAY.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder().with(ItemEntry.builder(BLADDERWRACK_ITEM).weight(10));
                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
