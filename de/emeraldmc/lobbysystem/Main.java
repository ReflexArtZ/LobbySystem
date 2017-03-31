package de.emeraldmc.lobbysystem;

import de.emeraldmc.lobbysystem.ChatAPI.*;
import de.emeraldmc.lobbysystem.ChatAPI.ChatAPI;
import de.emeraldmc.lobbysystem.ChatAPI.utils.*;
import de.emeraldmc.lobbysystem.commands.Lobby;
import de.emeraldmc.lobbysystem.listener.*;
import de.emeraldmc.lobbysystem.listener.Void;
import de.emeraldmc.lobbysystem.playerMenu.PlayerManager;
import de.emeraldmc.lobbysystem.playerMenu.PlayerMenuData;
import de.emeraldmc.lobbysystem.schudler.Announcements;
import de.emeraldmc.lobbysystem.schudler.NoTimeChange;
import de.emeraldmc.lobbysystem.utils.*;
import de.emeraldmc.lobbysystem.utils.Config;
import de.emeraldmc.lobbysystem.utils.ConfigManager;
import me.stst.placeholders.ActionAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;


public class Main extends JavaPlugin {

    private static Main instance;

    private Config config;
    private Messages messages;
    private ChatConfig chatConfig;
    private NoTimeChange noTimeChange;
    private Announcements announcements;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("\n"+"\n");
        Bukkit.getConsoleSender().sendMessage("§8###########################################################################################################################");
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a /$$                 /$$       /$$                          /$$$$$$                        /$$                            ");
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a| $$                | $$      | $$                         /$$__  $$                      | $$                            ");
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a| $$        /$$$$$$ | $$$$$$$ | $$$$$$$  /$$   /$$        | $$  \\__/ /$$   /$$  /$$$$$$$ /$$$$$$    /$$$$$$  /$$$$$$/$$$$ ");
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a| $$       /$$__  $$| $$__  $$| $$__  $$| $$  | $$ /$$$$$$|  $$$$$$ | $$  | $$ /$$_____/|_  $$_/   /$$__  $$| $$_  $$_  $$");
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a| $$      | $$  \\ $$| $$  \\ $$| $$  \\ $$| $$  | $$|______/ \\____  $$| $$  | $$|  $$$$$$   | $$    | $$$$$$$$| $$ \\ $$ \\ $$");
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a| $$      | $$  | $$| $$  | $$| $$  | $$| $$  | $$         /$$  \\ $$| $$  | $$ \\____  $$  | $$ /$$| $$_____/| $$ | $$ | $$");
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a| $$$$$$$$|  $$$$$$/| $$$$$$$/| $$$$$$$/|  $$$$$$$        |  $$$$$$/|  $$$$$$$ /$$$$$$$/  |  $$$$/|  $$$$$$$| $$ | $$ | $$");
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a|________/ \\______/ |_______/ |_______/  \\____  $$         \\______/  \\____  $$|_______/    \\___/   \\_______/|__/ |__/ |__/");
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a§7 version "+this.getDescription().getVersion()+"§a                             /$$  | $$                   /$$  | $$                                            ");
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a                                        |  $$$$$$/                  |  $$$$$$/                                            ");
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a                                         \\______/                    \\______/                          ");
        initializeFiles();
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a[+] §7Files initialized!");
        registerEvents();
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a[+] §7Events registered!");
        registerCommands();
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a[+] §7Commands registered!");
        noTimeChange = new NoTimeChange();
        noTimeChange.start();
        announcements = new Announcements();
        announcements.start();
        Bukkit.getConsoleSender().sendMessage("§8#"+"§a[+] §7Scheduler started!");
        Bukkit.getConsoleSender().sendMessage("§8###########################################################################################################################");
    }
    @Override
    public void onDisable() {
        if (noTimeChange != null) {
            noTimeChange.stop();
        }
        if (announcements != null) {
            announcements.stop();
        }
    }

    private void initializeFiles() {
        ConfigManager.readConfig();
        ConfigManager.setConfig();
        MessageManager.readMessages();
        MessageManager.setMessages();
        ChatConfigManager.readConfig();
        ChatConfigManager.setConfig();
        PlayerManager.readConfig();
        PlayerManager.setConfig();
        Motd.checkIfFileExist();
        ChatPlaceholders.checkIfFileExist();
        config = new Config();
        messages = new Messages();
        chatConfig = new ChatConfig();

        ActionAPI.addExternalReplacer();
    }
    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new ConfigurationGUI(), this);
        Bukkit.getPluginManager().registerEvents(new ItemMove(), this);
        Bukkit.getPluginManager().registerEvents(new Join(), this);
        Bukkit.getPluginManager().registerEvents(new Quit(), this);
        Bukkit.getPluginManager().registerEvents(new Void(), this);
        Bukkit.getPluginManager().registerEvents(new Damage(), this);
        Bukkit.getPluginManager().registerEvents(new DoubleJump(), this);
        Bukkit.getPluginManager().registerEvents(new TeleportBow(), this);
        Bukkit.getPluginManager().registerEvents(new Weather(), this);
        Bukkit.getPluginManager().registerEvents(new ChatAPI(), this);
        Bukkit.getPluginManager().registerEvents(new Death(), this);
        Bukkit.getPluginManager().registerEvents(new Explosion(), this);
        Bukkit.getPluginManager().registerEvents(new FireSpread(), this);
        Bukkit.getPluginManager().registerEvents(new FoodLevel(), this);
        Bukkit.getPluginManager().registerEvents(new LeaveDecay(), this);
        Bukkit.getPluginManager().registerEvents(new NoXP(), this);
        Bukkit.getPluginManager().registerEvents(new PluginProtection(), this);
        Bukkit.getPluginManager().registerEvents(new UnknownCommand(), this);
        Bukkit.getPluginManager().registerEvents(new NoMobSpawn(), this);

    }
    private void registerCommands() {
        getCommand("setlobby").setExecutor(new Lobby());
        getCommand("lobby").setExecutor(new Lobby());
        getCommand("hub").setExecutor(new Lobby());
        getCommand("spawn").setExecutor(new Lobby());
    }
    public static Main getInstance() {
        return instance;
    }
    public Config getConfiguartion() {
        return config;
    }
    public Messages getMessages() {
        return messages;
    }
    public ChatConfig getChatConfig() {
        return chatConfig;
    }
}
