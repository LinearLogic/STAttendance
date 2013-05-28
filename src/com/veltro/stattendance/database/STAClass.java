package com.veltro.stattendance.database;

import java.util.HashMap;

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
	 * A directory of attendance record entries (stored as strings formatted as shown below) indexed by student and
	 * (for each student) by date. Only instances of absence or tardiness are recorded; no entry should be made if a
	 * student is in class on time.
	 * <p>
	 * <b>Date string format:</b>
	 * "yyyy:mm:dd"
	 * <p>
	 * <b>Attendance record values:</b>
	 * Absences: excused = 0, unexcused = -1, senior cut = -2<br>
	 * Tardiness: the entry value is the number of minutes the student was late to class
	 */
	private HashMap<Integer, HashMap<String, Integer>> studentRecords;

	/**
	 * Constructor - initializes the class's {@link #name}, {@link #periods}, and {@link #teacherID} and instantiates
	 * an empty {@link #studentRecords list of student IDs}
	 * 
	 * @param name A string formatted like so: "department.className-sectionNumber"
	 * @param periods An array of the periods during which the class is held, represented as numerical byte values
	 * @param teacherID The identification number of the teacher of the class
	 */
	public STAClass(String name, byte[] periods, int teacherID) {
		this.name = name;
		this.periods = periods;
		this.teacherID = teacherID;
		studentRecords = new HashMap<Integer, HashMap<String, Integer>>();
	}

	/**
	 * This method is required in order to display the class in lists in the GUI.
	 * 
	 * @return The {@link #name} of the class
	 */
	@Override
	public String toString() {
		return name;
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
		int[] output = new int[studentRecords.size()];
		int index = 0;
		for (int id : studentRecords.keySet())
			output[index++] = id;
		return output;
	}

	public boolean containsStudent(Student student) {
		return studentRecords.containsKey(student.getID());
	}

	public boolean containsStudent(int studentID) {
		return studentRecords.containsKey(studentID);
	}

	public void addStudent(Student student) {
		studentRecords.put(student.getID(), new HashMap<String, Integer>());
	}

	public void addStudent(int studentID) {
		studentRecords.put(studentID, new HashMap<String, Integer>());
	}

	public void removeStudent(Student student) {
		studentRecords.remove(student.getID());
	}

	public void removeStudent(int studentID) {
		studentRecords.remove(studentID);
	}

	public void removeAllStudents() {
		studentRecords.clear();
	}

	public int getAttendanceRecord(Student s, String date) {
		return studentRecords.get(s.getID()).get(date);
	}

	public int getAttendanceRecord(int studentID, String date) {
		return studentRecords.get(studentID).get(date);
	}

	public HashMap<String, Integer> getAttendanceRecords(Student s) {
		return studentRecords.get(s.getID());
	}

	public HashMap<String, Integer> getAttendanceRecords(int studentID) {
		return studentRecords.get(studentID);
	}

	/**
	 * Adds an entry in the attendance records.  See the {@link #studentRecords} javadoc for info concerning the
	 * formatting of date strings and attendance record values.
	 * 
	 * @param s The student for whom an entry is being added
	 * @param date The date of the entry
	 * @param record The entry value
	 */
	public void addAttendanceRecord(Student s, String date, int record) {
		studentRecords.get(s.getID()).put(date, record);
	}

	/**
	 * Adds an entry in the attendance records.  See the {@link #studentRecords} javadoc for info concerning the
	 * formatting of date strings and attendance record values.
	 * 
	 * @param studentID The ID number of the student for whom an entry is being added
	 * @param date The date of the entry
	 * @param record The entry value
	 */
	public void addAttendanceRecord(int studentID, String date, int record) {
		studentRecords.get(studentID).put(date, record);
	}

	/**
	 * Removes the entry for the provided student and date (if any exists) from the attendance records. See the
	 * {@link #studentRecords} javadoc for info concerning the formatting of date strings.
	 * 
	 * @param s The student for whom an entry is being removed
	 * @param date The date of the entry
	 */
	public void removeAttendanceRecord(Student s, String date) {
		studentRecords.get(s.getID()).remove(date);
	}

	/**
	 * Removes the entry for the provided student and date (if any exists) from the attendance records. See the
	 * {@link #studentRecords} javadoc for info concerning the formatting of date strings.
	 * 
	 * @param studentID The ID number of the student for whom an entry is being removed
	 * @param date The date of the entry
	 */
	public void removeAttendanceRecord(int studentID, String date) {
		studentRecords.get(studentID).remove(date);
	}
}
