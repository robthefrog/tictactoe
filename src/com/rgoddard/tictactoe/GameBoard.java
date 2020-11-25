package com.rgoddard.tictactoe;

public class GameBoard implements IGameBoard {
    private final char[][] board = new char[3][3];
    private final IWinDetector winDetector;

    public GameBoard(IWinDetector winDetector) {
        this.winDetector = winDetector;
    }

    @Override
    public void displayBoard() {
        for (char[] row : board) {
            System.out.println(
                    displaySymbol(row[0]) + " "
                            + displaySymbol(row[1]) + " "
                            + displaySymbol(row[2])
            );
        }
    }

    @Override
    public void displayValidPositions() {
        int positionCount = 1;
        for (char[] row : board) {
            System.out.print((row[0] != 0 ? "*" : positionCount) + " ");
            positionCount++;
            System.out.print((row[1] != 0 ? "*" : positionCount) + " ");
            positionCount++;
            System.out.print((row[2] != 0 ? "*" : positionCount) + " ");
            positionCount++;
            System.out.println();
        }
        System.out.println("* is taken.");
    }

    @Override
    public boolean play(int player, int position) {
        char playerSymbol = player == 0 ? 'X' : 'O';

        if (position < 1 || position > 9) {
            System.out.println("Invalid Position!");
            return false;
        }

        int positionCount = 1;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (positionCount == position) {
                    if (board[x][y] != 0) {
                        System.out.println("Position already taken!");
                        return false;
                    } else {
                        board[x][y] = playerSymbol;
                        return true;
                    }
                } else {
                    positionCount++;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isGameOver() {
        int count = 0;

        for (char[] row : board) {
            for (char symbol : row) {
                count += symbol == 0 ? 0 : 1;
            }
        }

        return count == 9;
    }

    @Override
    public boolean isWin() {
        return winDetector.detectWin(board);
    }

    // Display 'X', 'O', or '-'(if default)
    private char displaySymbol(char symbol) {
        // Default char is '\u0000', however 0 is the same.
        return symbol == 0 ? '-' : symbol;
    }
}
