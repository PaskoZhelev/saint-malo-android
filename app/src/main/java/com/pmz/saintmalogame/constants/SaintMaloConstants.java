package com.pmz.saintmalogame.constants;

import com.pmz.saintmalogame.enums.DieType;
import com.pmz.saintmalogame.enums.SpaceSymbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.pmz.saintmalogame.enums.SpaceSymbol.*;

public class SaintMaloConstants {

    private SaintMaloConstants() {}

    //PLAYER Const
    public static final int INITIAL_PLAYER_COINS = 3;
    public static final int INITIAL_PLAYER_TREES = 2;
    public static final int INITIAL_PLAYER_POINTS = 0;
    public static final int INITIAL_PLAYER_DEFENCE = 0;
    public static final int INITIAL_PLAYER_CANNONS_DESTROYED = 0;
    public static final int MAXIMUM_AMOUNT_OF_SPACES = 45;
    public static final int CITIZEN_POINTS = 1;
    public static final int NOBLE_POINTS = 7;
    public static final int SOLDIER_DEFENCE_INCREASE = 1;
    public static final int ARCHITECT_1_HOUSE_POINTS_INCREASE = 3;
    public static final int ARCHITECT_2_HOUSE_POINTS_INCREASE = 6;
    public static final int ARCHITECT_3_HOUSE_POINTS_INCREASE = 9;


    //SPACE Const
    public static final String SPACE_SYMBOLS_IMAGE_NAMES_SUFFIX = "symbol";
    public static final Map<SpaceSymbol, String> SPACE_SYMBOLS_IMAGE_NAMES_MAP;
    public static final Map<String, SpaceSymbol> SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE;

    //DICE Const
    public static final List<String> DICE_IMAGES_LIST;
    public static final List<DieType> DICE_TO_ENUM_LIST;
    public static final String DICE_IMAGE_PREFIX = "dice";

    //IMAGE Const
    public static final List<String> ROLL_BTN_IMAGES_LIST;

    static {
        SPACE_SYMBOLS_IMAGE_NAMES_MAP = new HashMap<>();
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE = new HashMap<>();
        DICE_IMAGES_LIST = new ArrayList<>();
        DICE_TO_ENUM_LIST = new ArrayList<>();
        ROLL_BTN_IMAGES_LIST = new ArrayList<>();
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CRATE,        "crate");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CHURCH_LVL_1, "church1");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CHURCH_LVL_2, "church2");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CHURCH_LVL_3, "church3");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CHURCH_LVL_4, "church4");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(CHURCH_LVL_5, "church5");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(HOUSE,        "house");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_CITIZEN, "citizen");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_SOLDIER, "soldier");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_PRIEST, "priest");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_ARCHITECT, "architect");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_MERCHANT, "merchant");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_JUGGLER, "juggler");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(PERSON_NOBLE, "noble");
        SPACE_SYMBOLS_IMAGE_NAMES_MAP.put(WALL, "wall");

        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("cratesymbol", CRATE);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("church1symbol", CHURCH_LVL_1);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("church2symbol", CHURCH_LVL_2);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("church3symbol", CHURCH_LVL_3);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("church4symbol", CHURCH_LVL_4);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("church5symbol", CHURCH_LVL_5);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("housesymbol", HOUSE);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("citizensymbol", PERSON_CITIZEN);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("soldiersymbol", PERSON_SOLDIER);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("priestsymbol", PERSON_PRIEST);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("architectsymbol", PERSON_ARCHITECT);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("merchantsymbol", PERSON_MERCHANT);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("jugglersymbol", PERSON_JUGGLER);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("noblesymbol", PERSON_NOBLE);
        SPACE_SYMBOLS_IMAGE_NAMES_MAP_REVERSE.put("wallsymbol", WALL);



        DICE_IMAGES_LIST.add(0, "pirate");
        DICE_IMAGES_LIST.add(1, "crate");
        DICE_IMAGES_LIST.add(2, "tree");
        DICE_IMAGES_LIST.add(3, "wall");
        DICE_IMAGES_LIST.add(4, "church");
        DICE_IMAGES_LIST.add(5, "person");

        DICE_TO_ENUM_LIST.add(0, DieType.PIRATE);
        DICE_TO_ENUM_LIST.add(1, DieType.CRATE);
        DICE_TO_ENUM_LIST.add(2, DieType.TREE);
        DICE_TO_ENUM_LIST.add(3, DieType.WALL);
        DICE_TO_ENUM_LIST.add(4, DieType.CHURCH);
        DICE_TO_ENUM_LIST.add(5, DieType.PERSON);

        ROLL_BTN_IMAGES_LIST.add(0, "rollbtn0");
        ROLL_BTN_IMAGES_LIST.add(1, "rollbtn1");
        ROLL_BTN_IMAGES_LIST.add(2, "rollbtn2");
        ROLL_BTN_IMAGES_LIST.add(3, "rollbtn3");
    }
}
