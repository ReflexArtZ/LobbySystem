/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.playerMenu;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.utils.ChatAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerMenu {
    private String configuratorName;
    private String voteToolName;
    private Player player;
    private Inventory inv;
    //ToDo: Zeitung, Abstimmungen, Statistiken, Freunde

    public PlayerMenu(Player player) {
        setPlayer(player);
    }
    public void setPlayer(Player player) {
        if (player == null)return;
        this.player = player;
    }
    public Inventory build() {
        inv = Bukkit.createInventory(null, 9, ChatAPI.translateColor(Main.getInstance().getConfiguartion().getPlayerMenuName()));
        if (Main.getInstance().getConfiguartion().isConfigurator()) {
            inv.setItem(Main.getInstance().getConfiguartion().getConfiguratorSlot(), addConfigurator());
        }
        if (Main.getInstance().getConfiguartion().isVoteTool()) {
            inv.setItem(Main.getInstance().getConfiguartion().getVoteToolSlot(), addVoteTool());
        }
        return inv;
    }
    private ItemStack addConfigurator() {
        ItemStack configurator = new ItemStack(Material.REDSTONE_COMPARATOR_ON);
        ItemMeta configuratorMeta = configurator.getItemMeta();
        configuratorMeta.setDisplayName(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getConfiguratorName()));
        configurator.setItemMeta(configuratorMeta);
        return configurator;
    }
    private ItemStack addVoteTool() {
        ItemStack voteTool = new ItemStack(Material.NETHER_STAR);
        ItemMeta voteToolMeta = voteTool.getItemMeta();
        voteToolMeta.setDisplayName(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getVoteToolName()));
        return voteTool;
    }
}
