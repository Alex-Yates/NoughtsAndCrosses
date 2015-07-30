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
public abstract class Player implements iPlayer {
    /**
     * Instance variables
     */
    private String name;
    private String symbol;
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String str) {
        this.name = str;
    }
    
    @Override
    public String getSymbol(){
        return this.symbol;
    }

    @Override
    public void setSymbol(String str) {
        this.symbol = str;
    }
        
    @Override
    public String getOpponentsSymbol(){
        String opponentsSymbol;
        if (this.symbol.equals("O")){
            opponentsSymbol = "X";
        } else {
            opponentsSymbol = "O";
        }
        return opponentsSymbol;  
    }    
    
    @Override
    abstract public void takeTurn();
    
    @Override
    public iPlayer getOpposingPlayer(){
        if (this.getSymbol().equals("X")){
            return NoughtsAndCrosses.game.getPlayer2();
        }
        else return NoughtsAndCrosses.game.getPlayer1();
    }
}
