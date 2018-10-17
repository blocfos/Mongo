package test.model;

public class BookSingleton {
	private static BookSingleton instance;
	public String title;
	private BookSingleton() {
		
	}
	public static synchronized BookSingleton getInstance() {
		if(instance == null) {
			instance = new BookSingleton();
		}
		return instance;
					
	}
	public static BookSingleton getInstance2() {
		synchronized (BookSingleton.class) {
			if(instance == null) {
				instance = new BookSingleton();
			}
		}
		
		return instance;
					
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
