package com.pmz.saintmalogame.engine;

import com.pmz.saintmalogame.domain.dice.Die;
import com.pmz.saintmalogame.utils.DiceRoller;

import java.util.List;

public abstract class GameEngine {

    private DiceRoller diceRoller;

    public GameEngine() {
        diceRoller = new DiceRoller();
    }

    public void rollDice() {
        diceRoller.rollAllUnlockedDice();
    }

    public List<Die> getAllDice(){
        return diceRoller.getAllDice();
    }

    public Die getDie(int number) {
        return diceRoller.getAllDice().get(number);
    }

    public void lockDie(int dieNum) {
        diceRoller.lockDie(dieNum);
    }

    public void unlockDie(int dieNum) {
        diceRoller.unlockDie(dieNum);
    }

    public void unlockAllDice() {
        diceRoller.unlockAllDice();
    }

    public void lockAllDice() {
        diceRoller.lockAllDice();
    }
}
