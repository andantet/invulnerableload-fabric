package me.andante.invulnerableload.impl.server;

import me.andante.invulnerableload.api.InvulnerableLoad;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.SERVER)
public class InvulnerableLoadServerImpl implements InvulnerableLoad, DedicatedServerModInitializer {
	@Override
	public void onInitializeServer() {
		LOGGER.info("Initializing {}", MOD_NAME);
	}
}
