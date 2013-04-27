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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
