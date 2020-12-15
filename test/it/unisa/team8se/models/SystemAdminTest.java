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
    public static void tearDownClass() throws SQLException {
        con.setAutoCommit(true);
        DatabaseContext.closeConnection();
    }
    
    @Before
    public void setUp() {
        instance = new SystemAdmin("Paco", "nothing", "Lucci", "Alessandro");
    }
    
    @After
    public void tearDown() {
        try{
            con.rollback();
        instance = null;
        } catch( SQLException ex){
        Logger.getLogger(SystemAdminTest.class.getName()).log(Level.SEVERE,null,ex);
          }
    }
    
     private void deleteAllDatabaseInstances () throws SQLException{
        String query="Delete from system_administrator";
        stm.executeUpdate(query);
    }
    private void addActivityDatabase( SystemAdmin sa) throws SQLException {
        String query = "Insert into system_administrator values ('" + sa.getUsername() + "','" + sa.getPassword() + "','" + sa.getSurname() + "','" + sa.getName() + "')";
        stm.executeUpdate(query);
    }

    /**
     * Test of getInstanceWithPK method, of class SystemAdmin.
     */
    @Test
    public void testGetInstanceWithPK() throws SQLException {
        System.out.println("getInstanceWithPK");
        String username = "mio";
        SystemAdmin sa = new SystemAdmin("pol","mott","mio","baul");
        addActivityDatabase(sa);
        SystemAdmin result = SystemAdmin.getInstanceWithPK(username);
        assertEquals(sa, result);
    }

    /**
     * Test of getFromResultSet method, of class SystemAdmin.
     */
    @Test(expected= NullPointerException.class)
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
