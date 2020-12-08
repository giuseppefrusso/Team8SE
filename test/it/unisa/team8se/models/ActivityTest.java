/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.LinkedList;
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
public class ActivityTest {
    Activity instance;
    public ActivityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance= new Activity(1,new Area("Fisciano","Carpentry"),"Electrical",2,3,"Revisionare","Notes",false,new Timestamp(201367896)); 
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getID method, of class Activity.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        int result = instance.getID();
        assertEquals(1, result);
    }

    /**
     * Test of setID method, of class Activity.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int ID = 0;
        instance.setID(ID);
        assertEquals(ID, instance.getID());
    }

    /**
     * Test of setArea method, of class Activity.
     */
    @Test
    public void testSetArea() {
        System.out.println("setArea");
        Area Area = null;
        instance.setArea(Area);
        assertEquals(Area, instance.getArea());
    }

    /**
     * Test of setTipology method, of class Activity.
     */
    @Test
    public void testSetTipology() {
        System.out.println("setTipology");
        String Tipology = "";
        Activity instance = new Activity();
        instance.setTipology(Tipology);
    }

    /**
     * Test of setEIT method, of class Activity.
     */
    @Test
    public void testSetEIT() {
        System.out.println("setEIT");
        int EIT = 0;
        Activity instance = new Activity();
        instance.setEIT(EIT);
    }

    /**
     * Test of setWeekNumber method, of class Activity.
     */
    @Test
    public void testSetWeekNumber() {
        System.out.println("setWeekNumber");
        int WeekNumber = 0;
        Activity instance = new Activity();
        instance.setWeekNumber(WeekNumber);
    }

    /**
     * Test of setInterruptible method, of class Activity.
     */
    @Test
    public void testSetInterruptible() {
        System.out.println("setInterruptible");
        boolean Interruptible = false;
        Activity instance = new Activity();
        instance.setInterruptible(Interruptible);
    }

    /**
     * Test of getDatetime method, of class Activity.
     */
    @Test
    public void testGetDatetime() {
        System.out.println("getDatetime");
        Timestamp result = instance.getDatetime();
        assertEquals(new Timestamp(201367896), result);
    }

    /**
     * Test of setDatetime method, of class Activity.
     */
    @Test
    public void testSetDatetime() {
        System.out.println("setDatetime");
        Timestamp datetime = null;
        Activity instance = new Activity();
        instance.setDatetime(datetime);
    }

    /**
     * Test of getArea method, of class Activity.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        Area expResult = new Area("Fisciano", "Carpentry");
        Area result = instance.getArea();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTipology method, of class Activity.
     */
    @Test
    public void testGetTipology() {
        System.out.println("getTipology");
        Activity instance = new Activity();
        String expResult = "";
        String result = instance.getTipology();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEIT method, of class Activity.
     */
    @Test
    public void testGetEIT() {
        System.out.println("getEIT");
        Activity instance = new Activity();
        int expResult = 0;
        int result = instance.getEIT();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeekNumber method, of class Activity.
     */
    @Test
    public void testGetWeekNumber() {
        System.out.println("getWeekNumber");
        Activity instance = new Activity();
        int expResult = 0;
        int result = instance.getWeekNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of isInterruptible method, of class Activity.
     */
    @Test
    public void testIsInterruptible() {
        System.out.println("isInterruptible");
        Activity instance = new Activity();
        boolean expResult = false;
        boolean result = instance.isInterruptible();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWorkspaceNotes method, of class Activity.
     */
    @Test
    public void testGetWorkspaceNotes() {
        System.out.println("getWorkspaceNotes");
        Activity instance = new Activity();
        String expResult = "";
        String result = instance.getWorkspaceNotes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWorkspaceNotes method, of class Activity.
     */
    @Test
    public void testSetWorkspaceNotes() {
        System.out.println("setWorkspaceNotes");
        String WorkspaceNotes = "";
        Activity instance = new Activity();
        instance.setWorkspaceNotes(WorkspaceNotes);
    }

    /**
     * Test of getInterventionDescription method, of class Activity.
     */
    @Test
    public void testGetInterventionDescription() {
        System.out.println("getInterventionDescription");
        Activity instance = new Activity();
        String expResult = "";
        String result = instance.getInterventionDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInterventionDescription method, of class Activity.
     */
    @Test
    public void testSetInterventionDescription() {
        System.out.println("setInterventionDescription");
        String InterventionDescription = "";
        Activity instance = new Activity();
        instance.setInterventionDescription(InterventionDescription);
    }

    /**
     * Test of getRequiredCompetencies method, of class Activity.
     */
    @Test
    public void testGetRequiredCompetencies() {
        System.out.println("getRequiredCompetencies");
        LinkedList<Competence> expResult = new LinkedList<>();
        LinkedList<Competence> result = instance.getRequiredCompetencies();
        assertEquals(expResult, result);
    }

    /**
     * Test of addRequiredCompetence method, of class Activity.
     */
    @Test
    public void testAddRequiredCompetence() {
        System.out.println("addRequiredCompetence");
        Competence c = new Competence(1, "Testing");
        instance.addRequiredCompetence(c);
        LinkedList<Competence> expResult = new LinkedList<>();
        expResult.add(c);
        assertEquals(true, instance.getRequiredCompetencies().equals(expResult));
    }

    /**
     * Test of getAllDatabaseInstances method, of class Activity.
     */
    @Test
    public void testGetAllDatabaseInstances() {
        System.out.println("getAllDatabaseInstances");
        Activity[] expResult = null;
        Activity[] result = Activity.getAllDatabaseInstances();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getInstanceWithPK method, of class Activity.
     */
    @Test
    public void testGetInstanceWithPK() {
        System.out.println("getInstanceWithPK");
        int ID = 0;
        Activity expResult = null;
        Activity result = Activity.getInstanceWithPK(ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInstancesAssignedToMaintainer method, of class Activity.
     */
    @Test
    public void testGetInstancesAssignedToMaintainer() {
        System.out.println("getInstancesAssignedToMaintainer");
        Maintainer m = null;
        Activity[] expResult = null;
        Activity[] result = Activity.getInstancesAssignedToMaintainer(m);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getInstancesWithWeekNumber method, of class Activity.
     */
    @Test
    public void testGetInstancesWithWeekNumber() {
        System.out.println("getInstancesWithWeekNumber");
        int weekNumber = 0;
        Activity[] expResult = null;
        Activity[] result = Activity.getInstancesWithWeekNumber(weekNumber);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getRequiredCompetenciesFromDatabase method, of class Activity.
     */
    @Test
    public void testGetRequiredCompetenciesFromDatabase() {
        System.out.println("getRequiredCompetenciesFromDatabase");
        Activity instance = new Activity();
        instance.getRequiredCompetenciesFromDatabase();
    }

    /**
     * Test of toString method, of class Activity.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Activity instance = new Activity();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of saveToDatabase method, of class Activity.
     */
    @Test
    public void testSaveToDatabase() {
        System.out.println("saveToDatabase");
        Activity instance = new Activity();
        instance.saveToDatabase();
    }

    /**
     * Test of getFromResultSet method, of class Activity.
     */
    @Test
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        Activity instance = new Activity();
        instance.getFromResultSet(rs);
    }

    /**
     * Test of existsInDatabase method, of class Activity.
     */
    @Test
    public void testExistsInDatabase() {
        System.out.println("existsInDatabase");
        Activity instance = new Activity();
        boolean expResult = false;
        boolean result = instance.existsInDatabase();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateInterventionDescInDatabase method, of class Activity.
     */
    @Test
    public void testUpdateInterventionDescInDatabase() {
        System.out.println("updateInterventionDescInDatabase");
        Activity instance = new Activity();
        instance.updateInterventionDescInDatabase();
    }

    /**
     * Test of updateWorkspaceNotesInDatabase method, of class Activity.
     */
    @Test
    public void testUpdateWorkspaceNotesInDatabase() {
        System.out.println("updateWorkspaceNotesInDatabase");
        Activity instance = new Activity();
        instance.updateWorkspaceNotesInDatabase();
    }

    /**
     * Test of updateSMPInDatabase method, of class Activity.
     */
    @Test
    public void testUpdateSMPInDatabase() throws Exception {
        System.out.println("updateSMPInDatabase");
        SMP smp = null;
        Activity instance = new Activity();
        boolean expResult = false;
        boolean result = instance.updateSMPInDatabase(smp);
        assertEquals(expResult, result);
    }

    /**
     * Test of openSMPFromDatabase method, of class Activity.
     */
    @Test
    public void testOpenSMPFromDatabase() throws Exception {
        System.out.println("openSMPFromDatabase");
        Activity instance = new Activity();
        boolean expResult = false;
        boolean result = instance.openSMPFromDatabase();
        assertEquals(expResult, result);
    }

    /**
     * Test of assignActivityToMaintainer method, of class Activity.
     */
    @Test
    public void testAssignActivityToMaintainer() throws Exception {
        System.out.println("assignActivityToMaintainer");
        Maintainer m = null;
        Activity instance = new Activity();
        instance.assignActivityToMaintainer(m);
    }

    /**
     * Test of hashCode method, of class Activity.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Activity instance1 = new Activity(1,new Area("Fisciano","Carpentry"),"Electrical",2,3,"Revisionare","Notes",false,new Timestamp(201367896));
        int result = instance.hashCode();
        assertEquals(instance1.hashCode(), result);
    }

    /**
     * Test of equals method, of class Activity.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Activity instance1 = new Activity(1,new Area("Fisciano","Carpentry"),"Electrical",2,3,"Revisionare","Notes",false,new Timestamp(201367896));
        boolean result = instance.equals(instance1);
        assertEquals(true, result);
    }
    
}
