package com.veltro.stattendance.gui.pages;

/**
 * The MainPage JPanel is the hub of user activity. Its functions are separated into three tabs--one for accessing the
 * database, one for using the emailer, and one for generating export files.
 * 
 * @author LinearLogic
 * @since 0.0.3
 */
public class MainPage extends javax.swing.JPanel{

    /**
     * Creates a new MainPage panel
     */
    public MainPage() {
        initComponents();
    }

    /**
     * Initializes the components of the panel
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailerTab = new javax.swing.JTabbedPane();
        emailerPanel = new javax.swing.JPanel();
        sendPanel = new javax.swing.JPanel();
        greenPanel = new javax.swing.JPanel();
        greenSendButton = new javax.swing.JButton();
        greenTitle = new javax.swing.JLabel();
        greenSeparator = new javax.swing.JSeparator();
        greenEditButton = new javax.swing.JButton();
        generalPanel = new javax.swing.JPanel();
        generalTitle = new javax.swing.JLabel();
        generalSeparator = new javax.swing.JSeparator();
        generalComposeButton = new javax.swing.JButton();
        generalTemplateMenu = new javax.swing.JComboBox();
        generalTemplateLabel = new javax.swing.JLabel();
        generalEditTemplatesButton = new javax.swing.JButton();
        receivePanel = new javax.swing.JPanel();
        receiveButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        receiveInfo1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        receiveInfo2 = new javax.swing.JTextArea();
        composePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        composeRecipientsText = new javax.swing.JTextArea();
        composeRecipientsLabel = new javax.swing.JLabel();
        composeSubjectLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        composeSubjectText = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        composeMessageText = new javax.swing.JTextArea();
        composeActionPanel = new javax.swing.JPanel();
        composeSendButton = new javax.swing.JButton();
        composeDiscardButton = new javax.swing.JButton();

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

        greenEditButton.setText("Edit attendance email template...");
        greenEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenEditButtonActionPerformed(evt);
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
                .addComponent(greenEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(greenEditButton)
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

        generalTemplateMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blank message" }));
        generalTemplateMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalTemplateMenuActionPerformed(evt);
            }
        });

        generalTemplateLabel.setText("Choose a template:");

        generalEditTemplatesButton.setText("Edit templates...");

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
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(generalEditTemplatesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
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
                .addGap(30, 30, 30)
                .addComponent(generalEditTemplatesButton)
                .addGap(15, 15, 15))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(generalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        receivePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Parse Incoming Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 128))); // NOI18N
        receivePanel.setPreferredSize(new java.awt.Dimension(300, 164));

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
        composeRecipientsText.setRows(2);
        composeRecipientsText.setTabSize(4);
        composeRecipientsText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jScrollPane1.setViewportView(composeRecipientsText);

        composeRecipientsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        composeRecipientsLabel.setText("Send to:");

        composeSubjectLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        composeSubjectLabel.setText("Subject:");

        composeSubjectText.setColumns(20);
        composeSubjectText.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        composeSubjectText.setRows(2);
        composeSubjectText.setTabSize(4);
        composeSubjectText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jScrollPane2.setViewportView(composeSubjectText);

        composeMessageText.setColumns(20);
        composeMessageText.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        composeMessageText.setRows(2);
        composeMessageText.setTabSize(4);
        composeMessageText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        jScrollPane5.setViewportView(composeMessageText);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, composePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addGroup(composePanelLayout.createSequentialGroup()
                        .addComponent(composeActionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(composeSubjectLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(composeRecipientsLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        composePanelLayout.setVerticalGroup(
            composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(composePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(composePanelLayout.createSequentialGroup()
                        .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(composeRecipientsLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(composePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(composeSubjectLabel)))
                    .addComponent(composeActionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5)
                .addContainerGap())
        );

        javax.swing.GroupLayout emailerPanelLayout = new javax.swing.GroupLayout(emailerPanel);
        emailerPanel.setLayout(emailerPanelLayout);
        emailerPanelLayout.setHorizontalGroup(
            emailerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emailerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(receivePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addComponent(sendPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(receivePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        emailerTab.addTab("Emailer", emailerPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emailerTab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emailerTab)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void receiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiveButtonActionPerformed

    }//GEN-LAST:event_receiveButtonActionPerformed

    private void generalTemplateMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalTemplateMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generalTemplateMenuActionPerformed

    private void generalComposeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalComposeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generalComposeButtonActionPerformed

    private void greenEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenEditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_greenEditButtonActionPerformed

    private void greenSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenSendButtonActionPerformed

    }//GEN-LAST:event_greenSendButtonActionPerformed

    private void composeSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_composeSendButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_composeSendButtonActionPerformed

    private void composeDiscardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_composeDiscardButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_composeDiscardButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel composeActionPanel;
    private javax.swing.JButton composeDiscardButton;
    private javax.swing.JTextArea composeMessageText;
    private javax.swing.JPanel composePanel;
    private javax.swing.JLabel composeRecipientsLabel;
    private javax.swing.JTextArea composeRecipientsText;
    private javax.swing.JButton composeSendButton;
    private javax.swing.JLabel composeSubjectLabel;
    private javax.swing.JTextArea composeSubjectText;
    private javax.swing.JPanel emailerPanel;
    private javax.swing.JTabbedPane emailerTab;
    private javax.swing.JButton generalComposeButton;
    private javax.swing.JButton generalEditTemplatesButton;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JSeparator generalSeparator;
    private javax.swing.JLabel generalTemplateLabel;
    private javax.swing.JComboBox generalTemplateMenu;
    private javax.swing.JLabel generalTitle;
    private javax.swing.JButton greenEditButton;
    private javax.swing.JPanel greenPanel;
    private javax.swing.JButton greenSendButton;
    private javax.swing.JSeparator greenSeparator;
    private javax.swing.JLabel greenTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton receiveButton;
    private javax.swing.JTextArea receiveInfo1;
    private javax.swing.JTextArea receiveInfo2;
    private javax.swing.JPanel receivePanel;
    private javax.swing.JPanel sendPanel;
    // End of variables declaration//GEN-END:variables
}
