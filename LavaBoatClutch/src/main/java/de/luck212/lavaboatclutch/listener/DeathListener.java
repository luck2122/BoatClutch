package de.luck212.lavaboatclutch.listener;

import de.luck212.lavaboatclutch.main.Main;
import de.luck212.lavaboatclutch.utils.ConfigLocationUtil;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class DeathListener implements Listener {

    Main plugin;

    public DeathListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void handlePlayerDeath(PlayerDeathEvent event){
        if(!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if(!(plugin.getActivatePlugin().getPluginIsActive())){
            player.sendMessage("§cDas Plugin ist deaktiviert.");
            return;
        }

        if(event.getEntity().getKiller() != null){
            event.getDrops().clear();
            return;
        }else{
            event.getDrops().clear();
            player.getInventory().clear();
            for(int i = 0; i <= player.getInventory().getSize(); i++){
                if(player.getInventory().getItem(i) == null)
                    player.getInventory().setItem(i, new ItemStack(Material.OAK_BOAT));
            }
            player.getInventory().setChestplate(null);
            player.getInventory().setBoots(null);
            player.getInventory().setHelmet(null);
            player.getInventory().setLeggings(null);
            player.getInventory().setItemInOffHand(null);
        }
    }

    @EventHandler
    public void handleRespawn(PlayerRespawnEvent event){
        if(!(plugin.getActivatePlugin().getPluginIsActive())) return;
        Player player = event.getPlayer();
        ConfigLocationUtil configLocationUtil = new ConfigLocationUtil(plugin, "checkpoint." + player.getName());
        event.setRespawnLocation(configLocationUtil.loadLocation());
    }
}
