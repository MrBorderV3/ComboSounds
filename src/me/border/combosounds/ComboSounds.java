package me.border.combosounds;

import me.border.combosounds.listener.PlayerDamageHandler;
import me.border.combosounds.util.Utils;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ComboSounds extends JavaPlugin {

    @Override
    public void onEnable(){
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        new Utils(this);
        registerHandler(new PlayerDamageHandler());
    }

    private void registerHandler(Listener listener){
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
