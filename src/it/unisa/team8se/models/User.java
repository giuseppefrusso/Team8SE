package it.unisa.team8se.models;


/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:39
 */
public class User {

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

    public String[] toArray() {
        String[] array = {surname, name, username, password, role};
        return array;
    }
    
        
    public static User[] getAllDatabaseInstances() {
        return null;
    }

    
    public static User getInstanceWithPK(Object... pk) {
        return null;
    }

    
    public void saveToDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}