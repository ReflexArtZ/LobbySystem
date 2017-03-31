/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.utils;

import de.emeraldmc.lobbysystem.Main;
import org.bukkit.Bukkit;

public class Debug {
    public static void print(String s) {
        if (Main.getInstance().getConfiguartion().isDebug()) {
            Bukkit.getConsoleSender().sendMessage("§aLobbySystem §6[Debug] §7"+s);
        }
    }
}
