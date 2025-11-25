package com.thedeafcreeper.shooterpunishments.mixin;

import com.thedeafcreeper.shooterpunishments.Shooterpunishments;
import dev.doctor4t.trainmurdermystery.api.GameMode;
import dev.doctor4t.trainmurdermystery.game.GameFunctions;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameFunctions.class)
public class GameFunctionsMixin {
    @Inject(method = "startGame", at = @At("HEAD"))
    private static void startGame(ServerWorld world, GameMode gameMode, int time, CallbackInfo ci) {
        Shooterpunishments.preventGunPickup.clear();
    }
}
