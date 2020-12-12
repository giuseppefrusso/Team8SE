/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.sql.*;
import it.unisa.team8se.models.Competence;
import it.unisa.team8se.models.Maintainer;
import java.sql.ResultSet;
import java.util.LinkedList;
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
public class MaintainerTest {
    
    Maintainer instance;
    private static Connection con;
    private static Statement stm;
    
    public MaintainerTest() {
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
    public static void tearDownClass() {
        DatabaseContext.closeConnection();
    }
    
    @Before
    public void setUp() {
        instance= new Maintainer("Smaug", "gandalf","Lucio","Tito");
    }
    
    @After
    public void tearDown() {
        instance =null;
    }

    /**
     * Test of getCompetencies method, of class Maintainer.
     */
    @Test
    public void testGetCompetencies() {
        System.out.println("getCompetencies");
        LinkedList<Competence> expResult= new LinkedList<>();
        LinkedList<Competence> result = instance.getCompetencies();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompetencies method, of class Maintainer.
     */
    @Test
    public void testSetCompetencies() {
        System.out.println("setCompetencies");
        LinkedList<Competence> competencies = null;
        instance.setCompetencies(competencies);
        assertEquals(competencies,instance.getCompetencies());
    }

    /**
     * Test of addCompetence method, of class Maintainer.
     */
    @Test
    public void testAddCompetence() {
        System.out.println("addCompetence");
        Competence c = new Competence (1,"Testing");
        instance.addCompetence(c);
        LinkedList<Competence> expResult= new LinkedList <>();
        expResult.add(c);
        assertEquals(true,instance.getCompetencies().equals(expResult));
    }

    /**
     * Test of removeCompetence method, of class Maintainer.
     */
    @Test
    public void testRemoveCompetence() {
        System.out.println("removeCompetence");
        int ID = 0;
        Maintainer instance = new Maintainer();
        instance.removeCompetence(ID);
    }
    
    private void deleteAllDatabaseInstances () throws SQLException{
        String query="Delete from maintainer";
        stm.executeUpdate(query);
    }
    
    private void addActivityDatabase (Maintainer m) throws SQLException{
      String query= "Insert into maintainer values('"+ m.getUsername()+"','"+ m.getPassword()+"','"+ m.getSurname()+"','"+ m.getName()+"')";
      stm.executeUpdate(query);
    }

    /**
     * Test of getAllDatabaseInstances method, of class Maintainer.
     */
    @Test
    public void testGetAllDatabaseInstances() throws Exception {
        System.out.println("getAllDatabaseInstances");
        deleteAllDatabaseInstances();
        Maintainer m=instance;
        Maintainer[] expResult = {m};
        addActivityDatabase(m);
        Maintainer[] result = Maintainer.getAllDatabaseInstances();
        assertArrayEquals(expResult, result);
        con.rollback();
    }

    /**
     * Test of getInstanceWithPK method, of class Maintainer.
     */
    @Test
    public void testGetInstanceWithPK() throws Exception {
        System.out.println("getInstanceWithPK");
        deleteAllDatabaseInstances();
        String username = "";
        Maintainer expResult = instance;
        Maintainer result = Maintainer.getInstanceWithPK(username);
        assertEquals(expResult, result);
        con.rollback();
    }

    /**
     * Test of updateToDatabase method, of class Maintainer.
     */
    @Test
    public void testUpdateToDatabase_0args() throws Exception {
        System.out.println("updateToDatabase");
        Maintainer instance = new Maintainer();
        instance.updateToDatabase();
    }

    /**
     * Test of updateToDatabase method, of class Maintainer.
     */
    @Test
    public void testUpdateToDatabase_String() throws Exception {
        System.out.println("updateToDatabase");
        String newPk = "";
        Maintainer instance = new Maintainer();
        instance.updateToDatabase(newPk);
    }

    /**
     * Test of removeFromDatabase method, of class Maintainer.
     */
    @Test
    public void testRemoveFromDatabase() throws Exception {
        System.out.println("removeFromDatabase");
        String username = "";
        Maintainer.removeFromDatabase(username);
    }

    /**
     * Test of saveToDatabase method, of class Maintainer.
     */
    @Test
    public void testSaveToDatabase() throws Exception {
        System.out.println("saveToDatabase");
        Maintainer instance = new Maintainer();
        instance.saveToDatabase();
    }

    /**
     * Test of getFromResultSet method, of class Maintainer.
     */
    @Test
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        Maintainer instance = new Maintainer();
        instance.getFromResultSet(rs);
    }

    /**
     * Test of existsInDatabase method, of class Maintainer.
     */
    @Test
    public void testExistsInDatabase() throws Exception {
        System.out.println("existsInDatabase");
        Maintainer instance = new Maintainer();
        boolean expResult = false;
        boolean result = instance.existsInDatabase();
        assertEquals(expResult, result);
    }

    /**
     * Test of authenticate method, of class Maintainer.
     */
    @Test
    public void testAuthenticate() throws Exception {
        System.out.println("authenticate");
        String username = "";
        String password = "";
        Maintainer expResult = null;
        Maintainer result = Maintainer.authenticate(username, password);
        assertEquals(expResult, result);
    }
    
}
