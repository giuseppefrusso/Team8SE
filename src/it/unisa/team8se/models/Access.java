/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.base.DatabaseModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giuse
 */
public class Access extends DatabaseModel{

    private int ID;
    private String username;
    private Timestamp dataOraLogin, dataOraLogoff;
    
    public Access() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getDataOraLogin() {
        return dataOraLogin;
    }

    public void setDataOraLogin(Timestamp dataOraLogin) {
        this.dataOraLogin = dataOraLogin;
    }

    public Timestamp getDataOraLogoff() {
        return dataOraLogoff;
    }

    public void setDataOraLogoff(Timestamp dataOraLogoff) {
        this.dataOraLogoff = dataOraLogoff;
    }

    public static Access[] getAllDatabaseInstances() throws SQLException {
        String sql = "select * from accesso";
        LinkedList<Access> list = DatabaseContext.fetchAllModels(Access.class, DatabaseContext.getPreparedStatement(sql));
        return Arrays.copyOf(list.toArray(), list.size(), Access[].class);
    }

    public static Access getInstanceWithPK(int ID){
        String sql = "select * from accesso where id_accesso = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setInt(1, ID);
            LinkedList<Access> list = DatabaseContext.fetchAllModels(Access.class, ps);
            if (list.size() > 0)
                return (Access)list.get(0);
            else
                return null;
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        setID(rs.getInt("id_accesso"));
        if(rs.getString("maintainer")!=null)
            setUsername(rs.getString("maintainer"));
        else if(rs.getString("planner")!= null) 
            setUsername(rs.getString("planner"));
        else
            setUsername(rs.getString("system_administrator"));
        setDataOraLogin(rs.getTimestamp("data_e_ora_login"));
        setDataOraLogoff(rs.getTimestamp("data_e_ora_logoff"));
    }
    
    @Override
    public void saveToDatabase() throws SQLException {
        String sql = "insert into accesso(id_accesso, username, data_e_ora_login) "
                + "values(?, ?, ?)";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setInt(1, ID);
        ps.setString(2, username);
        ps.setTimestamp(3, dataOraLogin);
        ps.executeUpdate();
        ps.close();
    }
    
    public void logoff() throws SQLException {
        String sql = "update accesso set data_e_ora_logoff = ? "
                + "where id = ?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setTimestamp(1, dataOraLogoff);
        ps.setInt(2, ID);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public boolean existsInDatabase() throws SQLException {
        return Access.getInstanceWithPK(getID()) != null;
    }

    public Object[] toPastArray() {
        return new Object[]{getID(), getUsername(), getDataOraLogin(), getDataOraLogoff()};
    }
    
    public Object[] toCurrentArray() {
        return new Object[]{getID(), getUsername(), getDataOraLogin()};
    }
}
