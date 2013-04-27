package com.veltro.stattendance;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Main class - contains the {@link #frame GUI window object} and {@link #main(String[]) program entry point}
 * 
 * @author LinearLogic
 * @version 0.0.1
 */
public class STAttendance {

	/**
	 * The highest-level container of Swing components (the program window)
	 */
	private static JFrame frame;

	/**
	 * Sets up the {@link #frame GUI window}
	 */
	private static void createAndShowGui() {
		frame = new JFrame("STAttendance");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Program launch method - starts the GUI thread
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGui();
			}
		});
	}
}
