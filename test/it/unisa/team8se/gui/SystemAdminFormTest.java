/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    }
}
