/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

/**
 * Created by Gamer on 12.02.2017.
 */
public class TeleportBow implements Listener {

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e)
    {
        Projectile pro = e.getEntity();
        if ((pro instanceof Arrow))
        {
            Arrow arrow = (Arrow)pro;
            if ((arrow.getShooter() instanceof Player))
            {
                Player p = (Player)arrow.getShooter();
                p.getItemInHand().setDurability((short)0);
                Location destination = arrow.getLocation();
                destination.setPitch(p.getLocation().getPitch());
                destination.setYaw(p.getLocation().getYaw());
                p.teleport(destination);
                p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);
                p.spigot().playEffect(p.getLocation(), Effect.LAVA_POP, 3, 0, 1, 1, 2, 0.5f, 25, 2);
                e.getEntity().remove();
                Debug.print("Teleported "+p.getName()+" with the Bow!");
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e)
    {
        if (e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onDeath(EntityDeathEvent e)
    {
        e.getDrops().clear();
    }
}
