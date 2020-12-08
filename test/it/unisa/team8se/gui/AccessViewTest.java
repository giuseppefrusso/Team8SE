/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author giuse
 */
public class AccessViewTest {
    
    public AccessViewTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of refreshPastAccesses method, of class AccessView.
     */
    @Test
    public void testRefreshPastAccesses() {
        System.out.println("refreshPastAccesses");
        AccessView instance = new AccessView();
        boolean expResult = false;
        boolean result = instance.refreshPastAccesses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refreshCurrentAccesses method, of class AccessView.
     */
    @Test
    public void testRefreshCurrentAccesses() {
        System.out.println("refreshCurrentAccesses");
        AccessView instance = new AccessView();
        boolean expResult = false;
        boolean result = instance.refreshCurrentAccesses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refreshAccesses method, of class AccessView.
     */
    @Test
    public void testRefreshAccesses() {
        System.out.println("refreshAccesses");
        AccessView instance = new AccessView();
        boolean expResult = false;
        boolean result = instance.refreshAccesses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AccessView.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AccessView.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
