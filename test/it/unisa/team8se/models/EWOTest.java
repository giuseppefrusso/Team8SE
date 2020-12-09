/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prgne
 */
public class EWOTest {
    
    EWO instance;
    
    public EWOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new EWO ();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getTicket method, of class EWO.
     */
    @Test
    public void testGetTicket() {
        System.out.println("getTicket");
        Ticket expResult = null;
        Ticket result = instance.getTicket();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllDatabaseInstances method, of class EWO.
     */
    @Test
    public void testGetAllDatabaseInstances() {
        System.out.println("getAllDatabaseInstances");
        EWO[] expResult = null;
        EWO[] result = EWO.getAllDatabaseInstances();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getInstanceWithPK method, of class EWO.
     */
    @Test
    public void testGetInstanceWithPK() {
        System.out.println("getInstanceWithPK");
        int id = 0;
        EWO expResult = null;
        EWO result = EWO.getInstanceWithPK(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInstancesWithWeekNumber method, of class EWO.
     */
    @Test
    public void testGetInstancesWithWeekNumber() {
        System.out.println("getInstancesWithWeekNumber");
        int weekNumber = 0;
        EWO[] expResult = null;
        EWO[] result = EWO.getInstancesWithWeekNumber(weekNumber);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of saveToDatabase method, of class EWO.
     */
    @Test
    public void testSaveToDatabase() {
        System.out.println("saveToDatabase");
        EWO instance = new EWO();
        instance.saveToDatabase();
    }

    /**
     * Test of getFromResultSet method, of class EWO.
     */
    @Test
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        EWO instance = new EWO();
        instance.getFromResultSet(rs);
    }

    /**
     * Test of existsInDatabase method, of class EWO.
     */
    @Test
    public void testExistsInDatabase() {
        System.out.println("existsInDatabase");
        EWO instance = new EWO();
        boolean expResult = false;
        boolean result = instance.existsInDatabase();
        assertEquals(expResult, result);
    }
    
}
