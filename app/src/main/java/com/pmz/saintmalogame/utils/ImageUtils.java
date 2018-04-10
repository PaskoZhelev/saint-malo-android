package com.pmz.saintmalogame.utils;

import com.pmz.saintmalogame.constants.SaintMaloConstants;

public class ImageUtils {

    public static String getDiceName(int number) {
        StringBuilder sb = new StringBuilder();
        sb.append(SaintMaloConstants.DICE_IMAGE_PREFIX);
        sb.append(SaintMaloConstants.DICE_IMAGES_MAP.get(number));
        return sb.toString();
    }
}
