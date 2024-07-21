package org.xtreemes.treasuretrove;

import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;

public enum Rarity {
    COMMON(NamedTextColor.GRAY),
    RARE(TextColor.color(0x96B4E5));

    private final TextColor COLOUR;

    Rarity(TextColor colour){
        COLOUR = colour;
    }

    public TextColor getColour(){return COLOUR;}
}
