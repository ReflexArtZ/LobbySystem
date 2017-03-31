/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class UnknownCommand implements Listener {
    @EventHandler
    public void onCommandPreProcess(PlayerCommandPreprocessEvent e) {
        if (Bukkit.getHelpMap().getHelpTopic(e.getMessage().split(" ")[0]) == null) {
            if (Main.getInstance().getConfiguartion().isCustomUnknownMessage()) {
                e.getPlayer().sendMessage(Main.getInstance().getMessages().getCustomUnknownMessage());
                Debug.print("Sent CustomUnknownCommandMessage!");
                e.setCancelled(true);
            }
        }
    }
}
