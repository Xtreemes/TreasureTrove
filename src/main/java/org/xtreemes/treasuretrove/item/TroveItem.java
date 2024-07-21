package org.xtreemes.treasuretrove.item;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.xtreemes.treasuretrove.Rarity;
import org.xtreemes.treasuretrove.TreasureTrove;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

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
    private final ArrayList<TreasureTrove.Tag> TAGS = new ArrayList<>();
    private final Material MATERIAL;
    private final String ID;
    private String NAME = "No Name :(";
    private Rarity RARITY;

    private Consumer<PlayerInteractEvent> INTERACT_CONSUMER;

    public TroveItem(String id, Material material) {
        ITEMS.put(id, this);
        MATERIAL = material;
        ID = id;
        RARITY = Rarity.COMMON;
    }

    public ItemStack asItemStack() {
        ItemStack item = new ItemStack(MATERIAL);
        ItemMeta itemMeta = item.getItemMeta();

        ArrayList<Component> lore = new ArrayList<>();
        Component firstLine = Component.empty();
        ArrayList<TreasureTrove.Tag> tags = new ArrayList<>(TAGS);
        tags.addFirst(new TreasureTrove.Tag(RARITY.name(), RARITY.getColour()));
        for(TreasureTrove.Tag tag : tags){
            firstLine = firstLine.append(tag.asComponent());
        }
        lore.add(firstLine);
        itemMeta.lore(lore);

        itemMeta.itemName(Component.text(NAME));

        PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();
        pdc.set(ID_KEY, PersistentDataType.STRING, ID);

        item.setItemMeta(itemMeta);
        return item;
    }

    public TroveItem addTag(TreasureTrove.Tag tag){
        TAGS.add(tag);
        return this;
    }

    public Rarity rarity() {return RARITY;}
    public TroveItem rarity(Rarity rarity) {RARITY = rarity;return this;}


    public String name(){return NAME;}
    public TroveItem name(String name){NAME = name;return this;}

    public void interact(PlayerInteractEvent event){
        if(INTERACT_CONSUMER != null){
            INTERACT_CONSUMER.accept(event);
        }
    }
    public TroveItem interact(Consumer<PlayerInteractEvent> consumer){INTERACT_CONSUMER = consumer;return this;}
}
