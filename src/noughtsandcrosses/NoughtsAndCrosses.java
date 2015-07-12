/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsandcrosses;

/**
 *
 * @author Alex
 */
public class NoughtsAndCrosses {

    /**
     * 
     */
    boolean turn = true;
    
    public static void main(String[] args) {
        
    }
    
    public boolean turnIsTrue (){
        return (turn == true);
    }
    
    public void nextPlayer (){
        if (turnIsTrue()){
            turn = false;
        }
        else {
            turn = true;
        }
    }
    
    
}


