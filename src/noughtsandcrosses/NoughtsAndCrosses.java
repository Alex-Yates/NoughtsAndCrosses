/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsandcrosses;
import java.util.*;
/**
 *
 * @author Alex
 */
public class NoughtsAndCrosses {

    /**
     * 
     */
    static boolean turn = true;
    static List grid = new ArrayList();
      
    public static void main(String[] args) {
        initialiseGrid();
        printGrid();
    }
    
    public static boolean turnIsTrue (){
        return (turn == true);
    }
    
    public static void nextPlayer (){
        if (turnIsTrue()){
            turn = false;
        }
        else {
            turn = true;
        }
    }
    
    public static void initialiseGrid(){
        for (int i = 0; i < 9; i++){
            grid.add(" ");
        }
    }
    
    public static void printGrid(){
        System.out.println(" " + grid.get(0) + " | " + grid.get(1) + " | " + grid.get(2) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + grid.get(3) + " | " + grid.get(4) + " | " + grid.get(5) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + grid.get(6) + " | " + grid.get(7) + " | " + grid.get(8) + " ");
}   }


