/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import it.unisa.team8se.models.Maintainer;
import it.unisa.team8se.models.Planner;
import it.unisa.team8se.models.SystemAdmin;
import it.unisa.team8se.models.base.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author cptso
 */
public class UserSession {

    private static User loggedUser;

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static boolean authenticateAsMaintainer(String username, String password) throws SQLException {
        Maintainer m = Maintainer.authenticate(username, password);
        if (m != null) {
            loggedUser = m;
            
            /*
            String sql = "insert into accesso ()";
            try(PreparedStatement ps = DatabaseContext.getPreparedStatement("")){
            }*/
            
            return true;
        }
        return false;
    }

    public static boolean authenticateAsPlanner(String username, String password) {
        Planner p = Planner.authenticate(username, password);
        if (p != null) {
            loggedUser = p;
            
            
            
            return true;
        }
        return false;
    }

    public static boolean authenticateAsSystemAdmin(String username, String password) {
        SystemAdmin sa = SystemAdmin.authenticate(username, password);
        if (sa != null) {
            loggedUser = sa;
            
            
            
            return true;
        }
        return false;
    }
    
    public static void close(){
        
    }
}
