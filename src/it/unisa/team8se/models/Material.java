package it.unisa.team8se.models;


/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:37
 */
public class Material {

    private String Name;
    private String Description;

    public Material(){

    }

    public void finalize() throws Throwable {

    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }
	    
    public static Material[] getAllDatabaseInstances() {
        return null;
    }

    
    public static Material getInstanceWithPK(Object... pk) {
        return null;
    }

    public void saveToDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}//end Material