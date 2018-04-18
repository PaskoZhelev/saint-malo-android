package com.pmz.saintmalogame.utils;

import com.pmz.saintmalogame.enums.SpaceSymbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChurchHandler {

    private boolean startWithOne;
    private Map<Integer, SpaceSymbol> churches;

    public ChurchHandler() {
        churches = new HashMap<>();
        churches.put(1, null);
        churches.put(2, null);
        churches.put(3, null);
        churches.put(4, null);
        churches.put(5, null);
        churches.put(6, null);
    }

    public boolean isStartWithOne() {
        return startWithOne;
    }

    public boolean containsChurch(SpaceSymbol symbol) {
        return churches.containsValue(symbol);
    }

    public void activateStartWithOne() {
        startWithOne = true;
    }

    public Map<Integer, SpaceSymbol> getChurches() {
        return churches;
    }

    public boolean hasChurches(){
        return !churches.isEmpty();
    }

    public void addChurch(SpaceSymbol symbol) {
        switch (symbol){
            case CHURCH_LVL_1:
                churches.put(1, symbol);
                startWithOne = true;
                break;
            case CHURCH_LVL_2:
                churches.put(2, symbol);
                break;
            case CHURCH_LVL_3:
                churches.put(3, symbol);
                break;
            case CHURCH_LVL_4:
                churches.put(4, symbol);
                break;
            case CHURCH_LVL_5:
                churches.put(5, symbol);
                break;
        }
    }

    public int calculateConsecutiveChurches() {
        int consecutiveChurches = 0;
        for (int i = 1; i < 6; i++) {
            if(churches.get(i) != null) {
                consecutiveChurches++;
            } else {
                break;
            }
        }

        return consecutiveChurches;
    }
}
