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
public interface iPlayer {
    
    public void takeTurn();
    public String getName();
    public void setName(String str);
    public String getSymbol();
    public void setSymbol(String str);
    public String getOpponentsSymbol();
    public iPlayer getOpposingPlayer();
    
}
