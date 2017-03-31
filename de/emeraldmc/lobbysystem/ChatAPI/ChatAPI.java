/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.ChatAPI;

import de.emeraldmc.lobbysystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.permissions.Permission;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.regex.Pattern;

public class ChatAPI implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        PermissionUser user = PermissionsEx.getUser(p.getName());

        String msg = e.getMessage();
        String prefix = user.getPrefix(p.getWorld().getName());
        String suffix = user.getSuffix(p.getWorld().getName());
        /*
        StringBuilder prefixes = new StringBuilder();
        StringBuilder suffixes = new StringBuilder();

        for (PermissionGroup group : user.getGroups()) {
            prefixes.append(translateColor(group.getPrefix()));
            suffixes.append(translateColor(group.getSuffix()));
        }
        */
        String message = msg;
        if (p.hasPermission("chatapi.colors")) {
            message = translateColor(message);
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (msg.contains(player.getDisplayName())) {
                String name = PermissionsEx.getUser(player.getName()).getPrefix(player.getWorld().getName())+player.getDisplayName();
                message = message.replaceAll(player.getDisplayName(), name);
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1f, 1f);
                System.out.println(name);
                break;
            }
            if (msg.contains(player.getName())) {
                String name = PermissionsEx.getUser(player.getName()).getPrefix(player.getWorld().getName())+player.getDisplayName();
                message = message.replaceAll(player.getName(), name);
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1f, 1f);
                System.out.println(name);
                break;
            }
        }
        /* ToDo: Next update
        String[] words = msg.split(Pattern.quote(" "));
        for (String s : words) {
            if (Main.getInstance().getChatConfig().getPlaceholders().get(s.toLowerCase()) != null) {
                msg = msg.replaceAll(s, Main.getInstance().getChatConfig().getPlaceholders().get(s));
            }
        }
        */
        String formatted = translateColor(Main.getInstance().getChatConfig().getFormat().replaceAll(Pattern.quote("{PREFIX}"), prefix)
                .replaceAll(Pattern.quote("{DISPLAYNAME}"), p.getDisplayName())
                .replaceAll(Pattern.quote("{SUFFIX}"), suffix)
                .replaceAll(Pattern.quote("{MESSAGE}"), message));
        Bukkit.broadcastMessage(formatted);
        e.setCancelled(true);
    }

    private static String translateColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
