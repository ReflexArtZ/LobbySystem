/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Weather implements Listener {
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        e.setCancelled(Main.getInstance().getConfiguartion().isNoWeatherChange());
        if (e.isCancelled()) {
            Debug.print("Prevented a weather change");
        }
    }
}
