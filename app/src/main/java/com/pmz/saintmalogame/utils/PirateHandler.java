package com.pmz.saintmalogame.utils;

import com.pmz.saintmalogame.constants.SaintMaloConstants;
import com.pmz.saintmalogame.domain.player.Player;
import com.pmz.saintmalogame.enums.Resource;

import static com.pmz.saintmalogame.constants.SaintMaloConstants.MAX_PIRATES;

public class PirateHandler {

    private int numberOfPirates;

    public PirateHandler() {
        this.numberOfPirates = 0;
    }

    public void increasePirates(int num) {
        numberOfPirates += num;

        if(numberOfPirates > MAX_PIRATES) {
            numberOfPirates = MAX_PIRATES + 1;
        }
    }

    public int getNumberOfPirates() {
        return numberOfPirates;
    }

    public void checkForAttack(Player player) {
        switch (numberOfPirates) {
            case 4:
                destroyCannonsIfApplicable(1, player);
                break;
            case 8:
                destroyCannonsIfApplicable(3, player);
                break;
            case 12:
                destroyCannonsIfApplicable(6, player);
                break;
            case 16:
                destroyCannonsIfApplicable(8, player);
                break;
            case 20:
                destroyCannonsIfApplicable(10, player);
                break;
            case 24:
                destroyCannonsIfApplicable(12, player);
                break;
                default:
                    break;
        }
    }

    private void destroyCannonsIfApplicable(int defence, Player player) {
        if(player.getDefence() < defence) {
            player.increaseResource(Resource.CANNONS_DESTROYED, 1);
        }
    }
}
