/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.ResultSet;
import java.time.Instant;
import java.util.Random;
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
public class EWOTest {

    EWO instance;
    public static Connection con;
    private static Statement stm;

    public EWOTest() {
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
        addForeignKey();
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
        con.rollback();
        con.setAutoCommit(true);
        DatabaseContext.closeConnection();
    }

    @Before
    public void setUp() {
        instance = new EWO();
    }

    @After
    public void tearDown() {
        try {
            con.rollback();
            instance = null;
        } catch (SQLException ex) {
            Logger.getLogger(EWOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testGetTicket() {
        System.out.println("getTicket");
        Ticket expResult = null;
        Ticket result = instance.getTicket();
        assertEquals(expResult, result);
    }

    /*
    private void deleteAllDatabaseInstances() throws SQLException {
        String query = "Delete from ewo";
        stm.executeUpdate(query);
    }*/

    private void addEWOToDatabase(EWO e) throws SQLException {
        String query = "Insert into ewo values(?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "'ricevuto','letto','in corso')";

        PreparedStatement ps = DatabaseContext.getPreparedStatement(query);

        ps.setInt(1, e.getID());
        ps.setString(2, null);
        ps.setString(3, e.getArea().getSector());
        ps.setString(4, e.getArea().getLocation());
        ps.setString(5, null);
        ps.setString(6, null);
        ps.setString(7, e.getTipology());
        ps.setTimestamp(8, e.getDatetime());
        ps.setInt(9, e.getWeekNumber());
        ps.setInt(10, e.getEIT());
        ps.setString(11, e.getWorkspaceNotes());
        ps.setBoolean(12, e.isInterruptible());
        ps.setString(13, e.getInterventionDescription());

        ps.executeUpdate();
    }

    private static void addForeignKey() throws SQLException {
        String query1 = "Insert into area values ('luogo_prova','settore_prova')";
        String query2 = "Insert into planner values ('user_prova','cos','nick','ola')";
        String query3 = "Insert into smp values (?, ?)";
        String query4 = "Insert into maintainer values ('Ale','cit','ro','nell')";
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
        String query2 = "Delete from planner where username='user_prova'";
        String query3 = "Delete from smp where nome='documento_prova'";
        String query4 = "Delete from maintainer where username='Ale'";
        stm.executeUpdate(query1);
        stm.executeUpdate(query2);
        stm.executeUpdate(query3);
        stm.executeUpdate(query4);
    }

    /**
     * Test of getInstanceWithPK method, of class EWO.
     */
    @Test
    public void testGetInstanceWithPK() throws SQLException {
        System.out.println("getInstanceWithPK");
        int id = new Random().nextInt();

        EWO expResult = new EWO();
        expResult.setID(id);
        expResult.setArea(new Area("carpentry", "Fisciano"));
        expResult.setTipology("carpentry");
        expResult.setDatetime(Timestamp.from(Instant.now()));
        expResult.setWeekNumber(30);

        addEWOToDatabase(expResult);
        EWO result = EWO.getInstanceWithPK(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInstancesWithWeekNumber method, of class EWO.
     */
    @Test
    public void testGetInstancesWithWeekNumber() throws SQLException {
        System.out.println("getInstancesWithWeekNumber");
        int weekNumber = 25;
        EWO e = EWO.getInstanceWithPK(1);
        e.setID(new Random().nextInt());
        e.setWeekNumber(weekNumber);

        addEWOToDatabase(e);

        EWO[] expResult = {e};
        EWO[] result = EWO.getInstancesWithWeekNumber(weekNumber);

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getFromResultSet method, of class EWO.
     */
    @Test(expected = NullPointerException.class)
    public void testGetFromResultSet() throws Exception {
        System.out.println("getFromResultSet");
        ResultSet rs = null;
        EWO instance = new EWO();
        instance.getFromResultSet(rs);
    }

    /**
     * Test of existsInDatabase method, of class EWO.
     */
    @Test
    public void testExistsInDatabase() {
        System.out.println("existsInDatabase");
        EWO instance = new EWO();
        boolean expResult = false;
        boolean result = instance.existsInDatabase();
        assertEquals(expResult, result);
    }

}
