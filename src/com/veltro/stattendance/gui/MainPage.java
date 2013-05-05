package com.veltro.stattendance.gui;

import com.veltro.stattendance.STAttendance;
import com.veltro.stattendance.emailer.EmailMessage;
import com.veltro.stattendance.emailer.EmailTemplate;
import java.awt.CardLayout;
import javax.swing.JFrame;

/**
 * The MainPage JPanel is the hub of user activity. Its functions are separated into three tabs--one for accessing the
 * database, one for using the emailer, and one for generating export files.
 * 
 * @author LinearLogic
 * @since 0.0.3
 */
public class MainPage extends javax.swing.JPanel{

	private boolean editingAttendanceTemplate = false;

	private EmailerProgressDialog emailerProgressBox;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel composeActionPanel;
    private javax.swing.JButton composeDiscardButton;
    private javax.swing.JScrollPane composeMessageScroll;
    private javax.swing.JTextArea composeMessageText;
    private javax.swing.JPanel composePanel;
    private javax.swing.JLabel composeRecipientsLabel;
    private javax.swing.JScrollPane composeRecipientsScroll;
    private javax.swing.JTextArea composeRecipientsText;
    private javax.swing.JButton composeSendButton;
    private javax.swing.JLabel composeSubjectLabel;
    private javax.swing.JScrollPane composeSubjectScroll;
    private javax.swing.JTextArea composeSubjectText;
    private javax.swing.JPanel databasePanel;
    private javax.swing.JPanel editPanel;
    private javax.swing.JPanel emailerPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton generalComposeButton;
    private javax.swing.JButton generalEditTemplateButton;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JSeparator generalSeparator;
    private javax.swing.JLabel generalTemplateLabel;
    private javax.swing.JComboBox generalTemplateMenu;
    private javax.swing.JLabel generalTitle;
    private javax.swing.JButton greenEditTemplateButton;
    private javax.swing.JPanel greenPanel;
    private javax.swing.JButton greenSendButton;
    private javax.swing.JSeparator greenSeparator;
    private javax.swing.JLabel greenTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton manageAddClassButton;
    private javax.swing.JButton manageAddStudentButton;
    private javax.swing.JButton manageAddTeacherButton;
    private javax.swing.JButton manageClearButton;
    private javax.swing.JButton manageDeleteButton;
    private javax.swing.JPanel managePanel;
    private javax.swing.JSeparator manageSeparator;
    private javax.swing.JTabbedPane masterTabPane;
    private javax.swing.JButton receiveButton;
    private javax.swing.JTextArea receiveInfo1;
    private javax.swing.JTextArea receiveInfo2;
    private javax.swing.JPanel receivePanel;
    private javax.swing.JPanel sendPanel;
    private javax.swing.JList viewEntryList;
    private javax.swing.JPanel viewPanel;
    private javax.swing.JLabel viewSortByLabel;
    private javax.swing.JComboBox viewSortByMenu;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates a new MainPage panel
     */
    public MainPage() {
        initComponents();
		emailerProgressBox = new EmailerProgressDialog(STAttendance.getFrame(), true);
		hideComposePanel();
		generalTemplateMenu.addItem(new EmailTemplate("Blank message"));
		for (EmailTemplate template : STAttendance.getMailer().getTemplates())
			generalTemplateMenu.addItem(template);
    }

	/**
	 * Sets the contents of the 'Compose' panel in the 'Emailer' tab to be visible, and updates the text fields with
	 * the values stored in the currently selected {@link EmailTemplate}. The {@link #generalComposeButton} is also
	 * disabled.
	 */
	public void loadComposePanel() {
		generalComposeButton.setEnabled(false);
		composeActionPanel.setVisible(true);

		composeRecipientsText.setText(null);
		EmailTemplate toLoad;
		if (editingAttendanceTemplate)
			toLoad = STAttendance.getMailer().getAttendanceTemplate();
		else
			toLoad = (EmailTemplate) generalTemplateMenu.getSelectedItem();
		composeSubjectText.setText(toLoad.getSubject().toString());
		composeMessageText.setText(toLoad.getMessage().toString());

		composeRecipientsLabel.setVisible(true);
		composeRecipientsText.setVisible(true);
		composeRecipientsScroll.setVisible(true);

		composeSubjectLabel.setVisible(true);
		composeSubjectText.setVisible(true);
		composeSubjectScroll.setVisible(true);

		composeMessageText.setVisible(true);
		composeMessageScroll.setVisible(true);
	}

