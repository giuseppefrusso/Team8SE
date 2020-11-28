/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.Competence;
import it.unisa.team8se.models.Maintainer;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author gerar
 */
public class CompetenceView extends javax.swing.JFrame {

    protected DefaultComboBoxModel comboBoxModel;
    protected DefaultListModel<String> listModel;

    private Maintainer maintainers;
            
    private final String username = "postgres";
    private final String password = "password";

    /**
     * Creates new form CompetenceView
     */
    public CompetenceView() {
        DatabaseContext.connectDatabase("ProgettoSE", username, password);
        initComboBoxModel();
        initListModel();
        initComponents();

    }

    private void initComboBoxModel() {
        comboBoxModel = new DefaultComboBoxModel();
        refreshUsers();
    }

    protected void initListModel() {
        listModel = new DefaultListModel<>();
        if (comboBoxModel.getSize() != 0) {
            String defaultUsername = (String) comboBoxModel.getElementAt(0);
            refreshCompetences(defaultUsername);
        }
    }

    protected boolean refreshUsers() {
        Maintainer[] maintainers = Maintainer.getAllDatabaseInstances();
        if (maintainers != null && maintainers.length > 0) {
            for (Maintainer m : maintainers) {
                comboBoxModel.addElement(m.getUsername());
            }
            return true;
        }
        return false;

        /*
        try {
            Connection connection = DatabaseContext.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select username from maintainer order by username");
            
            while(rs.next()) {
                comboBoxModel.addElement(rs.getString("username"));
            }
            
            rs.close();
            statement.close();
            
        } catch (SQLException ex) {
            raiseError("Errore nella lettura degli utenti");
            return false;
        }
        return true;
         */
    }

    protected boolean refreshCompetences(String username) {
        listModel.clear();
        Competence[] competences = Competence.getAllCompetenceOfMaintainer(username);
        if (competences != null) {
            for (Competence c : competences) {
                listModel.addElement(c.getDescrizione());
            }
            return true;
        }
        return false;

        /*
        listModel.clear();
        try {
            Connection connection = DatabaseContext.getConnection();
            String query = "select C.id as id, C.descrizione as competenza from competenza C join possesso P on C.id = P.id where P.maintainer=? order by competenza";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                listModel.addElement(rs.getString("competenza"));
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            raiseError("Errore nella lettura delle competenze");
            return false;
        }
        return true;
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listCompetence = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();
        assignButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Competence View");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 102, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        comboBox.setModel(comboBoxModel);
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        listCompetence.setModel(listModel);
        jScrollPane2.setViewportView(listCompetence);

        jLabel1.setText("Utente");

        jLabel2.setText("Competenze");

        removeButton.setText("Rimuovi");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        assignButton.setText("Assegna");
        assignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignButtonActionPerformed(evt);
            }
        });

        backButton.setText("Utenti");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(assignButton)
                                .addComponent(removeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(backButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(assignButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(backButton)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void raiseError(String message) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(this, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        String selectedUsername = (String) comboBox.getSelectedItem();
        refreshCompetences(selectedUsername);
    }//GEN-LAST:event_comboBoxActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        SystemAdminForm form = new SystemAdminForm();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        DatabaseContext.closeConnection();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private String getSelectedUsername() {
        if (comboBoxModel.getSize() == 0) {
            raiseError("Non c'è alcun manutentore!");
            return null;
        }
        String selectedUsername = (String) comboBox.getSelectedItem();
        if (selectedUsername == null) {
            selectedUsername = (String) comboBoxModel.getElementAt(0);
        }
        return selectedUsername;
    }

    private String getSelectedCompetence() {
        if (listModel.getSize() == 0) {
            raiseError("Non c'è alcuna competenza!");
            return null;
        }
        String selectedCompetence = listCompetence.getSelectedValue();
        if (selectedCompetence == null) {
            raiseError("Non è stata selezionata alcuna competenza!");
            return null;
        }
        return selectedCompetence;
    }

    protected boolean assign(String username, String competenceDesc) {
        try {            
            int id = 0;
            boolean assignCompetence = true;

            /*
            ResultSet rs = s.executeQuery("select * from competenza order by descrizione");
            while (rs.next()) {
                if (rs.getString("descrizione").equalsIgnoreCase(competenceDesc)) {
                    id = rs.getInt("id");
                    assignCompetence = false;
                }
            }*/

            Competence competence = new Competence();
            if (!competence.existsInDatabase()) {
                ResultSet rs = DatabaseContext.getStatement().executeQuery("select max(id) from competenza");
                rs.next();
                int maxId = rs.getInt(1);
                id = maxId + 1;
                rs.close();
                
                competence.setID(id);
                competence.setDescrizione(competenceDesc);
                competence.saveToDatabase();
                
                /*
                query = "insert into competenza values(?,?)";
                ps = c.prepareStatement(query);
                ps.setInt(1, id);
                ps.setString(2, competenceDesc);
                ps.executeUpdate();
                */
            }
            
            String query = "insert into possesso values(?, ?)";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(query);
            
            ps.setInt(1, id);
            ps.setString(2, username);
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            raiseError("Errore nell'assegnamento");
            return false;
        }
        refreshCompetences(username);
        return true;
    }

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        String selectedUsername = getSelectedUsername();
        if (selectedUsername == null) {
            return;
        }
        String competence = JOptionPane.showInputDialog(this, "Assegna una competenza a '" + selectedUsername + "'",
                "Assegnazione", JOptionPane.PLAIN_MESSAGE);
        assign(selectedUsername, competence);
    }//GEN-LAST:event_assignButtonActionPerformed

    protected boolean remove(String username, String competence) {
        try {
            Connection c = DatabaseContext.getConnection();
            String query = "select C.id as id from competenza C where C.descrizione=? "
                    + "intersect "
                    + "select P.id as id from possesso P where P.maintainer=?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, competence);
            ps.setString(2, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt("id");

            query = "delete from possesso where id=? and maintainer=?";
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.executeUpdate();

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            raiseError("Errore nella rimozione");
            return false;
        }
        refreshCompetences(username);
        return true;
    }


    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        String selectedUsername = getSelectedUsername();
        String selectedCompetence = getSelectedCompetence();
        if (selectedUsername == null || selectedCompetence == null) {
            return;
        }

        int reply = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler cancellare la competenza '" + selectedCompetence + "' di '" + selectedUsername + "' ?", username, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            remove(selectedUsername, selectedCompetence);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompetenceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompetenceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompetenceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompetenceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompetenceView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listCompetence;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
