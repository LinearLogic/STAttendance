package com.veltro.stattendance.gui;

import com.veltro.stattendance.STAttendance;
import com.veltro.stattendance.database.ClassMaster;
import com.veltro.stattendance.database.STAClass;
import com.veltro.stattendance.database.Student;
import com.veltro.stattendance.database.Teacher;
import javax.swing.ListSelectionModel;

/**
 * A dialog box is used to display a list of classes, teachers, or students from which items can be selected
 * 
 * @author LinearLogic
 * @since 0.4.5
 */
public class EntryListDialog extends javax.swing.JDialog {

	/**
	 * The flag used to determine whether the database should be updated based on the selected items (enables canceling
	 * of entry additions)
	 */
	private boolean addOnExit;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addButton;
	private javax.swing.JList entryList;
	private javax.swing.JScrollPane listScrollPanel;
	// End of variables declaration//GEN-END:variables

	/**
	 * Creates new form EntryListDialog
	 */
	public EntryListDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		addOnExit = false;
	}

	/**
	 * Loads all the {@link STAClass} objects in the {@link ClassMaster database} into the dialog's entry list and sets
	 * the dialog visible and active
	 */
	public void loadWithClasses() {
		setSelectionMode(2);
		setTitle("Add Classes...");
		entryList.setListData(STAttendance.getDatabase().getClasses());
		setEnabled(true);
		setVisible(true);
	}

	/**
	 * Loads all the {@link Teacher} objects in the {@link ClassMaster database} into the dialog's entry list and sets
	 * the dialog visible and active
	 */
	public void loadWithTeachers() {
		setSelectionMode(0);
		setTitle("Add Teachers...");
		entryList.setListData(STAttendance.getDatabase().getTeachers());
		setEnabled(true);
		setVisible(true);
	}
/**
	 * Loads all the {@link Student} objects in the {@link ClassMaster database} into the dialog's entry list and sets
	 * the dialog visible and active
	 */
	public void loadWithStudents() {
		setSelectionMode(2);
		setTitle("Add Students...");
		entryList.setListData(STAttendance.getDatabase().getStudents());
		setEnabled(true);
		setVisible(true);
	}

	/**
	 * Sets the selection mode of the entry list based on the provided integer value: 0 if single item, 1 if single
	 * interval, any other number if multiple intervals.
	 */
	public void setSelectionMode(int intervalCount) {
		switch (intervalCount) {
			case 0:
				entryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				break;
			case 1:
				entryList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				break;
			default:
				entryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				break;
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
	 * content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listScrollPanel = new javax.swing.JScrollPane();
        entryList = new javax.swing.JList();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listScrollPanel.setViewportView(entryList);

        addButton.setText("Add selected items");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(listScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
		addOnExit = true;
		setVisible(false);
		setVisible(false);
    }//GEN-LAST:event_addButtonActionPerformed

	public Object[] getSelectedItems() {
		if (!addOnExit)
			return null;
		return entryList.getSelectedValues();
	}
}
