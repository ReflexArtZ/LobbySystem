/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import javax.persistence.Entity;

public class Explosion implements Listener{
    @EventHandler
    public void onEntityExplosion(EntityExplodeEvent e) {
        if (!(e instanceof Player)) {
            e.setCancelled(true);
            Debug.print("Prevented "+e.getEntity().getName()+" from exploding!");
        }
    }
}
