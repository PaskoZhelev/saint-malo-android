package com.pmz.saintmalogame.engine.impl;

import com.pmz.saintmalogame.domain.board.Board;
import com.pmz.saintmalogame.domain.player.impl.NormalPlayer;
import com.pmz.saintmalogame.domain.player.Player;
import com.pmz.saintmalogame.engine.GameEngine;
import com.pmz.saintmalogame.utils.ImageUtils;

public class SoloGameEngine extends GameEngine {

    private Board board;
    private Player player;


    public SoloGameEngine() {
        super();
        board = new Board();
        player = new NormalPlayer(board);
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }


}
