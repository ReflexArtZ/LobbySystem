/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class NoXP implements Listener {
    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        e.setDroppedExp(0);
        Debug.print("Prevented "+e.getEntity().getName()+" from dropping Exp");
    }
}
