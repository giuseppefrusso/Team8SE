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
public class Planner extends User {

    public static Planner[] getAllDatabaseInstances() {
        try {
            String sql = "select * from planner";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            LinkedList<Planner> list = DatabaseContext.fetchAllModels(Planner.class, ps);
            return Arrays.copyOf(list.toArray(), list.size(), Planner[].class);
        } catch (SQLException ex) {
            Logger.getLogger(Planner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Planner getInstanceWithPK(String username) {
        try {
            String sql = "select * from planner where username = ?";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, username);
            LinkedList<Planner> list = DatabaseContext.fetchAllModels(Planner.class, ps);

            if (list.size() > 0) {
                return list.get(0);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Planner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void saveToDatabase() {
        try {
            String sql = "insert into planner (username,password,name,surname) values (?,?,?,?)";
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

    public void updateToDatabase() {
        try {
            String sql = "update planner set password = ?, name = ?, surname = ? where username = ?";
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
            String sql = "update planner set username = ?, password = ?, name = ?, surname = ? where username = ?";
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
    public void getFromResultSet(ResultSet rs) throws SQLException {
        super.getFromResultSet(rs);
    }

    @Override
    public boolean existsInDatabase() {
        return Planner.getInstanceWithPK(getUsername()) != null; //To change body of generated methods, choose Tools | Templates.
    }
}
