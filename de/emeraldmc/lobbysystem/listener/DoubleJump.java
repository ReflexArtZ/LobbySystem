/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJump implements Listener {
    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent e)
    {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (!p.hasPermission("system.doubleJump")) {
            return;
        }
        e.setCancelled(true);
        p.setAllowFlight(false);
        p.setFlying(false);
        p.setVelocity(p.getLocation().getDirection().multiply(4.8D).setY(1.5D));
        p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 2.0F, 1.0F);
        p.spigot().playEffect(p.getLocation(), Effect.LAVA_POP, 3, 0, 1, 1, 2, 0.5f, 25, 2);
        Debug.print("Player "+e.getPlayer().getName()+" double jumped!");
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onPlayerMove(PlayerMoveEvent e)
    {
        Player p = e.getPlayer();
        if ((p.getGameMode() != GameMode.CREATIVE) && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR) && (!p.isFlying())) {
            p.setAllowFlight(true);
        }
    }
}
