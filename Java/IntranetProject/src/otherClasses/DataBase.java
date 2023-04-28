package otherClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import users.Admin;
import users.Manager;
import users.Student;
import users.Teacher;
import users.User;

public class DataBase {
	public static HashMap<Integer, User> users;
	public static HashMap<Integer, Manager> managers; 
	public static HashMap<Integer, Student> students;
	public static HashMap<Integer, Course> courses;
	public static HashMap<Integer, Teacher> teachers;
	public static HashMap<Integer, Admin> admins;
	public static HashMap<Integer, News> news;

	public static int getNumberOfUsers() {
		return users.size();
	}

	public static void getData() throws ClassNotFoundException, IOException {
		courses = desCourses();
		managers = desManagers();
		teachers = desTeachers();
		admins = desAdmins();
		students = desStudents();
		users = desUsers();
		news = desNews();
	}

	public static void saveData() throws IOException {
		serCourses(courses);
		serManagers(managers);
		serTeachers(teachers);
		serAdmins(admins);
		serStudents(students);
		serUsers(users);
		serNews(news);
	}

	// Serializing News data
	public static void serNews(HashMap<Integer, News> news) throws IOException {
		try {
			FileOutputStream fos2 = new FileOutputStream("News.ser");
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(news);
			fos2.close();
			oos2.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error In serializing News");
		}
	}

	// Deserializing News data
	public static HashMap<Integer, News> desNews() throws IOException, ClassNotFoundException {
		try {
			FileInputStream fis2 = new FileInputStream("News.ser");
			ObjectInputStream oin2 = new ObjectInputStream(fis2);
			HashMap<Integer, News> news = (HashMap<Integer, News>) oin2.readObject();
			oin2.close();
			fis2.close();
			return news;
		} catch (FileNotFoundException e) {
			System.out.println("Error In deserializing News");
			return new HashMap<Integer, News>();
		}

	}

	// Serializing Users data
	public static void serUsers(HashMap<Integer, User> users) throws IOException {
		try {
			FileOutputStream fos2 = new FileOutputStream("Users.ser");
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(users);
			fos2.close();
			oos2.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error In serializing Users");
		}
	}

	// Deserializing Users data
	public static HashMap<Integer, User> desUsers() throws IOException, ClassNotFoundException {
		try {
			FileInputStream fis2 = new FileInputStream("Users.ser");
			ObjectInputStream oin2 = new ObjectInputStream(fis2);
			HashMap<Integer, User> users = (HashMap<Integer, User>) oin2.readObject();
			oin2.close();
			fis2.close();
			return users;
		} catch (FileNotFoundException e) {
			System.out.println("Error In deserializing Users");
			return new HashMap<Integer, User>();
		}

	}

	// Serializing Students data
	public static void serStudents(HashMap<Integer, Student> students) throws IOException {
		try {
			FileOutputStream fos2 = new FileOutputStream("Students.ser");
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(students);
			fos2.close();
			oos2.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error In serializing Student");
		}
	}

	// Deserializing Students data
	public static HashMap<Integer, Student> desStudents() throws IOException, ClassNotFoundException {
		try {
			FileInputStream fis2 = new FileInputStream("Students.ser");
			ObjectInputStream oin2 = new ObjectInputStream(fis2);
			HashMap<Integer, Student> students = (HashMap<Integer, Student>) oin2.readObject();
			oin2.close();
			fis2.close();
			return students;
		} catch (FileNotFoundException e) {
			System.out.println("Error In deserializing Students");
			return new HashMap<Integer, Student>();
		}

	}

	// Serializing Teachers data
	public static void serTeachers(HashMap<Integer, Teacher> teachers) throws IOException {
		try {
			FileOutputStream fos2 = new FileOutputStream("Teachers.ser");
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(teachers);
			fos2.close();
			oos2.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error In serializing Teachers");
		}
	}

	// Deserializing Teachers data
	public static HashMap<Integer, Teacher> desTeachers() throws IOException, ClassNotFoundException {
		try {
			FileInputStream fis2 = new FileInputStream("Teachers.ser");
			ObjectInputStream oin2 = new ObjectInputStream(fis2);
			HashMap<Integer, Teacher> teachers = (HashMap<Integer, Teacher>) oin2.readObject();
			oin2.close();
			fis2.close();
			return teachers;
		} catch (FileNotFoundException e) {
			System.out.println("Error In deserializing Teachers");
			return new HashMap<Integer, Teacher>();
		}
	}

	// Serializing Managers data
	public static void serManagers(HashMap<Integer, Manager> managers) throws IOException {
		try {
			FileOutputStream fos2 = new FileOutputStream("Managers.ser");
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(managers);
			fos2.close();
			oos2.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error In serializing Managers");
		}
	}

	// Deserializing Managers data
	public static HashMap<Integer, Manager> desManagers() throws IOException, ClassNotFoundException {
		try {
			FileInputStream fis2 = new FileInputStream("Managers.ser");
			ObjectInputStream oin2 = new ObjectInputStream(fis2);
			HashMap<Integer, Manager> managers = (HashMap<Integer, Manager>) oin2.readObject();
			oin2.close();
			fis2.close();
			return managers;
		} catch (FileNotFoundException e) {
			System.out.println("Error In deserializing Managers");
			return new HashMap<Integer, Manager>();
		}

	}

	// Serializing Admins data
	public static void serAdmins(HashMap<Integer, Admin> admins) throws IOException {
		try {
			FileOutputStream fos2 = new FileOutputStream("Admins.ser");
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(admins);
			fos2.close();
			oos2.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error In serializing Admin");
		}
	}

	// Deserializing Admins data
	public static HashMap<Integer, Admin> desAdmins() throws IOException, ClassNotFoundException {
		try {
			FileInputStream fis2 = new FileInputStream("Admins.ser");
			ObjectInputStream oin2 = new ObjectInputStream(fis2);
			HashMap<Integer, Admin> admins = (HashMap<Integer, Admin>) oin2.readObject();
			oin2.close();
			fis2.close();
			return admins;
		} catch (FileNotFoundException e) {
			System.out.println("Error In deserializing Admin");
			return new HashMap<Integer, Admin>();
		}
	}

	// Serializing Courses data
	public static void serCourses(HashMap<Integer, Course> courses) throws IOException {
		try {
			FileOutputStream fos2 = new FileOutputStream("Courses.ser");
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(courses);
			fos2.close();
			oos2.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error In serializing Course");
		}
	}

	// Deserializing News data
	public static HashMap<Integer, Course> desCourses() throws IOException, ClassNotFoundException {
		try {
			FileInputStream fis2 = new FileInputStream("Courses.ser");
			ObjectInputStream oin2 = new ObjectInputStream(fis2);
			HashMap<Integer, Course> courses = (HashMap<Integer, Course>) oin2.readObject();
			oin2.close();
			fis2.close();
			return courses;
		} catch (FileNotFoundException e) {
			System.out.println("Error In deserializing Courses");
			return new HashMap<Integer, Course>();
		}

	}

}
