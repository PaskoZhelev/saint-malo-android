package com.pmz.saintmalogame.domain.player.impl;

import com.pmz.saintmalogame.domain.board.Board;
import com.pmz.saintmalogame.domain.player.Player;

import static com.pmz.saintmalogame.constants.SaintMaloConstants.INITIAL_PLAYER_CANNONS_DESTROYED;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.INITIAL_PLAYER_COINS;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.INITIAL_PLAYER_DEFENCE;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.INITIAL_PLAYER_POINTS;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.INITIAL_PLAYER_TREES;

public class NormalPlayer extends Player {

    public NormalPlayer(Board board) {
        super(board,
                INITIAL_PLAYER_POINTS,
                INITIAL_PLAYER_COINS,
                INITIAL_PLAYER_TREES,
                INITIAL_PLAYER_DEFENCE,
                INITIAL_PLAYER_CANNONS_DESTROYED,
                false);
    }

}
