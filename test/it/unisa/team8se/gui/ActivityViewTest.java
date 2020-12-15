/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.Competence;
import it.unisa.team8se.models.Material;
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
    private static Activity activity;
    private static Competence competence;
    private static Material material;

    public ActivityViewTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        act = new ActivityView(-1);
        activity = new Activity(1);
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
    public void testAssignCompetence1() {
        System.out.println("assignCompetence1");
        competence = new Competence(1, "Problem solving");
        boolean expResult = true;
        boolean result = act.assignCompetence(activity, competence);
        assertEquals(expResult, result);
    }

    /**
     * Wrong test of assignCompetence method, of class ActivityView.
     */
    @Test
    public void testAssignCompetence2() {
        System.out.println("assignCompetence2");
        competence = new Competence(2, "");
        boolean expResult = false;
        boolean result = act.assignCompetence(activity, competence);
        assertEquals(expResult, result);
    }

    /**
     * Wrong test of assignCompetence method, of class ActivityView.
     */
    @Test
    public void testAssignCompetence3() {
        System.out.println("assignCompetence3");
        competence = new Competence(3, "Lateral thinking");
        boolean expResult = false;
        boolean result = act.assignCompetence(activity, competence);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCompetence method, of class ActivityView.
     */
    @Test
    public void testRemoveCompetence1() {
        System.out.println("removeCompetence1");
        String description = "Lateral thinking";
        boolean expResult = true;
        boolean result = act.removeCompetence(activity, description);
        assertEquals(expResult, result);

    }

    /**
     * Wrong test of removeCompetence method, of class ActivityView.
     */
    @Test
    public void testRemoveCompetence2() {
        System.out.println("removeCompetence2");
        String description = "Problem solving";
        boolean expResult = false;
        boolean result = act.removeCompetence(activity, description);
        assertEquals(expResult, result);

    }

    /**
     * Wrong test of removeCompetence method, of class ActivityView.
     */
    @Test
    public void testRemoveCompetence3() {
        System.out.println("removeCompetence3");
        String description = "";
        boolean expResult = false;
        boolean result = act.removeCompetence(activity, description);
        assertEquals(expResult, result);

    }

    /**
     * Test of assignMaterial method, of class ActivityView.
     */
    @Test
    public void testAssignMaterial1() {
        System.out.println("assignMaterial1");
        material = new Material("trapano", null);
        boolean expResult = true;
        boolean result = act.assignMaterial(activity, material);
        assertEquals(expResult, result);

    }

    /**
     * Wrong test of assignMaterial method, of class ActivityView.
     */
    @Test
    public void testAssignMaterial2() {
        System.out.println("assignMaterial2");
        material = new Material("", null);
        boolean expResult = false;
        boolean result = act.assignMaterial(activity, material);
        assertEquals(expResult, result);

    }

    /**
     * Wrong test of assignMaterial method, of class ActivityView.
     */
    @Test
    public void testAssignMaterial3() {
        System.out.println("assignMaterial3");
        String nome = "fresatrice";
        boolean expResult = false;
        boolean result = act.assignMaterial(activity, material);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeMaterial method, of class ActivityView.
     */
    @Test
    public void testRemoveMaterial1() {
        System.out.println("removeMaterial1");
        String nome = "fresatrice";
        boolean expResult = true;
        boolean result = act.removeMaterial(activity, nome);
        assertEquals(expResult, result);

    }

    /**
     * Wrong Test of removeMaterial method, of class ActivityView.
     */
    @Test
    public void testRemoveMaterial2() {
        System.out.println("removeMaterial2");
        String nome = "";
        boolean expResult = false;
        boolean result = act.removeMaterial(activity, nome);
        assertEquals(expResult, result);

    }

}