	/**
	 * Hides the contents of the 'Compose' panel in the 'Emailer' tab. The {@link #generalComposeButton} is also
	 * disabled.
	 */
	public void hideComposePanel() {
		clearComposePanel();
		composeActionPanel.setVisible(false);

		composeRecipientsLabel.setVisible(false);
		composeRecipientsText.setVisible(false);
		composeRecipientsScroll.setVisible(false);

		composeSubjectLabel.setVisible(false);
		composeSubjectText.setVisible(false);
		composeSubjectScroll.setVisible(false);

		composeMessageText.setVisible(false);
		composeMessageScroll.setVisible(false);
	}

	/*
	 * Clears the contents of the text fields in the 'Compose' panel of the 'Emailer' tab
	 */
	public void clearComposePanel() {
		composeRecipientsText.setText(null);
		composeSubjectText.setText(null);
		composeMessageText.setText(null);
	}

	/**
	 * Enables the interactive components in the 'Send Email' and 'Parse Incoming Email' panels
	 */
	public void enableButtons() {
		greenSendButton.setEnabled(true);
		greenEditTemplateButton.setEnabled(true);
		generalComposeButton.setEnabled(true);
		generalTemplateMenu.setEnabled(true);
		generalEditTemplateButton.setEnabled(true);
		receiveButton.setEnabled(true);
	}

	/**
	 * Disables the interactive components in the 'Send Email' and 'Parse Incoming Email' panels
	 */
	public void disableButtons() {
		greenSendButton.setEnabled(false);
		greenEditTemplateButton.setEnabled(false);
		generalComposeButton.setEnabled(false);
		generalTemplateMenu.setEnabled(false);
		generalEditTemplateButton.setEnabled(false);
		receiveButton.setEnabled(false);
	}

	/**
	 * Constructs the {@link #progressBox} with the provided values
	 * 
	 * @param parent The JFrame that is to contain the dialog box
	 * @param modal Whether the dialog should be modal (if modal, underlying GUI components cannot be interacted with)
	 */
	public void loadEmailerProgressBox(JFrame parent, boolean modal) {
		emailerProgressBox = new EmailerProgressDialog(parent, modal);
	}

