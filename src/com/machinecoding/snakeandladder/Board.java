package com.machinecoding.snakeandladder;

import java.util.HashMap;

public class Board {
    HashMap<Integer, Integer> snakes = new HashMap<>();
    HashMap<Integer, Integer> ladders = new HashMap<>();
    Dice dice;
    int boardSize;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders, int numberOfDice){
        this.boardSize = boardSize;
        this.dice = new Dice(numberOfDice);
        initSnakes(numberOfSnakes);
        initLadders(numberOfLadders);
    }

    private int getPositionOnBoard(int max, int min){
        return (int) (Math.random() * (max - min) + min);
    }

    public void initSnakes(int numberOfSnakes){
        for(int i=0; i < numberOfSnakes; i++){
            int startPosition = getPositionOnBoard(boardSize, 2);
            int endPosition = getPositionOnBoard(startPosition, 1);
            snakes.put(startPosition, endPosition);
            System.out.println("Put Snake from " + startPosition + " to " + endPosition);
        }
    }

    public void initLadders(int numberOfLadders){
        for(int i=0; i < numberOfLadders; i++){
            int startPosition = getPositionOnBoard(boardSize + 1, 2);
            int endPosition = getPositionOnBoard(boardSize + 1, startPosition + 1);
            ladders.put(startPosition, endPosition);
            System.out.println("Put Ladder from " + startPosition + " to " + endPosition);
        }
    }
}
