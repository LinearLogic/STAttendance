package com.veltro.stattendance.gui;

import com.veltro.stattendance.STAttendance;
import com.veltro.stattendance.database.STAClass;
import com.veltro.stattendance.database.Student;
import com.veltro.stattendance.database.Teacher;
import java.util.ArrayList;

/**
 * A JPanel containing components for displaying and editing {@link STAClass} information in the 'Database' tab
 * 
 * @author LinearLogic
 * @since 0.4.7
 */
public class ClassPanel extends javax.swing.JPanel {

	/**
	 * The unique name of the class currently being displayed
	 */
	private String currentClassName;

	/**
	 * The unique integer ID of the teacher to be set in charge of the current class (if any)
	 */
	private int teacherID;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudentsButton;
    private javax.swing.JButton changeTeacherButton;
    private javax.swing.JLabel classInfoLabel;
    private javax.swing.JPanel classInfoPanel;
    private javax.swing.JSeparator classInfoSeparator;
    private javax.swing.JButton editClassInfoButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JCheckBox periodABox;
    private javax.swing.JCheckBox periodBBox;
    private javax.swing.JCheckBox periodCBox;
    private javax.swing.JCheckBox periodDBox;
    private javax.swing.JCheckBox periodEBox;
    private javax.swing.JCheckBox periodFBox;
    private javax.swing.JLabel periodsLabel;
    private javax.swing.JButton removeStudentButton;
    private javax.swing.JButton removeTeacherButton;
    private javax.swing.JList studentList;
    private javax.swing.JScrollPane studentListScroll;
    private javax.swing.JLabel studentsLabel;
    private javax.swing.JPanel studentsPanel;
    private javax.swing.JSeparator studentsSeparator;
    private javax.swing.JLabel teacherLabel;
    private javax.swing.JLabel teacherNameLabel;
    private javax.swing.JButton viewAttendanceButton;
    // End of variables declaration//GEN-END:variables

	/**
	 * Creates new form ClassPanel
	 */
	public ClassPanel() {
		initComponents();
		disableFields();
	}

	/**
	 * Calls the {@link #loadClassData(STAClass)} method, passing the {@link STAClass} with the provided ID
	 * 
	 * @param className The unique name of the class whose data should be loaded into the panel for editing
	 */
	public void loadClassData(String className) {
		loadClassData(STAttendance.getDatabase().getClass(className));
	}

	/**
	 * Loads a {@link STAClass} object to be displayed/edited, filling in the text fields in the 'Class Info' panel
	 * with the data of the provided class, and sets the {@link #currentClassName} to the name of the class
	 * 
	 * @param c The class to be edited in the panel
	 */
	public void loadClassData(STAClass c) {	
		if (c == null)
			return;
		currentClassName = c.getName();
		nameText.setText(c.getName());
		teacherID = c.getTeacherID();
		Teacher t = STAttendance.getDatabase().getTeacher(c.getTeacherID());
		teacherNameLabel.setText((t == null) ? "none" : t.toString());

		// Load class periods:
		for (byte period : c.getPeriods()) {
			switch(period) {
				case 0:
					periodABox.setSelected(true);
					break;
				case 1:
					periodBBox.setSelected(true);
					break;
				case 2:
					periodCBox.setSelected(true);
					break;
				case 3:
					periodDBox.setSelected(true);
					break;
				case 4:
					periodEBox.setSelected(true);
					break;
				case 5:
					periodFBox.setSelected(true);
				default:
					break;
			}
		}

		// Load students:
		ArrayList<Student> students = new ArrayList<Student>();
		for (int id : c.getStudentIDs()) {
			Student s = STAttendance.getDatabase().getStudent(id);
			if (s != null)
				students.add(s);
		}
		studentList.setListData(students.toArray());
	}

	/**
	 * Updates the class corresponding to the {@link #currentClassID} with the contents of the text fields in the
	 * 'Class Info' panel
	 */
	public void saveClassData() {
		STAClass c = STAttendance.getDatabase().getClass(currentClassName);
		if (c.getTeacherID() != teacherID) { // The teacher of the class has been changed - updated the database
			Teacher newTeacher = STAttendance.getDatabase().getTeacher(teacherID);
			if (newTeacher != null)
				STAttendance.getDatabase().addClassToTeacher(c, newTeacher);
		}
		c.setTeacherID(teacherID);

		// Update class periods:
		ArrayList<Byte> periodList = new ArrayList<Byte>();
		if (periodABox.isSelected())
			periodList.add((byte) 0);
		if (periodBBox.isSelected())
			periodList.add((byte) 1);
		if (periodCBox.isSelected())
			periodList.add((byte) 2);
		if (periodDBox.isSelected())
			periodList.add((byte) 3);
		if (periodEBox.isSelected())
			periodList.add((byte) 4);
		if (periodFBox.isSelected())
			periodList.add((byte) 5);
		byte[] periods = new byte[periodList.size()];
		for (int i = 0; i < periods.length; i++)
			periods[i] = periodList.get(i);
		c.setPeriods(periods);

		if (!currentClassName.equals(nameText.getText())) { // The class directory must be edited
			c.setName(nameText.getText());
			STAttendance.getDatabase().addClass(c);
			STAttendance.getDatabase().removeClass(currentClassName);
			currentClassName = nameText.getText();
			try {
				STAttendance.getDatabase().getTeacher(c.getTeacherID()).addClass(currentClassName);
			} catch (NullPointerException e) {}
			for (int id : c.getStudentIDs()) {
				try {
					STAttendance.getDatabase().getStudent((Integer) id).addClass(currentClassName);
				} catch (NullPointerException e) {
					continue;
				}
			}
		}
	}

