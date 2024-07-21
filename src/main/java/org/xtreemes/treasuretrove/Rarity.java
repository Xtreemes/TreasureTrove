package org.xtreemes.treasuretrove;

import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;

public enum Rarity {
    ERROR(NamedTextColor.RED),

    COMMON(NamedTextColor.GRAY),
    RARE(TextColor.color(0x5054E3)),
    EPIC(TextColor.color(0x9870CA)),
    LEGENDARY(TextColor.color(0xFFC34C));

    private final TextColor COLOUR;

    Rarity(TextColor colour){
        COLOUR = colour;
    }

    public TextColor getColour(){return COLOUR;}
}
