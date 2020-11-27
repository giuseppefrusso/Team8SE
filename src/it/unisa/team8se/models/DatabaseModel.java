/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cptso
 */
public abstract class DatabaseModel {
    public abstract void getFromResultSet(ResultSet rs) throws SQLException;
    public abstract void saveToDatabase();
}
