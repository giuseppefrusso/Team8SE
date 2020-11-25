/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author cptso
 */
public class DatabaseContext {

    private static final String databaseURL = "jdbc:postgresql://localhost/";
    private static final String databaseName = "";

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
    
    public static PreparedStatement getStatement(){
        return null;
    }
    
    public static ResultSet executeQuery(String Query){
        return null;
    }
}
