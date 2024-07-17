package com.lumiscosity.rounded.compat;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

public class WilderWildCompat {
    public static final Block TREATED_BAOBAB_PLANKS = new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()
    );
    public static final Item TREATED_BAOBAB_PLANKS_ITEM = new BlockItem(TREATED_BAOBAB_PLANKS, new Item.Settings());

    public static final Block TREATED_CYPRESS_PLANKS = new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()
    );
    public static final Item TREATED_CYPRESS_PLANKS_ITEM = new BlockItem(TREATED_CYPRESS_PLANKS, new Item.Settings());

    public static final Block TREATED_PALM_PLANKS = new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()
    );
    public static final Item TREATED_PALM_PLANKS_ITEM = new BlockItem(TREATED_PALM_PLANKS, new Item.Settings());

    public static void register() {
        register_treated_plank("compat/wilderwild/treated_baobab_planks", TREATED_BAOBAB_PLANKS, TREATED_BAOBAB_PLANKS_ITEM, "wilderwild", "baobab");
        register_treated_plank("compat/wilderwild/treated_cypress_planks", TREATED_CYPRESS_PLANKS, TREATED_CYPRESS_PLANKS_ITEM, "wilderwild", "cypress");
        register_treated_plank("compat/wilderwild/treated_palm_planks", TREATED_PALM_PLANKS, TREATED_PALM_PLANKS_ITEM, "wilderwild", "palm");
    }
}
