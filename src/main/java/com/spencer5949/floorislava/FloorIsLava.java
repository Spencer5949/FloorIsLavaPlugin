package com.spencer5949.floorislava;

import com.spencer5949.floorislava.commands.fl;
import com.spencer5949.floorislava.config.Config;
import com.spencer5949.floorislava.events.ClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class FloorIsLava extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fl").setExecutor(new fl());

        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        Config.setup();

        Config.get().options().copyDefaults(true);
        Config.save();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
