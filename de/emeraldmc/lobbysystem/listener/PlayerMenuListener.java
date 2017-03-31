/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.playerMenu.PlayerMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerMenuListener implements Listener {
    @EventHandler
    public void onInvInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getItemInHand().equals(Material.SKULL_ITEM)) {
            if (!Main.getInstance().getConfiguartion().isPlayerMenu()) return;
            PlayerMenu playerMenu = new PlayerMenu(p);
            p.openInventory(playerMenu.build());
        }
    }
}
