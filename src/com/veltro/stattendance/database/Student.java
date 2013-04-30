package com.veltro.stattendance.database;

/**
 * Represents an upper school student at STA. Each student has a unique integer ID, contact information, a form (grade)
 * number stored as a byte, and a list of the ID values of classes he is enrolled in.
 * 
 * @author LinearLogic
 * @since 0.2.2
 */
public class Student {

	/**
	 * The student's unique identification number, issued by the school
	 */
	private int id;

	/**
	 * The student's legal last name, as registered with the school
	 */
	private String lastName;

	/**
	 * The student's first name, as registered with the school
	 */
	private String firstName;

	/**
	 * The student's middle name, used to differentiate between students with identical first and last names. This
	 * field is optional.
	 */
	private String middleName;

	/**
	 * Simplified constructor - requires only the mandatory student attributes
	 * 
	 * @param id The student's {@link #id ID number}
	 * @param lastName The student's {@link #lastName last name}
	 * @param firstName The student's {@link #firstName first name}
	 */
	public Student(int id, String lastName, String firstName) {
		this(id, lastName, "", "");
	}

	/**
	 * Complete constructor - includes optional fields
	 * 
	 * @param id The student's {@link #id ID number}
	 * @param lastName The student's {@link #lastName last name}
	 * @param firstName The student's {@link #firstName first name}
	 * @param middleName The student's {@link #middleName middle name}
	 */
	public Student(int id, String lastName, String firstName, String middleName) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		lastName = name;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String name) {
		middleName = name;
	}
}
