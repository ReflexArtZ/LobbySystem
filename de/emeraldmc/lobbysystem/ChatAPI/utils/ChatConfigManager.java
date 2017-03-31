/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.ChatAPI.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ChatConfigManager {
    public static File getConfigFile() {
        return new File("plugins/LobbySystem/ChatAPI", "config.yml");
    }
    public static FileConfiguration getConfigFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }

    public static void setConfig() {
        FileConfiguration cfg = getConfigFileConfiguration();
        cfg.addDefault("Config.format", "{PREFIX}{DISPLAYNAME} &a> &7{MESSAGE}");
        cfg.addDefault("Config.playerPong", true);
        cfg.options().copyDefaults(true);
        try {
            cfg.save(getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readConfig() {
        FileConfiguration cfg = getConfigFileConfiguration();
    }
}
