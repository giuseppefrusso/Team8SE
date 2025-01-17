/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.Message;
import it.unisa.team8se.models.Competence;
import it.unisa.team8se.models.Maintainer;
import java.sql.SQLException;
import java.util.LinkedList;
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

    private LinkedList<Maintainer> maintainers;

    /**
     * Creates new form CompetenceView
     */
    public CompetenceView() {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }

        maintainers = new LinkedList<>();

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
        comboBoxModel.removeAllElements();
        try {
            Maintainer[] ms = Maintainer.getAllDatabaseInstances();
            if (ms != null && ms.length > 0) {
                maintainers.clear();
                for (Maintainer m : ms) {
                    comboBoxModel.addElement(m.getUsername());
                    maintainers.add(m);
                }

            }
        } catch (SQLException ex) {
            Message.raiseError(this, "Loading view!");
            return false;
        }
        return true;
    }

    protected boolean refreshCompetences(String username) {
        listModel.clear();
        Competence[] competences = Competence.getAllCompetencesOfMaintainer(username);
        if (competences.length != 0) {
            for (Competence c : competences) {
                listModel.addElement(c.getDescrizione());
            }
            return true;
        }
        return false;
    }


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
        manageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Competence View");
        setIconImage(Message.getImageIcon());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        comboBox.setModel(comboBoxModel);
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        listCompetence.setModel(listModel);
        listCompetence.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listCompetenceFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(listCompetence);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("User");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Competences");

        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        assignButton.setText("Assign");
        assignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        manageButton.setText("Manage");
        manageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageButtonActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(assignButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(manageButton)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assignButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
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

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        String selectedUsername = (String) comboBox.getSelectedItem();
        refreshCompetences(selectedUsername);
    }//GEN-LAST:event_comboBoxActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        /*
        SystemAdminForm form = new SystemAdminForm();
        form.setVisible(true);*/
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private Maintainer getSelectedMantainer() {
        if (comboBoxModel.getSize() == 0) {
            Message.raiseError(this, "No maintainers!");
            return null;
        }
        int index = comboBox.getSelectedIndex();

        if (index < 0 || index > maintainers.size()) {
            return maintainers.get(0);
        } else {
            return maintainers.get(index);
        }
    }

    private String getSelectedCompetence() {
        if (listModel.getSize() == 0) {
            Message.raiseError(this, "No competences!");
            return null;
        }
        String selectedCompetence = listCompetence.getSelectedValue();
        if (selectedCompetence == null) {
            Message.raiseError(this, "No selected competence!");
            return null;
        }
        return selectedCompetence;
    }

    protected boolean assign(Maintainer maintainer, Competence competence) {
        if (maintainer == null)  {
            return false;
        }

        String username = maintainer.getUsername();
        try {
            competence.saveIntoPossesso(username);
        } catch (SQLException ex) {
            Message.raiseError(this, "Assignment error");
            return false;
        }
        refreshCompetences(username);
        return true;
    }

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        Maintainer selectedMaintainer = getSelectedMantainer();
        if (selectedMaintainer == null) {
            return;
        }
        String selectedUsername = selectedMaintainer.getUsername();

        Competence[] cs = Competence.getAllDatabaseInstances();
        if(cs == null || cs.length <=0) {
            Message.raiseError(this, "No competences!");
            return;
        }
        //JComboBox jcb = new JComboBox(cs);
        Competence competence = (Competence) JOptionPane.showInputDialog(this, "Select a competence", "Add", 
                JOptionPane.QUESTION_MESSAGE, null, cs, cs[0]);

        if (competence == null) {
            return;
        }
        assign(selectedMaintainer, competence);
        removeButton.setEnabled(false);
    }//GEN-LAST:event_assignButtonActionPerformed

    protected boolean remove(String username, String competence) {
        try {
            Competence.removeFromPossessoWithDescription(competence, username);
        } catch (SQLException ex) {
            Message.raiseError(this, "Removing error");
            return false;
        }
        refreshCompetences(username);
        return true;
    }


    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Maintainer selectedMaintainer = getSelectedMantainer();
        String selectedCompetence = getSelectedCompetence();
        if (selectedMaintainer == null || selectedCompetence == null) {
            Message.raiseError(this, "No selected competence!");
            return;
        }

        String selectedUsername = selectedMaintainer.getUsername();

        int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove '" + selectedCompetence + "' competence of '" + selectedUsername + "' ?", "Remove", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            remove(selectedUsername, selectedCompetence);
        }
        removeButton.setEnabled(false);
    }//GEN-LAST:event_removeButtonActionPerformed

    private void listCompetenceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listCompetenceFocusGained
        removeButton.setEnabled(true);
    }//GEN-LAST:event_listCompetenceFocusGained

    private void manageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageButtonActionPerformed
        CompetenceManager view = new CompetenceManager();
        view.setVisible(true);
    }//GEN-LAST:event_manageButtonActionPerformed

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
    private javax.swing.JButton manageButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
