package com.lumiscosity.rounded;

import com.lumiscosity.rounded.blocks.RegisterBlocks;
import com.lumiscosity.rounded.compat.ExtravaganzaCompat;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rounded implements ModInitializer {
	public static final String MOD_ID = "rounded";
    public static final Logger LOGGER = LoggerFactory.getLogger("rounded");

	@Override
	public void onInitialize() {
		RegisterBlocks.initBlocks();

		if (FabricLoader.getInstance().isModLoaded("extravaganza")) {
			ExtravaganzaCompat.register();
		}

		LOGGER.info("Rounded init complete!");
	}
}