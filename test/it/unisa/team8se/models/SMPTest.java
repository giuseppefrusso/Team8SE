/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.sql.SQLException;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author cptso
 */
public class SMPTest extends TestCase {

    protected SMP instance;

    public SMPTest(String testName) {
        super(testName);
        DatabaseContext.connectDatabase();
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
    public void testImportDocument() {
        instance.importDocument("C:\\Users\\cptso\\Desktop\\", "doc");
        try {
            instance.saveToDatabase();
        } catch (SQLException ex) {}
        assertTrue(instance.file.length > 0);
    }

    public void testExportDocument() {
        instance = SMP.getInstanceWithPK("nome");
        instance.exportDocument("C:\\Users\\cptso\\Desktop\\", "doc1");
    }
}
