/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.models.Planner;
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
public class PlannerFormTest {
    
    private PlannerForm form;
    
    public PlannerFormTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        form = new PlannerForm();
    }
    
    @After
    public void tearDown() {
        form=null;
    }
    

    /**
     * Test of main method, of class PlannerForm.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PlannerForm.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
