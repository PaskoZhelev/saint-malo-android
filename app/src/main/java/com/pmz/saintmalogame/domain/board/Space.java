package com.pmz.saintmalogame.domain.board;

import com.pmz.saintmalogame.enums.SpaceSymbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.pmz.saintmalogame.enums.SpaceSymbol.EMPTY;

public class Space {

    private int id;
    private SpaceSymbol spaceSymbol;
    private List<Space> neighbouringSpaces;
    private boolean isFromOuterArea;

    public Space(int id, boolean isFromOuterArea) {
        this.id = id;
        this.spaceSymbol = SpaceSymbol.EMPTY;
        this.isFromOuterArea = isFromOuterArea;
        neighbouringSpaces = new ArrayList<>();

    }

    public boolean isEmpty() {
        return spaceSymbol == EMPTY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SpaceSymbol getSpaceSymbol() {
        return spaceSymbol;
    }

    public void fillSpace(SpaceSymbol spaceSymbol) {
        this.spaceSymbol = spaceSymbol;
    }

    public void makeSpaceEmpty() {
        this.spaceSymbol = EMPTY;
    }

    public List<Space> getNeighbouringSpaces() {
        return neighbouringSpaces;
    }

    public void setNeighbouringSpacesAsList(List<Space> neighbouringSpaces) {
        this.neighbouringSpaces = neighbouringSpaces;
    }

    public void setNeighbouringSpacesAsSeparateObjects(Space... spaces) {
        neighbouringSpaces.addAll(Arrays.asList(spaces));
    }

    public boolean isFromOuterArea() {
        return isFromOuterArea;
    }

    public void setFromOuterArea(boolean fromOuterArea) {
        isFromOuterArea = fromOuterArea;
    }
}
