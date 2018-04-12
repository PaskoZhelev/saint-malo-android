package com.pmz.saintmalogame.utils;

import com.pmz.saintmalogame.domain.player.Player;
import com.pmz.saintmalogame.enums.Resource;

import static com.pmz.saintmalogame.enums.Resource.CANNONS_DESTROYED;

public class PirateUtils {

    public static void handlePirateAttack(int attackValue, Player...players) {
        for (Player player : players) {
            if(player.getDefence() < attackValue) {
                player.increaseResource(CANNONS_DESTROYED, 1);
            }
        }
    }
}
