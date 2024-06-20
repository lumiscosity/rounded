package com.lumiscosity.rounded;

import com.lumiscosity.rounded.blocks.RegisterBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Rounded implements ModInitializer {
	public static final String MOD_ID = "rounded";
    public static final Logger LOGGER = LoggerFactory.getLogger("rounded");

	@Override
	public void onInitialize() {
		RegisterBlocks.initBlocks();

		LOGGER.info("Rounded init complete!");
	}
}