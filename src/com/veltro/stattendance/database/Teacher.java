package com.veltro.stattendance.database;

/**
 * Represents an upper school teacher at STA. Each teacher has a unique integer ID, contact information, and a list of
 * classes he or she teaches.
 * 
 * @author LinearLogic
 * @since 0.2.1
 */
public class Teacher {

	/**
	 * The teacher's unique ID number, issued by the school
	 */
	private int id;

	/**
	 * This field is optional
	 */
	private String firstName;

	/**
	 * The teacher's legal last name, as registered with the school
	 */
	private String lastName;

	/**
	 * The email address to which attendance messages should be sent (example: "jheath@cathedral.org")
	 */
	private String email;

	/**
	 * The teacher's cell number, represented however the user chooses. This field is optional.
	 */
	private String phoneNumber;

	/**
	 * Simple constructor - requires only the mandatory teacher attributes
	 * 
	 * @param id The teacher's {@link #id} number
	 * @param lastName The teacher's {@link #lastName last name}
	 * @param emailAddress The teacher's {@link #email} address, represented as a string in the format "name@site.com"
	 */
	public Teacher(int id, String lastName, String emailAddress) {
		this(id, "", lastName, emailAddress, "");
	}

	/**
	 * Complete constructor - includes optional fields
	 * 
	 * @param id The teacher's {@link #id} number
	 * @param firstName The teacher's {@link #firstName first name}
	 * @param lastName The teacher's {@link #lastName last name}
	 * @param emailAddress The teacher's {@link #email} address, represented as a string in the format "name@site.com"
	 * @param phoneNumber A string representation of the teacher's phone number
	 */
	public Teacher(int id, String firstName, String lastName, String emailAddress, String phoneNumber) {
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

	public String getFirstName() {
		return (firstName == null) ? "" : firstName;
	}

	public void setFirstName(String name) {
		firstName = name;
	}

	public String getLastName() {
		return (lastName == null) ? "" : lastName;
	}

	public void setLastName(String name) {
		lastName = name;
	}

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
}
