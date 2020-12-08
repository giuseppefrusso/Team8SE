/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gerar
 */
public class AreaViewTest {
    private AreaView area;
    
    public AreaViewTest() {
    }
        
    @Before
    public void setUp() {
        area= new AreaView();
    }
    
    @After
    public void tearDown() {
        area = null;
    }

    /**
     * Test of refreshLocations method, of class AreaView.
     */
    @Test
    public void testRefreshLocations() {
        System.out.println("refreshLocations");
        boolean expResult = true;
        boolean result = area.refreshLocations();
        assertEquals(expResult, result);
    }

    /**
     * Test of refreshSectors method, of class AreaView.
     */
    @Test
    public void testRefreshSectors() {
        System.out.println("refreshSectors");
        String location = "";
        boolean expResult = true;
        boolean result = area.refreshSectors(location);
        assertEquals(expResult, result);

    }

    /**
     * Test of addArea method, of class AreaView.
     */
    @Test
    public void testAddArea() {
        System.out.println("addArea");
        String location = "";
        String sector = "";
        boolean expResult = false;
        boolean result = area.addArea(location, sector);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeLocation method, of class AreaView.
     */
    @Test
    public void testRemoveLocation() {
        System.out.println("removeLocation");
        String location = "Nocera";
        boolean expResult = false;
        boolean result = area.removeLocation(location);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeSector method, of class AreaView.
     */
    @Test
    public void testRemoveSector() {
        System.out.println("removeSector");
        String location = "Nocera";
        String sector = "molding";
        boolean expResult = false;
        boolean result = area.removeSector(location, sector);
        assertEquals(expResult, result);

    }

    
}
