package com.pmz.saintmalogame.utils;

import android.widget.ImageView;

import java.util.Random;

public class DiceRoller {

    private Random rand;
    private String dieOne;
    private String dieTwo;
    private String dieThree;
    private String dieFour;
    private String dieFive;


    public DiceRoller() {
        rand = new Random();
        rollDice();
    }

    public void rollDice() {
        setDieOne(convertNumberToStringName(
                generateRandomNumber()));
        setDieTwo(convertNumberToStringName(
                generateRandomNumber()));
        setDieThree(convertNumberToStringName(
                generateRandomNumber()));
        setDieFour(convertNumberToStringName(
                generateRandomNumber()));
        setDieFive(convertNumberToStringName(
                generateRandomNumber()));
    }

    public String convertNumberToStringName(int num) {
        return ImageUtils.getDiceName(num);
    }

    public int generateRandomNumber() {
        return rand.nextInt(6);
    }

    public String getDieOne() {
        return dieOne;
    }

    public void setDieOne(String dieOne) {
        this.dieOne = dieOne;
    }

    public String getDieTwo() {
        return dieTwo;
    }

    public void setDieTwo(String dieTwo) {
        this.dieTwo = dieTwo;
    }

    public String getDieThree() {
        return dieThree;
    }

    public void setDieThree(String dieThree) {
        this.dieThree = dieThree;
    }

    public String getDieFour() {
        return dieFour;
    }

    public void setDieFour(String dieFour) {
        this.dieFour = dieFour;
    }

    public String getDieFive() {
        return dieFive;
    }

    public void setDieFive(String dieFive) {
        this.dieFive = dieFive;
    }

}
