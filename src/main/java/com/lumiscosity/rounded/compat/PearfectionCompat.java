package com.lumiscosity.rounded.compat;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

public class PearfectionCompat {
    public static final Block TREATED_CALLERY_PLANKS = new Block(
            Block.Settings.copy(Registries.BLOCK.get(Identifier.of("pearfection", "callery_planks")))
    );
    public static final Item TREATED_CALLERY_PLANKS_ITEM = new BlockItem(TREATED_CALLERY_PLANKS, new Item.Settings());

    public static void register() {
        register_treated_plank("compat/pearfection/treated_callery_planks", TREATED_CALLERY_PLANKS, TREATED_CALLERY_PLANKS_ITEM, "pearfection", "callery");

    }
}