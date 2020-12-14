/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import it.unisa.team8se.models.Maintainer;
import it.unisa.team8se.models.Planner;
import it.unisa.team8se.models.SMP;
import it.unisa.team8se.models.SystemAdmin;
import it.unisa.team8se.models.base.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author cptso
 */
public class UserSession {

    private static User loggedUser;
    private static int id;

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static int getId() {
        return id;
    }

    private static Timestamp getCurrentTimestamp() {
        return Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS));
    }

    public static boolean authenticateAsMaintainer(String username, String password) throws SQLException {
        Maintainer m = Maintainer.authenticate(username, password);

        if (m != null) {
            loggedUser = m;
            registerAccess("maintainer");
            return true;
        }
        return false;
    }

    public static boolean authenticateAsPlanner(String username, String password) throws SQLException {
        Planner p = Planner.authenticate(username, password);
        if (p != null) {
            loggedUser = p;
            registerAccess("planner");
            return true;
        }
        return false;
    }

    public static boolean authenticateAsSystemAdmin(String username, String password) throws SQLException {
        SystemAdmin sa = SystemAdmin.authenticate(username, password);
        if (sa != null) {
            loggedUser = sa;
            registerAccess("system_administrator");
            return true;
        }
        return false;
    }

    private static void registerAccess(String typeOfUser) throws SQLException {
        String sql = "select max(id_accesso) from accesso";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            id = rs.getInt(1) + 1;
        } else {
            id = 1;
        }
        rs.close();

        sql = "insert into accesso(id_accesso," + typeOfUser + ", data_e_ora_login) values(?, ?, ?)";
        ps = DatabaseContext.getPreparedStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, loggedUser.getUsername());
        ps.setTimestamp(3, getCurrentTimestamp());
        ps.executeUpdate();
        ps.close();
    }

    public static void close() throws SQLException {
        String sql = "update accesso set data_e_ora_logoff = ? "
                + "where id_accesso = ?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setTimestamp(1, getCurrentTimestamp());
        ps.setInt(2, id);
        ps.executeUpdate();
        ps.close();
        
        DatabaseContext.closeConnection();
        SMP.cleanTempDocumentFolder();
        System.exit(0);
    }
}
