package org.xtreemes.treasuretrove;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.xtreemes.treasuretrove.item.TroveItem;
import org.xtreemes.treasuretrove.player.listener.JoinLeaveEvent;

public final class TreasureTrove extends JavaPlugin {

    public static Plugin PLUGIN;

    @Override
    public void onEnable() {
        // Plugin startup logic
        PLUGIN = this;

        registerListeners(
                new JoinLeaveEvent()
        );

        // Items
        new TroveItem("test", Material.IRON_INGOT)
                .rarity(Rarity.RARE)
                .name("Awesome Iron")
                .addTag(new Tag("sigma", TextColor.color(0xD6879F)));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private static void registerListeners(Listener... listeners){
        for(Listener l : listeners){
            PLUGIN.getServer().getPluginManager().registerEvents(l, PLUGIN);
        }
    }

    // fancy little tag vro
    public record Tag(String text, TextColor colour){
        public Component asComponent(){
            String lowercaseText = text.toLowerCase();
            Component tag = Component.empty().font(Key.key("title")).decoration(TextDecoration.ITALIC, false);
            Component border = Component.text("=[" + ";|".repeat(lowercaseText.length()) + "']").color(colour);
            Component smallText = Component.text("=".repeat(lowercaseText.length()) + ";" + lowercaseText + "  ").color(NamedTextColor.WHITE);

            return tag.append(border).append(smallText);
        }
    }
}
