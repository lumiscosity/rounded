package com.lumiscosity.rounded.blocks;

import com.lumiscosity.rounded.worldgen.HugeLustershroomFeature;
import net.fabricmc.fabric.api.registry.LandPathNodeTypesRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
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
    public static final Item TREATED_OAK_PLANKS_ITEM = new BlockItem(TREATED_OAK_PLANKS, new Item.Settings());
    public static final Item TREATED_SPRUCE_PLANKS_ITEM = new BlockItem(TREATED_SPRUCE_PLANKS, new Item.Settings());
    public static final Item TREATED_BIRCH_PLANKS_ITEM = new BlockItem(TREATED_BIRCH_PLANKS, new Item.Settings());
    public static final Item TREATED_JUNGLE_PLANKS_ITEM = new BlockItem(TREATED_JUNGLE_PLANKS, new Item.Settings());
    public static final Item TREATED_ACACIA_PLANKS_ITEM = new BlockItem(TREATED_ACACIA_PLANKS, new Item.Settings());
    public static final Item TREATED_CHERRY_PLANKS_ITEM = new BlockItem(TREATED_CHERRY_PLANKS, new Item.Settings());
    public static final Item TREATED_DARK_OAK_PLANKS_ITEM = new BlockItem(TREATED_DARK_OAK_PLANKS, new Item.Settings());
    public static final Item TREATED_MANGROVE_PLANKS_ITEM = new BlockItem(TREATED_OAK_PLANKS, new Item.Settings());
    public static final Item TREATED_BAMBOO_PLANKS_ITEM = new BlockItem(TREATED_BAMBOO_PLANKS, new Item.Settings());



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
                    .luminance(state -> 8)
                    .postProcess(Blocks::always)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final BlockItem LUSTERSHROON_PLANT_ITEM = new BlockItem(LUSTERSHROOM_PLANT, new Item.Settings());
    public static final Block LUSTERSHROOM_BLOCK = new MushroomBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.CYAN)
                    .luminance(state -> 8)
    );
    public static final BlockItem LUSTERSHROON_BLOCK_ITEM= new BlockItem(LUSTERSHROOM_BLOCK, new Item.Settings());
    public static final Block LUSTER_CLUSTER = new Block(
            AbstractBlock.Settings.create().luminance(state -> 8).mapColor(MapColor.CYAN).instrument(NoteBlockInstrument.CHIME).strength(1.5F).sounds(BlockSoundGroup.DRIPSTONE_BLOCK)
    );
    public static final BlockItem LUSTER_CLUSTER_ITEM = new BlockItem(LUSTER_CLUSTER, new Item.Settings());

    public static final Block TROUGH = new TroughBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(0.6F).sounds(BlockSoundGroup.WOOD).burnable().ticksRandomly()
    );
    public static final Item TROUGH_ITEM = new BlockItem(TROUGH, new Item.Settings());

    public static void initBlocks() {
        register_treated_plank("treated_oak_planks", TREATED_OAK_PLANKS, TREATED_OAK_PLANKS_ITEM);
        register_treated_plank("treated_spruce_planks", TREATED_SPRUCE_PLANKS, TREATED_SPRUCE_PLANKS_ITEM);
        register_treated_plank("treated_birch_planks", TREATED_BIRCH_PLANKS, TREATED_BIRCH_PLANKS_ITEM);
        register_treated_plank("treated_jungle_planks", TREATED_JUNGLE_PLANKS, TREATED_JUNGLE_PLANKS_ITEM);
        register_treated_plank("treated_acacia_planks", TREATED_ACACIA_PLANKS, TREATED_ACACIA_PLANKS_ITEM);
        register_treated_plank("treated_cherry_planks", TREATED_CHERRY_PLANKS, TREATED_CHERRY_PLANKS_ITEM);
        register_treated_plank("treated_dark_oak_planks", TREATED_DARK_OAK_PLANKS, TREATED_DARK_OAK_PLANKS_ITEM);
        register_treated_plank("treated_mangrove_planks", TREATED_MANGROVE_PLANKS, TREATED_MANGROVE_PLANKS_ITEM);
        register_treated_plank("treated_bamboo_planks", TREATED_BAMBOO_PLANKS, TREATED_BAMBOO_PLANKS_ITEM);

        register_block("lustershroom", LUSTERSHROOM_PLANT, LUSTERSHROON_PLANT_ITEM);
        register_block("lustershroom_block", LUSTERSHROOM_BLOCK, LUSTERSHROON_BLOCK_ITEM);
        register_block("luster_cluster", LUSTER_CLUSTER, LUSTER_CLUSTER_ITEM);

        register_block("trough", TROUGH, TROUGH_ITEM);
    }

    private static void register_treated_plank(String name, Block block, Item item) {
        register_block(name, block, item);
        LandPathNodeTypesRegistry.register(block, PathNodeType.BLOCKED, PathNodeType.BLOCKED);
    }

    private static void register_block(String name, Block block, Item item) {
        Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block);
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    private static <C extends FeatureConfig, F extends Feature<C>> F register_feature(String name, F feature) {
        return Registry.register(Registries.FEATURE, Identifier.of(MOD_ID, name), feature);
    }
}