/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;


import it.unisa.team8se.DatabaseContext;
import java.sql.*;
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
    private static Connection con;
    private static Statement stm;
    
    public ActivityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
         if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
            con = DatabaseContext.getConnection();
            con.setAutoCommit(false);
        }
         stm= con.createStatement();
         addForeignKey();
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        removeForeignKey();
        DatabaseContext.closeConnection();
        
    }
    
    @Before
    public void setUp() {
        instance= new Activity(1,new Area("Fisciano","Carpentry"),"Electrical",2,3,"Notes","Revisionare",false,new Timestamp(201367896)); 
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
        instance.setTipology(Tipology);
        assertEquals(Tipology,instance.getTipology());
    }

    /**
     * Test of setEIT method, of class Activity.
     */
    @Test
    public void testSetEIT() {
        System.out.println("setEIT");
        int EIT = 0;
        instance.setEIT(EIT);
        assertEquals(EIT,instance.getEIT());
    }

    /**
     * Test of setWeekNumber method, of class Activity.
     */
    @Test
    public void testSetWeekNumber() {
        System.out.println("setWeekNumber");
        int WeekNumber = 0;
        instance.setWeekNumber(WeekNumber);
        assertEquals(WeekNumber,instance.getWeekNumber());
    }

    /**
     * Test of setInterruptible method, of class Activity.
     */
    @Test
    public void testSetInterruptible() {
        System.out.println("setInterruptible");
        boolean Interruptible = false;
        instance.setInterruptible(Interruptible);
        assertEquals(Interruptible,instance.isInterruptible());
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
        instance.setDatetime(datetime);
        assertEquals(datetime,instance.getDatetime());
    }

    /**
     * Test of getArea method, of class Activity.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        Area expResult = new Area("Fisciano","Carpentry");
        Area result = instance.getArea();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTipology method, of class Activity.
     */
    @Test
    public void testGetTipology() {
        System.out.println("getTipology");
        String result = instance.getTipology();
        assertEquals("Electrical", result);
    }

    /**
     * Test of getEIT method, of class Activity.
     */
    @Test
    public void testGetEIT() {
        System.out.println("getEIT");
        int result = instance.getEIT();
        assertEquals(2, result);
    }

    /**
     * Test of getWeekNumber method, of class Activity.
     */
    @Test
    public void testGetWeekNumber() {
        System.out.println("getWeekNumber");
        int result = instance.getWeekNumber();
        assertEquals(3, result);
    }

    /**
     * Test of isInterruptible method, of class Activity.
     */
    @Test
    public void testIsInterruptible() {
        System.out.println("isInterruptible");
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
        String result = instance.getWorkspaceNotes();
        instance.setWorkspaceNotes("Notes");
        assertEquals("Notes", result);
    }

    /**
     * Test of setWorkspaceNotes method, of class Activity.
     */
    @Test
    public void testSetWorkspaceNotes() {
        System.out.println("setWorkspaceNotes");
        String WorkspaceNotes = "";
        instance.setWorkspaceNotes(WorkspaceNotes);
        assertEquals(WorkspaceNotes,instance.getWorkspaceNotes());
    }

    /**
     * Test of getInterventionDescription method, of class Activity.
     */
    @Test
    public void testGetInterventionDescription() {
        System.out.println("getInterventionDescription");
        String result = instance.getInterventionDescription();
        assertEquals("Revisionare", result);
    }

    /**
     * Test of setInterventionDescription method, of class Activity.
     */
    @Test
    public void testSetInterventionDescription() {
        System.out.println("setInterventionDescription");
        String InterventionDescription = "";
        instance.setInterventionDescription(InterventionDescription);
        assertEquals(InterventionDescription,instance.getInterventionDescription());
    }

    /**
     * Test of getRequiredCompetencies method, of class Activity.
     */
    @Test
    public void testGetRequiredCompetences() {
        System.out.println("getRequiredCompetences");
        LinkedList<Competence> expResult = new LinkedList<>();
        LinkedList<Competence> result = instance.getRequiredCompetences();
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
        assertEquals(true, instance.getRequiredCompetences().equals(expResult));
    }

    /**
     * Test of getAllDatabaseInstances method, of class Activity.
     */
    private void deleteAllDatabaseInstances() throws SQLException{
        String query= "Delete from attivita_pianificata";
        stm.executeUpdate(query);
    }
    
    private void addActivityToDatabase (Activity a) throws SQLException{
    String query = "Insert into attivita_pianificata values("+ a.getID()+",'doc','Ale','Fisciano','Carpentry','Manu','"+ a.getTipology()+"','"+ a.getDatetime()+"',"+ a.getWeekNumber()+","+ a.getEIT()+",'"+ a.getWorkspaceNotes()+"','"+ a.getInterventionDescription()+"',"+ a.isInterruptible()+")";
    stm.executeUpdate(query);
    }
    
    private static void addForeignKey() throws SQLException{
    String query1="Insert into area values('Fisciano','Carpentry')";
    String query2="Insert into planner values ('Manu','cos','nick','ola')";
    String query3="Insert into smp values ('doc','pdf')";
    String query4="Insert into maintainer values ('Ale','cit','ro','nell')";
    stm.executeUpdate(query1);
    stm.executeUpdate(query2);
    stm.executeUpdate(query3);
    stm.executeUpdate(query4);
    }
    
    private static void removeForeignKey() throws SQLException{
    String query1="Delete from area where (nome,luogo_geografico)=('Fisciano','Carpentry')";
    String query2="Delete from planner where username='Manu'";
    String query3="Delete from smp where nome='doc'";
    String query4="Delete from maintainer where username='Ale'";
    stm.executeUpdate(query1);
    stm.executeUpdate(query2);
    stm.executeUpdate(query3);
    stm.executeUpdate(query4);
    }
    
    /**
     * Test of getAllDatabaseInstances method, of class Activity.
     */
    @Test
    public void testGetAllDatabaseInstances() throws SQLException {
        System.out.println("getAllDatabaseInstances");
        deleteAllDatabaseInstances();
        Activity a= instance;
        Activity[] expResult = {a};
        addActivityToDatabase(a);
        Activity[] result = Activity.getAllDatabaseInstances();
        assertArrayEquals(expResult, result);
        con.rollback();
    }

    /**
     * Test of getInstanceWithPK method, of class Activity.
     */
    @Test
    public void testGetInstanceWithPK() throws SQLException {
        System.out.println("getInstanceWithPK");
        deleteAllDatabaseInstances();
        int ID = 1;
        Activity expResult = instance;
        addActivityToDatabase(instance);
        Activity result = Activity.getInstanceWithPK(ID);
        assertEquals(expResult, result);
        con.rollback();
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
    public void testGetRequiredCompetencesFromDatabase() throws SQLException {
        System.out.println("getRequiredCompetencesFromDatabase");
        Activity instance = new Activity();
        instance.getRequiredCompetencesFromDatabase();
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
