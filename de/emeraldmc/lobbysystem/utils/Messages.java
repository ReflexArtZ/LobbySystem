/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.utils;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Datastructure for getting the Messages
 * @author Patrick Sommer
 */
public class Messages {
    private FileConfiguration msg;

    private final String prefix;
    private final String joinMessage;
    private final String quitMessage;
    private final String lobbyMessage;
    private final String motd;
    private final String hideMessage;
    private final String showMessage;
    private final String welcomeTitle;
    private final String welcomeSubTitle;
    private final String customUnknownMessage;
    private final ArrayList<String> announcements;

    public Messages() {
        msg = MessageManager.getMessageFileConfiguration();
        prefix = msg.getString("Messages.prefix");
        joinMessage = msg.getString("Messages.joinMessage");
        quitMessage = msg.getString("Messages.quitMessage");
        lobbyMessage = msg.getString("Messages.lobbyMessage");
        motd = Motd.readFile();
        hideMessage = msg.getString("Messages.hide");
        showMessage = msg.getString("Messages.show");
        welcomeTitle = msg.getString("Messages.welcomeTitle");
        welcomeSubTitle = msg.getString("Messages.welcomeSubTitle");
        customUnknownMessage = msg.getString("Messages.customUnknownMessage");
        announcements = new ArrayList<>(msg.getStringList("Messages.announcements"));
    }

    public FileConfiguration getMsg() {
        return msg;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getJoinMessage() {
        return joinMessage;
    }

    public String getQuitMessage() {
        return quitMessage;
    }

    public String getLobbyMessage() {
        return lobbyMessage;
    }

    public String getMotd() {
        return motd;
    }

    public String getHideMessage() {
        return hideMessage;
    }

    public String getShowMessage() {
        return showMessage;
    }

    public String getWelcomeTitle() {
        return welcomeTitle;
    }

    public String getWelcomeSubTitle() {
        return welcomeSubTitle;
    }

    public String getCustomUnknownMessage() {
        return customUnknownMessage;
    }

    public ArrayList<String> getAnnouncements() {
        return announcements;
    }
}
