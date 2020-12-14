/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author prgne
 */
public class SMPTest extends TestCase {

    protected SMP instance;
    private static Connection con;
     private static Statement stm;

    public SMPTest(String testName) {
        super(testName);
        DatabaseContext.connectDatabase();
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
    public void setUp() throws Exception {
        super.setUp();
        instance = new SMP("nome");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        instance = null;
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        String result = instance.getNome();
        assertEquals("nome", result);
    }

    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String Nome = "";
        instance.setNome(Nome);
        assertEquals(Nome, instance.getNome());
    }
    
    private void deleteAllDatabaseInstances () throws SQLException{
        String query="Delete from smp";
        stm.executeUpdate(query);
    }
    
     private void addActivityDatabase(SMP sm) {

    }
    
    @Test
    public void testImportDocument() {
        try {
            instance.importDocument("C:\\Users\\cptso\\Desktop\\", "doc");
            instance.saveToDatabase();
        } catch (IOException ex) {
            Logger.getLogger(SMPTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SMPTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testExportDocument() {
        instance = SMP.getInstanceWithPK("nome");
        instance.exportDocument("C:\\Users\\cptso\\Desktop\\", "doc1");
    }    
    @Test
    public void testOpenDocument(){
        instance = SMP.getInstanceWithPK("nome");
        assertTrue(instance.openDocument());   
    }
    @Test
    public void testCleanTemp(){
        boolean status = SMP.cleanTempDocumentFolder();
        assertTrue(status);   
    }
    
    
     @Test
    public void testGetInstanceWithPK() throws SQLException {
        System.out.println("getInstanceWithPK");
        deleteAllDatabaseInstances();
        String name = "";
        SMP expResult = instance;
        addActivityDatabase(instance);
        SMP result = SMP.getInstanceWithPK(name);
        assertEquals(expResult, result);
        con.rollback();
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
}
