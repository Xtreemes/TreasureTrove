package org.xtreemes.treasuretrove.player.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.xtreemes.treasuretrove.player.PlayerWrapper;
import org.xtreemes.treasuretrove.task.DiggingTask;

public class JoinLeaveEvent implements Listener {
    @EventHandler
    private void playerJoin(PlayerJoinEvent e) {
        PlayerWrapper pw = PlayerWrapper.of(e.getPlayer());
    }

    @EventHandler
    private void playerLeave(PlayerQuitEvent e) {
        PlayerWrapper pw = PlayerWrapper.of(e.getPlayer());
        DiggingTask digging = pw.digging();
        if(digging != null){
            digging.cancel();
        }
        PlayerWrapper.removePlayer(e.getPlayer());
    }

}
