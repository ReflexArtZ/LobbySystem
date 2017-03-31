/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.utils;

import de.emeraldmc.lobbysystem.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * API for sending information in different types to the user
 * @author Patrick Sommer
 */
public class ChatAPI {
    /**
     * Sends a title to the user
     * @param p the user
     * @param fadeIn time to fade the title in
     * @param fadeOut time to fade the title out
     * @param stay time the title will stay on the screen
     * @param title the title
     * @param subTitle a smaller subtitle under the main title
     */
    public static void sendTitle(Player p, int fadeIn, int fadeOut, int stay, String title, String subTitle) {
        PlayerConnection connection = ((CraftPlayer)p).getHandle().playerConnection;
        PacketPlayOutTitle packetPlayOut = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn, stay, fadeOut);
        connection.sendPacket(packetPlayOut);
        if (title != null) {
            title = ChatColor.translateAlternateColorCodes('&', title);
            IChatBaseComponent titleComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
            PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleComponent);
            connection.sendPacket(packetPlayOutTitle);
        }
        if (subTitle != null) {
            subTitle = ChatColor.translateAlternateColorCodes('&', subTitle);
            IChatBaseComponent titleComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subTitle + "\"}");
            PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleComponent);
            connection.sendPacket(packetPlayOutTitle);
        }
    }

    /**
     * If actionBarMessages are turned on the user will get the information in his actionBar, else the user will get a normal chat message
     * @param p the user
     * @param msg the message
     */
    public static void sendMessage(Player p, String msg) {
        msg = PlaceholderAPI.setPlaceholders(p, msg);
        if (Main.getInstance().getConfiguartion().isActionBar()) {
            IChatBaseComponent chatBaseComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + msg + "\"}");
            PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(chatBaseComponent, (byte) 2);
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packetPlayOutChat);
            return;
        }
        p.sendMessage(msg);
    }

    public static String translateColor(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
