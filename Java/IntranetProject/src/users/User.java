package users;

import java.io.Serializable;
import otherClasses.DataBase;
import java.util.Objects;
import java.util.Vector;

public class User implements Serializable {

	private static final long serialVersionUID = 1750137703248334457L;
	private Vector<String> actions = new Vector<String>();

	private String firstName, lastName;
	private String password = "123456";

	private int userId;

	{
		this.userId = 1000000 + DataBase.users.size();
		this.getActions().add("Quit."); //1
		this.getActions().add("Change Password."); //2
		this.getActions().add("News."); //3
	}

	public User() {

	}

	public User(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPassword(password);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, userId, lastName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && userId == other.userId && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "ID: " + this.getId() + " Full name: " + this.getLastName() + " " + this.getFirstName();
	}
	
	public boolean changePassword(String oldPassword, String newPassword) {
		if(this.getPassword().equals(oldPassword)) {
			this.setPassword(newPassword);
			return true;
		}
		return false;
	}
	
	static public boolean login(int userId, String password) {
		if(DataBase.users.containsKey(userId)) {
			if(DataBase.users.get(userId).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public void showActions() {
		int actionCnt = 1;
		for (String action: actions) {
			System.out.println("[" + actionCnt + "] " + action);
			actionCnt++;
		}
	}

	public Vector<String> getActions() {
		return actions;
	}

	public void setActions(Vector<String> actions) {
		this.actions = actions;
	}	
}
