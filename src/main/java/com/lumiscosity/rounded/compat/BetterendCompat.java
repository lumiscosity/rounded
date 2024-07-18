package com.lumiscosity.rounded.compat;

            import net.minecraft.block.AbstractBlock;
            import net.minecraft.block.Block;
            import net.minecraft.item.BlockItem;
            import net.minecraft.item.Item;
            import net.minecraft.registry.Registries;
            import net.minecraft.util.Identifier;

            import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

            public class BetterendCompat {
            public static final Block TREATED_DRAGON_TREE_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betterend", "dragon_tree_planks")))
            );
            public static final Item TREATED_DRAGON_TREE_PLANKS_ITEM = new BlockItem(TREATED_DRAGON_TREE_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_END_LOTUS_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betterend", "end_lotus_planks")))
            );
            public static final Item TREATED_END_LOTUS_PLANKS_ITEM = new BlockItem(TREATED_END_LOTUS_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_HELIX_TREE_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betterend", "helix_tree_planks")))
            );
            public static final Item TREATED_HELIX_TREE_PLANKS_ITEM = new BlockItem(TREATED_HELIX_TREE_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_JELLYSHROOM_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betterend", "jellyshroom_planks")))
            );
            public static final Item TREATED_JELLYSHROOM_PLANKS_ITEM = new BlockItem(TREATED_JELLYSHROOM_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_LACUGROVE_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betterend", "lacugrove_planks")))
            );
            public static final Item TREATED_LACUGROVE_PLANKS_ITEM = new BlockItem(TREATED_LACUGROVE_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_LUCERNIA_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betterend", "lucernia_planks")))
            );
            public static final Item TREATED_LUCERNIA_PLANKS_ITEM = new BlockItem(TREATED_LUCERNIA_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_MOSSY_GLOWSHROOM_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betterend", "mossy_glowshroom_planks")))
            );
            public static final Item TREATED_MOSSY_GLOWSHROOM_PLANKS_ITEM = new BlockItem(TREATED_MOSSY_GLOWSHROOM_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_PYTHADENDRON_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betterend", "pythadendron_planks")))
            );
            public static final Item TREATED_PYTHADENDRON_PLANKS_ITEM = new BlockItem(TREATED_PYTHADENDRON_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_TENANEA_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betterend", "tenanea_planks")))
            );
            public static final Item TREATED_TENANEA_PLANKS_ITEM = new BlockItem(TREATED_TENANEA_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_UMBRELLA_TREE_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betterend", "umbrella_tree_planks")))
            );
            public static final Item TREATED_UMBRELLA_TREE_PLANKS_ITEM = new BlockItem(TREATED_UMBRELLA_TREE_PLANKS, new Item.Settings());
        
           public static void register() {        register_treated_plank("compat/betterend/treated_dragon_tree_planks", TREATED_DRAGON_TREE_PLANKS, TREATED_DRAGON_TREE_PLANKS_ITEM, "betterend", "dragon_tree");
        register_treated_plank("compat/betterend/treated_end_lotus_planks", TREATED_END_LOTUS_PLANKS, TREATED_END_LOTUS_PLANKS_ITEM, "betterend", "end_lotus");
        register_treated_plank("compat/betterend/treated_helix_tree_planks", TREATED_HELIX_TREE_PLANKS, TREATED_HELIX_TREE_PLANKS_ITEM, "betterend", "helix_tree");
        register_treated_plank("compat/betterend/treated_jellyshroom_planks", TREATED_JELLYSHROOM_PLANKS, TREATED_JELLYSHROOM_PLANKS_ITEM, "betterend", "jellyshroom");
        register_treated_plank("compat/betterend/treated_lacugrove_planks", TREATED_LACUGROVE_PLANKS, TREATED_LACUGROVE_PLANKS_ITEM, "betterend", "lacugrove");
        register_treated_plank("compat/betterend/treated_lucernia_planks", TREATED_LUCERNIA_PLANKS, TREATED_LUCERNIA_PLANKS_ITEM, "betterend", "lucernia");
        register_treated_plank("compat/betterend/treated_mossy_glowshroom_planks", TREATED_MOSSY_GLOWSHROOM_PLANKS, TREATED_MOSSY_GLOWSHROOM_PLANKS_ITEM, "betterend", "mossy_glowshroom");
        register_treated_plank("compat/betterend/treated_pythadendron_planks", TREATED_PYTHADENDRON_PLANKS, TREATED_PYTHADENDRON_PLANKS_ITEM, "betterend", "pythadendron");
        register_treated_plank("compat/betterend/treated_tenanea_planks", TREATED_TENANEA_PLANKS, TREATED_TENANEA_PLANKS_ITEM, "betterend", "tenanea");
        register_treated_plank("compat/betterend/treated_umbrella_tree_planks", TREATED_UMBRELLA_TREE_PLANKS, TREATED_UMBRELLA_TREE_PLANKS_ITEM, "betterend", "umbrella_tree");

        }
    }