package org.xtreemes.treasuretrove.player.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.xtreemes.treasuretrove.item.TroveItem;
import org.xtreemes.treasuretrove.player.PlayerWrapper;

public class JoinLeaveEvent implements Listener {
    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        PlayerWrapper pw = PlayerWrapper.of(e.getPlayer());
        pw.player.getInventory().addItem(TroveItem.of("test").asItemStack());
    }

    @EventHandler
    public void playerLeave(PlayerQuitEvent e) {
        PlayerWrapper.removePlayer(e.getPlayer());
    }

}
