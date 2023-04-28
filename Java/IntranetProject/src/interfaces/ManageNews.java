package interfaces;

import otherClasses.News;

public interface ManageNews {

	void updateNews(News news, String newsTitle, String newsText);

	void deleteNews(int newsIndex);

	void createNews(News news);
}
