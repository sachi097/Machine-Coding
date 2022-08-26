package com.machinecoding.snakeandladder;

public class Dice {
    private final int numberOfDice;
    Dice(int numberOfDice){
        this.numberOfDice = numberOfDice;
    }

    public int rollDice(){
        return (int) (Math.random() * ((6 * numberOfDice - numberOfDice) + 1) ) + (numberOfDice);
    }
}
