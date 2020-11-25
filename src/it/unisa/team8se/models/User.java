package it.unisa.team8se.models;


/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:39
 */
public class User {

    private String UserName;
    private String Password; // TODO: Considerare di rimuovere l'attributo password
    private String Name;
    private String LastName;

    public User(){

    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    
    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }
}//end User