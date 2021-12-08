package me.andante.invulnerableload;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvulnerableLoad implements ModInitializer {
    public static final String MOD_ID   = "invulnerableload";
    public static final String MOD_NAME = "Invulnerable Load";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing {}", MOD_NAME);

        //

		LOGGER.info("Initialized {}", MOD_NAME);
	}
}
