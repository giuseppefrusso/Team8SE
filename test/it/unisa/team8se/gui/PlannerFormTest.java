/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.models.Planner;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @Before
    public void setUp() {
        try {
            form = new PlannerForm(-1);
            form.getConnection().setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(PlannerFormTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        try {
            form.getConnection().rollback();
            form.getConnection().setAutoCommit(true);
            form.closeConnection();
            form=null;
        } catch (SQLException ex) {
            Logger.getLogger(PlannerFormTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
