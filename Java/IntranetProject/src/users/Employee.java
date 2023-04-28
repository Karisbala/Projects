package users;
import interfaces.SendMessageToEmployee;

public abstract class Employee extends User implements SendMessageToEmployee {
	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName) {
		super(firstName, lastName);
	}


}
