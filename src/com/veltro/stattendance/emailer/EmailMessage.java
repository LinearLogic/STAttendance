package com.veltro.stattendance.emailer;

import java.util.HashSet;

/**
 * Represents an electronic message to be dispatched by the {@link MailManager}
 * 
 * @author LinearLogic
 * @since 0.1.5
 */
public class EmailMessage {

	/**
	 * A list of the addresses to which this email message should be sent. The list is stored as a set to prevent
	 * duplicate address entries.
	 */
	private HashSet<String> recipients;

	/**
	 * The subject line of the message. No string formatting is supported.
	 */
	private String subject;

	/**
	 * The text contents of the message. Primitive string formatting (/n, /t, etc.) is supported.
	 */
	private String body;

	/**
	 * Generates an empty EmailMessage object. Note that all of the message's fields must be manually instantiated
	 * if this constructor is used.
	 */
	public EmailMessage() {
		this("", "");
	}

	/**
	 * Generates an EmailMessage object and instantiates its subject and body with the provided strings. Note that the
	 * {@link #recipients} list must be populated separately.
	 * 
	 * @param subject The {@link #subject} of the message
	 * @param body The {@link #body} of the message
	 */
	public EmailMessage(String subject, String body) {
		recipients = new HashSet<String>();
		this.subject = (subject == null) ? "" : subject.split("\n")[0];
		this.body = (body == null) ? "" : body;
	}

	/**
	 * @return The message's {@link #recipients list of destination addresses}
	 */
	public String[] getRecipients() {
		String[] output = new String[recipients.size()];
		int index = 0;
		for (String s : recipients)
			output[index++] = s;
		return output;
	}

	/**
	 * Attempts to add the provided address string to the {@link #recipients} set. The address will fail to be added if
	 * it is a duplicate or if it is invalid (does not contain a '@' and a '.').
	 * 
	 * @param address The complete destination email address (eg. "abc@xyz.com")
	 */
	public void addRecipient(String address) {
		if (!address.contains("@") && !address.contains("."))
			return;
		recipients.add(address);
	}

	/**
	 * Removes the provided address string from the {@link #recipients} set if it is present.
	 * 
	 * @param address The complete destination email address (eg. "abc@xyz.com")
	 */
	public void removeRecipient(String address) {
		recipients.remove(address);
	}

	/**
	 * Empties the {@link #recipients list of destination addresses}
	 */
	public void clearRecipients() {
		recipients.clear();
	}

	/**
	 * @return The {@link #subject subject line} of the message
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the message's {@link #subject subject line} to the provided string, truncating it before the first newline
	 * if one is present
	 * 
	 * @param subject A single line
	 */
	public void setSubject(String subject) {
		this.subject = subject.split("\n")[0];
	}

	/**
	 * @return The {@link #body} of the message
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Sets the {@link #body} of the message to the provided string. Newlines are permitted.
	 * 
	 * @param body The text body of the message
	 */
	public void setBody(String body) {
		this.body = body;
	}
}
