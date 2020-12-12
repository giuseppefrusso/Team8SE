/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.Message;
import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.MultiPanelManager;
import it.unisa.team8se.UserSession;
import it.unisa.team8se.gui.datamodels.ActivityTableDataModel;
import it.unisa.team8se.gui.datamodels.MaintainerAvailabilityDataModel;
import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.Maintainer;
import it.unisa.team8se.models.SMP;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author cptso
 */
public class PlannerForm extends UserBaseForm {

    /**
     * Creates new form ActivityList
     */
    public PlannerForm(int defaultId) {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }
        initComponents();
        setupActivityTable();
        setupMaintainerTable();
        setupTextBoxes();

        if (defaultId != -1) {
            refreshActivities();
            selectedActivity = Activity.getInstanceWithPK(defaultId);
            switchToActivitySummary();
            tabbedPane.setSelectedIndex(1);
        } else {

            switchToActivityList();
        }
    }

    protected Connection getConnection() {
        return DatabaseContext.getConnection();
    }

    protected void closeConnection() {
        DatabaseContext.closeConnection();
    }

    private void setupTextBoxes() {

        interventionDescText.setInputVerifier(new InputVerifier() {
            private final int MAX_LENGTH = 50;

            @Override
            public boolean verify(JComponent input) {
                JTextPane text = (JTextPane) input;
                int texLen = text.getText().length();
                if (texLen > MAX_LENGTH) {
                    JOptionPane.showMessageDialog(PlannerForm.this, "ERRORE: Intervention description must not exceed "
                            + MAX_LENGTH + " characters. (Current Length: " + texLen + ")", "ERROR", JOptionPane.ERROR_MESSAGE);
                    Toolkit.getDefaultToolkit().beep();
                }
                return false;
            }
        });

        interventionDescText.setEditable(false);
        workspaceNotesText.setEditable(false);
    }

    private void setupActivityTable() {
        activities = new LinkedList<>();
        activityTable.setModel(new ActivityTableDataModel(activities));
        ListSelectionModel selectionModel = activityTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.setValueIsAdjusting(true);
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            int selectedRow = activityTable.getSelectedRow();
            if (selectedRow >= 0) {
                activityTableRowSelected(selectedRow);
                activityTable.clearSelection();
            }
        });
    }

    private void setupMaintainerTable() {
        maintainers = new LinkedList<>();
        try {
            Collections.addAll(maintainers, Maintainer.getAllDatabaseInstances());
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nella visualizzazione dei maintainers!");
        }
        maintainerTable.setModel(new MaintainerAvailabilityDataModel(maintainers));
        ListSelectionModel selectionModel = maintainerTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.setValueIsAdjusting(true);
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            int selectedRow = maintainerTable.getSelectedRow();
            if (selectedRow >= 0) {
                try {
                    maintainerTableRowSelected(selectedRow);
                } catch (SQLException ex) {
                    Message.raiseError(this, "Errore nell'assegnazione del maintainer!");
                }
                maintainerTable.clearSelection();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tabbedPane = new javax.swing.JTabbedPane();
        activityList = new javax.swing.JPanel();
        activityListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activityTable = new javax.swing.JTable();
        weeklabel = new javax.swing.JLabel();
        weekNumberLabel = new javax.swing.JLabel();
        activitySummary = new javax.swing.JPanel();
        interventionDescScrollPane = new javax.swing.JScrollPane();
        interventionDescText = new javax.swing.JTextPane();
        interventionDescLabel = new javax.swing.JLabel();
        workspaceNotesLabel = new javax.swing.JLabel();
        workspaceNotesScrollPane = new javax.swing.JScrollPane();
        workspaceNotesText = new javax.swing.JTextPane();
        workspaceNotesEditButton = new javax.swing.JButton();
        interventionDescriptionEditButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        smpButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        areaLabel = new javax.swing.JLabel();
        maintainerListButton = new javax.swing.JButton();
        workspaceNotesDoneButton = new javax.swing.JButton();
        interventionDescDoneButton = new javax.swing.JButton();
        uploadSMPButton = new javax.swing.JButton();
        viewExplorerButton = new javax.swing.JButton();
        manageButton = new javax.swing.JButton();
        maintainerList = new javax.swing.JPanel();
        maintainerScrollPane = new javax.swing.JScrollPane();
        maintainerTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Planner View");
        setIconImage(Message.getImageIcon());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabbedPane.setPreferredSize(new java.awt.Dimension(800, 600));
        tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPaneStateChanged(evt);
            }
        });

        activityList.setPreferredSize(new java.awt.Dimension(800, 600));
        java.awt.GridBagLayout activityListLayout = new java.awt.GridBagLayout();
        activityListLayout.columnWidths = new int[] {0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0};
        activityListLayout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0};
        activityList.setLayout(activityListLayout);

        activityListLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        activityListLabel.setText("ACTIVITY LIST");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activityList.add(activityListLabel, gridBagConstraints);

        activityTable.setAutoCreateRowSorter(true);
        activityTable.setModel(new javax.swing.table.DefaultTableModel(
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
        activityTable.setIntercellSpacing(new java.awt.Dimension(2, 1));
        activityTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(activityTable);
        activityTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 757;
        gridBagConstraints.ipady = 400;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        activityList.add(jScrollPane1, gridBagConstraints);

        weeklabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        weeklabel.setText("Week n#");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activityList.add(weeklabel, gridBagConstraints);

        weekNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        weekNumberLabel.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activityList.add(weekNumberLabel, gridBagConstraints);

        tabbedPane.addTab("ActivityList", activityList);

        activitySummary.setBackground(new java.awt.Color(255, 204, 153));
        java.awt.GridBagLayout activitySummaryLayout = new java.awt.GridBagLayout();
        activitySummaryLayout.columnWidths = new int[] {0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0};
        activitySummaryLayout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        activitySummary.setLayout(activitySummaryLayout);

        interventionDescText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                interventionDescTextFocusLost(evt);
            }
        });
        interventionDescScrollPane.setViewportView(interventionDescText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 238;
        gridBagConstraints.ipady = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        activitySummary.add(interventionDescScrollPane, gridBagConstraints);

        interventionDescLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        interventionDescLabel.setText("Intervention Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(interventionDescLabel, gridBagConstraints);

        workspaceNotesLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        workspaceNotesLabel.setText("WorkSpace Notes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(workspaceNotesLabel, gridBagConstraints);

        workspaceNotesText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                workspaceNotesTextFocusLost(evt);
            }
        });
        workspaceNotesScrollPane.setViewportView(workspaceNotesText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 238;
        gridBagConstraints.ipady = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        activitySummary.add(workspaceNotesScrollPane, gridBagConstraints);

        workspaceNotesEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/edit.png"))); // NOI18N
        workspaceNotesEditButton.setBorder(null);
        workspaceNotesEditButton.setBorderPainted(false);
        workspaceNotesEditButton.setPreferredSize(new java.awt.Dimension(28, 28));
        workspaceNotesEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workspaceNotesEditButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(workspaceNotesEditButton, gridBagConstraints);

        interventionDescriptionEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/edit.png"))); // NOI18N
        interventionDescriptionEditButton.setBorder(null);
        interventionDescriptionEditButton.setBorderPainted(false);
        interventionDescriptionEditButton.setPreferredSize(new java.awt.Dimension(28, 28));
        interventionDescriptionEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interventionDescriptionEditButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(interventionDescriptionEditButton, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ACTIVITY SUMMARY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        activitySummary.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("10");
        jLabel5.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        activitySummary.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Week n#");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        activitySummary.add(jLabel6, gridBagConstraints);

        smpButton.setBackground(new java.awt.Color(255, 255, 255));
        smpButton.setForeground(new java.awt.Color(255, 255, 255));
        smpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/pdf.png"))); // NOI18N
        smpButton.setOpaque(false);
        smpButton.setPreferredSize(new java.awt.Dimension(70, 70));
        smpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smpButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 18;
        activitySummary.add(smpButton, gridBagConstraints);

        jScrollPane2.setEnabled(false);
        jScrollPane2.setFocusable(false);
        jScrollPane2.setRequestFocusEnabled(false);
        jScrollPane2.setWheelScrollingEnabled(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(10);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(3);
        jTextArea1.setText("Standard Mainteinance \nProcedure ");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jTextArea1.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        activitySummary.add(jScrollPane2, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Activity to assign");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        activitySummary.add(jLabel7, gridBagConstraints);

        areaLabel.setBackground(new java.awt.Color(204, 204, 204));
        areaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        areaLabel.setText("Carpentry - Fisciano");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        activitySummary.add(areaLabel, gridBagConstraints);

        maintainerListButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maintainerListButton.setText("Go to Mantainers");
        maintainerListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintainerListButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipady = 20;
        activitySummary.add(maintainerListButton, gridBagConstraints);

        workspaceNotesDoneButton.setText("Done");
        workspaceNotesDoneButton.setEnabled(false);
        workspaceNotesDoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workspaceNotesDoneButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        activitySummary.add(workspaceNotesDoneButton, gridBagConstraints);

        interventionDescDoneButton.setText("Done");
        interventionDescDoneButton.setEnabled(false);
        interventionDescDoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interventionDescDoneButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        activitySummary.add(interventionDescDoneButton, gridBagConstraints);

        uploadSMPButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/upload.png"))); // NOI18N
        uploadSMPButton.setPreferredSize(new java.awt.Dimension(35, 35));
        uploadSMPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadSMPButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        activitySummary.add(uploadSMPButton, gridBagConstraints);

        viewExplorerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/folder.png"))); // NOI18N
        viewExplorerButton.setPreferredSize(new java.awt.Dimension(35, 35));
        viewExplorerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewExplorerButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        activitySummary.add(viewExplorerButton, gridBagConstraints);

        manageButton.setText("Assegna competenze e materiali");
        manageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        activitySummary.add(manageButton, gridBagConstraints);

        tabbedPane.addTab("ActivitySummary", activitySummary);

        java.awt.GridBagLayout maintainerListLayout = new java.awt.GridBagLayout();
        maintainerListLayout.columnWidths = new int[] {0, 6, 0, 6, 0, 6, 0, 6, 0};
        maintainerListLayout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0};
        maintainerList.setLayout(maintainerListLayout);

        maintainerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title1", "Title2"
            }
        ));
        maintainerScrollPane.setViewportView(maintainerTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 752;
        gridBagConstraints.ipady = 474;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        maintainerList.add(maintainerScrollPane, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("MANTAINER LIST");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        maintainerList.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Week n#");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        maintainerList.add(jLabel3, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("10");
        jLabel1.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        maintainerList.add(jLabel1, gridBagConstraints);

        tabbedPane.addTab("MaintainerList", maintainerList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void activityTableRowSelected(int index) {
        selectedActivity = activities.get(index);
        tabbedPane.setSelectedIndex(1);
    }

    private void maintainerTableRowSelected(int index) throws SQLException {
        selectedMaintainer = maintainers.get(index);
        int reply = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler assegnare l'attività '" + selectedActivity.getID() + "' al maintainer '" + selectedMaintainer.getUsername() + "'?", "Assegnamento", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            selectedActivity.assignActivityToMaintainer(selectedMaintainer);
        }
    }

    private void switchToActivityList() {
        refreshActivities();
        tabbedPane.setEnabledAt(1, false);
        tabbedPane.setEnabledAt(2, false);
        selectedActivity = null;
    }

    private void switchToActivitySummary() {
        tabbedPane.setEnabledAt(1, true);
        tabbedPane.setEnabledAt(2, true);

        weekNumberLabel.setText(Integer.toString(selectedActivity.getWeekNumber()));
        areaLabel.setText(selectedActivity.getArea().toString());
        interventionDescText.setText(selectedActivity.getInterventionDescription());
        workspaceNotesText.setText(selectedActivity.getWorkspaceNotes());
    }

    private void switchToMaintainerList() {
        refreshMaintainers();
    }


    private void interventionDescriptionEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interventionDescriptionEditButtonActionPerformed

        int textLength = interventionDescText.getText().length();
        interventionDescText.setCaretPosition(textLength);
        interventionDescText.setEditable(true);
        interventionDescText.requestFocus();

        interventionDescDoneButton.setEnabled(true);
    }//GEN-LAST:event_interventionDescriptionEditButtonActionPerformed

    private void workspaceNotesEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workspaceNotesEditButtonActionPerformed

        int textLength = workspaceNotesText.getText().length();
        workspaceNotesText.setCaretPosition(textLength);
        workspaceNotesText.setEditable(true);
        workspaceNotesText.requestFocus();

        workspaceNotesDoneButton.setEnabled(true);
    }//GEN-LAST:event_workspaceNotesEditButtonActionPerformed

    private void tabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPaneStateChanged
        // TODO add your handling code here:
        int selectedIndex = tabbedPane.getSelectedIndex();
        if (tabbedPane.getTabCount() == 3) {
            switch (selectedIndex) {
                case 0:
                    switchToActivityList();
                    break;
                case 1:
                    switchToActivitySummary();
                    break;
                case 2:
                    switchToMaintainerList();
                    break;
            }
        }
    }//GEN-LAST:event_tabbedPaneStateChanged

    private void maintainerListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintainerListButtonActionPerformed
        tabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_maintainerListButtonActionPerformed

    private void interventionDescTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_interventionDescTextFocusLost
        if (selectedActivity == null) {
            return;
        }

        interventionDescText.setEditable(false);
        interventionDescDoneButton.setEnabled(false);
        selectedActivity.setInterventionDescription(interventionDescText.getText());
        selectedActivity.updateInterventionDescInDatabase();
    }//GEN-LAST:event_interventionDescTextFocusLost

    private void workspaceNotesTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_workspaceNotesTextFocusLost
        if (selectedActivity == null) {
            return;
        }

        workspaceNotesText.setEditable(false);
        workspaceNotesDoneButton.setEnabled(false);
        selectedActivity.setWorkspaceNotes(workspaceNotesText.getText());
        selectedActivity.updateWorkspaceNotesInDatabase();
    }//GEN-LAST:event_workspaceNotesTextFocusLost

    private void interventionDescDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interventionDescDoneButtonActionPerformed
        interventionDescText.setEditable(false);
        interventionDescDoneButton.setEnabled(false);
        selectedActivity.setInterventionDescription(interventionDescText.getText());
        selectedActivity.updateInterventionDescInDatabase();
    }//GEN-LAST:event_interventionDescDoneButtonActionPerformed

    private void workspaceNotesDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workspaceNotesDoneButtonActionPerformed
        workspaceNotesText.setEditable(false);
        workspaceNotesDoneButton.setEnabled(false);
        selectedActivity.setWorkspaceNotes(workspaceNotesText.getText());
        selectedActivity.updateWorkspaceNotesInDatabase();
    }//GEN-LAST:event_workspaceNotesDoneButtonActionPerformed

    private void refreshMaintainers() {
        try {
            Maintainer[] m = Maintainer.getAllDatabaseInstances();
            if (m != null) {
                Collections.addAll(maintainers, m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlannerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshActivities() {
        Activity[] a = Activity.getAllDatabaseInstances();
        if (a != null) {
            Collections.addAll(activities, a);
        }
    }
    private void smpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smpButtonActionPerformed

        SMP smp = selectedActivity.getSmp();
        if (smp != null) {
            smp.openDocument();
        } else {
            Message.raiseInfo(this, "Nessun SMP specificato.");
        }
    }//GEN-LAST:event_smpButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            UserSession.close();
            closeConnection();
            System.exit(0);
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nella chiusura!");
        }
    }//GEN-LAST:event_formWindowClosing

    private void manageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageButtonActionPerformed
        int selectedId = selectedActivity.getID();
        ActivityView view = new ActivityView(selectedId);
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageButtonActionPerformed

    private void uploadSMPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadSMPButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Document (*.pdf)", "pdf");
        fc.setFileFilter(filter);

        int res = fc.showDialog(this, "Load");
        if (res == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            String absPath = f.getAbsolutePath();
            String fileExtension = absPath.substring(absPath.length() - 4, absPath.length());

            if (absPath == null || !fileExtension.equals(".pdf")) {
                System.out.println(fileExtension);
                Message.raiseError(this, "Per favore seleziona un file di tipo PDF.");
                return;
            }

            try {
                SMP smp = new SMP();
                smp.setNome(f.getName());
                smp.importDocument(f.getAbsolutePath());
                if (!smp.existsInDatabase()) {
                    smp.saveToDatabase();
                }

                selectedActivity.setSmp(smp);
                selectedActivity.updateSMPInDatabase();
            } catch (IOException ex) {
                Logger.getLogger(PlannerForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PlannerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_uploadSMPButtonActionPerformed

    private void viewExplorerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewExplorerButtonActionPerformed
        Path p = Paths.get(".\\temp");
        try {
            File directory = new File(p.toUri());
            Desktop.getDesktop().open(directory);
        } catch (IOException ex) {
            Logger.getLogger(PlannerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewExplorerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PlannerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlannerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlannerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlannerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        PlannerForm pf = new PlannerForm(-1);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pf.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel activityList;
    private javax.swing.JLabel activityListLabel;
    private javax.swing.JPanel activitySummary;
    private javax.swing.JTable activityTable;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JButton interventionDescDoneButton;
    private javax.swing.JLabel interventionDescLabel;
    private javax.swing.JScrollPane interventionDescScrollPane;
    private javax.swing.JTextPane interventionDescText;
    private javax.swing.JButton interventionDescriptionEditButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel maintainerList;
    private javax.swing.JButton maintainerListButton;
    private javax.swing.JScrollPane maintainerScrollPane;
    private javax.swing.JTable maintainerTable;
    private javax.swing.JButton manageButton;
    private javax.swing.JButton smpButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton uploadSMPButton;
    private javax.swing.JButton viewExplorerButton;
    private javax.swing.JLabel weekNumberLabel;
    private javax.swing.JLabel weeklabel;
    private javax.swing.JButton workspaceNotesDoneButton;
    private javax.swing.JButton workspaceNotesEditButton;
    private javax.swing.JLabel workspaceNotesLabel;
    private javax.swing.JScrollPane workspaceNotesScrollPane;
    private javax.swing.JTextPane workspaceNotesText;
    // End of variables declaration//GEN-END:variables

    private LinkedList<Activity> activities;
    private LinkedList<Maintainer> maintainers;
    private Activity selectedActivity;
    private Maintainer selectedMaintainer;
    private MultiPanelManager panelManager;
}
