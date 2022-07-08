package me.andante.invulnerableload.impl.server;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.SERVER)
public interface ServerPlayNetworkHandlerAccess {
    boolean isInvulnerableLoad();
}
