package com.veltro.stattendance.emailer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * The MailMaster provides email-related functionality, from sending attendance email to handling incoming messages
 * containing class attendance updates.
 * 
 * @author LinearLogic
 * @since 0.1.1
 */
public class MailMaster {

	/**
	 * The Gmail account name (omitting "@gmail.com") used to handle attendance email
	 */
	private final String ACCOUNT;

	/**
	 * The password used to logon to the {@link #ACCOUNT}
	 */
	private final String PASSWORD;

	/**
	 * The special {@link EmailTemplate} used for attendance messages
	 */
	private EmailTemplate attendanceTemplate;

	/**
	 * A list of the currently loaded {@link EmailTemplate} objects
	 */
	private ArrayList<EmailTemplate> templates;

	/**
	 * Initializes the email {@link #ACCOUNT}, {@link #PASSWORD}, and {@link #templates} fields
	 * 
	 * @param account A Gmail username
	 * @param password The password used to authenticate the above account
	 */
	public MailMaster(String account, String password) {
		ACCOUNT = account;
		PASSWORD = password;
		attendanceTemplate = new EmailTemplate("Attendance template");
		templates = new ArrayList<EmailTemplate>();
	}

	/**
	 * Dispatches the provided email message from the {@link #ACCOUNT account} provided at startup. If one of several
	 * possible exceptions is thrown during the transmission process, the method will return a null String[] object.
	 * Otherwise, the method will return a String[] object containing the destination addresses that were invalid.
	 * 
	 * @param message An {@link EmailMessage} object containing the data of the email to be sent
	 * @return A String Array containing the account names (eg. "abc@xyz.com") that the message could not be sent to
	 */
	public String[] sendMessage(EmailMessage message) {

		// Preliminary tests
		if (message.getRecipients().length == 0 || ACCOUNT == null || ACCOUNT.length() < 6 || PASSWORD == null ||
				PASSWORD.length() < 8)
			return null;

		// Set up the email transmission session properties
		String host = "smtp.gmail.com";
	    Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", ACCOUNT);
	    props.put("mail.smtp.password", PASSWORD);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");

	    // Begin the email transmission session and instantiate the message object
	    Session session = Session.getDefaultInstance(props, null);
	    MimeMessage mm = new MimeMessage(session);
	    try {
			mm.setFrom(new InternetAddress(ACCOUNT));
		} catch (AddressException e1) {
			return null;
		} catch (MessagingException e1) {
			return null;
		}

	    // Handle recipient addresses
	    ArrayList<String> failedAddresses = new ArrayList<String>();
	    for (String recipient : message.getRecipients()) {
	    	InternetAddress addr;
			try {
				addr = new InternetAddress(recipient);
			} catch (AddressException e) {
				failedAddresses.add(recipient);
				continue;
			}
	    	try {
				mm.addRecipient(RecipientType.TO, addr);
			} catch (MessagingException e) {
				failedAddresses.add(recipient);
				continue;
			}
	    }
	    try {
			if (mm.getAllRecipients() == null || mm.getAllRecipients().length == 0) {
				String[] output = new String[failedAddresses.size()];
			    int index = 0;
			    for (String addr : failedAddresses)
			    	output[index++] = addr;
			    return output;
			}
		} catch (MessagingException e1) {
			return null;
		}

	    // SEND ALL THE THINGS!!
	    try {
			mm.setSubject(message.getSubject());
			mm.setText(message.getBody());
		} catch (MessagingException e) {
			return null;
		}
	    Transport transport;
		try {
			transport = session.getTransport("smtp");
		} catch (NoSuchProviderException e) {
			return null;
		}
	    try {
			transport.connect(host, ACCOUNT, PASSWORD);
			transport.sendMessage(mm, mm.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			return null;
		}
	    String[] output = new String[failedAddresses.size()];
	    int index = 0;
	    for (String addr : failedAddresses)
	    	output[index++] = addr;
	    return output;
	}

	/**
	 * Loads {@link EmailTemplate} objects from the .txt files stored in the 'Email Template' directory
	 * 
	 * @param templateDir The root email template folder, represented as a File object
	 */
	public void loadTemplates() {
		attendanceTemplate = new EmailTemplate("Attendance template");
		attendanceTemplate.setSubject("Attendance for $DATE");
		attendanceTemplate.setMessage("Mark only students that were absent (mark with an \"A\"), took a cut (\"C\")," +
				" or were late to class (\"L20\" if tardy fifteen minutes, \"L05\" if tardy five, etc.)" +
				"\n\n$ATTENDANCE_LISTS"); // Default attendance email template
		String path = ClassLoader.getSystemClassLoader().getResource(".").getPath();
		try {
			path = URLDecoder.decode(path, "UTF-8");
			if (path.length() < 1)
				return;
		} catch (UnsupportedEncodingException ex) {
			return;
		}
		File templateDir = new File(path, "Email Templates");
		if (!templateDir.exists() || !templateDir.isDirectory()) {
			templateDir.mkdirs();
			return;
		}

		for (File f : templateDir.listFiles()) {
			if (f.isDirectory())
				continue;
			String name = f.getName();
			if (!name.endsWith(".txt")) // TXT files are used to store email templates
				continue;
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) { // This should never happen...
				continue;
			}
			EmailTemplate temp = new EmailTemplate(name.substring(0, name.length() - 4)); // Drop extension for name
			try {
				String subject = br.readLine();
				temp.setSubject(subject);
				StringBuilder message = new StringBuilder();
				String messageLine = br.readLine();
				while (messageLine != null) {
					message.append(messageLine);
					message.append("\n");
					messageLine = br.readLine();
				}
				temp.setMessage(message.toString());
			} catch (IOException e) {
				e.printStackTrace();
				// TODO: log error in program execution log
			} finally {
				if (name.startsWith("Attendance template"))
					attendanceTemplate = temp;
				else
					templates.add(temp);
			}
		}
	}

	/**
	 * Writes each of the currently loaded {@link EmailTemplate} objects to files in the 'Email Templates' directory by
	 * calling the {@link EmailTemplate#saveToFile(File)} for each.
	 */
	public void saveTemplates() {
		String path = ClassLoader.getSystemClassLoader().getResource(".").getPath();
		try {
			path = URLDecoder.decode(path, "UTF-8");
			if (path.length() < 1)
				return;
		} catch (UnsupportedEncodingException ex) {
			return;
		}
		File templateDir = new File(path, "Email Templates");
		if (!templateDir.exists() || !templateDir.isDirectory()) {
			templateDir.mkdirs();
			return;
		}
		attendanceTemplate.saveToFile(new File(templateDir, attendanceTemplate.toString() + ".txt"));
		for (EmailTemplate temp : templates)
			temp.saveToFile(new File(templateDir, temp.toString() + ".txt"));
	}

	public EmailTemplate getAttendanceTemplate() {
		return attendanceTemplate;
	}

	public ArrayList<EmailTemplate> getTemplates() {
		return templates;
	}

	/**
	 * Determines whether the provided Gmail account is valid and if the password is correct
	 * 
	 * @param username The account name (omitting "@gmail.com")
	 * @param password The password to the above account
	 * @return 'true' iff the username and password were successfully verified
	 */
	public static boolean verifyAccount(String username, String password) {
		String host = "smtp.gmail.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, null);
		Transport transport;
		try {
			transport = session.getTransport("smtp");
		} catch (NoSuchProviderException e) { // Failed to bind to SMTP server
			return false;
		}
		try {
			transport.connect(host, username, password);
			transport.close();
		} catch (MessagingException e) { // Account and/or password is invalid
			return false;
		}
		return true;
	}
}
