package com.veltro.stattendance.gui;

import com.veltro.stattendance.STAttendance;
import com.veltro.stattendance.emailer.MailMaster;

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
    private javax.swing.JLabel accTooShortLabel;
    private javax.swing.JTextField accountField;
    private javax.swing.JLabel accountLabel;
    private javax.swing.JLabel authErrorLabel;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logonButton;
    private javax.swing.JLabel passTooShortLabel;
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
		accTooShortLabel.setVisible(false);
		passTooShortLabel.setVisible(false);
		authErrorLabel.setVisible(false);
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
        accTooShortLabel = new javax.swing.JLabel();
        passTooShortLabel = new javax.swing.JLabel();
        authErrorLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));

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
        welcomeText1.setRows(1);
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
        welcomeText2.setRows(2);
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

        accTooShortLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accTooShortLabel.setForeground(new java.awt.Color(128, 0, 0));
        accTooShortLabel.setText("Too short!");

        passTooShortLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        passTooShortLabel.setForeground(new java.awt.Color(128, 0, 0));
        passTooShortLabel.setText("Too short!");

        authErrorLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        authErrorLabel.setForeground(new java.awt.Color(128, 0, 0));
        authErrorLabel.setText("Authentication error");

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
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(passwordLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(logonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(passwordField)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(accountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(authErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(accountField))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(accTooShortLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(passTooShortLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(authErrorLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountLabel)
                    .addComponent(accountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accTooShortLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passTooShortLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitButton)
                    .addComponent(logonButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * Moves the cursor to the {@link #accountField}
	 */
	public void activateCursor() {
		accountField.requestFocusInWindow();
	}

	/**
	 * Checks to ensure that the account and password fields have been filled in, and then switches to a loading screen
	 * while verifying the provided Gmail account and (if the verification was successful) loading the database.
	 */
	private void switchToMainPage() {
		String user = accountField.getText();
		String pass = String.valueOf(passwordField.getPassword());
		accTooShortLabel.setVisible(false);
		passTooShortLabel.setVisible(false);
		authErrorLabel.setVisible(false);
		if (user == null || user.length() < 6) { // Gmail usernames must be at least six characters in length
			accTooShortLabel.setVisible(true);
			accountField.setText(null);
			passwordField.setText(null);
			accountField.requestFocusInWindow();
			return;
		}
		if (pass == null || pass.length() < 8) { // Gmail passwords must contain at least eight characters
			passTooShortLabel.setVisible(true);
			passwordField.setText(null);
			passwordField.requestFocusInWindow();
			return;
		}
		if (!MailMaster.verifyAccount(user, pass)) {
			passwordField.setText(null);
			passwordField.requestFocusInWindow();
			authErrorLabel.setVisible(true);
			return;
		}
		STAttendance.loadMailer(user, pass);
		STAttendance.loadMainPage();
	}

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
    	System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void logonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logonButtonActionPerformed
    	switchToMainPage();
    }//GEN-LAST:event_logonButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        switchToMainPage();
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void accountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountFieldActionPerformed
        passwordField.requestFocusInWindow();
    }//GEN-LAST:event_accountFieldActionPerformed
}
