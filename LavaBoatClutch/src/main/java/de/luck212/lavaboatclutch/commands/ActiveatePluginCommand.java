package de.luck212.lavaboatclutch.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ActiveatePluginCommand implements CommandExecutor {
    private boolean pluginIsActive = true;

    public ActiveatePluginCommand(){

    }
    //TODO auf alle Methoden noch anwenden
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(pluginIsActive){
                player.sendMessage("§aDas Plugin wird deaktiviert");
                pluginIsActive = false;
            }else{
                player.sendMessage("§aDas Plugin wird aktiviert");
                pluginIsActive = true;
            }

        }
        return false;
    }

    public boolean getPluginIsActive(){
        return pluginIsActive;
    }
}