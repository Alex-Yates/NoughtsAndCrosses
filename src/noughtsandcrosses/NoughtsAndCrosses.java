/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsandcrosses;

import java.util.*;
import java.io.*;

/**
 *
 * @author Alex
 */
public class NoughtsAndCrosses {

    /**
     *
     */
    static String currentPlayer = "O";
    static List grid = new ArrayList();

    public static void main(String[] args) {
        initialiseGrid();
        while (!gameEnd()) {
            nextPlayer();
            takeTurn();
            printGrid();
        }
    }

    public static boolean turnIsX() {
        return (currentPlayer.equals("X"));
    }

    public static void nextPlayer() {
        if (turnIsX()) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }

    public static void initialiseGrid() {
        for (int i = 0; i < 9; i++) {
            grid.add(" ");
        }
    }

    public static void printGrid() {
        System.out.println(" " + grid.get(0) + " | " + grid.get(1) + " | " + grid.get(2) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + grid.get(3) + " | " + grid.get(4) + " | " + grid.get(5) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + grid.get(6) + " | " + grid.get(7) + " | " + grid.get(8) + " ");
    }

    public static boolean isWon() {
        boolean gameIsWon = false;
        String winner;
        winner = "";
        
        //Determining if victory conditions are met
        if (grid.get(0).equals(grid.get(1)) && grid.get(1).equals(grid.get(2)) && !grid.get(0).equals(" ")){
            gameIsWon = true;
            winner = (String) grid.get(0);
        }
        else if (grid.get(3).equals(grid.get(4)) && grid.get(4).equals(grid.get(5)) && !grid.get(3).equals(" ")){
            gameIsWon = true;
            winner = (String) grid.get(3);
        }
        else if (grid.get(6).equals(grid.get(7)) && grid.get(7).equals(grid.get(8)) && !grid.get(6).equals(" ")){
            gameIsWon = true;
            winner = (String) grid.get(6);
        }
        else if (grid.get(0).equals(grid.get(3)) && grid.get(3).equals(grid.get(6)) && !grid.get(0).equals(" ")){
            gameIsWon = true;
            winner = (String) grid.get(0);
        }
        else if (grid.get(1).equals(grid.get(4)) && grid.get(4).equals(grid.get(7)) && !grid.get(1).equals(" ")){
            gameIsWon = true;
            winner = (String) grid.get(1);
        }
        else if (grid.get(2).equals(grid.get(5)) && grid.get(5).equals(grid.get(8)) && !grid.get(2).equals(" ")){
            gameIsWon = true;
            winner = (String) grid.get(2);
        }
        else if (grid.get(0).equals(grid.get(4)) && grid.get(4).equals(grid.get(8)) && !grid.get(0).equals(" ")){
            gameIsWon = true;
            winner = (String) grid.get(0);
        }
        else if (grid.get(2).equals(grid.get(4)) && grid.get(4).equals(grid.get(6)) && !grid.get(2).equals(" ")){
            gameIsWon = true;
            winner = (String) grid.get(0);
        }
        
        // Logging the winner 
        if (gameIsWon){
            System.out.println("Game over! " + winner + "'s win!");
        }
        
        // Signalling whether the game is over
        return gameIsWon;
    }
    
    public static boolean isDraw(){
        if (!isWon() && !grid.contains(" ")){
            System.out.println("It's a draw!");
            return true;    
        }
        return false;
    }
    
    public static boolean gameEnd(){
        return (isWon() || isDraw());
    }

    public static void takeTurn() {
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
