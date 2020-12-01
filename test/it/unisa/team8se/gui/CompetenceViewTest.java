package it.unisa.team8se.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import it.unisa.team8se.gui.CompetenceView;
import it.unisa.team8se.models.Maintainer;
import javax.swing.DefaultListModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gerar
 */
public class CompetenceViewTest {
    
    public CompetenceViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initListModel method, of class CompetenceView.
     */
    @Test
    public void testInitListModel() {
        System.out.println("initListModel");
        CompetenceView instance = new CompetenceView();
        instance.initListModel();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.listModel instanceof DefaultListModel);
    }

    /**
     * Test of refreshUsers method, of class CompetenceView.
     */
    @Test
    public void testRefreshUsers() {
        System.out.println("refreshUsers");
        CompetenceView instance = new CompetenceView();
        boolean expResult = false;
        boolean result = instance.refreshUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refreshCompetences method, of class CompetenceView.
     */
    @Test
    public void testRefreshCompetences() {
        System.out.println("refreshCompetences");
        String username = "";
        CompetenceView instance = new CompetenceView();
        boolean expResult = false;
        boolean result = instance.refreshCompetences(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assign method, of class CompetenceView.
     */
    @Test
    public void testAssign() {
        System.out.println("assign");
        Maintainer maintainer = null;
        String competenceDesc = "";
        CompetenceView instance = new CompetenceView();
        boolean expResult = false;
        boolean result = instance.assign(maintainer, competenceDesc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class CompetenceView.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        String username = "";
        String competence = "";
        CompetenceView instance = new CompetenceView();
        boolean expResult = false;
        boolean result = instance.remove(username, competence);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CompetenceView.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CompetenceView.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
