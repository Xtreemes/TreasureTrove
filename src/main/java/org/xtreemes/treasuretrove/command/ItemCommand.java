package org.xtreemes.treasuretrove.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.xtreemes.treasuretrove.item.TroveItem;

public class ItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        String id = strings[0];
        Player p = (Player) commandSender;

        p.getInventory().addItem(TroveItem.of(id).asItemStack());

        return true;
    }
}
