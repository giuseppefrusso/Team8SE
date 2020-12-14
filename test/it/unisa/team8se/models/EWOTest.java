/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
    private static Statement stm;
    
    public EWOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
                  if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
            con = DatabaseContext.getConnection();
            con.setAutoCommit(false);
          }
                  stm= con.createStatement();
                  addForeignKey();
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        con.setAutoCommit(true);
        DatabaseContext.closeConnection();
    }
    
    @Before
    public void setUp() {
        instance = new EWO ();
    }
    
    @After
    public void tearDown() {
        try{
            con.rollback();
        instance = null;
        } catch (SQLException ex){
            Logger.getLogger(EWOTest.class.getName()).log(Level.SEVERE,null,ex);
        }
        
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
    
    private void deleteAllDatabaseInstances () throws SQLException{
        String query="Delete from ewo";
        stm.executeUpdate(query);
    }
    
      private void addActivityDatabase (EWO e) throws SQLException{
          String query = "Insert into ewo values(" + e.getID() + ", 'doc','Fisciano','Carpentry','Ale','Manu'" + e.getTipology() + "," + e.getDatetime() + "," + e.getWeekNumber() + "," + e.getEIT() + "," + e.getWorkspaceNotes() + "," + e.getInterventionDescription() + "','non avviato','in corso','chiuso','inviato per primo','ricevuto','letto','inviato','ricevuto','non inviato') ";
          stm.executeUpdate(query);
      }
      
       private static void addForeignKey() throws SQLException{
        String query1="Insert into area values ('Fisciano','Carpentry')";
        String query2="Insert into planner values ('Manu','cos','nick','ola')";
        String query3="Insert into smp values ('doc','pdf')";
        String query4="Insert into maintainer values ('Ale','cit','ro','nell')";
        stm.executeUpdate(query1);
        stm.executeUpdate(query2);
        stm.executeUpdate(query3);
        stm.executeUpdate(query4);
    }
       
        
    private static void removeForeignKey() throws SQLException{
    String query1="Delete from area where (nome,luogo_geografico)=('Fisciano','Carpentry')";
    String query2="Delete from planner where username='Manu'";
    String query3="Delete from smp where nome='doc'";
    String query4="Delete from maintainer where username='Ale'";
    stm.executeUpdate(query1);
    stm.executeUpdate(query2);
    stm.executeUpdate(query3);
    stm.executeUpdate(query4);
    }


    /**
     * Test of getInstanceWithPK method, of class EWO.
     */
    @Test
    public void testGetInstanceWithPK() throws SQLException {
        System.out.println("getInstanceWithPK");
        int id = 1;
        EWO expResult = instance;
        addForeignKey();
        addActivityDatabase(instance);
        EWO result = EWO.getInstanceWithPK(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInstancesWithWeekNumber method, of class EWO.
     */
    @Test
    public void testGetInstancesWithWeekNumber() throws SQLException {
        System.out.println("getInstancesWithWeekNumber");
        deleteAllDatabaseInstances();
        int weekNumber = 3;
        EWO e =instance;
        EWO[] expResult = {e};
        addActivityDatabase(e);
        EWO[] result = EWO.getInstancesWithWeekNumber(weekNumber);
        assertArrayEquals(expResult, result);
        con.rollback();
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
