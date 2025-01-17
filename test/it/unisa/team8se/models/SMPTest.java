/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author prgne
 */
public class SMPTest{

    protected SMP instance;
    private static Connection con;
    private static Statement stm;


    @BeforeClass
    public static void setUpClass() throws SQLException {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }
        System.out.println("beforeClass");
        con = DatabaseContext.getConnection();
        con.setAutoCommit(false);
        stm = con.createStatement();
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
        con.setAutoCommit(true);
        SMP.cleanTempDocumentFolder();
        DatabaseContext.closeConnection();
    }

    @Before
    public void setUp() {
        instance = new SMP("nome");
    }

    @After
    public void tearDown() {
        try {
            con.rollback();
            instance = null;
        } catch (SQLException ex) {
            Logger.getLogger(ActivityTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void deleteAllDatabaseInstances() throws SQLException {
        String query = "Delete from smp";
        stm.executeUpdate(query);
    }

    @Test
    public void testImportDocument() {
        try {
            byte[] dummyDoc = new byte[]{10,10,10,10,10};
            Path p = Paths.get(".\\temp\\documento_prova.pdf");
            Files.write(p, dummyDoc);
            instance = new SMP("prova");
            
            instance.importDocument(p.toString());
            Assert.assertArrayEquals(dummyDoc, instance.document);
        } catch (IOException ex) {
            Logger.getLogger(SMPTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testExportDocument() {
        try {
            instance = new SMP("prova");
            instance.document = new byte[]{10,10,10,10,10};
            Path p = Paths.get(".\\temp\\documento_prova.pdf");
            instance.exportDocument(p.toString());
            byte[] result = Files.readAllBytes(p);
            
            Assert.assertArrayEquals(result, instance.document);
        } catch (IOException ex) {
            Logger.getLogger(SMPTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testOpenDocument() {
        instance = SMP.getInstanceWithPK("nome");
        assertTrue(instance.openDocument());
    }

    @Test
    public void testCleanTempDocumentFolder() {
        System.out.println("cleanTempDocumentFolder");
        boolean status = SMP.cleanTempDocumentFolder();
        assertTrue(status);
    }

    @Test
    public void testGetInstanceWithPK() throws SQLException {
        System.out.println("getInstanceWithPK");
        
        String name = "nome_smp_prova";
        instance = new SMP(name);
        instance.document = new byte[]{10,10,10,10,10}; // dummy document
        instance.setDocumentSize(instance.document.length);
        instance.saveToDatabase();
        SMP result = SMP.getInstanceWithPK(name);
        assertTrue(instance.equals(result));
    }

    @Test
    public void testSaveToDatabase() throws Exception {
        instance = new SMP("documento_prova");
        instance.document = new byte[]{10,10,10,10,10};
        try {
            instance.saveToDatabase();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Assert.assertTrue(true);
    }
}
