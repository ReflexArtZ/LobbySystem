/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.utils;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;

public class LightningUtils {
    public static void spawnLightning(Location loc) {
        loc.getWorld().strikeLightningEffect(loc);
    }
}
