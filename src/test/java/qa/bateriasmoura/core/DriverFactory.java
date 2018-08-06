package qa.bateriasmoura.core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {
	}

	@Before
	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "/home/target/driver/chromedriver"); //Usar no Linux
			//System.setProperty("webdriver.gecko.driver","/home/target/driver/geckodriver"); //Usar no Linux
			driver = new ChromeDriver();
			//driver = new FirefoxDriver();
		}

		return driver;
	}

	@After
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;

		}
	}
}