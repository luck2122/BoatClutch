package de.luck212.lavaboatclutch.main;

import de.luck212.lavaboatclutch.commands.ActiveatePluginCommand;
import de.luck212.lavaboatclutch.listener.CheckPointListener;
import de.luck212.lavaboatclutch.listener.DeathListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    ActiveatePluginCommand activeatePluginCommand;
    //TODO noch einen /pieps command einbauen der einen booelan verändert der dann abfrag ob was passieren soll oder nicht
    @Override
    public void onEnable() {
        activeatePluginCommand = new ActiveatePluginCommand();
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new CheckPointListener(this), this);
        pluginManager.registerEvents(new DeathListener(this), this);
        getCommand("startplugin").setExecutor(activeatePluginCommand);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ActiveatePluginCommand getActivatePlugin(){
        return activeatePluginCommand;
    }
}
