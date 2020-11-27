/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;
import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.Area;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prgne
 */
public class DatabaseTest {
    private Connection con;
    private final String url="jdbc:postgresql://localhost/SoftwareEngineering";
    private final String user="manuel";
    private final String pwd="admin";
    private Activity activity;
    public DatabaseTest(){
        try {
            con=DriverManager.getConnection(url,user,pwd);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        activity.setArea(new Area("area","luogo geografico"));
        activity.setID(1);
        activity.setEIT(45);
        activity.setInterruptible(true);
        activity.setTipology("ambito");
        activity.setWeekNumber(2);
        activity.setWorkspaceNotes("notes");
    }
    @Test
    public void testGetAllDatabaseInstances(){
        Activity[] liste= Activity.getAllDatabaseInstances();
        assertEquals(liste[0],activity);
    }
    @Test
    public void testGetInstancesWithWeekNumber(){
    Activity[] liste= Activity.getInstancesWithWeekNumber(2);
        assertEquals(liste[0],activity);
    }
    
}
