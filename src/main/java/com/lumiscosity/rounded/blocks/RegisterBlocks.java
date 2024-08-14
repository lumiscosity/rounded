package com.lumiscosity.rounded.blocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.LandPathNodeTypesRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static com.lumiscosity.rounded.Rounded.MOD_ID;

public class RegisterBlocks {

    // Vanilla treated planks
    public static final Block TREATED_OAK_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()
            );
    public static final Block TREATED_SPRUCE_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.SPRUCE_BROWN)
                            .instrument(Instrument.BELL)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            );
    public static final Block TREATED_BIRCH_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.PALE_YELLOW)
                            .instrument(Instrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            );
    public static final Block TREATED_JUNGLE_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DIRT_BROWN)
                            .instrument(Instrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()
            );
    public static final Block TREATED_ACACIA_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).instrument(Instrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()
            );
    public static final Block TREATED_CHERRY_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.TERRACOTTA_WHITE)
                            .instrument(Instrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.CHERRY_WOOD)
                            .burnable()
            );
    public static final Block TREATED_DARK_OAK_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create().mapColor(MapColor.BROWN).instrument(Instrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()
            );
    public static final Block TREATED_MANGROVE_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create().mapColor(MapColor.RED).instrument(Instrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()
            );
    public static final Block TREATED_BAMBOO_PLANKS = new TreatedPlank(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.YELLOW)
                            .instrument(Instrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sounds(BlockSoundGroup.BAMBOO_WOOD)
                            .burnable()
            );
    public static final Block TREATED_CRIMSON_PLANKS = new Block(
                    AbstractBlock.Settings.create().mapColor(MapColor.DULL_PINK).instrument(Instrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD)
            );
    public static final Block TREATED_WARPED_PLANKS = new Block(
                    AbstractBlock.Settings.create().mapColor(MapColor.DARK_AQUA).instrument(Instrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD)
            );


    public static final Item TREATED_OAK_PLANKS_ITEM = new BlockItem(TREATED_OAK_PLANKS, new Item.Settings());
    public static final Item TREATED_SPRUCE_PLANKS_ITEM = new BlockItem(TREATED_SPRUCE_PLANKS, new Item.Settings());
    public static final Item TREATED_BIRCH_PLANKS_ITEM = new BlockItem(TREATED_BIRCH_PLANKS, new Item.Settings());
    public static final Item TREATED_JUNGLE_PLANKS_ITEM = new BlockItem(TREATED_JUNGLE_PLANKS, new Item.Settings());
    public static final Item TREATED_ACACIA_PLANKS_ITEM = new BlockItem(TREATED_ACACIA_PLANKS, new Item.Settings());
    public static final Item TREATED_CHERRY_PLANKS_ITEM = new BlockItem(TREATED_CHERRY_PLANKS, new Item.Settings());
    public static final Item TREATED_DARK_OAK_PLANKS_ITEM = new BlockItem(TREATED_DARK_OAK_PLANKS, new Item.Settings());
    public static final Item TREATED_MANGROVE_PLANKS_ITEM = new BlockItem(TREATED_MANGROVE_PLANKS, new Item.Settings());
    public static final Item TREATED_BAMBOO_PLANKS_ITEM = new BlockItem(TREATED_BAMBOO_PLANKS, new Item.Settings());
    public static final Item TREATED_CRIMSON_PLANKS_ITEM = new BlockItem(TREATED_CRIMSON_PLANKS, new Item.Settings());
    public static final Item TREATED_WARPED_PLANKS_ITEM = new BlockItem(TREATED_WARPED_PLANKS, new Item.Settings());

    // Lustershroom and related blocks
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
            AbstractBlock.Settings.create().luminance(state -> 7).mapColor(MapColor.CYAN).instrument(Instrument.CHIME).strength(1.5F).sounds(BlockSoundGroup.DRIPSTONE_BLOCK)
    );
    public static final BlockItem LUSTER_CLUSTER_ITEM = new BlockItem(LUSTER_CLUSTER, new Item.Settings());

    // Trough
    public static final Block TROUGH = new TroughBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASS).strength(0.6F).sounds(BlockSoundGroup.WOOD).burnable().ticksRandomly()
    );
    public static final Item TROUGH_ITEM = new BlockItem(TROUGH, new Item.Settings());

    // Smooth Prismarine
    public static final Block SMOOTH_PRISMARINE = new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F)
    );
    public static final Block SMOOTH_PRISMARINE_SLAB = new SlabBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F)
    );
    public static final BlockItem SMOOTH_PRISMARINE_ITEM= new BlockItem(SMOOTH_PRISMARINE, new Item.Settings());
    public static final BlockItem SMOOTH_PRISMARINE_SLAB_ITEM= new BlockItem(SMOOTH_PRISMARINE_SLAB, new Item.Settings());

    // Chiseled Prismarine Bricks
    public static final Block CHISELED_PRISMARINE_BRICKS = new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F)
    );
    public static final BlockItem CHISELED_PRISMARINE_BRICKS_ITEM= new BlockItem(CHISELED_PRISMARINE_BRICKS, new Item.Settings());

    // Prismarine Lantern
    public static final Block PRISMARINE_LANTERN = new LanternBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.IRON_GRAY)
                    .solid()
                    .requiresTool()
                    .strength(3.5F)
                    .sounds(BlockSoundGroup.LANTERN)
                    .luminance(state -> 15)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final BlockItem PRISMARINE_LANTERN_ITEM = new BlockItem(PRISMARINE_LANTERN, new Item.Settings());

    // Bladderwrack and related blocks
    public static final Block DEAD_BLADDERWRACK = new DeadCoralFanBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BROWN).solid().instrument(Instrument.BASEDRUM).requiresTool().noCollision().breakInstantly()
    );
    public static final Block BLADDERWRACK = new CoralFanBlock(
            DEAD_BLADDERWRACK,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DIRT_BROWN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.WET_GRASS)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block DEAD_BLADDERWRACK_BLOCK = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.GRAY)
            .solid()
            .instrument(Instrument.BASEDRUM)
            .requiresTool()
            .strength(1.5F, 6.0F)
    );
    public static final Block BLADDERWRACK_BLOCK = new CoralBlockBlock(DEAD_BLADDERWRACK_BLOCK, AbstractBlock.Settings.create()
            .mapColor(MapColor.TERRACOTTA_BROWN)
            .instrument(Instrument.BASEDRUM)
            .requiresTool()
            .strength(1.5F, 6.0F)
            .sounds(BlockSoundGroup.CORAL));
    public static final BlockItem DEAD_BLADDERWRACK_ITEM = new BlockItem(DEAD_BLADDERWRACK, new Item.Settings());
    public static final BlockItem BLADDERWRACK_ITEM = new BlockItem(BLADDERWRACK, new Item.Settings());
    public static final BlockItem BLADDERWRACK_BLOCK_ITEM = new BlockItem(BLADDERWRACK_BLOCK, new Item.Settings());
    public static final BlockItem DEAD_BLADDERWRACK_BLOCK_ITEM = new BlockItem(DEAD_BLADDERWRACK_BLOCK, new Item.Settings());

    // Moisture Detector
    public static final Block MOISTURE_DETECTOR = new MoistureDetectorBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).instrument(Instrument.BASEDRUM).strength(1.5F, 6.0F)
    );
    public static final BlockItem MOISTURE_DETECTOR_ITEM = new BlockItem(MOISTURE_DETECTOR, new Item.Settings());
    public static final BlockEntityType<MoistureDetectorBlock.MoistureDetectorBlockEntity> MOISTURE_DETECTOR_BE = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(MOD_ID, "moisture_detector"),
            FabricBlockEntityTypeBuilder.create(MoistureDetectorBlock.MoistureDetectorBlockEntity::new, MOISTURE_DETECTOR).build()
    );

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

        register_block("smooth_prismarine", SMOOTH_PRISMARINE, SMOOTH_PRISMARINE_ITEM);
        register_block("smooth_prismarine_slab", SMOOTH_PRISMARINE_SLAB, SMOOTH_PRISMARINE_SLAB_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of("minecraft", "prismarine_slab")), SMOOTH_PRISMARINE_ITEM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of(MOD_ID, "smooth_prismarine")), SMOOTH_PRISMARINE_SLAB_ITEM);
        });

        register_block("chiseled_prismarine_bricks", CHISELED_PRISMARINE_BRICKS, CHISELED_PRISMARINE_BRICKS_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of("minecraft", "prismarine_brick_slab")), CHISELED_PRISMARINE_BRICKS_ITEM);
        });

        register_block("prismarine_lantern", PRISMARINE_LANTERN, PRISMARINE_LANTERN_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of("minecraft", "soul_lantern")), PRISMARINE_LANTERN_ITEM);
        });

        register_block("dead_bladderwrack", DEAD_BLADDERWRACK, DEAD_BLADDERWRACK_ITEM);
        register_block("bladderwrack", BLADDERWRACK, BLADDERWRACK_ITEM);
        register_block("dead_bladderwrack_block", DEAD_BLADDERWRACK_BLOCK, DEAD_BLADDERWRACK_BLOCK_ITEM);
        register_block("bladderwrack_block", BLADDERWRACK_BLOCK, BLADDERWRACK_BLOCK_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of("minecraft", "dead_horn_coral_fan")), DEAD_BLADDERWRACK_ITEM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of("minecraft", "horn_coral_fan")), BLADDERWRACK_ITEM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of("minecraft", "dead_horn_coral_block")), DEAD_BLADDERWRACK_BLOCK_ITEM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of("minecraft", "horn_coral_block")), BLADDERWRACK_BLOCK_ITEM);
        });

        register_block("moisture_detector", MOISTURE_DETECTOR, MOISTURE_DETECTOR_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
            content.addAfter(Registries.BLOCK.get(Identifier.of("minecraft", "daylight_detector")), MOISTURE_DETECTOR_ITEM);
        });
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
}