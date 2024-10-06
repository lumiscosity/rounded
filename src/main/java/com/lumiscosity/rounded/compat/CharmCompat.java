package com.lumiscosity.rounded.compat;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

public class CharmCompat {
    public static final Block TREATED_EBONY_PLANKS = new Block(
            Block.Settings.copy(Registries.BLOCK.get(Identifier.of("charm", "ebony_planks")))
    );
    public static final Item TREATED_EBONY_PLANKS_ITEM = new BlockItem(TREATED_EBONY_PLANKS, new Item.Settings());

    public static final Block TREATED_AZALEA_PLANKS = new Block(
            Block.Settings.copy(Registries.BLOCK.get(Identifier.of("charm", "azalea_planks")))
    );
    public static final Item TREATED_AZALEA_PLANKS_ITEM = new BlockItem(TREATED_AZALEA_PLANKS, new Item.Settings());


    public static void register() {
        register_treated_plank("compat/charm/treated_ebony_planks", TREATED_EBONY_PLANKS, TREATED_EBONY_PLANKS_ITEM, "charm", "ebony");
        register_treated_plank("compat/charm/treated_azalea_planks", TREATED_AZALEA_PLANKS, TREATED_AZALEA_PLANKS_ITEM, "charm", "azalea");

    }
}