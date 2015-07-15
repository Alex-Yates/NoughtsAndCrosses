/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsandcrosses;

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
        player1 = new HumanPlayer(1);
        player2 = new HumanPlayer(2);
        this.currentPlayer = this.player1;
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
     * Checks to see whether either player has won the game and if so logs which
     * player won.
     *
     * Also returns true if the game has been won and false otherwise.
     *
     * @return True if either player won. False if not.
     */
    private boolean isWon() {
        boolean gameIsWon = false;
        String winner;
        winner = "";

        //Determining if victory conditions are met
        if (NoughtsAndCrosses.grid.get(0).equals(NoughtsAndCrosses.grid.get(1)) && NoughtsAndCrosses.grid.get(1).equals(NoughtsAndCrosses.grid.get(2)) && !NoughtsAndCrosses.grid.get(0).equals(" ")) {
            gameIsWon = true;
            winner = this.currentPlayer.getName();
        } else if (NoughtsAndCrosses.grid.get(3).equals(NoughtsAndCrosses.grid.get(4)) && NoughtsAndCrosses.grid.get(4).equals(NoughtsAndCrosses.grid.get(5)) && !NoughtsAndCrosses.grid.get(3).equals(" ")) {
            gameIsWon = true;
            winner = this.currentPlayer.getName();
        } else if (NoughtsAndCrosses.grid.get(6).equals(NoughtsAndCrosses.grid.get(7)) && NoughtsAndCrosses.grid.get(7).equals(NoughtsAndCrosses.grid.get(8)) && !NoughtsAndCrosses.grid.get(6).equals(" ")) {
            gameIsWon = true;
            winner = this.currentPlayer.getName();
        } else if (NoughtsAndCrosses.grid.get(0).equals(NoughtsAndCrosses.grid.get(3)) && NoughtsAndCrosses.grid.get(3).equals(NoughtsAndCrosses.grid.get(6)) && !NoughtsAndCrosses.grid.get(0).equals(" ")) {
            gameIsWon = true;
            winner = this.currentPlayer.getName();
        } else if (NoughtsAndCrosses.grid.get(1).equals(NoughtsAndCrosses.grid.get(4)) && NoughtsAndCrosses.grid.get(4).equals(NoughtsAndCrosses.grid.get(7)) && !NoughtsAndCrosses.grid.get(1).equals(" ")) {
            gameIsWon = true;
            winner = this.currentPlayer.getName();
        } else if (NoughtsAndCrosses.grid.get(2).equals(NoughtsAndCrosses.grid.get(5)) && NoughtsAndCrosses.grid.get(5).equals(NoughtsAndCrosses.grid.get(8)) && !NoughtsAndCrosses.grid.get(2).equals(" ")) {
            gameIsWon = true;
            winner = this.currentPlayer.getName();
        } else if (NoughtsAndCrosses.grid.get(0).equals(NoughtsAndCrosses.grid.get(4)) && NoughtsAndCrosses.grid.get(4).equals(NoughtsAndCrosses.grid.get(8)) && !NoughtsAndCrosses.grid.get(0).equals(" ")) {
            gameIsWon = true;
            winner = this.currentPlayer.getName();
        } else if (NoughtsAndCrosses.grid.get(2).equals(NoughtsAndCrosses.grid.get(4)) && NoughtsAndCrosses.grid.get(4).equals(NoughtsAndCrosses.grid.get(6)) && !NoughtsAndCrosses.grid.get(2).equals(" ")) {
            gameIsWon = true;
            winner = this.currentPlayer.getName();
        }

        /**
         * Logging the winner Note: this only works if you know the game has
         * been won by currentPlayer
         */
        if (gameIsWon) {
            System.out.println("Game over! " + winner + " wins!");
        }

        // Signalling whether the game is over
        return gameIsWon;
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
        if (!isWon() && !NoughtsAndCrosses.grid.contains(" ")) {
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
        return (isWon() || isDraw());
    }
}
