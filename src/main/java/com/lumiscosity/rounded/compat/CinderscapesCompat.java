package com.lumiscosity.rounded.compat;

            import net.minecraft.block.AbstractBlock;
            import net.minecraft.block.Block;
            import net.minecraft.item.BlockItem;
            import net.minecraft.item.Item;
            import net.minecraft.registry.Registries;
            import net.minecraft.util.Identifier;

            import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

            public class CinderscapesCompat {
            public static final Block TREATED_SCORCHED_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("cinderscapes", "scorched_planks")))
            );
            public static final Item TREATED_SCORCHED_PLANKS_ITEM = new BlockItem(TREATED_SCORCHED_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_UMBRAL_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("cinderscapes", "umbral_planks")))
            );
            public static final Item TREATED_UMBRAL_PLANKS_ITEM = new BlockItem(TREATED_UMBRAL_PLANKS, new Item.Settings());
        
           public static void register() {        register_treated_plank("compat/cinderscapes/treated_scorched_planks", TREATED_SCORCHED_PLANKS, TREATED_SCORCHED_PLANKS_ITEM, "cinderscapes", "scorched");
        register_treated_plank("compat/cinderscapes/treated_umbral_planks", TREATED_UMBRAL_PLANKS, TREATED_UMBRAL_PLANKS_ITEM, "cinderscapes", "umbral");

        }
    }