package com.pmz.saintmalogame.engine.impl;

import com.pmz.saintmalogame.domain.board.Board;
import com.pmz.saintmalogame.domain.player.impl.NormalPlayer;
import com.pmz.saintmalogame.domain.player.Player;
import com.pmz.saintmalogame.engine.GameEngine;
import com.pmz.saintmalogame.utils.ImageUtils;

public class SoloGameEngine extends GameEngine {

    private Board board;
    private Player player;
    private int turn;


    public SoloGameEngine() {
        super();
        board = new Board();
        player = new NormalPlayer(board);
        turn = 1;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }

    public int getTurn() {
        return turn;
    }

    public void increaseTurn() {
        turn++;
    }

    public int calculateEndPoints() {
        int points = player.getPoints();
        int resources = player.getTrees() + (player.getCoins() / 2);
        int churchPoints = board.calculateBonusFromChurches();
        int pointsForFullCompletion = 0;
        if(board.isFilledEntirely()){
            pointsForFullCompletion = 5;
        }
        int pointsFromCannonsDestroyed = player.getCannonsDestroyed() * 5;

        return (points + resources + churchPoints + pointsForFullCompletion) - pointsFromCannonsDestroyed;
    }
}
