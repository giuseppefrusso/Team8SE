/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author cptso
 */
public class DatabaseContext {

    private final String databaseURL = "jdbc:postgresql://localhost/";
    private final String databaseName = "";

    private Connection db;

    public void connectDatabase(String username, String password) {
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
    
    public PreparedStatement getStatement(){
        return null;
    }
}
