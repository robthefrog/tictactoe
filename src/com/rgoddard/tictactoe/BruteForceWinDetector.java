package com.rgoddard.tictactoe;

public class BruteForceWinDetector implements IWinDetector {
    @Override
    public boolean detectWin(char[][] board) {
        char[] symbols = {'X', 'O'};
        for (char symbol : symbols) {
            if (
                // Horizontal
                    (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                            (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                            (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
                            // Vertical
                            (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                            (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                            (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
                            // Diagonals
                            (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            ) {
                return true;
            }
        }
        return false;
    }
}
