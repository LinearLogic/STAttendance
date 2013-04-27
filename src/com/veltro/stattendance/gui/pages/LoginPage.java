package com.veltro.stattendance.gui.pages;

import com.veltro.stattendance.STAttendance;

/**
 * The LoginPage is a JPanel that presents the user with a login screen requesting a Gmail account name and password.
 * It contains two buttons: one to terminate the program and the other to attempt to login using the provided
 * information.
 * 
 * @author LinearLogic
 * @since 0.0.2
 */
public class LoginPage extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountField;
    private javax.swing.JLabel accountLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logonButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton quitButton;
    private javax.swing.JTextArea welcomeText1;
    private javax.swing.JTextArea welcomeText2;
    // End of variables declaration//GEN-END:variables

	/**
     * Creates a new LoginPage panel
     */
    public LoginPage() {
        initComponents();
    }

    /**
     * Initializes the components of the panel
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        quitButton = new javax.swing.JButton();
        logonButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        welcomeText1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        welcomeText2 = new javax.swing.JTextArea();
        passwordLabel = new javax.swing.JLabel();
        accountField = new javax.swing.JTextField();
        accountLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(241, 241, 241));

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        logonButton.setText("Log on");
        logonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logonButtonActionPerformed(evt);
            }
        });

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        welcomeText1.setEditable(false);
        welcomeText1.setBackground(new java.awt.Color(240, 240, 240));
        welcomeText1.setColumns(5);
        welcomeText1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        welcomeText1.setForeground(new java.awt.Color(0, 0, 128));
        welcomeText1.setLineWrap(true);
        welcomeText1.setRows(3);
        welcomeText1.setText("Welcome to the STA class attendance helper!");
        welcomeText1.setBorder(null);
        welcomeText1.setRequestFocusEnabled(false);
        welcomeText1.setSelectedTextColor(new java.awt.Color(0, 0, 128));
        welcomeText1.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(welcomeText1);

        jScrollPane2.setBorder(null);

        welcomeText2.setEditable(false);
        welcomeText2.setBackground(new java.awt.Color(240, 240, 240));
        welcomeText2.setColumns(5);
        welcomeText2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        welcomeText2.setLineWrap(true);
        welcomeText2.setRows(3);
        welcomeText2.setTabSize(4);
        welcomeText2.setText("Please enter your Gmail username and password\n\t\tbelow to get started.");
        welcomeText2.setBorder(null);
        welcomeText2.setRequestFocusEnabled(false);
        welcomeText2.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        welcomeText2.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(welcomeText2);

        passwordLabel.setText("Password:");

        accountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountFieldActionPerformed(evt);
            }
        });

        accountLabel.setText("Account:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(accountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(accountField)
                            .addComponent(passwordField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logonButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitButton)
                    .addComponent(logonButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
    	System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void logonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logonButtonActionPerformed
    	STAttendance.loadMainPage();
    }//GEN-LAST:event_logonButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void accountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountFieldActionPerformed
    }//GEN-LAST:event_accountFieldActionPerformed
}
