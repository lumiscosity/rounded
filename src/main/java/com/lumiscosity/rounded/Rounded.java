package com.lumiscosity.rounded;

import com.lumiscosity.rounded.blocks.RegisterBlocks;
import com.lumiscosity.rounded.compat.*;
import com.lumiscosity.rounded.misc.RegisterSounds;
import com.lumiscosity.rounded.misc.RegisterTrades;
import com.lumiscosity.rounded.worldgen.RegisterFeatures;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rounded implements ModInitializer {
	public static final String MOD_ID = "rounded";
    public static final Logger LOGGER = LoggerFactory.getLogger("rounded");

	@Override
	public void onInitialize() {
		RegisterFeatures.initFeatures();
		RegisterBlocks.initBlocks();
		RegisterSounds.initSounds();
		RegisterTrades.initTrades();
		RegisterMisc.initMisc();

		if (FabricLoader.getInstance().isModLoaded("extravaganza")) {
			ExtravaganzaCompat.register();
		}

		if (FabricLoader.getInstance().isModLoaded("betterend")) {
			BetterendCompat.register();
		}
		if (FabricLoader.getInstance().isModLoaded("betternether")) {
			BetternetherCompat.register();
		}
		if (FabricLoader.getInstance().isModLoaded("biomesoplenty")) {
			BiomesoplentyCompat.register();
		}
		if (FabricLoader.getInstance().isModLoaded("cinderscapes")) {
			CinderscapesCompat.register();
		}
		if (FabricLoader.getInstance().isModLoaded("terrestria")) {
			TerrestriaCompat.register();
		}
		if (FabricLoader.getInstance().isModLoaded("traverse")) {
			TraverseCompat.register();
		}
		if (FabricLoader.getInstance().isModLoaded("wilderwild")) {
			WilderwildCompat.register();
		}
		if (FabricLoader.getInstance().isModLoaded("gardens_of_the_dead")) {
			GardensofthedeadCompat.register();
		}
		if (FabricLoader.getInstance().isModLoaded("pearfection")) {
			PearfectionCompat.register();
		}
		if (FabricLoader.getInstance().isModLoaded("verdance")) {
			VerdanceCompat.register();
		}
		if (FabricLoader.getInstance().isModLoaded("charm")) {
			CharmCompat.register();
		}
		if (FabricLoader.getInstance().isModLoaded("pyrite")) {
			PyriteCompat.register();
		}

		LOGGER.info("Rounded init complete!");
	}
}