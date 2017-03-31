/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.ChatAPI.utils;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Pattern;
public class ChatPlaceholders {
    private static File file = new File("plugins/LobbySystem/ChatAPI", "placeholders.txt");

    /**
     * If the file placeholder file don't exist it will create one
     * @return if the placeholder file exist it will return true, else it will return false
     */
    public static boolean checkIfFileExist() {
        if (file.exists()) return true;
        createFile();
        return false;
    }

    /**
     * Simply create the placeholder file
     */
    private static void createFile() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("[-] Error creating MOTD file!");
            e.printStackTrace();
        }
    }

    /**
     * Read the placeholder file
     * @return the information of the placeholder file
     */
    public static HashMap<String, String> readFile() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            String text = new String();
            while ((line=reader.readLine()) != null) {
                text += line;
            }
            text = text.trim();
            char[] chars = text.toCharArray();
            int z = 0;
            for (char c : chars) {
                if (c == ';') {
                    z++;
                }
            }
            String[] placeholders = text.split(Pattern.quote(";"));
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i<placeholders.length; i++) {
                map.put(placeholders[i].split(Pattern.quote(","))[0].toLowerCase(), placeholders[i].split(Pattern.quote(","))[1].toLowerCase());
            }
            reader.close();
            return map;
        } catch (FileNotFoundException e) {
            System.out.println("[-] Error reading ChatPlaceholders file!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("[-] Error reading ChatPlaceholders file!");
            e.printStackTrace();
        }
        return null;
    }

}
