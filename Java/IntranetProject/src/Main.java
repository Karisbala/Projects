import java.io.IOException;
import users.*;
import otherClasses.*;

public class Main {
	
	public static void run(User user) throws NumberFormatException, IOException {
		while (true) {
			System.out.println("\nPlease choose your action: ");
			user.showActions();
			int action = Integer.parseInt(Runner.input.readLine());
			if(Runner.run(user, action)) {
				break;
			}
		}
	}

	static void initialize() throws ClassNotFoundException, IOException {

		DataBase.getData();
	//	Admin admin = new Admin("Abzal", "Issayev");
	//	admin.addUser(admin);
	//	DataBase.saveData();
	}

	static void start() throws IOException {
		System.out.println("Hello welcome to our INTRANET System please login at first");
		
		System.out.println("Please enter the userId: ");
		int userId = Integer.parseInt(Runner.input.readLine());
		
		System.out.println("Please enter the password: ");
		String password = Runner.input.readLine();

		
		while (true) {
			
			if (User.login(userId, password)) {
				break;
			} else if (!User.login(userId, password)) {
				System.out.println("Incorrect userId or password.");
				System.exit(0);
			}

		}

		User user = DataBase.users.get(userId);
		System.out.println("Welcome " + user.getFirstName() + "!");
		if (user instanceof Student) {
			run(DataBase.students.get(userId));
		} else if (user instanceof Manager) {
			run(DataBase.managers.get(userId));
		} else if (user instanceof Admin) {
			run(DataBase.admins.get(userId));
		} else if (user instanceof Teacher) {
			run(DataBase.teachers.get(userId));
		}

	}

	static void finish() throws IOException {
		DataBase.saveData();
		System.out.println("Goodbye!");
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		initialize();
		start();
		finish();
	}

}
