package com.veltro.stattendance.emailer;

import com.veltro.stattendance.gui.MainPage;

/**
 * EmailTemplates contain prewritten message text to be loaded into the 'Compose' panel in the 'Emailer' tab of the
 * {@link MainPage}
 * 
 * @author LinearLogic
 * @since 0.3.6
 */
public class EmailTemplate {

	private String name;

	/**
	 * The text to be loaded into the subject field (if null, the subject field will be left empty)
	 */
	private String subject;

	/**
	 * The text to be loaded into the message field (if null, the message field will be left empty)
	 */
	private String message;

	/**
	 * Simplified constructor - calls the {@link #EmailTemplate(String, String, String) complete constructor} passing
	 * the provided name string and null subject and message strings
	 * 
	 * @param name The {@link #name} of the template
	 */
	public EmailTemplate(String name) {
		this(name, null, null);
	}

	/**
	 * Complete constructor - initializes all fields
	 * 
	 * @param name The name used to identify the template
	 * @param subject The {@link #subject subject line}
	 * @param message The {@link #message message body}
	 */
	public EmailTemplate(String name, String subject, String message) {
		this.name = (name == null) ? "" : name;
		this.subject = subject;
		this.message = message;
	}

	/**
	 * @return The {@link #name} of the template. Usage of the toString method is mandatory for the list of templates
	 * in the 'General' in the 'Emailer' tab of the {@link MainPage} to properly represent the template.
	 */
	public String toString() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return (subject == null) ? "" : subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return (message == null) ? "" : message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
