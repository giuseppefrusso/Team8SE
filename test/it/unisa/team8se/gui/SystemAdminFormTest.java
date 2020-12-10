/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author giuse
 */
public class SystemAdminFormTest {

    private static SystemAdminForm form;
    private static Connection connection;

    public SystemAdminFormTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        try {
            form = new SystemAdminForm();
            connection = form.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(SystemAdminFormTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        try {
            connection.setAutoCommit(true);
            form.closeConnection();
            form = null;
        } catch (SQLException ex) {
            Logger.getLogger(SystemAdminFormTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(SystemAdminFormTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testRefreshUsers() {
        System.out.println("refreshUsers");
        SystemAdminForm instance = new SystemAdminForm();
        boolean expResult = true;
        boolean result = instance.refreshUsers();
        assertEquals(expResult, result);
    }

    /**
     * Test of containsUsername method, of class SystemAdminForm.
     */
    @Test
    public void testContainsUsername1() {
        System.out.println("containsUsername");
        String username = "Aug";
        boolean expResult = true;
        boolean result = form.containsUsername(username);
        assertEquals(expResult, result);
    }
    
    /**
     * Wrong test of containsUsername method, of class SystemAdminForm.
     */
    @Test
    public void testContainsUsername2() {
        System.out.println("containsUsername2");
        String username = "";
        boolean expResult = false;
        boolean result = form.containsUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertUser method, of class SystemAdminForm.
     */
    @Test
    public void testInsertUser1() {
        System.out.println("insertUser1");
        String surname = "Russo";
        String name = "Giuseppe Felice";
        String username = "pepito";
        String password = "rondinone";
        String role = "planner";
        boolean expResult = true;
        boolean result = form.insertUser(surname, name, username, password, role);
        assertEquals(expResult, result);
    }
    
    /**
     * Wrong test of insertUser method, of class SystemAdminForm.
     */
    @Test
    public void testInsertUser2() {
        System.out.println("insertUser2");
        String surname = "";
        String name = "";
        String username = "Aug";
        String password = "";
        String role = "";
        boolean expResult = false;
        boolean result = form.insertUser(surname, name, username, password, role);
        assertEquals(expResult, result);
    }

    /**
     * Test of modifyUser method, of class SystemAdminForm.
     */
    @Test
    public void testModifyUser1() {
        System.out.println("modifyUser1");
        String newValue = "Tullio";
        int selectedRow = 0;
        int selectedColumn = 1;
        boolean expResult = true;
        boolean result = form.modifyUser(newValue, selectedRow, selectedColumn);
        assertEquals(expResult, result);
    }
    
    /**
     * Wrong test of modifyUser method, of class SystemAdminForm.
     */
    @Test
    public void testModifyUser2() {
        System.out.println("modifyUser2");
        String newValue = "Paco";
        int selectedRow = 0;
        int selectedColumn = 2;
        boolean expResult = false;
        boolean result = form.modifyUser(newValue, selectedRow, selectedColumn);
        assertEquals(expResult, result);
    }
}
