package com.veltro.stattendance;

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
}
