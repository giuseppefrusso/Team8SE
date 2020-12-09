/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import java.sql.ResultSet;
import java.sql.Timestamp;
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
public class AccessTest {
    
    Access instance;
    
    public AccessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Access();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getID method, of class Access.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        int expResult = 0;
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
        assertEquals(ID,instance.getID());
    }

    /**
     * Test of getUsername method, of class Access.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = "";
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
        assertEquals(username,instance.getUsername());
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
        assertEquals(dataOraLogin,instance.getDataOraLogin());
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
        assertEquals(dataOraLogoff,instance.getDataOraLogoff());
    }

    /**
     * Test of getAllDatabaseInstances method, of class Access.
     */
    @Test
    public void testGetAllDatabaseInstances() throws Exception {
        System.out.println("getAllDatabaseInstances");
        Access[] expResult = null;
        Access[] result = Access.getAllDatabaseInstances();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getInstanceWithPK method, of class Access.
     */
    @Test
    public void testGetInstanceWithPK() {
        System.out.println("getInstanceWithPK");
        int ID = 0;
        Access expResult = null;
        Access result = Access.getInstanceWithPK(ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFromResultSet method, of class Access.
     */
    @Test
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        Access instance = new Access();
        instance.getFromResultSet(rs);
    }

    /**
     * Test of saveToDatabase method, of class Access.
     */
    @Test
    public void testSaveToDatabase() throws Exception {
        System.out.println("saveToDatabase");
        Access instance = new Access();
        instance.saveToDatabase();
    }

    /**
     * Test of logoff method, of class Access.
     */
    @Test
    public void testLogoff() throws Exception {
        System.out.println("logoff");
        Access instance = new Access();
        instance.logoff();
    }

    /**
     * Test of existsInDatabase method, of class Access.
     */
    @Test
    public void testExistsInDatabase() throws Exception {
        System.out.println("existsInDatabase");
        Access instance = new Access();
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
        Object[] expResult = null;
        Object[] result = instance.toPastArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of toCurrentArray method, of class Access.
     */
    @Test
    public void testToCurrentArray() {
        System.out.println("toCurrentArray");
        Object[] expResult = null;
        Object[] result = instance.toCurrentArray();
        assertArrayEquals(expResult, result);
    }
    
}
