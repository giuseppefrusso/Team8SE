package it.unisa.team8se.models;


/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:35
 */
public class Competence{

    private int ID;
    private String Descrizione;

    public Competence(){

    }
    
    public Competence(int ID, String Descrizione) {
        this.ID = ID;
        this.Descrizione = Descrizione;
    }

    public void finalize() throws Throwable {

    }

    public int getID() {
        return ID;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDescrizione(String Descrizione) {
        this.Descrizione = Descrizione;
    }

    
    public static Competence[] getAllDatabaseInstances() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public static Competence getInstanceWithPK(Object... pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void saveToDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}//end Competence