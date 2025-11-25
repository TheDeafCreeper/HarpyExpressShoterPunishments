package com.thedeafcreeper.shooterpunishments;

import com.thedeafcreeper.shooterpunishments.commands.SetShootInnocentPunishmentCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.player.PlayerEntity;

import java.util.HashSet;

public class Shooterpunishments implements ModInitializer {
    public enum ShootInnocentPunishment {
        DEFAULT,
        PREVENT_GUN_PICKUP,
        KILL_SHOOTER
    }

    public static ShootInnocentPunishment shootInnocentPunishment = ShootInnocentPunishment.DEFAULT;
    public static HashSet<PlayerEntity> preventGunPickup = new HashSet<>();

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
            SetShootInnocentPunishmentCommand.register(dispatcher);
        }));
    }
}
