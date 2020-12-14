/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.sql.*;
import java.util.LinkedList;
import org.junit.After;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
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
    private static Statement stm;
    
    public AreaTest() {
    }
    @BeforeClass
    public static void setUpClass() throws SQLException{
              if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
            con = DatabaseContext.getConnection();
            con.setAutoCommit(false);
          }
              stm= con.createStatement();
    }
    @AfterClass
    public static void tearDownClass() throws SQLException{
        con.setAutoCommit(true);
    DatabaseContext.closeConnection();
    }

    @Before
    public void setUp() {
        instance = new Area("carpentry","Nocera");
    }

    @After
    public void tearDown() {
        try{
        con.rollback();
        instance = null;
        } catch (SQLException ex){
        Logger.getLogger(AreaTest.class.getName()).log(Level.SEVERE,null,ex);
        }
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
        String expresult = instance.getSector() +" - " +instance.getLocation();
        String result =instance.toString();
        assertEquals(expresult, result);

    }
    
    private void deleteAllDatabaseInstances () throws SQLException{
        String query="Delete from area";
        stm.executeUpdate(query);
    }
    
     private void addActivityDatabase(Area a) throws SQLException {
        String query = "Insert into area values ('" + a.getSector() + "','" + a.getLocation() +"')";
        stm.executeUpdate(query);
    }
     @Test
    public void testGetInstanceWithPK() throws SQLException {
        System.out.println("getInstanceWithPK");
        String sector = "carpentry";
        String location = "Nocera";
        Area expResult =instance;
        addActivityDatabase(instance);
        Area result = Area.getInstanceWithPK(sector, location);
        assertEquals(expResult, result);
    }
    
    
     @Test
    public void testSaveToDatabase() throws Exception {
        System.out.println("saveToDatabase");
        try{
        instance.saveToDatabase();
        } catch(SQLException ex){
        System.out.println(ex.getMessage());
        Assert.fail();
        }
    }
    @Test
    public void testExistsInDatabase(){
    System.out.println("existsInDatabase");
    boolean expResult=false;
    boolean result = instance.existsInDatabase();
    assertEquals(expResult,result);
    }
    
    @Test (expected= NullPointerException.class)
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        Area instance = new Area();
        instance.getFromResultSet(rs);
    }
}
