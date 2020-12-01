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

    /*@Test
    public void testInsertUser1() {
        form.insertUser("Landino", "Gerardo", "gerry", "xxx", "System Admin");
        assertTrue(form.containsUsername("gerry"));
    }
    
    @Test
    public void testInsertUser2() {
        form.insertUser("Landino", "Gerardo", "gerry", "xxx", "System Admin");
        form.insertUser("Landino", "Gerardo", "gerry", "xxx", "System Admin");
        assertEquals(form.tableModel.getRowCount(),1);
    }
    
    @Test
    public void testModifyUser1() {
        form.insertUser("Landino", "Gerardo", "gerry", "xxx", "System Admin");
        form.modifyUser("gerardo", 0, 2);
        assertTrue(form.containsUsername("gerardo"));
    }
    
    @Test
    public void testModifyUser2() {
        form.insertUser("Landino", "Gerardo", "gerry", "xxx", "System Admin");
        form.insertUser("Russo", "Gerardo", "gerardo", "xxx", "System Admin");
        form.modifyUser("gerardo", 0, 2);
        assertTrue(form.containsUsername("gerry"));
    }
    
    @Test
    public void testRemoveUser() {
        form.insertUser("Landino", "Gerardo", "gerry", "xxx", "System Admin");
        form.removeUser("gerry", 0);
        assertEquals(form.tableModel.getRowCount(),0);
    }*/

    /**
     * Test of refreshUsers method, of class SystemAdminForm.
     */
    @Test
    public void testRefreshUsers() {
        System.out.println("refreshUsers");
        SystemAdminForm instance = new SystemAdminForm();
        boolean expResult = false;
        boolean result = instance.refreshUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of raiseError method, of class SystemAdminForm.
     */
    @Test
    public void testRaiseError() {
        System.out.println("raiseError");
        String message = "";
        SystemAdminForm instance = new SystemAdminForm();
        instance.raiseError(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertUser method, of class SystemAdminForm.
     */
    @Test
    public void testInsertUser() {
        System.out.println("insertUser");
        String surname = "";
        String name = "";
        String username = "";
        String password = "";
        String role = "";
        SystemAdminForm instance = new SystemAdminForm();
        boolean expResult = false;
        boolean result = instance.insertUser(surname, name, username, password, role);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyUser method, of class SystemAdminForm.
     */
    @Test
    public void testModifyUser() {
        System.out.println("modifyUser");
        String newValue = "";
        int selectedRow = 0;
        int selectedColumn = 0;
        SystemAdminForm instance = new SystemAdminForm();
        boolean expResult = false;
        boolean result = instance.modifyUser(newValue, selectedRow, selectedColumn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class SystemAdminForm.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SystemAdminForm.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
