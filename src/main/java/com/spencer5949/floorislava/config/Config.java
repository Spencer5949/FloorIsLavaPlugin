package com.spencer5949.floorislava.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private static File file;
    private static FileConfiguration maps;


    //Creates or loads the config.yml file
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("FloorIsLava").getDataFolder(), "maps.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            }catch (IOException e){
                //:(
            }
        }
        maps = YamlConfiguration.loadConfiguration(file);

    }

    public static FileConfiguration get(){
        return maps;
    }

    public static void save(){
        try{
            maps.save(file);
        }catch(IOException e){
            System.out.println("Could not save file");
        }
    }

    public static void reload(){
        maps = YamlConfiguration.loadConfiguration(file);
    }

}
