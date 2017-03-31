/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class NoMobSpawn implements Listener {
    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent e) {
        if (e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.CHUNK_GEN)) {
            boolean noMobSpawn = Main.getInstance().getConfiguartion().isNoMobSpawn();
            e.setCancelled(noMobSpawn);
            Debug.print("Prevented spawning of "+e.getEntity().getName()+": "+noMobSpawn);
        }
    }
}
