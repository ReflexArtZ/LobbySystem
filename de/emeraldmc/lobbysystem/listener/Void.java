/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;


import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.utils.ChatAPI;
import de.emeraldmc.lobbysystem.utils.Debug;
import de.emeraldmc.lobbysystem.utils.TeleportUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Void implements Listener {

    @EventHandler
    public void onVoidEnter(EntityDamageEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
            e.setCancelled(true);
            ((Player) e.getEntity()).setHealth(((Player) e.getEntity()).getMaxHealth());
            TeleportUtils.teleportToLobby((Player) e.getEntity());
            ChatAPI.sendMessage((Player)e.getEntity(), Main.getInstance().getMessages().getLobbyMessage());
            Debug.print("Prevented "+e.getEntity().getName()+" fom falling into the void!");
        }
    }
}
