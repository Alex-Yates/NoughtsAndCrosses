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
public class AIPlayer extends Player{

    public AIPlayer(String playerName, String playerSymbol) {
        super();
        this.setName(playerName);
        this.setSymbol(playerSymbol);
    }

    public AIPlayer(int playerNumber) {
        if (playerNumber != 1 && playerNumber != 2) {
            playerNumber = 1;
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter a name for player " + playerNumber);
            String str = br.readLine();
            this.setName(str);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e);
        }
        if (playerNumber == 1) {
            this.setSymbol("X");
        }
        if (playerNumber == 2) {
            this.setSymbol("O");
        }
    }

    @Override
    public void takeTurn() {
        // Declaring a variable to hold the current best move
        int move;

        // Logic to pick the best square
        move = arbitraryAvailableSquare();

        // If the opposising player has an opportunity to win, block them
        if (VictoryConditions.winningMoveAvailabeFor(getOpposingPlayer()) != -1){
        move = VictoryConditions.winningMoveAvailabeFor(getOpposingPlayer());
        }       
        
        // If this player can win with a single move, pick that square
        if (VictoryConditions.winningMoveAvailabeFor(this) != -1){
        move = VictoryConditions.winningMoveAvailabeFor(this);
        }
            
            
        // Making the move
        NoughtsAndCrosses.grid.set(move, this.getSymbol());
        System.out.println(this.getName() + " chooses square " + move + ":");
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
    



}
