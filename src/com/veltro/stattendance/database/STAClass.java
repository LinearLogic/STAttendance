package com.veltro.stattendance.database;

import java.util.HashSet;

/**
 * Represents an upper school class at STA. Each class has a unique name string (containing title and section) and a
 * time window expressed using a byte array (with one or more numerical values--between 1 and 6, inclusive--
 * representing the period(s) during which the class meets). Each class also contains a name string, the integer ID of
 * the faculty member it is taught by and a list of the integer IDs of students enrolled in it.
 * 
 * @author LinearLogic
 * @since 0.2.3
 */
public class STAClass {

	/**
	 * The title of the class, formatted like so: "department.className-sectionNumber". HappyCal with Mr. Hansen, for
	 * instance, is registered as "MAT.calcAPH-1". This format is used by the EducationEdge backend.
	 */
	private String name;

	/**
	 * An array of values (between 1 and 6, inclusive) representative of periods in a school day during which the class
	 * meets.
	 */
	private byte[] periods;

	/**
	 * The unique identification number of the faculty member in charge of (teaching/proctoring) the class
	 */
	private int teacherID;

	/**
	 * A list containing the unique identification number for each student enrolled in the class.
	 */
	private HashSet<Integer> studentIDs = new HashSet<Integer>();

	/**
	 * Constructor - initializes the class's {@link #name}, {@link #periods}, and {@link #teacherID} and instantiates
	 * an empty {@link #studentIDs list of student IDs}
	 * 
	 * @param name A string formatted liek so: "department.className-sectionNumber"
	 * @param periods An array of the periods during which the class is held, represented as numerical byte values
	 * @param teacherID The identification number of the teacher of the class
	 */
	public STAClass(String name, byte[] periods, int teacherID) {
		this.name = name;
		this.periods = periods;
		this.teacherID = teacherID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPeriods() {
		return periods;
	}

	public void setPeriods(byte[] periods) {
		this.periods = periods;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int id) {
		teacherID = id;
	}

	public int[] getStudentIDs() {
		int[] output = new int[studentIDs.size()];
		int index = 0;
		for (int id : studentIDs)
			output[index++] = id;
		return output;
	}

	public boolean containsStudent(Student student) {
		return studentIDs.contains(student.getID());
	}

	public boolean containsStudent(int studentID) {
		return studentIDs.contains(studentID);
	}

	public boolean addStudent(Student student) {
		return studentIDs.add(student.getID());
	}

	public boolean addStudent(int studentID) {
		return studentIDs.add(studentID);
	}

	public boolean removeStudent(Student student) {
		return studentIDs.remove((Integer) student.getID());
	}

	public boolean removeStudent(int studentID) {
		return studentIDs.remove((Integer) studentID);
	}

	public void removeAllStudents() {
		studentIDs.clear();
	}
}
