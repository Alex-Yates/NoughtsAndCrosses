/*
 * This code is purely for fun and learning and shared openly.
 */
package noughtsandcrosses;

/**
 * A noughts and crosses game to be played in the command prompt
 * @author Alex
 */
public class NoughtsAndCrosses {

    /**
     * Orchestration method to execute the required steps to play a game of
     * noughts and crosses.
     */
    public static void main(String[] args) {
        Game game = new Game();
        while (!game.gameEnd()) {
            game.nextPlayer();
            game.takeTurn();
            game.printGrid();
        }
    }
}
