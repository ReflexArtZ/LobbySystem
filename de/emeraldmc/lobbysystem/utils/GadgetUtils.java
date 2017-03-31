/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.utils;

import de.emeraldmc.lobbysystem.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class GadgetUtils {
    public static void addGagdets(Player p) {
        if (Main.getInstance().getConfiguartion().isTeleportBow()) {
            p.getInventory().setItem(Main.getInstance().getConfiguartion().getTeleportBowSlot(), getTeleportBow());
            p.getInventory().setItem(35, getTeleportArrow());
        }
        if (Main.getInstance().getConfiguartion().isPlayerMenu()) {
            p.getInventory().setItem(Main.getInstance().getConfiguartion().getPlayerMenuSlot(), getPlayerMenu(p));
        }

    }
    private static ItemStack getTeleportBow() {
        ItemStack bow = new ItemStack(Material.BOW, 1);
        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getTeleportBowName()));
        ArrayList<String> bowLore = (ArrayList<String>) Main.getInstance().getConfiguartion().getTeleportBowLore();
        ArrayList<String> lore = new ArrayList<>();
        for (String s : bowLore) {
            lore.add(ChatAPI.translateColor(s));
        }
        bowMeta.setLore(lore);
        bow.setItemMeta(bowMeta);
        return bow;
    }
    private static ItemStack getTeleportArrow() {
        return new ItemStack(Material.ARROW, 1);
    }
    private static ItemStack getPlayerMenu(Player p) {
        ItemStack playerMenu = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ItemMeta playerMenuMeta = playerMenu.getItemMeta();
        SkullMeta sm = (SkullMeta) playerMenuMeta;
        sm.setOwner(p.getName());
        sm.setDisplayName(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getPlayerMenuName()));
        playerMenu.setItemMeta(sm);
        return playerMenu;
    }
    private static ItemStack getVoteToolItem() {
        ItemStack voteTool = new ItemStack(Material.NETHER_STAR);
        ItemMeta voteToolMeta = voteTool.getItemMeta();
        voteToolMeta.setDisplayName(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getVoteToolName()));
        voteTool.setItemMeta(voteToolMeta);
        return voteTool;
    }
}
