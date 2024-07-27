package org.xtreemes.treasuretrove.player;

import org.bukkit.entity.Player;
import org.xtreemes.treasuretrove.task.DiggingTask;

import javax.annotation.Nullable;
import java.util.HashMap;

public class PlayerWrapper {
    // Static
    private static final HashMap<Player, PlayerWrapper> PLAYERS = new HashMap<>();

    public static PlayerWrapper of(Player player){
        return PLAYERS.computeIfAbsent(player, PlayerWrapper::new);
    }
    public static void removePlayer(Player player){
        PLAYERS.remove(player);
    }

    // Object
    public final Player player;
    private DiggingTask digging;

    public PlayerWrapper(Player player){
        this.player = player;
    }

    public @Nullable DiggingTask digging(){
        return digging;
    }
    public void digging(@Nullable DiggingTask digging){
        this.digging = digging;
    }
}
