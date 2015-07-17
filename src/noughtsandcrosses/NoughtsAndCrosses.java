/*
 * This code is purely for fun and learning and shared openly.
 */
package noughtsandcrosses;
import java.util.*;
/**
 * A noughts and crosses game to be played in the command prompt
 * @author Alex
 */
public class NoughtsAndCrosses {
    public static List grid = new ArrayList();
    public static Game game = new Game();
    /**
     * Orchestration method to execute the required steps to play a game of
     * noughts and crosses.
     */
    public static void main(String[] args) {

        game.getCurrentPlayer().takeTurn();
        game.printGrid();
        while (!game.gameEnd()) {
            game.nextPlayer();
            game.getCurrentPlayer().takeTurn();
            game.printGrid();
        }
    }
}
