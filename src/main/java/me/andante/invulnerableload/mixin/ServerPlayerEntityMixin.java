package me.andante.invulnerableload.mixin;

import me.andante.invulnerableload.ServerPlayNetworkHandlerAccess;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {
    @Shadow public ServerPlayNetworkHandler networkHandler;

    @Inject(method = "isInvulnerableTo", at = @At("HEAD"), cancellable = true)
    private void onIsInvulnerableTo(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (((ServerPlayNetworkHandlerAccess) this.networkHandler).isInvulnerableLoad()) {
            cir.setReturnValue(true);
        }
    }
}
