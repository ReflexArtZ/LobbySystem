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

/**
 * Creates, loads and fills the Message-Configuration file so the user can configure it
 * @author Patrick Sommer
 */
public class MessageManager {
    public static File getMessageFile() {
        return new File("plugins/LobbySystem", "messages.yml");
    }
    public static FileConfiguration getMessageFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getMessageFile());
    }

    public static void setMessages() {
        FileConfiguration cfg = getMessageFileConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("Messages.prefix", "&8> &a&lL&7obby &8 | &7");
        cfg.addDefault("Messages.joinMessage", "&a> %playerMenu%");
        cfg.addDefault("Messages.quitMessage", "&c< %playerMenu%");
        cfg.addDefault("Messages.lobbyMessage", "Woosh!");
        cfg.addDefault("Messages.hide", "Alle Spieler sind nun unsichtbar!");
        cfg.addDefault("Messages.show", "Alle Spieler sind nun sichtbar!");
        cfg.addDefault("Messages.welcomeTitle", "&aWillkommen %playerMenu% auf EmeraldMc!");
        cfg.addDefault("Messages.welcomeSubTitle", "&a%server%");
        cfg.addDefault("Messages.customUnknownMessage", "Unbekannter Befehl!");
        ArrayList<String> announcements = new ArrayList<>();
        announcements.add("%prefix% Teamspeak: Ts.EmeraldMc.de");
        cfg.addDefault("Messages.announcements", announcements);
        try {
            cfg.save(getMessageFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readMessages() {
        FileConfiguration msg = getMessageFileConfiguration();
    }
}
