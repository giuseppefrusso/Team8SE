/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.enumerations.DepartmentFlag;
import it.unisa.team8se.enumerations.MaintainerFlag;
import it.unisa.team8se.enumerations.TicketState;
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
public class TicketTest {
    
    Ticket instance;
    
    public TicketTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Ticket();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getDepartmentFlag method, of class Ticket.
     */
    @Test
    public void testGetDepartmentFlag() {
        System.out.println("getDepartmentFlag");
        DepartmentFlag expResult = null;
        DepartmentFlag result = instance.getDepartmentFlag();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaintainerFlag method, of class Ticket.
     */
    @Test
    public void testGetMaintainerFlag() {
        System.out.println("getMaintainerFlag");
        MaintainerFlag expResult = null;
        MaintainerFlag result = instance.getMaintainerFlag();
        assertEquals(expResult, result);
    }

    /**
     * Test of getState method, of class Ticket.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        TicketState expResult = null;
        TicketState result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDepartmentFlag method, of class Ticket.
     */
    @Test
    public void testSetDepartmentFlag() {
        System.out.println("setDepartmentFlag");
        DepartmentFlag DepartmentFlag = null;
        instance.setDepartmentFlag(DepartmentFlag);
        assertEquals(DepartmentFlag,instance.getDepartmentFlag());
    }

    /**
     * Test of setMaintainerFlag method, of class Ticket.
     */
    @Test
    public void testSetMaintainerFlag() {
        System.out.println("setMaintainerFlag");
        MaintainerFlag MaintainerFlag = null;
        instance.setMaintainerFlag(MaintainerFlag);
        assertEquals(MaintainerFlag,instance.getMaintainerFlag());
    }

    /**
     * Test of setState method, of class Ticket.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        TicketState State = null;
        instance.setState(State);
        assertEquals(State,instance.getState());
    }
    
}
