package me.andante.invulnerableload.mixin;

import me.andante.invulnerableload.ServerPlayNetworkHandlerAccess;
import net.minecraft.network.packet.c2s.play.ResourcePackStatusC2SPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin implements ServerPlayNetworkHandlerAccess {
    private boolean invulnerableLoad = true;

    @Inject(method = "onResourcePackStatus", at = @At("TAIL"))
    private void onOnResourcePackStatus(ResourcePackStatusC2SPacket packet, CallbackInfo ci) {
        ResourcePackStatusC2SPacket.Status status = packet.getStatus();
        if (status != ResourcePackStatusC2SPacket.Status.ACCEPTED) {
            this.invulnerableLoad = false;
        }
    }

    @Override
    public boolean isInvulnerableLoad() {
        return this.invulnerableLoad;
    }
}
