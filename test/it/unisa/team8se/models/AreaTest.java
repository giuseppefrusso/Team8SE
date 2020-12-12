/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.sql.*;
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
    private static Connection con;
    
    public AreaTest() {
    }
    @BeforeClass
    public static void setUpClass(){
              if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
            con = DatabaseContext.getConnection();
          }
    }
    @AfterClass
    public static void tearDownClass(){
    DatabaseContext.closeConnection();
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
    
    private void deleteAllDatabaseIntances (Statement stm) throws SQLException{
        String query="Delete from area";
        stm.executeUpdate(query);
    }
    
     private void addActivityDatabase(Statement stm, Area a) {
        String query = "Insert into planner values ('" + a.getSector() + "','" + a.getLocation() +"')";
    }
}
