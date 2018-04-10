package com.pmz.saintmalogame.domain.player;

import com.pmz.saintmalogame.domain.board.Board;

public abstract class Player {

    private Board board;
    private int points;
    private int coins;
    private int trees;
    private int defence;
    private int cannonsDestroyed;
    private boolean isFirst;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getTrees() {
        return trees;
    }

    public void setTrees(int trees) {
        this.trees = trees;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getCannonsDestroyed() {
        return cannonsDestroyed;
    }

    public void setCannonsDestroyed(int cannonsDestroyed) {
        this.cannonsDestroyed = cannonsDestroyed;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }
}
