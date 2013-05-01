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

	/**
	 * Adds the provided {@link STAClass} to the provided {@link Teacher} and sets the class's teacherID to that of the
	 * provided teacher. The class is also removed from its old teacher's class list.
	 * 
	 * @param c One of the classes contained in the {@link #classes class directory}
	 * @param t One of the teachers contained in the {@link #teachers teacher directory}
	 * @return 'true' iff the teacher and class objects were successfully updated
	 */
	public boolean addClassToTeacher(STAClass c, Teacher t) {
		try {
			teachers.get(c.getTeacherID()).removeClass(c.getName());
		} catch (NullPointerException e) { }
		c.setTeacherID(t.getID());
		return t.addClass(c);
	}

	/**
	 * Removes the provided {@link STAClass} from the provided {@link Teacher} and sets the class's teacherID to -1,
	 * signifying no teacher.
	 * 
	 * @param c One of the classes contained in the {@link #classes class directory}
	 * @param t One of the teachers contained in the {@link #teachers teacher directory}
	 * @return 'true' iff the teacher and class objects were successfully updated
	 */
	public boolean removeClassFromTeacher(STAClass c, Teacher t) {
		boolean removed = t.removeClass(c);
		if (!removed)
			return false;
		c.setTeacherID(-1);
		return true;
	}

	/**
	 * Adds the provided {@link Student} to the provided {@link STAClass} and vice versa
	 * 
	 * @param s One of the students contained in the {@link #students student directory}
	 * @param c One of the classes contained in the {@link #classes class directory}
	 * @return 'true' iff the student and class objects were successfully updated
	 */
	public boolean addStudentToClass(Student s, STAClass c) {
		boolean a = s.addClass(c);
		boolean b = c.addStudent(s);
		return a && b;
	}


	/**
	 * Removes the provided {@link Student} from the provided {@link STAClass} and vice versa
	 * 
	 * @param s One of the students contained in the {@link #students student directory}
	 * @param c One of the classes contained in the {@link #classes class directory}
	 * @return 'true' iff the student and class objects were successfully updated
	 */
	public boolean removeStudentFromClass(Student s, STAClass c) {
		boolean a = s.removeClass(c);
		boolean b = c.removeStudent(s);
		return a && b;
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
