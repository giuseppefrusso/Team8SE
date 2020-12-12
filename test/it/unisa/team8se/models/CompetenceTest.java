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
public class CompetenceTest {
    Competence instance;
    private static Connection con;
    private static Statement stm;
    
    public CompetenceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
                  if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
            con = DatabaseContext.getConnection();
            con.setAutoCommit(false);
          }
                  stm = con.createStatement();
    }
    
    @AfterClass
    public static void tearDownClass() {
        DatabaseContext.closeConnection();
    }
    
    @Before
    public void setUp() {
        instance = new Competence(1,"Testing");
    }
    
    @After
    public void tearDown() {
        instance= null;
    }

    /**
     * Test of getID method, of class Competence.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        int result = instance.getID();
        assertEquals(1, result);
    }

    /**
     * Test of getDescrizione method, of class Competence.
     */
    @Test
    public void testGetDescrizione() {
        System.out.println("getDescrizione");
        String result = instance.getDescrizione();
        assertEquals("Testing", result);
    }

    /**
     * Test of setID method, of class Competence.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int ID = 0;
        instance.setID(ID);
        assertEquals(ID,instance.getID());
    }

    /**
     * Test of setDescrizione method, of class Competence.
     */
    @Test
    public void testSetDescrizione() {
        System.out.println("setDescrizione");
        String Descrizione = "";
        instance.setDescrizione(Descrizione);
        assertEquals(true,instance.getDescrizione().equals(Descrizione));
    }

    /**
     * Test of getAllCompetenceOfMaintainer method, of class Competence.
     */
    @Test
    public void testGetAllCompetenceOfMaintainer() {
        System.out.println("getAllCompetenceOfMaintainer");
        String username = "";
        Competence[] expResult = null;
        Competence[] result = Competence.getAllCompetencesOfMaintainer(username);
        assertArrayEquals(expResult, result);
    }
    
    private void deleteAllDatabaseInstances () throws SQLException{
        String query="Delete from competenza";
        stm.executeUpdate(query);
    }
    
    private void addActivityDatabase (Competence c) throws SQLException{
    String query= "Insert into competenza values("+c.getID()+",'" +c.getDescrizione()+"')";
    stm.executeUpdate(query);
    }
    

    /**
     * Test of getAllDatabaseInstances method, of class Competence.
     */
    @Test
    public void testGetAllDatabaseInstances() throws SQLException {
        System.out.println("getAllDatabaseInstances");
        deleteAllDatabaseInstances();
        Competence c=instance;
        Competence[] expResult = {c};
        addActivityDatabase(c);
        Competence[] result = Competence.getAllDatabaseInstances();
        assertArrayEquals(expResult, result);
        con.rollback();
    }

    /**
     * Test of getInstanceWithPK method, of class Competence.
     */
    @Test
    public void testGetInstanceWithPK() throws SQLException {
        System.out.println("getInstanceWithPK");
        deleteAllDatabaseInstances();
        int id = 0;
        Competence expResult = instance;
        addActivityDatabase(instance);
        Competence result = Competence.getInstanceWithPK(id);
        assertEquals(expResult, result);
        con.rollback();
    }

    /**
     * Test of getInstanceWithDescription method, of class Competence.
     */
    @Test
    public void testGetInstanceWithDescription() throws SQLException {
        System.out.println("getInstanceWithDescription");
        deleteAllDatabaseInstances();
        String desc = "";
        Competence expResult = instance;
        addActivityDatabase(instance);
        Competence result = Competence.getInstanceWithDescription(desc);
        assertEquals(expResult, result);
        con.rollback();
    }

    /**
     * Test of saveToDatabase method, of class Competence.
     */
    @Test
    public void testSaveToDatabase() {
        System.out.println("saveToDatabase");
        Competence instance = new Competence();
        instance.saveToDatabase();
    }

    /**
     * Test of getFromResultSet method, of class Competence.
     */
    @Test
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        Competence instance = new Competence();
        instance.getFromResultSet(rs);
    }

    /**
     * Test of existsInDatabase method, of class Competence.
     */
    @Test
    public void testExistsInDatabase() {
        System.out.println("existsInDatabase");
        Competence instance = new Competence();
        boolean expResult = false;
        boolean result = instance.existsInDatabase();
        assertEquals(expResult, result);
    }
    
}
