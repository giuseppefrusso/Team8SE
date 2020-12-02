package it.unisa.team8se.models.base;

import it.unisa.team8se.models.base.DatabaseModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


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
    
    public String[] toArray(){
        return new String[]{getSurname(),getName(),getUsername(),getPassword(),getRole()};
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
    
    @Override
    public void saveToDatabase() throws SQLException{
        
    }
    
    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        setName(rs.getString("nome"));
        setSurname(rs.getString("cognome"));
        setUsername(rs.getString("username"));
        setPassword(rs.getString("password"));
    }
    
}