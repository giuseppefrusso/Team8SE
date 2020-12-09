/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
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
        try {
            area = new AreaView();
            area.getConnection().setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AreaViewTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
        try {
            area.getConnection().rollback();
            area.getConnection().setAutoCommit(true);
            area.closeConnection();
            area = null;
        } catch (SQLException ex) {
            Logger.getLogger(AreaViewTest.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        String location = "Fisciano";
        boolean expResult = true;
        boolean result = area.refreshSectors(location);
        assertEquals(expResult, result);

    }

    /**
     * Wrong test of addArea method, of class AreaView.
     */
    @Test
    public void testAddArea1() {
        System.out.println("addArea1");
        String location = "Nocera";
        String sector = "molding";
        boolean expResult = false;
        boolean result = area.addArea(location, sector);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of addArea method, of class AreaView.
     */
    @Test
    public void testAddArea2() {
        System.out.println("addArea2");
        String location = "Roma";
        String sector = "Trigoria";
        boolean expResult = true;
        boolean result = area.addArea(location, sector);
        assertEquals(expResult, result);
    }

    /**
     * Wrong test of removeLocation method, of class AreaView.
     */
    @Test
    public void testRemoveLocation1() {
        System.out.println("removeLocation1");
        String location = "Nocera";
        boolean expResult = false;
        boolean result = area.removeLocation(location);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of removeLocation method, of class AreaView.
     */
    @Test
    public void testRemoveLocation2() {
        System.out.println("removeLocation2");
        String location = "Pagani";
        boolean expResult = true;
        boolean result = area.removeLocation(location);
        assertEquals(expResult, result);
    }

    /**
     * Wrong test of removeSector method, of class AreaView.
     */
    @Test
    public void testRemoveSector1() {
        System.out.println("removeSector1");
        String location = "Nocera";
        String sector = "molding";
        boolean expResult = false;
        boolean result = area.removeSector(location, sector);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of removeSector method, of class AreaView.
     */
    @Test
    public void testRemoveSector2() {
        System.out.println("removeSector2");
        String location = "Pagani";
        String sector = "hydraulic";
        boolean expResult = true;
        boolean result = area.removeSector(location, sector);
        assertEquals(expResult, result);
    }

}