package database;

public class ApplicationService {

	
	private static volatile ApplicationService instance;

	public static ApplicationService getInstance() {
		if (instance == null) {
			synchronized (ApplicationService.class) {
				if (instance == null) {
					instance = new ApplicationService();
				}
			}
		}
		return instance;
	}


}
