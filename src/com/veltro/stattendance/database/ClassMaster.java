package com.veltro.stattendance.database;

import java.util.HashMap;

/**
 * The ClassMaster houses the directories of {@link #classes}, {@link #teachers}, and {@link #students} and provides
 * utility methods for integrating students and teachers with classes.
 * 
 * @author LinearLogic
 * @since 0.2.5
 */
public class ClassMaster {

	/**
	 * A directory of {@link STAStudent STA classes} indexed by {@link STAStudent#name}
	 */
	private HashMap<String, STAClass> classes;

	/**
	 * A directory of {@link Teacher upper school teachers} indexed by {@link Teacher#id} values
	 */
	private HashMap<Integer, Teacher> teachers;

	/**
	 * A directory of{@link Student upper school students} indexed by {@link Student#id} values
	 */
	private HashMap<Integer, Student> students;

	/**
	 * Constructor - initializes the directories of {@link #classes}, {@link #teachers}, and {@link #students}
	 */
	public ClassMaster() {
		classes = new HashMap<String, STAClass>();
		teachers = new HashMap<Integer, Teacher>();
		students = new HashMap<Integer, Student>();
	}

	public STAClass[] getClasses() {
		STAClass[] output = new STAClass[classes.size()];
		int index = 0;
		for (STAClass c : classes.values())
			output[index++] = c;
		return output;
	}

	public void addStudent(STAClass c) {
		classes.put(c.getName(), c);
	}

	public void removeClass(STAClass c) {
		classes.remove(c.getName());
	}

	public void removeClass(String className) {
		classes.remove(className);
	}

	public void clearClass() {
		classes.clear();
	}

	public Teacher[] getTeachers() {
		Teacher[] output = new Teacher[teachers.size()];
		int index = 0;
		for (Teacher t : teachers.values())
			output[index++] = t;
		return output;
	}

	public void addTeacher(Teacher t) {
		teachers.put(t.getID(), t);
	}

	public void removeTeacher(Teacher t) {
		teachers.remove(t.getID());
	}

	public void removeTeacher(int teacherID) {
		teachers.remove(teacherID);
	}

	public void clearTeachers() {
		teachers.clear();
	}

	public Student[] getstudents() {
		Student[] output = new Student[students.size()];
		int index = 0;
		for (Student s : students.values())
			output[index++] = s;
		return output;
	}

	public void addStudent(Student s) {
		students.put(s.getID(), s);
	}

	public void removeStudent(Student s) {
		students.remove(s.getID());
	}

	public void removeStudent(int studentID) {
		students.remove(studentID);
	}

	public void clearstudents() {
		students.clear();
	}
}
