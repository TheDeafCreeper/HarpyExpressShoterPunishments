package com.thedeafcreeper.shooterpunishments.mixin;

import com.thedeafcreeper.shooterpunishments.Shooterpunishments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {
    @Inject(method = "onPlayerCollision", at = @At("HEAD"), cancellable = true)
    public void preventGunPickup(PlayerEntity player, CallbackInfo ci) {
        if (player.isCreative()) return;
        if (Shooterpunishments.preventGunPickup.contains(player)) ci.cancel();
    }
}
