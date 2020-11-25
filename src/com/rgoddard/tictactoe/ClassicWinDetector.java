package com.rgoddard.tictactoe;

public class ClassicWinDetector implements IWinDetector {
    @Override
    public boolean detectWin(char[][] board) {
        System.out.println("In Classic");
        return false;
    }
}
