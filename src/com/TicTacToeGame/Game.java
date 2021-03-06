package com.TicTacToeGame;

import java.util.Scanner;

public class Game {
    private Board board;
    private final Player x;
    private final Player o;
    private int count = 1;

    public Game() {
        this.board = new Board();
        x = new Player("x");
        o = new Player("o");
    }

    public void runGame() throws Exception {
        while (true) {
            board.printBoard();
            Player player = setPlayer(count);
            System.out.println("Play Mr./Mrs."+player.getName());
            System.out.println("Enter Row And Column Number From 0-2:");
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(board.isValidCoordinate(row, col))
                play(player, row, col);
            else
                System.out.println("Enter valid coordinate ");
        }

    }

    private void play(Player player ,int row, int col) throws Exception {
        board.setValue(player,row, col);
        if(board.hasWon(player)) {
            board.printBoard();
            throw new Exception("Congratulation You Won Mr./Mrs." + player.getName());
        }
        board.result.hasTied(count);
        count++;
    }

    private Player setPlayer(int count) {
        return (count%2==0) ? o : x;
    }
}
