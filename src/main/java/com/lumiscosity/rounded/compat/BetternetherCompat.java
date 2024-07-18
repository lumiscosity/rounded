package com.lumiscosity.rounded.compat;

            import net.minecraft.block.AbstractBlock;
            import net.minecraft.block.Block;
            import net.minecraft.item.BlockItem;
            import net.minecraft.item.Item;
            import net.minecraft.registry.Registries;
            import net.minecraft.util.Identifier;

            import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

            public class BetternetherCompat {
            public static final Block TREATED_ANCHOR_TREE_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betternether", "anchor_tree_planks")))
            );
            public static final Item TREATED_ANCHOR_TREE_PLANKS_ITEM = new BlockItem(TREATED_ANCHOR_TREE_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_MUSHROOM_FIR_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betternether", "mushroom_fir_planks")))
            );
            public static final Item TREATED_MUSHROOM_FIR_PLANKS_ITEM = new BlockItem(TREATED_MUSHROOM_FIR_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_NETHER_MUSHROOM_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betternether", "nether_mushroom_planks")))
            );
            public static final Item TREATED_NETHER_MUSHROOM_PLANKS_ITEM = new BlockItem(TREATED_NETHER_MUSHROOM_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_NETHER_REED_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betternether", "nether_reed_planks")))
            );
            public static final Item TREATED_NETHER_REED_PLANKS_ITEM = new BlockItem(TREATED_NETHER_REED_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_NETHER_SAKURA_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betternether", "nether_sakura_planks")))
            );
            public static final Item TREATED_NETHER_SAKURA_PLANKS_ITEM = new BlockItem(TREATED_NETHER_SAKURA_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_RUBEUS_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betternether", "rubeus_planks")))
            );
            public static final Item TREATED_RUBEUS_PLANKS_ITEM = new BlockItem(TREATED_RUBEUS_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_STALAGNATE_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betternether", "stalagnate_planks")))
            );
            public static final Item TREATED_STALAGNATE_PLANKS_ITEM = new BlockItem(TREATED_STALAGNATE_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_WART_PLANKS_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betternether", "wart_planks_planks")))
            );
            public static final Item TREATED_WART_PLANKS_PLANKS_ITEM = new BlockItem(TREATED_WART_PLANKS_PLANKS, new Item.Settings());
        
        
            public static final Block TREATED_WILLOW_PLANKS_PLANKS = new Block(
                AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("betternether", "willow_planks_planks")))
            );
            public static final Item TREATED_WILLOW_PLANKS_PLANKS_ITEM = new BlockItem(TREATED_WILLOW_PLANKS_PLANKS, new Item.Settings());
        
           public static void register() {        register_treated_plank("compat/betternether/treated_anchor_tree_planks", TREATED_ANCHOR_TREE_PLANKS, TREATED_ANCHOR_TREE_PLANKS_ITEM, "betternether", "anchor_tree");
        register_treated_plank("compat/betternether/treated_mushroom_fir_planks", TREATED_MUSHROOM_FIR_PLANKS, TREATED_MUSHROOM_FIR_PLANKS_ITEM, "betternether", "mushroom_fir");
        register_treated_plank("compat/betternether/treated_nether_mushroom_planks", TREATED_NETHER_MUSHROOM_PLANKS, TREATED_NETHER_MUSHROOM_PLANKS_ITEM, "betternether", "nether_mushroom");
        register_treated_plank("compat/betternether/treated_nether_reed_planks", TREATED_NETHER_REED_PLANKS, TREATED_NETHER_REED_PLANKS_ITEM, "betternether", "nether_reed");
        register_treated_plank("compat/betternether/treated_nether_sakura_planks", TREATED_NETHER_SAKURA_PLANKS, TREATED_NETHER_SAKURA_PLANKS_ITEM, "betternether", "nether_sakura");
        register_treated_plank("compat/betternether/treated_rubeus_planks", TREATED_RUBEUS_PLANKS, TREATED_RUBEUS_PLANKS_ITEM, "betternether", "rubeus");
        register_treated_plank("compat/betternether/treated_stalagnate_planks", TREATED_STALAGNATE_PLANKS, TREATED_STALAGNATE_PLANKS_ITEM, "betternether", "stalagnate");
        register_treated_plank("compat/betternether/treated_wart_planks_planks", TREATED_WART_PLANKS_PLANKS, TREATED_WART_PLANKS_PLANKS_ITEM, "betternether", "wart_planks");
        register_treated_plank("compat/betternether/treated_willow_planks_planks", TREATED_WILLOW_PLANKS_PLANKS, TREATED_WILLOW_PLANKS_PLANKS_ITEM, "betternether", "willow_planks");

        }
    }