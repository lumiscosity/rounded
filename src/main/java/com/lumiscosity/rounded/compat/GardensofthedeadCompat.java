package com.lumiscosity.rounded.compat;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

public class GardensofthedeadCompat {
    public static final Block TREATED_SOULBLIGHT_PLANKS = new Block(
            Block.Settings.copy(Registries.BLOCK.get(Identifier.of("gardens_of_the_dead", "soulblight_planks")))
    );
    public static final Item TREATED_SOULBLIGHT_PLANKS_ITEM = new BlockItem(TREATED_SOULBLIGHT_PLANKS, new Item.Settings());

    public static final Block TREATED_WHISTLECANE_PLANKS = new Block(
            Block.Settings.copy(Registries.BLOCK.get(Identifier.of("gardens_of_the_dead", "whistlecane_planks")))
    );
    public static final Item TREATED_WHISTLECANE_PLANKS_ITEM = new BlockItem(TREATED_WHISTLECANE_PLANKS, new Item.Settings());


    public static void register() {
        register_treated_plank("compat/gardens_of_the_dead/treated_soulblight_planks", TREATED_SOULBLIGHT_PLANKS, TREATED_SOULBLIGHT_PLANKS_ITEM, "gardens_of_the_dead", "soulblight");
        register_treated_plank("compat/gardens_of_the_dead/treated_whistlecane_planks", TREATED_WHISTLECANE_PLANKS, TREATED_WHISTLECANE_PLANKS_ITEM, "gardens_of_the_dead", "whistlecane");

    }
}