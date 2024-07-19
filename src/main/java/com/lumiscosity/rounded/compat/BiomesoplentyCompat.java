package com.lumiscosity.rounded.compat;

            import net.minecraft.block.AbstractBlock;
            import net.minecraft.block.Block;
            import net.minecraft.item.BlockItem;
            import net.minecraft.item.Item;
            import net.minecraft.registry.Registries;
            import net.minecraft.util.Identifier;

            import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

            public class BiomesoplentyCompat {
                public static final Block TREATED_DEAD_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "dead_planks")))
                );
                public static final Item TREATED_DEAD_PLANKS_ITEM = new BlockItem(TREATED_DEAD_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_EMPYREAL_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "empyreal_planks")))
                );
                public static final Item TREATED_EMPYREAL_PLANKS_ITEM = new BlockItem(TREATED_EMPYREAL_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_FIR_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "fir_planks")))
                );
                public static final Item TREATED_FIR_PLANKS_ITEM = new BlockItem(TREATED_FIR_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_HELLBARK_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "hellbark_planks")))
                );
                public static final Item TREATED_HELLBARK_PLANKS_ITEM = new BlockItem(TREATED_HELLBARK_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_JACARANDA_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "jacaranda_planks")))
                );
                public static final Item TREATED_JACARANDA_PLANKS_ITEM = new BlockItem(TREATED_JACARANDA_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_MAGIC_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "magic_planks")))
                );
                public static final Item TREATED_MAGIC_PLANKS_ITEM = new BlockItem(TREATED_MAGIC_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_MAHOGANY_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "mahogany_planks")))
                );
                public static final Item TREATED_MAHOGANY_PLANKS_ITEM = new BlockItem(TREATED_MAHOGANY_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_MAPLE_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "maple_planks")))
                );
                public static final Item TREATED_MAPLE_PLANKS_ITEM = new BlockItem(TREATED_MAPLE_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_PALM_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "palm_planks")))
                );
                public static final Item TREATED_PALM_PLANKS_ITEM = new BlockItem(TREATED_PALM_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_PINE_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "pine_planks")))
                );
                public static final Item TREATED_PINE_PLANKS_ITEM = new BlockItem(TREATED_PINE_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_REDWOOD_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "redwood_planks")))
                );
                public static final Item TREATED_REDWOOD_PLANKS_ITEM = new BlockItem(TREATED_REDWOOD_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_UMBRAN_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "umbran_planks")))
                );
                public static final Item TREATED_UMBRAN_PLANKS_ITEM = new BlockItem(TREATED_UMBRAN_PLANKS, new Item.Settings());
            
            
                public static final Block TREATED_WILLOW_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("biomesoplenty", "willow_planks")))
                );
                public static final Item TREATED_WILLOW_PLANKS_ITEM = new BlockItem(TREATED_WILLOW_PLANKS, new Item.Settings());
            
               public static void register() {        register_treated_plank("compat/biomesoplenty/treated_dead_planks", TREATED_DEAD_PLANKS, TREATED_DEAD_PLANKS_ITEM, "biomesoplenty", "dead");
        register_treated_plank("compat/biomesoplenty/treated_empyreal_planks", TREATED_EMPYREAL_PLANKS, TREATED_EMPYREAL_PLANKS_ITEM, "biomesoplenty", "empyreal");
        register_treated_plank("compat/biomesoplenty/treated_fir_planks", TREATED_FIR_PLANKS, TREATED_FIR_PLANKS_ITEM, "biomesoplenty", "fir");
        register_treated_plank("compat/biomesoplenty/treated_hellbark_planks", TREATED_HELLBARK_PLANKS, TREATED_HELLBARK_PLANKS_ITEM, "biomesoplenty", "hellbark");
        register_treated_plank("compat/biomesoplenty/treated_jacaranda_planks", TREATED_JACARANDA_PLANKS, TREATED_JACARANDA_PLANKS_ITEM, "biomesoplenty", "jacaranda");
        register_treated_plank("compat/biomesoplenty/treated_magic_planks", TREATED_MAGIC_PLANKS, TREATED_MAGIC_PLANKS_ITEM, "biomesoplenty", "magic");
        register_treated_plank("compat/biomesoplenty/treated_mahogany_planks", TREATED_MAHOGANY_PLANKS, TREATED_MAHOGANY_PLANKS_ITEM, "biomesoplenty", "mahogany");
        register_treated_plank("compat/biomesoplenty/treated_maple_planks", TREATED_MAPLE_PLANKS, TREATED_MAPLE_PLANKS_ITEM, "biomesoplenty", "maple");
        register_treated_plank("compat/biomesoplenty/treated_palm_planks", TREATED_PALM_PLANKS, TREATED_PALM_PLANKS_ITEM, "biomesoplenty", "palm");
        register_treated_plank("compat/biomesoplenty/treated_pine_planks", TREATED_PINE_PLANKS, TREATED_PINE_PLANKS_ITEM, "biomesoplenty", "pine");
        register_treated_plank("compat/biomesoplenty/treated_redwood_planks", TREATED_REDWOOD_PLANKS, TREATED_REDWOOD_PLANKS_ITEM, "biomesoplenty", "redwood");
        register_treated_plank("compat/biomesoplenty/treated_umbran_planks", TREATED_UMBRAN_PLANKS, TREATED_UMBRAN_PLANKS_ITEM, "biomesoplenty", "umbran");
        register_treated_plank("compat/biomesoplenty/treated_willow_planks", TREATED_WILLOW_PLANKS, TREATED_WILLOW_PLANKS_ITEM, "biomesoplenty", "willow");

        }
    }