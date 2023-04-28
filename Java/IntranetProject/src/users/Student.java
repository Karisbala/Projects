package users;
import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import enums.Degree;
import enums.Faculty;
import otherClasses.*;

public class Student extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Vector<Course> registeredCourses = new Vector<Course>();;
	private HashMap<Course, Attendance> attendanceForCourse = new HashMap <Course, Attendance>();

	private StudentOrganization studOrg;
	private Faculty faculty;
	private int yearOfStudy, totalCredits = 21;
	private Degree degree;
	private double gpa;
	
	{
		this.getActions().add("My Courses."); //4
		this.getActions().add("Attestation."); //5
		this.getActions().add("Transcript."); //6
		this.getActions().add("Registration for Course."); //7
		this.getActions().add("Rate Teachers."); //8
	}
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, Faculty faculty, int yearOfStudy, Degree degree) {
		super(firstName, lastName);
		this.setFaculty(faculty);
		this.setYearOfStudy(yearOfStudy);
		this.setDegree(degree);
	}

	public void addToStudenOrg(StudentOrganization studOrg) {
		this.setStudOrg(studOrg);
	}
	
	public Vector<Course> getRegisteredCourses() {
		return registeredCourses;
	}

	public StudentOrganization getStudOrg() {
		return studOrg;
	}

	public void setStudOrg(StudentOrganization studOrg) {
		this.studOrg = studOrg;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public HashMap<Course, Attendance> getAttendanceForCourse() {
		return attendanceForCourse;
	}

	public void setAttendanceForCourse(Course course) {
		this.attendanceForCourse.get(course).setPresent();
	}

	public void getAttestation(int courseId) {
		System.out.println(DataBase.courses.get(courseId).getCourseName() + ": " + DataBase.courses.get(courseId).getStudentsMarks().get(this));
	}

	public boolean registerForCourse(Course course) {
		if(Manager.approveRegistration(this, course)) {
			this.setTotalCredits(this.getTotalCredits() - course.getCredits());
			this.getRegisteredCourses().add(course);
			course.addStudent(this);
			return true;
		}
		return false;
	}
	
	public boolean isEligibleForFinal(Course course) {
		if(course.getStudentsMarks().get(this.getId()).getTotalMark() >= 30) {
			if(this.getAttendanceForCourse().containsKey(course)) {
				if(this.getAttendanceForCourse().get(course).getNumberOfPresents() >= course.getCredits() * 12) {
					return true;
				}
				else {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public void rateTeacher(Teacher teacher, int rating) {
		teacher.setRating(rating);
	}
}
