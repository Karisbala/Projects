package otherClasses;

public class Attendance {
	private int numberOfPresents;

	public Attendance() {

	}

	public Attendance(int numberOfApsents) {
		this.setPresent();
	}

	public int getNumberOfPresents() {
		return numberOfPresents;
	}

	public void setPresent() {
		this.numberOfPresents = this.getNumberOfPresents() + 1;
	}

}