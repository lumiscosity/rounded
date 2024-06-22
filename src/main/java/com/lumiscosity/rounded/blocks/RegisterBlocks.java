package com.lumiscosity.rounded.blocks;

import com.lumiscosity.rounded.worldgen.HugeLustershroomFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.LandPathNodeTypesRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

import static com.lumiscosity.rounded.Rounded.MOD_ID;

public class RegisterBlocks {

    public static final Block TREATED_OAK_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()
            );
    public static final Block TREATED_SPRUCE_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.SPRUCE_BROWN)
                            .instrument(NoteBlockInstrument.BELL)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            );
    public static final Block TREATED_BIRCH_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.PALE_YELLOW)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            );
    public static final Block TREATED_JUNGLE_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DIRT_BROWN)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            );
    public static final Block TREATED_ACACIA_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()
            );
    public static final Block TREATED_CHERRY_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.TERRACOTTA_WHITE)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.CHERRY_WOOD)
                            .burnable()
            );
    public static final Block TREATED_DARK_OAK_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create().mapColor(MapColor.BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()
            );
    public static final Block TREATED_MANGROVE_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create().mapColor(MapColor.RED).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()
            );
    public static final Block TREATED_BAMBOO_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.YELLOW)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.BAMBOO_WOOD)
                            .burnable()
            );
    public static final Block TREATED_CRIMSON_PLANKS = new Block(
                    AbstractBlock.Settings.create().mapColor(MapColor.DULL_PINK).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD)
            );
    public static final Block TREATED_WARPED_PLANKS = new Block(
                    AbstractBlock.Settings.create().mapColor(MapColor.DARK_AQUA).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD)
            );

    public static final Item TREATED_OAK_PLANKS_ITEM = new BlockItem(TREATED_OAK_PLANKS, new Item.Settings());
    public static final Item TREATED_SPRUCE_PLANKS_ITEM = new BlockItem(TREATED_SPRUCE_PLANKS, new Item.Settings());
    public static final Item TREATED_BIRCH_PLANKS_ITEM = new BlockItem(TREATED_BIRCH_PLANKS, new Item.Settings());
    public static final Item TREATED_JUNGLE_PLANKS_ITEM = new BlockItem(TREATED_JUNGLE_PLANKS, new Item.Settings());
    public static final Item TREATED_ACACIA_PLANKS_ITEM = new BlockItem(TREATED_ACACIA_PLANKS, new Item.Settings());
    public static final Item TREATED_CHERRY_PLANKS_ITEM = new BlockItem(TREATED_CHERRY_PLANKS, new Item.Settings());
    public static final Item TREATED_DARK_OAK_PLANKS_ITEM = new BlockItem(TREATED_DARK_OAK_PLANKS, new Item.Settings());
    public static final Item TREATED_MANGROVE_PLANKS_ITEM = new BlockItem(TREATED_OAK_PLANKS, new Item.Settings());
    public static final Item TREATED_BAMBOO_PLANKS_ITEM = new BlockItem(TREATED_BAMBOO_PLANKS, new Item.Settings());
    public static final Item TREATED_CRIMSON_PLANKS_ITEM = new BlockItem(TREATED_CRIMSON_PLANKS, new Item.Settings());
    public static final Item TREATED_WARPED_PLANKS_ITEM = new BlockItem(TREATED_WARPED_PLANKS, new Item.Settings());



    // no time for good coding practices! get this thing over here
    public static final Feature<HugeMushroomFeatureConfig> HUGE_LUSTERSHROOM = register_feature(
            "huge_lustershroom", new HugeLustershroomFeature(HugeMushroomFeatureConfig.CODEC)
    );

    public static final Block LUSTERSHROOM_PLANT = new LustershroomPlant(
            RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MOD_ID, "huge_lustershroom")),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.CYAN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .luminance(state -> 3)
                    .postProcess(Blocks::always)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final BlockItem LUSTERSHROON_PLANT_ITEM = new BlockItem(LUSTERSHROOM_PLANT, new Item.Settings());
    public static final Block LUSTERSHROOM_BLOCK = new MushroomBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.CYAN)
                    .luminance(state -> 7)
                    .sounds(BlockSoundGroup.WOOD)
    );
    public static final BlockItem LUSTERSHROON_BLOCK_ITEM= new BlockItem(LUSTERSHROOM_BLOCK, new Item.Settings());
    public static final Block LUSTER_CLUSTER = new Block(
            AbstractBlock.Settings.create().luminance(state -> 7).mapColor(MapColor.CYAN).instrument(NoteBlockInstrument.CHIME).strength(1.5F).sounds(BlockSoundGroup.DRIPSTONE_BLOCK)
    );
    public static final BlockItem LUSTER_CLUSTER_ITEM = new BlockItem(LUSTER_CLUSTER, new Item.Settings());

    public static final Block TROUGH = new TroughBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(0.6F).sounds(BlockSoundGroup.WOOD).burnable().ticksRandomly()
    );
    public static final Item TROUGH_ITEM = new BlockItem(TROUGH, new Item.Settings());

    public static void initBlocks() {
        register_treated_plank("treated_oak_planks", TREATED_OAK_PLANKS, TREATED_OAK_PLANKS_ITEM, "minecraft", "oak");
        register_treated_plank("treated_spruce_planks", TREATED_SPRUCE_PLANKS, TREATED_SPRUCE_PLANKS_ITEM, "minecraft", "spruce");
        register_treated_plank("treated_birch_planks", TREATED_BIRCH_PLANKS, TREATED_BIRCH_PLANKS_ITEM, "minecraft", "birch");
        register_treated_plank("treated_jungle_planks", TREATED_JUNGLE_PLANKS, TREATED_JUNGLE_PLANKS_ITEM, "minecraft", "jungle");
        register_treated_plank("treated_acacia_planks", TREATED_ACACIA_PLANKS, TREATED_ACACIA_PLANKS_ITEM, "minecraft", "acacia");
        register_treated_plank("treated_cherry_planks", TREATED_CHERRY_PLANKS, TREATED_CHERRY_PLANKS_ITEM, "minecraft", "cherry");
        register_treated_plank("treated_dark_oak_planks", TREATED_DARK_OAK_PLANKS, TREATED_DARK_OAK_PLANKS_ITEM, "minecraft", "dark_oak");
        register_treated_plank("treated_mangrove_planks", TREATED_MANGROVE_PLANKS, TREATED_MANGROVE_PLANKS_ITEM, "minecraft", "mangrove");
        register_treated_plank("treated_bamboo_planks", TREATED_BAMBOO_PLANKS, TREATED_BAMBOO_PLANKS_ITEM, "minecraft", "bamboo");
        register_treated_plank("treated_crimson_planks", TREATED_CRIMSON_PLANKS, TREATED_CRIMSON_PLANKS_ITEM, "minecraft", "crimson");
        register_treated_plank("treated_warped_planks", TREATED_WARPED_PLANKS, TREATED_WARPED_PLANKS_ITEM, "minecraft", "warped");

        register_block("lustershroom", LUSTERSHROOM_PLANT, LUSTERSHROON_PLANT_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of("minecraft", "red_mushroom")), LUSTERSHROON_PLANT_ITEM);
        });
        register_block("lustershroom_block", LUSTERSHROOM_BLOCK, LUSTERSHROON_BLOCK_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of("minecraft", "red_mushroom_block")), LUSTERSHROON_BLOCK_ITEM);
        });
        register_block("luster_cluster", LUSTER_CLUSTER, LUSTER_CLUSTER_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.add(LUSTER_CLUSTER_ITEM);
        });

        register_block("trough", TROUGH, TROUGH_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of("minecraft", "composter")), TROUGH_ITEM);
        });

        BiomeModifications.addFeature(
                BiomeSelectors.tag(TagKey.of(RegistryKeys.BIOME, Identifier.of(MOD_ID, "has_lustershrooms"))),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "lustershroom"))
        );
        BiomeModifications.addFeature(
                BiomeSelectors.tag(TagKey.of(RegistryKeys.BIOME, Identifier.of(MOD_ID, "has_more_lustershrooms"))),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "lustershroom_extra"))
        );
    }

    public static void register_treated_plank(String name, Block block, Item item, String source_mod, String plank_type) {
        register_block(name, block, item);
        LandPathNodeTypesRegistry.register(block, PathNodeType.DAMAGE_OTHER, PathNodeType.DAMAGE_OTHER);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of(source_mod, plank_type + "_planks")), item);
        });
    }

    private static void register_block(String name, Block block, Item item) {
        Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block);
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    private static <C extends FeatureConfig, F extends Feature<C>> F register_feature(String name, F feature) {
        return Registry.register(Registries.FEATURE, Identifier.of(MOD_ID, name), feature);
    }
}