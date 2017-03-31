/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemMove implements Listener {
    @EventHandler
    public void onDrop(PlayerDropItemEvent e)
    {
        if (e.getPlayer().getGameMode() == GameMode.ADVENTURE) {
            e.setCancelled(true);
            Debug.print("Prevented item drop from "+e.getPlayer().getName());
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onMove(InventoryClickEvent e)
    {
        if (e.getWhoClicked().getGameMode() == GameMode.ADVENTURE) {
            e.setCancelled(true);
            Debug.print("Prevented item move from "+e.getWhoClicked().getName());
        } else {
            e.setCancelled(false);
        }
    }

}
