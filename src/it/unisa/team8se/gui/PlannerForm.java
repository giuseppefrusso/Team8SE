/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.Message;
import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.DocumentImportWindow;
import it.unisa.team8se.UserSession;
import it.unisa.team8se.gui.datamodels.ActivityTableDataModel;
import it.unisa.team8se.gui.datamodels.MaintainerAvailabilityDataModel;
import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.Competence;
import it.unisa.team8se.models.Maintainer;
import it.unisa.team8se.models.Material;
import it.unisa.team8se.models.SMP;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author cptso
 */
public class PlannerForm extends UserBaseForm {

    private LinkedList<Activity> activities;
    private LinkedList<Maintainer> maintainers;

    private Activity selectedActivity;
    private Maintainer selectedMaintainer;

    private DefaultListModel competenceListModel;
    private DefaultListModel materialListModel;
    private TableRowSorter activityRowSorter;
    private DefaultComboBoxModel<String> weekSelectorModel;

    public PlannerForm(int defaultId) {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }
        initComponents();
        setupActivityTable();
        setupMaintainerTable();
        setupTextBoxes();
        setupCompetenceList();
        setupMaterialList();

        weekSelectorModel = new DefaultComboBoxModel<>();
        weekSelector.setModel(weekSelectorModel);
        
        weekSelector.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                final String weekNumberString = (String)weekSelector.getSelectedItem();
                
                if (weekNumberString.equalsIgnoreCase("all")){
                    activityRowSorter.setRowFilter(null);
                    return;
                }
        
