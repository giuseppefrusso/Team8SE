/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.ActivityTest;
import it.unisa.team8se.models.Area;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
 * @author gerar
 */
public class ActivityManagerTest {

    private Activity instance;
    private static Connection con;
    private static Statement stm;
    private static ActivityManager am;

    public ActivityManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
            con = DatabaseContext.getConnection();
            con.setAutoCommit(false);
        }
        stm = con.createStatement();
        addForeignKey();
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
        con.setAutoCommit(true);
        DatabaseContext.closeConnection();

    }

    @Before
    public void setUp() {
        am = new ActivityManager();
        instance = new Activity(3, new Area("carpentry", "Fisciano"), "Electrical", 2, 3, "Notes", "Revisionare", false, new Timestamp(201367896));
    }

    @After
    public void tearDown() {
        try {
            con.rollback();
            instance = null;
            am = null;
        } catch (SQLException ex) {
            Logger.getLogger(ActivityTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void addForeignKey() throws SQLException {
        String query1 = "Insert into area values('Fisciano','Carpentry')";
        String query2 = "Insert into planner values ('Manu','cos','nick','ola')";
        String query3 = "Insert into smp values ('doc','pdf')";
        String query4 = "Insert into maintainer values ('Ale','cit','ro','nell')";
        stm.executeUpdate(query1);
        stm.executeUpdate(query2);
        stm.executeUpdate(query3);
        stm.executeUpdate(query4);
    }

    /**
     * Test of refreshActivities method, of class ActivityManager.
     */
    @Test
    public void testRefreshActivities() {
        System.out.println("refreshActivities");
        boolean expResult = true;
        boolean result = am.refreshActivities();
        assertEquals(expResult, result);

    }

    /**
     * Test of addActivity method, of class ActivityManager.
     */
    @Test
    public void testAddActivity() {
        System.out.println("addActivity");
        boolean expResult = true;
        boolean result = am.addActivity(instance);
        assertEquals(expResult, result);

    }

    /**
     * Test of modifyActivity method, of class ActivityManager.
     */
    @Test
    public void testModifyActivity() {
        System.out.println("modifyActivity");
        int idActivity = 0;
        Object newValue = null;
        String field = "";
        boolean expResult = false;
        boolean result = am.modifyActivity(idActivity, newValue, field);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeActivity method, of class ActivityManager.
     */
    @Test
    public void testRemoveActivity() {
        System.out.println("removeActivity");
        int idActivity = 0;
        boolean expResult = false;
        boolean result = am.removeActivity(idActivity);
        assertEquals(expResult, result);

    }



}
