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
import java.awt.EventQueue;
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
public class SystemAdminForm extends UserBaseForm {

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
        tableModel.addColumn("Last name");
        tableModel.addColumn("Name");
        tableModel.addColumn("Username");
        tableModel.addColumn("Password");
        tableModel.addColumn("Role");
    }

    private void initButtonGroup() {
        buttonGroup = new ButtonGroup();
        buttonGroup.add(plannerRadioButton);
        buttonGroup.add(maintainerRadioButton);
        buttonGroup.add(adminRadioButton);
    }

    public SystemAdminForm() {
        allUsers = new LinkedList<>();

        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }
        initTableModel();
        refreshUsers();
        initButtonGroup();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createUserPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        adminRadioButton = new javax.swing.JRadioButton();
        maintainerRadioButton = new javax.swing.JRadioButton();
        plannerRadioButton = new javax.swing.JRadioButton();
        insertButton = new javax.swing.JButton();
        userList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        modifyButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        viewMenu = new javax.swing.JPanel();
        competenceButton = new javax.swing.JButton();
        accessButton = new javax.swing.JButton();
        areaButton = new javax.swing.JButton();
        activityButton = new javax.swing.JButton();
        materialButton = new javax.swing.JButton();
        smpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("System Admistrator - User Management View");
        setBackground(new java.awt.Color(0, 51, 204));
        setIconImage(Message.getImageIcon());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        createUserPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CREATE USER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        createUserPanel.setLayout(new java.awt.GridLayout(12, 1));

        usernameLabel.setText("Username");
        createUserPanel.add(usernameLabel);

        usernameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameFieldMouseClicked(evt);
            }
        });
        createUserPanel.add(usernameField);

        passwordLabel.setText("Password");
        createUserPanel.add(passwordLabel);

        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordFieldMouseClicked(evt);
            }
        });
        createUserPanel.add(passwordField);

        nameLabel.setText("Name");
        createUserPanel.add(nameLabel);

        nameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameFieldMouseClicked(evt);
            }
        });
        createUserPanel.add(nameField);

        surnameLabel.setText("Last Name");
        createUserPanel.add(surnameLabel);

        surnameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                surnameFieldMouseClicked(evt);
            }
        });
        createUserPanel.add(surnameField);

        adminRadioButton.setText("System Admin");
        adminRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminRadioButtonActionPerformed(evt);
            }
        });
        createUserPanel.add(adminRadioButton);

        maintainerRadioButton.setText("Maintainer");
        maintainerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintainerRadioButtonActionPerformed(evt);
            }
        });
        createUserPanel.add(maintainerRadioButton);

        plannerRadioButton.setText("Planner");
        plannerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plannerRadioButtonActionPerformed(evt);
            }
        });
        createUserPanel.add(plannerRadioButton);

        insertButton.setText("Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });
        createUserPanel.add(insertButton);

        userList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "USER LIST", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tableUsers.setAutoCreateRowSorter(true);
        tableUsers.setModel(tableModel);
        tableUsers.setRowSelectionAllowed(false);
        tableUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableUsers.getTableHeader().setReorderingAllowed(false);
        tableUsers.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableUsersFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(tableUsers);

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

        javax.swing.GroupLayout userListLayout = new javax.swing.GroupLayout(userList);
        userList.setLayout(userListLayout);
        userListLayout.setHorizontalGroup(
            userListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userListLayout.createSequentialGroup()
                .addGroup(userListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userListLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(modifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userListLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)))
                .addContainerGap())
        );
        userListLayout.setVerticalGroup(
            userListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userListLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyButton)
                    .addComponent(removeButton)))
        );

        viewMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Views", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        viewMenu.setPreferredSize(new java.awt.Dimension(0, 70));
        viewMenu.setRequestFocusEnabled(false);
        viewMenu.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        competenceButton.setText("Competence Management");
        competenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                competenceButtonActionPerformed(evt);
            }
        });
        viewMenu.add(competenceButton);

        accessButton.setText("Access Logs");
        accessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessButtonActionPerformed(evt);
            }
        });
        viewMenu.add(accessButton);

        areaButton.setText("Area Management");
        areaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaButtonActionPerformed(evt);
            }
        });
        viewMenu.add(areaButton);

        activityButton.setText("Activity Management");
        activityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityButtonActionPerformed(evt);
            }
        });
        viewMenu.add(activityButton);

        materialButton.setText("Material Management");
        materialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButtonActionPerformed(evt);
            }
        });
        viewMenu.add(materialButton);

        smpButton.setText("SMP Management");
        smpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smpButtonActionPerformed(evt);
            }
        });
        viewMenu.add(smpButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createUserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            Message.raiseError(this, "Loading error");
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
            Message.raiseError(this, "Username already present!");
            return false;
        }
        if (surname.equals("") || name.equals("") || username.equals("") || password.equals("")) {
            Message.raiseError(this, "There are some empty fields!");
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
            Message.raiseError(this, "No role selected!");
            tableUsers.clearSelection();
            modifyButton.setEnabled(false);
            removeButton.setEnabled(false);
            return;
        }

        insertUser(surname, name, username, password, role);
        tableUsers.clearSelection();
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
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
            Message.raiseError(this, "Username already present!");
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
                Message.raiseError(this, "Modifying role error!");
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
                Message.raiseError(this, "Modifying username error");
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
                Message.raiseError(this, "Modifiying error");
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
            Message.raiseError(this, "Select a cell!");
            return;
        }

        String oldValue = (String) tableUsers.getValueAt(selectedRow, selectedColumn);

        String field = tableModel.getColumnName(selectedColumn);
        String newValue = new String();
        if (field.equals("Role")) {
            String[] options = {"Planner", "Maintainer", "System Admin"};
            int choice = JOptionPane.showOptionDialog(this, "Modify " + field, "Modify", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
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
            newValue = JOptionPane.showInputDialog(this, "Modify " + field, "Modify", JOptionPane.INFORMATION_MESSAGE);
            if (newValue == null || newValue.equals("")) {
                tableUsers.clearSelection();
                modifyButton.setEnabled(false);
                removeButton.setEnabled(false);
                return;
            }
        }

        if (newValue.equalsIgnoreCase(oldValue)) {
            tableUsers.clearSelection();
            modifyButton.setEnabled(false);
            removeButton.setEnabled(false);
            return;
        }

        modifyUser(newValue, selectedRow, selectedColumn);
        tableUsers.clearSelection();
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
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
            Message.raiseError(this, "Removing error!");
        }
        refreshUsers();
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int selectedRow = tableUsers.getSelectedRow();

        if (selectedRow == -1) {
            Message.raiseError(this, "Select a row!");
            return;
        }

        String selectedUsername = (String) tableModel.getValueAt(selectedRow, 2);

        int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove '" + selectedUsername + "' ?", "Remove", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (reply == JOptionPane.YES_OPTION) {
            removeUser(selectedUsername, selectedRow);
        }
        tableUsers.clearSelection();
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
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
        CompetenceView competence = new CompetenceView();
        competence.setVisible(true);
    }//GEN-LAST:event_competenceButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            UserSession.close();
        } catch (SQLException ex) {

        } finally {
            EventQueue.invokeLater(() -> {
                dispose();
                System.exit(0);
            });
        }
    }//GEN-LAST:event_formWindowClosing

    private void accessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessButtonActionPerformed
        AccessView view = new AccessView();
        view.setVisible(true);
    }//GEN-LAST:event_accessButtonActionPerformed

    private void areaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaButtonActionPerformed
        AreaView view = new AreaView();
        view.setVisible(true);
    }//GEN-LAST:event_areaButtonActionPerformed

    private void activityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityButtonActionPerformed
        ActivityView view = new ActivityView(-1);
        view.setVisible(true);
    }//GEN-LAST:event_activityButtonActionPerformed

    private void tableUsersFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableUsersFocusGained
        modifyButton.setEnabled(true);
        removeButton.setEnabled(true);
    }//GEN-LAST:event_tableUsersFocusGained

    private void materialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButtonActionPerformed
        ToolsView view = new ToolsView();
        view.setVisible(true);
    }//GEN-LAST:event_materialButtonActionPerformed

    private void smpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smpButtonActionPerformed
        SMPView view = new SMPView();
        view.setVisible(true);
    }//GEN-LAST:event_smpButtonActionPerformed

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
    private javax.swing.JButton activityButton;
    private javax.swing.JRadioButton adminRadioButton;
    private javax.swing.JButton areaButton;
    private javax.swing.JButton competenceButton;
    private javax.swing.JPanel createUserPanel;
    private javax.swing.JButton insertButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton maintainerRadioButton;
    private javax.swing.JButton materialButton;
    private javax.swing.JButton modifyButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JRadioButton plannerRadioButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton smpButton;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTable tableUsers;
    private javax.swing.JPanel userList;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JPanel viewMenu;
    // End of variables declaration//GEN-END:variables
}
