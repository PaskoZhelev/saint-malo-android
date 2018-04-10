package com.pmz.saintmalogame.utils;

import com.pmz.saintmalogame.domain.board.Space;
import com.pmz.saintmalogame.enums.SpaceSymbol;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpaceHandlerTest {

    private SpaceHandler testClass = new SpaceHandler();
    private Space space1 = testClass.getAllSpaces().get(1);
    private Space space21 = testClass.getAllSpaces().get(21);

    @Test
    public void generateSpacesTest(){
        assertNotNull(space1);
        assertThat(space1, CoreMatchers.<Space>instanceOf(Space.class));
        assertEquals(46, testClass.getAllSpaces().size());
    }

    @Test
    public void generateNeighbouringSpacesTest(){
        assertEquals(2, space1.getNeighbouringSpaces().get(0).getId());
        assertEquals(20, space1.getNeighbouringSpaces().get(1).getId());
        assertEquals(21, space1.getNeighbouringSpaces().get(2).getId());
        assertEquals(22, space1.getNeighbouringSpaces().get(3).getId());

        assertEquals(1, space21.getNeighbouringSpaces().get(0).getId());
        assertEquals(2, space21.getNeighbouringSpaces().get(1).getId());
        assertEquals(19, space21.getNeighbouringSpaces().get(2).getId());
        assertEquals(20, space21.getNeighbouringSpaces().get(3).getId());
        assertEquals(22, space21.getNeighbouringSpaces().get(4).getId());
        assertEquals(26, space21.getNeighbouringSpaces().get(5).getId());
        assertEquals(27, space21.getNeighbouringSpaces().get(6).getId());

    }

    @Test
    public void checkFilledSpaces(){
        assertNull(testClass.getFilledSpaces().get(1));
        assertNotNull(testClass.getFilledSpaces().get(21));
        assertNotNull(testClass.getFilledSpaces().get(22));
        assertNotNull(testClass.getFilledSpaces().get(26));
        assertNotNull(testClass.getFilledSpaces().get(31));
    }

    @Test
    public void checkEmptySpaces(){
        assertNotNull(testClass.getEmptySpaces().get(1));
        assertNull(testClass.getEmptySpaces().get(21));

        testClass.fillSpace(testClass.getAllSpaces().get(1), SpaceSymbol.WALL);
        assertNull(testClass.getEmptySpaces().get(1));
    }
}
