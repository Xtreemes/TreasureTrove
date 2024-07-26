package org.xtreemes.treasuretrove.item.shovel;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.EquipmentSlot;
import org.xtreemes.treasuretrove.TreasureTrove;
import org.xtreemes.treasuretrove.item.TroveItem;
import org.xtreemes.treasuretrove.player.PlayerWrapper;

public class TroveShovel extends TroveItem {
    private final int SPEED;
    private final int FORTUNE;

    public TroveShovel(String id, Material material, int speed, int fortune) {
        super(id, material);

        SPEED = speed;
        FORTUNE = fortune;

        addTag(new TreasureTrove.Tag("shovel", TextColor.color(0x696688)));
        interact((e) -> {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getHand() == EquipmentSlot.HAND) {
                PlayerWrapper pw = PlayerWrapper.of(e.getPlayer());
                e.setCancelled(true);
                Block block = e.getClickedBlock();
                if(block != null){
                    if(block.getType() == Material.SAND){
                        pw.player.sendMessage(Component.text("digging sand me boy"));
                    }
                }
            }
        });
    }
}
