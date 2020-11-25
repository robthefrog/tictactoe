package com.rgoddard.tictactoe;

public class GameBoard {
    private final char[][] board = new char[3][3];

    public void displayBoard() {
        for (char[] row : board) {
            System.out.println(
                    displaySymbol(row[0]) + " "
                            + displaySymbol(row[1]) + " "
                            + displaySymbol(row[2])
            );
        }
    }

    public void displayValidPositions() {
        int positionCount = 1;
        for (char[] row : board) {
            System.out.print((row[0] != 0 ? "*" : positionCount++) + " ");
            System.out.print((row[1] != 0 ? "*" : positionCount++) + " ");
            System.out.print((row[2] != 0 ? "*" : positionCount++) + " ");
            System.out.println();
        }
        System.out.println("* is taken.");
    }

    public void play(int player, int position) {
        char playerSymbol = player == 0 ? 'X' : 'O';

        if (position < 1 || position > 9) {
            System.out.println("Invalid Position!");
            return;
        }

        int positionCount = 1;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (positionCount == position) {
                    if (board[x][y] != 0) {
                        System.out.println("Position already taken!");
                    } else {
                        board[x][y] = playerSymbol;
                        displayBoard();
                    }
                    return;
                } else {
                    positionCount++;
                }
            }
        }
    }

    // Display 'X', 'O', or '-'(if default)
    private char displaySymbol(char symbol) {
        // Default char is '\u0000', however 0 is the same.
        return symbol == 0 ? '-' : symbol;
    }
}
