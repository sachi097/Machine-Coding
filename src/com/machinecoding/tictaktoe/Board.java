package com.machinecoding.tictaktoe;

public class Board {

    public static Board board;
    int boardSize;
    String[][] gameBoard;
    private Board(int boardSize){
        this.boardSize = boardSize;
        this.initBoard();
    }

    public static Board getBoardObject(int boardSize){
        if(board == null){
            board = new Board(boardSize);
        }
        return board;
    }

    private void initBoard(){
        gameBoard = new String[boardSize][boardSize];
        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                gameBoard[i][j] = "-";
            }
        }
    }

    public void printBoard(){
        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                System.out.print(gameBoard[i][j].toUpperCase() + " ");
            }
            System.out.println();
        }
    }

    public boolean validateInput(int x, int y){
        return (x>=0 && y>=0 && x<boardSize && y<boardSize && gameBoard[x][y].equals("-"));
    }

    public void setSymbolOnBoard(int x, int y, String symbol){
        gameBoard[x][y] = symbol;
    }

    public String getSymbolOnBoard(int x, int y){
        return gameBoard[x][y];
    }
}
