package otherClasses;

import java.io.Serializable;
import java.util.Map;

public class News implements Serializable {
	
	private int newsId, newsCnt;
	private String title;
	private String text;
	
	{
		this.newsId = newsCnt++;
	}
	
	public News() {
		
	}
	
	public News(String title, String text) {
		this.setTitle(title);
		this.setText(text);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public int getNewsId() {
		return newsId;
	}

	public static void viewNews() {
		for(Map.Entry<Integer, News> entry: DataBase.news.entrySet()) {
			System.out.println(entry.getKey() + ") " + entry.getValue());
		}
	}
	
	public String toString() {
		return this.getTitle() + "\n" + this.getText();
	}

}
