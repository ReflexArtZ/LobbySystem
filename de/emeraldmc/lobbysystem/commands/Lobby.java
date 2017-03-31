/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.commands;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.utils.ChatAPI;
import de.emeraldmc.lobbysystem.utils.ConfigManager;
import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Lobby implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setlobby")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§c[-] §7You have to do this while you are in game!");
                return false;
            }
            Player p = (Player)sender;
            if (!p.hasPermission("system.setlobby")) {
                Debug.print(p.getName()+"has no permissions!");
                return false;
            }
            Location loc = p.getLocation();
            Debug.print("Location of Player "+p.getName()+"\n"+loc.toString());
            FileConfiguration cfg = Main.getInstance().getConfiguartion().getCfg();
            cfg.set("Config.Lobby.world", loc.getWorld().getName());
            cfg.set("Config.Lobby.x", loc.getX());
            cfg.set("Config.Lobby.y", loc.getY());
            cfg.set("Config.Lobby.z", loc.getZ());
            cfg.set("Config.Lobby.yaw", loc.getYaw());
            cfg.set("Config.Lobby.pitch", loc.getPitch());
            try {
                cfg.save(ConfigManager.getConfigFile());
                Debug.print("Lobby position saved in config!");
                ChatAPI.sendMessage(p, "&aLobby set!");
            } catch (IOException e) {
                ChatAPI.sendMessage(p, "&cThere was a problem setting the lobby!");
                Bukkit.getConsoleSender().sendMessage("§c[-] §7There was a problem setting the lobby!");
                e.printStackTrace();
            }
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("lobby") || cmd.getName().equalsIgnoreCase("hub") || cmd.getName().equalsIgnoreCase("spawn")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§c[-] §7You have to do this while you are in game!");
                return false;
            }
            Player p = (Player)sender;
            Location loc = Main.getInstance().getConfiguartion().getLobbyLocation();
            p.teleport(loc);
            Debug.print("Teleported "+p.getName()+" to the spawn!");
            Debug.print("Spawn: "+"\n"+loc.toString());
            ChatAPI.sendMessage(p, Main.getInstance().getMessages().getLobbyMessage());
            return true;
        }
        return false;
    }
}
