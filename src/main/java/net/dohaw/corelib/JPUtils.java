package net.dohaw.corelib;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Map;

public class JPUtils {

    private static JavaPlugin instance = CoreLib.getInstance();

    public static void validateFiles(String... fileNames){
        for(String name : fileNames){
            File file = new File(instance.getDataFolder(), name);
            if(!file.exists()){
                instance.saveResource(name, false);
            }
        }
    }

    public static void validateFolders(Map<String, Object> folderInfo){
        for(Map.Entry<String, Object> info : folderInfo.entrySet()){
            String fileName = info.getKey();
            File path = (File) info.getValue();
            File file = new File(path, fileName);
            if(!file.exists()){
                file.mkdirs();
            }
        }
    }

    public static void registerCommand(String commandName, CommandExecutor exec){
        instance.getServer().getPluginCommand(commandName).setExecutor(exec);
    }

    public static void registerEvents(Listener... listeners){
        JavaPlugin plugin = CoreLib.getInstance();
        for(Listener l : listeners){
            Bukkit.getServer().getPluginManager().registerEvents(l, plugin);
        }
    }

}
