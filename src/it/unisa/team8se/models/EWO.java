package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
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
 * @created 22-nov-2020 11:33:36
 */
public class EWO extends Activity {

    private Ticket ticket;

    public EWO(){
        super();
    }
    public EWO(int ID){
        super(ID);
    }

    public Ticket getTicket() {
        return ticket;
    }
    
    public static EWO[] getAllDatabaseInstances() {
        try {            
            String sql = "select * from ewo";
            LinkedList<EWO> list = DatabaseContext.fetchAllModels(EWO.class, DatabaseContext.getPreparedStatement(sql));
            return Arrays.copyOf(list.toArray(),list.size(),EWO[].class);
            
        } catch (SQLException ex) {
            Logger.getLogger(EWO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public static EWO getInstanceWithPK(int id) {
        String sql = "select * from ewo where id = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setInt(1, id);
            LinkedList<EWO> list = DatabaseContext.fetchAllModels(EWO.class, ps);
            if (list.size() > 0)
                return (EWO)list.get(0);
            else
                return null;
        } catch (SQLException ex) {
            Logger.getLogger(EWO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static EWO[] getInstancesWithWeekNumber(int weekNumber){
        String sql = "select * from ewo where week_number = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setInt(1, weekNumber);
            LinkedList<EWO> list = DatabaseContext.fetchAllModels(EWO.class, ps);
            return Arrays.copyOf(list.toArray(),list.size(),EWO[].class);
        } catch (SQLException ex) {
            Logger.getLogger(EWO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void saveToDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException{
        super.getFromResultSet(rs);
        ticket = new Ticket();
    }

    @Override
    public boolean existsInDatabase() {
        return EWO.getInstanceWithPK(getID()) != null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
}