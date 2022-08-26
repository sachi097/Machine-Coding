package com.machinecoding.tictaktoe;

public class Player {
    int id;
    String name;
    String symbol;

    Player(int id, String name, String symbol){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public int getPlayerId(){
        return id;
    }

    public String getPlayerName(){
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

}
