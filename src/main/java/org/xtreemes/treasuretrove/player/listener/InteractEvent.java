package org.xtreemes.treasuretrove.player.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.xtreemes.treasuretrove.item.TroveItem;

public class InteractEvent implements Listener {
    @EventHandler
    private void playerInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        TroveItem.of(p.getInventory().getItemInMainHand()).interact(e);
    }
}
