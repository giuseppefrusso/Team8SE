package it.unisa.team8se.models.base;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.base.DatabaseModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:39
 */
public abstract class User extends DatabaseModel{

    private String surname;    
    private String name;
    private String username;
    private String password;
    private String role;

    public User(){
    }
    
    public User(String surname, String name, String username, String password, String role) {
        this.surname = surname;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static String[] toArray(String surname, String name, String username, String password, String role) {
        String[] array = {surname, name, username, password, role};
        return array;
    }

    @Override
    public void saveToDatabase(){

    }
    
    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        setName(rs.getString("nome"));
        setSurname(rs.getString("cognome"));
        setRole(rs.getString("ruolo"));
        setUsername(rs.getString("username"));
        setPassword(rs.getString("password"));
    }
}