package org.xtreemes.treasuretrove.task;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.xtreemes.treasuretrove.TreasureTrove;

public class DiggingTask {
    private final Block BLOCK;
    private final BlockDisplay ENTITY;
    private final int SPEED;
    private final int FORTUNE;
    private final Player PLAYER;

    public DiggingTask(Player player, Block block, int speed, int fortune){
        BLOCK = block;
        SPEED = speed;
        FORTUNE = fortune;
        PLAYER = player;

        BLOCK.setType(Material.SMOOTH_SANDSTONE_SLAB);
        ENTITY = (BlockDisplay) PLAYER.getWorld().spawnEntity(BLOCK.getLocation(), EntityType.BLOCK_DISPLAY);
        ENTITY.setBlock(Material.SAND.createBlockData());


        // temporarily use a health value for all sand
        int timeToDig = 100 / SPEED;
        Bukkit.getScheduler().runTaskLater(TreasureTrove.PLUGIN, this::finish, timeToDig);
    }

    public void cancel(){
        BLOCK.setType(Material.SAND);
        ENTITY.remove();
    }
    private void finish(){
        ENTITY.remove();
    }
}
