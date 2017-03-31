/*
 * Copyright (c) 2017 Patrick Sommer
 * You don't have the permission to distribute or modify this source code except you are an official Developer of EmeraldMc
 */

package de.emeraldmc.lobbysystem.utils;

import java.io.*;

/**
 * Structure for creating and reading the motd
 * @author Patrick Sommer
 */
public class Motd {
    private static File file = new File("plugins/LobbySystem", "motd.txt");

    /**
     * If the file motd don't exist it will create one
     * @return if the motd exist it will return true, else it will return false
     */
    public static boolean checkIfFileExist() {
        if (file.exists()) return true;
        createFile();
        return false;
    }

    /**
     * Simply create the motd file
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
     * Read the motd file
     * @return the information of the motd file
     */
    public static String readFile() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));


            String line;
            String text = new String();
            while ((line=reader.readLine()) != null) {
                text += line+"\n";
            }
            reader.close();
            return text;
        } catch (FileNotFoundException e) {
            System.out.println("[-] Error reading MOTD file!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("[-] Error reading MOTD file!");
            e.printStackTrace();
        }
        return null;
    }
}
