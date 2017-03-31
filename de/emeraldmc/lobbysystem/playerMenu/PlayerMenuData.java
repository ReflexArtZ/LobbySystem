/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.playerMenu;

import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.regex.Pattern;

public class PlayerMenuData {
    private FileConfiguration cfg = PlayerManager.getPlayerFileConfiguration();
    private Player player;
    private boolean hidePlayers;
    private boolean jump;
    private boolean speed;
    private boolean particles;

    public PlayerMenuData(Player player) {
        setPlayer(player);
        if (!playerExist()) {
            add();
        }
        load();
    }
    public void setPlayer(Player player) {
        if (player == null) return;
        this.player = player;
    }
    public void setHidePlayers(boolean hidePlayers) {
        this.hidePlayers = hidePlayers;
    }
    public void setJump(boolean jump) {
        this.jump = jump;
    }
    public void setSpeed(boolean speed) {
        this.speed = speed;
    }

    public void setParticles(boolean particles) {
        this.particles = particles;
    }

    public Player getPlayer() {
        return player;
    }
    public boolean isHidePlayers() {
        return hidePlayers;
    }
    public boolean isJump() {
        return jump;
    }
    public boolean isSpeed() {
        return speed;
    }
    public boolean isParticles() {
        return particles;
    }

    public void add() {
        cfg.set("Players."+player.getUniqueId()+".hidePlayers", false);
        cfg.set("Players."+player.getUniqueId()+".jump", true);
        cfg.set("Players."+player.getUniqueId()+".speed", true);
        cfg.set("Players."+player.getUniqueId()+".particles", true);
        try {
            cfg.save(PlayerManager.getPlayerFile());
            Debug.print("Added Player "+player.getName()+" to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean playerExist() {
        if (player == null) {
            Debug.print("§cPlayer is null");
            return false;
        }
        for (String s : cfg.getKeys(true) ){
            if (s.equals("Players."+player.getUniqueId())) {
                Debug.print(player.getName()+" exists in the File");
                return true;
            }
        }
        Debug.print(player.getName()+" does not exist in the File");
        return false;
    }
    public void save() {
        cfg.set("Players."+player.getUniqueId()+".hidePlayers", hidePlayers);
        Debug.print("Updated HidePlayers from "+player.getName()+" to "+hidePlayers);
        cfg.set("Players."+player.getUniqueId()+".jump", jump);
        Debug.print("Updated Jump from "+player.getName()+" to "+jump);
        cfg.set("Players."+player.getUniqueId()+".speed", speed);
        Debug.print("Updated Speed from "+player.getName()+" to "+speed);
        cfg.set("Players."+player.getUniqueId()+".particle", particles);
        Debug.print("Updated Particles from "+player.getName()+" to "+particles);

        try {
            cfg.save(PlayerManager.getPlayerFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void load() {
        setHidePlayers(cfg.getBoolean("Players."+player.getUniqueId()+".hidePlayers"));
        Debug.print("Loaded HidePlayers from "+player.getName()+" enabled: "+hidePlayers);

        setJump(cfg.getBoolean("Players."+player.getUniqueId()+".jump"));
        Debug.print("Loaded Jump from "+player.getName()+" enabled: "+jump);

        setSpeed(cfg.getBoolean("Players."+player.getUniqueId()+".speed"));
        Debug.print("Loaded Speed from "+player.getName()+" enabled: "+speed);

        setParticles(cfg.getBoolean("Players."+player.getUniqueId()+".particles"));
        Debug.print("Loaded Particles from "+player.getName()+" enabled: "+particles);
    }
}
