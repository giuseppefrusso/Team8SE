/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.DatabaseContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gerar
 */
public class ActivityViewTest {
    private static ActivityView act;
    private static Connection connection;
    
    public ActivityViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {       
        act = new ActivityView();
        connection = DatabaseContext.getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(AreaViewTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        try {
            connection.setAutoCommit(true);
            DatabaseContext.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AreaViewTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(AreaViewTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of assignCompetence method, of class ActivityView.
     */
    @Test
    public void testAssignCompetence() {
        System.out.println("assignCompetence");
        int id = 1;
        String description = "Problem solving";
        boolean expResult = true;
        boolean result = act.assignCompetence(id, description);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCompetence method, of class ActivityView.
     */
    @Test
    public void testRemoveCompetence() {
        System.out.println("removeCompetence");
        int id = 1;
        String description = "";
        ActivityView instance = new ActivityView();
        boolean expResult = false;
        boolean result = instance.removeCompetence(id, description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
