package com.lumiscosity.rounded.compat;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

public class VerdanceCompat {
    public static final Block TREATED_MULBERRY_PLANKS = new Block(
            Block.Settings.copy(Registries.BLOCK.get(Identifier.of("minecraft", "oak_planks")))
    );
    public static final Item TREATED_MULBERRY_PLANKS_ITEM = new BlockItem(TREATED_MULBERRY_PLANKS, new Item.Settings());

    public static void register() {
        register_treated_plank("compat/verdance/treated_mulberry_planks", TREATED_MULBERRY_PLANKS, TREATED_MULBERRY_PLANKS_ITEM, "verdance", "mulberry");

    }
}
