package com.pmz.saintmalogame.domain.board;

import com.pmz.saintmalogame.constants.SaintMaloConstants;
import com.pmz.saintmalogame.enums.SpaceSymbol;
import com.pmz.saintmalogame.utils.SpaceHandler;

import java.util.List;

import static com.pmz.saintmalogame.constants.SaintMaloConstants.MAXIMUM_AMOUNT_OF_SPACES;

public class Board {

    //private OuterArea outerArea;
    //private InnerArea innerArea;
    private int numberOfSpacesFilled;
    private boolean isFilledEntirely;
    private SpaceHandler spaceHandler;

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
        if(numberOfSpacesFilled == MAXIMUM_AMOUNT_OF_SPACES){
            isFilledEntirely = true;
        }
    }

    private void decreaseNumberOfSpacesFilled() {
        numberOfSpacesFilled--;
        if(numberOfSpacesFilled != MAXIMUM_AMOUNT_OF_SPACES){
            isFilledEntirely = false;
        }
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
}
