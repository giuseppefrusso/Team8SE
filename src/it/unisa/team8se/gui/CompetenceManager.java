/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.Message;
import it.unisa.team8se.UserSession;
import it.unisa.team8se.models.Competence;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author giuse
 */
public class CompetenceManager extends javax.swing.JFrame {

    private DefaultTableModel competenceModel;
    private LinkedList<Competence> competences;

    /**
     * Creates new form CompetenceManager
     */
    public CompetenceManager() {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }
        initTableModel();
        competences = new LinkedList<>();
        initComponents();
        refreshCompetences();
    }
    
    private void initTableModel() {
        competenceModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        competenceModel.addColumn("ID");
        competenceModel.addColumn("Description");
    }

    private void refreshCompetences() {
        competenceModel.setRowCount(0);
        competences.clear();

        Competence[] cs = Competence.getAllDatabaseInstances();
        if (cs != null || cs.length > 0) {
            Collections.addAll(competences, cs);
            for (Competence c : cs) {
                competenceModel.addRow(c.toArray());
            }
        }
        competenceTable.clearSelection();
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
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
        descField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        modifyButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        competenceTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Competence Manager");
        setIconImage(Message.getImageIcon());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        descField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Competence");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Modify");
        modifyButton.setEnabled(false);
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        competenceTable.setAutoCreateRowSorter(true);
        competenceTable.setModel(competenceModel);
        competenceTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                competenceTableFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(competenceTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(descField)
                        .addGap(18, 18, 18)
                        .addComponent(addButton))
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modifyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(modifyButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
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

    private Competence getSelectedCompetence(int row) {
        if (competenceModel.getRowCount() == 0) {
            Message.raiseError(this, "There is no competence!");
            return null;
        }
        int selectedId = (int) competenceModel.getValueAt(row,0);
        String selectedDescription = (String) competenceModel.getValueAt(row, 1);
        Competence selectedCompetence = new Competence(selectedId, selectedDescription);
        if (selectedCompetence == null) {
            Message.raiseError(this, "No competence was selected!");
            return null;
        }
        return selectedCompetence;
    }

    protected boolean add(String desc) {
        try {
            Competence.saveToDatabaseWithDescription(desc);
            return true;
        } catch (SQLException ex) {
            Message.raiseError(this, "Competence already present");
            return false;
        }
    }

    private void addAction() {
        String newDesc = descField.getText();
        if (newDesc == null || newDesc.equals("")) {
            Message.raiseError(this, "Nothing has been entered!");
            return;
        }
        add(newDesc);
        refreshCompetences();
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        addAction();
    }//GEN-LAST:event_addButtonActionPerformed

    private void descFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descFieldActionPerformed
        addAction();
    }//GEN-LAST:event_descFieldActionPerformed

    protected boolean modify(Competence c, String newDesc) {
        try {
            c.updateDescription(newDesc);
            return true;
        } catch (SQLException ex) {
            Message.raiseError(this, "Error in editing");
            return false;
        }
    }

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        Competence c = getSelectedCompetence(competenceTable.getSelectedRow());
        
        String newDesc = JOptionPane.showInputDialog(this, "Choose a new description for competence '"+c.toString()+"'", "Modify", JOptionPane.PLAIN_MESSAGE);
        if(newDesc == null || newDesc.equals("")) {
            return;
        }
        
        modify(c, newDesc);
        refreshCompetences();
    }//GEN-LAST:event_modifyButtonActionPerformed

    protected boolean remove(Competence c) {
        try {
            c.removeFromDatabase();
            return true;
        } catch (SQLException ex) {
            Message.raiseError(this, "Error in removal");
            return false;
        }
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Competence c = getSelectedCompetence(competenceTable.getSelectedRow());
        
        int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the competence '"+c.toString()+"'?",
                "Removal", JOptionPane.YES_NO_OPTION);
        
        if(reply == JOptionPane.YES_OPTION) {
            remove(c);
        }
        refreshCompetences();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void competenceTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_competenceTableFocusGained
        modifyButton.setEnabled(true);
        removeButton.setEnabled(true);
    }//GEN-LAST:event_competenceTableFocusGained

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CompetenceManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompetenceManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompetenceManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompetenceManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompetenceManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTable competenceTable;
    private javax.swing.JTextField descField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
