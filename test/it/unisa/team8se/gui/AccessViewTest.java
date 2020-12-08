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
    private AccessView access;
    
    public AccessViewTest() {
    }
    
    @Before
    public void setUp() {
        access= new AccessView();
    }
    
    @After
    public void tearDown() {
        access = null;
    }

    /**
     * Test of refreshPastAccesses method, of class AccessView.
     */
    @Test
    public void testRefreshPastAccesses() {
        System.out.println("refreshPastAccesses");
        boolean expResult = true;
        boolean result = access.refreshPastAccesses();
        assertEquals(expResult, result);
    }

    /**
     * Test of refreshCurrentAccesses method, of class AccessView.
     */
    @Test
    public void testRefreshCurrentAccesses() {
        System.out.println("refreshCurrentAccesses");
        boolean expResult = true;
        boolean result = access.refreshCurrentAccesses();
        assertEquals(expResult, result);
    }

    /**
     * Test of refreshAccesses method, of class AccessView.
     */
    @Test
    public void testRefreshAccesses() {
        System.out.println("refreshAccesses");
        boolean expResult = true;
        boolean result = access.refreshAccesses();
        assertEquals(expResult, result);
    }


    
}
