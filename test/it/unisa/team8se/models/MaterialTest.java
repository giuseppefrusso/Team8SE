/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MaterialTest {
    
    Material instance;
    private static Connection con;
    private static Statement stm;
    
    public MaterialTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
                  if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
            con = DatabaseContext.getConnection();
            con.setAutoCommit(false);
          }
                  stm= con.createStatement();
                  
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        con.setAutoCommit(true);
        DatabaseContext.closeConnection();
    }
    
    @Before
    public void setUp() {
        instance = new Material ();
    }
    
    @After
    public void tearDown() {
        try{
            con.rollback();
        instance = null;
        } catch (SQLException ex){
        Logger.getLogger(MaterialTest.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    /**
     * Test of getName method, of class Material.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Material.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = "";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Material.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        instance.setName(name);
        assertEquals(name,instance.getName());
    }

    /**
     * Test of setDescription method, of class Material.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        instance.setDescription(description);
        assertEquals(description,instance.getDescription());
    }
    
    private void deleteAllDatabaseInstances () throws SQLException{
        String query="Delete from materiale";
        stm.executeUpdate(query);
    }
    
    private void addActivityDatabase (Material m) throws SQLException{
      String query= "Insert into materiale values('"+ m.getName()+"','"+ m.getDescription()+"')";
      stm.executeUpdate(query);
    }


    /**
     * Test of getInstanceWithPK method, of class Material.
     */
    @Test
    public void testGetInstanceWithPK() throws SQLException {
        System.out.println("getInstanceWithPK");
        String name = "";
        Material expResult = instance;
        addActivityDatabase(instance);
        Material result = Material.getInstanceWithPK(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveToDatabase method, of class Material.
     */
    @Test
    public void testSaveToDatabase() {
        System.out.println("saveToDatabase");
        Material instance = new Material();
        instance.saveToDatabase();
    }

    /**
     * Test of getFromResultSet method, of class Material.
     */
    @Test
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        Material instance = new Material();
        instance.getFromResultSet(rs);
    }

    /**
     * Test of existsInDatabase method, of class Material.
     */
    @Test
    public void testExistsInDatabase() {
        System.out.println("existsInDatabase");
        Material instance = new Material();
        boolean expResult = false;
        boolean result = instance.existsInDatabase();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeFromDatabase method, of class Material.
     */
    @Test
    public void testRemoveFromDatabase() {
        System.out.println("removeFromDatabase");
        Material instance = new Material();
        instance.removeFromDatabase();
    }

    /**
     * Test of updateToDatabase method, of class Material.
     */
    @Test
    public void testUpdateToDatabase() {
        System.out.println("updateToDatabase");
        Material instance = new Material();
        instance.updateToDatabase();
    }

    /**
     * Test of updateToDatabaseWithName method, of class Material.
     */
    @Test
    public void testUpdateToDatabaseWithName() {
        System.out.println("updateToDatabaseWithName");
        String newName = "";
        Material instance = new Material();
        instance.updateToDatabaseWithName(newName);
    }
    
}
