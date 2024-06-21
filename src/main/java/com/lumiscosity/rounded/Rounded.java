package com.lumiscosity.rounded;

import com.lumiscosity.rounded.blocks.RegisterBlocks;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rounded implements ModInitializer {
	public static final String MOD_ID = "rounded";
    public static final Logger LOGGER = LoggerFactory.getLogger("rounded");

	@Override
	public void onInitialize() {
		RegisterBlocks.initBlocks();

		LOGGER.info("Rounded init complete!");
	}
}