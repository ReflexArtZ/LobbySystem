/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates, loads and fills the Config file so the user can configure it
 * @author Patrick Sommer
 */
public class ConfigManager {
    public static File getConfigFile() {
        return new File("plugins/LobbySystem", "config.yml");
    }
    public static FileConfiguration getConfigFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }

    public static void setConfig() {
        FileConfiguration cfg = getConfigFileConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("Config.debug", false);
        cfg.addDefault("Config.actionBarMessages", true);
        cfg.addDefault("Config.announcer", true);
        cfg.addDefault("Config.Announcer.interval", 60);
        cfg.addDefault("Config.joinSound", true);
        cfg.addDefault("Config.joinLightning", true);
        cfg.addDefault("Config.joinClearInventory", true);
        cfg.addDefault("Config.joinClearChat", true);
        cfg.addDefault("Config.joinLobby", true);
        cfg.addDefault("Config.joinFirework", true);
        cfg.addDefault("Config.joinMotd", true);
        cfg.addDefault("Config.joinMessage", true);
        cfg.addDefault("Config.quitMessage", true);
        cfg.addDefault("Config.voidTeleport", true);
        cfg.addDefault("Config.noWeatherChange", true);
        cfg.addDefault("Config.playerHider", true);
        cfg.addDefault("Config.PlayerHider.name", "&c&lH&7ider");
        cfg.addDefault("Config.speedItem", true);
        cfg.addDefault("Config.SpeedItem.name", "&c&lS&7peed");
        cfg.addDefault("Config.jumpItem", true);
        cfg.addDefault("Config.JumpItem.name", "&c&lJ&7ump");
        cfg.addDefault("Config.lobbyParticleItem", true);
        cfg.addDefault("Config.LobbyParticleItem.name", "&c&lP&7artikel");
        cfg.addDefault("Config.shop", false);
        cfg.addDefault("Config.Shop.name", "&c&lS&7hop");
        cfg.addDefault("Config.noDamage", true);
        cfg.addDefault("Config.customUnknownMessage", true);
        cfg.addDefault("Config.teleportBow", true);
        cfg.addDefault("Config.TeleportBow.slot", 7);
        cfg.addDefault("Config.TeleportBow.name", "&a&lT&7eleport&a&lB&7ow");
        List<String> lore = new ArrayList<>();
        lore.add("&aSchieße dich mit dem Bogen davon!");
        cfg.addDefault("Config.TeleportBow.lore", lore);
        cfg.addDefault("Config.doubleJump", true);
        cfg.addDefault("Config.DoubleJump.height", 3);
        cfg.addDefault("Config.DoubleJump.length", 6);
        cfg.addDefault("Config.jumpPad", true);
        cfg.addDefault("Config.JumpPad.height", 3);
        cfg.addDefault("Config.JumpPad.length", 6);
        cfg.addDefault("Config.playerMenu", true);
        cfg.addDefault("Config.PlayerMenu.name", "%player%");
        lore = new ArrayList<>();
        lore.add("&aSieh dir deine Stats an oder Konfiguriere ein paar sachen!");
        cfg.addDefault("Config.PlayerMenu.lore", lore);
        cfg.addDefault("Config.PlayerMenu.slot", 9);
        cfg.addDefault("Config.welcomeTitle", true);
        cfg.addDefault("Config.noMobSpawn", true);
        cfg.addDefault("Config.noFireSpread", true);
        cfg.addDefault("Config.noTimeChange", true);
        cfg.addDefault("Config.NoTimeChange.time", 2000);
        cfg.addDefault("Config.noItemMove", true);
        cfg.addDefault("Config.configurator", true);
        cfg.addDefault("Config.Configurator.slot", 5);
        cfg.addDefault("Config.Configurator.name", "&a&lS&7ettings");
        lore = new ArrayList<>();
        lore.add("&aStelle ein paar Sachen ein!");
        cfg.addDefault("Config.voteTool", true);
        cfg.addDefault("Config.VoteTool.slot", 9);
        cfg.addDefault("Config.VoteTool.name", "&c&lV&7ote");
        cfg.addDefault("Config.Lobby.world", "lobby");
        cfg.addDefault("Config.Lobby.x", 0D);
        cfg.addDefault("Config.Lobby.y", 0D);
        cfg.addDefault("Config.Lobby.z", 0D);
        cfg.addDefault("Config.Lobby.yaw", 0D);
        cfg.addDefault("Config.Lobby.pitch", 0D);
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