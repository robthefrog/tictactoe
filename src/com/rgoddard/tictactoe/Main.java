package com.rgoddard.tictactoe;

public class Main {

    public static void main(String[] args) {
        String winDetectionMode = "classic";

        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-d":
                    case "--detection-mode":
                        winDetectionMode = args[i + 1];
                }
            }
        } catch (Exception ex) {
            System.out.println("Wrong number of arguments.");
            System.exit(1);
        }

        GameRunner.RunGame(
                new GameBoard(
                        winDetectionMode.toLowerCase().equals("magic") ?
                                new MagicSquareWinDetector() : new ClassicWinDetector()
                )
        );
    }
}
