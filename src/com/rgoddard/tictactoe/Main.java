package com.rgoddard.tictactoe;

public class Main {

    public static void main(String[] args) {
	    GameBoard gameBoard = new GameBoard();
		gameBoard.play(0, 2);
		gameBoard.displayValidPositions();
    }
}
