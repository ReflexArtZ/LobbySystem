/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.playerMenu;

import de.emeraldmc.lobbysystem.Main;
import de.emeraldmc.lobbysystem.utils.ChatAPI;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Configurator {
    private FileConfiguration cfg = PlayerManager.getPlayerFileConfiguration();
    private PlayerMenuData playerMenuData;
    private Player player;
    private Inventory inv;
    private String displayName;

    public Configurator(Player player) {
        if (!Main.getInstance().getConfiguartion().isConfigurator()) return;
        playerMenuData = new PlayerMenuData(player);
        load();
    }
    public Inventory build() {
        inv = Bukkit.createInventory(null, 27, displayName);
        if (Main.getInstance().getConfiguartion().isPlayerHider()) {
            inv.setItem(1, addPlayerHider());
            String name = Main.getInstance().getConfiguartion().getPlayerHiderName();
            inv.setItem(19, playerMenuData.isHidePlayers() ? addEnabledItem(name) : addDisabledItem(name));
        }
        if (Main.getInstance().getConfiguartion().isJumpItem()) {
            inv.setItem(3, addJumpItem());
            String name = Main.getInstance().getConfiguartion().getJumpItemName();
            inv.setItem(21, playerMenuData.isJump() ? addEnabledItem(name) : addDisabledItem(name));
        }
        if (Main.getInstance().getConfiguartion().isSpeedItem()) {
            inv.setItem(5, addSpeedItem());
            String name = Main.getInstance().getConfiguartion().getSpeedItemName();
            inv.setItem(23, playerMenuData.isSpeed() ? addEnabledItem(name) : addDisabledItem(name));
        }
        if (Main.getInstance().getConfiguartion().isLobbyParticleItem()) {
            inv.setItem(7, addLobbyParticleItem());
            String name = Main.getInstance().getConfiguartion().getLobbyParticleName();
            inv.setItem(25, playerMenuData.isParticles() ? addEnabledItem(name) : addDisabledItem(name));
        }
        return inv;
    }
    public void load() {
        playerMenuData.load();
        displayName = cfg.getString(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getConfiguratorName()));
    }
    private ItemStack addPlayerHider() {
        ItemStack hider = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta hiderMeta = hider.getItemMeta();
        hiderMeta.setDisplayName(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getPlayerHiderName()));
        hider.setItemMeta(hiderMeta);
        return hider;
    }
    private ItemStack addJumpItem() {
        ItemStack jump = new ItemStack(Material.ARROW);
        ItemMeta jumpMeta = jump.getItemMeta();
        jumpMeta.setDisplayName(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getJumpItemName()));
        jump.setItemMeta(jumpMeta);
        return jump;
    }
    private ItemStack addSpeedItem() {
        ItemStack speed = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta speedMeta = speed.getItemMeta();
        speedMeta.setDisplayName(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getSpeedItemName()));
        speed.setItemMeta(speedMeta);
        return speed;
    }
//    private static ItemStack getShopItem() {
//        ItemStack shop = new ItemStack(Material.EMERALD);
//        ItemMeta shopMeta = shop.getItemMeta();
//        shopMeta.setDisplayName(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getShopName()));
//        shop.setItemMeta(shopMeta);
//        return shop;
//    }
    private ItemStack addLobbyParticleItem() {
        ItemStack particle = new ItemStack(Material.SNOW_BALL);
        ItemMeta particleMeta = particle.getItemMeta();
        particleMeta.setDisplayName(ChatAPI.translateColor(Main.getInstance().getConfiguartion().getLobbyParticleName()));
        particle.setItemMeta(particleMeta);
        return particle;
    }
    private ItemStack addEnabledItem(String name) {
        ItemStack enabled = new ItemStack(Material.INK_SACK, 1, DyeColor.LIME.getData());
        ItemMeta enabledMeta = enabled.getItemMeta();
        enabledMeta.setDisplayName(ChatAPI.translateColor(name));
        enabled.setItemMeta(enabledMeta);
        return enabled;
    }
    private ItemStack addDisabledItem(String name) {
        ItemStack disabled = new ItemStack(Material.INK_SACK, 1, DyeColor.GRAY.getData());
        ItemMeta disabledMeta = disabled.getItemMeta();
        disabledMeta.setDisplayName(ChatAPI.translateColor(name));
        disabled.setItemMeta(disabledMeta);
        return disabled;
    }
}
