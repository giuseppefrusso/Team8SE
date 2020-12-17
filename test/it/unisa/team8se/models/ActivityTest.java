/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prgne
 */
public class ActivityTest {

    private Activity instance;
    private int instanceDefaultID = 10000000;
    
    private static Connection con;
    private static Statement stm;

    public ActivityTest() {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }

        con = DatabaseContext.getConnection();
        con.setAutoCommit(false);
        stm = con.createStatement();
        removeForeignKey();
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
        con.setAutoCommit(true);
        DatabaseContext.closeConnection();

    }

    @Before
    public void setUp() {
        instance = new Activity(instanceDefaultID, new Area("carpentry", "Fisciano"), "Electrical", 2, 3, "Notes", "Revisionare", false, new Timestamp(201367896));
    }

    @After
    public void tearDown() {
        try {
            con.rollback();
            instance = null;
        } catch (SQLException ex) {
            Logger.getLogger(ActivityTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getID method, of class Activity.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        int result = instance.getID();
        assertEquals(instanceDefaultID, result);
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
        assertEquals(Tipology, instance.getTipology());
    }

    /**
     * Test of setEIT method, of class Activity.
     */
    @Test
    public void testSetEIT() {
        System.out.println("setEIT");
        int EIT = 0;
        instance.setEIT(EIT);
        assertEquals(EIT, instance.getEIT());
    }

    /**
     * Test of setWeekNumber method, of class Activity.
     */
    @Test
    public void testSetWeekNumber() {
        System.out.println("setWeekNumber");
        int WeekNumber = 0;
        instance.setWeekNumber(WeekNumber);
        assertEquals(WeekNumber, instance.getWeekNumber());
    }

    /**
     * Test of setInterruptible method, of class Activity.
     */
    @Test
    public void testSetInterruptible() {
        System.out.println("setInterruptible");
        boolean Interruptible = false;
        instance.setInterruptible(Interruptible);
        assertEquals(Interruptible, instance.isInterruptible());
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
        assertEquals(datetime, instance.getDatetime());
    }

    /**
     * Test of getArea method, of class Activity.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        Area expResult = new Area("carpentry", "Fisciano");
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
        assertEquals(WorkspaceNotes, instance.getWorkspaceNotes());
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
        assertEquals(InterventionDescription, instance.getInterventionDescription());
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
    private void deleteAllDatabaseInstances() throws SQLException {
        String query = "Delete from attivita_pianificata";
        stm.executeUpdate(query);
    }

    private void addActivityToDatabase(Activity a) throws SQLException {
        String query = "Insert into attivita_pianificata (id,smp,area,luogo_geografico,planner,maintainer,ambito,"
                + "data_e_ora,week_number, eta, workspace_notes, interrompibile, descrizione_intervento) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = DatabaseContext.getPreparedStatement(query);

        ps.setInt(1, a.getID());
        ps.setString(2, null);
        ps.setString(3, a.getArea().getSector());
        ps.setString(4, a.getArea().getLocation());
        ps.setString(5, null);
        ps.setString(6, "maintainer_prova");
        ps.setString(7, a.getTipology());
        ps.setTimestamp(8, a.getDatetime());
        ps.setInt(9, a.getWeekNumber());
        ps.setInt(10, a.getEIT());
        ps.setString(11, a.getWorkspaceNotes());
        ps.setBoolean(12, a.isInterruptible());
        ps.setString(13, a.getInterventionDescription());

        ps.executeUpdate();
    }

    private static void addForeignKey() throws SQLException {
        String query1 = "Insert into area values ('luogo_prova','settore_prova')";
        String query2 = "Insert into planner values ('planner_prova','cos','nick','ola')";
        String query3 = "Insert into smp values (?, ?)";
        String query4 = "Insert into maintainer values ('maintainer_prova','cit','ro','nell')";
        stm.executeUpdate(query1);
        stm.executeUpdate(query2);

        PreparedStatement ps = DatabaseContext.getPreparedStatement(query3);
        ps.setString(1, "documento_prova");
        ps.setBytes(2, new byte[]{10, 10, 10, 10, 10}); // documento dummy
        ps.executeUpdate();

        stm.executeUpdate(query4);
    }

    private static void removeForeignKey() throws SQLException {
        String query1 = "Delete from area where (nome,luogo_geografico)=('luogo_prova','settore_prova')";
        String query2 = "Delete from planner where username='planner_prova'";
        String query3 = "Delete from smp where nome='documento_prova'";
        String query4 = "Delete from maintainer where username='maintainer_prova'";
        stm.executeUpdate(query1);
        stm.executeUpdate(query2);
        stm.executeUpdate(query3);
        stm.executeUpdate(query4);
    }

    /**
     * Test of getInstanceWithPK method, of class Activity.
     */
    @Test
    public void testGetInstanceWithPK() throws SQLException {
        System.out.println("getInstanceWithPK");

        Activity expResult = instance;        
        
        addForeignKey();
        addActivityToDatabase(instance);
        Activity result = Activity.getInstanceWithPK(instance.getID());
        assertEquals(expResult, result);
    }

    /**
     * Test of getInstancesAssignedToMaintainer method, of class Activity.
     */
    @Test
    public void testGetInstancesAssignedToMaintainer() throws SQLException {
        System.out.println("getInstancesAssignedToMaintainer");
        Maintainer m = null;

        addForeignKey();
        addActivityToDatabase(instance);
        
        try {
            m = Maintainer.getInstanceWithPK("maintainer_prova");
        } catch (SQLException ex) {
            Logger.getLogger(ActivityTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail();
        }
        Activity[] expResult = {instance};
        Activity[] result = Activity.getInstancesAssignedToMaintainer(m);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getInstancesWithWeekNumber method, of class Activity.
     */
    @Test
    public void testGetInstancesWithWeekNumber() throws SQLException {
        System.out.println("getInstancesWithWeekNumber");
        int weekNumber = 3;
        Activity a = instance;
        
        Activity[] expResult = {a};
        
        addForeignKey();
        addActivityToDatabase(a);
        
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

        String expResult = "Activity{" + "ID=" + instance.getID() + ", Area=" + instance.getArea() + ", Tipology=" + instance.getTipology()
                + ", EIT=" + instance.getEIT() + ", WeekNumber=" + instance.getWeekNumber() + ", WorkspaceNotes="
                + instance.getWorkspaceNotes() + ", InterventionDescription=" + instance.getInterventionDescription() + ", Interruptible="
                + instance.isInterruptible() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFromResultSet method, of class Activity.
     */
    @Test(expected = NullPointerException.class)
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
    public void testUpdateWorkspaceNotesInDatabase() throws SQLException {
        System.out.println("updateWorkspaceNotesInDatabase");
        instance.setWorkspaceNotes("notes");
        
        addForeignKey();
        addActivityToDatabase(instance);
        instance.updateWorkspaceNotesInDatabase();
        String result = instance.getWorkspaceNotes();
        assertEquals(result, "notes");
    }

    /**
     * Test of updateSMPInDatabase method, of class Activity.
     */
    @Test
    public void testUpdateSMPInDatabase() throws Exception {
        System.out.println("updateSMPInDatabase");
        SMP smp = new SMP();

        //Activity instance = new Activity();
        instance.setSmp(smp);
        boolean expResult = false;
        boolean result = instance.updateSMPInDatabase();
        assertEquals(expResult, result);
    }

    /**
     * Test of assignActivityToMaintainer method, of class Activity.
     */
    @Test
    public void testAssignActivityToMaintainer() throws SQLException {
        System.out.println("assignActivityToMaintainer");
        boolean expResult = true;
        
        addForeignKey();
        
        Maintainer m = Maintainer.getInstanceWithPK("maintainer_prova");
        
        try {
            addActivityToDatabase(instance);
        } catch (SQLException ex) {
            Logger.getLogger(ActivityTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean result = instance.assignActivityToMaintainer(m);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Activity.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Activity instance1 = new Activity(instanceDefaultID, new Area("Fisciano", "Carpentry"), "Electrical", 2, 3, "Revisionare", "Notes", false, new Timestamp(201367896));
        int result = instance.hashCode();
        assertEquals(instance1.hashCode(), result);
    }

    /**
     * Test of equals method, of class Activity.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Activity instance1 = new Activity(instanceDefaultID, new Area("Fisciano", "Carpentry"), "Electrical", 2, 3, "Revisionare", "Notes", false, new Timestamp(201367896));
        boolean result = instance.equals(instance1);
        assertEquals(true, result);
    }

}
