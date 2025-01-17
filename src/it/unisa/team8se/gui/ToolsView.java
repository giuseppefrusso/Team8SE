/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.Message;
import it.unisa.team8se.models.Material;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cptso
 */
public class ToolsView extends javax.swing.JFrame {

    private LinkedList<Material> materials;
    private DefaultTableModel listModel;

    /**
     * Creates new form ToolsView
     */
    public ToolsView() {
        initComponents();

        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }

        materials = new LinkedList<>();
        listModel = new DefaultTableModel(new String[]{"Name", "Description"}, 0);

        toolList.setModel(listModel);
        refreshMaterials();
    }

    private void refreshMaterials() {
        materials.clear();
        listModel.setRowCount(0);

        Material[] m = Material.getAllDatabaseInstances();

        if (m != null || m.length > 0) {
            Collections.addAll(materials, m);
            for (Material mat : m) {
                if (mat.getDescription() != null) {
                    listModel.addRow(new String[]{mat.getName(), mat.getDescription()});
                } else {
                    listModel.addRow(new String[]{mat.getName(), ""});
                }
            }
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolsLabel = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        descriptionField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        toolList = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tools View");
        setBackground(new java.awt.Color(255, 204, 153));
        setIconImage(Message.getImageIcon());
        setResizable(false);

        toolsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        toolsLabel.setText("MATERIALS");

        removeButton.setText("Remove");
        removeButton.setToolTipText("");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Modify");
        modifyButton.setEnabled(false);
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Description");

        jLabel2.setText("Name");

        jLabel3.setText("LIST");

        toolList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        toolList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        toolList.setRowSelectionAllowed(false);
        toolList.setShowHorizontalLines(false);
        toolList.getTableHeader().setReorderingAllowed(false);
        toolList.setVerifyInputWhenFocusTarget(false);
        toolList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                toolListFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(toolList);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(327, 474, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(descriptionField)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifyButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(toolsLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(toolsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyButton)
                    .addComponent(removeButton)
                    .addComponent(backButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String name = nameField.getText();
        String desc = descriptionField.getText();

        if (name.isEmpty()) {
            Message.raiseError(rootPane, "Please fill the name field!");
            return;
        }

        Material m = new Material(name, desc);
        m.saveToDatabase();
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
        refreshMaterials();
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Material selected = materials.get(toolList.getSelectedRow());
        if (selected != null) {
            selected.removeFromDatabase();
            refreshMaterials();
        }
        toolList.clearSelection();
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
    }//GEN-LAST:event_removeButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        int selectedCol = toolList.getSelectedColumn();
        int selectedRow = toolList.getSelectedRow();

        if (selectedCol >= 0 && selectedRow >= 0) {
            Material selectedMat = materials.get(selectedRow);
            String colName = toolList.getColumnName(selectedCol);

            if (selectedCol == 0) {
                String newValue = (String) JOptionPane.showInputDialog(this, "Modify " + colName, "Modify",
                         JOptionPane.INFORMATION_MESSAGE, null, null, selectedMat.getName());
                if (newValue != null && !newValue.isEmpty()) {
                    selectedMat.updateToDatabaseWithName(newValue);
                    refreshMaterials();
                }
            } else if (selectedCol == 1) {
                String newValue = (String) JOptionPane.showInputDialog(this, "Modify " + colName, "Modify",
                         JOptionPane.INFORMATION_MESSAGE, null, null, selectedMat.getDescription());
                if(newValue != null){
                    selectedMat.setDescription(newValue);
                    selectedMat.updateToDatabase();
                    refreshMaterials();
                }
            }
        }
        toolList.clearSelection();
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void toolListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_toolListFocusGained
        modifyButton.setEnabled(true);
        removeButton.setEnabled(true);
    }//GEN-LAST:event_toolListFocusGained

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
            java.util.logging.Logger.getLogger(ToolsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToolsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToolsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToolsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToolsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton removeButton;
    private javax.swing.JTable toolList;
    private javax.swing.JLabel toolsLabel;
    // End of variables declaration//GEN-END:variables
}
