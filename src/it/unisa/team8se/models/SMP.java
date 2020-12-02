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

/**
 *
 * @author cptso
 */
public class SMP extends DatabaseModel{
    private String nome;
    private String documentoPDF;

    public SMP(String nome) {
        this.nome = nome;
    }
    
    public SMP(String nome, String documentoPDF) {
        this.nome = nome;
        this.documentoPDF = documentoPDF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumentoPDF() {
        return documentoPDF;
    }

    public void setDocumentoPDF(String documentoPDF) {
        this.documentoPDF = documentoPDF;
    }

    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        if(rs.next()) {
            setNome(rs.getString("nome"));
            setDocumentoPDF(rs.getString("documento_pdf"));
        }
    }

    @Override
    public void saveToDatabase() throws SQLException {
        String sql = "insert into smp(nome, documento_pdf) values(?, ?)";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, documentoPDF);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public boolean existsInDatabase() throws SQLException {
        String sql = "select * from smp where nome = ?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setString(1, nome);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
            return true;
        else
            return false;
    } 
}
