/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author giuse
 */
public class SystemAdminFormTest {
    private SystemAdminForm form;
    
    public SystemAdminFormTest() {
        
    }
    
    @Before
    public void setUp() {
        form = new SystemAdminForm();
    }
    
    @After
    public void tearDown() {
        form = null;
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
    public void testContainsUsername() {
        System.out.println("containsUsername");
        String username = "";
        SystemAdminForm instance = new SystemAdminForm();
        boolean expResult = false;
        boolean result = instance.containsUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertUser method, of class SystemAdminForm.
     */
    @Test
    public void testInsertUser() {
        System.out.println("insertUser");
        String surname = "";
        String name = "";
        String username = "Aug";
        String password = "";
        String role = "";
        SystemAdminForm instance = new SystemAdminForm();
        boolean expResult = false;
        boolean result = instance.insertUser(surname, name, username, password, role);
        assertEquals(expResult, result);
    }

    /**
     * Test of modifyUser method, of class SystemAdminForm.
     */
    @Test
    public void testModifyUser() {
        System.out.println("modifyUser");
        String newValue = "Paco";
        int selectedRow = 0;
        int selectedColumn = 2;
        SystemAdminForm instance = new SystemAdminForm();
        boolean expResult = false;
        boolean result = instance.modifyUser(newValue, selectedRow, selectedColumn);
        assertEquals(expResult, result);
    }
}
