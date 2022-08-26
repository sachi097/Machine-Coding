package com.machinecoding.tictaktoe;

import java.util.Queue;
import java.util.Scanner;

public class Game {
    Queue<Player> players;
    Board board;

    int consumedChances = 0;

    Game(Queue<Player> players, int boardSize){
        this.players = players;
        board = Board.getBoardObject(boardSize);
    }

    public void playGame(){
        board.printBoard();
        while(players.size() > 1 && consumedChances != (board.boardSize * board.boardSize)){
            Player currentPlayer = players.poll();
            String currentSymbol = currentPlayer.getSymbol();
            System.out.println("Current Player : " + currentPlayer.name + " , Symbol : " + currentSymbol.toUpperCase());
            System.out.println("Enter Your Position");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            while (!board.validateInput(x, y)){
                System.out.println("Invalid Position, Enter again");
                x = scanner.nextInt();
                y = scanner.nextInt();
            }
            consumedChances++;
            board.setSymbolOnBoard(x,y,currentSymbol);
            board.printBoard();
            if(checkPlayerWon(x, y, currentSymbol)){
                System.out.println("Player : " + currentPlayer.name + " Won");
            }
            else{
                players.add(currentPlayer);
            }
        }
        if(consumedChances == (board.boardSize * board.boardSize)){
            System.out.println("Match Drawn");
        }
    }

    private boolean checkPlayerWon(int row, int col, String currentSymbol){
        boolean rowWin = true, colWin = true, rDgnWin = true, lDgnWin = true;
        for(int i = 0; i < board.boardSize; i++){
            if(!board.getSymbolOnBoard(row, i).equals(currentSymbol)){
                rowWin = false;
            }
            if(!board.getSymbolOnBoard(i, col).equals(currentSymbol)){
                colWin = false;
            }
            if(!board.getSymbolOnBoard(i, i).equals(currentSymbol)){
                rDgnWin = false;
            }
            if(!board.getSymbolOnBoard(i, board.boardSize - i - 1).equals(currentSymbol)){
                lDgnWin = false;
            }
        }
        return rowWin || colWin || rDgnWin || lDgnWin;
    }

}
