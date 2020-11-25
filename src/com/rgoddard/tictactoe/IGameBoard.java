package com.rgoddard.tictactoe;

public interface IGameBoard {
    void displayBoard();
    void displayValidPositions();
    boolean play(int player, int position);
    boolean isGameOver();
    boolean isWin();
}
