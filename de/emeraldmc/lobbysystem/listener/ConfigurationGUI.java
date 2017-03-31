/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.listener;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.playerMenu.Configurator;
import de.emeraldmc.lobbysystem.playerMenu.PlayerMenuData;
import de.emeraldmc.lobbysystem.utils.ChatAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ConfigurationGUI implements Listener {
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getName().equals(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getPlayerMenuName()))) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getConfiguratorName()))) {
                Configurator configurator = new Configurator(p);
                p.openInventory(configurator.build());
            }
        }
        if (e.getClickedInventory().getName().equals(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getConfiguratorName()))) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.getInstance().getConfiguartion().getPlayerHiderName())) {
                if (e.getCurrentItem().equals(new ItemStack(Material.INK_SACK))) {
                    PlayerMenuData playerMenuData = new PlayerMenuData(p);
                    if (playerMenuData.isHidePlayers()) {
                        playerMenuData.setHidePlayers(false);
                    } else {
                        playerMenuData.setHidePlayers(true);
                    }
                }
            }
        }
    }

}
