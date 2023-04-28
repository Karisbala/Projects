package otherClasses;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import enums.Degree;
import enums.Faculty;
import enums.SemesterPeriod;
import enums.TypeOfTheCourse;

import users.Student;

public class Course implements Serializable {
	
	private String courseName;
	private int teacher;
	private int credits, capacity, courseId;
	private SemesterPeriod semester;
	private Faculty faculty;
	private TypeOfTheCourse typeOfTheCourse;
	
	private HashMap<Student, Mark> studentsMarks = new HashMap<Student, Mark>();

	{
		this.courseId = 2000000 + DataBase.courses.size();
	}
	
	public Course() {
		
	}

	public Course(String courseName, int teacherId, int credits, int capacity, SemesterPeriod semester, TypeOfTheCourse typeOfTheCourse) {
		this.setCourseName(courseName);
		this.setTeacher(teacherId);
		this.setCredits(credits);
		this.setCapacity(capacity);
		this.setSemester(semester);
		this.setTypeOfTheCourse(typeOfTheCourse);
	}

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getTeacher() {
		return this.teacher;
	}

	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public SemesterPeriod getSemester() {
		return semester;
	}

	public void setSemester(SemesterPeriod semester) {
		this.semester = semester;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public TypeOfTheCourse getTypeOfTheCourse() {
		return typeOfTheCourse;
	}

	public void setTypeOfTheCourse(TypeOfTheCourse typeOfTheCourse) {
		this.typeOfTheCourse = typeOfTheCourse;
	}

	public HashMap<Student, Mark> getStudentsMarks() {
		return studentsMarks;
	}

	public void changeMark(Student student, Mark mark) {
		if (!this.getStudentsMarks().containsKey(student)) {
			System.out.println("Student not found");
		}
		this.getStudentsMarks().replace(student, mark);
		System.out.println("Mark changed on student " + student.getFirstName());
	}
	
	public void addStudent(Student s) {
		this.getStudentsMarks().put(s, new Mark());
	}
	
	
	public static void viewCourses () {
		if (DataBase.courses.size() == 0) {
			System.out.println("Courses are not available.");
		}
		for (Map.Entry<Integer, Course> entry : DataBase.courses.entrySet()){
		    System.out.println(entry.getKey() + ". " + entry.getValue());
		}
	}
	
	public void printAllStudents() {
		if (this.getStudentsMarks().isEmpty()) {
			System.out.println("Course has 0 students");
		}
		for (Map.Entry<Student, Mark> entry : this.getStudentsMarks().entrySet()){
		    System.out.println(entry.getKey() + " Marks: " + entry.getValue());
		}
	}
	
	public boolean isFull() {
		if (capacity <= this.getStudentsMarks().entrySet().size())
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseName, credits, faculty, semester, typeOfTheCourse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseName, other.courseName) && credits == other.credits && faculty == other.faculty
				&& semester == other.semester && typeOfTheCourse == other.typeOfTheCourse;
	}

	public String toString() {
		return "Name of the course: " + this.getCourseName()
		+ " Credits: " + this.getCredits()
		+ " Capacity: " + this.getCapacity()
		+ " Semester: " + this.getSemester()
		+ " Type of the course: " + this.getTypeOfTheCourse();
	}
}
