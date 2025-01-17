/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.base.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cptso
 */
public class SystemAdmin extends User {

    public SystemAdmin() {
    }

    public SystemAdmin(String surname, String name, String username, String password) {
        super(surname, name, username, password, "System Admin");
    }
    
    public static SystemAdmin[] getAllDatabaseInstances() {
        try {
            String sql = "select * from system_administrator";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            LinkedList<SystemAdmin> list = DatabaseContext.fetchAllModels(SystemAdmin.class, ps);
            return Arrays.copyOf(list.toArray(), list.size(), SystemAdmin[].class);
        } catch (SQLException ex) {
            Logger.getLogger(SystemAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static SystemAdmin getInstanceWithPK(String username) {
        try {
            String sql = "select * from system_administrator where username = ?";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, username);
            LinkedList<SystemAdmin> list = DatabaseContext.fetchAllModels(SystemAdmin.class, ps);

            if (list.size() > 0) {
                return list.get(0);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SystemAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        super.getFromResultSet(rs);
        setRole("System Admin");
    }

    @Override
    public void saveToDatabase() {
           try {
            String sql = "insert into system_administrator (username,password,nome,cognome) values (?,?,?,?)";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, getUsername());
            ps.setString(2, getPassword());
            ps.setString(3, getName());
            ps.setString(4, getSurname());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Planner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void removeFromDatabase(String username) throws SQLException {
        String sql = "delete from system_administrator where username=?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);

        ps.setString(1, username);

        ps.executeUpdate();
        ps.close();
    }
    
    public void updateToDatabase() {
        try {
            String sql = "update system_administrator set password = ?, nome = ?, cognome = ? where username = ?";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);

            ps.setString(1, getPassword());
            ps.setString(2, getName());
            ps.setString(3, getSurname());
            ps.setString(4, getUsername());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Planner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateToDatabase(String newPk) {
        try {
            String sql = "update system_administrator set username = ?, password = ?, nome = ?, cognome = ? where username = ?";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);

            ps.setString(1, newPk);
            ps.setString(2, getPassword());
            ps.setString(3, getName());
            ps.setString(4, getSurname());
            ps.setString(5, getUsername());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Planner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean existsInDatabase() {
        return SystemAdmin.getInstanceWithPK(getUsername()) != null;
    }
    
    public static SystemAdmin authenticate(String username, String password) {
        SystemAdmin sa = SystemAdmin.getInstanceWithPK(username);
        if(sa != null){
            if(sa.getPassword().equals(password)){
                return sa;
            }
        }
        return null;
    }
}
