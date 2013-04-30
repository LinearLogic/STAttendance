package com.veltro.stattendance.database;

import java.util.ArrayList;

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
	 * The student's form number stored as a byte value between 3 and 6. Freshmen are in Form 3, sophomores Form 4,
	 * juniors Form 5, and seniors Form 6.
	 */
	private byte formNumber;

	/**
	 * A list of the names of classes in which the student is enrolled
	 */
	private ArrayList<String> classes;

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

	public int getID() {
		return id;
	}

	public void setID(int id) {
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

	public byte getFormNumber() {
		return formNumber;
	}

	/**
	 * Sets the student's {@link #formNumber form number} to the provided byte value. Note that the form number must be
	 * between 3 (freshman) and 6 (senior), inclusive
	 * 
	 * @param number
	 */
	public void setFormNumber(byte number) {
		if (number < 3 || number > 6)
			return;
		formNumber = number;
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
