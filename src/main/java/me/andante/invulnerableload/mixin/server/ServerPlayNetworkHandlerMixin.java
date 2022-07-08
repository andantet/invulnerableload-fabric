package me.andante.invulnerableload.mixin.server;

import me.andante.invulnerableload.impl.server.ServerPlayNetworkHandlerAccess;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.packet.c2s.play.ResourcePackStatusC2SPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.SERVER)
@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin implements ServerPlayNetworkHandlerAccess {
    private @Unique boolean invulnerableLoad = true;

    @Inject(method = "onResourcePackStatus", at = @At("TAIL"))
    private void onOnResourcePackStatus(ResourcePackStatusC2SPacket packet, CallbackInfo ci) {
        ResourcePackStatusC2SPacket.Status status = packet.getStatus();
        if (status != ResourcePackStatusC2SPacket.Status.ACCEPTED) this.invulnerableLoad = false;
    }

    @Override
    public @Unique boolean isInvulnerableLoad() {
        return this.invulnerableLoad;
    }
}
