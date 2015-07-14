/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsandcrosses;

import java.io.*;
import java.util.*;

/**
 *
 * @author alex.yates
 */
public class Game {
        /**
     * Class variables used to hold the identity of the current player and the
     * current state of the grid.
     */
    private String currentPlayer;
    private List grid;
    
    /**
     * Constuctor for Game objects.
     * Initialises current player as "O" and uses 
     * the initialiseGrid() method to initialise grid.
     */
    public Game(){
        super();
        this.currentPlayer = "O";
        this.grid = new ArrayList();
        this.initialiseGrid();
    }
    
    /**
     * Returns true if current player is X
     * @return true if current player is X
     */
    private boolean turnIsX() {
        return (currentPlayer.equals("X"));
    }

    /**
     * Swaps the current player for the next turn
     */
    public void nextPlayer() {
        if (turnIsX()) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }

    /**
     * Initialises the playing grid to a blank slate. All values from 0 - 8 will
     * be set to " ".
     */
    private void initialiseGrid() {
        for (int i = 0; i < 9; i++) {
            grid.add(" ");
        }
    }

    /**
     * Logs the current state of the grid.
     */
    public void printGrid() {
        System.out.println(" " + grid.get(0) + " | " + grid.get(1) + " | " + grid.get(2) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + grid.get(3) + " | " + grid.get(4) + " | " + grid.get(5) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + grid.get(6) + " | " + grid.get(7) + " | " + grid.get(8) + " ");
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
        if (grid.get(0).equals(grid.get(1)) && grid.get(1).equals(grid.get(2)) && !grid.get(0).equals(" ")) {
            gameIsWon = true;
            winner = (String) grid.get(0);
        } else if (grid.get(3).equals(grid.get(4)) && grid.get(4).equals(grid.get(5)) && !grid.get(3).equals(" ")) {
            gameIsWon = true;
            winner = (String) grid.get(3);
        } else if (grid.get(6).equals(grid.get(7)) && grid.get(7).equals(grid.get(8)) && !grid.get(6).equals(" ")) {
            gameIsWon = true;
            winner = (String) grid.get(6);
        } else if (grid.get(0).equals(grid.get(3)) && grid.get(3).equals(grid.get(6)) && !grid.get(0).equals(" ")) {
            gameIsWon = true;
            winner = (String) grid.get(0);
        } else if (grid.get(1).equals(grid.get(4)) && grid.get(4).equals(grid.get(7)) && !grid.get(1).equals(" ")) {
            gameIsWon = true;
            winner = (String) grid.get(1);
        } else if (grid.get(2).equals(grid.get(5)) && grid.get(5).equals(grid.get(8)) && !grid.get(2).equals(" ")) {
            gameIsWon = true;
            winner = (String) grid.get(2);
        } else if (grid.get(0).equals(grid.get(4)) && grid.get(4).equals(grid.get(8)) && !grid.get(0).equals(" ")) {
            gameIsWon = true;
            winner = (String) grid.get(0);
        } else if (grid.get(2).equals(grid.get(4)) && grid.get(4).equals(grid.get(6)) && !grid.get(2).equals(" ")) {
            gameIsWon = true;
            winner = (String) grid.get(0);
        }

        // Logging the winner 
        if (gameIsWon) {
            System.out.println("Game over! " + winner + "'s win!");
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
        if (!isWon() && !grid.contains(" ")) {
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

    /**
     * Asks the next player where they would like to go. Then reads the input
     * from the command prompt and updates grid<> accordingly.
     */
    public void takeTurn() {
        int move;
        boolean legalMove = false;
        // Copied some of the code for this section from 
        // http://www.avajava.com/tutorials/lessons/
        // how-do-i-accept-text-input-in-a-console-application.html 
        try {
            while (legalMove == false) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                if (turnIsX()) {
                    System.out.println("Crosses turn next:");
                } else {
                    System.out.println("Noughts turn next:");
                }
                // I'm not sure why but without using line.separator
                // (below) there was no new line after:
                // "Where would you like to go?"
                String newLine = System.getProperty("line.separator");
                System.out.print("Where would you like to go?" + newLine);
                System.out.println(" 0 | 1 | 2 ");
                System.out.println("---+---+---");
                System.out.println(" 3 | 4 | 5 ");
                System.out.println("---+---+---");
                System.out.println(" 6 | 7 | 8 ");
                System.out.print("Enter a number from 0-8:");
                String str = br.readLine();
                if (str.equals("0") || str.equals("1") || str.equals("2")
                        || str.equals("3") || str.equals("4") || str.equals("5")
                        || str.equals("6") || str.equals("7") || str.equals("8")) {
                    move = Integer.parseInt(str);
                    if (grid.get(move).equals(" ")) {
                        grid.set(move, currentPlayer);
                        legalMove = true;
                    } else {
                        System.out.println("The space must be free!");
                    }
                } else {
                    System.out.println("You must enter an integer between 0-8.");

                }
            }
        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println(e);
        }
    }

}
