package com.pmz.saintmalogame.utils;

import com.pmz.saintmalogame.constants.SaintMaloConstants;
import com.pmz.saintmalogame.enums.DieType;
import com.pmz.saintmalogame.enums.SpaceSymbol;

import static com.pmz.saintmalogame.constants.SaintMaloConstants.DICE_TO_ENUM_LIST;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.ROLL_BTN_IMAGES_LIST;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.SPACE_SYMBOLS_IMAGE_NAMES_MAP;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.SPACE_SYMBOLS_IMAGE_NAMES_SUFFIX;

public class ImageUtils {

    public static String getDiceStringName(int number) {
        StringBuilder sb = new StringBuilder();
        sb.append(SaintMaloConstants.DICE_IMAGE_PREFIX);
        sb.append(SaintMaloConstants.DICE_IMAGES_LIST.get(number));
        return sb.toString();
    }

    public static DieType getDiceEnumName(int number) {
        return DICE_TO_ENUM_LIST.get(number);
    }

    public static String getSymbolName(SpaceSymbol symbol) {
        String symbolName = SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(symbol);
        StringBuilder sb = new StringBuilder();
        sb.append(symbolName);
        sb.append(SPACE_SYMBOLS_IMAGE_NAMES_SUFFIX);
        return sb.toString();
    }

    public static String getRollButtonImageName(int rollsRemaining){
        return ROLL_BTN_IMAGES_LIST.get(rollsRemaining);
    }


}
