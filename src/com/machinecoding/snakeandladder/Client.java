package com.machinecoding.snakeandladder;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        int numberOfPlayers;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Player");
        numberOfPlayers = scanner.nextInt();
        Game game = new Game(numberOfPlayers, 100, 5, 5, 1);
        game.playGame();
    }
}
