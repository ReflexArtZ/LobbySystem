/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.utils;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

/**
 * Datastructure for getting the configuration
 * @author Patrick Sommer
 */
public class Config {
    private FileConfiguration cfg;

    private final boolean debug;
    private final boolean actionBar;
    private final boolean announcer;
    private final int announcerInterval;
    private final boolean joinSound;
    private final boolean joinLightning;
    private final boolean joinClearInventory;
    private final boolean joinClearChat;
    private final boolean joinLobby;
    private final boolean joinFirework;
    private final boolean joinMotd;
    private final boolean joinMessage;
    private final boolean quitMessage;
    private final boolean voidTeleport;
    private final boolean noWeatherChange;
    private final boolean playerHider;
    private final String playerHiderName;
    private final boolean speedItem;
    private final String speedItemName;
    private final boolean jumpItem;
    private final String jumpItemName;
    private final boolean shop;
    private final String shopName;
    private final boolean lobbyParticleItem;
    private final String lobbyParticleName;
    private final boolean playerMenu;
    private final String playerMenuName;
    private final int playerMenuSlot;
    private final List<String> playerMenuLore;
    private final boolean noDamage;
    private final boolean customUnknownMessage;
    private final boolean teleportBow;
    private final int teleportBowSlot;
    private final String teleportBowName;
    private final List<String> teleportBowLore;
    private final boolean doubleJump;
    private final int doubleJumpHeight;
    private final int doubleJumpLength;
    private final boolean jumpPad;
    private final int jumpPadheight;
    private final int jumpPadlength;
    private final boolean welcomeTitle;
    private final boolean noMobSpawn;
    private final boolean noFireSpread;
    private final boolean noTimeChange;
    private final int time;
    private final boolean noItemMove;
    private final boolean configurator;
    private final int configuratorSlot;
    private final String configuratorName;
    private final boolean voteTool;
    private final int voteToolSlot;
    private final String voteToolName;
    private final Location lobbyLocation;

    public Config() {
        cfg = ConfigManager.getConfigFileConfiguration();

        debug = cfg.getBoolean("Config.debug");
        actionBar = cfg.getBoolean("Config.actionBarMessages");
        announcer = cfg.getBoolean("Config.announcer");
        announcerInterval = cfg.getInt("Config.Announcer.interval");
        joinSound = cfg.getBoolean("Config.joinSound");
        joinLightning = cfg.getBoolean("Config.joinLightning");
        joinClearInventory = cfg.getBoolean("Config.joinClearInventory");
        joinClearChat = cfg.getBoolean("Config.joinClearChat");
        joinLobby = cfg.getBoolean("Config.joinLobby");
        joinFirework = cfg.getBoolean("Config.joinFirework");
        joinMotd = cfg.getBoolean("Config.joinMotd");
        joinMessage = cfg.getBoolean("Config.joinMessage");
        quitMessage = cfg.getBoolean("Config.quitMessage");
        voidTeleport = cfg.getBoolean("Config.voidTeleport");
        noWeatherChange = cfg.getBoolean("Config.noWeatherChange");
        playerHider = cfg.getBoolean("Config.playerHider");
        playerHiderName = cfg.getString("Config.PlayerHider.name");
        speedItem = cfg.getBoolean("Config.speedItem");
        speedItemName = cfg.getString("Config.SpeedItem.name");
        jumpItem = cfg.getBoolean("Config.jumpItem");
        jumpItemName = cfg.getString("Config.JumpItem.name");
        lobbyParticleItem = cfg.getBoolean("Config.lobbyParticleItem");
        lobbyParticleName = cfg.getString("Config.LobbyParticleItem.name");
        shop = cfg.getBoolean("Config.shop");
        shopName = cfg.getString("Config.Shop.name");
        noDamage = cfg.getBoolean("Config.noDamage");
        customUnknownMessage = cfg.getBoolean("Config.customUnknownMessage");
        teleportBow = cfg.getBoolean("Config.teleportBow");
        teleportBowSlot = cfg.getInt("Config.TeleportBow.slot")-1;
        teleportBowName = cfg.getString("Config.TeleportBow.name");
        teleportBowLore = cfg.getStringList("Config.TeleportBow.lore");
        doubleJump = cfg.getBoolean("Config.doubleJump");
        doubleJumpHeight = cfg.getInt("Config.DoubleJump.height");
        doubleJumpLength = cfg.getInt("Config.DoubleJump.length");
        jumpPad = cfg.getBoolean("Config.jumpPad");
        jumpPadheight = cfg.getInt("Config.JumpPad.height");
        jumpPadlength = cfg.getInt("Config.JumpPad.length");
        playerMenu = cfg.getBoolean("Config.playerMenu");
        playerMenuName = cfg.getString("Config.PlayerMenu.name");
        playerMenuLore = cfg.getStringList("Config.PlayerMenu.lore");
        playerMenuSlot = cfg.getInt("Config.PlayerMenu.slot")-1;
        welcomeTitle = cfg.getBoolean("Config.welcomeTitle");
        noMobSpawn = cfg.getBoolean("Config.noMobSpawn");
        noFireSpread = cfg.getBoolean("Config.noFireSpread");
        noTimeChange = cfg.getBoolean("Config.noTimeChange");
        time = cfg.getInt("Config.NoTimeChange.time");
        noItemMove = cfg.getBoolean("Config.noItemMove");
        configurator = cfg.getBoolean("Config.configurator");
        configuratorSlot = cfg.getInt("Config.Configurator.slot")-1;
        configuratorName = cfg.getString("Config.Configurator.name");
        voteTool = cfg.getBoolean("Config.voteTool");
        voteToolSlot = cfg.getInt("Config.VoteTool.slot")-1;
        voteToolName = cfg.getString("Config.VoteTool.name");
        lobbyLocation = new Location(Bukkit.getWorld(cfg.getString("Config.Lobby.world")),
                cfg.getDouble("Config.Lobby.x"),
                cfg.getDouble("Config.Lobby.y"),
                cfg.getDouble("Config.Lobby.z"),
                (float) cfg.getDouble("Config.Lobby.yaw"),
                (float) cfg.getDouble("Config.Lobby.pitch"));
    }

