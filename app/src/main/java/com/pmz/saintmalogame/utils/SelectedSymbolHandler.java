package com.pmz.saintmalogame.utils;

public class SelectedSymbolHandler {

    private String symbolName;
    private int numberOfSymbolsToBeWritten;

    public void resetSymbolHandler() {
        symbolName = null;
        numberOfSymbolsToBeWritten = 0;
    }

    public void increaseNumberOfSymbolsToBeWritten() {
        numberOfSymbolsToBeWritten++;
    }

    public void decreaseNumberOfSymbolsToBeWritten() {
        numberOfSymbolsToBeWritten--;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public int getNumberOfSymbolsToBeWritten() {
        return numberOfSymbolsToBeWritten;
    }

    public void setNumberOfSymbolsToBeWritten(int numberOfSymbolsToBeWritten) {
        this.numberOfSymbolsToBeWritten = numberOfSymbolsToBeWritten;
    }
}
