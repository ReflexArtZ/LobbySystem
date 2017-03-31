/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.utils.ChatAPI;
import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("");
        if (Main.getInstance().getConfiguartion().isQuitMessage()) {
            if (p.hasPermission("system.quit.message")) {
                Bukkit.broadcastMessage(ChatAPI.translateColor(Main.getInstance().getMessages().getQuitMessage()));
                Debug.print("Sent Quit-Message for "+p.getName());
            }
        }
    }
}
