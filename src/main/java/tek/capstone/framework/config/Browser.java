package tek.capstone.framework.config;

import org.openqa.selenium.WebDriver;

public interface Browser {
	
	//We create one method and then implement this method in each of the browser classes
	WebDriver openBrowser(String url);

}
