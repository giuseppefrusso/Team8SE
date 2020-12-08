/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.Message;
import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.UserSession;
import it.unisa.team8se.models.Maintainer;
import it.unisa.team8se.models.Planner;
import it.unisa.team8se.models.base.User;
import it.unisa.team8se.models.SystemAdmin;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cptso
 */
public class SystemAdminForm extends javax.swing.JFrame {

    protected DefaultTableModel tableModel;
    private ButtonGroup buttonGroup;
    private LinkedList<User> allUsers;

    private void initTableModel() {
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.addColumn("Cognome");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Username");
        tableModel.addColumn("Password");
        tableModel.addColumn("Ruolo");

    }

    private void initButtonGroup() {
        buttonGroup = new ButtonGroup();
        buttonGroup.add(plannerRadioButton);
        buttonGroup.add(maintainerRadioButton);
        buttonGroup.add(adminRadioButton);
    }

    /**
     * Creates new form SystemAdminForm
     */
    public SystemAdminForm() {
        allUsers = new LinkedList<>();

        DatabaseContext.connectDatabase();
        initTableModel();
        refreshUsers();
        initButtonGroup();
        //caricare dati dal db
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

        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        insertButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        surnameField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        surnameLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        plannerRadioButton = new javax.swing.JRadioButton();
        maintainerRadioButton = new javax.swing.JRadioButton();
        adminRadioButton = new javax.swing.JRadioButton();
        competenceButton = new javax.swing.JButton();
        accessButton = new javax.swing.JButton();
        areaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("System Admistrator View\n");
        setBackground(new java.awt.Color(0, 51, 204));
        setIconImage(Message.getImageIcon());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        usernameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameFieldMouseClicked(evt);
            }
        });

        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordFieldMouseClicked(evt);
            }
        });

        insertButton.setText("Inserisci");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Rimuovi");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Modifica");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        nameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameFieldMouseClicked(evt);
            }
        });

        surnameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                surnameFieldMouseClicked(evt);
            }
        });

        tableUsers.setAutoCreateRowSorter(true);
        tableUsers.setModel(tableModel);
        tableUsers.setRowSelectionAllowed(false);
        tableUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableUsers.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableUsers);

        surnameLabel.setText("Cognome");

        nameLabel.setText("Nome");

        passwordLabel.setText("Password");

        usernameLabel.setText("Username");

        plannerRadioButton.setText("Planner");
        plannerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plannerRadioButtonActionPerformed(evt);
            }
        });

        maintainerRadioButton.setText("Maintainer");
        maintainerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintainerRadioButtonActionPerformed(evt);
            }
        });

        adminRadioButton.setText("System Admin");
        adminRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminRadioButtonActionPerformed(evt);
            }
        });

        competenceButton.setText("Competenze");
        competenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                competenceButtonActionPerformed(evt);
            }
        });

        accessButton.setText("Accessi");
        accessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessButtonActionPerformed(evt);
            }
        });

        areaButton.setText("Aree");
        areaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaButtonActionPerformed(evt);
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
                        .addComponent(modifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(areaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accessButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(competenceButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addComponent(surnameLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(nameLabel))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(usernameLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(passwordLabel)
                                        .addGap(10, 10, 10)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plannerRadioButton)
                            .addComponent(maintainerRadioButton)
                            .addComponent(adminRadioButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(insertButton))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surnameLabel)
                            .addComponent(nameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(plannerRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maintainerRadioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(adminRadioButton)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameLabel)
                            .addComponent(passwordLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertButton)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(modifyButton)
                    .addComponent(competenceButton)
                    .addComponent(accessButton)
                    .addComponent(areaButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected boolean refreshUsers() {
        try {
            tableModel.setRowCount(0);
            allUsers.clear();

            Maintainer[] ms = Maintainer.getAllDatabaseInstances();
            if (ms != null) {
                Collections.addAll(allUsers, ms);
            } else {
                return false;
            }

            Planner[] ps = Planner.getAllDatabaseInstances();
            if (ps != null) {
                Collections.addAll(allUsers, ps);
            } else {
                return false;
            }

            SystemAdmin[] sas = SystemAdmin.getAllDatabaseInstances();
            if (sas != null) {
                Collections.addAll(allUsers, sas);
            } else {
                return false;
            }

            for (User u : allUsers) {
                tableModel.addRow(u.toArray());
            }
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nel caricamento");
            return false;
        }
        return true;
    }

    protected boolean containsUsername(String username) {

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String value = (String) tableModel.getValueAt(i, 2);
            if (value.equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    protected boolean insertUser(String surname, String name, String username, String password, String role) {
        if (containsUsername(username)) {
            Message.raiseError(this, "Username già presente!");
            return false;
        }
        if (surname.equals("") || name.equals("") || username.equals("") || password.equals("")) {
            Message.raiseError(this, "Inserire tutti i campi!");
            return false;
        }

        if (role.equalsIgnoreCase("maintainer")) {
            Maintainer m = new Maintainer(surname, name, username, password);
            try {
                m.saveToDatabase();
            } catch (SQLException ex) {
                Logger.getLogger(SystemAdminForm.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else if (role.equalsIgnoreCase("planner")) {
            Planner p = new Planner(surname, name, username, password);
            p.saveToDatabase();
        } else if (role.equalsIgnoreCase("system admin")) {
            SystemAdmin sa = new SystemAdmin(surname, name, username, password);
            sa.saveToDatabase();
        }

        refreshUsers();

        return true;

    }

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        //mettere tendina per scegliere ruolo
        String surname = surnameField.getText();
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String role = new String();

        if (plannerRadioButton.isSelected()) {
            role = "planner";

        } else if (maintainerRadioButton.isSelected()) {
            role = "maintainer";

        } else if (adminRadioButton.isSelected()) {
            role = "system admin";
        } else {
            Message.raiseError(this, "Inserire un ruolo!");
            return;
        }

        insertUser(surname, name, username, password, role);

    }//GEN-LAST:event_insertButtonActionPerformed

    private void surnameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_surnameFieldMouseClicked
        surnameField.selectAll();
    }//GEN-LAST:event_surnameFieldMouseClicked

    private void nameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameFieldMouseClicked
        nameField.selectAll();
    }//GEN-LAST:event_nameFieldMouseClicked

    private void passwordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseClicked
        passwordField.selectAll();
    }//GEN-LAST:event_passwordFieldMouseClicked

    private void usernameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameFieldMouseClicked
        usernameField.selectAll();
    }//GEN-LAST:event_usernameFieldMouseClicked

    protected boolean modifyUser(String newValue, int selectedRow, int selectedColumn) {
        String selectedUsername = (String) tableModel.getValueAt(selectedRow, 2);
        String selectedRole = (String) tableModel.getValueAt(selectedRow, 4);
        String field = tableModel.getColumnName(selectedColumn);

        if (selectedColumn == 2 && containsUsername(newValue)) {
            Message.raiseError(this, "Username già presente!");
            return false;
        }

        if (field.equals("Ruolo")) {
            try {
                if (selectedRole.equalsIgnoreCase("maintainer")) {
                    Maintainer.removeFromDatabase(selectedUsername);
                }
                if (selectedRole.equalsIgnoreCase("planner")) {
                    Planner.removeFromDatabase(selectedUsername);
                }
                if (selectedRole.equalsIgnoreCase("system admin")) {
                    SystemAdmin.removeFromDatabase(selectedUsername);
                }

                if (newValue.equalsIgnoreCase("maintainer")) {
                    Maintainer m = new Maintainer((String) tableModel.getValueAt(selectedRow, 0),
                            (String) tableModel.getValueAt(selectedRow, 1),
                            (String) tableModel.getValueAt(selectedRow, 2),
                            (String) tableModel.getValueAt(selectedRow, 3));

                    m.saveToDatabase();
                }
                if (newValue.equalsIgnoreCase("planner")) {
                    Planner p = new Planner((String) tableModel.getValueAt(selectedRow, 0),
                            (String) tableModel.getValueAt(selectedRow, 1),
                            (String) tableModel.getValueAt(selectedRow, 2),
                            (String) tableModel.getValueAt(selectedRow, 3));
                    p.saveToDatabase();
                }
                if (newValue.equalsIgnoreCase("system admin")) {
                    SystemAdmin sa = new SystemAdmin((String) tableModel.getValueAt(selectedRow, 0),
                            (String) tableModel.getValueAt(selectedRow, 1),
                            (String) tableModel.getValueAt(selectedRow, 2),
                            (String) tableModel.getValueAt(selectedRow, 3));
                    sa.saveToDatabase();
                }
            } catch (SQLException e) {
                Message.raiseError(this, "Errore nella modifica del ruolo.");
                return false;
            }
        } else if (field.equalsIgnoreCase("username")) {
            try {
                if (selectedRole.equalsIgnoreCase("maintainer")) {
                    Maintainer m = (Maintainer) allUsers.get(selectedRow);
                    m.updateToDatabase(newValue);
                } else if (selectedRole.equalsIgnoreCase("planner")) {
                    Planner p = (Planner) allUsers.get(selectedRow);
                    p.updateToDatabase(newValue);
                } else if (selectedRole.equalsIgnoreCase("system admin")) {
                    SystemAdmin sa = (SystemAdmin) allUsers.get(selectedRow);
                    sa.updateToDatabase(newValue);
                }
            } catch (SQLException e) {
                Message.raiseError(this, "ERRORE" + e.getMessage());
                return false;
            }
        } else {
            try {
                tableModel.setValueAt(newValue, selectedRow, selectedColumn);

                if (selectedRole.equalsIgnoreCase("maintainer")) {
                    Maintainer m = (Maintainer) allUsers.get(selectedRow);
                    m.setSurname((String) tableModel.getValueAt(selectedRow, 0));
                    m.setName((String) tableModel.getValueAt(selectedRow, 1));
                    m.setPassword((String) tableModel.getValueAt(selectedRow, 3));
                    m.updateToDatabase();
                } else if (selectedRole.equalsIgnoreCase("planner")) {
                    Planner p = (Planner) allUsers.get(selectedRow);
                    p.setSurname((String) tableModel.getValueAt(selectedRow, 0));
                    p.setName((String) tableModel.getValueAt(selectedRow, 1));
                    p.setPassword((String) tableModel.getValueAt(selectedRow, 3));
                    p.updateToDatabase();
                } else if (selectedRole.equalsIgnoreCase("system admin")) {
                    SystemAdmin sa = (SystemAdmin) allUsers.get(selectedRow);
                    sa.setSurname((String) tableModel.getValueAt(selectedRow, 0));
                    sa.setName((String) tableModel.getValueAt(selectedRow, 1));
                    sa.setPassword((String) tableModel.getValueAt(selectedRow, 3));
                    sa.updateToDatabase();
                }
            } catch (SQLException e) {
                Message.raiseError(this, "ERRORE" + e.getMessage());
                return false;
            }
        }
        refreshUsers();
        return true;
    }

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed

        int selectedRow = tableUsers.getSelectedRow();
        int selectedColumn = tableUsers.getSelectedColumn();

        if (selectedRow == -1 || selectedColumn == -1) {
            Message.raiseError(this, "Selezionare una cella");
            return;
        }

        String oldValue = (String) tableUsers.getValueAt(selectedRow, selectedColumn);

        String field = tableModel.getColumnName(selectedColumn);
        String newValue = new String();
        if (field.equals("Ruolo")) {
            String[] options = {"Planner", "Maintainer", "System Admin"};
            int choice = JOptionPane.showOptionDialog(this, "Modifica " + field, "Modifica", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
            System.out.println(choice);
            switch (choice) {
                case -1:
                    return;
                case 0:
                    newValue = "Planner";
                    break;
                case 1:
                    newValue = "Maintainer";
                    break;
                case 2:
                    newValue = "System Admin";
                    break;
            }
        } else {
            newValue = JOptionPane.showInputDialog(this, "Modifica " + field, "Modifica", JOptionPane.INFORMATION_MESSAGE);
            if (newValue == null || newValue.equals("")) {
                return;
            }
        }

        if (newValue.equalsIgnoreCase(oldValue)) {
            return;
        }

        modifyUser(newValue, selectedRow, selectedColumn);
    }//GEN-LAST:event_modifyButtonActionPerformed

    protected void removeUser(String selectedUsername, int selectedRow) {
        try {
            String role = (String) tableModel.getValueAt(selectedRow, 4);
            if (role.equalsIgnoreCase("Planner")) {
                Planner.removeFromDatabase(selectedUsername);
            }
            if (role.equalsIgnoreCase("Maintainer")) {
                Maintainer.removeFromDatabase(selectedUsername);
            }
            if (role.equalsIgnoreCase("System Admin")) {
                SystemAdmin.removeFromDatabase(selectedUsername);
            }
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nella rimozione!");
        }
        refreshUsers();
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int selectedRow = tableUsers.getSelectedRow();

        if (selectedRow == -1) {
            Message.raiseError(this, "Selezionare una riga!");
            return;
        }

        String selectedUsername = (String) tableModel.getValueAt(selectedRow, 2);

        int reply = JOptionPane.showConfirmDialog(this, "Sei sicuro di rimuovere l'utente con username '" + selectedUsername + "' ?", "Rimozione", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (reply == JOptionPane.YES_OPTION) {
            removeUser(selectedUsername, selectedRow);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void plannerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plannerRadioButtonActionPerformed

        maintainerRadioButton.setSelected(false);
        adminRadioButton.setSelected(false);
    }//GEN-LAST:event_plannerRadioButtonActionPerformed

    private void maintainerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintainerRadioButtonActionPerformed

        plannerRadioButton.setSelected(false);
        adminRadioButton.setSelected(false);
    }//GEN-LAST:event_maintainerRadioButtonActionPerformed

    private void adminRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminRadioButtonActionPerformed

        plannerRadioButton.setSelected(false);
        maintainerRadioButton.setSelected(false);
    }//GEN-LAST:event_adminRadioButtonActionPerformed

    private void competenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_competenceButtonActionPerformed
        // TODO add your handling code here:
        CompetenceView competence = new CompetenceView();
        competence.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_competenceButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            UserSession.close();
            DatabaseContext.closeConnection();
            System.exit(0);
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nella chiusura!");
        }
    }//GEN-LAST:event_formWindowClosing

    private void accessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessButtonActionPerformed
        AccessView view = new AccessView();
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_accessButtonActionPerformed

    private void areaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaButtonActionPerformed
        AreaView view = new AreaView();
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_areaButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SystemAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemAdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accessButton;
    private javax.swing.JRadioButton adminRadioButton;
    private javax.swing.JButton areaButton;
    private javax.swing.JButton competenceButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton maintainerRadioButton;
    private javax.swing.JButton modifyButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JRadioButton plannerRadioButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTable tableUsers;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
