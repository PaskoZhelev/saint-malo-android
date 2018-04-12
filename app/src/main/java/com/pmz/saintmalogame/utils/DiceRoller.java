package com.pmz.saintmalogame.utils;

import com.pmz.saintmalogame.domain.dice.Die;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceRoller {

    private Random rand;
    private final Die dieOne;
    private final Die dieTwo;
    private final Die dieThree;
    private final Die dieFour;
    private final Die dieFive;
    private List<Die> allDice;


    public DiceRoller() {
        rand = new Random();
        allDice = new ArrayList<>();
        dieOne = new Die();
        dieTwo = new Die();
        dieThree = new Die();
        dieFour = new Die();
        dieFive = new Die();
        allDice.add(0, null);
        allDice.add(1, dieOne);
        allDice.add(2, dieTwo);
        allDice.add(3, dieThree);
        allDice.add(4, dieFour);
        allDice.add(5, dieFive);
        rollAllUnlockedDice();
    }

    public void rollAllUnlockedDice() {
        for (Die die : allDice) {
            if((die != null) && !(die.isLocked())) {
                rollDie(die);
            }
        }
    }

    private void rollDie(Die die) {
        die.setFace(convertNumberToStringName(
                generateRandomNumber()
        ));
    }

    private String convertNumberToStringName(int num) {
        return ImageUtils.getDiceName(num);
    }

    private int generateRandomNumber() {
        return rand.nextInt(6);
    }

    public Die getDieOne() {
        return dieOne;
    }

    public Die getDieTwo() {
        return dieTwo;
    }

    public Die getDieThree() {
        return dieThree;
    }

    public Die getDieFour() {
        return dieFour;
    }

    public Die getDieFive() {
        return dieFive;
    }

    public List<Die> getAllDice() {
        return allDice;
    }

    public void changeDie(int dieNum, String dieResult) {
        allDice.get(dieNum).setFace(dieResult);
    }

    public void lockDie(int dieNum) {
        allDice.get(dieNum).setLocked(true);
    }

    public void unlockDie(int dieNum) {
        allDice.get(dieNum).setLocked(false);
    }

    public void lockAllDice() {
        for (int i = 1; i < 6; i++) {
            dieFive.setLocked(true);
        }
    }

    public void unlockAllDice() {
        for (int i = 1; i < 6; i++) {
            dieFive.setLocked(false);
        }
    }
}
