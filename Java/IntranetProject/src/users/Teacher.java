package users;

import java.io.IOException;
import java.util.Vector;

import enums.Title;
import otherClasses.Course;
import otherClasses.DataBase;
import otherClasses.Runner;
import otherClasses.Mark;

public class Teacher extends Employee {

	private Title teacherTitle;
	private double rating = 0.0;

	public Vector<Integer> teacherRates = new Vector<Integer>();

	{
		this.getActions().add("My Courses."); //4
		this.getActions().add("Manage Course Files."); //5
		this.getActions().add("View Students."); //6
		this.getActions().add("Put Marks."); //7
		this.getActions().add("Show my Rating."); //7
	}

	public Teacher() {

	}

	public Teacher(String firstName, String lastName) {
		super(firstName, lastName);
		this.setTeacherTitle(teacherTitle);
	}

	public Title getTeacherTitle() {
		return teacherTitle;
	}

	public void setTeacherTitle(Title teacherTitle) {
		this.teacherTitle = teacherTitle;
	}

	public double getRating() {
		return rating;
	}

	public void addSyllabys(String courseName, String syllabusFile) {

	}

	public void putMarks(Course course) throws NumberFormatException, IOException {
		System.out.println("All students of " + course.getCourseName() +  " :");
		course.printAllStudents();
		System.out.println();
		while (true) {
			System.out.println("Please Enter ID of student (Enter 0 to exit):");
			int nextStudentId = Integer.parseInt(Runner.input.readLine());
			Student student = DataBase.students.get(nextStudentId);
			if (nextStudentId == 0) {
				break;
			}
			System.out.println("Attestation to grade:");
			System.out.println("Enter the Mark for the First Attestation:");
			int markForFirstAtt = Integer.parseInt(Runner.input.readLine());

			System.out.println("Enter the Mark for the Second Attestation:");
			int markForSecondAtt = Integer.parseInt(Runner.input.readLine());

			System.out.println("Enter the Mark for the Final Attestation:");
			int markForFinalAtt = Integer.parseInt(Runner.input.readLine());
			course.changeMark(student, new Mark(markForFirstAtt, markForSecondAtt, markForFinalAtt));		
		}
	}
	
	public void setRating(int rating) {
		this.rating += this.getRating();
	}

	@Override
	public void sendMessageTo(Employee employee, String message) {
		// TODO Auto-generated method stub

	}
}
