/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.playerMenu.PlayerMenuData;
import de.emeraldmc.lobbysystem.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("");
        if (Main.getInstance().getConfiguartion().isJoinClearChat()) {
            for (int i = 0; i<25; i++) p.sendMessage("\n");
            Debug.print("Join-Cleared Chat of "+p.getName());
        }
        if (Main.getInstance().getConfiguartion().isJoinMessage()) {
            if (p.hasPermission("system.join.message")) {
                Bukkit.broadcastMessage(ChatAPI.translateColor(Main.getInstance().getMessages().getJoinMessage()));
                Debug.print("Sent Join-Message to "+p.getName());
            }
        }
        if (Main.getInstance().getConfiguartion().isJoinClearInventory()) {
            p.getInventory().clear();
            Debug.print("Cleared the inventory of "+p.getName());
        }
        if (Main.getInstance().getConfiguartion().isJoinMotd()) {
            p.sendMessage(ChatAPI.translateColor(Main.getInstance().getMessages().getMotd()));
            Debug.print("Sent MOTD to "+p.getName());
        }
        if (Main.getInstance().getConfiguartion().isWelcomeTitle()) {
            ChatAPI.sendTitle(p, 25, 25, 50, Main.getInstance().getMessages().getWelcomeTitle(), Main.getInstance().getMessages().getWelcomeSubTitle());
            Debug.print("Sent Title to "+p.getName());
        }
        PlayerMenuData playerMenuData = new PlayerMenuData(p);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (Main.getInstance().getConfiguartion().isJoinFirework()) {
                    if (p.hasPermission("system.join.firework")) {
                        FireworkUtils.spawnRandomFirework(p.getLocation());
                        Debug.print("Spawned random firework for "+p.getName());
                    }
                }
                if (Main.getInstance().getConfiguartion().isJoinLightning()) {
                    if (p.hasPermission("system.join.lightning")) {
                        LightningUtils.spawnLightning(p.getLocation());
                        Debug.print("Spawned random lightning for "+p.getName());
                    }
                }
                if (Main.getInstance().getConfiguartion().isJoinLobby()) {
                    TeleportUtils.teleportToLobby(p);
                    Debug.print("Teleported "+p.getName()+" to the lobby location!");
                }
                if (Main.getInstance().getConfiguartion().isJoinSound()) {
                    if (p.hasPermission("system.join.sound")) {
                        SoundUtils.playRandomSound(p);
                        Debug.print("Played random sound to "+p.getName());
                    }
                }
                p.setGameMode(GameMode.ADVENTURE);
                Debug.print("Set the Game-Mod to ADVENTURE for "+p.getName());
                p.setFoodLevel(100);
                Debug.print("Set the Food-Level to "+p.getFoodLevel()+" for "+p.getName());
                GadgetUtils.addGagdets(p);
                Debug.print("Added Gadgets to "+p.getName());
            }
        }, 5l);

    }
}
