/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.Activity;
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
        System.out.println("assignCompetence");
        String description = "Problem solving";
        boolean expResult = true;
        boolean result = act.assignCompetence(this.activity, description);
        assertEquals(expResult, result);
    }

    /**
     * Wrong test of assignCompetence method, of class ActivityView.
     */
    @Test
    public void testAssignCompetence2() {
        System.out.println("assignCompetence");
        String description = "Lateral thinking";
        boolean expResult = false;
        boolean result = act.assignCompetence(this.activity, description);
        assertEquals(expResult, result);
    }

    /**
     * Wrong test of assignCompetence method, of class ActivityView.
     */
    @Test
    public void testAssignCompetence3() {
        System.out.println("assignCompetence");
        String description = "";
        boolean expResult = false;
        boolean result = act.assignCompetence(this.activity, description);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCompetence method, of class ActivityView.
     */
    @Test
    public void testRemoveCompetence() {
        System.out.println("removeCompetence");
        String description = "Lateral thinking";
        boolean expResult = true;
        boolean result = act.removeCompetence(this.activity, description);
        assertEquals(expResult, result);

    }

    /**
     * Wrong test of removeCompetence method, of class ActivityView.
     */
    @Test
    public void testRemoveCompetence2() {
        System.out.println("removeCompetence");
        String description = "Problem solving";
        boolean expResult = false;
        boolean result = act.removeCompetence(this.activity, description);
        assertEquals(expResult, result);

    }

    /**
     * Wrong test of removeCompetence method, of class ActivityView.
     */
    @Test
    public void testRemoveCompetence3() {
        System.out.println("removeCompetence");
        String description = "";
        boolean expResult = false;
        boolean result = act.removeCompetence(this.activity, description);
        assertEquals(expResult, result);

    }

    /**
     * Test of assignMaterial method, of class ActivityView.
     */
    @Test
    public void testAssignMaterial1() {
        System.out.println("assignMaterial");
        String nome = "trapano";
        boolean expResult = true;
        boolean result = act.assignMaterial(this.activity, nome);
        assertEquals(expResult, result);

    }

    /**
     * Wrong test of removeCompetence method, of class ActivityView.
     */
    @Test
    public void testAssignMaterial2() {
        System.out.println("assignMaterial");
        String nome = "";
        boolean expResult = false;
        boolean result = act.assignMaterial(this.activity, nome);
        assertEquals(expResult, result);

    }

    /**
     * Wrong test of removeCompetence method, of class ActivityView.
     */
    @Test
    public void testAssignMaterial3() {
        System.out.println("assignMaterial");
        String nome = "fresatrice";
        boolean expResult = false;
        boolean result = act.assignMaterial(this.activity, nome);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeMaterial method, of class ActivityView.
     */
    @Test
    public void testRemoveMaterial1() {
        System.out.println("removeMaterial");
        String nome = "fresatrice";
        boolean expResult = true;
        boolean result = act.removeMaterial(this.activity, nome);
        assertEquals(expResult, result);

    }

    /**
     * Wrong Test of removeMaterial method, of class ActivityView.
     */
    @Test
    public void testRemoveMaterial2() {
        System.out.println("removeMaterial");
        String nome = "";
        boolean expResult = false;
        boolean result = act.removeMaterial(this.activity, nome);
        assertEquals(expResult, result);

    }



}
