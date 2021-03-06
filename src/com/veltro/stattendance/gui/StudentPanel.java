package com.veltro.stattendance.gui;

import com.veltro.stattendance.STAttendance;
import com.veltro.stattendance.database.STAClass;
import com.veltro.stattendance.database.Student;

/**
 * A JPanel containing components for displaying and editing {@link Student} information in the 'Database' tab
 * 
 * @author LinearLogic
 * @since 0.4.6
 */
public class StudentPanel extends javax.swing.JPanel {

	/**
	 * The unique integer ID of the student currently being displayed
	 */
	private int currentStudentID;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClassesButton;
    private javax.swing.JList classList;
    private javax.swing.JScrollPane classListScroll;
    private javax.swing.JLabel classesLabel;
    private javax.swing.JPanel classesPanel;
    private javax.swing.JSeparator classesSeparator;
    private javax.swing.JLabel contactInfoLabel;
    private javax.swing.JPanel contactInfoPanel;
    private javax.swing.JSeparator contactInfoSeparator;
    private javax.swing.JButton editContactInfoButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameText;
    private javax.swing.JLabel formNumberLabel;
    private javax.swing.JTextField formNumberText;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameText;
    private javax.swing.JLabel middleNameLabel;
    private javax.swing.JTextField middleNameText;
    private javax.swing.JButton removeClassButton;
    // End of variables declaration//GEN-END:variables

	/**
	 * Creates new form StudentPanel
	 */
	public StudentPanel() {
		initComponents();
		disableFields();
	}

	/**
	 * Calls the {@link #loadStudent(Student)} method, passing the {@link Student} with the provided ID
	 * 
	 * @param studentID The unique ID number of the student whose data should be loaded into the panel for editing
	 */
	public void loadStudentData(int studentID) {
		loadStudentData(STAttendance.getDatabase().getStudent(studentID));
	}

	/**
	 * Loads a {@link Student} object to be displayed/edited, filling in the text fields in the 'Contact Info' panel
	 * with the data of the provided student, and sets the {@link #currentStudentID} to the student's unique ID number
	 * 
	 * @param s The student to be edited in the panel
	 */
	public void loadStudentData(Student s) {	
		if (s == null)
			return;
		currentStudentID = s.getID();
		firstNameText.setText(s.getFirstName());
		middleNameText.setText(s.getMiddleName());
		lastNameText.setText(s.getLastName()); 
		idText.setText(Integer.toString(s.getID()));
		formNumberText.setText(Byte.toString(s.getFormNumber()));
		classList.setListData(s.getClasses());
	}

	/**
	 * Updates the student corresponding to the {@link #currentStudentID} with the contents of the text fields in the
	 * 'Contact Info' panel
	 */
	public void saveStudentData() {
		Student s = STAttendance.getDatabase().getStudent(currentStudentID);
		if (s == null)
			return;
		s.setFirstName(firstNameText.getText());
		s.setMiddleName(middleNameText.getText());
		s.setLastName(lastNameText.getText());

		// Update the student's form number:
		try {
			int formNum = Integer.parseInt(formNumberText.getText());
			if (formNum < 3 || formNum > 6) { // An invalid form number has been entered
				formNumberText.setText(Byte.toString(s.getFormNumber()));
				return;
			}
			s.setFormNumber((byte) formNum);
		} catch (NumberFormatException e) {
			formNumberText.setText(Byte.toString(s.getFormNumber()));
		}

		// Update the student's ID number:
		try {
			int id = Integer.parseInt(idText.getText());
			if (id != s.getID()) { // The student directory must be updated
				int oldID = s.getID();
				s.setID(id);
				STAttendance.getDatabase().addStudent(s);
				STAttendance.getDatabase().removeStudent(oldID);
			}
		} catch (NumberFormatException e) {
			idText.setText(Integer.toString(s.getID()));
		}
	}

	/**
	 * Enables editing of the contents of the text fields in the 'Contact Info' panel
	 */
	public void enableFields() {
		firstNameText.setEnabled(true);
		middleNameText.setEnabled(true);
		lastNameText.setEnabled(true);
		idText.setEnabled(true);
		formNumberText.setEnabled(true);
	}

	/**
	 * Disables editing of the contents of the text fields in the 'Contact Info' panel
	 */
	public void disableFields() {
		firstNameText.setEnabled(false);
		middleNameText.setEnabled(false);
		lastNameText.setEnabled(false);
		idText.setEnabled(false);
		formNumberText.setEnabled(false);
	}