    public FileConfiguration getCfg() {
        return cfg;
    }

    public boolean isDebug() {
        return debug;
    }

    public boolean isActionBar() {
        return actionBar;
    }

    public boolean isAnnouncer() {
        return announcer;
    }

    public int getAnnouncerInterval() {
        return announcerInterval;
    }

    public boolean isJoinSound() {
        return joinSound;
    }

    public boolean isJoinLightning() {
        return joinLightning;
    }

    public boolean isJoinClearInventory() {
        return joinClearInventory;
    }

    public boolean isJoinClearChat() {
        return joinClearChat;
    }

    public boolean isJoinLobby() {
        return joinLobby;
    }

    public boolean isJoinFirework() {
        return joinFirework;
    }

    public boolean isJoinMotd() {
        return joinMotd;
    }

    public boolean isJoinMessage() {
        return joinMessage;
    }

    public boolean isQuitMessage() {
        return quitMessage;
    }

    public boolean isVoidTeleport() {
        return voidTeleport;
    }

    public boolean isNoWeatherChange() {
        return noWeatherChange;
    }

    public boolean isPlayerHider() {
        return playerHider;
    }

    public boolean isSpeedItem() {
        return speedItem;
    }

    public String getSpeedItemName() {
        return speedItemName;
    }

    public boolean isJumpItem() {
        return jumpItem;
    }

    public String getJumpItemName() {
        return jumpItemName;
    }

    public boolean isShop() {
        return shop;
    }

    public boolean isLobbyParticleItem() {
        return lobbyParticleItem;
    }

    public String getLobbyParticleName() {
        return lobbyParticleName;
    }

    public boolean isNoDamage() {
        return noDamage;
    }

    public boolean isCustomUnknownMessage() {
        return customUnknownMessage;
    }

    public boolean isTeleportBow() {
        return teleportBow;
    }

    public int getTeleportBowSlot() {
        return teleportBowSlot;
    }

    public String getTeleportBowName() {
        return teleportBowName;
    }

    public List<String> getTeleportBowLore() {
        return teleportBowLore;
    }

    public boolean isDoubleJump() {
        return doubleJump;
    }

    public int getDoubleJumpHeight() {
        return doubleJumpHeight;
    }

    public int getDoubleJumpLength() {
        return doubleJumpLength;
    }

    public boolean isJumpPad() {
        return jumpPad;
    }

    public int getJumpPadheight() {
        return jumpPadheight;
    }

    public int getJumpPadlength() {
        return jumpPadlength;
    }

    public boolean isWelcomeTitle() {
        return welcomeTitle;
    }

    public boolean isNoMobSpawn() {
        return noMobSpawn;
    }

    public boolean isNoFireSpread() {
        return noFireSpread;
    }

    public boolean isNoItemMove() {
        return noItemMove;
    }

    public boolean isConfigurator() {
        return configurator;
    }

    public int getConfiguratorSlot() {
        return configuratorSlot;
    }

    public String getConfiguratorName() {
        return configuratorName;
    }


    public boolean isVoteTool() {
        return voteTool;
    }

    public int getVoteToolSlot() {
        return voteToolSlot;
    }

    public String getVoteToolName() {
        return voteToolName;
    }

    public Location getLobbyLocation() {
        return lobbyLocation;
    }

    public boolean isNoTimeChange() {
        return noTimeChange;
    }

    public int getTime() {
        return time;
    }

    public String getPlayerHiderName() {
        return playerHiderName;
    }

    public String getShopName() {
        return shopName;
    }

    public boolean isPlayerMenu() {
        return playerMenu;
    }

    public String getPlayerMenuName() {
        return playerMenuName;
    }

    public List<String> getPlayerMenuLore() {
        return playerMenuLore;
    }

    public int getPlayerMenuSlot() {
        return playerMenuSlot;
    }
}
