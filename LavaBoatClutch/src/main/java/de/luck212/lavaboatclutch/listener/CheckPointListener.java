package de.luck212.lavaboatclutch.listener;

import de.luck212.lavaboatclutch.main.Main;
import de.luck212.lavaboatclutch.utils.ConfigLocationUtil;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CheckPointListener implements Listener {

    Main plugin;

    public CheckPointListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onCheckPointStep(PlayerMoveEvent event){
        if(!(plugin.getActivatePlugin().getPluginIsActive())) return;
        Player player = event.getPlayer();
        ConfigLocationUtil configLocationUtil = null;
        if(player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.GOLD_BLOCK){
            configLocationUtil = new ConfigLocationUtil(plugin, "checkpoint." + player.getName(), player.getLocation());
            configLocationUtil.saveLocation();
        }

    }

    @EventHandler
    public void handleFoodLose(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }
}
