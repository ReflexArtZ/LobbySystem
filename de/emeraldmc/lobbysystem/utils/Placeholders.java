/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.utils;

import de.emeraldmc.lobbysystem.Main;
import me.clip.placeholderapi.external.EZPlaceholderHook;
import org.bukkit.entity.Player;

public class Placeholders extends EZPlaceholderHook{
    private Main plugin;

    public Placeholders(Main plugin) {
        super(plugin, "lobby");
        this.plugin = plugin;
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {
        if (p == null) {
            return "";
        }
        return null;
    }
}
