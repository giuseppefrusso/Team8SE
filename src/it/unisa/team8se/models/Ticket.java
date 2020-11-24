package it.unisa.team8se.models;

import it.unisa.team8se.enumerations.TicketState;
import it.unisa.team8se.enumerations.MaintainerFlag;
import it.unisa.team8se.enumerations.DepartmentFlag;


/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:38
 */
public class Ticket {

	private DepartmentFlag DepartmentFlag;
	private MaintainerFlag MaintainerFlag;
	private TicketState State;

	public Ticket(){

	}

	public void finalize() throws Throwable {

	}

    public DepartmentFlag getDepartmentFlag() {
        return DepartmentFlag;
    }

    public MaintainerFlag getMaintainerFlag() {
        return MaintainerFlag;
    }

    public TicketState getState() {
        return State;
    }
        
}//end Ticket