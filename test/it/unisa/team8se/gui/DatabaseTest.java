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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prgne
 */
public class DatabaseTest {
    private Connection con;
    private final String url="jdbc:postgresql://localhost/ProgettoSE";
    private final String user="postgres";
    private final String pwd="password";
    private Activity activity;
    public DatabaseTest(){

    }
    
    @Before
    public void setup(){
        try {
            con = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        activity = new Activity();
        activity.setArea(new Area("molding", "Nocera"));
        activity.setID(new Random().nextInt(10000));
        activity.setEIT(45);
        activity.setInterruptible(true);
        activity.setTipology("ambito");
        activity.setWeekNumber(2);
        activity.setWorkspaceNotes("notes");
        
        activity.saveToDatabase();
    }
    
    @Test
    public void testGetAllDatabaseInstances(){
        Activity[] liste = Activity.getAllDatabaseInstances();
        assertEquals(liste[0],activity);
    }
    @Test
    public void testGetInstancesWithWeekNumber(){
        activity.saveToDatabase();
        Activity[] liste = Activity.getInstancesWithWeekNumber(2);
        assertEquals(liste[0],activity);
    }
    
}
