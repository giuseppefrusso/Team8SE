/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import it.unisa.team8se.models.base.DatabaseModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cptso
 */
public class DatabaseContext {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost/";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String DB_NAME = "postgres";

    private static Connection db;

    public static void connectDatabase() {

        try {
            Class.forName("org.postgresql.Driver");
            Properties info = new Properties();
            info.setProperty("user", USERNAME);
            info.setProperty("password", PASSWORD);
            db = DriverManager.getConnection(DATABASE_URL + DB_NAME, info);
        } catch (SQLException e) {
            System.err.println("CONNESSIONE AL DATABASE FALLITA.");
            System.err.println(e.getMessage());
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        return db;
    }
    
    public static boolean isConnected(){
        Connection conn = getConnection();
        try {
            return conn != null && conn.isValid(1000);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static Statement getStatement(){
        try {
            return db.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException{
        return db.prepareStatement(sql);
    }
    
    public static <T extends DatabaseModel> LinkedList<T> fetchAllModels(Class<T> c,PreparedStatement ps) throws SQLException{
        try {
            ResultSet results = ps.executeQuery();
            LinkedList<T> instances = new LinkedList<>();
            
            while (results.next()) {
                T instance = c.newInstance();
                instance.getFromResultSet(results);
                instances.add(instance);
            }
            
            results.close();
            ps.close();
            return instances;
        } catch (InstantiationException ex) {
            Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void closeConnection() {
        try {
            db.close();
        } catch (SQLException e) {
            System.err.println("CHIUSURA DEL DATABASE FALLITA.");
            System.err.println(e.getMessage());
        }
    }
}
