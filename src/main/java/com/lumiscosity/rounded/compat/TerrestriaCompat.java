package com.lumiscosity.rounded.compat;

            import net.minecraft.block.AbstractBlock;
            import net.minecraft.block.Block;
            import net.minecraft.item.BlockItem;
            import net.minecraft.item.Item;
            import net.minecraft.registry.Registries;
            import net.minecraft.util.Identifier;

            import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

            public class TerrestriaCompat {
            public static final Block TREATED_CYPRESS_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("terrestria", "cypress_planks")))
            );
            public static final Item TREATED_CYPRESS_PLANKS_ITEM = new BlockItem(TREATED_CYPRESS_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_HEMLOCK_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("terrestria", "hemlock_planks")))
            );
            public static final Item TREATED_HEMLOCK_PLANKS_ITEM = new BlockItem(TREATED_HEMLOCK_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_JAPANESE_MAPLE_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("terrestria", "japanese_maple_planks")))
            );
            public static final Item TREATED_JAPANESE_MAPLE_PLANKS_ITEM = new BlockItem(TREATED_JAPANESE_MAPLE_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_RAINBOW_EUCALYPTUS_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("terrestria", "rainbow_eucalyptus_planks")))
            );
            public static final Item TREATED_RAINBOW_EUCALYPTUS_PLANKS_ITEM = new BlockItem(TREATED_RAINBOW_EUCALYPTUS_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_REDWOOD_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("terrestria", "redwood_planks")))
            );
            public static final Item TREATED_REDWOOD_PLANKS_ITEM = new BlockItem(TREATED_REDWOOD_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_RUBBER_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("terrestria", "rubber_planks")))
            );
            public static final Item TREATED_RUBBER_PLANKS_ITEM = new BlockItem(TREATED_RUBBER_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_SAKURA_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("terrestria", "sakura_planks")))
            );
            public static final Item TREATED_SAKURA_PLANKS_ITEM = new BlockItem(TREATED_SAKURA_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_WILLOW_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("terrestria", "willow_planks")))
            );
            public static final Item TREATED_WILLOW_PLANKS_ITEM = new BlockItem(TREATED_WILLOW_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_YUCCA_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("terrestria", "yucca_planks")))
            );
            public static final Item TREATED_YUCCA_PLANKS_ITEM = new BlockItem(TREATED_YUCCA_PLANKS, new Item.Settings());
        
           public static void register() {        register_treated_plank("compat/terrestria/treated_cypress_planks", TREATED_CYPRESS_PLANKS, TREATED_CYPRESS_PLANKS_ITEM, "terrestria", "cypress");
        register_treated_plank("compat/terrestria/treated_hemlock_planks", TREATED_HEMLOCK_PLANKS, TREATED_HEMLOCK_PLANKS_ITEM, "terrestria", "hemlock");
        register_treated_plank("compat/terrestria/treated_japanese_maple_planks", TREATED_JAPANESE_MAPLE_PLANKS, TREATED_JAPANESE_MAPLE_PLANKS_ITEM, "terrestria", "japanese_maple");
        register_treated_plank("compat/terrestria/treated_rainbow_eucalyptus_planks", TREATED_RAINBOW_EUCALYPTUS_PLANKS, TREATED_RAINBOW_EUCALYPTUS_PLANKS_ITEM, "terrestria", "rainbow_eucalyptus");
        register_treated_plank("compat/terrestria/treated_redwood_planks", TREATED_REDWOOD_PLANKS, TREATED_REDWOOD_PLANKS_ITEM, "terrestria", "redwood");
        register_treated_plank("compat/terrestria/treated_rubber_planks", TREATED_RUBBER_PLANKS, TREATED_RUBBER_PLANKS_ITEM, "terrestria", "rubber");
        register_treated_plank("compat/terrestria/treated_sakura_planks", TREATED_SAKURA_PLANKS, TREATED_SAKURA_PLANKS_ITEM, "terrestria", "sakura");
        register_treated_plank("compat/terrestria/treated_willow_planks", TREATED_WILLOW_PLANKS, TREATED_WILLOW_PLANKS_ITEM, "terrestria", "willow");
        register_treated_plank("compat/terrestria/treated_yucca_planks", TREATED_YUCCA_PLANKS, TREATED_YUCCA_PLANKS_ITEM, "terrestria", "yucca");

        }
    }