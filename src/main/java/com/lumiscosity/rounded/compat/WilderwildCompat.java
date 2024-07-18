package com.lumiscosity.rounded.compat;

            import net.minecraft.block.AbstractBlock;
            import net.minecraft.block.Block;
            import net.minecraft.item.BlockItem;
            import net.minecraft.item.Item;
            import net.minecraft.registry.Registries;
            import net.minecraft.util.Identifier;

            import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

            public class WilderwildCompat {
            public static final Block TREATED_BAOBAB_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("wilderwild", "baobab_planks")))
            );
            public static final Item TREATED_BAOBAB_PLANKS_ITEM = new BlockItem(TREATED_BAOBAB_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_CYPRESS_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("wilderwild", "cypress_planks")))
            );
            public static final Item TREATED_CYPRESS_PLANKS_ITEM = new BlockItem(TREATED_CYPRESS_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_PALM_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("wilderwild", "palm_planks")))
            );
            public static final Item TREATED_PALM_PLANKS_ITEM = new BlockItem(TREATED_PALM_PLANKS, new Item.Settings());
        
           public static void register() {        register_treated_plank("compat/wilderwild/treated_baobab_planks", TREATED_BAOBAB_PLANKS, TREATED_BAOBAB_PLANKS_ITEM, "wilderwild", "baobab");
        register_treated_plank("compat/wilderwild/treated_cypress_planks", TREATED_CYPRESS_PLANKS, TREATED_CYPRESS_PLANKS_ITEM, "wilderwild", "cypress");
        register_treated_plank("compat/wilderwild/treated_palm_planks", TREATED_PALM_PLANKS, TREATED_PALM_PLANKS_ITEM, "wilderwild", "palm");

        }
    }