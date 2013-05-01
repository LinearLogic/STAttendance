package com.veltro.stattendance.database;

import java.util.HashSet;

/**
 * Represents an upper school teacher at STA. Each teacher has a unique integer ID, contact information, and a list of
 * the ID values of classes he or she teaches.
 * 
 * @author LinearLogic
 * @since 0.2.1
 */
public class Teacher {

	/**
	 * The teacher's unique identification number, issued by the school
	 */
	private int id;

	/**
	 * The teacher's legal last name, as registered with the school
	 */
	private String lastName;

	/**
	 * The teacher's first name, used to differentiate between faculty with identical last names. This field is
	 * optional.
	 */
	private String firstName;

	/**
	 * The teacher's middle name, used to differentiate between faculty with identical first and last names. This
	 * field is optional.
	 */
	private String middleName;

	/**
	 * The email address to which attendance messages should be sent (example: "jheath@cathedral.org")
	 */
	private String email;

	/**
	 * The teacher's cell number, represented however the user chooses. This field is optional.
	 */
	private String phoneNumber;

	/**
	 * A list of the names of classes that the teacher is in charge of
	 */
	private HashSet<String> classes;

	/**
	 * Simplified constructor - requires only the mandatory teacher attributes
	 * 
	 * @param id The teacher's {@link #id ID number}
	 * @param lastName The teacher's {@link #lastName last name}
	 * @param emailAddress The teacher's {@link #email} address, represented as a string in the format "name@site.com"
	 */
	public Teacher(int id, String lastName, String emailAddress) {
		this(id, lastName, "", "", emailAddress, "");
	}

	/**
	 * Complete constructor - includes optional fields
	 * 
	 * @param id The teacher's {@link #id ID number}
	 * @param lastName The teacher's {@link #lastName last name}
	 * @param firstName The teacher's {@link #firstName first name}
	 * @param middleName The teacher's {@link #middleName middle name}
	 * @param emailAddress The teacher's {@link #email} address, represented as a string in the format "name@site.com"
	 * @param phoneNumber A string representation of the teacher's phone number
	 */
	public Teacher(int id, String lastName, String firstName, String middleName, String emailAddress,
			String phoneNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		email = emailAddress;
		this.phoneNumber = phoneNumber;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
	
	public String getLastName() {
		return (lastName == null) ? "" : lastName;
	}
	
	public void setLastName(String name) {
		lastName = name;
	}

	public String getFirstName() {
		return (firstName == null) ? "" : firstName;
	}

	public void setFirstName(String name) {
		firstName = name;
	}

	public String getMiddleName() {
		return (middleName == null) ? "" : middleName;
	}

	public void setMiddleName(String name) {
		middleName = name;
	}

	/**
	 * @return The teacher's {@link #email email address} in the format "name@site.com"
	 */
	public String getEmailAddress() {
		return (email == null) ? "" : email;
	}

	/**
	 * Sets the teacher's {@link #email}
	 * 
	 * @param address A string in the format "name@site.com"
	 */
	public void setEmailAddress(String address) {
		email = address;
	}

	public String getPhoneNumber() {
		return (phoneNumber == null) ? "" : phoneNumber;
	}

	public void setPhoneNumber(String number) {
		phoneNumber = number;
	}

	public String[] getClasses() {
		String[] output = new String[classes.size()];
		int index = 0;
		for (String className : classes)
			output[index++] = className;
		return output;
	}

	public boolean addClass(STAClass c)  {
		return classes.add(c.getName());
	}

	public boolean isInClass(STAClass c) {
		return classes.contains(c.getName());
	}

	public boolean isInClass(String className) {
		return classes.contains(className);
	}

	public boolean addClass(String className) {
		return classes.add(className);
	}

	public boolean removeClass(STAClass c) {
		return classes.remove(c.getName());
	}

	public boolean removeClass(String className) {
		return classes.remove(className);
	}

	public void clearClasses() {
		classes.clear();
	}
}
