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
public class EWOTest {
    
    EWO instance;
    public static Connection con;
    
    public EWOTest() {
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
    
    private void deleteAllDatabaseIntances (Statement stm) throws SQLException{
        String query="Delete from ewo";
        stm.executeUpdate(query);
    }
    
      private void addActivityDatabase (Statement stm, EWO e){
    //String query= "Insert into EWO values("+ e.getID()+", 'doc','Fisciano','Carpentry','Ale','Manu'"+ e.getTipology()+","+ e.getDatetime()+","+ e.getWeekNumber()+","+ e.getEIT()+","+ e.getWorkspaceNotes()+","+ e.getInterventionDescription()+","+;
    }
      
       private void addForeignKey() throws SQLException{
        Statement stm = con.createStatement();
        String query1="Insert into area values ('Fisciano','Carpentry')";
        String query2="Insert into planner values ('Manu')";
        String query3="Insert into smp values ('doc')";
        String query4="Insert into maintainer values ('Ale')";
        stm.executeUpdate(query1);
        stm.executeUpdate(query2);
        stm.executeUpdate(query3);
        stm.executeUpdate(query4);
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
