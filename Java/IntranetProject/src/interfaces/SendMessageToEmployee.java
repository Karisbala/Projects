package interfaces;
import users.Employee;

public interface SendMessageToEmployee {
	public abstract void sendMessageTo(Employee employee, String message);

}
