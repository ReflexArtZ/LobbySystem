/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Random;

public class SoundUtils {
    public static void playRandomSound(Player p) {
        Random random = new Random();
        p.playSound(p.getLocation(), getRandomSound(random.nextInt(21)), 1f, 1f);
    }
    private static Sound getRandomSound(int i) {
        switch (i) {
            case 0:
                return Sound.ANVIL_LAND;
            case 1:
                return Sound.ANVIL_USE;
            case 2:
                return Sound.ARROW_HIT;
            case 3:
                return Sound.BLAZE_HIT;
            case 4:
                return Sound.CAT_MEOW;
            case 5:
                return Sound.CHICKEN_EGG_POP;
            case 6:
                return Sound.COW_HURT;
            case 7:
                return Sound.CREEPER_HISS;
            case 8:
                return Sound.ENDERMAN_TELEPORT;
            case 9:
                return Sound.GHAST_FIREBALL;
            case 10:
                return Sound.EXPLODE;
            case 11:
                return Sound.IRONGOLEM_HIT;
            case 12:
                return Sound.NOTE_BASS_DRUM;
            case 13:
                return Sound.NOTE_PIANO;
            case 14:
                return Sound.NOTE_PLING;
            case 15:
                return Sound.NOTE_SNARE_DRUM;
            case 16:
                return Sound.SKELETON_HURT;
            case 17:
                return Sound.LEVEL_UP;
            case 18:
                return Sound.VILLAGER_HIT;
            case 19:
                return Sound.WITHER_SHOOT;
            case 20:
                return Sound.WOLF_HOWL;
        }
        return null;
    }
}
