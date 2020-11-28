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
    public void saveToDatabase(){
        
    }

    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        super.getFromResultSet(rs);
    }
}
