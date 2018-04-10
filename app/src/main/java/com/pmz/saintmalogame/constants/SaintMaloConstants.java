package com.pmz.saintmalogame.constants;

import com.pmz.saintmalogame.enums.SpaceSymbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.pmz.saintmalogame.enums.SpaceSymbol.*;

public class SaintMaloConstants {

    private SaintMaloConstants() {}

    public static final Map<SpaceSymbol, String> SPACE_SYMBOLS_IMAGE_NAMES_MAP;
    public static final List<String> DICE_IMAGES_MAP;
    public static final String SPACE_SYMBOLS_IMAGE_NAMES_PREFIX = "space_symbol_";
    public static final String DICE_IMAGE_PREFIX = "dice";

    static {
        SPACE_SYMBOLS_IMAGE_NAMES_MAP = new HashMap<>();
        DICE_IMAGES_MAP = new ArrayList<>();
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CRATE, "crate");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CROSS_LVL_1, "cross1");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CROSS_LVL_2, "cross2");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CROSS_LVL_3, "cross3");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CROSS_LVL_4, "cross4");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CROSS_LVL_5, "cross5");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(HOUSE, "house");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_CITIZEN, "person_citizen");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_SOLDIER, "person_soldier");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_PRIEST, "person_priest");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_ARCHITECT, "person_architect");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_MERCHANT, "person_merchant");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_JUGGLER, "person_juggler");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_NOBLE, "person_noble");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(WALL, "wall");

        DICE_IMAGES_MAP.add(0, "pirate");
        DICE_IMAGES_MAP.add(1, "crate");
        DICE_IMAGES_MAP.add(2, "tree");
        DICE_IMAGES_MAP.add(3, "wall");
        DICE_IMAGES_MAP.add(4, "church");
        DICE_IMAGES_MAP.add(5, "person");

    }
}
