package otherClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import enums.Degree;
import enums.Faculty;
import users.Admin;
import users.Manager;
import users.Student;
import users.Teacher;

public class UserFactory {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void createUser(Admin admin) throws IOException {
		System.out.println("Please enter type of the User (Student, Admin, Teacher, Manager):");
		String typeOfTheUser = input.readLine();
		System.out.println("Please enter First Name of the User:");
		String firstName = input.readLine();
		System.out.println("Please enter Last Name of the User:");
		String lastName = input.readLine();

		if (typeOfTheUser.equals("Student")) {
			System.out.println("Please enter Faculty of Student (just acronym, i.e. SITE):");
			String faculty = input.readLine();
			Faculty facultyEnum = Faculty.valueOf(faculty);
			System.out.println("Please enter Year Of Study of Student:");
			int yearOfStudy = Integer.parseInt(input.readLine());
			System.out.println("Please enter Degree of Student (BACHELOR, MASTER, PHD):");
			String degree = input.readLine();
			Degree degreeEnum = Degree.valueOf(degree);
			Student student = new Student(firstName, lastName, facultyEnum, yearOfStudy, degreeEnum);
			admin.addUser(student);
		} else if (typeOfTheUser.equals("Admin")) {
			Admin newAdmin = new Admin(firstName, lastName);
			admin.addUser(newAdmin);
		} else if (typeOfTheUser.equals("Teacher")) {
			Teacher teacher = new Teacher(firstName, lastName);
			admin.addUser(teacher);
		} else if (typeOfTheUser.equals("Manager")) {
			Manager manager = new Manager(firstName, lastName);
			admin.addUser(manager);
		}
	}
}
