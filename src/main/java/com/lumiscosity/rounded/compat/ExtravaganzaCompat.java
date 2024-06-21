package com.lumiscosity.rounded.compat;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

public class ExtravaganzaCompat {
    public static final Block TREATED_HEVEA_BRASILIENSIS_PLANKS = new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.DARK_AQUA).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD)
    );
    public static final Item TREATED_HEVEA_BRASILIENSIS_PLANKS_ITEM = new BlockItem(TREATED_HEVEA_BRASILIENSIS_PLANKS, new Item.Settings());

    public static void register() {
        register_treated_plank("compat/treated_hevea_brasiliensis_planks", TREATED_HEVEA_BRASILIENSIS_PLANKS, TREATED_HEVEA_BRASILIENSIS_PLANKS_ITEM);
    }
}
