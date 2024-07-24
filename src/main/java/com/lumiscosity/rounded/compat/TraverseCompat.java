package com.lumiscosity.rounded.compat;

            import net.minecraft.block.AbstractBlock;
            import net.minecraft.block.Block;
            import net.minecraft.item.BlockItem;
            import net.minecraft.item.Item;
            import net.minecraft.registry.Registries;
            import net.minecraft.util.Identifier;

            import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

            public class TraverseCompat {
                public static final Block TREATED_FIR_PLANKS = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("minecraft", "oak_planks")))
                );
                public static final Item TREATED_FIR_PLANKS_ITEM = new BlockItem(TREATED_FIR_PLANKS, new Item.Settings());
            
               public static void register() {        register_treated_plank("compat/traverse/treated_fir_planks", TREATED_FIR_PLANKS, TREATED_FIR_PLANKS_ITEM, "traverse", "fir");

        }
    }