    /**
     * Initializes the components of the panel
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        masterTabPane = new javax.swing.JTabbedPane();
        databasePanel = new javax.swing.JPanel();
        viewPanel = new javax.swing.JPanel();
        viewSortByLabel = new javax.swing.JLabel();
        viewSortByMenu = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewEntryList = new javax.swing.JList();
        managePanel = new javax.swing.JPanel();
        manageAddTeacherButton = new javax.swing.JButton();
        manageAddStudentButton = new javax.swing.JButton();
        manageAddClassButton = new javax.swing.JButton();
        manageDeleteButton = new javax.swing.JButton();
        manageClearButton = new javax.swing.JButton();
        manageSeparator = new javax.swing.JSeparator();
        editPanel = new javax.swing.JPanel();
        emailerPanel = new javax.swing.JPanel();
        sendPanel = new javax.swing.JPanel();
        greenPanel = new javax.swing.JPanel();
        greenSendButton = new javax.swing.JButton();
        greenTitle = new javax.swing.JLabel();
        greenSeparator = new javax.swing.JSeparator();
        greenEditTemplateButton = new javax.swing.JButton();
        generalPanel = new javax.swing.JPanel();
        generalTitle = new javax.swing.JLabel();
        generalSeparator = new javax.swing.JSeparator();
        generalComposeButton = new javax.swing.JButton();
        generalTemplateMenu = new javax.swing.JComboBox();
        generalTemplateLabel = new javax.swing.JLabel();
        generalEditTemplateButton = new javax.swing.JButton();
        receivePanel = new javax.swing.JPanel();
        receiveButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        receiveInfo1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        receiveInfo2 = new javax.swing.JTextArea();
        composePanel = new javax.swing.JPanel();
        composeRecipientsScroll = new javax.swing.JScrollPane();
        composeRecipientsText = new javax.swing.JTextArea();
        composeRecipientsLabel = new javax.swing.JLabel();
        composeSubjectLabel = new javax.swing.JLabel();
        composeSubjectScroll = new javax.swing.JScrollPane();
        composeSubjectText = new javax.swing.JTextArea();
        composeMessageScroll = new javax.swing.JScrollPane();
        composeMessageText = new javax.swing.JTextArea();
        composeActionPanel = new javax.swing.JPanel();
        composeSendButton = new javax.swing.JButton();
        composeDiscardButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(120, 0), new java.awt.Dimension(120, 0), new java.awt.Dimension(120, 32767));

        viewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "View Entries", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 128))); // NOI18N
        viewPanel.setPreferredSize(new java.awt.Dimension(302, 354));

        viewSortByLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        viewSortByLabel.setText("Sort by:");

        viewSortByMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Teacher", "Student", "Class" }));

        viewEntryList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(viewEntryList);

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addGroup(viewPanelLayout.createSequentialGroup()
                        .addComponent(viewSortByLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewSortByMenu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewSortByLabel)
                    .addComponent(viewSortByMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        managePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Manage Entries", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 128))); // NOI18N
        managePanel.setPreferredSize(new java.awt.Dimension(300, 182));

        manageAddTeacherButton.setText("Add a teacher");

        manageAddStudentButton.setText("Add a student");
        manageAddStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAddStudentButtonActionPerformed(evt);
            }
        });

        manageAddClassButton.setText("Add a class");
        manageAddClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAddClassButtonActionPerformed(evt);
            }
        });

        manageDeleteButton.setText("Delete selected entry");

        manageClearButton.setForeground(new java.awt.Color(128, 0, 0));
        manageClearButton.setText("Clear all entries of the selected type");
        manageClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageClearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout managePanelLayout = new javax.swing.GroupLayout(managePanel);
        managePanel.setLayout(managePanelLayout);
        managePanelLayout.setHorizontalGroup(
            managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(managePanelLayout.createSequentialGroup()
                        .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(managePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(manageAddClassButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(manageDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(manageSeparator)
                            .addGroup(managePanelLayout.createSequentialGroup()
                                .addComponent(manageAddTeacherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(manageAddStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managePanelLayout.createSequentialGroup()
                        .addComponent(manageClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        managePanelLayout.setVerticalGroup(
            managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageAddTeacherButton)
                    .addComponent(manageAddStudentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageAddClassButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manageDeleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageClearButton)
                .addContainerGap())
        );

        editPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Edit Entry", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 128))); // NOI18N
        editPanel.setPreferredSize(new java.awt.Dimension(460, 550));
        editPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout databasePanelLayout = new javax.swing.GroupLayout(databasePanel);
        databasePanel.setLayout(databasePanelLayout);
        databasePanelLayout.setHorizontalGroup(
            databasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databasePanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(databasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(managePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(editPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
        databasePanelLayout.setVerticalGroup(
            databasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databasePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(databasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(databasePanelLayout.createSequentialGroup()
                        .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14)
                        .addComponent(managePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        masterTabPane.addTab("Database", databasePanel);

        sendPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Send Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 128))); // NOI18N

        greenPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));

        greenSendButton.setText("Send attendance email to all teachers");
        greenSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenSendButtonActionPerformed(evt);
            }
        });

        greenTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        greenTitle.setForeground(new java.awt.Color(0, 100, 0));
        greenTitle.setText("Green Attendance");

        greenEditTemplateButton.setText("Edit attendance email template...");
        greenEditTemplateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenEditTemplateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout greenPanelLayout = new javax.swing.GroupLayout(greenPanel);
        greenPanel.setLayout(greenPanelLayout);
        greenPanelLayout.setHorizontalGroup(
            greenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(greenPanelLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(greenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(greenSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greenTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
            .addGroup(greenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(greenSendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(greenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(greenEditTemplateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        greenPanelLayout.setVerticalGroup(
            greenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(greenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(greenTitle)
                .addGap(0, 0, 0)
                .addComponent(greenSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(greenSendButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(greenEditTemplateButton)
                .addGap(15, 15, 15))
        );

        generalPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));

        generalTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        generalTitle.setForeground(new java.awt.Color(64, 0, 0));
        generalTitle.setText("General");

        generalComposeButton.setText("Compose new message...");
        generalComposeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalComposeButtonActionPerformed(evt);
            }
        });

        generalTemplateMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalTemplateMenuActionPerformed(evt);
            }
        });

        generalTemplateLabel.setText("Choose a template:");

        generalEditTemplateButton.setText("Edit current template...");
        generalEditTemplateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalEditTemplateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(generalComposeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generalPanelLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(generalTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(generalSeparator)))
                            .addGroup(generalPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(generalTemplateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generalTemplateMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(generalEditTemplateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generalTitle)
                .addGap(0, 0, 0)
                .addComponent(generalSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(generalComposeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generalTemplateMenu)
                    .addComponent(generalTemplateLabel))
                .addGap(26, 26, 26)
                .addComponent(generalEditTemplateButton)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout sendPanelLayout = new javax.swing.GroupLayout(sendPanel);
        sendPanel.setLayout(sendPanelLayout);
        sendPanelLayout.setHorizontalGroup(
            sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(greenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        sendPanelLayout.setVerticalGroup(
            sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(greenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(generalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        receivePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Parse Incoming Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 128))); // NOI18N
        receivePanel.setPreferredSize(new java.awt.Dimension(302, 164));

        receiveButton.setText("Parse Inbox");
        receiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiveButtonActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(null);

        receiveInfo1.setEditable(false);
        receiveInfo1.setBackground(new java.awt.Color(240, 240, 240));
        receiveInfo1.setColumns(5);
        receiveInfo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        receiveInfo1.setLineWrap(true);
        receiveInfo1.setRows(3);
        receiveInfo1.setTabSize(4);
        receiveInfo1.setText("Click the button below to update the database\n   with attendance records contained in email\n\tmessages received from teachers.");
        receiveInfo1.setBorder(null);
        receiveInfo1.setRequestFocusEnabled(false);
        receiveInfo1.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        receiveInfo1.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(receiveInfo1);

        jScrollPane4.setBorder(null);

        receiveInfo2.setEditable(false);
        receiveInfo2.setBackground(new java.awt.Color(240, 240, 240));
        receiveInfo2.setColumns(5);
        receiveInfo2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        receiveInfo2.setLineWrap(true);
        receiveInfo2.setRows(1);
        receiveInfo2.setTabSize(4);
        receiveInfo2.setText("After being parsed, messages are deleted from\t\t  the Gmail inbox.");
        receiveInfo2.setBorder(null);
        receiveInfo2.setRequestFocusEnabled(false);
        receiveInfo2.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        receiveInfo2.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(receiveInfo2);

        javax.swing.GroupLayout receivePanelLayout = new javax.swing.GroupLayout(receivePanel);
        receivePanel.setLayout(receivePanelLayout);
        receivePanelLayout.setHorizontalGroup(
            receivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receivePanelLayout.createSequentialGroup()
                .addGroup(receivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receivePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(receivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(receivePanelLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(receiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        receivePanelLayout.setVerticalGroup(
            receivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receivePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(receiveButton)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        composePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Compose", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 128))); // NOI18N

        composeRecipientsText.setColumns(20);
        composeRecipientsText.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        composeRecipientsText.setLineWrap(true);
        composeRecipientsText.setRows(2);
        composeRecipientsText.setTabSize(4);
        composeRecipientsText.setWrapStyleWord(true);
        composeRecipientsText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        composeRecipientsScroll.setViewportView(composeRecipientsText);

        composeRecipientsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        composeRecipientsLabel.setText("Send to:");

        composeSubjectLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        composeSubjectLabel.setText("Subject:");

        composeSubjectText.setColumns(20);
        composeSubjectText.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        composeSubjectText.setLineWrap(true);
        composeSubjectText.setRows(2);
        composeSubjectText.setTabSize(4);
        composeSubjectText.setWrapStyleWord(true);
        composeSubjectText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        composeSubjectScroll.setViewportView(composeSubjectText);

        composeMessageText.setColumns(20);
        composeMessageText.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        composeMessageText.setLineWrap(true);
        composeMessageText.setRows(2);
        composeMessageText.setTabSize(4);
        composeMessageText.setWrapStyleWord(true);
        composeMessageText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        composeMessageScroll.setViewportView(composeMessageText);

        composeActionPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        composeSendButton.setText("Send");
        composeSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                composeSendButtonActionPerformed(evt);
            }
        });

        composeDiscardButton.setText("Discard");
        composeDiscardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                composeDiscardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout composeActionPanelLayout = new javax.swing.GroupLayout(composeActionPanel);
        composeActionPanel.setLayout(composeActionPanelLayout);
        composeActionPanelLayout.setHorizontalGroup(
            composeActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(composeActionPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(composeActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(composeSendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(composeDiscardButton))
                .addGap(4, 4, 4))
        );
        composeActionPanelLayout.setVerticalGroup(
            composeActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, composeActionPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(composeSendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(composeDiscardButton)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout composePanelLayout = new javax.swing.GroupLayout(composePanel);
        composePanel.setLayout(composePanelLayout);
        composePanelLayout.setHorizontalGroup(
            composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(composePanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(composeMessageScroll, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, composePanelLayout.createSequentialGroup()
                        .addComponent(composeActionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(composeSubjectLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(composeRecipientsLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(composeRecipientsScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(composeSubjectScroll))))
                .addGap(10, 10, 10))
        );
        composePanelLayout.setVerticalGroup(
            composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(composePanelLayout.createSequentialGroup()
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(composeRecipientsLabel)
                        .addComponent(composeActionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(composePanelLayout.createSequentialGroup()
                        .addComponent(composeRecipientsScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(composeSubjectLabel)
                            .addComponent(composeSubjectScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(composeMessageScroll)
                .addContainerGap())
        );

        javax.swing.GroupLayout emailerPanelLayout = new javax.swing.GroupLayout(emailerPanel);
        emailerPanel.setLayout(emailerPanelLayout);
        emailerPanelLayout.setHorizontalGroup(
            emailerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailerPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(emailerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(receivePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(composePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
        emailerPanelLayout.setVerticalGroup(
            emailerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emailerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(composePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(emailerPanelLayout.createSequentialGroup()
                        .addComponent(sendPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(receivePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        masterTabPane.addTab("Emailer", emailerPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(masterTabPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(masterTabPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void receiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiveButtonActionPerformed
		for (EmailTemplate t : STAttendance.getMailer().getTemplates())
			System.out.println(t.getSubject());
		emailerProgressBox.loadInParseMode();
    }//GEN-LAST:event_receiveButtonActionPerformed

    private void generalTemplateMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalTemplateMenuActionPerformed
    }//GEN-LAST:event_generalTemplateMenuActionPerformed

    private void generalComposeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalComposeButtonActionPerformed
		disableButtons();
		loadComposePanel();
    }//GEN-LAST:event_generalComposeButtonActionPerformed

    private void greenEditTemplateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenEditTemplateButtonActionPerformed
		disableButtons();
		composeSendButton.setText("Save");
		editingAttendanceTemplate = true;
		loadComposePanel();
    }//GEN-LAST:event_greenEditTemplateButtonActionPerformed

    private void greenSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenSendButtonActionPerformed
		emailerProgressBox.loadInSendMode();
    }//GEN-LAST:event_greenSendButtonActionPerformed

    private void composeSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_composeSendButtonActionPerformed
		if (composeSendButton.getText().equals("Save")) {

			String subject = composeSubjectText.getText(), message = composeMessageText.getText();
			if (editingAttendanceTemplate) {
				STAttendance.getMailer().getAttendanceTemplate().setSubject((subject == null) ? "" : subject);
				STAttendance.getMailer().getAttendanceTemplate().setMessage((message == null) ? "" : message);
				editingAttendanceTemplate = false;
			} else {
				EmailTemplate template = (EmailTemplate) generalTemplateMenu.getSelectedItem();
				if (!template.toString().equals("Blank message")) { // Prevent editing of the blank template
					template.setSubject((subject == null) ? "" : subject);
					template.setMessage((message == null) ? "" : message);
				}
			}

			hideComposePanel();
			composeSendButton.setText("Send");
			enableButtons();
			return;
		}

		if (composeRecipientsText.getText() == null || composeRecipientsText.getText().length() < 6) // no recipients
			return;
		EmailMessage mail = new EmailMessage(composeSubjectText.getText(), composeMessageText.getText());
		for (String recipient : composeRecipientsText.getText().split(";")) {
			recipient = recipient.trim();
			if (recipient.length() < 6) // "a@a.co" is the shortest email address possible
				continue;
			mail.addRecipient(recipient);
		}
		hideComposePanel();
		enableButtons();
		emailerProgressBox.addMessage(mail);
		emailerProgressBox.loadInSendMode();
    }//GEN-LAST:event_composeSendButtonActionPerformed

    private void composeDiscardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_composeDiscardButtonActionPerformed
		if (composeSendButton.getText().equals("Save")) {
			editingAttendanceTemplate = false;
			composeSendButton.setText("Send");
		}
		hideComposePanel();
		enableButtons();
    }//GEN-LAST:event_composeDiscardButtonActionPerformed

    private void generalEditTemplateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalEditTemplateButtonActionPerformed
		composeSendButton.setText("Save");
		disableButtons();
		loadComposePanel();
    }//GEN-LAST:event_generalEditTemplateButtonActionPerformed

    private void manageAddStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAddStudentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageAddStudentButtonActionPerformed

    private void manageAddClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAddClassButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageAddClassButtonActionPerformed

    private void manageClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageClearButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageClearButtonActionPerformed
}
