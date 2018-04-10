package com.pmz.saintmalogame.utils;

import com.pmz.saintmalogame.domain.board.Space;
import com.pmz.saintmalogame.enums.SpaceSymbol;

import java.util.ArrayList;
import java.util.List;

import static com.pmz.saintmalogame.enums.SpaceSymbol.CRATE;

public class SpaceHandler {

    private List<Space> allSpaces;
    private List<Space> filledSpaces;
    private List<Space> emptySpaces;

    public SpaceHandler() {
        allSpaces = new ArrayList<>();
        initializeSpaces();
        generateNeighbouringSpaces();
        generateFilledSpaces();
        generateUnfilledSpaces();
        fillDefaultSpaces();
    }

    private void fillDefaultSpaces(){
        fillSpace(allSpaces.get(21), CRATE);
        fillSpace(allSpaces.get(22), CRATE);
        fillSpace(allSpaces.get(26), CRATE);
        fillSpace(allSpaces.get(31), CRATE);
    }

    public void fillSpace(Space space, SpaceSymbol spaceSymbol) {
        space.fillSpace(spaceSymbol);
        filledSpaces.add(space.getId(), space);
        emptySpaces.add(space.getId(), null);
    }


    private void generateFilledSpaces() {
        filledSpaces = new ArrayList<>();
        for (int i = 0; i < 46; i++) {
            filledSpaces.add(i, null);
        }
    }

    private void generateUnfilledSpaces() {
        emptySpaces = new ArrayList<>(allSpaces);
    }

    private void initializeSpaces() {
        Space space = null;
        allSpaces.add(0, null);

        //generate 1 to 20 space of the Outer area
        for (int i = 1; i < 21; i++) {
            space = new Space(i, true);
            allSpaces.add(i, space);
        }

        //generate 21 to 45 spaces of the Inner Area
        for (int j = 21; j < 46; j++) {
            space = new Space(j, false);
            allSpaces.add(j, space);
        }
    }

    private void generateNeighbouringSpaces() {
        generateNeighboursOuterArea();
        generateNeighboursInnerArea();
    }

