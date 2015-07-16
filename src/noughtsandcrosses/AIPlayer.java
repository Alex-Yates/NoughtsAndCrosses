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
public class AIPlayer implements iPlayer {

    private String name;
    private String symbol;

    public AIPlayer(String playerName, String playerSymbol) {
        super();
        this.name = playerName;
        this.symbol = playerSymbol;
    }

    public AIPlayer(int playerNumber) {
        if (playerNumber != 1 && playerNumber != 2) {
            playerNumber = 1;
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter a name for player " + playerNumber);
            String str = br.readLine();
            this.name = str;
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e);
        }
        if (playerNumber == 1) {
            this.symbol = "X";
        }
        if (playerNumber == 2) {
            this.symbol = "O";
        }
    }

    // Note this is duplicated in AIPlayer class. Should have used 
    // Abstract class rather than interface
    @Override
    public String getName() {
        return this.name;
    }

// Note this is duplicated in AIPlayer class. Should have used 
    // Abstract class rather than interface
    @Override
    public String getSymbol() {
        return this.symbol;
    }

    // Note this is duplicated in AIPlayer class. Should have used 
    // Abstract class rather than interface
    @Override
    public String getOpponentsSymbol() {
        String opponentsSymbol;
        if (this.symbol.equals("O")) {
            opponentsSymbol = "X";
        } else {
            opponentsSymbol = "O";
        }
        return opponentsSymbol;
    }

    @Override
    public void takeTurn() {
        // Declaring a variable to hold the current best move
        int move;

        // Logic to pick the best square
        move = arbitraryAvailableSquare();

        // Making the move
        NoughtsAndCrosses.grid.set(move, this.symbol);
        System.out.println(this.name + " moves chooses square " + move + ":");
    }

    /**
     * Simple method to return an available square. By default it will pick the
     * centre square if available. If the centre is not available it will pick a
     * corner. If no corners are available it will pick another remaining
     * square. If no squares are available it will thrown an exception.
     *
     * @return an integer to represent an available square.
     * @throws IllegalStateException if there are no available spaces.
     */
    private int arbitraryAvailableSquare() throws IllegalStateException {
        if (NoughtsAndCrosses.grid.get(4).equals(" ")) {
            return 4;
        }
        if (NoughtsAndCrosses.grid.get(0).equals(" ")) {
            return 0;
        }
        if (NoughtsAndCrosses.grid.get(2).equals(" ")) {
            return 2;
        }
        if (NoughtsAndCrosses.grid.get(6).equals(" ")) {
            return 6;
        }
        if (NoughtsAndCrosses.grid.get(8).equals(" ")) {
            return 8;
        }
        if (NoughtsAndCrosses.grid.get(1).equals(" ")) {
            return 1;
        }
        if (NoughtsAndCrosses.grid.get(3).equals(" ")) {
            return 3;
        }
        if (NoughtsAndCrosses.grid.get(5).equals(" ")) {
            return 5;
        }
        if (NoughtsAndCrosses.grid.get(7).equals(" ")) {
            return 7;
        }

        // If this point is reached all the squares are taken and
        // the game should already have ended.
        throw new IllegalStateException();
    }

    private int winningMoveAvailable() {
        int winningMove= 9;
        for (Map vcSet : VictoryConditions.victoryConditions.values()) {
            // If the victory condition includes only empty spaces and this.symbol
            if (!vcSet.containsValue(getOpponentsSymbol()) && 
                        vcSet.containsValue(getOpponentsSymbol()) &&
                        vcSet.containsValue(" ")){
                int numOfSpacesLeft = 3;
                for (String vcSymbol : vcSet.values){
                    if (vcSymbol.equals(this.symbol)){
                        numOfSpacesLeft--;
                    }
                    if (numOfSpacesLeft == 1){
                        // Get the key for which value is " "
                        winningMove = vcSet. // to be completed.
                    }
                }
            
            }     


            }
        }
    }
}
