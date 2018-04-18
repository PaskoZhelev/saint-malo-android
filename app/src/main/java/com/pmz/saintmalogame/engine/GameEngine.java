package com.pmz.saintmalogame.engine;

import com.pmz.saintmalogame.constants.SaintMaloConstants;
import com.pmz.saintmalogame.domain.dice.Die;
import com.pmz.saintmalogame.enums.DieType;
import com.pmz.saintmalogame.enums.SpaceSymbol;
import com.pmz.saintmalogame.utils.DiceRoller;
import com.pmz.saintmalogame.utils.PirateHandler;
import com.pmz.saintmalogame.utils.SelectedSymbolHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.pmz.saintmalogame.constants.SaintMaloConstants.DICE_IMAGE_PREFIX;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.SPACE_SYMBOLS_IMAGE_NAMES_MAP;
import static com.pmz.saintmalogame.constants.SaintMaloConstants.SPACE_SYMBOLS_IMAGE_NAMES_SUFFIX;
import static com.pmz.saintmalogame.enums.SpaceSymbol.CHURCH_LVL_1;
import static com.pmz.saintmalogame.enums.SpaceSymbol.CHURCH_LVL_2;
import static com.pmz.saintmalogame.enums.SpaceSymbol.CHURCH_LVL_3;
import static com.pmz.saintmalogame.enums.SpaceSymbol.CHURCH_LVL_4;
import static com.pmz.saintmalogame.enums.SpaceSymbol.CHURCH_LVL_5;
import static com.pmz.saintmalogame.enums.SpaceSymbol.CRATE;
import static com.pmz.saintmalogame.enums.SpaceSymbol.PERSON_ARCHITECT;
import static com.pmz.saintmalogame.enums.SpaceSymbol.PERSON_CITIZEN;
import static com.pmz.saintmalogame.enums.SpaceSymbol.PERSON_JUGGLER;
import static com.pmz.saintmalogame.enums.SpaceSymbol.PERSON_NOBLE;
import static com.pmz.saintmalogame.enums.SpaceSymbol.WALL;

public abstract class GameEngine {

    private DiceRoller diceRoller;
    private SelectedSymbolHandler symbolHandler;
    private PirateHandler pirateHandler;
    private int remainingRolls;
    private Map<DieType, Integer> dieTypeMap;


    public GameEngine() {
        diceRoller = new DiceRoller();
        symbolHandler = new SelectedSymbolHandler();
        pirateHandler = new PirateHandler();
        dieTypeMap = new HashMap<>();
        generateEmptyDieTypeMap();
        resetRemainingRolls();
    }

    private void generateEmptyDieTypeMap() {
        dieTypeMap.put(DieType.PIRATE, 0);
        dieTypeMap.put(DieType.CRATE, 0);
        dieTypeMap.put(DieType.TREE, 0);
        dieTypeMap.put(DieType.WALL, 0);
        dieTypeMap.put(DieType.CHURCH, 0);
        dieTypeMap.put(DieType.PERSON, 0);
    }

    public void rollDice() {
        diceRoller.rollAllUnlockedDice();
        decreaseRemainingRolls();
    }

    public List<Die> getAllDice() {
        return diceRoller.getAllDice();
    }

    public List<Die> getAllLockedDice() {
        return diceRoller.getAllLockedDice();
    }

    public Die getDie(int number) {
        return diceRoller.getAllDice().get(number);
    }

    public String getDieStringName(int number) {
        return DICE_IMAGE_PREFIX + getDie(number).getType()
                .toString().toLowerCase();
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

    public int getRemainingRolls() {
        return remainingRolls;
    }

    public void decreaseRemainingRolls() {
        remainingRolls--;
        if(remainingRolls < 0) {
            remainingRolls = 0;
        }
    }

    public void resetRemainingRolls() {
        remainingRolls = 3;
    }


    public void populateSymbolHandler() {
        //TODO
        List<Die> allLockedDice = getAllLockedDice();
        DieType dieType = allLockedDice.get(0).getType();
        int numberDice = allLockedDice.size();
        StringBuilder sb = new StringBuilder();
        switch (dieType) {
            case CRATE:
                sb.append(SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(CRATE));
                symbolHandler.setNumberOfSymbolsToBeWritten(numberDice);
                break;
            case WALL:
                sb.append(SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(WALL));
                symbolHandler.setNumberOfSymbolsToBeWritten(numberDice);
                break;
            case CHURCH:
                sb.append(generateChurchSymbol(numberDice));
                symbolHandler.setNumberOfSymbolsToBeWritten(1);
                break;
            case PERSON:
                sb.append(generatePersonSymbol(numberDice));
                symbolHandler.setNumberOfSymbolsToBeWritten(1);
                break;
            default:
                sb.append("empty");
                symbolHandler.setNumberOfSymbolsToBeWritten(0);
                break;
        }
        sb.append(SPACE_SYMBOLS_IMAGE_NAMES_SUFFIX);
        symbolHandler.setSymbolName(sb.toString());

    }

    public void populateSymbolHandlerForPerson(SpaceSymbol symbol) {
        symbolHandler.setSymbolName(
                SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(symbol) + SPACE_SYMBOLS_IMAGE_NAMES_SUFFIX);
        symbolHandler.setNumberOfSymbolsToBeWritten(1);
    }

    public void populateSymbolHandlerForArchitect(int houses) {
        symbolHandler.setSymbolName(
                SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(PERSON_ARCHITECT) + SPACE_SYMBOLS_IMAGE_NAMES_SUFFIX);
        symbolHandler.setNumberOfSymbolsToBeWritten(1 + houses);
    }

    private String generateChurchSymbol(int numberDice) {
        switch (numberDice){
            case 1:
                return SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(CHURCH_LVL_1);
            case 2:
                return SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(CHURCH_LVL_2);
            case 3:
                return SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(CHURCH_LVL_3);
            case 4:
                return SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(CHURCH_LVL_4);
            case 5:
                return SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(CHURCH_LVL_5);

            default:
                return null;
        }
    }

    private String generatePersonSymbol(int numberDice) {
        switch (numberDice){
            case 1:
                return SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(PERSON_CITIZEN);
            case 4:
                return SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(PERSON_JUGGLER);
            case 5:
                return SPACE_SYMBOLS_IMAGE_NAMES_MAP.get(PERSON_NOBLE);

            default:
                return null;
        }
    }

    public boolean hasDifferentLockedDice() {
        return diceRoller.hasDifferentLockedDice();
    }

    public SelectedSymbolHandler getSymbolHandler() {
        return symbolHandler;
    }

    public PirateHandler getPirateHandler() {
        return pirateHandler;
    }

    public int getPirates() {
        return pirateHandler.getNumberOfPirates();
    }

    public void increasePirates(int num) {
        pirateHandler.increasePirates(num);
    }

}
