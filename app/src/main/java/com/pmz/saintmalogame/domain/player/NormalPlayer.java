package com.pmz.saintmalogame.domain.player;

import com.pmz.saintmalogame.domain.board.Board;

import static com.pmz.saintmalogame.constants.SaintMaloConstants.INITIAL_PLAYER_CANNONS_DESTROYED;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.INITIAL_PLAYER_COINS;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.INITIAL_PLAYER_DEFENCE;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.INITIAL_PLAYER_POINTS;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.INITIAL_PLAYER_TREES;

public class NormalPlayer extends Player {

    public NormalPlayer() {
        super(new Board(),
                INITIAL_PLAYER_POINTS,
                INITIAL_PLAYER_COINS,
                INITIAL_PLAYER_TREES,
                INITIAL_PLAYER_DEFENCE,
                INITIAL_PLAYER_CANNONS_DESTROYED,
                false);
    }

    public void testMethod() {

    }
}
