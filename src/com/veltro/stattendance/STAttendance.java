package com.veltro.stattendance;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.veltro.stattendance.emailer.MailMaster;
import com.veltro.stattendance.gui.pages.LoginPage;
import com.veltro.stattendance.gui.pages.MainPage;

/**
 * Main class - contains the {@link #frame GUI window object} and {@link #main(String[]) program entry point}
 * 
 * @author LinearLogic
 * @version 0.2.3
 */
public class STAttendance {

	/**
	 * The highest-level container of Swing components (the program window)
	 */
	private static JFrame frame;

	/**
	 * The utility class for verifying Gmail accounts, sending email, and parsing received messages
	 */
	private static MailMaster mailer;

	/**
	 * Sets up the {@link #frame GUI window} and sets the active JPanel to the {@link LoginPage}
	 */
	private static void createAndShowGui() {
		frame = new JFrame("STAttendance");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginPage login = new LoginPage();
		frame.getContentPane().add(login);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		login.activateCursor();
	}

	/**
	 * Sets the active JPanel to the {@link MainPage}
	 */
	public static void loadMainPage() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(new MainPage());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Initializes the {@link #mailer} to a MailMaster object with the provided account information
	 * 
	 * @param account The username of the Gmail account to bind to the mailer
	 * @param password The password to the above account
	 */
	public static void loadMailer(String account, String password) {
		mailer = new MailMaster(account, password);
	}

	/**
	 * @return The current {@link #mailer}
	 */
	public static MailMaster getMailer() {
		return mailer;
	}

	/**
	 * Program launch method - starts the GUI thread
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
		}
		catch (ClassNotFoundException e) {
		}
		catch (InstantiationException e) {
		}
		catch (IllegalAccessException e) {
		}
		finally {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					createAndShowGui();
				}
			});
		}
	}
}
