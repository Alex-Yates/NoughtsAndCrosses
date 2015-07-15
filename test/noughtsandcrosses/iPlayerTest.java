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
public class iPlayerTest {
    
    public iPlayerTest() {
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
     * Test of takeTurn method, of class iPlayer.
     */
    @org.junit.Test
    public void testTakeTurn() {
        System.out.println("takeTurn");
        iPlayer instance = new iPlayerImpl();
        instance.takeTurn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class iPlayer.
     */
    @org.junit.Test
    public void testGetName() {
        System.out.println("getName");
        iPlayer instance = new iPlayerImpl();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class iPlayerImpl implements iPlayer {

        public void takeTurn() {
        }

        public String getName() {
            return "";
        }
    }
    
}
