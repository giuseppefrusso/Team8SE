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

    public Ticket() {

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

    public void setDepartmentFlag(DepartmentFlag DepartmentFlag) {
        this.DepartmentFlag = DepartmentFlag;
    }

    public void setMaintainerFlag(MaintainerFlag MaintainerFlag) {
        this.MaintainerFlag = MaintainerFlag;
    }

    public void setState(TicketState State) {
        this.State = State;
    }
}//end Ticket
