/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsandcrosses;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentPlayer method, of class Game.
     */
    @org.junit.Test
    public void testGetCurrentPlayer() {
        System.out.println("getCurrentPlayer");
        Game instance = new Game();
        iPlayer expResult = null;
        iPlayer result = instance.getCurrentPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextPlayer method, of class Game.
     */
    @org.junit.Test
    public void testNextPlayer() {
        System.out.println("nextPlayer");
        Game instance = new Game();
        instance.nextPlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printGrid method, of class Game.
     */
    @org.junit.Test
    public void testPrintGrid() {
        System.out.println("printGrid");
        Game instance = new Game();
        instance.printGrid();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gameEnd method, of class Game.
     */
    @org.junit.Test
    public void testGameEnd() {
        System.out.println("gameEnd");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.gameEnd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
