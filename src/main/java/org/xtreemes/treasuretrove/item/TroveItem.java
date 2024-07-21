package org.xtreemes.treasuretrove.item;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.xtreemes.treasuretrove.Rarity;
import org.xtreemes.treasuretrove.TreasureTrove;

import java.util.ArrayList;
import java.util.HashMap;

public class TroveItem {
    // Static
    private static final HashMap<String, TroveItem> ITEMS = new HashMap<>();
    private static final NamespacedKey ID_KEY = NamespacedKey.fromString("id", TreasureTrove.PLUGIN);

    public static TroveItem of(String id) {
        return ITEMS.getOrDefault(id, new TroveItem("error", Material.STONE));
    }

    public static TroveItem of(ItemStack item) {
        PersistentDataContainer pdc = item.getItemMeta().getPersistentDataContainer();
        String id = pdc.get(ID_KEY, PersistentDataType.STRING);
        return ITEMS.getOrDefault(id, new TroveItem("error", Material.STONE));
    }

    // Object
    private final Material MATERIAL;
    private final String ID;
    private Rarity RARITY;

    public TroveItem(String id, Material material) {
        ITEMS.put(id, this);
        MATERIAL = material;
        ID = id;
        RARITY = Rarity.COMMON;
    }

    public ItemStack asItemStack() {
        ItemStack item = new ItemStack(MATERIAL);
        ItemMeta itemMeta = item.getItemMeta();
        ArrayList<Component> lore = new ArrayList<Component>();

        // Lore
        lore.add(new TreasureTrove.Tag(RARITY.name(), RARITY.getColour()).asComponent());

        itemMeta.lore(lore);
        // Lore end

        PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();
        pdc.set(ID_KEY, PersistentDataType.STRING, ID);

        item.setItemMeta(itemMeta);
        return item;
    }


    public Rarity rarity() {
        return RARITY;
    }

    public TroveItem rarity(Rarity rarity) {
        RARITY = rarity;
        return this;
    }
}
