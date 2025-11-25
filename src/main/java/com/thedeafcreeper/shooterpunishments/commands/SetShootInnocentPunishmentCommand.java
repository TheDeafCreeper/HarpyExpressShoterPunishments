package com.thedeafcreeper.shooterpunishments.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.thedeafcreeper.shooterpunishments.Shooterpunishments;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class SetShootInnocentPunishmentCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("setShootInnocentPunishment")
                        .requires(source -> source.hasPermissionLevel(2))
                        .then(CommandManager.literal("default")
                                .executes(context -> {
                                    Shooterpunishments.shootInnocentPunishment = Shooterpunishments.ShootInnocentPunishment.DEFAULT;
                                    context.getSource().sendMessage(Text.of("Set shoot innocent punishment to default."));
                                    return 1;
                                })
                        )
                        .then(CommandManager.literal("preventGunPickup")
                                .executes(context -> {
                                    Shooterpunishments.shootInnocentPunishment = Shooterpunishments.ShootInnocentPunishment.PREVENT_GUN_PICKUP;
                                    context.getSource().sendMessage(Text.of("Set shoot innocent punishment to Prevent Gun Pickup."));
                                    return 1;
                                })
                        )
                        .then(CommandManager.literal("killShooter")
                                .executes(context -> {
                                    Shooterpunishments.shootInnocentPunishment = Shooterpunishments.ShootInnocentPunishment.KILL_SHOOTER;
                                    context.getSource().sendMessage(Text.of("Set shoot innocent punishment to Kill Shooter."));
                                    return 1;
                                })
                        )
        );
    }
}
