package com.veltro.stattendance.gui;

import com.veltro.stattendance.STAttendance;
import com.veltro.stattendance.emailer.EmailMessage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JDialog;
import javax.swing.SwingWorker;

/**
 * A dialog box that is used to show the progress through an email function, namely sending messages or parsing the
 * inbox for received attendance records.
 * 
 * @author LinearLogic
 * @since 0.3.5
 */
public class EmailerProgressDialog extends JDialog implements PropertyChangeListener {

	/**
	 * A queue (FIFO list) of {@link EmailMessage messages} to be sent while the progress box is open
	 */
	private ArrayList<EmailMessage> mailToSend;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel recipientLabel;
    private javax.swing.JLabel sendLabel;
    // End of variables declaration//GEN-END:variables

	/**
	 * Creates new form emailerProgressDialog
	 */
	public EmailerProgressDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		mailToSend = new ArrayList<EmailMessage>();
	}

	/**
	 * Increases the progress bar's value (between 0 and 100, inclusive) by the provided amount. If the progress bar's
	 * value exceeds 100 after an incrementation occurs, the dialog box is automatically closed
	 * 
	 * @param amount The amount by which to increase the progress bar's value (must be greater than zero)
	 */
	public void incrementProgressBar(int amount) {
		if (amount <= 0)
			return;
		int val = progressBar.getValue() + amount;
		progressBar.setValue((val > 100) ? 100 : val);
	}

	/**
	 * Sets up the dialog box to show progress through an email sending task and then sends every email in the
	 * {@link #mailToSend} queue.
	 */
	public void loadInSendMode() {
		setTitle("Sending Email...");
		progressBar.setValue(0);
		sendLabel.setVisible(true);
		recipientLabel.setText("");
		SenderTask task = new SenderTask();
		task.addPropertyChangeListener(this);
		task.execute();
		setEnabled(true);
		setVisible(true);
	}

	/**
	 * Sets up the dialog box to show progress through an inbox parsing task, and then displays the window
	 */
	public void loadInParseMode() {
		setTitle("Parsing Email...");
		progressBar.setValue(0);
		sendLabel.setVisible(false);
		recipientLabel.setText("Parsing inbox/updating data...");
		setEnabled(true);
		setVisible(true);
	}

	/**
	 * Disables the dialog box window and makes it invisible
	 */
	public void close() {
		setEnabled(false);
		setVisible(false);
	}

	/**
	 * Called when the progress bar's 
	 * @param event 
	 */
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals("progress")) {
			int progress = (Integer) event.getNewValue();
			progressBar.setValue(progress);
		}
	}

	/**
	 * Appends the provided {@link EmailMessage} object to the {@link #mailToSend email to be sent}
	 * @param message 
	 */
	public void addMessage(EmailMessage message) {
		mailToSend.add(message);
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
	 * content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sendLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        recipientLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setModal(true);

        sendLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sendLabel.setForeground(new java.awt.Color(0, 0, 255));
        sendLabel.setText("Sending to:");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sendLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(recipientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sendLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recipientLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addGap(9, 9, 9))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO: cancel the current operation in MailMaster
		close();
    }//GEN-LAST:event_cancelButtonActionPerformed

	/**
	 * A task that runs in the background to dispatch all the {@link #mailToSend email to be sent}
	 */
	class SenderTask extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			float incrementAmount = (float) (100.0 / ((mailToSend.size() > 0) ? mailToSend.size() : 1));
			if (incrementAmount <= 100) {
				float progress = 0;
				setProgress(0);
				for (EmailMessage toSend : mailToSend) {
					if (!isEnabled()) // cancel the email transmission
						return null;
					String recipients = Arrays.toString(toSend.getRecipients());
					recipients = recipients.substring(1, recipients.length() - 1);
					recipientLabel.setText(recipients);
					STAttendance.getMailer().sendMessage(toSend);
					progress += incrementAmount;
					setProgress(Math.min((int) progress, 100));
				}
				mailToSend.clear();
			}
			return null;
		}
	
		@Override
		public void done() {
			close();
		}
	}
}