	/**
	 * Clears the contents of the text fields in the 'Contact Info' panel
	 */
	public void clearContactInfoFields() {
		firstNameText.setText(null);
		middleNameText.setText(null);
		lastNameText.setText(null);
		idText.setText(null);
		formNumberText.setText(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
	 * content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contactInfoPanel = new javax.swing.JPanel();
        contactInfoLabel = new javax.swing.JLabel();
        contactInfoSeparator = new javax.swing.JSeparator();
        firstNameLabel = new javax.swing.JLabel();
        firstNameText = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameText = new javax.swing.JTextField();
        middleNameText = new javax.swing.JTextField();
        middleNameLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        formNumberLabel = new javax.swing.JLabel();
        editContactInfoButton = new javax.swing.JButton();
        formNumberText = new javax.swing.JTextField();
        classesPanel = new javax.swing.JPanel();
        classesLabel = new javax.swing.JLabel();
        classesSeparator = new javax.swing.JSeparator();
        addClassesButton = new javax.swing.JButton();
        removeClassButton = new javax.swing.JButton();
        classListScroll = new javax.swing.JScrollPane();
        classList = new javax.swing.JList();

        setPreferredSize(new java.awt.Dimension(448, 524));

        contactInfoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));

        contactInfoLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        contactInfoLabel.setText("Contact Information");

        firstNameLabel.setText("First name:");

        lastNameLabel.setText("Last name:");

        middleNameLabel.setText("Middle name:");

        idLabel.setText("ID number:");

        formNumberLabel.setText("Form number:");

        editContactInfoButton.setText("Edit");
        editContactInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editContactInfoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contactInfoPanelLayout = new javax.swing.GroupLayout(contactInfoPanel);
        contactInfoPanel.setLayout(contactInfoPanelLayout);
        contactInfoPanelLayout.setHorizontalGroup(
            contactInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactInfoPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(firstNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(middleNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(middleNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lastNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(contactInfoPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(formNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactInfoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contactInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactInfoPanelLayout.createSequentialGroup()
                        .addComponent(editContactInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactInfoPanelLayout.createSequentialGroup()
                        .addGroup(contactInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(contactInfoSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(154, 154, 154))))
        );
        contactInfoPanelLayout.setVerticalGroup(
            contactInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contactInfoLabel)
                .addGap(0, 0, 0)
                .addComponent(contactInfoSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(contactInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(middleNameLabel)
                    .addComponent(middleNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contactInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formNumberLabel)
                    .addComponent(formNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(editContactInfoButton)
                .addContainerGap())
        );

        classesPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));

        classesLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        classesLabel.setText("Classes");

        addClassesButton.setText("Add classes...");
        addClassesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassesButtonActionPerformed(evt);
            }
        });

        removeClassButton.setText("Remove selected class");
        removeClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeClassButtonActionPerformed(evt);
            }
        });

        classList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        classListScroll.setViewportView(classList);

        javax.swing.GroupLayout classesPanelLayout = new javax.swing.GroupLayout(classesPanel);
        classesPanel.setLayout(classesPanelLayout);
        classesPanelLayout.setHorizontalGroup(
            classesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, classesPanelLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(classesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(classesSeparator)
                    .addComponent(classesLabel))
                .addGap(191, 191, 191))
            .addGroup(classesPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(classesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(classListScroll)
                    .addGroup(classesPanelLayout.createSequentialGroup()
                        .addComponent(addClassesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(removeClassButton)))
                .addGap(20, 20, 20))
        );
        classesPanelLayout.setVerticalGroup(
            classesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(classesLabel)
                .addGap(0, 0, 0)
                .addComponent(classesSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(classesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addClassesButton)
                    .addComponent(removeClassButton))
                .addGap(18, 18, 18)
                .addComponent(classListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contactInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(classesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editContactInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editContactInfoButtonActionPerformed
		if (editContactInfoButton.getText().equals("Save")) {
			disableFields();
			saveStudentData();
			editContactInfoButton.setText("Edit");
			return;
		}
		enableFields();
		editContactInfoButton.setText("Save");
    }//GEN-LAST:event_editContactInfoButtonActionPerformed

    private void addClassesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassesButtonActionPerformed
		EntryListDialog classListDialog = new EntryListDialog(STAttendance.getFrame(), true);
		classListDialog.loadWithClasses();
		Object[] classObjs = classListDialog.getSelectedItems();
		if (classObjs == null || classObjs.length == 0)
			return;
		Student s = STAttendance.getDatabase().getStudent(currentStudentID);
		for (Object classObj : classObjs)
			STAttendance.getDatabase().addStudentToClass(s, (STAClass) classObj);
		classList.setListData(s.getClasses()); // Update class list
    }//GEN-LAST:event_addClassesButtonActionPerformed

    private void removeClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeClassButtonActionPerformed
		if (classList.getSelectedIndex() == -1)
			return;
		Student s = STAttendance.getDatabase().getStudent(currentStudentID);
		STAClass c = STAttendance.getDatabase().getClass((String) classList.getSelectedValue());
		if (s == null || c == null)
			return;
		STAttendance.getDatabase().removeStudentFromClass(s, c);
		classList.setListData(s.getClasses());
    }//GEN-LAST:event_removeClassButtonActionPerformed
}
