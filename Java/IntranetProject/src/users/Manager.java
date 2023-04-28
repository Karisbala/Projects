package users;

import enums.ManagerType;
import interfaces.ManageNews;
import otherClasses.Course;
import otherClasses.DataBase;
import otherClasses.News;

public class Manager extends Employee implements ManageNews {

	private ManagerType managerType;

	{
		this.getActions().add("Add Course for Registration."); // 4
		this.getActions().add("Manage News."); // 5
		this.getActions().add("View Students and/or Teachers."); // 6
		this.getActions().add("View Requests From Employees."); // 7
	}

	public Manager() {

	}

	public Manager(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public String getStatReportOnPerformance(Student student) {
		// TODO implement me
		return "";
	}

	public static boolean approveRegistration(Student student, Course course) {
		if(course.isFull()) {
			return false;
		}
		if(student.getTotalCredits() <= 0) {
			return false;
		}
		return true;
	}

	public void addCourseForRegistration(Course course) {
		DataBase.courses.put(course.getCourseId(), course);
	}

	@Override
	public void sendMessageTo(Employee employee, String message) {
		// TODO Auto-generated method stub
		
	}

	public void createNews(News news) {
		DataBase.news.put(news.getNewsId(), news);
	}

	@Override
	public void deleteNews(int newsIndex) {
		DataBase.news.remove(newsIndex);		
	}

	@Override
	public void updateNews(News news, String newsTitle, String newsText) {
		news.setTitle(newsTitle);
		news.setText(newsText);
	}
	
}
