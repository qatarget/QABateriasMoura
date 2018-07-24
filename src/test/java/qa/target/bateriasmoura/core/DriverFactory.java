package qa.target.bateriasmoura.core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory {
	
	private static WebDriver driver;

    public static WebDriver GetDriver()
    {
        if (driver == null)
        	
            driver = new ChromeDriver();          

        return driver;
    }

    
    public static void KillDriver()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }

}
