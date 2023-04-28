package users;

import java.util.HashMap;
import java.util.Vector;

import otherClasses.DataBase;

public class Admin extends Employee {

	private static HashMap<User, Vector<String>> listOfUserActions;
	
	{
		this.getActions().add("Add User."); //4
		this.getActions().add("Delete User."); //5
		this.getActions().add("Update User."); //6
		this.getActions().add("See Log File Of User Actions."); //7
		this.getActions().add("Show List of Users."); //8
	}

	public Admin() {

	}
	
	public Admin(String firstName, String lastName) {
		super(firstName, lastName);
		this.setPassword("adminPass");
	}

	public void addUser(User user) {
		DataBase.users.put(user.getId(), user);
		if (user instanceof Student) {
			Student s = (Student) user;
			DataBase.students.put(user.getId(), s);
		} else if (user instanceof Manager) {
			Manager manager = (Manager) user;
			DataBase.managers.put(user.getId(), manager);
		} else if (user instanceof Admin) {
			Admin admin = (Admin) user;
			DataBase.admins.put(user.getId(), admin);
		} else if (user instanceof Teacher) {
			Teacher teacher = (Teacher) user;
			DataBase.teachers.put(user.getId(), teacher);
		}
	}

	public void removeUser(int userId) {
		DataBase.users.put(userId, null);
		DataBase.students.remove(userId);
		DataBase.teachers.remove(userId);
		DataBase.managers.remove(userId);
		DataBase.admins.remove(userId);
	}

	public void updateUser(int userId) {

	}
	/*
	static public void trackUserAction(User user, String action) {
		Vector<String> listOfActions = new Vector<String>();
		listOfActions.add(action);
		listOfUserActions.put(user, listOfActions);
	}
	*/
	@Override
	public void sendMessageTo(Employee employee, String message) {
		// TODO Auto-generated method stub

	}

}
