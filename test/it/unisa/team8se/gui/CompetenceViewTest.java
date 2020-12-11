package it.unisa.team8se.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import it.unisa.team8se.models.Maintainer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author gerar
 */
public class CompetenceViewTest {
    
    private static CompetenceView form;
    private static Connection connection;
    
    public CompetenceViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            form = new CompetenceView();
            connection = form.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(CompetenceViewTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        try {
            connection.setAutoCommit(true);
            form.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CompetenceViewTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(CompetenceViewTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of initListModel method, of class CompetenceView.
     */
    @Test
    public void testInitListModel() {
        System.out.println("initListModel");
        form.initListModel();
        assertTrue(form.listModel instanceof DefaultListModel);
    }

    /**
     * Test of refreshUsers method, of class CompetenceView.
     */
    @Test
    public void testRefreshUsers() {
        System.out.println("refreshUsers");
        boolean expResult = true;
        boolean result = form.refreshUsers();
        assertEquals(expResult, result);
    }

    /**
     * Test of refreshCompetences method, of class CompetenceView.
     */
    @Test
    public void testRefreshCompetences() {
        System.out.println("refreshCompetences");
        String username = "Aug";
        boolean expResult = true;
        boolean result = form.refreshCompetences(username);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of wrong execution of refreshCompetences method, of class CompetenceView.
     */
    @Test
    public void testRefreshCompetencesWrong() {
        System.out.println("wrong execution of refreshCompetences");
        String username = "noMaintainer";
        boolean expResult = false;
        boolean result = form.refreshCompetences(username);
        assertEquals(expResult, result);
    }

    /**
     * Wrong test of assign method, of class CompetenceView.
     */
    @Test
    public void testAssign1() {
        System.out.println("assign1");
        Maintainer maintainer = new Maintainer("Adami", "Aureliano", "Aug", "procopio12");
        String competenceDesc = "Problem solving";
        boolean expResult = false;
        boolean result = form.assign(maintainer, competenceDesc);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of assign method, of class CompetenceView.
     */
    @Test
    public void testAssign2() {
        System.out.println("assign2");
        Maintainer maintainer = new Maintainer("Anacleti", "Alberto", "Spadino", "sinti90");
        String competenceDesc = "Lateral thinking";
        boolean expResult = true;
        boolean result = form.assign(maintainer, competenceDesc);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class CompetenceView.
     */
    @Test
    public void testRemove1() {
        System.out.println("remove1");
        String username = "Aug";
        String competence = "Problem solving";
        boolean expResult = true;
        boolean result = form.remove(username, competence);
        assertEquals(expResult, result);
    }
    
    /**
     * Wrong test of remove method, of class CompetenceView.
     */
    @Test
    public void testRemove2() {
        System.out.println("remove2");
        String username = "";
        String competence = "";
        boolean expResult = false;
        boolean result = form.remove(username, competence);
        assertEquals(expResult, result);
    }    
}
