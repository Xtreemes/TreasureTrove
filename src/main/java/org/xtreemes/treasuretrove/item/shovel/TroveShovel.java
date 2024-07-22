package org.xtreemes.treasuretrove.item.shovel;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.xtreemes.treasuretrove.TreasureTrove;
import org.xtreemes.treasuretrove.item.TroveItem;

public class TroveShovel extends TroveItem {
    public TroveShovel(String id, Material material) {
        super(id, material);
        addTag(new TreasureTrove.Tag("shovel", TextColor.color(0x696688)));
    }
}
