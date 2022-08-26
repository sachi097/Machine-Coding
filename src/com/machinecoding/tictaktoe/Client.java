package com.machinecoding.tictaktoe;

import java.util.ArrayDeque;
import java.util.Queue;

public class Client {

    public static void main(String[] args) {
        Queue<Player> players = new ArrayDeque<>();
        Player player1 = new Player(1, "Player 1", "o");
        Player player2 = new Player(2, "Player 2", "x");
        players.add(player1);
        players.add(player2);
        Game game = new Game(players, 3);
        game.playGame();
    }
}
