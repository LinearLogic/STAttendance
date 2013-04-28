package com.veltro.stattendance.emailer;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;

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
	 * Initializes the email {@link #ACCOUNT} and {@link #PASSWORD} fields
	 * 
	 * @param account A Gmail username
	 * @param password The password used to authenticate the above account
	 */
	public MailMaster(String account, String password) {
		ACCOUNT = account;
		PASSWORD = password;
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
