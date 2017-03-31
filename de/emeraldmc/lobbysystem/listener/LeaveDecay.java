/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class LeaveDecay implements Listener {
    @EventHandler
    public void onLeaveDecay(LeavesDecayEvent e) {
        e.setCancelled(true);
        Debug.print("Prevented leave decay!");
    }
}
