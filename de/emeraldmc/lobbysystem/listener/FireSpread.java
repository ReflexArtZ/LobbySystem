/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;

public class FireSpread implements Listener {
    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent e) {
        if (e.getCause().equals(BlockIgniteEvent.IgniteCause.SPREAD)) {
            e.setCancelled(true);
            Debug.print("Prevening BlockIgnite: "+e.getCause());
        }
    }
}
