/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cptso
 */
public class Main {
    
    public static void main(String[] args){
        /*
        try 
        {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Connection con = DriverManager.getConnection(
                         "jdbc:postgresql://localhost/progettoEsame",
                         "postgres",
                         "password");
            if(con.isValid(5)){
                System.out.println("Il database è connesso");
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery("select * from categoria");
                while(rs.next()){
                    System.out.println(rs.getString("nome"));
                    System.out.println(rs.getString("descrizione"));
                }
            }
            else{
                System.out.println("Il database non si è connesso");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
*/
    }
}
