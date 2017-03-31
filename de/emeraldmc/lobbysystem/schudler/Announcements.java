/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.schudler;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.utils.Debug;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;

import java.util.ArrayList;

public class Announcements {
    private boolean enabled;
    private boolean announcements;
    private Object[] messages;
    private int interval;
    private int taskId;
    private int index;

    public Announcements() {
        setEnabled(Main.getInstance().getConfiguartion().isAnnouncer());
        if (!isEnabled()) return;
        setInterval(Main.getInstance().getConfiguartion().getAnnouncerInterval());
        setMessages(Main.getInstance().getMessages().getAnnouncements());
    }
    public void start() {
        if (!enabled) return;
        if (announcements) stop();
        announcements = true;
        taskId = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(PlaceholderAPI.setPlaceholders(null, nextMessage()));
            }
        }, 0l, 20l*interval);
        Debug.print("Starting Announcement Task with the id= "+taskId);
    }
    public void stop() {
        if (!enabled) return;
        Bukkit.getServer().getScheduler().cancelTask(taskId);
        announcements = false;
        Debug.print("Cancelled Announcement Task with the id= "+taskId);
    }

    private String nextMessage() {
        if (index >= messages.length) {
            index = 0;
        }
        return (String)messages[index++];
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setInterval(int interval) {
        if (interval < 0) return;
        this.interval = interval;
    }

    public void setMessages(ArrayList<String> messages) {
        if (messages == null) return;
        this.messages = messages.toArray();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isAnnouncements() {
        return announcements;
    }

    public int getInterval() {
        return interval;
    }

    public int getTaskId() {
        return taskId;
    }
}