    private void generateNeighboursInnerArea() {
        allSpaces.get(21)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(1),
                        allSpaces.get(2),
                        allSpaces.get(19),
                        allSpaces.get(20),
                        allSpaces.get(22),
                        allSpaces.get(26),
                        allSpaces.get(27)
                );
        allSpaces.get(22)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(1),
                        allSpaces.get(2),
                        allSpaces.get(3),
                        allSpaces.get(21),
                        allSpaces.get(23),
                        allSpaces.get(26),
                        allSpaces.get(27),
                        allSpaces.get(28)
                );
        allSpaces.get(23)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(2),
                        allSpaces.get(3),
                        allSpaces.get(4),
                        allSpaces.get(22),
                        allSpaces.get(24),
                        allSpaces.get(27),
                        allSpaces.get(28),
                        allSpaces.get(29)
                );
        allSpaces.get(24)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(3),
                        allSpaces.get(4),
                        allSpaces.get(5),
                        allSpaces.get(23),
                        allSpaces.get(25),
                        allSpaces.get(28),
                        allSpaces.get(29),
                        allSpaces.get(30)
                );
        allSpaces.get(25)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(4),
                        allSpaces.get(5),
                        allSpaces.get(6),
                        allSpaces.get(7),
                        allSpaces.get(24),
                        allSpaces.get(29),
                        allSpaces.get(30)
                );
        allSpaces.get(26)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(18),
                        allSpaces.get(19),
                        allSpaces.get(20),
                        allSpaces.get(21),
                        allSpaces.get(22),
                        allSpaces.get(27),
                        allSpaces.get(31),
                        allSpaces.get(32)
                );
        allSpaces.get(27)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(21),
                        allSpaces.get(22),
                        allSpaces.get(23),
                        allSpaces.get(26),
                        allSpaces.get(28),
                        allSpaces.get(31),
                        allSpaces.get(32),
                        allSpaces.get(33)
                );
        allSpaces.get(28)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(2),
                        allSpaces.get(23),
                        allSpaces.get(24),
                        allSpaces.get(27),
                        allSpaces.get(29),
                        allSpaces.get(32),
                        allSpaces.get(33),
                        allSpaces.get(34)
                );
        allSpaces.get(29)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(23),
                        allSpaces.get(24),
                        allSpaces.get(25),
                        allSpaces.get(28),
                        allSpaces.get(30),
                        allSpaces.get(33),
                        allSpaces.get(34),
                        allSpaces.get(35)
                );
        allSpaces.get(30)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(6),
                        allSpaces.get(7),
                        allSpaces.get(8),
                        allSpaces.get(24),
                        allSpaces.get(25),
                        allSpaces.get(29),
                        allSpaces.get(34),
                        allSpaces.get(35)
                );
        allSpaces.get(31)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(17),
                        allSpaces.get(18),
                        allSpaces.get(19),
                        allSpaces.get(26),
                        allSpaces.get(27),
                        allSpaces.get(32),
                        allSpaces.get(36),
                        allSpaces.get(37)
                );
        allSpaces.get(32)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(26),
                        allSpaces.get(27),
                        allSpaces.get(28),
                        allSpaces.get(31),
                        allSpaces.get(33),
                        allSpaces.get(36),
                        allSpaces.get(37),
                        allSpaces.get(38)
                );
        allSpaces.get(33)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(27),
                        allSpaces.get(28),
                        allSpaces.get(29),
                        allSpaces.get(32),
                        allSpaces.get(34),
                        allSpaces.get(37),
                        allSpaces.get(38),
                        allSpaces.get(39)
                );
        allSpaces.get(34)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(28),
                        allSpaces.get(29),
                        allSpaces.get(30),
                        allSpaces.get(33),
                        allSpaces.get(35),
                        allSpaces.get(38),
                        allSpaces.get(39),
                        allSpaces.get(40)
                );
        allSpaces.get(35)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(7),
                        allSpaces.get(8),
                        allSpaces.get(9),
                        allSpaces.get(29),
                        allSpaces.get(30),
                        allSpaces.get(34),
                        allSpaces.get(39),
                        allSpaces.get(40)
                );
        allSpaces.get(36)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(16),
                        allSpaces.get(17),
                        allSpaces.get(18),
                        allSpaces.get(31),
                        allSpaces.get(32),
                        allSpaces.get(37),
                        allSpaces.get(41),
                        allSpaces.get(42)
                );
        allSpaces.get(37)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(31),
                        allSpaces.get(32),
                        allSpaces.get(33),
                        allSpaces.get(36),
                        allSpaces.get(38),
                        allSpaces.get(41),
                        allSpaces.get(42),
                        allSpaces.get(43)
                );
        allSpaces.get(38)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(32),
                        allSpaces.get(33),
                        allSpaces.get(34),
                        allSpaces.get(37),
                        allSpaces.get(39),
                        allSpaces.get(42),
                        allSpaces.get(43),
                        allSpaces.get(44)
                );
        allSpaces.get(39)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(33),
                        allSpaces.get(34),
                        allSpaces.get(35),
                        allSpaces.get(38),
                        allSpaces.get(40),
                        allSpaces.get(43),
                        allSpaces.get(44),
                        allSpaces.get(45)
                );
        allSpaces.get(40)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(8),
                        allSpaces.get(9),
                        allSpaces.get(10),
                        allSpaces.get(34),
                        allSpaces.get(35),
                        allSpaces.get(39),
                        allSpaces.get(44),
                        allSpaces.get(45)
                );
        allSpaces.get(41)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(14),
                        allSpaces.get(15),
                        allSpaces.get(16),
                        allSpaces.get(17),
                        allSpaces.get(36),
                        allSpaces.get(37),
                        allSpaces.get(42)
                );
        allSpaces.get(42)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(13),
                        allSpaces.get(14),
                        allSpaces.get(15),
                        allSpaces.get(36),
                        allSpaces.get(37),
                        allSpaces.get(38),
                        allSpaces.get(41),
                        allSpaces.get(43)
                );
        allSpaces.get(43)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(12),
                        allSpaces.get(13),
                        allSpaces.get(14),
                        allSpaces.get(37),
                        allSpaces.get(38),
                        allSpaces.get(39),
                        allSpaces.get(42),
                        allSpaces.get(44)
                );
        allSpaces.get(44)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(11),
                        allSpaces.get(12),
                        allSpaces.get(13),
                        allSpaces.get(38),
                        allSpaces.get(39),
                        allSpaces.get(40),
                        allSpaces.get(43),
                        allSpaces.get(45)
                );
        allSpaces.get(45)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(9),
                        allSpaces.get(10),
                        allSpaces.get(11),
                        allSpaces.get(12),
                        allSpaces.get(39),
                        allSpaces.get(40),
                        allSpaces.get(44)
                );
    }

    private void generateNeighboursOuterArea() {
        allSpaces.get(1)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(2),
                        allSpaces.get(20),
                        allSpaces.get(21),
                        allSpaces.get(22)
                );

        allSpaces.get(2)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(1),
                        allSpaces.get(3),
                        allSpaces.get(21),
                        allSpaces.get(22),
                        allSpaces.get(22)
                );

        allSpaces.get(3)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(2),
                        allSpaces.get(4),
                        allSpaces.get(22),
                        allSpaces.get(23),
                        allSpaces.get(24)
                );

        allSpaces.get(4)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(3),
                        allSpaces.get(5),
                        allSpaces.get(23),
                        allSpaces.get(24),
                        allSpaces.get(25)
                );

        allSpaces.get(5)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(4),
                        allSpaces.get(6),
                        allSpaces.get(24),
                        allSpaces.get(25)
                );

        allSpaces.get(6)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(5),
                        allSpaces.get(7),
                        allSpaces.get(25),
                        allSpaces.get(30)
                );

        allSpaces.get(7)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(6),
                        allSpaces.get(8),
                        allSpaces.get(25),
                        allSpaces.get(30),
                        allSpaces.get(35)
                );

        allSpaces.get(8)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(7),
                        allSpaces.get(9),
                        allSpaces.get(30),
                        allSpaces.get(35),
                        allSpaces.get(40)
                );

        allSpaces.get(9)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(8),
                        allSpaces.get(10),
                        allSpaces.get(35),
                        allSpaces.get(40),
                        allSpaces.get(45)
                );

        allSpaces.get(10)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(9),
                        allSpaces.get(11),
                        allSpaces.get(40),
                        allSpaces.get(45)
                );

        allSpaces.get(11)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(10),
                        allSpaces.get(12),
                        allSpaces.get(44),
                        allSpaces.get(45)
                );

        allSpaces.get(12)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(11),
                        allSpaces.get(13),
                        allSpaces.get(43),
                        allSpaces.get(44),
                        allSpaces.get(45)
                );

        allSpaces.get(13)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(12),
                        allSpaces.get(14),
                        allSpaces.get(42),
                        allSpaces.get(43),
                        allSpaces.get(44)
                );

        allSpaces.get(14)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(13),
                        allSpaces.get(15),
                        allSpaces.get(41),
                        allSpaces.get(42),
                        allSpaces.get(43)
                );

        allSpaces.get(15)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(14),
                        allSpaces.get(16),
                        allSpaces.get(41),
                        allSpaces.get(42)
                );

        allSpaces.get(16)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(15),
                        allSpaces.get(17),
                        allSpaces.get(36),
                        allSpaces.get(41)
                );

        allSpaces.get(17)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(16),
                        allSpaces.get(18),
                        allSpaces.get(31),
                        allSpaces.get(36),
                        allSpaces.get(41)
                );

        allSpaces.get(18)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(17),
                        allSpaces.get(19),
                        allSpaces.get(26),
                        allSpaces.get(31),
                        allSpaces.get(36)
                );

        allSpaces.get(19)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(18),
                        allSpaces.get(20),
                        allSpaces.get(21),
                        allSpaces.get(26),
                        allSpaces.get(31)
                );

        allSpaces.get(20)
                .setNeighbouringSpacesAsSeparateObjects(
                        allSpaces.get(1),
                        allSpaces.get(19),
                        allSpaces.get(21),
                        allSpaces.get(26)
                );
    }

    public List<Space> getAllSpaces() {
        return allSpaces;
    }

    public List<Space> getFilledSpaces() {
        return filledSpaces;
    }

    public List<Space> getEmptySpaces() {
        return emptySpaces;
    }
}
