package it.unisa.team8se.models;

import java.util.LinkedList;



/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:36
 */
public class EWO extends Activity {

	private Ticket Ticket;

	public EWO(){
            super();
	}

    public Ticket getTicket() {
        return Ticket;
    }
    
    public static LinkedList<EWO> getAllDatabaseInstances() {
        return null;
    }

    
    public static EWO getInstanceWithPK(Object... pk) {
        return null;
    }

    
    public void saveToDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}