/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import java.sql.ResultSet;
import java.util.LinkedList;
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
public class AreaTest {

    Area instance;
    public AreaTest() {
    }

    @Before
    public void setUp() {
        instance = new Area("carpentry","Nocera");
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of finalize method, of class Area.
     */
    @Test
    public void testFinalize() throws Exception {

    }

    /**
     * Test of getSector method, of class Area.
     */
    @Test
    public void testGetSector() {
        System.out.println("getSector");
        String result = instance.getSector();
        assertEquals("carpentry", result);
    }

    /**
     * Test of getLocation method, of class Area.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        String result = instance.getLocation();
        assertEquals("Nocera", result);
    }

    /**
     * Test of toString method, of class Area.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Area instance = new Area();
        String result = instance.toString();
        assertTrue(result instanceof String);

    }

    /**
     * Test of getAllDatabaseInstances method, of class Area.
     */
    @Test
    public void testGetAllLocations() {
        System.out.println("getAllDatabaseInstances");
        LinkedList<String> expResult = null;
        LinkedList<String> result = Area.getAllLocations();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllSectorsOf method, of class Area.
     */
    @Test
    public void testGetAllSectorsOf() {
        System.out.println("getAllSectorsOf");
        String location = "";
        LinkedList<Area> expResult = null;
        LinkedList<Area> result = Area.getAllSectorsOf(location);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstanceWithPK method, of class Area.
     */
    @Test
    public void testGetInstanceWithPK() {
        System.out.println("getInstanceWithPK");
        String sector = "";
        String location = "";
        Area expResult = null;
        Area result = Area.getInstanceWithPK(sector, location);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveToDatabase method, of class Area.
     */
    @Test
    public void testSaveToDatabase() throws Exception {
        System.out.println("saveToDatabase");
        Area instance = new Area();
        instance.saveToDatabase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFromResultSet method, of class Area.
     */
    @Test
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        Area instance = new Area();
        instance.getFromResultSet(rs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existsInDatabase method, of class Area.
     */
    @Test
    public void testExistsInDatabase() {
        System.out.println("existsInDatabase");
        Area instance = new Area();
        boolean expResult = false;
        boolean result = instance.existsInDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
