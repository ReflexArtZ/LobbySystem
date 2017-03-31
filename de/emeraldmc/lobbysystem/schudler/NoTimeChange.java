/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.schudler;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.utils.Debug;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class NoTimeChange {
    private boolean enabled;
    private boolean noTimeChange;
    private World lobby;
    private int time;
    private int taskId;

    public NoTimeChange() {
        setEnabled(Main.getInstance().getConfiguartion().isNoTimeChange());
        if (!isEnabled()) return;
        setLobby(Main.getInstance().getConfiguartion().getLobbyLocation().getWorld());
        setTime(Main.getInstance().getConfiguartion().getTime());
    }
    public void start() {
        if (!enabled) return;
        if (noTimeChange) stop();
        noTimeChange = true;
        taskId = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                lobby.setTime(time);
                Debug.print("Setting time to: "+time);
            }
        }, 0l, 20l*10l);
        Debug.print("Starting NoTimeChange Task with the id= "+taskId);
    }
    public void stop() {
        if (!enabled) return;
        Bukkit.getServer().getScheduler().cancelTask(taskId);
        noTimeChange = false;
        Debug.print("Cancelled NoTimeChange Task with the id= "+taskId);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setLobby(World lobby) {
        if (lobby == null) return;
        this.lobby = lobby;
    }

    public void setTime(int time) {
        if (time < 0 || time > 24000) return;
        this.time = time;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isNoTimeChange() {
        return noTimeChange;
    }

    public World getLobby() {
        return lobby;
    }

    public int getTime() {
        return time;
    }

    public int getTaskId() {
        return taskId;
    }
}
