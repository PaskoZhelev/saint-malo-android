package com.pmz.saintmalogame.domain.player;

import com.pmz.saintmalogame.domain.board.Board;
import com.pmz.saintmalogame.enums.Resource;

public abstract class Player {

    private Board board;
    private int points;
    private int coins;
    private int trees;
    private int defence;
    private int cannonsDestroyed;
    private boolean isFirst;

    public Player(Board board, int points, int coins, int trees, int defence, int cannonsDestroyed, boolean isFirst) {
        this.board = board;
        this.points = points;
        this.coins = coins;
        this.trees = trees;
        this.defence = defence;
        this.cannonsDestroyed = cannonsDestroyed;
        this.isFirst = isFirst;
    }

    public Board getBoard() {
        return board;
    }

    public int getPoints() {
        return points;
    }


    public int getCoins() {
        return coins;
    }


    public int getTrees() {
        return trees;
    }


    public int getDefence() {
        return defence;
    }

    public int getCannonsDestroyed() {
        return cannonsDestroyed;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public void increaseResource(Resource resource, int numToIncrease) {
        switch (resource){
            case COINS:
                coins += numToIncrease;
                break;
            case TREES:
                trees += numToIncrease;
                break;
            case POINTS:
                points += numToIncrease;
                break;
            case DEFENCE:
                defence += numToIncrease;
            case CANNONS_DESTROYED:
                cannonsDestroyed += numToIncrease;
        }
    }

    public void decreaseResource(Resource resource, int numToDecrease) {
        switch (resource){
            case COINS:
                coins -= numToDecrease;
                break;
            case TREES:
                trees -= numToDecrease;
                break;
            case POINTS:
                points -= numToDecrease;
                break;
            case DEFENCE:
                defence -= numToDecrease;
            case CANNONS_DESTROYED:
                cannonsDestroyed -= numToDecrease;
        }
    }
}
