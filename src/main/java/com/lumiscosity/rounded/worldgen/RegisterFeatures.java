package com.lumiscosity.rounded.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;

import static com.lumiscosity.rounded.Rounded.MOD_ID;

public class RegisterFeatures {
    public static void initFeatures() {
        // Lustershroom patch and Huge Lustershroom
        register_feature("huge_lustershroom", new HugeLustershroomFeature(HugeMushroomFeatureConfig.CODEC));
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

        // Bladderwrack
        BiomeModifications.addFeature(
                BiomeSelectors.tag(TagKey.of(RegistryKeys.BIOME, Identifier.of(MOD_ID, "has_bladderwrack"))),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "bladderwrack"))
        );

        // Ocean rocks
        register_feature("ocean_rock", new OceanRockFeature(SimpleBlockFeatureConfig.CODEC));
        BiomeModifications.addFeature(
                BiomeSelectors.tag(TagKey.of(RegistryKeys.BIOME, Identifier.of(MOD_ID, "has_andesite_ocean_rocks"))),
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "andesite_ocean_rock"))
        );
        BiomeModifications.addFeature(
                BiomeSelectors.tag(TagKey.of(RegistryKeys.BIOME, Identifier.of(MOD_ID, "has_diorite_ocean_rocks"))),
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "diorite_ocean_rock"))
        );
        BiomeModifications.addFeature(
                BiomeSelectors.tag(TagKey.of(RegistryKeys.BIOME, Identifier.of(MOD_ID, "has_smooth_basalt_ocean_rocks"))),
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "smooth_basalt_ocean_rock"))
        );
        BiomeModifications.addFeature(
                BiomeSelectors.tag(TagKey.of(RegistryKeys.BIOME, Identifier.of(MOD_ID, "has_lava_ocean_rocks"))),
                GenerationStep.Feature.LOCAL_MODIFICATIONS,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "lava_ocean_rock"))
        );
    }

    private static <C extends FeatureConfig, F extends Feature<C>> void register_feature(String name, F feature) {
        Registry.register(Registries.FEATURE, Identifier.of(MOD_ID, name), feature);
    }
}
