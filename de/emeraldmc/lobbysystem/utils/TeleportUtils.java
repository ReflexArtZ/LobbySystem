/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.utils;

import de.emeraldmc.lobbysystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TeleportUtils {
    public static void teleportToLobby(Player p) {
        Location location = Main.getInstance().getConfiguartion().getLobbyLocation();
        try {
            p.teleport(location);
        } catch (NullPointerException e) {
            Bukkit.getConsoleSender().sendMessage("§c[-] §7Lobby world not set!");
            e.printStackTrace();
        }
    }
}
