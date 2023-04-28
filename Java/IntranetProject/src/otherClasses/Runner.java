package otherClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Vector;

import enums.SemesterPeriod;
import enums.TypeOfTheCourse;
import users.Admin;
import users.Manager;
import users.Student;
import users.Teacher;
import users.User;

public class Runner {
	public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	private static void changePass(User user) throws IOException {
		System.out.println("Please Enter old Password");
		String oldPassword = input.readLine();
		System.out.println("Please Enter new Password");
		String newPassword = input.readLine();
		if (user.changePassword(oldPassword, newPassword))
			System.out.println("Password changed");
		else {
			System.out.println("Incorrect old password");
		}
	}

	public static boolean run(User user, int action) throws IOException {
		System.out.println("Action " + user.getActions().elementAt(action - 1));
		if (action == 1) {
			return true;
		} else if (action == 2) {
			changePass(user);
		} else if (action == 3) {
			News.viewNews();
		}
		if (user instanceof Student) {
			Student student = (Student) user;
			runStudent(student, action);
		} else if (user instanceof Manager) {
			Manager manager = (Manager) user;
			runManager(manager, action);
		} else if (user instanceof Admin) {
			Admin admin = (Admin) user;
			runAdmin(admin, action);
		} else if (user instanceof Teacher) {
			Teacher teacher = (Teacher) user;
			runTeacher(teacher, action);
		}
		return false;
	}

	public static void runStudent(Student student, int action) throws NumberFormatException, IOException {
		try {
			if (action == 4) {
				System.out.println("List of Registered Courses:");
				for(Course course: student.getRegisteredCourses()) {
					System.out.println(course);
				}
				
			} else if (action == 5) {
				System.out.println("Please Enter Course ID:");
				int courseId = Integer.parseInt(input.readLine());
				student.getAttestation(courseId);
			} else if (action == 6) {

			} else if (action == 7) {
				System.out.println("Please Enter Course ID:");
				int courseId = Integer.parseInt(input.readLine());
				Course course = DataBase.courses.get(courseId);
				if (student.registerForCourse(course)) {
					System.out.println("Successfully registered to " + course.getCourseName() + "!");
				}
			} else if (action == 8) {
				System.out.println("Please Enter Teacher ID:");
				int teacherId = Integer.parseInt(input.readLine());
				Teacher teacher = DataBase.teachers.get(teacherId);
				System.out.println("Give rating out of 10:");
				int rating = Integer.parseInt(input.readLine());
				student.rateTeacher(teacher, rating);
				System.out.println("You rated " + teacher.getFirstName() + " " + rating + " out of 10.");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Please Enter Correct Id!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void runManager(Manager manager, int action) throws IOException {
		if(action == 4) {
			System.out.println("Please Enter the Name of the Course:");
			String courseName = input.readLine();
			System.out.println("Please Enter the Teacher ID for the Course:");
			int teacherId = Integer.parseInt(input.readLine());
			System.out.println("Please Enter the Credits of the Course:");
			int credits = Integer.parseInt(input.readLine());
			System.out.println("Please Enter the Capacity of the Course:");
			int capacity = Integer.parseInt(input.readLine());
			System.out.println("Please Enter the Semester of the Course (AUTUMN, SPRING, SUMMER):");
			String semester = input.readLine();
			System.out.println("Please Enter the Type of the Course (MANDATORY, MAJOR, FREE):");
			String typeOfTheCourse = input.readLine();
			Course course = new Course(courseName, teacherId, credits, capacity, SemesterPeriod.valueOf(semester), TypeOfTheCourse.valueOf(typeOfTheCourse));
			manager.addCourseForRegistration(course);
			System.out.println("Course " + course.getCourseName() + " has been added for registration.");
		} else if(action == 5) {
			if(DataBase.news.isEmpty()) {
				System.out.println("There is no News yet. Do you want to Create one?(Yes/No)");
				String answer = input.readLine();
				if(answer.equals("Yes")) {
					System.out.println("Please Enter News Title:");
					String newsTitle = input.readLine();
					System.out.println("Please Enter News Text:");
					String newsText = input.readLine();
					News news = new News(newsTitle, newsText);
					manager.createNews(news);
					System.out.println("You have created a News!" + "\n" + news);
				}
			} else {
				return;
			}
			News.viewNews();
			System.out.println("Please Enter News ID:");
			int newsId = Integer.parseInt(input.readLine());
			News news = DataBase.news.get(newsId);
			System.out.println("Please Enter Operation on News(Update/Delete)");
			String operation = input.readLine();
			if(operation.equals("Update")) {
				System.out.println("Please Enter New Title:");
				String newTitle = input.readLine();
				System.out.println("Please Enter New Text:");
				String newText = input.readLine();
				manager.updateNews(news, newTitle, newText);
			} else if(operation.equals("Delete")){
				manager.deleteNews(newsId);
			}
		} else if(action == 6) {
			
		} else if(action == 7) {

		}
	}
	public static void runTeacher(Teacher teacher, int action) throws NumberFormatException, IOException {
		if (action == 4) {
			for (Course entry: DataBase.courses.values()) {
				if(entry.getTeacher() == teacher.getId()) {
					System.out.println(entry);
				}
			}
		} else if (action == 5) {
			
		} else if (action == 6) {
			for (Course entry: DataBase.courses.values()) {
				if(entry.getTeacher() == teacher.getId()) {
					entry.printAllStudents();
				}
			}
		} else if (action == 7) {
			System.out.println("Please Enter Course ID:");
			int courseId = Integer.parseInt(input.readLine());
			Course course = DataBase.courses.get(courseId);
			teacher.putMarks(course);
			System.out.println("Marks for " + course.getCourseName() + " course successfully given!");
		} else if (action == 6) {
			System.out.println(teacher.getRating());			
		}
	}

	public static void runAdmin(Admin admin, int action) throws NumberFormatException, IOException {
		if (action == 4) {
			UserFactory.createUser(admin);
			System.out.println("User added.");
		} else if (action == 5) {
			System.out.println("Please Enter User Id:");
			int userId = Integer.parseInt(input.readLine());
			admin.removeUser(userId);
			System.out.println("User removed.");
		} else if (action == 6) {
			System.out.println("Please Enter User Id:");
			int userId = Integer.parseInt(input.readLine());
			admin.updateUser(userId);
		} else if (action == 7) {
			
		} else if (action == 8) {
			for(Map.Entry<Integer, User> entry: DataBase.users.entrySet()) {
				System.out.println(entry.getValue());
			}
			
		}
	}

}
