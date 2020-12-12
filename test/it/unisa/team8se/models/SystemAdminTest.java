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
public class SystemAdminTest {
    
    SystemAdmin instance;
    private static Connection con;
    private static Statement stm;
    
    public SystemAdminTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
                  if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
            con = DatabaseContext.getConnection();
            con.setAutoCommit(false);
          }
                  stm=con.createStatement();
    }
    
    @AfterClass
    public static void tearDownClass() {
        DatabaseContext.closeConnection();
    }
    
    @Before
    public void setUp() {
        instance = new SystemAdmin("Paco", "nothing", "Lucci", "Alessandro");
    }
    
    @After
    public void tearDown() {
        instance = null;
    }
    
     private void deleteAllDatabaseIntances (Statement stm) throws SQLException{
        String query="Delete from system_administrator";
        stm.executeUpdate(query);
    }
    private void addActivityDatabase(Statement stm, SystemAdmin sa) throws SQLException {
        String query = "Insert into system_administrator values ('" + sa.getUsername() + "','" + sa.getPassword() + "','" + sa.getSurname() + "','" + sa.getName() + "')";
        stm.executeUpdate(query);
    }

    /**
     * Test of getAllDatabaseInstances method, of class SystemAdmin.
     */
    @Test
    public void testGetAllDatabaseInstances() {
        System.out.println("getAllDatabaseInstances");
        SystemAdmin[] expResult = null;
        SystemAdmin[] result = SystemAdmin.getAllDatabaseInstances();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getInstanceWithPK method, of class SystemAdmin.
     */
    @Test
    public void testGetInstanceWithPK() {
        System.out.println("getInstanceWithPK");
        String username = "";
        SystemAdmin expResult = null;
        SystemAdmin result = SystemAdmin.getInstanceWithPK(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFromResultSet method, of class SystemAdmin.
     */
    @Test
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        SystemAdmin instance = new SystemAdmin();
        instance.getFromResultSet(rs);
    }

    /**
     * Test of saveToDatabase method, of class SystemAdmin.
     */
    @Test
    public void testSaveToDatabase() {
        System.out.println("saveToDatabase");
        SystemAdmin instance = new SystemAdmin();
        instance.saveToDatabase();
    }

    /**
     * Test of removeFromDatabase method, of class SystemAdmin.
     */
    @Test
    public void testRemoveFromDatabase() throws Exception {
        System.out.println("removeFromDatabase");
        String username = "";
        SystemAdmin.removeFromDatabase(username);
    }

    /**
     * Test of updateToDatabase method, of class SystemAdmin.
     */
    @Test
    public void testUpdateToDatabase_0args() {
        System.out.println("updateToDatabase");
        SystemAdmin instance = new SystemAdmin();
        instance.updateToDatabase();
    }

    /**
     * Test of updateToDatabase method, of class SystemAdmin.
     */
    @Test
    public void testUpdateToDatabase_String() {
        System.out.println("updateToDatabase");
        String newPk = "";
        SystemAdmin instance = new SystemAdmin();
        instance.updateToDatabase(newPk);
    }

    /**
     * Test of existsInDatabase method, of class SystemAdmin.
     */
    @Test
    public void testExistsInDatabase() {
        System.out.println("existsInDatabase");
        SystemAdmin instance = new SystemAdmin();
        boolean expResult = false;
        boolean result = instance.existsInDatabase();
        assertEquals(expResult, result);
    }

    /**
     * Test of authenticate method, of class SystemAdmin.
     */
    @Test
    public void testAuthenticate() {
        System.out.println("authenticate");
        String username = "";
        String password = "";
        SystemAdmin expResult = null;
        SystemAdmin result = SystemAdmin.authenticate(username, password);
        assertEquals(expResult, result);
    }
    
}
