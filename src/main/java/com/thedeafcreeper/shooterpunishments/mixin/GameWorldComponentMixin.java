package com.thedeafcreeper.shooterpunishments.mixin;

import com.thedeafcreeper.shooterpunishments.Shooterpunishments;
import dev.doctor4t.trainmurdermystery.cca.GameWorldComponent;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameWorldComponent.class)
public class GameWorldComponentMixin {
    @Inject(method = "readFromNbt", at = @At("HEAD"))
    private void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup, CallbackInfo ci) {
        Shooterpunishments.shootInnocentPunishment = Shooterpunishments.ShootInnocentPunishment.valueOf(nbtCompound.getString("shootInnocentPunishment"));
    }

    @Inject(method = "writeToNbt", at = @At("HEAD"))
    private void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup, CallbackInfo ci) {
        nbtCompound.putString("shootInnocentPunishment", Shooterpunishments.shootInnocentPunishment.name());
    }
}
