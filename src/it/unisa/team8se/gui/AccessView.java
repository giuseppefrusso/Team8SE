/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.Message;
import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.UserSession;
import it.unisa.team8se.models.Access;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author giuse
 */
public class AccessView extends javax.swing.JFrame {

    private DefaultTableModel pastAccessesModel, currentAccessesModel;
    
    private void initPastAccessesModel() {
        pastAccessesModel = new DefaultTableModel();
        pastAccessesModel.addColumn("ID");
        pastAccessesModel.addColumn("Username");
        pastAccessesModel.addColumn("Data e ora login");
        pastAccessesModel.addColumn("Data e ora logoff");
    }
    
    private void initCurrentAccessesModel() {
        currentAccessesModel = new DefaultTableModel();
        currentAccessesModel.addColumn("ID");
        currentAccessesModel.addColumn("Username");
        currentAccessesModel.addColumn("Data e ora login");
    }
    
    protected boolean refreshPastAccesses() {
        try {
            pastAccessesModel.setRowCount(0);
            Access[] pastAccesses = Access.getAllDatabaseInstances();
            for (Access a : pastAccesses) {
                if(a.getDataOraLogoff()!= null)
                    pastAccessesModel.addRow(a.toPastArray());
            }
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nel caricamento degli accessi passati!");
            return false;
        }
        return true;
    }
    
    protected boolean refreshCurrentAccesses() {
        try {
            currentAccessesModel.setRowCount(0);
            Access[] currentAccesses = Access.getAllDatabaseInstances();
            for (Access a : currentAccesses) {
                if (a.getDataOraLogoff()==null)
                    currentAccessesModel.addRow(a.toCurrentArray());
            }
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nel caricamento degli accessi correnti!");
            return false;
        }
        return true;
    }
    
    private void initTableModels() {
        initPastAccessesModel();
        initCurrentAccessesModel();
    }
    
    protected boolean refreshAccesses() {
        return refreshPastAccesses() && refreshCurrentAccesses();
    }
    
    /**
     * Creates new form AccessView
     */
    public AccessView() {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }
        initTableModels();
        refreshAccesses();
        initComponents();        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        currentAccessesTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        pastAccessesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Access View");
        setIconImage(Message.getImageIcon());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        currentAccessesTable.setAutoCreateRowSorter(true);
        currentAccessesTable.setModel(currentAccessesModel);
        currentAccessesTable.setEnabled(false);
        jScrollPane1.setViewportView(currentAccessesTable);

        pastAccessesTable.setAutoCreateRowSorter(true);
        pastAccessesTable.setModel(pastAccessesModel);
        pastAccessesTable.setEnabled(false);
        pastAccessesTable.setRowSelectionAllowed(false);
        pastAccessesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(pastAccessesTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Accessi passati");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Accessi correnti");

        backButton.setText("Utenti");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Aggiorna");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(refreshButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                            .addComponent(backButton))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(refreshButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            UserSession.close();
            DatabaseContext.closeConnection();
            System.exit(0);
        } catch (SQLException ex) {
            Message.raiseError(this,"Errore nella chiusura!");
        }
    }//GEN-LAST:event_formWindowClosing

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        SystemAdminForm form = new SystemAdminForm();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        if (!refreshAccesses())
            Message.raiseError(this, "Non ci sono accessi da visualizzare!");
    }//GEN-LAST:event_refreshButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AccessView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccessView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccessView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccessView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccessView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTable currentAccessesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable pastAccessesTable;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
