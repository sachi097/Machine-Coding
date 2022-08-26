package com.machinecoding.snakeandladder;

public class Player {
    private final int id;
    private final String name;

    Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getPlayerId(){
        return id;
    }

    public String getPlayerName(){
        return name;
    }
}
