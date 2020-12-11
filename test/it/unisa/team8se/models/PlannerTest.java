/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.sql.*;
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
public class PlannerTest {
    
    Planner instance;
    private static Connection con;
    
    public PlannerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
                  if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
            con = DatabaseContext.getConnection();
          }
    }
    
    @AfterClass
    public static void tearDownClass() {
        DatabaseContext.closeConnection();
    }
    
    @Before
    public void setUp() {
        instance= new Planner("Flaco", "flachito", "Pastore", "Javier");
    }
    
    @After
    public void tearDown() {
        instance = null;
    }
    
    private void deleteAllDatabaseIntances (Statement stm) throws SQLException{
        String query="Delete from planner";
        stm.executeUpdate(query);
    }
    
     private void addActivityDatabase (Statement stm, Planner p){
      String query= "Insert into planner values ("+ p.getUsername()+","+ p.getPassword()+","+ p.getSurname()+","+ p.getName()+")";
    }

    /**
     * Test of getAllDatabaseInstances method, of class Planner.
     */
    @Test
    public void testGetAllDatabaseInstances() {
        System.out.println("getAllDatabaseInstances");
        Planner[] expResult = null;
        Planner[] result = Planner.getAllDatabaseInstances();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getInstanceWithPK method, of class Planner.
     */
    @Test
    public void testGetInstanceWithPK() {
        System.out.println("getInstanceWithPK");
        String username = "";
        Planner expResult = null;
        Planner result = Planner.getInstanceWithPK(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveToDatabase method, of class Planner.
     */
    @Test
    public void testSaveToDatabase() {
        System.out.println("saveToDatabase");
        Planner instance = new Planner();
        instance.saveToDatabase();
    }

    /**
     * Test of removeFromDatabase method, of class Planner.
     */
    @Test
    public void testRemoveFromDatabase() throws Exception {
        System.out.println("removeFromDatabase");
        String username = "";
        Planner.removeFromDatabase(username);
    }

    /**
     * Test of updateToDatabase method, of class Planner.
     */
    @Test
    public void testUpdateToDatabase_0args() {
        System.out.println("updateToDatabase");
        Planner instance = new Planner();
        instance.updateToDatabase();
    }

    /**
     * Test of updateToDatabase method, of class Planner.
     */
    @Test
    public void testUpdateToDatabase_String() {
        System.out.println("updateToDatabase");
        String newPk = "";
        Planner instance = new Planner();
        instance.updateToDatabase(newPk);
    }

    /**
     * Test of getFromResultSet method, of class Planner.
     */
    @Test
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        Planner instance = new Planner();
        instance.getFromResultSet(rs);
    }

    /**
     * Test of existsInDatabase method, of class Planner.
     */
    @Test
    public void testExistsInDatabase() {
        System.out.println("existsInDatabase");
        Planner instance = new Planner();
        boolean expResult = false;
        boolean result = instance.existsInDatabase();
        assertEquals(expResult, result);
    }

    /**
     * Test of authenticate method, of class Planner.
     */
    @Test
    public void testAuthenticate() {
        System.out.println("authenticate");
        String username = "";
        String password = "";
        Planner expResult = null;
        Planner result = Planner.authenticate(username, password);
        assertEquals(expResult, result);
    }
    
}
