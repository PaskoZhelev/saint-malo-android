package com.pmz.saintmalogame.domain.board;

import com.pmz.saintmalogame.constants.SaintMaloConstants;
import com.pmz.saintmalogame.enums.SpaceSymbol;
import com.pmz.saintmalogame.utils.SpaceHandler;

import java.util.List;

import static com.pmz.saintmalogame.constants.SaintMaloConstants.MAXIMUM_AMOUNT_OF_SPACES;

public class Board {

    private int numberOfSpacesFilled;
    private SpaceHandler spaceHandler;
    private boolean peopleBonusTaken;
    private boolean coinsBonus1Taken;
    private boolean coinsBonus2Taken;
    private boolean pointsBonusTaken;

    public Board() {
        spaceHandler = new SpaceHandler();
        numberOfSpacesFilled = 4;
    }

    public void fillSpace(int index, SpaceSymbol spaceSymbol) {
        spaceHandler.fillSpace(index, spaceSymbol);
        increaseNumberOfSpacesFilled();
    }

    private void increaseNumberOfSpacesFilled() {
        numberOfSpacesFilled++;
    }

    private void decreaseNumberOfSpacesFilled() {
        numberOfSpacesFilled--;
    }

    public List<Space> getAllSpaces() {
        return spaceHandler.getAllSpaces();
    }

    public List<Space> getFilledSpaces() {
        return spaceHandler.getFilledSpaces();
    }

    public List<Space> getEmptySpaces() {
        return spaceHandler.getEmptySpaces();
    }

    public List<Space> getOuterSpaces() {
        return spaceHandler.getOuterSpaces();
    }

    public boolean isFilledEntirely() {
        return numberOfSpacesFilled == SaintMaloConstants.MAXIMUM_AMOUNT_OF_SPACES;
    }

    public boolean isPeopleBonusAvailable() {
        List<Space> outerSpaces = getOuterSpaces();
        boolean bonus = false;
        for (int i = 1; i < 6; i++) {
            if(outerSpaces.get(i).getSpaceSymbol() != SpaceSymbol.WALL){
                return bonus;
            }
        }

        if(!peopleBonusTaken){
            peopleBonusTaken = true;
            bonus = true;
        }

        return bonus;
    }

    public boolean isCoinsBonus1Available() {
        List<Space> outerSpaces = getOuterSpaces();
        boolean bonus = false;
        for (int i = 6; i < 11; i++) {
            if(outerSpaces.get(i).getSpaceSymbol() != SpaceSymbol.WALL){
                return bonus;
            }
        }

        if(!coinsBonus1Taken){
            coinsBonus1Taken = true;
            bonus = true;
        }

        return bonus;
    }

    public boolean isCoinsBonus2Available() {
        List<Space> outerSpaces = getOuterSpaces();
        boolean bonus = false;
        for (int i = 16; i < 21; i++) {
            if(outerSpaces.get(i).getSpaceSymbol() != SpaceSymbol.WALL){
                return bonus;
            }
        }

        if(!coinsBonus2Taken){
            coinsBonus2Taken = true;
            bonus = true;
        }

        return bonus;
    }

    public boolean isPointsBonusAvailable() {
        List<Space> outerSpaces = getOuterSpaces();
        boolean bonus = false;
        for (int i = 11; i < 16; i++) {
            if(outerSpaces.get(i).getSpaceSymbol() != SpaceSymbol.WALL){
                return bonus;
            }
        }

        if(!pointsBonusTaken){
            pointsBonusTaken = true;
            bonus = true;
        }

        return bonus;
    }

    public boolean isPeopleBonusTaken() {
        return peopleBonusTaken;
    }

    public boolean isCoinsBonus1Taken() {
        return coinsBonus1Taken;
    }

    public boolean isCoinsBonus2Taken() {
        return coinsBonus2Taken;
    }

    public boolean isPointsBonusTaken() {
        return pointsBonusTaken;
    }
}