                activityRowSorter.setRowFilter(new RowFilter(){
                    @Override
                    public boolean include(RowFilter.Entry entry) {
                        int index = (int)entry.getIdentifier();
                        int weekNumber = Integer.parseInt(weekNumberString);
                        System.out.println(index);
                        return activities.get(index).getWeekNumber() == weekNumber;
                    }
                });
            }
        });
        
        
        if (defaultId != -1) {
            refreshActivities();
            selectedActivity = Activity.getInstanceWithPK(defaultId);
            switchToActivitySummary();
            tabbedPane.setSelectedIndex(1);
        } else {

            switchToActivityList();
        }
    }

    private void setupCompetenceList() {
        competenceListModel = new DefaultListModel();
        requiredCompetencesList.setModel(competenceListModel);
    }

    private void setupMaterialList() {
        materialListModel = new DefaultListModel();
        requiredMaterialsList.setModel(materialListModel);
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
        
        activityRowSorter = new TableRowSorter(activityTable.getModel());
        activityTable.setRowSorter(activityRowSorter);
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

        tabbedPane = new javax.swing.JTabbedPane();
        activityList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activityTable = new javax.swing.JTable();
        weeklabel = new javax.swing.JLabel();
        acivityListHeader = new javax.swing.JPanel();
        activityListLabel = new javax.swing.JLabel();
        activityButton = new javax.swing.JButton();
        weekSelector = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        activitySummary = new javax.swing.JPanel();
        interventionDescScrollPane = new javax.swing.JScrollPane();
        interventionDescText = new javax.swing.JTextPane();
        interventionDescLabel = new javax.swing.JLabel();
        workspaceNotesLabel = new javax.swing.JLabel();
        workspaceNotesScrollPane = new javax.swing.JScrollPane();
        workspaceNotesText = new javax.swing.JTextPane();
        workspaceNotesEditButton = new javax.swing.JButton();
        interventionDescriptionEditButton = new javax.swing.JButton();
        weekNumberLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        smpButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        areaLabel = new javax.swing.JLabel();
        maintainerListButton = new javax.swing.JButton();
        workspaceNotesDoneButton = new javax.swing.JButton();
        interventionDescDoneButton = new javax.swing.JButton();
        uploadSMPButton = new javax.swing.JButton();
        viewExplorerButton = new javax.swing.JButton();
        manageButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        requirementsContainer = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        requiredCompetencesList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        requiredMaterialsList = new javax.swing.JList<>();
        maintainerList = new javax.swing.JPanel();
        maintainerScrollPane = new javax.swing.JScrollPane();
        maintainerTable = new javax.swing.JTable();
        selectedActivityLabel = new javax.swing.JLabel();
        selectedActivityNameLabel = new javax.swing.JLabel();
        maintainerListHeader = new javax.swing.JPanel();
        maintainerListLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Planner View");
        setIconImage(Message.getImageIcon());
        setPreferredSize(new java.awt.Dimension(800, 800));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabbedPane.setPreferredSize(new java.awt.Dimension(800, 700));
        tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPaneStateChanged(evt);
            }
        });

        activityList.setBackground(new java.awt.Color(255, 204, 153));
        activityList.setPreferredSize(new java.awt.Dimension(600, 600));

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

        weeklabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        weeklabel.setText("Week n#");

        acivityListHeader.setBackground(new java.awt.Color(51, 51, 51));
        acivityListHeader.setLayout(new javax.swing.OverlayLayout(acivityListHeader));

        activityListLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        activityListLabel.setForeground(new java.awt.Color(255, 255, 255));
        activityListLabel.setText("ACTIVITY LIST");
        activityListLabel.setAlignmentX(0.02F);
        acivityListHeader.add(activityListLabel);

        activityButton.setText("Plan");
        activityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityButtonActionPerformed(evt);
            }
        });

        weekSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/cancel_small.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(28, 28));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/search_small.png"))); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(28, 28));

        javax.swing.GroupLayout activityListLayout = new javax.swing.GroupLayout(activityList);
        activityList.setLayout(activityListLayout);
        activityListLayout.setHorizontalGroup(
            activityListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(acivityListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(activityListLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(activityListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(activityListLayout.createSequentialGroup()
                        .addGroup(activityListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(activityListLayout.createSequentialGroup()
                                .addComponent(weeklabel)
                                .addGap(6, 6, 6)
                                .addComponent(weekSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(activityListLayout.createSequentialGroup()
                        .addComponent(activityButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        activityListLayout.setVerticalGroup(
            activityListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activityListLayout.createSequentialGroup()
                .addComponent(acivityListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(activityListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(activityListLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(weeklabel))
                    .addComponent(weekSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(activityListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(activityListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(activityButton)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        tabbedPane.addTab("ActivityList", activityList);

        activitySummary.setBackground(new java.awt.Color(255, 204, 153));
        activitySummary.setPreferredSize(new java.awt.Dimension(800, 800));

        interventionDescText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                interventionDescTextFocusLost(evt);
            }
        });
        interventionDescScrollPane.setViewportView(interventionDescText);

        interventionDescLabel.setBackground(new java.awt.Color(255, 255, 255));
        interventionDescLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        interventionDescLabel.setText("Intervention Description");

        workspaceNotesLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        workspaceNotesLabel.setText("WorkSpace Notes");

        workspaceNotesText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                workspaceNotesTextFocusLost(evt);
            }
        });
        workspaceNotesScrollPane.setViewportView(workspaceNotesText);

        workspaceNotesEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/edit.png"))); // NOI18N
        workspaceNotesEditButton.setBorder(null);
        workspaceNotesEditButton.setBorderPainted(false);
        workspaceNotesEditButton.setPreferredSize(new java.awt.Dimension(28, 28));
        workspaceNotesEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workspaceNotesEditButtonActionPerformed(evt);
            }
        });

        interventionDescriptionEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/edit.png"))); // NOI18N
        interventionDescriptionEditButton.setBorder(null);
        interventionDescriptionEditButton.setBorderPainted(false);
        interventionDescriptionEditButton.setPreferredSize(new java.awt.Dimension(28, 28));
        interventionDescriptionEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interventionDescriptionEditButtonActionPerformed(evt);
            }
        });

        weekNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        weekNumberLabel.setText("10");
        weekNumberLabel.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Week n#");

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Activity to assign:");

        areaLabel.setBackground(new java.awt.Color(204, 204, 204));
        areaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        areaLabel.setText("Carpentry - Fisciano");

        maintainerListButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        maintainerListButton.setText("Select Maintainer");
        maintainerListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintainerListButtonActionPerformed(evt);
            }
        });

        workspaceNotesDoneButton.setText("Done");
        workspaceNotesDoneButton.setEnabled(false);
        workspaceNotesDoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workspaceNotesDoneButtonActionPerformed(evt);
            }
        });

        interventionDescDoneButton.setText("Done");
        interventionDescDoneButton.setEnabled(false);
        interventionDescDoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interventionDescDoneButtonActionPerformed(evt);
            }
        });

        uploadSMPButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/upload.png"))); // NOI18N
        uploadSMPButton.setPreferredSize(new java.awt.Dimension(35, 35));
        uploadSMPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadSMPButtonActionPerformed(evt);
            }
        });

        viewExplorerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/folder.png"))); // NOI18N
        viewExplorerButton.setPreferredSize(new java.awt.Dimension(35, 35));
        viewExplorerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewExplorerButtonActionPerformed(evt);
            }
        });

        manageButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        manageButton.setText("Manage Competencies and Materials");
        manageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Required Competences");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Required Materials");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Standard Mainteinance Procedure");

        header.setBackground(new java.awt.Color(51, 51, 51));
        header.setLayout(new javax.swing.OverlayLayout(header));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ACTIVITY SUMMARY");
        jLabel4.setAlignmentX(0.02F);
        header.add(jLabel4);

        requirementsContainer.setBackground(new java.awt.Color(255, 204, 153));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5);
        flowLayout1.setAlignOnBaseline(true);
        requirementsContainer.setLayout(flowLayout1);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(200, 280));

        requiredCompetencesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "3", "4", "5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(requiredCompetencesList);

        requirementsContainer.add(jScrollPane3);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(200, 280));

        requiredMaterialsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "3", "4", "5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        requiredMaterialsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(requiredMaterialsList);

        requirementsContainer.add(jScrollPane4);

        javax.swing.GroupLayout activitySummaryLayout = new javax.swing.GroupLayout(activitySummary);
        activitySummary.setLayout(activitySummaryLayout);
        activitySummaryLayout.setHorizontalGroup(
            activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(activitySummaryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(activitySummaryLayout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(interventionDescDoneButton)
                                .addGap(322, 322, 322)
                                .addComponent(workspaceNotesDoneButton))
                            .addGroup(activitySummaryLayout.createSequentialGroup()
                                .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(interventionDescScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(activitySummaryLayout.createSequentialGroup()
                                        .addComponent(interventionDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(interventionDescriptionEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(activitySummaryLayout.createSequentialGroup()
                                        .addComponent(workspaceNotesLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(workspaceNotesEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(workspaceNotesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(activitySummaryLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(weekNumberLabel)
                            .addGap(471, 471, 471)
                            .addComponent(manageButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, activitySummaryLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(areaLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maintainerListButton)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(activitySummaryLayout.createSequentialGroup()
                        .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(activitySummaryLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel9))
                            .addComponent(requirementsContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(activitySummaryLayout.createSequentialGroup()
                                .addComponent(smpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uploadSMPButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(viewExplorerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        activitySummaryLayout.setVerticalGroup(
            activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activitySummaryLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(weekNumberLabel)
                    .addComponent(manageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maintainerListButton)
                    .addComponent(areaLabel)
                    .addComponent(jLabel7))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(interventionDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interventionDescriptionEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(workspaceNotesLabel)
                    .addComponent(workspaceNotesEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(interventionDescScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(workspaceNotesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(interventionDescDoneButton)
                    .addComponent(workspaceNotesDoneButton))
                .addGap(29, 29, 29)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(activitySummaryLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(smpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(activitySummaryLayout.createSequentialGroup()
                                .addComponent(uploadSMPButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewExplorerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(activitySummaryLayout.createSequentialGroup()
                        .addGroup(activitySummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(requirementsContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
        );

        tabbedPane.addTab("ActivitySummary", activitySummary);

        maintainerList.setBackground(new java.awt.Color(255, 204, 153));

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

        selectedActivityLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectedActivityLabel.setText("Selected Activity: ");

        selectedActivityNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        selectedActivityNameLabel.setText("xxxxxxx - xxxxxxx");
        selectedActivityNameLabel.setToolTipText("");

        maintainerListHeader.setBackground(new java.awt.Color(51, 51, 51));
        maintainerListHeader.setLayout(new javax.swing.OverlayLayout(maintainerListHeader));

        maintainerListLabel.setBackground(new java.awt.Color(255, 255, 255));
        maintainerListLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        maintainerListLabel.setForeground(new java.awt.Color(255, 255, 255));
        maintainerListLabel.setText("MANTAINER LIST");
        maintainerListLabel.setAlignmentX(0.02F);
        maintainerListHeader.add(maintainerListLabel);

        javax.swing.GroupLayout maintainerListLayout = new javax.swing.GroupLayout(maintainerList);
        maintainerList.setLayout(maintainerListLayout);
        maintainerListLayout.setHorizontalGroup(
            maintainerListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maintainerListLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(maintainerListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(maintainerListLayout.createSequentialGroup()
                        .addComponent(maintainerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(maintainerListLayout.createSequentialGroup()
                        .addComponent(selectedActivityLabel)
                        .addGap(5, 5, 5)
                        .addComponent(selectedActivityNameLabel))))
            .addComponent(maintainerListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        maintainerListLayout.setVerticalGroup(
            maintainerListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maintainerListLayout.createSequentialGroup()
                .addComponent(maintainerListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(maintainerListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectedActivityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(maintainerListLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(selectedActivityNameLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maintainerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPane.addTab("MaintainerList", maintainerList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 826, Short.MAX_VALUE)
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
        refreshRequiredMaterials();
        refreshRequiredCompetences();

        weekNumberLabel.setText(Integer.toString(selectedActivity.getWeekNumber()));
        areaLabel.setText(selectedActivity.getArea().toString());
        interventionDescText.setText(selectedActivity.getInterventionDescription());
        workspaceNotesText.setText(selectedActivity.getWorkspaceNotes());

        tabbedPane.setEnabledAt(1, true);
        tabbedPane.setEnabledAt(2, true);
    }

    private void switchToMaintainerList() {
        refreshMaintainers();

        selectedActivityNameLabel.setText(selectedActivity.getArea().toString());
    }

    private void refreshRequiredMaterials() {
        if (selectedActivity != null) {
            try {
                materialListModel.clear();
                for (Material m : selectedActivity.getUsedMaterialsFromDatabase()) {
                    materialListModel.addElement(m.getName());
                }
            } catch (SQLException ex) {
                Logger.getLogger(PlannerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void refreshRequiredCompetences() {
        if (selectedActivity != null) {
            try {
                competenceListModel.clear();
                for (Competence c : selectedActivity.getRequiredCompetencesFromDatabase()) {
                    competenceListModel.addElement(c.getDescrizione());
                }
            } catch (SQLException ex) {
                Logger.getLogger(PlannerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

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
        activities.clear();
        weekSelectorModel.removeAllElements();
        weekSelectorModel.addElement("All");

        LinkedList<String> weekNumbers = new LinkedList<>();
        Activity[] acts = Activity.getAllDatabaseInstances();
        String currentWeekNumber;

        if (acts != null) {
            for (Activity a : acts) {
                activities.add(a);
                currentWeekNumber = Integer.toString(a.getWeekNumber());
                if (!weekNumbers.contains(currentWeekNumber)) {
                    weekNumbers.add(currentWeekNumber);
                }
            }
            
            weekNumbers.sort((a,b) -> {return  a.compareTo(b);});
            
            for(String w : weekNumbers){
                weekSelectorModel.addElement(w);
            }
        }
    }

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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            UserSession.close();
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nella chiusura!");
        }
    }//GEN-LAST:event_formWindowClosing

    private void activityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityButtonActionPerformed
        ActivityManager view = new ActivityManager();
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_activityButtonActionPerformed

    private void manageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageButtonActionPerformed
        int selectedId = selectedActivity.getID();
        ActivityView view = new ActivityView(selectedId);
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_manageButtonActionPerformed

    private void viewExplorerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewExplorerButtonActionPerformed
        Path p = Paths.get(".\\temp");
        try {
            File directory = new File(p.toUri());
            Desktop.getDesktop().open(directory);
        } catch (IOException ex) {
            Logger.getLogger(PlannerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewExplorerButtonActionPerformed

    private void uploadSMPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadSMPButtonActionPerformed
        File f = DocumentImportWindow.importDocument(this);

        if (f != null) {
            try {
                String absPath = f.getAbsolutePath();
                String fileName = f.getName().substring(0, f.getName().length() - 4);
                System.out.println(fileName);
                SMP smp = new SMP();
                smp.setNome(fileName);
                smp.importDocument(absPath);
                if (!smp.existsInDatabase()) {
                    smp.saveToDatabase();
                }

                selectedActivity.setSmp(smp);
                selectedActivity.updateSMPInDatabase();
            } catch (IOException ex) {
                Logger.getLogger(PlannerForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PlannerForm.class.getName()).log(Level.SEVERE, null, ex);
                Message.raiseError(this, "Errore nel salvataggio del file SMP");
            }
        }
    }//GEN-LAST:event_uploadSMPButtonActionPerformed

    private void interventionDescDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interventionDescDoneButtonActionPerformed
        this.requestFocus();
    }//GEN-LAST:event_interventionDescDoneButtonActionPerformed

    private void workspaceNotesDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workspaceNotesDoneButtonActionPerformed
        this.requestFocus();
    }//GEN-LAST:event_workspaceNotesDoneButtonActionPerformed

    private void maintainerListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintainerListButtonActionPerformed
        tabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_maintainerListButtonActionPerformed

    private void smpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smpButtonActionPerformed

        SMP smp = selectedActivity.getSmp();
        if (smp != null) {
            smp.openDocument();
        } else {
            Message.raiseInfo(this, "Nessun SMP specificato.");
        }
    }//GEN-LAST:event_smpButtonActionPerformed

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

    private void workspaceNotesTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_workspaceNotesTextFocusLost
        if (selectedActivity == null) {
            return;
        }

        workspaceNotesText.setEditable(false);
        workspaceNotesDoneButton.setEnabled(false);
        selectedActivity.setWorkspaceNotes(workspaceNotesText.getText());
        selectedActivity.updateWorkspaceNotesInDatabase();
    }//GEN-LAST:event_workspaceNotesTextFocusLost

    private void interventionDescTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_interventionDescTextFocusLost
        if (selectedActivity == null) {
            return;
        }

        interventionDescText.setEditable(false);
        interventionDescDoneButton.setEnabled(false);
        selectedActivity.setInterventionDescription(interventionDescText.getText());
        selectedActivity.updateInterventionDescInDatabase();
    }//GEN-LAST:event_interventionDescTextFocusLost

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
    private javax.swing.JPanel acivityListHeader;
    private javax.swing.JButton activityButton;
    private javax.swing.JPanel activityList;
    private javax.swing.JLabel activityListLabel;
    private javax.swing.JPanel activitySummary;
    private javax.swing.JTable activityTable;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JPanel header;
    private javax.swing.JButton interventionDescDoneButton;
    private javax.swing.JLabel interventionDescLabel;
    private javax.swing.JScrollPane interventionDescScrollPane;
    private javax.swing.JTextPane interventionDescText;
    private javax.swing.JButton interventionDescriptionEditButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel maintainerList;
    private javax.swing.JButton maintainerListButton;
    private javax.swing.JPanel maintainerListHeader;
    private javax.swing.JLabel maintainerListLabel;
    private javax.swing.JScrollPane maintainerScrollPane;
    private javax.swing.JTable maintainerTable;
    private javax.swing.JButton manageButton;
    private javax.swing.JList<String> requiredCompetencesList;
    private javax.swing.JList<String> requiredMaterialsList;
    private javax.swing.JPanel requirementsContainer;
    private javax.swing.JLabel selectedActivityLabel;
    private javax.swing.JLabel selectedActivityNameLabel;
    private javax.swing.JButton smpButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton uploadSMPButton;
    private javax.swing.JButton viewExplorerButton;
    private javax.swing.JLabel weekNumberLabel;
    private javax.swing.JComboBox<String> weekSelector;
    private javax.swing.JLabel weeklabel;
    private javax.swing.JButton workspaceNotesDoneButton;
    private javax.swing.JButton workspaceNotesEditButton;
    private javax.swing.JLabel workspaceNotesLabel;
    private javax.swing.JScrollPane workspaceNotesScrollPane;
    private javax.swing.JTextPane workspaceNotesText;
    // End of variables declaration//GEN-END:variables

}
