package com.thedeafcreeper.shooterpunishments.mixin;

import com.thedeafcreeper.shooterpunishments.Shooterpunishments;
import dev.doctor4t.trainmurdermystery.TMM;
import dev.doctor4t.trainmurdermystery.cca.GameWorldComponent;
import dev.doctor4t.trainmurdermystery.game.GameFunctions;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "dev.doctor4t.trainmurdermystery.util.GunShootPayload$Receiver")
public class GunShootPayloadMixin {
    @Inject(method = "lambda$receive$2", at = @At("HEAD"), remap = false, cancellable = true)
    private static void onShootInnocent(ServerPlayNetworking.Context context, ServerPlayerEntity player, Item revolver, CallbackInfo ci) {
        if (player.isCreative()) return;

        switch (Shooterpunishments.shootInnocentPunishment) {
            case DEFAULT: break;
            case PREVENT_GUN_PICKUP: Shooterpunishments.preventGunPickup.add(player); break;
            case KILL_SHOOTER: {
                var game = GameWorldComponent.KEY.get(player.getWorld());
                if (!game.isInnocent(player)) return;

                ci.cancel();
                GameFunctions.killPlayer(player, true, player, TMM.id("shot_innocent"));
                break;
            }
        }
    }
}