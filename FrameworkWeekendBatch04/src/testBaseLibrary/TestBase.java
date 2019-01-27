package testBaseLibrary;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	public WebDriver driver;
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	String log4jPath = "Log4jProperties";
	

	public void testIntializer(String browser, String url)
	{
		PropertyConfigurator.configure(log4jPath);
		log.info("Launching "+browser+ " browser");
		launchBrowser(browser);
		log.info("Navigating to the url: "+url);
		getURL(url);
		
	}
	
	public void launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			//To launch Chrome Browser
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//To Launch Firefox Browser
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void getURL(String url)
	{
		driver.get(url);
	}
	
	public void closeBrowser()
	{
		log.info("Closing the browser...");
		driver.close();
	}
	
	public void quitBrowser()
	{
		log.info("Quit the browser...");
		driver.quit();
	}
}
