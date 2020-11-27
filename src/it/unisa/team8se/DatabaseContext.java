/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.DatabaseModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cptso
 */
public class DatabaseContext {

    private static final String databaseURL = "jdbc:postgresql://localhost/";
    private static final String databaseName = "postgres";

    private static Connection db;

    public static void connectDatabase(String username, String password) {

        try {
            Properties info = new Properties();
            info.setProperty("user", username);
            info.setProperty("password", password);
            db = DriverManager.getConnection(databaseURL + databaseName, info);
        } catch (SQLException e) {
            System.err.println("CONNESSIONE AL DATABASE FALLITA.");
            System.err.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return db;
    }
    
    /*
    public static <T extends DatabaseModel> T[] fetchAllModels(Class<T> c,String sql) {

        try {
            PreparedStatement ps = DatabaseContext.getConnection().prepareStatement(sql);
            ResultSet results = ps.executeQuery();
            LinkedList<T> instances = new LinkedList<>();
            
            while (results.next()) {
                T instance = c.newInstance();
                instance.getFromResultSet(results);
                instances.add(instance);
            }
            return (T[]) instances.toArray();
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/
}
