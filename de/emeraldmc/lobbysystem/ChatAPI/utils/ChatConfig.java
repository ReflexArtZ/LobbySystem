/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.ChatAPI.utils;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public class ChatConfig {
    private FileConfiguration cfg;

    private final String format;
    private final boolean playerPong;
    //private final HashMap<String, String> placeholders;

    public ChatConfig() {
        cfg = ChatConfigManager.getConfigFileConfiguration();
        format = cfg.getString("Config.format");
        playerPong = cfg.getBoolean("Config.playerPong");
       //placeholders = ChatPlaceholders.readFile();
    }

    public FileConfiguration getCfg() {
        return cfg;
    }

    public String getFormat() {
        return format;
    }

    public boolean isPlayerPong() {
        return playerPong;
    }

    /*public HashMap<String, String> getPlaceholders() {
        return placeholders;
    }*/
}
