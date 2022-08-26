package com.machinecoding.snakeandladder;

import java.util.*;

public class Game {

    Queue<Player> players = new ArrayDeque<>();
    Board board;
    private final HashMap<Integer, Integer> playerPosition = new HashMap<>();

    Game(int numberOfPlayers, int boardSize, int numberOfSnakes, int numberOfLadders, int numberOfDice){
        this.board = new Board(boardSize,numberOfSnakes,numberOfLadders,numberOfDice);
        initPlayers(numberOfPlayers);
    }

    public void initPlayers(int numberOfPlayers){
        for(int i=0; i<numberOfPlayers; i++){
            players.add(new Player(i, "Player " + i));
            playerPosition.put(i, 0);
        }
    }

    public void playGame(){
        while (players.size() > 1){
            Player currentPlayer = players.poll();
            int currentPlayerId = currentPlayer.getPlayerId();
            String currentPlayerName = currentPlayer.getPlayerName();
            int diceRoll = board.dice.rollDice();
            int currentPlayerPosition = playerPosition.get(currentPlayerId);
            int nextPossiblePosition = currentPlayerPosition + diceRoll;
            System.out.println(currentPlayerName + " rolled dice " + diceRoll);
            if(nextPossiblePosition <= board.boardSize){
                if(nextPossiblePosition == board.boardSize){
                    System.out.println(currentPlayerName + " moved from " + currentPlayerPosition + " to " + nextPossiblePosition);
                    System.out.println(currentPlayerName + " Won the game");
                }
                else{
                    if(board.snakes.get(nextPossiblePosition) != null){
                        System.out.println(currentPlayerName + " got bitten by snake at " + nextPossiblePosition);
                        nextPossiblePosition = board.snakes.get(nextPossiblePosition);
                        System.out.println(currentPlayerName + " moved from " + (currentPlayerPosition + diceRoll) + " to " + nextPossiblePosition);
                    }
                    else if(board.ladders.get(nextPossiblePosition) != null){
                        System.out.println(currentPlayerName + " used ladder at " + nextPossiblePosition);
                        nextPossiblePosition = board.ladders.get(nextPossiblePosition);
                        System.out.println(currentPlayerName + " moved from " + (currentPlayerPosition + diceRoll)  + " to " + nextPossiblePosition);
                    }
                    else{
                        System.out.println(currentPlayerName + " moved from " + currentPlayerPosition + " to " + nextPossiblePosition);
                    }
                    playerPosition.put(currentPlayerId, nextPossiblePosition);
                    players.add(currentPlayer);
                }
            }
            else{
                players.add(currentPlayer);
            }
        }
    }
}

