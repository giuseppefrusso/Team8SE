/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author prgne
 */
public class AccessTest {

    private static Statement stm;
    private static Connection conn;
    private static Access instance;

    public AccessTest() {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
            conn = DatabaseContext.getConnection();
            conn.setAutoCommit(false);
        }
        stm = conn.createStatement();
        addForeignKey();
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {

        conn.setAutoCommit(true);
        DatabaseContext.closeConnection();
    }

    @Before
    public void setUp() {
        instance = new Access();
    }

    @After
    public void tearDown() {
        try{
            conn.rollback();
        instance = null;
        } catch(SQLException ex){
        Logger.getLogger(AccessTest.class.getName()).log(Level.SEVERE,null,ex);
        }

        try {
            instance = null;
            conn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(AccessTest.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    /**
     * Test of getID method, of class Access.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        int expResult = 0;
        instance.setID(expResult);
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setID method, of class Access.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int ID = 0;
        instance.setID(ID);
        assertEquals(ID, instance.getID());
    }

    /**
     * Test of getUsername method, of class Access.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = "";
        instance.setUsername(expResult);
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Access.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of getDataOraLogin method, of class Access.
     */
    @Test
    public void testGetDataOraLogin() {
        System.out.println("getDataOraLogin");
        Timestamp expResult = null;
        Timestamp result = instance.getDataOraLogin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataOraLogin method, of class Access.
     */
    @Test
    public void testSetDataOraLogin() {
        System.out.println("setDataOraLogin");
        Timestamp dataOraLogin = null;
        instance.setDataOraLogin(dataOraLogin);
        assertEquals(dataOraLogin, instance.getDataOraLogin());
    }

    /**
     * Test of getDataOraLogoff method, of class Access.
     */
    @Test
    public void testGetDataOraLogoff() {
        System.out.println("getDataOraLogoff");
        Timestamp expResult = null;
        Timestamp result = instance.getDataOraLogoff();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataOraLogoff method, of class Access.
     */
    @Test
    public void testSetDataOraLogoff() {
        System.out.println("setDataOraLogoff");
        Timestamp dataOraLogoff = null;
        instance.setDataOraLogoff(dataOraLogoff);
        assertEquals(dataOraLogoff, instance.getDataOraLogoff());
    }

    private void deleteAllDatabaseInstances() throws SQLException {
        String query = "Delete from accesso";
        stm.executeUpdate(query);
    }

    private void addActivityToDatabase(Access a) throws SQLException {
        String query = "Insert into accesso values(" + a.getID() + ",'" + a.getDataOraLogin() + "','" + a.getDataOraLogoff() + "','Marco','Manu','Ale')";
        stm.executeUpdate(query);
    }

    private static void addForeignKey() throws SQLException {
        String query1 = "Insert into maintainer values('Ale','cit','ro','nel')";
        String query2 = "Insert into planner values ('Manu','cos','nick','ola')";
        String query3 = "Insert into system_administrator values ('Marco','sin','orn','dries')";
        stm.executeUpdate(query1);
        stm.executeUpdate(query2);
        stm.executeUpdate(query3);
    }

    private static void removeForeignKey() throws SQLException {
        String query1 = "Delete from maintainer where username=('Ale')";
        String query2 = "Delete from planner where username='Manu'";
        String query3 = "Delete from system_administrator where username='Marco'";
        stm.executeUpdate(query1);
        stm.executeUpdate(query2);
        stm.executeUpdate(query3);
    }



    /**
     * Test of getInstanceWithPK method, of class Access.
     */
    /*@Test
    public void testGetInstanceWithPK() throws SQLException {
        System.out.println("getInstanceWithPK");
        int ID = 1;
        Access expResult = instance;
        addForeignKey();
        addActivityToDatabase(instance);
        Access result = Access.getInstanceWithPK(ID);
        assertTrue(result instanceof Access);
    }*/

    /**
     * Test of getFromResultSet method, of class Access.
     */
    @Test (expected= NullPointerException.class)
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        Access instance = new Access();
        instance.getFromResultSet(rs);
    }

    /**
     * Test of existsInDatabase method, of class Access.
     */
    @Test
    public void testExistsInDatabase() throws SQLException {
        System.out.println("existsInDatabase");
        boolean expResult = false;
        boolean result = instance.existsInDatabase();
        assertEquals(expResult, result);
    }

    /**
     * Test of toPastArray method, of class Access.
     */
    @Test
    public void testToPastArray() {
        System.out.println("toPastArray");
        Object[] expResult = {1, "Stringa", new Timestamp(192188), new Timestamp(301814)};
        instance.setID(1);
        instance.setUsername("Stringa");
        instance.setDataOraLogin(new Timestamp(192188));
        instance.setDataOraLogoff(new Timestamp(301814));
        Object[] result = instance.toPastArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of toCurrentArray method, of class Access.
     */
    @Test
    public void testToCurrentArray() {
        System.out.println("toCurrentArray");
        Object[] expResult = {1, "Stringa", new Timestamp(192188)};
        instance.setID(1);
        instance.setUsername("Stringa");
        instance.setDataOraLogin(new Timestamp(192188));
        Object[] result = instance.toCurrentArray();
        assertArrayEquals(expResult, result);
    }

}
