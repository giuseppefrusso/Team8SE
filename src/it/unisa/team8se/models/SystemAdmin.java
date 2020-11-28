/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.base.User;
import java.sql.PreparedStatement;
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
    public void saveToDatabase(){
        
    }
}