	/**
	 * Enables editing of the contents of the text fields in the 'Class Info' panel
	 */
	public void enableFields() {
		nameText.setEnabled(true);
		periodABox.setEnabled(true);
		periodBBox.setEnabled(true);
		periodCBox.setEnabled(true);
		periodDBox.setEnabled(true);
		periodEBox.setEnabled(true);
		periodFBox.setEnabled(true);
		changeTeacherButton.setEnabled(true);
		removeTeacherButton.setEnabled(true);
	}

	/**
	 * Disables editing of the contents of the text fields in the 'Class Info' panel
	 */
	public void disableFields() {
		nameText.setEnabled(false);
		periodABox.setEnabled(false);
		periodBBox.setEnabled(false);
		periodCBox.setEnabled(false);
		periodDBox.setEnabled(false);
		periodEBox.setEnabled(false);
		periodFBox.setEnabled(false);
		changeTeacherButton.setEnabled(false);
		removeTeacherButton.setEnabled(false);
	}

	/**
	 * Clears the contents of the text fields in the 'Class Info' panel
	 */
	public void clearContactInfoFields() {
		nameText.setText(null);
		periodABox.setSelected(false);
		periodBBox.setSelected(false);
		periodCBox.setSelected(false);
		periodDBox.setSelected(false);
		periodEBox.setSelected(false);
		periodFBox.setSelected(false);
		teacherNameLabel.setText(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
	 * content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        classInfoPanel = new javax.swing.JPanel();
        classInfoLabel = new javax.swing.JLabel();
        classInfoSeparator = new javax.swing.JSeparator();
        nameLabel = new javax.swing.JLabel();
        periodsLabel = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        editClassInfoButton = new javax.swing.JButton();
        periodABox = new javax.swing.JCheckBox();
        periodBBox = new javax.swing.JCheckBox();
        periodCBox = new javax.swing.JCheckBox();
        periodDBox = new javax.swing.JCheckBox();
        periodEBox = new javax.swing.JCheckBox();
        periodFBox = new javax.swing.JCheckBox();
        teacherLabel = new javax.swing.JLabel();
        teacherNameLabel = new javax.swing.JLabel();
        changeTeacherButton = new javax.swing.JButton();
        removeTeacherButton = new javax.swing.JButton();
        studentsPanel = new javax.swing.JPanel();
        studentsLabel = new javax.swing.JLabel();
        studentsSeparator = new javax.swing.JSeparator();
        addStudentsButton = new javax.swing.JButton();
        removeStudentButton = new javax.swing.JButton();
        studentListScroll = new javax.swing.JScrollPane();
        studentList = new javax.swing.JList();
        viewAttendanceButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(448, 524));

        classInfoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));

        classInfoLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        classInfoLabel.setText("Class Information");

        nameLabel.setText("Name:");

        periodsLabel.setText("Periods:");

        editClassInfoButton.setText("Edit");
        editClassInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editClassInfoButtonActionPerformed(evt);
            }
        });

        periodABox.setText("A");

        periodBBox.setText("B");

        periodCBox.setText("C");

        periodDBox.setText("D");

        periodEBox.setText("E");

        periodFBox.setText("F");

        teacherLabel.setText("Teacher:");

        changeTeacherButton.setText("Change teacher...");
        changeTeacherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTeacherButtonActionPerformed(evt);
            }
        });

        removeTeacherButton.setText("Remove teacher");
        removeTeacherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTeacherButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout classInfoPanelLayout = new javax.swing.GroupLayout(classInfoPanel);
        classInfoPanel.setLayout(classInfoPanelLayout);
        classInfoPanelLayout.setHorizontalGroup(
            classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, classInfoPanelLayout.createSequentialGroup()
                .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(classInfoPanelLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(editClassInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(classInfoPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(periodsLabel))
                    .addGroup(classInfoPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, classInfoPanelLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(teacherNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(teacherLabel)
                            .addGroup(classInfoPanelLayout.createSequentialGroup()
                                .addComponent(changeTeacherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeTeacherButton, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addGap(55, 55, 55)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(classInfoPanelLayout.createSequentialGroup()
                        .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(periodABox)
                            .addComponent(periodCBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(periodBBox)
                            .addComponent(periodDBox)))
                    .addGroup(classInfoPanelLayout.createSequentialGroup()
                        .addComponent(periodEBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(periodFBox)))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, classInfoPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(classInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classInfoSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162))
        );
        classInfoPanelLayout.setVerticalGroup(
            classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(classInfoLabel)
                .addGap(0, 0, 0)
                .addComponent(classInfoSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(classInfoPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editClassInfoButton)
                        .addContainerGap())
                    .addGroup(classInfoPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(classInfoPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(teacherLabel)
                                    .addComponent(teacherNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(changeTeacherButton)
                                    .addComponent(removeTeacherButton)))
                            .addGroup(classInfoPanelLayout.createSequentialGroup()
                                .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nameLabel)
                                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(periodsLabel)
                                    .addComponent(periodABox)
                                    .addComponent(periodBBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(periodCBox)
                                    .addComponent(periodDBox))
                                .addGap(0, 0, 0)
                                .addGroup(classInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(periodEBox)
                                    .addComponent(periodFBox))))
                        .addGap(0, 44, Short.MAX_VALUE))))
        );

        studentsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));
        studentsPanel.setPreferredSize(new java.awt.Dimension(418, 312));

        studentsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        studentsLabel.setText("Students");

        addStudentsButton.setText("Add students...");
        addStudentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentsButtonActionPerformed(evt);
            }
        });

        removeStudentButton.setText("Remove selected student");
        removeStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStudentButtonActionPerformed(evt);
            }
        });

        studentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        studentListScroll.setViewportView(studentList);

        viewAttendanceButton.setText("View attendance records for selected student...");
        viewAttendanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAttendanceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentsPanelLayout = new javax.swing.GroupLayout(studentsPanel);
        studentsPanel.setLayout(studentsPanelLayout);
        studentsPanelLayout.setHorizontalGroup(
            studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsPanelLayout.createSequentialGroup()
                .addGroup(studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentsPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(studentListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(studentsPanelLayout.createSequentialGroup()
                                .addComponent(addStudentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(removeStudentButton))
                            .addComponent(viewAttendanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(studentsPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(studentsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, studentsPanelLayout.createSequentialGroup()
                            .addGap(187, 187, 187)
                            .addComponent(studentsLabel))))
                .addContainerGap())
        );
        studentsPanelLayout.setVerticalGroup(
            studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentsLabel)
                .addGap(0, 0, 0)
                .addComponent(studentsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStudentsButton)
                    .addComponent(removeStudentButton))
                .addGap(18, 18, 18)
                .addComponent(studentListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewAttendanceButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(classInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(studentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editClassInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editClassInfoButtonActionPerformed
		if (editClassInfoButton.getText().equals("Save")) {
			disableFields();
			saveClassData();
			editClassInfoButton.setText("Edit");
			return;
		}
		enableFields();
		editClassInfoButton.setText("Save");
    }//GEN-LAST:event_editClassInfoButtonActionPerformed

    private void changeTeacherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeTeacherButtonActionPerformed
        EntryListDialog teacherList = new EntryListDialog(STAttendance.getFrame(), true);
		teacherList.loadWithTeachers();
		Object[] teachers = teacherList.getSelectedItems();
		if (teachers == null)
			return;
		Teacher t = (Teacher) teachers[0];
		teacherID = t.getID();
		teacherNameLabel.setText(t.toString());
    }//GEN-LAST:event_changeTeacherButtonActionPerformed

    private void removeTeacherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTeacherButtonActionPerformed
        teacherID = -1;
		teacherNameLabel.setText("none");
    }//GEN-LAST:event_removeTeacherButtonActionPerformed

    private void addStudentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentsButtonActionPerformed
		EntryListDialog studentListDialog = new EntryListDialog(STAttendance.getFrame(), true);
		studentListDialog.loadWithStudents();
		Object[] studentObjs = studentListDialog.getSelectedItems();
		if (studentObjs == null || studentObjs.length == 0)
			return;
		STAClass c = STAttendance.getDatabase().getClass(currentClassName);
		if (c == null)
			return;
		for (Object studentObj : studentObjs)
			STAttendance.getDatabase().addStudentToClass((Student) studentObj, c);
		// Reload student list:
		ArrayList<Student> students = new ArrayList<Student>();
		for (int id : c.getStudentIDs()) {
			Student s = STAttendance.getDatabase().getStudent(id);
			if (s != null)
				students.add(s);
		}
		studentList.setListData(students.toArray());
    }//GEN-LAST:event_addStudentsButtonActionPerformed

    private void removeStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeStudentButtonActionPerformed
		if (studentList.getSelectedIndex() == -1)
			return;
		STAClass c = STAttendance.getDatabase().getClass(currentClassName);
		Student s = (Student) studentList.getSelectedValue();
		if (c == null || s == null)
			return;
		STAttendance.getDatabase().removeStudentFromClass(s, c);
		// Reload student list:
		ArrayList<Student> students = new ArrayList<Student>();
		for (int id : c.getStudentIDs()) {
			s = STAttendance.getDatabase().getStudent(id);
			if (s != null)
				students.add(s);
		}
		studentList.setListData(students.toArray());
    }//GEN-LAST:event_removeStudentButtonActionPerformed

    private void viewAttendanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAttendanceButtonActionPerformed
        // TODO: open attendance dialog
    }//GEN-LAST:event_viewAttendanceButtonActionPerformed
}
