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
public class HumanPlayer implements iPlayer {
    /**
     * Instance variables
     */
    private String name;
    private String symbol;
    
    /**
     * Constructor
     * @param playerName: The name of the player
     * @param playerSymbol: The symbol the player will use for the game. e.g. "O" or "X"
     */
    public HumanPlayer(String playerName, String playerSymbol){
        super();
        this.name = playerName;
        this.symbol = playerSymbol;
    }
    
    @Override
    public String getName(){
        return this.name;
    }
    
    /**
     * Asks the next player where they would like to go. Then reads the input
     * from the command prompt and updates grid<> accordingly.
     */
    @Override
    public void takeTurn() {
        int move;
        boolean legalMove = false;
        // Copied some of the code for this section from 
        // http://www.avajava.com/tutorials/lessons/
        // how-do-i-accept-text-input-in-a-console-application.html 
        try {
            while (legalMove == false) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println(this.name + "'s turn next:");
                // I'm not sure why but without using line.separator
                // (below) there was no new line after:
                // "Where would you like to go?"
                String newLine = System.getProperty("line.separator");
                System.out.print(this.name + " where would you like to go?" + newLine);
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
                    if (NoughtsAndCrosses.grid.get(move).equals(" ")) {
                        NoughtsAndCrosses.grid.set(move, this.symbol);
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
