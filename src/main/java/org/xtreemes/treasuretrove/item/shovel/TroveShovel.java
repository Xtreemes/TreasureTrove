package org.xtreemes.treasuretrove.item.shovel;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.EquipmentSlot;
import org.xtreemes.treasuretrove.TreasureTrove;
import org.xtreemes.treasuretrove.item.TroveItem;

public class TroveShovel extends TroveItem {
    public TroveShovel(String id, Material material) {
        super(id, material);
        addTag(new TreasureTrove.Tag("shovel", TextColor.color(0x696688)));
        interact((e) -> {
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getHand() == EquipmentSlot.HAND){
                Player p = e.getPlayer();
                e.setCancelled(true);
                p.sendMessage("i work!!!");
            }
        });
    }
}
