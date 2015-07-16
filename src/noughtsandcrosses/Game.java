/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsandcrosses;

import java.io.*;

/**
 *
 * @author alex.yates
 */
public class Game {

    /**
     * Class variables used to hold the identity of the current player and the
     * current state of the grid.
     */
    private iPlayer currentPlayer;
    private iPlayer player1;
    private iPlayer player2;

    /**
     * Constuctor for Game objects. Initialises current player as "O" and uses
     * the initialiseGrid() method to initialise grid.
     */
    public Game() {
        super();
        this.initialiseGrid();
        // Setting players as either human or AI
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Player1: Enter 1 for human or 2 for AI");
            String p1 = br.readLine();
            if (p1.equals("1")) {
                player1 = new HumanPlayer(1);
            } else {
                player1 = new AIPlayer(1);
            }
            System.out.println("Player2: Enter 1 for human or 2 for AI");
            String p2 = br.readLine();
            if (p2.equals("1")) {
                player2 = new HumanPlayer(2);
            } else {
                player2 = new AIPlayer(2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Setting player1 as the current player to start
        this.currentPlayer = this.player1;
    }

    public iPlayer getPlayer1() {
        return player1;
    }

    public iPlayer getPlayer2() {
        return player2;
    }

    public iPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Initialises the playing grid to a blank slate. All values from 0 - 8 will
     * be set to " ".
     */
    private void initialiseGrid() {
        NoughtsAndCrosses.grid.clear();
        for (int i = 0; i < 9; i++) {
            NoughtsAndCrosses.grid.add(" ");
        }
    }

    /**
     * Swaps the current player for the next turn
     */
    public void nextPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    /**
     * Logs the current state of the grid.
     */
    public void printGrid() {
        System.out.println(" " + NoughtsAndCrosses.grid.get(0) + " | " + NoughtsAndCrosses.grid.get(1) + " | " + NoughtsAndCrosses.grid.get(2) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + NoughtsAndCrosses.grid.get(3) + " | " + NoughtsAndCrosses.grid.get(4) + " | " + NoughtsAndCrosses.grid.get(5) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + NoughtsAndCrosses.grid.get(6) + " | " + NoughtsAndCrosses.grid.get(7) + " | " + NoughtsAndCrosses.grid.get(8) + " ");
    }

    /**
     * Returns true and logs if the game is a draw.
     *
     * Only intelligent enough to spot a draw if all 9 squares are full and no
     * winner.
     *
     * @return True if the game is drawn. False if not.
     */
    private boolean isDraw() {
        if (!VictoryConditions.gameWon() && !NoughtsAndCrosses.grid.contains(" ")) {
            System.out.println("It's a draw!");
            return true;
        }
        return false;
    }

    /**
     * Returns true if the game is finished.
     *
     * @return True if game finished
     */
    public boolean gameEnd() {
        return (VictoryConditions.gameWon() || isDraw());
    }
}
