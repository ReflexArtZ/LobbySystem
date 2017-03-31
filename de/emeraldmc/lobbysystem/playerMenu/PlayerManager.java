/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.playerMenu;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerManager {
    public static File getPlayerFile() {
        return new File("plugins/LobbySystem", "playerMenu.yml");
    }
    public static FileConfiguration getPlayerFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getPlayerFile());
    }
    public static void setConfig() {
        FileConfiguration cfg = getPlayerFileConfiguration();
        cfg.options().copyDefaults(true);
        try {
            cfg.save(getPlayerFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readConfig() {
        FileConfiguration cfg = getPlayerFileConfiguration();
    }
}
