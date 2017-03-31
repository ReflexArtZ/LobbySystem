/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PluginProtection implements Listener{
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (e.getPlayer().hasPermission("system.spy")) return;

        String cmd = e.getMessage();
        if (cmd.equalsIgnoreCase("/?")
                || cmd.equalsIgnoreCase("/plugins")
                || cmd.equalsIgnoreCase("/pl")
                || cmd.equalsIgnoreCase("/bukkit:plugins")
                || cmd.equalsIgnoreCase("/bukkit:pl")
                || cmd.equalsIgnoreCase("/version")
                || cmd.equalsIgnoreCase("/ver")
                || cmd.equalsIgnoreCase("/bukkit:version")
                || cmd.equalsIgnoreCase("/bukkit:ver")
                || cmd.equalsIgnoreCase("/about")
                || cmd.equalsIgnoreCase("/bukkit:about")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onTab(PlayerChatTabCompleteEvent e) {
        if (e.getPlayer().hasPermission("system.spy")) return;

        String cmd = e.getChatMessage();

        if (cmd.equalsIgnoreCase("/")
                || cmd.equalsIgnoreCase("/?")
                || cmd.equalsIgnoreCase("/plugins")
                || cmd.equalsIgnoreCase("/pl")
                || cmd.equalsIgnoreCase("/bukkit:plugins")
                || cmd.equalsIgnoreCase("/bukkit:pl")
                || cmd.equalsIgnoreCase("/version")
                || cmd.equalsIgnoreCase("/ver")
                || cmd.equalsIgnoreCase("/bukkit:version")
                || cmd.equalsIgnoreCase("/bukkit:ver")
                || cmd.equalsIgnoreCase("/about")
                || cmd.equalsIgnoreCase("/bukkit:about")) {
            return;
        }
    }
}
