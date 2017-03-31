/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.utils.Debug;
import de.emeraldmc.lobbysystem.utils.GadgetUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;


public class Death implements Listener {
     @EventHandler
    public void onDeath(PlayerDeathEvent e) {
         GadgetUtils.addGagdets(e.getEntity());
         e.getDrops().clear();
         Debug.print("Cleared Drops of "+e.getEntity().getName()+" and added Gadgets to this Player!");
     }

     @EventHandler
    public void onAnimalDeath(EntityDeathEvent e) {
         e.getDrops().clear();
         Debug.print("Cleared Drops of "+e.getEntity().getName());
     }
}
