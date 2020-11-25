package com.rgoddard.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameRunner {
    public static void RunGame(IGameBoard gameBoard) {
        boolean gameOver = false;
        boolean win = false;
        int player = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to Tic Tac Toe");
        System.out.println();

        while (!gameOver) {
            System.out.println(
                    "Player "
                            + (player + 1)
                            + "(" + (player == 0 ? "X" : "O") + ")"
                            + ", you're up! Here's a view of the board:"
            );
            gameBoard.displayBoard();
            System.out.print("Enter 1-9 or 's' to show available moves: ");

            try {
                String userInput = reader.readLine();

                if (userInput.toLowerCase().equals("s")) {
                    gameBoard.displayValidPositions();
                } else {
                    try {
                        int position = Integer.parseInt(userInput);
                        if (!gameBoard.play(player, position)){
                            continue;
                        }
                        gameOver = gameBoard.isGameOver() || gameBoard.isWin();
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid position entered.");
                        continue;
                    }
                }
            } catch (IOException e) {
                System.out.println("An unknown error occurred. Exiting");
                System.exit(1);
            }

            player = player == 0 ? 1 : 0;
        }

        if (gameBoard.isWin()) {
            System.out.println("Player " + (player + 1) + " wins!");
        } else {
            System.out.println("The game is a tie!");
        }

        gameBoard.displayBoard();
    }
}
