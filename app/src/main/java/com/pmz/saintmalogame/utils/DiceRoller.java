package com.pmz.saintmalogame.utils;

import com.pmz.saintmalogame.domain.dice.Die;
import com.pmz.saintmalogame.enums.DieType;

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
        die.setType(convertNumberToEnum(
                generateRandomNumber()
        ));
    }

    private String convertNumberToStringName(int num) {
        return ImageUtils.getDiceStringName(num);
    }

    private DieType convertNumberToEnum(int num) {
        return ImageUtils.getDiceEnumName(num);
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

    public List<Die> getAllLockedDice(){
        List<Die> lockedDice = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Die die = allDice.get(i);
            if(die.isLocked()){
                lockedDice.add(die);
            }
        }

        return lockedDice;
    }

    public void changeDie(int dieNum, DieType dieResult) {
        allDice.get(dieNum).setType(dieResult);
    }

    public void lockDie(int dieNum) {
        allDice.get(dieNum).setLocked(true);
    }

    public void unlockDie(int dieNum) {
        allDice.get(dieNum).setLocked(false);
    }

    public void lockAllDice() {
        for (int i = 1; i < 6; i++) {
            allDice.get(i).setLocked(true);
        }
    }

    public void unlockAllDice() {
        for (int i = 1; i < 6; i++) {
            allDice.get(i).setLocked(false);
        }
    }

    public boolean hasDifferentLockedDice() {
        List<Die> lockedDice = getAllLockedDice();
        DieType dieType = lockedDice.get(0).getType();
        for (Die die : lockedDice) {
            if(die.getType() != dieType) {
                return true;
            }
        }

        return false;
    }

}
